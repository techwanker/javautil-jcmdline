package com.pacificdataservices.diamond.planning.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.javautil.util.Timer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pacificdataservices.diamond.models.ApsSplyPool;
import com.pacificdataservices.diamond.models.ApsSplySubPool;
import com.pacificdataservices.diamond.models.ApsSrcRule;
import com.pacificdataservices.diamond.models.ApsSrcRulePrimary;
import com.pacificdataservices.diamond.models.FcstGrp;
import com.pacificdataservices.diamond.models.IcItemMast;
import com.pacificdataservices.diamond.models.NaOrg;
import com.pacificdataservices.diamond.models.OeCustMast;
import com.pacificdataservices.diamond.models.OeCustMfr;
import com.pacificdataservices.diamond.models.UtFacility;
import com.pacificdataservices.diamond.planning.PlanningDataException;
import com.pacificdataservices.diamond.planning.StringBean;
import com.pacificdataservices.diamond.planning.container.ApsSrcRuleSetExt;
import com.pacificdataservices.diamond.planning.demand.Demand;
import com.pacificdataservices.diamond.planning.supply.Supply;
import com.pacificdataservices.diamond.planning.supply.SupplyOnhand;

public class PlanningDataGraphBuilder {
	private StringBean stringBean = new StringBean();
	private PlanningData pd;
	transient private Logger logger = LoggerFactory.getLogger(getClass());
	transient private Logger analytics = LoggerFactory.getLogger("analytics");
	private static boolean showTiming = true;

	private PlanningDataValidator pdv;

	public PlanningDataGraphBuilder(PlanningData pd) {
		this.pd = pd;
		pdv = new PlanningDataValidator(pd);
	}

	public void process() {
		logger.debug("********* buildReferences **************");
		associateSourcingRules();
		if (pdv != null) {
			pdv.checkApsSrcRuleSetExt();         //
		}
		associateApsSplySubPoolInSupply();
		populateDemands();
		associateDemand();
		associateSupply();
		associateApsSplySubPoolInApsSrcRule();
		associateUtFacilityInApsSrcRule();
		associatePrimaryFacilityInDemand();
		associateOeCustMast();
		associateOeCustMfr();
		multiCert();
		pd.populateForecastBucketsByForecastGroup();
		pd.populateOrderGroups();
		
	}

	public void associateSourcingRules() {
		Timer t = new Timer();
		Collection<ApsSrcRule> apsSrcRules = pd.getApsSrcRules();
		Map<Integer, ApsSrcRulePrimary> primaryById = pd.getApsSrcRulePrimaryById();
		TreeMap<Integer, Set<ApsSrcRule>> sourceRulesBySetNbr = new TreeMap<>();
		TreeMap<Integer,ApsSrcRuleSetExt> rulesetExtMap = pd.getApsSrcRuleSetExtById();

		for (ApsSrcRule asr : apsSrcRules) {
			Set<ApsSrcRule> rules = sourceRulesBySetNbr.get(asr.getApsSrcRuleSetNbr());
			if (rules == null) {
				rules = new HashSet<ApsSrcRule>();
			}
			rules.add(asr);
			sourceRulesBySetNbr.put(asr.getApsSrcRuleSetNbr(), rules);
		}

		for (ApsSrcRuleSetExt setx : pd.getApsSrcRuleSetExtById().values()) {
			ApsSrcRulePrimary prime = primaryById.get(setx.getApsSrcRuleSetNbr());
			int primaryRuleNbr = prime.getApsSrcRuleNbr();
			ApsSrcRule primaryRule = pd.getApsSrcRuleById().get(primaryRuleNbr);
			setx.setPrimaryRule(primaryRule);

			Set<ApsSrcRule> ruleSet = sourceRulesBySetNbr.get(setx.getApsSrcRuleSetNbr());
			if (ruleSet == null) {
				String message = String.format("ApsSrcRuleSet: %d has null ruleSet", setx.getApsSrcRuleSetNbr());
				logger.error(message);
				throw new IllegalArgumentException(message);
			} else {
				setx.setApsSrcRules(ruleSet);
				if (logger.isDebugEnabled()) {
					StringBean stringBean = new StringBean();
					logger.debug("ApsSrcRuleSet {} has {} rules", stringBean.asString(setx), ruleSet.size());
				}
			}
		}
		if (showTiming) {
			String message = String.format("associateSourcingRules complete: %d  microseconds", t.getElapsedMicros());
			analytics.info(message);
		}
	}

	public void associateApsSplySubPoolInSupply() {
		Timer t = new Timer();
		for (Supply supply : pd.getSupplies()) {
			ApsSplySubPool apsSubPool = pd.getApsSplySubPoolById().get(supply.getApsSplySubPoolNbr());
			if (apsSubPool == null) {
				StringBuilder sb = new StringBuilder();
				sb.append(String.format("apsSupplySubPoolById.values().size() %d\n",
						pd.getApsSplySubPoolById().values().size()));
				sb.append(String.format("apsSupplySubPool.size() %d\n", pd.getApsSplySubPools().size()));
				for (ApsSplySubPool sub : pd.getApsSplySubPoolById().values()) {
					sb.append(sub);
					sb.append("\n");
				}
				sb.append("no subpool found " + supply.getApsSplySubPoolNbr() + "\n" + sb.toString());
				logger.error(sb.toString());
				throw new PlanningDataException(sb.toString());
			}
			supply.setApsSplySubPool(apsSubPool);
		}
		if (showTiming) {
			String message = String.format("associateApsSplySubPoolInSupply complete: %d  microseconds",
					t.getElapsedMicros());
			analytics.info(message);
		}
	}

	public void associateDemand() {
		Timer t = new Timer();
		for (Demand demand : pd.getDemands()) {
			OeCustMast ocm = null;
			try {
				ocm = pd.getOeCustMast(demand.getOrgNbrCust());
			} catch (IllegalArgumentException iae) {
				String message = String.format("Could not find customer %d for demand %s", demand.getOrgNbrCust(),
						demand.toString());
				logger.error(message);
				throw new PlanningDataException(message);
			}
			demand.setOeCustMast(ocm);

			demand.setApsSrcRuleSetExt(pd.getApsSrcRuleSetExt(demand.getApsSrcRuleSetNbr()));
			ApsSrcRuleSetExt ruleSet = demand.getApsSrcRuleSetExt();
			ApsSrcRule primary = ruleSet.getPrimaryRule();
			demand.setPrimarySourcingFacility(primary.getUtFacility());

			IcItemMast iim = pd.getIcItemMastById(demand.getItemNbrDmd());
			demand.setIcItemMast(iim);

			String fcstGrp = demand.getFcstGrp();
			if (fcstGrp == null) {
				throw new PlanningDataException("fcstGrp is null for " + demand);
			}
			Map<String,FcstGrp> fcstGrpById = pd.getFcstGrpById();
			FcstGrp fg = fcstGrpById.get(fcstGrp);
			demand.setDemandFcstGrp(fg);

			if (demand.getOrgNbrMfrRqst() != null) { 
				NaOrg mfr = pd.getNaOrg(demand.getOrgNbrMfrRqst(),demand);
				demand.setNaOrgMfrRqst(mfr);
			}
		}
		if (showTiming) {
			String message = String.format("associateApsSrcRuleInDemand complete: %d  microseconds", t.getElapsedMicros());
			analytics.info(message);
		}
	}


	void associateApsSplySubPoolInApsSrcRule() {
		Timer t = new Timer();
		for (ApsSrcRule rule : pd.getApsSrcRules()) {
			ApsSplySubPool sub = pd.getApsSplySubPoolById().get(rule.getApsSplySubPoolNbr());
			if (sub == null) {
				String message = String.format(
						"ApsSrcRule # %d has apsSplySubPoolNbr %d not in ApsSplySubPoolById\n %s",
						rule.getApsSrcRuleNbr(), rule.getApsSplySubPoolNbr(),
						stringBean.asString(pd.getApsSplySubPoolById()));
				logger.error(message);
				throw new PlanningDataException(message);
			}
			rule.setApsSplySubPool(sub);
		}
		if (showTiming) {
			String message = String.format("associateApsSplySubPoolInApsSrcRule complete: %d  microseconds",
					t.getElapsedMicros());
			analytics.info(message);
		}
	}

	void associateUtFacilityInApsSrcRule() {
		Timer t = new Timer();
		for (ApsSrcRule rule : pd.getApsSrcRules()) {
			String facilityName = rule.getFacility();
			UtFacility uf = pd.getUtFacility(facilityName);
			if (uf == null) {
				String message = String.format("Facility %s not found in %s", facilityName,
						stringBean.asString(pd.getUtFacilityById()));
				logger.error(message);
				throw new PlanningDataException(message);
			}
			rule.setUtFacility(uf);
		}
		if (showTiming) {
			String message = String.format("associateUtFacilityInApsSrcRule complete: %d  microseconds",
					t.getElapsedMicros());
			analytics.info(message);
		}
	}

	public void associatePrimaryFacilityInDemand() {
		Timer t = new Timer();
		Collection<Demand> demands = pd.getDemands();
		if (demands == null) {
			throw new PlanningDataException("Planning Data pd.getDemands() == null");
		}
		ApsSrcRuleSetExt ruleSet = null;
	//	ApsSrcRule srcRule = null;
		for (Demand d : demands) {
			ruleSet = d.getApsSrcRuleSetExt();
			ApsSrcRule primary = ruleSet.getPrimaryRule();
			d.setPrimarySourcingFacility(primary.getUtFacility());
		}
		if (showTiming) {
			String message = String.format("associateUtFacilityInDemand complete: %d  microseconds",
					t.getElapsedMicros());
			analytics.info(message);
		}
	}
	
	
	void multiCert() {
		for (SupplyOnhand so  : pd.getSupplyOnhandById().values()) {
			so.setIcItemMastByItemCd(pd.getIcItemMastsById(), pd.getItemNbrsByLotNbr());
		}
	}

	public void associateSupply() {
		for (Supply supply : pd.getSupplies()) {
			Integer subNbr = supply.getApsSplySubPoolNbr();
			ApsSplySubPool sub = pd.getApsSplySubPool(subNbr);
			ApsSplyPool pool = pd.getApsSplyPool(sub.getApsSplyPoolCd());
			supply.setApsSplyPool(pool);
		}
	}
	/** 
	 * This is kind of goofy, OeCustMast.naOrg will be automatically populated
	 * by hibernate as it is a one to one, but if marshalled to JSON we need to populate.
	 */
	private void associateOeCustMast() {
		for (OeCustMast cust : pd.getOeCustMasts()) {
			if (cust.getNaOrg() == null) {
				NaOrg org  = pd.getNaOrg(cust.getOrgNbrCust(),cust);
				cust.setNaOrg(org);
			}
		}
	}

	private void associateOeCustMfr() {
		for (OeCustMfr custMfr: pd.getOeCustMfrs()) {
			if (custMfr.getPoMfrMast() == null) {
				int orgNbr =custMfr.getId().getOrgNbrMfr();
				NaOrg mfr = pd.getNaOrg(orgNbr,custMfr);
				custMfr.setNaOrgMfr(mfr);
			}
			if (custMfr.getOeCustMast() == null) {
				OeCustMast ocm = pd.getOeCustMast(custMfr.getId().getOrgNbrCust());
				if (ocm.getNaOrg().getOrgCd() == null) {
					throw new PlanningDataException("OeCustMast.naOrg is null for " + ocm.getOrgNbrCust());
				}
//				NaOrg custOrg = pd.getNaOrg(ocm.getOrgNbrCust());
//				ocm.setNaOrg(custOrg);
				custMfr.setOeCustMast(ocm);
			}
//			//PoMfrMast mfr = custMfr.getPoMfrMast();
//			NaOrg orgMfr = custMfr.getNaOrgMfr();
//			if (mfr == null) {
//				NaOrg mfrOrg = pd.getNaOrg(mfr.getOrgNbrMfr());
//				custMfr.getPoMfrMast().setNaOrg(mfrOrg);
//			}
			
			if (custMfr.getIcItemMast() == null) {
				IcItemMast iim = pd.getIcItemMastById(custMfr.getId().getItemNbr());
				custMfr.setIcItemMast(iim);
			}
		}
	}

	public void populateDemands() {
		ArrayList<Demand> demands = new ArrayList<Demand>();
		demands.addAll(pd.getDemandCustomers());
		demands.addAll(pd.getDemandSafetyStocks());
		demands.addAll(pd.getDemandWorkOrders());
		demands.addAll(pd.getDemandForecastById().values());
		pd.setDemands(demands);
	}
}
