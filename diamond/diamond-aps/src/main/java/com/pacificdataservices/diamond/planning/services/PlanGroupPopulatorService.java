package com.pacificdataservices.diamond.planning.services;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.javautil.core.misc.Timer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.pacificdataservices.diamond.hibernate.SessionHelper;
import com.pacificdataservices.diamond.models.ApsItemGlobalSubst;
import com.pacificdataservices.diamond.models.ApsPlanGrp;
import com.pacificdataservices.diamond.models.IcItemCustSubst;
import com.pacificdataservices.diamond.models.IcItemMast;
import com.pacificdataservices.diamond.models.IcItemMastEquiv;

@Component
@Repository
@EnableAutoConfiguration
@Transactional
@EnableTransactionManagement

public class PlanGroupPopulatorService extends DiamondDataServices {
	Logger logger = LoggerFactory.getLogger(getClass());

	private HashMap<Integer, Integer> itemPlanGroup = new HashMap<Integer, Integer>();
	private HashMap<Integer, HashSet<Integer>> planGroupItems = new HashMap<Integer, HashSet<Integer>>();
	List<IcItemMastEquiv> icItemMastEquivs;
	List<IcItemCustSubst> icItemCustSubsts;
	List<ApsItemGlobalSubst> apsItemGlobalSubsts;

	Map<Integer, Set<Integer>> equivalentsByItem;
	Map<Integer, Set<Integer>> customerSubstituteByItem;
	Map<Integer, Set<Integer>> globalSubstituteByItem;
	Map<Integer, Set<Integer>> itemSetByItem = new HashMap<Integer, Set<Integer>>();
	Map<Integer, Set<Integer>> planGroupByGroup = new HashMap<Integer, Set<Integer>>();
	SessionHelper sessionHelper;
	Query iimQuery;

	int groupNbr = 1;

	private Map<String, BigInteger> stats;

	public void process() {
		logger.info("process begin");
		String hql = "FROM IcItemMast iim WHERE iim.itemNbr = :itemNbr";
		Session session = getSession();
		iimQuery = session.createQuery(hql);
		Timer t = new Timer();
		populate();
		logger.info("process() populate complete");
		infer();
		logger.info("process() infer complete");
		save();
		logger.info("process() save complete");
		populateNonGroup();
		logger.info("process() populateNonGroup complete");
		createStats();
		logger.info("process microseconds: %d", t.getElapsedMicros());
	}

	private void populateNonGroup() {
		
		String nonGroupSql = "insert into aps_plan_grp (plan_grp_nbr, item_nbr)\n" + 
				"select -1 * item_nbr, item_nbr\n" + 
				"from  (\n" + 
				"select item_nbr from ic_item_mast\n" + 
				"except\n" + 
				"select item_nbr from aps_plan_grp\n" + 
				") item_nbr_no_grp";
		Session session = getSession();
		Query q = session.createSQLQuery(nonGroupSql);
		q.executeUpdate();
		
	}

	@SuppressWarnings("unchecked")
	private void createStats() {
		stats = new HashMap<String, BigInteger>();
		Session session = getSession();
		String iimCount = "select count(*) item_mast_count from ic_item_mast";
		String planGroupRecordCount = "select count(*) plan_group_count from aps_plan_grp";
		String planGroupCount = "select count(*) from aps_plan_grp group by plan_grp_nbr";

		Query q = session.createSQLQuery(iimCount);
		List<BigInteger> results = q.list();
		BigInteger cnt = results.get(0);
		stats.put("item_mast_count", cnt);
		logger.warn("item_mast_count " + cnt);

		q = session.createSQLQuery(planGroupRecordCount);
		results = q.list();
		cnt = results.get(0);
		stats.put("plan_group_count", cnt);
		logger.warn("plan_group_count " + cnt);

//		q = session.createSQLQuery(planGroupCount);
//		results = q.list();
//		cnt = results.get(0);
//		stats.put("plan_groups", cnt);
//		logger.info("plan_groups " + cnt);
	}

	private void populate() {
		logger.info("populate()");
		Session session = getSession();
		sessionHelper = new SessionHelper(session);
		icItemMastEquivs = getAll("IcItemMastEquiv", session);
		icItemCustSubsts = getAll("IcItemCustSubst", session);
		apsItemGlobalSubsts = getAll("ApsItemGlobalSubst", session);
		logger.info("populate() end");
	}

	@SuppressWarnings("unchecked")
	protected void infer() {
		logger.info("infer() begin");
		equivalentsByItem = getEquivalentsByItem(icItemMastEquivs);
		customerSubstituteByItem = getIcItemCustSubstByItem(icItemCustSubsts);
		globalSubstituteByItem = getGlobalSubstitutesByItem(apsItemGlobalSubsts);
		logger.info("equivalentsByItem");
		populatePlanGroupByItem(equivalentsByItem);
		logger.info("customerSubstituteByItem");
		populatePlanGroupByItem(customerSubstituteByItem);
		logger.info("globalSubstitute");
		populatePlanGroupByItem(globalSubstituteByItem);
		logger.info("infer() end");
	}

	protected void populatePlanGroupByItem(Map<Integer, Set<Integer>> groupByItem) {
		for (Entry<Integer, Set<Integer>> e : groupByItem.entrySet()) {
			for (Integer equiv : e.getValue()) {
				add(e.getKey(), equiv);
			}
		}
	}

	void ensureIcItemMast(Integer itemNbr) {
		iimQuery.setInteger("itemNbr", itemNbr);
		List<IcItemMast> iims = iimQuery.list();
		if (iims.size() == 0) {
			throw new IllegalStateException("cannot  find item master for " + itemNbr);
		}
	}

	protected void save() {
		logger.info("save() begins");
		Session session = getSession();
		deleteAll("ApsPlanGrp", session);
		String hql = "FROM IcItemMast iim WHERE iim.itemNbr = :itemNbr";
		Query iimQuery = session.createQuery(hql);
		int itemCount = 0;
		for (Entry<Integer, HashSet<Integer>> e : planGroupItems.entrySet()) {
			Iterator<Integer> it = e.getValue().iterator();
			while (it.hasNext()) {
				Integer itemNbr = it.next();
				iimQuery.setInteger("itemNbr", itemNbr);
				List<IcItemMast> iims = iimQuery.list();
				if (iims.size() == 0) {
					throw new IllegalStateException("cannot  find item master for " + itemNbr);
				}
				ApsPlanGrp apg = new ApsPlanGrp();
				apg.setPlanGrpNbr(e.getKey());
				apg.setItemNbr(itemNbr);
				sessionHelper.save(apg);
				itemCount++;
			}
		}
		session.flush();
		logger.info("planning group size " + itemCount);
		logger.info("save() ends");
	}

	/**
	 * 
	 * @param icItemMastEquivs
	 * @return All the equivalent items for a given item keyed by item_nbr
	 */
	Map<Integer, Set<Integer>> getEquivalentsByItem(List<IcItemMastEquiv> icItemMastEquivs) {
		Map<Integer, Set<Integer>> byItemEquiv = new HashMap<Integer, Set<Integer>>();
		for (IcItemMastEquiv ime : icItemMastEquivs) {
			Integer itemNbr = ime.getId().getItemNbr();
			Integer equiv = ime.getId().getItemNbrEquiv();
			Set<Integer> equivForItem = byItemEquiv.get(itemNbr);
			if (equivForItem == null) {
				equivForItem = new HashSet<Integer>();
				byItemEquiv.put(itemNbr, equivForItem);
			}
			equivForItem.add(equiv);
		}
		return byItemEquiv;
	}

	Map<Integer, Set<Integer>> getIcItemCustSubstByItem(List<IcItemCustSubst> icItemCustSubsts) {
		Map<Integer, Set<Integer>> byItemEquiv = new HashMap<Integer, Set<Integer>>();
		for (IcItemCustSubst subst : icItemCustSubsts) {
			Integer itemNbr = subst.getId().getItemNbr();
			Integer equiv = subst.getId().getItemNbrSubst();
			Set<Integer> equivForItem = byItemEquiv.get(itemNbr);
			if (equivForItem == null) {
				equivForItem = new HashSet<Integer>();
				byItemEquiv.put(itemNbr, equivForItem);
			}
			equivForItem.add(equiv);
		}
		return byItemEquiv;
	}

	Map<Integer, Set<Integer>> getGlobalSubstitutesByItem(List<ApsItemGlobalSubst> substs) {
		Map<Integer, Set<Integer>> byItemEquiv = new HashMap<Integer, Set<Integer>>();
		for (ApsItemGlobalSubst subst : substs) {
			Integer itemNbr = subst.getId().getItemNbr();
			Integer equiv = subst.getId().getItemNbrSubst();
			Set<Integer> equivForItem = byItemEquiv.get(itemNbr);
			if (equivForItem == null) {
				equivForItem = new HashSet<Integer>();
				byItemEquiv.put(itemNbr, equivForItem);
			}
			equivForItem.add(equiv);
		}
		return byItemEquiv;
	}

	private void add(Integer item1, int item2) {
		ensureIcItemMast(item1);
		ensureIcItemMast(item2);
		Integer itemGroup = itemPlanGroup.get(item1);
		Integer equivGroup = itemPlanGroup.get(item2);
		if (itemGroup != null) {
			if (equivGroup != null) {
				if (itemGroup.intValue() != equivGroup.intValue()) {
					moveGroup(itemGroup, equivGroup);
				} else {
					addToGroup(equivGroup, item2);
				}
			}
		} else {
			if (equivGroup != null) {
				addToGroup(equivGroup, item1);
			} else {
				groupNbr++;
				addToGroup(groupNbr, item1);
				addToGroup(groupNbr, item2);
				itemPlanGroup.put(item1, groupNbr);
				itemPlanGroup.put(item2, groupNbr);
			}
		}
	}

	private synchronized void addToGroup(Integer groupNbr, Integer itemNbr) {
		HashSet<Integer> groupItems = planGroupItems.get(groupNbr);
		if (groupItems == null) {
			groupItems = new HashSet<Integer>();
		}
		groupItems.add(itemNbr);
		itemPlanGroup.put(itemNbr, groupNbr);
		planGroupItems.put(groupNbr, groupItems);
	}

	private synchronized void moveGroup(Integer destination, Integer source) {
		HashSet<Integer> itemsInSource = planGroupItems.get(source);
		HashSet<Integer> itemsInDest = planGroupItems.get(destination);
		if (itemsInDest == null) {
			throw new IllegalStateException("no destination group " + destination);
		}
		itemsInDest.addAll(itemsInSource);
		planGroupItems.remove(source);
		for (Integer sourceItem : itemsInSource) {
			itemPlanGroup.put(sourceItem, destination);
		}
	}

	public Map<String, BigInteger> getStats() {
		return stats;
	}

}
