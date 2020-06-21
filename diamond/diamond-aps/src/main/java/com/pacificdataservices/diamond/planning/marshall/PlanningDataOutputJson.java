package com.pacificdataservices.diamond.planning.marshall;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.TreeMap;

import org.javautil.core.json.JsonSerializerGson;
import org.javautil.hibernate.HibernateMarshallerFactory;
import org.javautil.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.pacificdataservices.diamond.planning.data.PlanningData;
import com.pacificdataservices.diamond.planning.demand.Demand;

public class PlanningDataOutputJson {
	
	transient private static Logger logger = LoggerFactory.getLogger(PlanningDataOutputJson.class);
	private Date effectiveDate;
	
//	private Collection<ApsSplySubPool> apsSplySubPools;
//	private Collection<ApsSrcRule> apsSrcRules;
//	private Collection<ApsSrcRuleSet> apsSrcRuleSets;
//	private TreeMap<String,UtFacility> utFacilities;
//	private TreeMap<String,FcstGrp> fcstGrps;
	
	private TreeMap<String,Demand> prioritizedDemands;
// 	///
//	private TreeMap<Integer,ApsAllocOnhandFc> apsAllocOnhandFcs;
//	private TreeMap<Integer,ApsAllocOnhandOo> apsAllocOnhandOos;
//	private TreeMap<Integer,ApsAllocOnhandSs> apsAllocOnhandSss;
//	private TreeMap<ApsAllocOnhandWo> apsAllocOnhandWos;
//	private TreeMap<ApsAllocReplenFc> apsAllocReplenFcs;
//	// Replenishment Allocations
//	private TreeMap<ApsAllocReplenOo> apsAllocReplenOos;
//	private TreeMap<ApsAllocReplenSs> apsAllocReplenSss;
//	private TreeMap<ApsAllocReplenWo> apsAllocReplenWos;
//	// Work Order Allocations
//	private TreeMap<ApsAllocWoFc> apsAllocWoFcs;
//	private TreeMap<ApsAllocWoOo> apsAllocWoOos;
//	private TreeMap<ApsAllocWoSs> apsAllocWoSss;
//	private TreeMap<ApsAllocWoWo> apsAllocWoWos;
//	private TreeMap<ApsAvailOnhand> apsAvailOnhands;
//	private TreeMap<ApsAvailReplen> apsAvailReplens;
//	private TreeMap<ApsAvailWo> apsAvailWos;
//	// private TreeMap<ApsCustMfrVw> apsCustMfrVws;
//	private TreeMap<String,ApsDmdFc> apsDmdFcs;
//	private TreeMap<String,ApsDmdOo> apsDmdOos;
//	private TreeMap<String,ApsDmdSs> apsDmdSss;
//	private TreeMap<String,ApsDmdWo> apsDmdWos;
//	private TreeMap<ApsItemGlobalSubst> apsItemGlobalSubsts;
//	// private TreeMap<ApsSupply> apsSupplies;
//	private TreeMap<FcItemMast> fcItemMasts;
//	private TreeMap<IcCertCd> icCertCds;
//	private TreeMap<IcItemCustSubst> icItemCustsSubsts;
//	private TreeMap<IcItemMastEquiv> icItemMastEquivs;
//	private TreeMap<IcItemMast> icItemMasts;
//	private Map<Integer, OeCustMast> oeCustMastById;
//	//private Collection<OeCustMast> oeCustMasts;
//	private TreeMap<OeCustMfr> oeCustMfrs;
//	private TreeMap<OeOrdDtlCert> oeOrdDtlCerts;
//	private TreeMap<TmpItem> tmpItems;
//	private Collection<ApsSrcRulePrimary> apsSrcRulePrimarys;
//	private Map<Integer,NaOrg> naOrgById;
	

//	private PlanningDataOutputJson() {
//	}
	
//    /**
//     * 	
//     * @param jsonFile json create by PlanningDataMarshaller 
//     * @return
//     * @throws IOException
//     */
//    public static PlanningData planningDataFromFile (File jsonFile) throws IOException {
//    	Timer t = new Timer();
//		JsonSerializerGson dillon = new JsonSerializerGson();
//		String json = IOUtils.readFileAsString(jsonFile.getAbsolutePath());
//	    logger.info("unmarshall micros {}", t.getElapsedMicros());	
//		return planningDataFromJson(json);
//    }
//	
////    public static PlanningData planningDataFromJson(String json) throws IOException {
////		PlanningDataOutputJson pdm = fromJson(json);
////		return pdm.toPlanningData();
////    }
////    
//    public static PlanningDataOutputJson fromFile(File file) throws IOException {
//		JsonSerializerGson dillon = new JsonSerializerGson();
//		return fromJson(IOUtils.readFileAsString(file.getAbsolutePath()));
//    }
    
//    public  PlanningData toPlanningData() throws IOException {
//    	PlanningData pd = new PlanningData();
//    	pd.setEffectiveDate(effectiveDate);
//		pd.setApsAllocOnhandFcs(getApsAllocOnhandFcs());
//		pd.setApsAllocOnhandOos(getApsAllocOnhandOos());
//		pd.setApsAllocOnhandSss(getApsAllocOnhandSss());
//		pd.setApsAllocOnhandWos(getApsAllocOnhandWos());
//		pd.setApsAllocReplenFcs(getApsAllocReplenFcs());
//		// setAllocations
//		pd.setApsAllocReplenOos(getApsAllocReplenOos());
//		pd.setApsAllocReplenSss(getApsAllocReplenSss());
//		pd.setApsAllocReplenWos(getApsAllocReplenWos());
//		pd.setApsAllocWoFcs(getApsAllocWoFcs());
//		pd.setApsAllocWoOos(getApsAllocWoOos());
//		pd.setApsAllocWoSss(getApsAllocWoSss());
//		pd.setApsAllocWoWos(getApsAllocWoWos());
//		//
//		List<ApsAvailOnhand> apsAvailOnhands = getApsAvailOnhands();
//		assertNotNull(apsAvailOnhands);
//		pd.setApsAvailOnhands(getApsAvailOnhands());
//		pd.setApsAvailReplens(getApsAvailReplens());
//		pd.setApsAvailWos(getApsAvailWos());
//		//
//		pd.setApsDmdFcs(getApsDmdFcs());
//		pd.setApsDmdOos(getApsDmdOos());
//		pd.setApsDmdSss(getApsDmdSss());
//		pd.setApsDmdWos(getApsDmdWos());
//		//
//		pd.setApsItemGlobalSubsts(getApsItemGlobalSubsts());
//		pd.setApsSplySubPools(getApsSplySubPools());
//		pd.setApsSrcRules(getApsSrcRules());
//		pd.setApsSrcRuleSets(getApsSrcRuleSets());
//		pd.setApsSrcRulePrimarys(getApsSrcRulePrimarys());
//		//
//		pd.setFcItemMasts(getFcItemMasts());
//		pd.setFcstGrps(getFcstGrps());
//		pd.setIcCertCds(getIcCertCds());
//		pd.setIcItemCustsSubsts(getIcItemCustsSubsts());
//		pd.setIcItemMastEquivs(getIcItemMastEquivs());
//		pd.setIcItemMasts(getIcItemMasts());
//		pd.setOeCustMastById(oeCustMastById);
//		pd.setOeCustMfrs(getOeCustMfrs());
//		pd.setOeOrdDtlCerts(getOeOrdDtlCerts());
//		pd.setUtFacilities(utFacilities);
//		pd.setTmpItems(getTmpItems());
//		pd.setNaOrgById(naOrgById);
//		pd.buildMapsAndReferences();
//		pd.checkIntegrity();
//		return pd;
//    }
//    
//    public static PlanningDataOutputJson fromJson(String json) {
//		JsonSerializerGson dillon = new JsonSerializerGson();
//		PlanningDataOutputJson retval = (PlanningDataOutputJson) dillon.toObjectFromJson(json, PlanningDataOutputJson.class);
//		return retval;
//    }
//    
	public PlanningDataOutputJson(PlanningData pd) {
		if (pd == null) {
			throw new IllegalArgumentException("pd is null");
		}
		effectiveDate     = pd.getEffectiveDate();
		prioritizedDemands = pd.getPrioritizedDemands();
		
//		apsAllocOnhandFcs = pd.getApsAllocOnhandFcs();
//		apsAllocOnhandOos = pd.getApsAllocOnhandOos();
//		apsAllocOnhandSss = pd.getApsAllocOnhandSss();
//		apsAllocOnhandWos = pd.getApsAllocOnhandWos();
//		apsAllocReplenFcs = pd.getApsAllocReplenFcs();
//		// setAllocations
//		apsAllocReplenOos = pd.getApsAllocReplenOos();
//		apsAllocReplenSss = pd.getApsAllocReplenSss();
//		setApsAllocReplenWos(pd.getApsAllocReplenWos());
//		setApsAllocWoFcs(pd.getApsAllocWoFcs());
//		setApsAllocWoOos(pd.getApsAllocWoOos());
//		setApsAllocWoSss(pd.getApsAllocWoSss());
//		setApsAllocWoWos(pd.getApsAllocWoWos());
//		setApsAvailOnhands(pd.getApsAvailOnhands());
//		setApsAvailReplens(pd.getApsAvailReplens());
//		setApsAvailWos(pd.getApsAvailWos());
//		// setApsCustMfrVws(pd.getApsCustMfrVws());
//		setApsDmdFcs(pd.getApsDmdFcs());
//		setApsDmdOos(pd.getApsDmdOos());
//		setApsDmdSss(pd.getApsDmdSss());
//		setApsDmdWos(pd.getApsDmdWos());
//		setApsItemGlobalSubsts(pd.getApsItemGlobalSubsts());
//		setApsSplySubPools(pd.getApsSplySubPools());
//		setApsSrcRules(pd.getApsSrcRules());
//		setApsSrcRuleSets(pd.getApsSrcRuleSets());
//		setFcItemMasts(pd.getFcItemMasts());
//		setFcstGrps(pd.getFcstGrps());
//		setIcCertCds(pd.getIcCertCds());
//		setIcItemCustsSubsts(pd.getIcItemCustsSubsts());
//		setIcItemMastEquivs(pd.getIcItemMastEquivs());
//		// TODO WTF?
//		ArrayList<IcItemMast> icItemMasts = new ArrayList<IcItemMast>();
//		icItemMasts.addAll(pd.getIcItemMasts());
//		setIcItemMasts(icItemMasts);
//		//
//		oeCustMastById =pd.getOeCustMastById();
//		setOeCustMfrs(pd.getOeCustMfrs());
//		setOeOrdDtlCerts(pd.getOeOrdDtlCerts());
//		setUtFacilities(pd.getUtFacilities());
////		setTmpItems(pd.getTmpItems());
//		setApsSrcRulePrimarys(pd.getApsSrcRulePrimaryById().values());
////		for (NaOrg org : pd.getNaOrgById().values()) {
////			System.out.print(org.toString());
////		}
//		naOrgById = pd.getNaOrgById();
//		
//		
////		HashMap<Integer,NaOrg> orgs = new HashMap<Integer,NaOrg>();
////		for (OeCustMast cust : pd.getOeCustMasts()) {
////			NaOrg org = cust.getNaOrg();
////			orgs.put(org.getOrgNbr(),org);
////		}
////		for (OeCustMfr custMfr : pd.getOeCustMfrs()) {
////			NaOrg org = custMfr.getNaOrgMfr();
////			orgs.put(org.getOrgNbr(),org);
////		}
//		naOrgs = orgs.values();
	}

//	public PlanningDataMarshallable trimToOne() {
//		PlanningDataMarshallable pdm = new PlanningDataMarshallable();
//		pdm.setApsAllocOnhandOos(trimToOne(apsAllocOnhandOos));
//		pdm.setApsAllocOnhandSss(trimToOne(apsAllocOnhandSss));
//		pdm.setApsAllocOnhandWos(trimToOne(apsAllocOnhandWos));
//		pdm.setApsAllocReplenFcs(trimToOne(apsAllocReplenFcs));
//		pdm.setApsAllocReplenOos(trimToOne(apsAllocReplenOos));
//		pdm.setApsAllocReplenSss(trimToOne(apsAllocReplenSss));
//		pdm.setApsAllocReplenWos(trimToOne(apsAllocReplenWos));
//		pdm.setApsAllocWoOos(trimToOne(apsAllocWoOos));
//		pdm.setApsAllocWoSss(trimToOne(apsAllocWoSss));
//		pdm.setApsAllocWoWos(trimToOne(apsAllocWoWos));
//		pdm.setApsAvailOnhands(trimToOne(apsAvailOnhands));
//		pdm.setApsAvailReplens(trimToOne(apsAvailReplens));
//		pdm.setApsAvailWos(trimToOne(apsAvailWos));
//		pdm.setApsDmdFcs(trimToOne(apsDmdFcs));
//		pdm.setApsDmdOos(trimToOne(apsDmdOos));
//		pdm.setApsDmdSss(trimToOne(apsDmdSss));
//		pdm.setApsDmdWos(trimToOne(apsDmdWos));
//		pdm.setApsItemGlobalSubsts(trimToOne(apsItemGlobalSubsts));
//		pdm.setApsSplySubPools(trimToOne(apsSplySubPools));
//		pdm.setApsSrcRuleSets(trimToOne(apsSrcRuleSets));
//		pdm.setFcItemMasts(trimToOne(fcItemMasts));
//		pdm.setFcstGrps(trimToOne(fcstGrps));
//		pdm.setIcCertCds(trimToOne(icCertCds));
//		pdm.setIcItemCustsSubsts(trimToOne(icItemCustsSubsts));
//		pdm.setIcItemMastEquivs(trimToOne(icItemMastEquivs));
//		pdm.setIcItemMasts(trimToOne(icItemMasts));
//		pdm.setOeCustMasts(trimToOne(oeCustMasts));
//		pdm.setOeCustMfrs(trimToOne(oeCustMfrs));
//		pdm.setOeOrdDtlCerts(trimToOne(oeOrdDtlCerts));
//		pdm.setTmpItems(trimToOne(tmpItems));
//		return pdm;
//	}
	
	public void writeToFile(File f) throws IOException {
		Gson dillon  = HibernateMarshallerFactory.getHibernateGsonWithProxyDateFormatter();
		IOUtils.writeString(f,dillon.toJson(this));
	}

//	public <t> List<t> trimToOne(Collection<t> coll) {
//		List<t> target = null;
//		if (coll != null) {
//			target = new ArrayList<t>();
//			target.addAll(coll);
//			target = trimToOne(target);
//		}
//		return target;
//	}

//	public <t> List<t> trimToOne(List<t> list) {
//		ArrayList<t> result = null;
//		if (list != null) {
//			result = new ArrayList<t>();
//			if (list.size() > 0) {
//				try {
//				result.addAll(list.subList(0, 1));
//				} catch (Exception e) {
//					logger.error(e.getMessage());
//					
//				}
//			}
//		}
//		if (list != null && list.size() > 0) {
//			Object obj = list.get(0);
//			String className = obj.getClass().getName();
//	    	System.out.println(String.format("input size: %d output size: %d %s",list.size(),result.size(), className));
//		}
//		return result;
//	}
	
	public String toJson() {
		JsonSerializerGson dillon = new JsonSerializerGson();
		String retval = dillon.toJsonPretty(this);
		return retval;
	}

//	public List<ApsAllocOnhandFc> getApsAllocOnhandFcs() {
//		return apsAllocOnhandFcs;
//	}
//
//	public List<ApsAllocOnhandOo> getApsAllocOnhandOos() {
//		return apsAllocOnhandOos;
//	}
//
//	public List<ApsAllocOnhandSs> getApsAllocOnhandSss() {
//		return apsAllocOnhandSss;
//	}
//
//	public List<ApsAllocOnhandWo> getApsAllocOnhandWos() {
//		return apsAllocOnhandWos;
//	}
//
//	public List<ApsAllocReplenFc> getApsAllocReplenFcs() {
//		return apsAllocReplenFcs;
//	}
//
//	public List<ApsAllocReplenOo> getApsAllocReplenOos() {
//		return apsAllocReplenOos;
//	}
//
//	public List<ApsAllocReplenSs> getApsAllocReplenSss() {
//		return apsAllocReplenSss;
//	}
//
//	public List<ApsAllocReplenWo> getApsAllocReplenWos() {
//		return apsAllocReplenWos;
//	}
//
//	public List<ApsAllocWoFc> getApsAllocWoFcs() {
//		return apsAllocWoFcs;
//	}
//
//	public List<ApsAllocWoOo> getApsAllocWoOos() {
//		return apsAllocWoOos;
//	}
//
//	public List<ApsAllocWoSs> getApsAllocWoSss() {
//		return apsAllocWoSss;
//	}
//
//	public List<ApsAllocWoWo> getApsAllocWoWos() {
//		return apsAllocWoWos;
//	}
//
//	public List<ApsAvailOnhand> getApsAvailOnhands() {
//		return apsAvailOnhands;
//	}
//
//	public List<ApsAvailReplen> getApsAvailReplens() {
//		return apsAvailReplens;
//	}
//
//	public List<ApsAvailWo> getApsAvailWos() {
//		return apsAvailWos;
//	
//	}
//	public List<ApsDmdFc> getApsDmdFcs() {
//		return apsDmdFcs;
//	}
//
//	public List<ApsDmdOo> getApsDmdOos() {
//		return apsDmdOos;
//	}
//
//	public List<ApsDmdSs> getApsDmdSss() {
//		return apsDmdSss;
//	}
//
//	public List<ApsDmdWo> getApsDmdWos() {
//		return apsDmdWos;
//	}
//
//	public List<ApsItemGlobalSubst> getApsItemGlobalSubsts() {
//		return apsItemGlobalSubsts;
//	}
//
//	public Collection<ApsSplySubPool> getApsSplySubPools() {
//		return apsSplySubPools;
//	}
//
//	public Collection<ApsSrcRule> getApsSrcRules() {
//		return apsSrcRules;
//	}
//
//	public Collection<ApsSrcRuleSet> getApsSrcRuleSets() {
//		return apsSrcRuleSets;
//	}
//
//	// public List<ApsSupply> getApsSupplies() {
//	// return apsSupplies;
//	// }
//	public List<FcItemMast> getFcItemMasts() {
//		return fcItemMasts;
//	}
//
//	public List<FcstGrp> getFcstGrps() {
//		return fcstGrps;
//	}
//
//	public List<IcCertCd> getIcCertCds() {
//		return icCertCds;
//	}
//
//	public List<IcItemCustSubst> getIcItemCustsSubsts() {
//		return icItemCustsSubsts;
//	}
//
//	public List<IcItemMastEquiv> getIcItemMastEquivs() {
//		return icItemMastEquivs;
//	}
//
//	public List<IcItemMast> getIcItemMasts() {
//		return icItemMasts;
//	}
//
//
//	public List<OeCustMfr> getOeCustMfrs() {
//		return oeCustMfrs;
//	}
//
//	public List<OeOrdDtlCert> getOeOrdDtlCerts() {
//		return oeOrdDtlCerts;
//	}
//
//	public List<TmpItem> getTmpItems() {
//		return tmpItems;
//	}
//
//	public void setApsAllocOnhandFcs(List<ApsAllocOnhandFc> apsAllocOnhandFcs) {
//		this.apsAllocOnhandFcs = apsAllocOnhandFcs;
//	}
//
//	public void setApsAllocOnhandOos(List<ApsAllocOnhandOo> apsAllocOnhandOos) {
//		this.apsAllocOnhandOos = apsAllocOnhandOos;
//	}
//
//	public void setApsAllocOnhandSss(List<ApsAllocOnhandSs> apsAllocOnhandSss) {
//		this.apsAllocOnhandSss = apsAllocOnhandSss;
//	}
//
//	public void setApsAllocOnhandWos(List<ApsAllocOnhandWo> apsAllocOnhandWos) {
//		this.apsAllocOnhandWos = apsAllocOnhandWos;
//	}
//
//	public void setApsAllocReplenFcs(List<ApsAllocReplenFc> apsAllocReplenFcs) {
//		this.apsAllocReplenFcs = apsAllocReplenFcs;
//	}
//
//	public void setApsAllocReplenOos(List<ApsAllocReplenOo> apsAllocReplenOos) {
//		this.apsAllocReplenOos = apsAllocReplenOos;
//	}
//
//	public void setApsAllocReplenSss(List<ApsAllocReplenSs> apsAllocReplenSss) {
//		this.apsAllocReplenSss = apsAllocReplenSss;
//	}
//
//	public void setApsAllocReplenWos(List<ApsAllocReplenWo> apsAllocReplenWos) {
//		this.apsAllocReplenWos = apsAllocReplenWos;
//	}
//
//	public void setApsAllocWoFcs(List<ApsAllocWoFc> apsAllocWoFcs) {
//		this.apsAllocWoFcs = apsAllocWoFcs;
//	}
//
//	public void setApsAllocWoOos(List<ApsAllocWoOo> apsAllocWoOos) {
//		this.apsAllocWoOos = apsAllocWoOos;
//	}
//
//	public void setApsAllocWoSss(List<ApsAllocWoSs> apsAllocWoSss) {
//		this.apsAllocWoSss = apsAllocWoSss;
//	}
//
//	public void setApsAllocWoWos(List<ApsAllocWoWo> apsAllocWoWos) {
//		this.apsAllocWoWos = apsAllocWoWos;
//	}
//
//	public void setApsAvailOnhands(List<ApsAvailOnhand> apsAvailOnhands) {
//		this.apsAvailOnhands = apsAvailOnhands;
//	}
//
//	public void setApsAvailReplens(List<ApsAvailReplen> apsAvailReplens) {
//		this.apsAvailReplens = apsAvailReplens;
//	}
//
//	public void setApsAvailWos(List<ApsAvailWo> apsAvailWos) {
//		this.apsAvailWos = apsAvailWos;
//	}
//
//	// public void setApsCustMfrVws(List<ApsCustMfrVw> apsCustMfrVws) {
//	// this.apsCustMfrVws = apsCustMfrVws;
//	// }
//	public void setApsDmdFcs(List<ApsDmdFc> apsDmdFcs) {
//		this.apsDmdFcs = apsDmdFcs;
//	}
//
//	public void setApsDmdOos(List<ApsDmdOo> apsDmdOos) {
//		this.apsDmdOos = apsDmdOos;
//	}
//
//	public void setApsDmdSss(List<ApsDmdSs> apsDmdSss) {
//		this.apsDmdSss = apsDmdSss;
//	}
//
//	public void setApsDmdWos(List<ApsDmdWo> apsDmdWos) {
//		this.apsDmdWos = apsDmdWos;
//	}
//
//	public void setApsItemGlobalSubsts(List<ApsItemGlobalSubst> apsItemGlobalSubsts) {
//		this.apsItemGlobalSubsts = apsItemGlobalSubsts;
//	}
//
//	public void setApsSplySubPools(Collection<ApsSplySubPool> apsSplySubPools) {
//		this.apsSplySubPools = apsSplySubPools;
//	}
//
//	public void setApsSrcRules(Collection<ApsSrcRule> apsSrcRules) {
//		this.apsSrcRules = apsSrcRules;
//	}
//
//	public void setApsSrcRuleSets(Collection<ApsSrcRuleSet> apsSrcRuleSets) {
//		this.apsSrcRuleSets = apsSrcRuleSets;
//	}
//
//	public void setFcItemMasts(List<FcItemMast> fcItemMasts) {
//		this.fcItemMasts = fcItemMasts;
//	}
//
//	public void setFcstGrps(List<FcstGrp> fcstGrps) {
//		this.fcstGrps = fcstGrps;
//	}
//
//	public void setIcCertCds(List<IcCertCd> icCertCds) {
//		this.icCertCds = icCertCds;
//	}
//
//	public void setIcItemCustsSubsts(List<IcItemCustSubst> icItemCustsSubsts) {
//		this.icItemCustsSubsts = icItemCustsSubsts;
//	}
//
//	public void setIcItemMastEquivs(List<IcItemMastEquiv> icItemMastEquivs) {
//		this.icItemMastEquivs = icItemMastEquivs;
//	}
//
//	public void setIcItemMasts(List<IcItemMast> list) {
//		this.icItemMasts = list;
//	}
//
//
//	public void setOeCustMfrs(List<OeCustMfr> oeCustMfrs) {
//		this.oeCustMfrs = oeCustMfrs;
//	}
//
//	public void setOeOrdDtlCerts(List<OeOrdDtlCert> oeOrdDtlCerts) {
//		this.oeOrdDtlCerts = oeOrdDtlCerts;
//	}
//
//	public void setTmpItems(List<TmpItem> tmpItems) {
//		this.tmpItems = tmpItems;
//	}
//
//	public List<UtFacility> getUtFacilities() {
//		return utFacilities;
//	}
//
//	public void setUtFacilities(List<UtFacility> utFacilities) {
//		this.utFacilities = utFacilities;
//	}
//	
//	public Collection<ApsSrcRulePrimary> getApsSrcRulePrimarys() {
//		return apsSrcRulePrimarys;
//	}
//
//	public void setApsSrcRulePrimarys(Collection<ApsSrcRulePrimary> collection) {
//		this.apsSrcRulePrimarys = collection;
//	}
//
//	public Date getEffectiveDate() {
//		return effectiveDate;
//	}
//
//	public void setEffectiveDate(Date effectiveDate) {
//		this.effectiveDate = effectiveDate;
//	}
}
