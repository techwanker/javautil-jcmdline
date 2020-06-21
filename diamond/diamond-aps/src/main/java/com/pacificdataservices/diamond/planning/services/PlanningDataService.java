package com.pacificdataservices.diamond.planning.services;

import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;

//https://stackoverflow.com/questions/25063995/spring-boot-handle-to-hibernate-sessionfactory
//https://stackoverflow.com/questions/1657557/spring-hibernate-unknown-entity

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.transaction.Transactional;

import org.hibernate.Query;
//import org.hibernate.Query;
import org.hibernate.Session;
import org.javautil.core.misc.Timer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.pacificdataservices.diamond.models.ApsDmdFc;
import com.pacificdataservices.diamond.models.ApsDmdOo;
import com.pacificdataservices.diamond.models.ApsDmdSs;
import com.pacificdataservices.diamond.models.ApsDmdWo;
import com.pacificdataservices.diamond.models.ApsItemGlobalSubst;
import com.pacificdataservices.diamond.models.ApsPlanGrp;
import com.pacificdataservices.diamond.models.ApsSrcRule;
import com.pacificdataservices.diamond.models.ApsSrcRuleSet;
import com.pacificdataservices.diamond.models.IcItemCustSubst;
import com.pacificdataservices.diamond.models.IcItemMast;
import com.pacificdataservices.diamond.models.IcItemMastEquiv;
import com.pacificdataservices.diamond.models.IcMultipleCert;
import com.pacificdataservices.diamond.models.NaOrg;
import com.pacificdataservices.diamond.models.OeCustMast;
import com.pacificdataservices.diamond.models.OeCustMfr;
import com.pacificdataservices.diamond.models.OeItemHistFcstGrp;
import com.pacificdataservices.diamond.models.OeOrdDtlCert;
import com.pacificdataservices.diamond.models.OeOrdDtlHist;
import com.pacificdataservices.diamond.models.TmpItem;
import com.pacificdataservices.diamond.models.VqQteVw;
import com.pacificdataservices.diamond.planning.PlanningDataException;
import com.pacificdataservices.diamond.planning.StringBean;
import com.pacificdataservices.diamond.planning.container.ApsSrcRuleSetExt;
import com.pacificdataservices.diamond.planning.data.PlanningData;
import com.pacificdataservices.diamond.rules.CustomerItemManufacturerRules;

@Component
@Repository
@EnableAutoConfiguration
@Transactional
@EnableTransactionManagement
// TODO only get ApsSrcRuleSets used in demand
public class PlanningDataService extends DiamondDataServices {
	Logger logger = LoggerFactory.getLogger(getClass());
	private StringBean stringBean = new StringBean();
	private Logger analytics = LoggerFactory.getLogger("analytics");
	private PlanningData pd;
	//@Autowired
	/** 
	 * If true, sourcing rules not used are delete, but this is an 
	 * expensive operation and should be done another way should this be
	 * used in production TOOD
	 */
	private boolean trimSourcingRules = false;
	private File marshallFile;
	private Object itemNbrsByLotNbr;

	public void assertNotNull(Object o) {
		if (o == null) {
			throw new IllegalStateException("null found");
		}
	}

	public PlanningData getPlanningData(Collection<Integer> itemNumbers) {
		Session session = getSession();
		populateTmpItemSql(itemNumbers, session);
		PlanningData pd =  getPlanningData();
		pd.setItemNumbers(itemNumbers);
		return pd;
	}

	public PlanningData getPlanningDataForGroup(Integer planGrpNbr) {
		Session session = getSession();
		//Collection<Integer>itemNbrs = getItemNbrsInPlanGroup(planGrpNbr, session);
		analytics.debug("getPlanningData for group " + planGrpNbr);
		List<Integer> itemNumbers = getItemNumbersInPlanGrp(planGrpNbr);
		return getPlanningData(itemNumbers);
	}

	public PlanningData getPlanningDataForPartCd(String partCd) {
		Session session = getSession();
		String sql = "select item_nbr from ic_item_mast where item_cd = :item_cd";
		Query q = session.createSQLQuery(sql);
		q.setString("item_cd", partCd);
		List<Integer> qdata = q.list();
		if (qdata.size() == 0) {
			String message = String.format("Part Code %s returns no rows",partCd);
			logger.error(message);
			throw new IllegalArgumentException(message);
		}
		return getPlanningData(qdata);
	}
	public PlanningData getPlanningDataForItemNumber(int itemNbr) {
//		Session sesssion = getSession();
		int planGrp = getPlanGroupForItemNumber(itemNbr);
		return getPlanningDataForGroup(planGrp);
	}

	public List<Integer>  getItemNumbersInPlanGrp(int planGrp)  {
		Session session = getSession();
		String sql = "select item_nbr from aps_plan_grp where plan_grp_nbr = :plan_grp_nbr";
		Query q = session.createSQLQuery(sql);
		q.setInteger("plan_grp_nbr", planGrp);
		List<Integer> qdata = q.list();
		List<Integer> retval  = new ArrayList<Integer>();
		for (Integer rsn : qdata) {
			retval.add(rsn.intValue());
		}
		return retval;
	}

	public int getPlanGroupForItemNumber(int itemNbr) {
		Session session = getSession();
		String sql = "select plan_grpp_nbr from aps_plan_grp where item_nbr = :item_nbr";
		Query q = session.createSQLQuery(sql);
		q.setInteger("item_nbr", itemNbr);
		List<Integer> qdata = q.list();
		Integer response = qdata.get(0);
		return response.intValue();

	}

	@SuppressWarnings("unchecked")
	private PlanningData getPlanningData() {
		//logger.debug("\n***********\ngetting {}\n************",itemNumbers);
		pd = new PlanningData();
		Timer getPlanningDataTimer = new Timer();
		String logMessage = null;
		Session session = getSession();
		pd.setEffectiveDate(new Date());
		// Allocations
		pd.setApsAllocOnhandSss(getTableDataItemNbrRqst("ApsAllocOnhandSs", session));
		pd.setApsAllocOnhandFcs(getTableDataItemNbrRqst("ApsAllocOnhandFc", session));
		pd.setApsAllocOnhandOos(getTableDataItemNbrRqst("ApsAllocOnhandOo", session));
		pd.setApsAllocOnhandSss(getTableDataItemNbrRqst("ApsAllocOnhandSs", session));
		pd.setApsAllocOnhandWos(getTableDataItemNbrRqst("ApsAllocOnhandWo", session));
		pd.setApsAllocReplenFcs(getTableDataItemNbrRqst("ApsAllocReplenFc", session));
		pd.setApsAllocReplenOos(getTableDataItemNbrRqst("ApsAllocReplenOo", session));
		pd.setApsAllocReplenSss(getTableDataItemNbrRqst("ApsAllocReplenSs", session));
		pd.setApsAllocReplenWos(getTableDataItemNbrRqst("ApsAllocReplenWo", session));
		pd.setApsAllocWoFcs(getTableDataItemNbrRqst("ApsAllocWoFc", session));
		pd.setApsAllocWoOos(getTableDataItemNbrRqst("ApsAllocWoOo", session));
		pd.setApsAllocWoSss(getTableDataItemNbrRqst("ApsAllocWoSs", session));
		pd.setApsAllocWoWos(getTableDataItemNbrRqst("ApsAllocWoWo", session));

		pd.setApsAvailOnhands(getTableDataItemNbr("ApsAvailOnhand", session));
		pd.setApsAvailReplens(getTableDataItemNbr("ApsAvailReplen", session));
		pd.setApsAvailWos(getTableDataItemNbr("ApsAvailWo",session));

		pd.setApsDmdFcs(getTableDataItemNbrDmd("ApsDmdFc", session));
		pd.setApsDmdSss(getTableDataItemNbrDmd("ApsDmdSs", session));
		pd.setApsDmdWos(getTableDataItemNbrDmd("ApsDmdWo", session));
		List<ApsDmdOo> dmdOos = getTableDataItemNbrDmd("ApsDmdOo", session);
		pd.setApsDmdOos(dmdOos);

		pd.setApsSrcRuleSets(getAll("ApsSrcRuleSet",session));
		pd.setOeCustMfrs(getTableDataItemNbr("OeCustMfr",session));
		pd.setFcItemMasts(getTableDataItemNbr("FcItemMast",session));
		pd.setItemNbrsByLotNbr(getItemNbrsByLotNbr(getTableDataItemNbr("IcMultipleCert",session)));
		pd.setIcItemMastEquivs(getIcItemMastEquiv(session));
		pd.setIcItemCustsSubsts(getIcItemCustSubst(session));
		pd.setIcLotMasts(getTableDataItemNbr("IcLotMast",session));
		pd.setApsSrcRulePrimarys(getAll("ApsSrcRulePrimary",session));
		pd.setIcCertCds(getAll("IcCertCd",session));
		pd.setUtFacilities(getAll("UtFacility", session));
		// supplies
		pd.setApsSplyPools(getAll("ApsSplyPool",session));
		pd.setApsSplySubPools(getAll("ApsSplySubPool",session));
		pd.setOeOrdDtlCerts(getOeOrdDtlCerts(session));
		// substitutes
		pd.setApsItemGlobalSubsts(getApsItemGlobalSubsts(session));
		// item master
		logger.debug("about to fetch icItemMasts");
		pd.setIcItemMasts(getTableDataItemNbr("IcItemMast", session));
		logger.debug("icItemMasts.size() " + pd.getIcItemMasts().size());

		pd.setFcstGrps(getAll("FcstGrp",session));
		// TODO this should be a cached query
		List<ApsSrcRule> apsSrcRules = getAll("ApsSrcRule",session);
		pd.setApsSrcRules(apsSrcRules);
		List<ApsSrcRuleSet> sourceRuleSets = getAll("ApsSrcRuleSet",session);
		logger.debug("getting ApsSrcRules for ruleSet");
		pd.setApsSrcRuleSets(sourceRuleSets);
		pd.setApsSplySubPools(getAll("ApsSplySubPool",session));

		pd.setOeCustMasts(getCustomers(session));
		//
		Map<Integer, NaOrg> naOrgById = new TreeMap<>();
		Map<Integer, OeCustMast> oeCustMapById = pd.getOeCustMastById();
		for (OeCustMast cust : pd.getOeCustMasts()) {
			NaOrg org = cust.getNaOrg();
			org.getOrgCd(); // Force fetch 
			naOrgById.put(org.getOrgNbr(),org);
		}
		for (OeCustMfr custMfr : pd.getOeCustMfrs()) {
			NaOrg orgMfr = custMfr.getNaOrgMfr();
			orgMfr.getOrgCd(); // Force fetch 
			naOrgById.put(orgMfr.getOrgNbr(),orgMfr);

			NaOrg orgCust = custMfr.getOeCustMast().getNaOrg();
			orgCust.getOrgCd();
			naOrgById.put(orgCust.getOrgNbr(),orgCust);
			
			OeCustMast cust = custMfr.getOeCustMast();
			oeCustMapById.put(cust.getOrgNbrCust(),cust);
			
			custMfr.getIcItemMast().getItemCd(); // force read hibenerate
			
		}
		pd.setNaOrgById(naOrgById);
		long fetchTime = getPlanningDataTimer.getElapsedMicros();
		getOrgs();
		pd.buildMapsAndReferences();
		if (pd.getMissingOrgNbrs().size() > 0) {
			throw new PlanningDataException("missingOrgNbrs");
		}
		CustomerItemManufacturerRules cmr  = new CustomerItemManufacturerRules(pd.getOeCustMfrs());
		pd.setCustomerItemManufacturerRules(cmr);
		ArrayList<String> messages = pd.checkIntegrity();

		logMessage = String.format("***\ngetPlanningData fetch Micros %d totalMicros %d\n***",fetchTime, getPlanningDataTimer.getElapsedMicros());
		logger.info(logMessage);
		// TODO this could all be in planning results, not needed to do a pllan
		pd.setVqQteVws(getVqQteVws());
		pd.setOeOrdDtlHists(getOeOrdDtlHists());
		pd.setOeItemHistFcstGrps(getOeItemHistFcstGrps());
		int arddNext = getSequenceNumber(pd.getDemands().size(), "aps_result_dtl_dmd_seq");  // keep this very near the end for minimimal lock time.
		pd.setApsResultDtlDmdId(arddNext);
		pd.setOeItemHistFcstGrps(getOeItemHistFcstGrps());
		analytics.debug(logMessage);
		return pd;
	}


	private TreeMap<Integer,ArrayList<Integer>> getItemNbrsByLotNbr(List<IcMultipleCert> list) {
		TreeMap<Integer,ArrayList<Integer>> map = new TreeMap<Integer, ArrayList<Integer>>();
		for (IcMultipleCert imc : list)  {
			Integer lotNbr =  imc.getId().getLotNbr();
			ArrayList<Integer> itemNbrs = map.get(lotNbr);
			if (itemNbrs == null) {
				itemNbrs = new ArrayList<Integer>();
				map.put(lotNbr,itemNbrs);
			}
			itemNbrs.add(imc.getId().getItemNbr());
		}
		return map;
	}

	private List<OeItemHistFcstGrp> getOeItemHistFcstGrps() {
		logger.info("getOeItemHistFcstGrps items in tmp {}", itemsInTmpItem());
		String queryText = "from OeItemHistFcstGrp "
				+ "where item_nbr_rqst in (select itemNbr from TmpItem) "
				+ "order by fcst_grp, ord_dt_mm";
		@SuppressWarnings("unchecked")
		List<OeItemHistFcstGrp> retval =  getList("OeItemHistFcstGrp", queryText, getSession());
		return retval;
	}

	private List<OeOrdDtlHist> getOeOrdDtlHists() {
		String queryText = "from OeOrdDtlHist "
				+ "where item_nbr_rqst in (select itemNbr from TmpItem) "
				+ "or item_nbr_ord in (select itemNbr from TmpItem)";
		@SuppressWarnings("unchecked")
		List<OeOrdDtlHist> retval =  getList("OeOrdDtlHist", queryText, getSession());
		return retval;
	}

	private List<VqQteVw> getVqQteVws() {
		String queryText = "from VqQteVw where item_nbr_qte in (select itemNbr from TmpItem) order by org_nm, item_cd_qte, vq_qte_eff_dt,  qte_qty";
		@SuppressWarnings("unchecked")
		List<VqQteVw> retval =  getList("VqQteVw", queryText, getSession());
		return retval;
	}
	
	Set<Integer> itemsInTmpItem() {
		Query q = getSession().createQuery("from TmpItem");
		List<TmpItem> rows = q.list();
		Set<Integer> itemsInTmpItem = new HashSet<Integer>();
		for (TmpItem row : rows) {
			itemsInTmpItem.add(row.getItemNbr());
		}
		return itemsInTmpItem;
	}

	public static Set<Integer> populateTmpItemSql(Collection<Integer> itemNumbers, Session session) {
		//session.beginTransaction();
		Query q =session.createSQLQuery("delete from tmp_item");
		int count = q.executeUpdate();
		//logger.debug("deleted " + count + " from tmp_item");

		Query ins = session.createSQLQuery("insert into tmp_item (item_nbr) values (:item_nbr)");
		for (Integer itemNumber : itemNumbers)  {
			ins.setParameter("item_nbr", itemNumber);
			int rowCount = ins.executeUpdate();
		//	logger.info("Inserted " + itemNumber + " rows " + rowCount);
		}
		session.flush();
		// TODO nuke
		q = session.createSQLQuery("select count(*) cnt from tmp_item");  // TODO there is nothing here
		@SuppressWarnings("unchecked")
		List<BigInteger> results = q.list();
		BigInteger cnt= results.get(0);
		String message = "tmp_item row count = " + cnt;
		//logger.info("#items in tmp_item " + cnt);

		q = session.createQuery("from TmpItem");
		List<TmpItem> rows = q.list();
		Set<Integer> itemsInTmpItem = new HashSet<Integer>();
		for (TmpItem row : rows) {
			itemsInTmpItem.add(row.getItemNbr());
		}
		System.out.print(message);
		//logger.debug(message);
		if (itemsInTmpItem.size() != itemNumbers.size()) {
			String errmsg = "expected itemNbrs" + itemNumbers + " but got " + itemsInTmpItem;
		//	logger.error(errmsg);
			throw new IllegalStateException(errmsg);
		}

		return itemsInTmpItem;

	}



	@SuppressWarnings("unchecked")
	private List<ApsItemGlobalSubst> getApsItemGlobalSubsts(Session session) {
		String queryText = "from ApsItemGlobalSubst where " +
				"item_nbr in (select itemNbr from TmpItem) or "
				+ " item_nbr_subst in (select itemNbr from TmpItem)";
		return getList("ApsItemGlobalSubst", queryText, session);
	}

	private List<OeOrdDtlCert> getOeOrdDtlCerts(Session session) {
		String queryText = 
				"from OeOrdDtlCert "  
						+ "where oe_ord_dtl_nbr in ( \n" 
						+ "  select oeOrdDtlNbr "
						+ "  from OeOrdDtl "
						+ "  where item_nbr_rqst in (" 
						+ "     select itemNbr "
						+ "     from TmpItem" 
						+ "   )"
						+ ")";
		return getList("OeOrdDtlCert", queryText, session);


	}


	private List<ApsDmdOo> getApsDmdOo(Session session) {
		String queryText = "from ApsDmdOo)";
		Query query = session.createQuery(queryText);
		@SuppressWarnings("rawtypes")
		List result = query.list();
		return result;
	}

	@SuppressWarnings("unchecked")
	private List<IcItemCustSubst> getIcItemCustSubst(Session session) {
		String queryText = "from IcItemCustSubst where " + "item_nbr in (select itemNbr from TmpItem) or "
				+ " item_nbr_subst in (select itemNbr from TmpItem)";
		return getList("IcItemCustSubst", queryText, session);

	}

	@SuppressWarnings("unchecked")
	List<IcItemMastEquiv> getIcItemMastEquiv(Session session) {
		String queryText = "from IcItemMastEquiv where item_nbr in (select itemNbr from TmpItem)"
				+ "or item_nbr_equiv in (select itemNbr from TmpItem)";
		return getList("IcItemMastEquiv", queryText, session);
	}

	public Collection<Integer> getItemNbrsInPlanGroup(Integer planGrpNumber) {
		return getItemNbrsInPlanGroup(planGrpNumber,getSession());
	}

	public Collection<Integer> getItemNbrsInPlanGroup(Integer planGrpNbr, Session session) {
		List<ApsPlanGrp> planGroups;
		String queryText = "from ApsPlanGrp where planGrpNbr = :planGrpNbr";
		Query query = session.createQuery(queryText);
		query.setInteger("planGrpNbr", planGrpNbr);
		List<ApsPlanGrp> result = query.list();
		ArrayList<Integer> itemNbrs = new ArrayList<Integer>();
		int index = 0;
		for (ApsPlanGrp grp : result) {
			itemNbrs.add(grp.getItemNbr());
		}
		return itemNbrs;
	}

	/* TODO should  populate tmp_surrogate and select from there */
	Collection<OeCustMast> getCustomers(Session session) {
		String q = "from OeCustMast where "
				+ "org_nbr_cust in    ( select orgNbrCust from ApsDmdOo where itemNbrDmd in (select itemNbr from TmpItem)) "
				+ "or  orgNbrCust in (select orgNbrCust from ApsDmdFc where itemNbrDmd in (select itemNbr from TmpItem)) "
				+ "or orgNbrCust in (select orgNbrCust from ApsDmdSs where itemNbrDmd in (select itemNbr from TmpItem)) "
				+ "or orgNbrCust in (select orgNbrCust from ApsDmdWo where itemNbrDmd in (select itemNbr from TmpItem)) "
				+ ")";
		List<OeCustMast> apsDmdCusts =  getList("OeCustMast",q,session);


		HashMap<Integer,OeCustMast> custById = new HashMap<Integer,OeCustMast>();

		for (OeCustMast cust : apsDmdCusts) {
			logger.debug("putting customer: {}",cust.getOrgNbrCust());
			custById.put(cust.getOrgNbrCust(),cust);
		}

		logger.debug("**************** Customers *****************");
		for (OeCustMast ocm : custById.values()) {
			System.out.println("OrgNbrCust: " + ocm.getOrgNbrCust());
			logger.debug("orgNbrCust: {} " ,ocm.getOrgNbrCust());
		}
		return custById.values();
	}

//	Collection<OeCustMast> getCustomers(Session session) {
//		String q = "from OeCustMast where org_nbr_cust in ("
//				+ "select orgNbrCust from ApsDmdOo where itemNbrDmd in (select itemNbr from TmpItem))";
//		List<OeCustMast> apsDmdOoCusts =  getList("OeCustMast",q,session);
//
//		String p = "from OeCustMast where org_nbr_cust in ("
//				+ "select orgNbrCust from ApsDmdFc where itemNbrDmd in (select itemNbr from TmpItem))";
//		List<OeCustMast> apsDmdFcCusts =  getList("OeCustMast",p,session);
//
//		HashMap<Integer,OeCustMast> custById = new HashMap<Integer,OeCustMast>();
//
//		for (OeCustMast cust : apsDmdOoCusts) {
//			logger.debug("putting customer: {}",cust.getOrgNbrCust());
//			custById.put(cust.getOrgNbrCust(),cust);
//		}
//
//		for (OeCustMast cust : apsDmdFcCusts) {
//			System.out.println("putting customer for apsDmdFc: " + cust.getOrgNbrCust());
//			logger.debug("putting customer: {}",cust.getOrgNbrCust());
//			custById.put(cust.getOrgNbrCust(),cust);
//		}
//		logger.debug("**************** Customers *****************");
//		for (OeCustMast ocm : custById.values()) {
//			System.out.println("OrgNbrCust: " + ocm.getOrgNbrCust());
//			logger.debug("orgNbrCust: " + ocm.getOrgNbrCust());
//		}
//		return custById.values();
//	}

	public boolean isTrimSourcingRules() {
		return trimSourcingRules;
	}

	public void setTrimSourcingRules(boolean trimSourcingRules) {
		this.trimSourcingRules = trimSourcingRules;
	}

	public List<ApsSrcRuleSetExt> getAllApsSrcRuleSetExt() {
		List<ApsSrcRuleSetExt> retval = getAllSql(ApsSrcRuleSetExt.class, "select * from aps_src_rule_set", getSession());
		logger.debug("ApsSrcRuleSetExt size " + retval.size());
		return retval;
	}

	public void getOrgs() {
		for (ApsDmdOo apsDmdOo : pd.getApsDmdOos() ) {
			if (apsDmdOo.getOrgNbrMfrRqst() != null) {
				getNaOrg(apsDmdOo.getOrgNbrMfrRqst());
				getNaOrg(apsDmdOo.getOrgNbrCust());
			}
		}
		for (ApsDmdWo apsDmdWo : pd.getApsDmdWos() ) {
			if (apsDmdWo.getOrgNbrMfrRqst() != null) {
				getNaOrg(apsDmdWo.getOrgNbrMfrRqst());
				getNaOrg(apsDmdWo.getOrgNbrMfrRqst());
				getNaOrg(apsDmdWo.getOrgNbrCust());
			}
		}
		for (ApsDmdFc apsDmdFc : pd.getApsDmdFcs() ) {
			if (apsDmdFc.getOrgNbrMfrRqst() != null) {
				getNaOrg(apsDmdFc.getOrgNbrMfrRqst());
				getNaOrg(apsDmdFc.getOrgNbrMfrRqst());
				getNaOrg(apsDmdFc.getOrgNbrCust());
			}
		}
		for (ApsDmdSs apsDmdSs : pd.getApsDmdSss() ) {
			if (apsDmdSs.getOrgNbrMfrRqst() != null) {
				getNaOrg(apsDmdSs.getOrgNbrMfrRqst());
				getNaOrg(apsDmdSs.getOrgNbrMfrRqst());
				getNaOrg(apsDmdSs.getOrgNbrCust());
			}
		}
	}
	public NaOrg getNaOrg(Integer naOrgNbr) {
		Session session = getSession();
		Map<Integer, NaOrg> orgMap = pd.getNaOrgById();
		NaOrg retval = orgMap.get(naOrgNbr);
		if (retval == null) {
			String sql = "from NaOrg where org_nbr = :na_org_nbr";
			Query query = session.createQuery(sql);
			query.setInteger("na_org_nbr", naOrgNbr);
			List<NaOrg> naOrgs =  query.list();
			if (naOrgs.size() != 1) {
				throw new IllegalStateException("naOrgs " + naOrgs + " for " + naOrgNbr);
			}
			retval = naOrgs.get(0);
			orgMap.put(retval.getOrgNbr(),retval);
		}
		return retval;
	}
	
	@SuppressWarnings("unchecked")
	public int getSequenceNumber(int qty,String sequenceName) {  // TODO put all in one tabl3
		// TODO report stats
		
		// TODO for concurrency this should be done in a separate transaction
		Session session = getSession();
	    String qstr = "select nextval from " + sequenceName + " for update";
		Query q = session.createSQLQuery(qstr);
		List<Integer> qdata = q.list();
		Integer bd = qdata.get(0);
		int retval = bd.intValue();
	    
	    String ustr = "update " + sequenceName + " set nextval = nextval + :qty";
		Query u = session.createSQLQuery(ustr);
		u.setInteger("qty", qty);
		u.executeUpdate();
	    return retval;
	    
	}
	
	public void save(PlanningData pd) {
		Session session = getSession();
		for (IcItemMast iim :  pd.getIcItemMastsById().values()) {
		//	iim.setItemCd("item " + iim.getItemNbr());
			//iim.setItemNbr(0);
			logger.info("iim is itemNbr: {} itemCd:{}" , iim.getItemNbr(), iim.getItemCd());
			logger.info("iim is {}", iim.toString());
			session.saveOrUpdate(iim);
			session.flush(); // TODO big peformance hit -- remove
		}
		session.flush();
	}
	
	public void processMissingOrgs() {
		List<NaOrg> missing = getNaOrgs(pd.getMissingOrgNbrs().keySet());
		Map<Integer,NaOrg> map = pd.getNaOrgById();
		for (NaOrg naOrg : missing) {
			logger.debug("adding {} {}", naOrg.getOrgNbr(),naOrg);
			map.put(naOrg.getOrgNbr(),naOrg);
		}
	}
	
	List<NaOrg> getNaOrgs(Collection<Integer> orgNbrs) {
		List<NaOrg> retval = new ArrayList<NaOrg>();
		Session s = getSession();
		Query q = s.createQuery("from NaOrg where orgNbr = :orgNbr");
		for (Integer orgNbr : orgNbrs) {
			q.setInteger("orgNbr", orgNbr);
			List<NaOrg> one = q.list();
			retval.addAll(one);
		}
		return retval;
		
	}
}
