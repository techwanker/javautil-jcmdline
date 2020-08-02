package com.pacificdataservices.diamond.planning.json;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.javautil.util.Timer;
import org.javautil.hibernate.HibernateMarshallerFactory;
import org.javautil.io.IOUtils;
import org.javautil.json.JsonSerializerGson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.pacificdataservices.diamond.models.ApsAllocOnhandFc;
import com.pacificdataservices.diamond.models.ApsAllocOnhandOo;
import com.pacificdataservices.diamond.models.ApsAllocOnhandSs;
import com.pacificdataservices.diamond.models.ApsAllocOnhandWo;
import com.pacificdataservices.diamond.models.ApsAllocReplenFc;
import com.pacificdataservices.diamond.models.ApsAllocReplenOo;
import com.pacificdataservices.diamond.models.ApsAllocReplenSs;
import com.pacificdataservices.diamond.models.ApsAllocReplenWo;
import com.pacificdataservices.diamond.models.ApsAllocWoFc;
import com.pacificdataservices.diamond.models.ApsAllocWoOo;
import com.pacificdataservices.diamond.models.ApsAllocWoSs;
import com.pacificdataservices.diamond.models.ApsAllocWoWo;
import com.pacificdataservices.diamond.models.ApsAvailOnhand;
import com.pacificdataservices.diamond.models.ApsAvailReplen;
import com.pacificdataservices.diamond.models.ApsAvailWo;
//import com.pacificdataservices.diamond.models.ApsCustMfrVw;
import com.pacificdataservices.diamond.models.ApsDmdFc;
import com.pacificdataservices.diamond.models.ApsDmdOo;
import com.pacificdataservices.diamond.models.ApsDmdSs;
import com.pacificdataservices.diamond.models.ApsDmdWo;
import com.pacificdataservices.diamond.models.ApsItemGlobalSubst;
import com.pacificdataservices.diamond.models.ApsResultDtlDmd;
import com.pacificdataservices.diamond.models.ApsSplyPool;
import com.pacificdataservices.diamond.models.ApsSplySubPool;
import com.pacificdataservices.diamond.models.ApsSrcRule;
import com.pacificdataservices.diamond.models.ApsSrcRulePrimary;
import com.pacificdataservices.diamond.models.ApsSrcRuleSet;
//import com.pacificdataservices.diamond.models.ApsSupply;
import com.pacificdataservices.diamond.models.FcItemMast;
import com.pacificdataservices.diamond.models.FcstGrp;
import com.pacificdataservices.diamond.models.IcCertCd;
import com.pacificdataservices.diamond.models.IcItemCustSubst;
import com.pacificdataservices.diamond.models.IcItemMast;
import com.pacificdataservices.diamond.models.IcItemMastEquiv;
import com.pacificdataservices.diamond.models.NaOrg;
import com.pacificdataservices.diamond.models.OeCustMast;
import com.pacificdataservices.diamond.models.OeCustMfr;
import com.pacificdataservices.diamond.models.OeOrdDtlCert;
import com.pacificdataservices.diamond.models.OeOrdDtlHist;
import com.pacificdataservices.diamond.models.TmpItem;
import com.pacificdataservices.diamond.models.UtFacility;
import com.pacificdataservices.diamond.models.VqQteVw;
import com.pacificdataservices.diamond.planning.data.PlanningData;
import com.pacificdataservices.diamond.rules.CustomerItemManufacturerRules;

public class PlanningDataMarshallable {
	
	transient private static Logger logger = LoggerFactory.getLogger(PlanningDataMarshallable.class);
	private Date effectiveDate;
	private List<ApsAllocOnhandFc> apsAllocOnhandFcs;
	private List<ApsAllocOnhandOo> apsAllocOnhandOos;
	private List<ApsAllocOnhandSs> apsAllocOnhandSss;
	private List<ApsAllocOnhandWo> apsAllocOnhandWos;
	private List<ApsAllocReplenFc> apsAllocReplenFcs;
	// Replenishment Allocations
	private List<ApsAllocReplenOo> apsAllocReplenOos;
	private List<ApsAllocReplenSs> apsAllocReplenSss;
	private List<ApsAllocReplenWo> apsAllocReplenWos;
	// Work Order Allocations
	private List<ApsAllocWoFc> apsAllocWoFcs;
	private List<ApsAllocWoOo> apsAllocWoOos;
	private List<ApsAllocWoSs> apsAllocWoSss;
	private List<ApsAllocWoWo> apsAllocWoWos;
	private List<ApsAvailOnhand> apsAvailOnhands;
	private List<ApsAvailReplen> apsAvailReplens;
	private List<ApsAvailWo> apsAvailWos;
	// private List<ApsCustMfrVw> apsCustMfrVws;
	
	private List<ApsDmdFc> apsDmdFcs;
	private List<ApsDmdOo> apsDmdOos;
	private List<ApsDmdSs> apsDmdSss;
	private List<ApsDmdWo> apsDmdWos;
	private List<ApsItemGlobalSubst> apsItemGlobalSubsts;
	private ArrayList<ApsResultDtlDmd> apsResultDtlDmds;
	private Map<String,ApsSplyPool> apsSplyPoolById;
	// Blows up TODO
	private Collection<ApsSplySubPool> apsSplySubPools;
	private Collection<ApsSrcRule> apsSrcRules;
	// Blows up TODO
	private Collection<ApsSrcRuleSet> apsSrcRuleSets;
	
	private Collection<ApsSrcRulePrimary> apsSrcRulePrimarys;
	private List<FcItemMast> fcItemMasts;
	private List<FcstGrp> fcstGrps;
	private List<IcCertCd> icCertCds;
	private List<IcItemCustSubst> icItemCustsSubsts;
	private List<IcItemMastEquiv> icItemMastEquivs;
	private List<IcItemMast> icItemMasts;
	private Map<Integer, OeCustMast> oeCustMastById;
	private List<OeCustMfr> oeCustMfrs;
	private List<OeOrdDtlCert> oeOrdDtlCerts;
	private List<TmpItem> tmpItems;
	private List<UtFacility> utFacilities;
	private Map<Integer,NaOrg> naOrgById; //
	private List<VqQteVw> vqQteVws;
	private List<OeOrdDtlHist> oeOrdDtlHists;
	private Map<Integer,ArrayList<Integer>> itemNbrsByLotNbr;
	
	

	public PlanningDataMarshallable() {
	}
	
    /**
     * 	
     * @param jsonFile json create by PlanningDataMarshaller 
     * @return
     * @throws IOException
     */
    public static PlanningData planningDataFromFile (File jsonFile) throws IOException {
    	Timer t = new Timer();
	//	JsonSerializerGson dillon = new JsonSerializerGson();
		String json = IOUtils.readFileAsString(jsonFile.getAbsolutePath());
	    logger.info("unmarshall micros {}", t.getElapsedMicros());	
		return planningDataFromJson(json);
    }
	
    public static PlanningData planningDataFromJson(String json) throws IOException {
		PlanningDataMarshallable pdm = fromJson(json);
		return pdm.toPlanningData();
    }
    
    public static PlanningDataMarshallable fromFile(File file) throws IOException {
	//	JsonSerializerGson dillon = new JsonSerializerGson();
		return fromJson(IOUtils.readFileAsString(file.getAbsolutePath()));
    }
    
    public  PlanningData toPlanningData() throws IOException {
    	PlanningData pd = new PlanningData();
    	pd.setEffectiveDate(effectiveDate);
		pd.setApsAllocOnhandFcs(getApsAllocOnhandFcs());
		pd.setApsAllocOnhandOos(getApsAllocOnhandOos());
		pd.setApsAllocOnhandSss(getApsAllocOnhandSss());
		pd.setApsAllocOnhandWos(getApsAllocOnhandWos());
		pd.setApsAllocReplenFcs(getApsAllocReplenFcs());
		// setAllocations
		pd.setApsAllocReplenOos(getApsAllocReplenOos());
		pd.setApsAllocReplenSss(getApsAllocReplenSss());
		pd.setApsAllocReplenWos(getApsAllocReplenWos());
		pd.setApsAllocWoFcs(getApsAllocWoFcs());
		pd.setApsAllocWoOos(getApsAllocWoOos());
		pd.setApsAllocWoSss(getApsAllocWoSss());
		pd.setApsAllocWoWos(getApsAllocWoWos());
		//
		List<ApsAvailOnhand> apsAvailOnhands = getApsAvailOnhands();
		assertNotNull(apsAvailOnhands);
		pd.setApsAvailOnhands(getApsAvailOnhands());
		pd.setApsAvailReplens(getApsAvailReplens());
		pd.setApsAvailWos(getApsAvailWos());
		//
		pd.setApsDmdFcs(getApsDmdFcs());
		pd.setApsDmdOos(getApsDmdOos());
		pd.setApsDmdSss(getApsDmdSss());
		pd.setApsDmdWos(getApsDmdWos());
		//
		pd.setApsItemGlobalSubsts(getApsItemGlobalSubsts());
		pd.setApsResultDtlDmds(apsResultDtlDmds);
		pd.setApsSplySubPools(getApsSplySubPools());
		pd.setApsSrcRules(getApsSrcRules());
		pd.setApsSrcRuleSets(getApsSrcRuleSets());
		pd.setApsSrcRulePrimarys(getApsSrcRulePrimarys());
		pd.setApsSplyPools(apsSplyPoolById.values());
;		//
		pd.setFcItemMasts(getFcItemMasts());
		pd.setFcstGrps(getFcstGrps());
		pd.setIcCertCds(getIcCertCds());
		pd.setIcItemCustsSubsts(getIcItemCustsSubsts());
		pd.setIcItemMastEquivs(getIcItemMastEquivs());
		pd.setIcItemMasts(getIcItemMasts());
		pd.setOeCustMastById(oeCustMastById);
	
		pd.setOeOrdDtlCerts(getOeOrdDtlCerts());
		pd.setUtFacilities(utFacilities);
		pd.setTmpItems(getTmpItems());
		pd.setNaOrgById(naOrgById);
		pd.setVqQteVws(vqQteVws);
		pd.setOeOrdDtlHists(oeOrdDtlHists);
		pd.setOeCustMfrs(getOeCustMfrs());
		pd.setItemNbrsByLotNbr(itemNbrsByLotNbr);
		pd.buildMapsAndReferences();
		pd.setCustomerItemManufacturerRules(new CustomerItemManufacturerRules(pd.getOeCustMfrs()));
		pd.populateForecastBucketsByForecastGroup();
		pd.checkIntegrity();
		return pd;
    }
    
    public static PlanningDataMarshallable fromJson(String json) {
		JsonSerializerGson dillon = new JsonSerializerGson();
		PlanningDataMarshallable retval = (PlanningDataMarshallable) dillon.toObjectFromJson(json, PlanningDataMarshallable.class);
		return retval;
    }
    
	public PlanningDataMarshallable(PlanningData pd) {
		if (pd == null) {
			throw new IllegalArgumentException("pd is null");
		}
		effectiveDate     = pd.getEffectiveDate();
		apsAllocOnhandFcs = pd.getApsAllocOnhandFcs();
		apsAllocOnhandOos = pd.getApsAllocOnhandOos();
		apsAllocOnhandSss = pd.getApsAllocOnhandSss();
		apsAllocOnhandWos = pd.getApsAllocOnhandWos();
		apsAllocReplenFcs = pd.getApsAllocReplenFcs();
		// setAllocations
		apsAllocReplenOos = pd.getApsAllocReplenOos();
		apsAllocReplenSss = pd.getApsAllocReplenSss();
		setApsAllocReplenWos(pd.getApsAllocReplenWos());
		setApsAllocWoFcs(pd.getApsAllocWoFcs());
		setApsAllocWoOos(pd.getApsAllocWoOos());
		setApsAllocWoSss(pd.getApsAllocWoSss());
		setApsAllocWoWos(pd.getApsAllocWoWos());
		setApsAvailOnhands(pd.getApsAvailOnhands());
		setApsAvailReplens(pd.getApsAvailReplens());
		setApsAvailWos(pd.getApsAvailWos());
		// setApsCustMfrVws(pd.getApsCustMfrVws());
		setApsDmdFcs(pd.getApsDmdFcs());
		setApsDmdOos(pd.getApsDmdOos());
		setApsDmdSss(pd.getApsDmdSss());
		setApsDmdWos(pd.getApsDmdWos());
		setApsItemGlobalSubsts(pd.getApsItemGlobalSubsts());
		apsResultDtlDmds = pd.getApsResultDtlDmds();
		
		apsSplyPoolById = pd.getApsSplyPoolById();
		setApsSplySubPools(pd.getApsSplySubPools());
		setApsSrcRules(pd.getApsSrcRules());
		apsSrcRulePrimarys = pd.getApsSrcRulePrimaryById().values();
		setApsSrcRuleSets(pd.getApsSrcRuleSets());
		setFcItemMasts(pd.getFcItemMasts());
		setFcstGrps(pd.getFcstGrps());
		setIcCertCds(pd.getIcCertCds());
		setIcItemCustsSubsts(pd.getIcItemCustsSubsts());
		setIcItemMastEquivs(pd.getIcItemMastEquivs());
		// TODO WTF?
		ArrayList<IcItemMast> icItemMasts = new ArrayList<IcItemMast>();
		icItemMasts.addAll(pd.getIcItemMasts());
		setIcItemMasts(icItemMasts);
		//
		oeCustMastById =pd.getOeCustMastById();
		setOeCustMfrs(pd.getOeCustMfrs());
		setOeOrdDtlCerts(pd.getOeOrdDtlCerts());
		setUtFacilities(pd.getUtFacilities());
		naOrgById = pd.getNaOrgById();
		vqQteVws = pd.getVqQteVws();
		oeOrdDtlHists = pd.getOeOrdDtlHists();
		itemNbrsByLotNbr = pd.getItemNbrsByLotNbr();
	}

	

	public <t> List<t> trimToOne(Collection<t> coll) {
		List<t> target = null;
		if (coll != null) {
			target = new ArrayList<t>();
			target.addAll(coll);
			target = trimToOne(target);
		}
		return target;
	}

	public void writeToFile(File f) throws IOException {
		logger.info("writing to {}",f.getCanonicalFile());
		//logger.info("apsResultDtlDmds.size(): {}", apsResultDtlDmds.size());
		Gson dillon  = HibernateMarshallerFactory.getHibernateGsonWithProxyDateFormatter();
		IOUtils.writeString(f,dillon.toJson(this));
	}
	
	public String toJson() {
		Gson dillon  = HibernateMarshallerFactory.getHibernateGsonWithProxyDateFormatter();
		String retval = dillon.toJson(this);
		return retval;
	}

	public List<ApsAllocOnhandFc> getApsAllocOnhandFcs() {
		return apsAllocOnhandFcs;
	}

	public List<ApsAllocOnhandOo> getApsAllocOnhandOos() {
		return apsAllocOnhandOos;
	}

	public List<ApsAllocOnhandSs> getApsAllocOnhandSss() {
		return apsAllocOnhandSss;
	}

	public List<ApsAllocOnhandWo> getApsAllocOnhandWos() {
		return apsAllocOnhandWos;
	}

	public List<ApsAllocReplenFc> getApsAllocReplenFcs() {
		return apsAllocReplenFcs;
	}

	public List<ApsAllocReplenOo> getApsAllocReplenOos() {
		return apsAllocReplenOos;
	}

	public List<ApsAllocReplenSs> getApsAllocReplenSss() {
		return apsAllocReplenSss;
	}

	public List<ApsAllocReplenWo> getApsAllocReplenWos() {
		return apsAllocReplenWos;
	}

	public List<ApsAllocWoFc> getApsAllocWoFcs() {
		return apsAllocWoFcs;
	}

	public List<ApsAllocWoOo> getApsAllocWoOos() {
		return apsAllocWoOos;
	}

	public List<ApsAllocWoSs> getApsAllocWoSss() {
		return apsAllocWoSss;
	}

	public List<ApsAllocWoWo> getApsAllocWoWos() {
		return apsAllocWoWos;
	}

	public List<ApsAvailOnhand> getApsAvailOnhands() {
		return apsAvailOnhands;
	}

	public List<ApsAvailReplen> getApsAvailReplens() {
		return apsAvailReplens;
	}

	public List<ApsAvailWo> getApsAvailWos() {
		return apsAvailWos;
	
	}
	public List<ApsDmdFc> getApsDmdFcs() {
		return apsDmdFcs;
	}

	public List<ApsDmdOo> getApsDmdOos() {
		return apsDmdOos;
	}

	public List<ApsDmdSs> getApsDmdSss() {
		return apsDmdSss;
	}

	public List<ApsDmdWo> getApsDmdWos() {
		return apsDmdWos;
	}

	public List<ApsItemGlobalSubst> getApsItemGlobalSubsts() {
		return apsItemGlobalSubsts;
	}

	public Collection<ApsSplySubPool> getApsSplySubPools() {
		return apsSplySubPools;
	}

	public Collection<ApsSrcRule> getApsSrcRules() {
		return apsSrcRules;
	}

	public Collection<ApsSrcRuleSet> getApsSrcRuleSets() {
		return apsSrcRuleSets;
	}

	public List<FcItemMast> getFcItemMasts() {
		return fcItemMasts;
	}

	public List<FcstGrp> getFcstGrps() {
		return fcstGrps;
	}

	public List<IcCertCd> getIcCertCds() {
		return icCertCds;
	}

	public List<IcItemCustSubst> getIcItemCustsSubsts() {
		return icItemCustsSubsts;
	}

	public List<IcItemMastEquiv> getIcItemMastEquivs() {
		return icItemMastEquivs;
	}

	public List<IcItemMast> getIcItemMasts() {
		return icItemMasts;
	}


	public List<OeCustMfr> getOeCustMfrs() {
		return oeCustMfrs;
	}

	public List<OeOrdDtlCert> getOeOrdDtlCerts() {
		return oeOrdDtlCerts;
	}

	public List<TmpItem> getTmpItems() {
		return tmpItems;
	}

	public void setApsAllocOnhandFcs(List<ApsAllocOnhandFc> apsAllocOnhandFcs) {
		this.apsAllocOnhandFcs = apsAllocOnhandFcs;
	}

	public void setApsAllocOnhandOos(List<ApsAllocOnhandOo> apsAllocOnhandOos) {
		this.apsAllocOnhandOos = apsAllocOnhandOos;
	}

	public void setApsAllocOnhandSss(List<ApsAllocOnhandSs> apsAllocOnhandSss) {
		this.apsAllocOnhandSss = apsAllocOnhandSss;
	}

	public void setApsAllocOnhandWos(List<ApsAllocOnhandWo> apsAllocOnhandWos) {
		this.apsAllocOnhandWos = apsAllocOnhandWos;
	}

	public void setApsAllocReplenFcs(List<ApsAllocReplenFc> apsAllocReplenFcs) {
		this.apsAllocReplenFcs = apsAllocReplenFcs;
	}

	public void setApsAllocReplenOos(List<ApsAllocReplenOo> apsAllocReplenOos) {
		this.apsAllocReplenOos = apsAllocReplenOos;
	}

	public void setApsAllocReplenSss(List<ApsAllocReplenSs> apsAllocReplenSss) {
		this.apsAllocReplenSss = apsAllocReplenSss;
	}

	public void setApsAllocReplenWos(List<ApsAllocReplenWo> apsAllocReplenWos) {
		this.apsAllocReplenWos = apsAllocReplenWos;
	}

	public void setApsAllocWoFcs(List<ApsAllocWoFc> apsAllocWoFcs) {
		this.apsAllocWoFcs = apsAllocWoFcs;
	}

	public void setApsAllocWoOos(List<ApsAllocWoOo> apsAllocWoOos) {
		this.apsAllocWoOos = apsAllocWoOos;
	}

	public void setApsAllocWoSss(List<ApsAllocWoSs> apsAllocWoSss) {
		this.apsAllocWoSss = apsAllocWoSss;
	}

	public void setApsAllocWoWos(List<ApsAllocWoWo> apsAllocWoWos) {
		this.apsAllocWoWos = apsAllocWoWos;
	}

	public void setApsAvailOnhands(List<ApsAvailOnhand> apsAvailOnhands) {
		this.apsAvailOnhands = apsAvailOnhands;
	}

	public void setApsAvailReplens(List<ApsAvailReplen> apsAvailReplens) {
		this.apsAvailReplens = apsAvailReplens;
	}

	public void setApsAvailWos(List<ApsAvailWo> apsAvailWos) {
		this.apsAvailWos = apsAvailWos;
	}

	// public void setApsCustMfrVws(List<ApsCustMfrVw> apsCustMfrVws) {
	// this.apsCustMfrVws = apsCustMfrVws;
	// }
	public void setApsDmdFcs(List<ApsDmdFc> apsDmdFcs) {
		this.apsDmdFcs = apsDmdFcs;
	}

	public void setApsDmdOos(List<ApsDmdOo> apsDmdOos) {
		this.apsDmdOos = apsDmdOos;
	}

	public void setApsDmdSss(List<ApsDmdSs> apsDmdSss) {
		this.apsDmdSss = apsDmdSss;
	}

	public void setApsDmdWos(List<ApsDmdWo> apsDmdWos) {
		this.apsDmdWos = apsDmdWos;
	}

	public void setApsItemGlobalSubsts(List<ApsItemGlobalSubst> apsItemGlobalSubsts) {
		this.apsItemGlobalSubsts = apsItemGlobalSubsts;
	}

	public void setApsSplySubPools(Collection<ApsSplySubPool> apsSplySubPools) {
		this.apsSplySubPools = apsSplySubPools;
	}

	public void setApsSrcRules(Collection<ApsSrcRule> apsSrcRules) {
		this.apsSrcRules = apsSrcRules;
	}

	public void setApsSrcRuleSets(Collection<ApsSrcRuleSet> apsSrcRuleSets) {
		this.apsSrcRuleSets = apsSrcRuleSets;
	}

	public void setFcItemMasts(List<FcItemMast> fcItemMasts) {
		this.fcItemMasts = fcItemMasts;
	}

	public void setFcstGrps(List<FcstGrp> fcstGrps) {
		this.fcstGrps = fcstGrps;
	}

	public void setIcCertCds(List<IcCertCd> icCertCds) {
		this.icCertCds = icCertCds;
	}

	public void setIcItemCustsSubsts(List<IcItemCustSubst> icItemCustsSubsts) {
		this.icItemCustsSubsts = icItemCustsSubsts;
	}

	public void setIcItemMastEquivs(List<IcItemMastEquiv> icItemMastEquivs) {
		this.icItemMastEquivs = icItemMastEquivs;
	}

	public void setIcItemMasts(List<IcItemMast> list) {
		this.icItemMasts = list;
	}


	public void setOeCustMfrs(List<OeCustMfr> oeCustMfrs) {
		this.oeCustMfrs = oeCustMfrs;
	}

	public void setOeOrdDtlCerts(List<OeOrdDtlCert> oeOrdDtlCerts) {
		this.oeOrdDtlCerts = oeOrdDtlCerts;
	}

	public void setTmpItems(List<TmpItem> tmpItems) {
		this.tmpItems = tmpItems;
	}

	public List<UtFacility> getUtFacilities() {
		return utFacilities;
	}

	public void setUtFacilities(List<UtFacility> utFacilities) {
		this.utFacilities = utFacilities;
	}
	
	public Collection<ApsSrcRulePrimary> getApsSrcRulePrimarys() {
		return apsSrcRulePrimarys;
	}

	public void setApsSrcRulePrimarys(Collection<ApsSrcRulePrimary> collection) {
		this.apsSrcRulePrimarys = collection;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	/**
	 * @return the vqQteVws
	 */
	public List<VqQteVw> getVqQteVws() {
		return vqQteVws;
	}

	/**
	 * @param vqQteVws the vqQteVws to set
	 */
	public void setVqQteVws(List<VqQteVw> vqQteVws) {
		this.vqQteVws = vqQteVws;
	}

	/**
	 * @return the itemNbrsByLotNbr
	 */
	public Map<Integer, ArrayList<Integer>> getItemNbrsByLotNbr() {
		return itemNbrsByLotNbr;
	}

	/**
	 * @param itemNbrsByLotNbr the itemNbrsByLotNbr to set
	 */
	public void setItemNbrsByLotNbr(Map<Integer, ArrayList<Integer>> itemNbrsByLotNbr) {
		this.itemNbrsByLotNbr = itemNbrsByLotNbr;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PlanningDataMarshallable [effectiveDate=");
		builder.append(effectiveDate);
		builder.append("\n apsAllocOnhandFcs=");
		builder.append(apsAllocOnhandFcs);
		builder.append("\n apsAllocOnhandOos=");
		builder.append(apsAllocOnhandOos);
		builder.append("\n apsAllocOnhandSss=");
		builder.append(apsAllocOnhandSss);
		builder.append("\n apsAllocOnhandWos=");
		builder.append(apsAllocOnhandWos);
		builder.append("\n apsAllocReplenFcs=");
		builder.append(apsAllocReplenFcs);
		builder.append("\n apsAllocReplenOos=");
		builder.append(apsAllocReplenOos);
		builder.append("\n apsAllocReplenSss=");
		builder.append(apsAllocReplenSss);
		builder.append("\n apsAllocReplenWos=");
		builder.append(apsAllocReplenWos);
		builder.append("\n apsAllocWoFcs=");
		builder.append(apsAllocWoFcs);
		builder.append("\n apsAllocWoOos=");
		builder.append(apsAllocWoOos);
		builder.append("\n apsAllocWoSss=");
		builder.append(apsAllocWoSss);
		builder.append("\n apsAllocWoWos=");
		builder.append(apsAllocWoWos);
		builder.append("\n apsAvailOnhands=");
		builder.append(apsAvailOnhands);
		builder.append("\n apsAvailReplens=");
		builder.append(apsAvailReplens);
		builder.append("\n apsAvailWos=");
		builder.append(apsAvailWos);
		builder.append("\n apsDmdFcs=");
		builder.append(apsDmdFcs);
		builder.append("\n apsDmdOos=");
		builder.append(apsDmdOos);
		builder.append("\n apsDmdSss=");
		builder.append(apsDmdSss);
		builder.append("\n apsDmdWos=");
		builder.append(apsDmdWos);
		builder.append("\n apsItemGlobalSubsts=");
		builder.append(apsItemGlobalSubsts);
		builder.append("\n apsResultDtlDmds=");
		builder.append(apsResultDtlDmds);
		builder.append("\n apsSplyPoolById=");
		builder.append(apsSplyPoolById);
		builder.append("\n apsSplySubPools=");
		builder.append(apsSplySubPools);
		builder.append("\n apsSrcRules=");
		builder.append(apsSrcRules);
		builder.append("\n apsSrcRuleSets=");
		builder.append(apsSrcRuleSets);
		builder.append("\n apsSrcRulePrimarys=");
		builder.append(apsSrcRulePrimarys);
		builder.append("\n fcItemMasts=");
		builder.append(fcItemMasts);
		builder.append("\n fcstGrps=");
		builder.append(fcstGrps);
		builder.append("\n icCertCds=");
		builder.append(icCertCds);
		builder.append("\n icItemCustsSubsts=");
		builder.append(icItemCustsSubsts);
		builder.append("\n icItemMastEquivs=");
		builder.append(icItemMastEquivs);
		builder.append("\n icItemMasts=");
		builder.append(icItemMasts);
		builder.append("\n oeCustMastById=");
		builder.append(oeCustMastById);
		builder.append("\n oeCustMfrs=");
		builder.append(oeCustMfrs);
		builder.append("\n oeOrdDtlCerts=");
		builder.append(oeOrdDtlCerts);
		builder.append("\n tmpItems=");
		builder.append(tmpItems);
		builder.append("\n utFacilities=");
		builder.append(utFacilities);
		builder.append("\n naOrgById=");
		builder.append(naOrgById);
		builder.append("\n vqQteVws=");
		builder.append(vqQteVws);
		builder.append("\n oeOrdDtlHists=");
		builder.append(oeOrdDtlHists);
		builder.append("\n itemNbrsByLotNbr=");
		builder.append(itemNbrsByLotNbr);
		builder.append("]");
		return builder.toString();
	}
}
