//package com.pacificdataservices.diamond.planning.services;
//
//import java.io.File;
//import java.math.BigDecimal;
//import java.sql.Connection;
//import java.util.ArrayList;
//import java.util.Arrays;
//
////https://stackoverflow.com/questions/25063995/spring-boot-handle-to-hibernate-sessionfactory
////https://stackoverflow.com/questions/1657557/spring-hibernate-unknown-entity
//
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import javax.transaction.Transactional;
//
//import org.hibernate.Query;
////import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.transform.Transformers;
//import org.javautil.util.Timer;
//import org.javautil.core.sql.SqlStatement;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import com.pacificdataservices.diamond.models.ApsDmdOo;
//import com.pacificdataservices.diamond.models.ApsItemGlobalSubst;
//import com.pacificdataservices.diamond.models.ApsPlanGrp;
//import com.pacificdataservices.diamond.models.ApsSrcRule;
//import com.pacificdataservices.diamond.models.ApsSrcRuleSet;
//import com.pacificdataservices.diamond.models.IcItemCustSubst;
//import com.pacificdataservices.diamond.models.IcItemMastEquiv;
//import com.pacificdataservices.diamond.models.OeCustMast;
//import com.pacificdataservices.diamond.models.OeOrdDtl;
//import com.pacificdataservices.diamond.models.OeOrdDtlCert;
//import com.pacificdataservices.diamond.models.TmpItem;
//import com.pacificdataservices.diamond.planning.PlanningData;
//import com.pacificdataservices.diamond.planning.StringBean;
//
//// TODO only get ApsSrcRuleSets used in demand
//public class PlanningDataJDBCService extends DiamondDataJDBCServices {
//
//	Logger logger = LoggerFactory.getLogger(getClass());
//	private StringBean stringBean = new StringBean();
//	private Logger analytics = LoggerFactory.getLogger("analytics");
//	private boolean trimSourcingRules = false;
//	private File marshallFile;
//
//	//@Autowired
//	//private SourcingRuleService sourcingRuleService;
//	/** 
//	 * If true, sourcing rules not used are delete, but this is an 
//	 * expensive operation and should be done another way should this be
//	 * used in production TOOD
//	 */
//	public PlanningDataJDBCService(Connection connection) {
//		super(connection);
//	}
//	
//	public void assertNotNull(Object o) {
//		if (o == null) {
//			throw new IllegalStateException("null found");
//		}
//	}
//	
//	
//	public PlanningData getPlanningData(int [] itemNumbers) {
//		
//		ArrayList<Integer> myItemNbrs = new ArrayList<Integer>(itemNumbers.length);
//		for (int itemNbr : itemNumbers) {
//			myItemNbrs.add(itemNbr);
//		}
//		return getPlanningData(myItemNbrs);
//	}
//	
//	public PlanningData getPlanningData(Integer [] itemNumbers) {
//		return getPlanningData(Arrays.asList(itemNumbers));
//	}
//
//	public PlanningData getPlanningData(Integer planGrpNbr) {
//		Collection<Integer>itemNbrs = getItemNbrsInPlanGroup(planGrpNbr, session);
//		return getPlanningData(itemNbrs);
//	}
//	
//	@SuppressWarnings("unchecked")
//	public PlanningData getPlanningData(Collection<Integer> itemNumbers) {
//		logger.debug("\n***********\ngetting {}\n************",itemNumbers);
//		PlanningData pd = new PlanningData();
//		Timer getPlanningDataTimer = new Timer();
//		String logMessage = null;
//		Session session = getSession();
//		
//		analytics.debug("getPlanningData for " + itemNumbers.toString());
//		populateTmpItemJpa(itemNumbers, session);
//		// Allocations
//		pd.setApsAllocOnhandSss(getTableDataItemNbrRqst("ApsAllocOnhandSs", session));
//		pd.setApsAllocOnhandFcs(getTableDataItemNbrRqst("ApsAllocOnhandFc", session));
//		pd.setApsAllocOnhandOos(getTableDataItemNbrRqst("ApsAllocOnhandOo", session));
//		pd.setApsAllocOnhandSss(getTableDataItemNbrRqst("ApsAllocOnhandSs", session));
//		pd.setApsAllocOnhandWos(getTableDataItemNbrRqst("ApsAllocOnhandWo", session));
//		pd.setApsAllocReplenFcs(getTableDataItemNbrRqst("ApsAllocReplenFc", session));
//		pd.setApsAllocReplenOos(getTableDataItemNbrRqst("ApsAllocReplenOo", session));
//		pd.setApsAllocReplenSss(getTableDataItemNbrRqst("ApsAllocReplenSs", session));
//		pd.setApsAllocReplenWos(getTableDataItemNbrRqst("ApsAllocReplenWo", session));
//		pd.setApsAllocWoFcs(getTableDataItemNbrRqst("ApsAllocWoFc", session));
//		pd.setApsAllocWoOos(getTableDataItemNbrRqst("ApsAllocWoOo", session));
//		pd.setApsAllocWoSss(getTableDataItemNbrRqst("ApsAllocWoSs", session));
//		pd.setApsAllocWoWos(getTableDataItemNbrRqst("ApsAllocWoWo", session));
//
//		pd.setApsAvailOnhands(getTableDataItemNbr("ApsAvailOnhand", session));
//		pd.setApsAvailReplens(getTableDataItemNbr("ApsAvailReplen", session));
//		pd.setApsAvailWos(getTableDataItemNbr("ApsAvailWo",session));
//			
//		pd.setApsDmdFcs(getTableDataItemNbrDmd("ApsDmdFc", session));
//		pd.setApsDmdSss(getTableDataItemNbrDmd("ApsDmdSs", session));
//		pd.setApsDmdWos(getTableDataItemNbrDmd("ApsDmdWo", session));
//		List<ApsDmdOo> dmdOos = getTableDataItemNbrDmd("ApsDmdOo", session);
//		System.out.println("PlanningDataService getPlanningData dmdOos.size " + dmdOos.size());
//		System.out.println("PlanningDataService getPlanningData dmdOos" + stringBean.asString(dmdOos));
//		pd.setApsDmdOos(dmdOos);
//	//	pd.setApsDmdOos(getTableDataItemNbrDmd("ApsDmdOo", session));
//		
//		pd.setOeCustMfrs(getTableDataItemNbr("OeCustMfr",session));
//		pd.setFcItemMasts(getTableDataItemNbr("FcItemMast",session));
//	
//		pd.setIcItemMastEquivs(getIcItemMastEquiv(session));
//		pd.setIcItemCustsSubsts(getIcItemCustSubst(session));
//		pd.setIcLotMasts(getTableDataItemNbr("IcLotMast",session));
//		pd.setIcCertCds(getAll("IcCertCd",session));
//		pd.setUtFacilities(getAll("UtFacility", session));
//		// supplies
//		// this should cut down on sql calls TODO
//		
//		
//		//
//		pd.setApsSplySubPools(getAll("ApsSplySubPool",session));
//		pd.setOeOrdDtlCerts(getOeOrdDtlCerts2(session));
//		// substitutes
//		pd.setApsItemGlobalSubsts(getApsItemGlobalSubsts(session));
////		// manufacturer
////		pd.setApsCustMfrVws(getTableDataItemNbr("ApsCustMfrVw",session));
//		// item master
//		logger.debug("about to fetch icItemMasts");
//		pd.setIcItemMasts(getTableDataItemNbr("IcItemMast", session));
//		logger.debug("icItemMasts.size() " + pd.getIcItemMasts().size());
//		
//		pd.setFcstGrps(getAll("FcstGrp",session));
//		// TODO this should be a cached query
//		List<ApsSrcRule> apsSrcRules = getAll("ApsSrcRule",session);
//		pd.setApsSrcRules(apsSrcRules);
//		List<ApsSrcRuleSet> sourceRuleSets = getAll("ApsSrcRuleSet",session);
//		logger.debug("getting ApsSrcRules for ruleSet");
//		pd.setApsSrcRuleSets(sourceRuleSets);
//		pd.setApsSplySubPools(getAll("ApsSplySubPool",session));
//		
//		pd.setOeCustMasts(getCustomers(session));
//		long fetchTime = getPlanningDataTimer.getElapsedMicros();
//		//SourcingRules sourcingRules = new SourcingRules(apsSrcRules, sourceRuleSets);
//		//
//		// This creates data from the previous calls, creating maps and linking 
//		// classes together 
//		//
//		pd.buildMapsAndReferences();
//		ArrayList<String> messages = pd.checkIntegrity();
//		// no need to close the session, this is transactional, it will be committed and closed
//	
////		if (this.trimSourcingRules) {
////			pd.getSourcingRules(pd);
////		}
//		// TODO PERFORMANCE 
//		
//		logMessage = String.format("***\ngetPlanningData fetch Micros %d totalMicros %d\n***",fetchTime, getPlanningDataTimer.getElapsedMicros());
//		logger.info(logMessage);
//		analytics.debug(logMessage);
//
//		return pd;
//	}
//	
//
//
//	public Set<Integer> populateTmpItemSql(Collection<Integer> itemNumbers, Session session) {
//		session.beginTransaction();
//		Query q =session.createSQLQuery("delete from tmp_item");
//		int count = q.executeUpdate();
//		logger.debug("deleted " + count + " from tmp_item");
//		
//		Query ins = session.createSQLQuery("insert into tmp_item (item_nbr) values (:item_nbr)");
//		for (Integer itemNumber : itemNumbers)  {
//			ins.setParameter("item_nbr", itemNumber);
//			int rowCount = ins.executeUpdate();
//			logger.debug("Inserted " + itemNumber + " rows " + rowCount);
//		}
//		
//		
//	
//		session.flush();
//		q = session.createSQLQuery("select count(*) cnt from tmp_item");  // TODO there is nothing here
//		@SuppressWarnings("unchecked")
//		List<BigDecimal> results = q.list();
//		BigDecimal cnt= results.get(0);
//		String message = "tmp_item row count = " + cnt;
//		
//		q = session.createQuery("from TmpItem");
//		List<TmpItem> rows = q.list();
//		Set<Integer> itemsInTmpItem = new HashSet<Integer>();
//		for (TmpItem row : rows) {
//			itemsInTmpItem.add(row.getItemNbr());
//		}
//		System.out.print(message);
//		logger.debug(message);
//		if (itemsInTmpItem.size() != itemNumbers.size()) {
//			logger.error("expected " + itemNumbers + " but got " + itemsInTmpItem);
//		}
//	
//		return itemsInTmpItem;
//		
//	}
//
//
//	public Set<Integer> populateTmpItemJpa(Collection<Integer> itemNumbers, Session session) {
//		Query q =session.createSQLQuery("delete from tmp_item");
//		int count = q.executeUpdate();
//		logger.debug("deleted " + count + " from tmp_item");
//	
//		for (Integer itemNumber : itemNumbers) {
//			TmpItem ti = new TmpItem();
//			ti.setItemNbr(itemNumber);
//			logger.debug("inserting " + itemNumber);
//			session.persist(ti);
//		}
//	
//		logger.debug("about to flush");
//		session.flush();
//		logger.debug("flushed");
//		q = session.createSQLQuery("select count(*) cnt from tmp_item");  // TODO there is nothing here
//		@SuppressWarnings("unchecked")
//		List<Number> results = q.list();
//		Number cnt= results.get(0);
//		String message = "tmp_item row count = " + cnt;
//		
//		q = session.createQuery("from TmpItem");
//		List<TmpItem> rows = q.list();
//		Set<Integer> itemsInTmpItem = new HashSet<Integer>();
//		for (TmpItem row : rows) {
//			itemsInTmpItem.add(row.getItemNbr());
//		}
//		logger.debug(message);
//		if (itemsInTmpItem.size() != itemNumbers.size()) {
//			logger.error("expected " + itemNumbers + " but got " + itemsInTmpItem);
//		}
//		return itemsInTmpItem;
//		
//	}
//	
//
//	@SuppressWarnings("unchecked")
//	private List<ApsItemGlobalSubst> getApsItemGlobalSubsts(Session session) {
//		String queryText = "from ApsItemGlobalSubst where " +
//                   "item_nbr in (select itemNbr from TmpItem) or "
//				+ " item_nbr_subst in (select itemNbr from TmpItem)";
//		return getList("ApsItemGlobalSubst", queryText, session);
//	}
//
//	private List<OeOrdDtlCert> getOeOrdDtlCerts(Session session) {
//		String queryText = 
//				"select * from oe_ord_dtl_cert "
//				+"where oe_ord_dtl_nbr in "
//                + "(select oe_ord_dtl_nbr from oe_ord_dtl where item_nbr_rqst in (" 
//                + "select item_nbr from tmp_item))";
//		Query q = session.createSQLQuery(queryText).setResultTransformer(Transformers.aliasToBean(OeOrdDtl.class));
//		return q.list();
//	}
//	
//	@SuppressWarnings("unchecked")
//	private List<OeOrdDtlCert> getOeOrdDtlCerts2(Session session) {
//		String queryText = 
//				"select * from oe_ord_dtl_cert "
//				+"where oe_ord_dtl_nbr in "
//                + "(select oe_ord_dtl_nbr from oe_ord_dtl where item_nbr_rqst in (" 
//                + "select item_nbr from tmp_item))";
//		return getAllSql(OeOrdDtl.class,queryText,session);
//	}
//		
//	
//	private List<ApsDmdOo> getApsDmdOo(Session session) {
//		String queryText = "from ApsDmdOo)";
//		Query query = session.createQuery(queryText);
//		@SuppressWarnings("rawtypes")
//		List result = query.list();
//		return result;
//	}
//	
//	@SuppressWarnings("unchecked")
//	private List<IcItemCustSubst> getIcItemCustSubst(Session session) {
//		String queryText = "from IcItemCustSubst where " + "item_nbr in (select itemNbr from TmpItem) or "
//				+ " item_nbr_subst in (select itemNbr from TmpItem)";
//		return getList("IcItemCustSubst", queryText, session);
//
//	}
//
//	@SuppressWarnings("unchecked")
//	List<IcItemMastEquiv> getIcItemMastEquiv(Session session) {
//		String queryText = "from IcItemMastEquiv where item_nbr in (select itemNbr from TmpItem)"
//				+ "or item_nbr_equiv in (select itemNbr from TmpItem)";
//		return getList("IcItemMastEquiv", queryText, session);
//	}
//	
//	
//	public Collection<Integer> getItemNbrsInPlanGroup(Integer planGrpNbr) {
//	    List<ApsPlanGrp> planGroups;
//		String queryText = "from ApsPlanGrp where planGrpNbr = :planGrpNbr";
//		SqlStatement ss  = new SqlStatement(getConnection(),queryText);
//		Query query = session.createQuery(queryText);
//		query.setInteger("planGrpNbr", planGrpNbr);
//		List<ApsPlanGrp> result = query.list();
//		ArrayList<Integer> itemNbrs = new ArrayList<Integer>();
//	    int index = 0;
//		for (ApsPlanGrp grp : result) {
//			itemNbrs.add(grp.getItemNbr());
//		}
//		return itemNbrs;
//	}
//
//	Collection<OeCustMast> getCustomers(Session session) {
//          String q = "from OeCustMast where org_nbr_cust in ("
//          		+ "select orgNbrCust from ApsDmdOo where itemNbrDmd in (select itemNbr from TmpItem))";
//          List<OeCustMast> apsDmdOoCusts =  getList("OeCustMast",q,session);
//          
//          String p = "from OeCustMast where org_nbr_cust in ("
//          		+ "select orgNbrCust from ApsDmdFc where itemNbrDmd in (select itemNbr from TmpItem))";
//          List<OeCustMast> apsDmdFcCusts =  getList("OeCustMast",p,session);
//          
//          HashMap<Integer,OeCustMast> custById = new HashMap<Integer,OeCustMast>();
//          
//          for (OeCustMast cust : apsDmdOoCusts) {
//        	  logger.debug("putting customer: {}",cust.getOrgNbrCust());
//        	  custById.put(cust.getOrgNbrCust(),cust);
//          }
//          
//          for (OeCustMast cust : apsDmdFcCusts) {
//        	  System.out.println("putting customer for apsDmdFc: " + cust.getOrgNbrCust());
//        	  logger.debug("putting customer: {}",cust.getOrgNbrCust());
//        	  custById.put(cust.getOrgNbrCust(),cust);
//          }
////        if (logger.isDebugEnabled()){
//        	  logger.debug("**************** Customers *****************");
//        	  for (OeCustMast ocm : custById.values()) {
//        		  System.out.println("OrgNbrCust: " + ocm.getOrgNbrCust());
//        		  logger.debug("orgNbrCust: " + ocm.getOrgNbrCust());
//        	  }
// //       }
//          return custById.values();
//	}
//
//	public boolean isTrimSourcingRules() {
//		return trimSourcingRules;
//	}
//
//	public void setTrimSourcingRules(boolean trimSourcingRules) {
//		this.trimSourcingRules = trimSourcingRules;
//	}
//
//
//}
