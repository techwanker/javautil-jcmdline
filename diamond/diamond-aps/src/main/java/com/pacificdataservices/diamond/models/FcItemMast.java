package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * FcItemMast generated by hbm2java
 */
@Entity
@Table(name="FC_ITEM_MAST"
)
public class FcItemMast  implements java.io.Serializable {


     private int fcItemMastNbr;
     private ApsSrcRuleSet apsSrcRuleSet;
     private PoMfrMast poMfrMast;
     private OeCustMast oeCustMast;
     private String fcstGrp;
     private FcBuildRateGrp fcBuildRateGrp;
     private int itemNbr;
     private IcItemMast icItemMast;
     private BigDecimal svcLvl;
     private BigDecimal totLeadTime;
     private BigDecimal safetyStkMinPrd;
     private BigDecimal safetyStkMaxPrd;
     private Integer safetyStkMinUnit;
     private Integer safetyStkMaxUnit;
     private Integer replenQtyMinUnit;
     private Integer replenQtyMaxUnit;
     private BigDecimal replenQtyMinPrd;
     private BigDecimal replenQtyMaxPrd;
     private String storeAltFcstFlg;
     private String archAltFcstFlg;
     private String calendar;
     private String fcstMdlGrp;
     private String statId;
     private BigDecimal safetyStkAdj;
     private String fcstTypeId;
     private String revLvl;
     private String fcItemMastStatId;
     private String fcItemMastDescr;
     private BigDecimal safetyStkAllocQty;
     private Date fcstEndDt;
     private String custRefCd;
     private String safetyStkAvailToSell;
     private String hardAllocFcWithinLeadTm;
     private Set<FcHist> fcHists = new HashSet<FcHist>(0);
     private Set<FcAdj> fcAdjs = new HashSet<FcAdj>(0);
     private Set<IdlFcFcst> idlFcFcsts = new HashSet<IdlFcFcst>(0);
     //private Set<FcAggrMast> fcAggrMasts = new HashSet<FcAggrMast>(0);
     private Set<FcItemAttr> fcItemAttrs = new HashSet<FcItemAttr>(0);
     private Set<ApsAllocWoSs> apsAllocWoSses = new HashSet<ApsAllocWoSs>(0);
     private Set<FcFcst> fcFcsts = new HashSet<FcFcst>(0);
     //private FcQueue fcQueue;

    public FcItemMast() {
    }

	
   
     @Id 

    
    @Column(name="FC_ITEM_MAST_NBR", unique=true, nullable=false, precision=9, scale=0)
    public int getFcItemMastNbr() {
        return this.fcItemMastNbr;
    }
    
    public void setFcItemMastNbr(int fcItemMastNbr) {
        this.fcItemMastNbr = fcItemMastNbr;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="APS_SRC_RULE_SET_NBR", nullable=false)
    public ApsSrcRuleSet getApsSrcRuleSet() {
        return this.apsSrcRuleSet;
    }
    
    public void setApsSrcRuleSet(ApsSrcRuleSet apsSrcRuleSet) {
        this.apsSrcRuleSet = apsSrcRuleSet;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ORG_NBR_MFR_RQST")
    public PoMfrMast getPoMfrMast() {
        return this.poMfrMast;
    }
    
    public void setPoMfrMast(PoMfrMast poMfrMast) {
        this.poMfrMast = poMfrMast;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ORG_NBR_CUST", nullable=false)
    public OeCustMast getOeCustMast() {
        return this.oeCustMast;
    }
    
    public void setOeCustMast(OeCustMast oeCustMast) {
        this.oeCustMast = oeCustMast;
    }
    

    @Column(name="FCST_GRP")
    public  String getFcstGrp() {
    	return fcstGrp;
    }
    
    public void setFcstGrp(String val) {
    	this.fcstGrp= val;
    }

//@ManyToOne(fetch=FetchType.LAZY)
//    @JoinColumn(name="FCST_GRP", nullable=false)
//    public FcstGrp getFcstGrp() {
//        return this.fcstGrp;
//    }
//    
//    public void setFcstGrp(FcstGrp fcstGrp) {
//        this.fcstGrp = fcstGrp;
//    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="FC_BUILD_RATE_GRP_CD")
    public FcBuildRateGrp getFcBuildRateGrp() {
        return this.fcBuildRateGrp;
    }
    
    public void setFcBuildRateGrp(FcBuildRateGrp fcBuildRateGrp) {
        this.fcBuildRateGrp = fcBuildRateGrp;
    }
    
    @Column(name="ITEM_NBR")
    public int getItemNbr()  {
    	return itemNbr;
    }
    
    public void setItemNbr(int itemNbr) {
    	this.itemNbr = itemNbr;
    }
//
//@ManyToOne(fetch=FetchType.LAZY)
//    @JoinColumn(name="ITEM_NBR", nullable=false)
//    public IcItemMast getIcItemMast() {
//        return this.icItemMast;
//    }
//    
//    public void setIcItemMast(IcItemMast icItemMast) {
//        this.icItemMast = icItemMast;
//    }

    
    @Column(name="SVC_LVL", precision=2)
    public BigDecimal getSvcLvl() {
        return this.svcLvl;
    }
    
    public void setSvcLvl(BigDecimal svcLvl) {
        this.svcLvl = svcLvl;
    }

    
    @Column(name="TOT_LEAD_TIME", nullable=false, precision=22, scale=0)
    public BigDecimal getTotLeadTime() {
        return this.totLeadTime;
    }
    
    public void setTotLeadTime(BigDecimal totLeadTime) {
        this.totLeadTime = totLeadTime;
    }

    
    @Column(name="SAFETY_STK_MIN_PRD", precision=3, scale=1)
    public BigDecimal getSafetyStkMinPrd() {
        return this.safetyStkMinPrd;
    }
    
    public void setSafetyStkMinPrd(BigDecimal safetyStkMinPrd) {
        this.safetyStkMinPrd = safetyStkMinPrd;
    }

    
    @Column(name="SAFETY_STK_MAX_PRD", precision=3, scale=1)
    public BigDecimal getSafetyStkMaxPrd() {
        return this.safetyStkMaxPrd;
    }
    
    public void setSafetyStkMaxPrd(BigDecimal safetyStkMaxPrd) {
        this.safetyStkMaxPrd = safetyStkMaxPrd;
    }

    
    @Column(name="SAFETY_STK_MIN_UNIT", precision=8, scale=0)
    public Integer getSafetyStkMinUnit() {
        return this.safetyStkMinUnit;
    }
    
    public void setSafetyStkMinUnit(Integer safetyStkMinUnit) {
        this.safetyStkMinUnit = safetyStkMinUnit;
    }

    
    @Column(name="SAFETY_STK_MAX_UNIT", precision=8, scale=0)
    public Integer getSafetyStkMaxUnit() {
        return this.safetyStkMaxUnit;
    }
    
    public void setSafetyStkMaxUnit(Integer safetyStkMaxUnit) {
        this.safetyStkMaxUnit = safetyStkMaxUnit;
    }

    
    @Column(name="REPLEN_QTY_MIN_UNIT", precision=8, scale=0)
    public Integer getReplenQtyMinUnit() {
        return this.replenQtyMinUnit;
    }
    
    public void setReplenQtyMinUnit(Integer replenQtyMinUnit) {
        this.replenQtyMinUnit = replenQtyMinUnit;
    }

    
    @Column(name="REPLEN_QTY_MAX_UNIT", precision=8, scale=0)
    public Integer getReplenQtyMaxUnit() {
        return this.replenQtyMaxUnit;
    }
    
    public void setReplenQtyMaxUnit(Integer replenQtyMaxUnit) {
        this.replenQtyMaxUnit = replenQtyMaxUnit;
    }

    
    @Column(name="REPLEN_QTY_MIN_PRD", precision=4, scale=1)
    public BigDecimal getReplenQtyMinPrd() {
        return this.replenQtyMinPrd;
    }
    
    public void setReplenQtyMinPrd(BigDecimal replenQtyMinPrd) {
        this.replenQtyMinPrd = replenQtyMinPrd;
    }

    
    @Column(name="REPLEN_QTY_MAX_PRD", precision=4, scale=1)
    public BigDecimal getReplenQtyMaxPrd() {
        return this.replenQtyMaxPrd;
    }
    
    public void setReplenQtyMaxPrd(BigDecimal replenQtyMaxPrd) {
        this.replenQtyMaxPrd = replenQtyMaxPrd;
    }

    
    @Column(name="STORE_ALT_FCST_FLG", length=1)
    public String getStoreAltFcstFlg() {
        return this.storeAltFcstFlg;
    }
    
    public void setStoreAltFcstFlg(String storeAltFcstFlg) {
        this.storeAltFcstFlg = storeAltFcstFlg;
    }

    
    @Column(name="ARCH_ALT_FCST_FLG", length=1)
    public String getArchAltFcstFlg() {
        return this.archAltFcstFlg;
    }
    
    public void setArchAltFcstFlg(String archAltFcstFlg) {
        this.archAltFcstFlg = archAltFcstFlg;
    }

    
    @Column(name="CALENDAR", length=6)
    public String getCalendar() {
        return this.calendar;
    }
    
    public void setCalendar(String calendar) {
        this.calendar = calendar;
    }

    
    @Column(name="FCST_MDL_GRP", length=8)
    public String getFcstMdlGrp() {
        return this.fcstMdlGrp;
    }
    
    public void setFcstMdlGrp(String fcstMdlGrp) {
        this.fcstMdlGrp = fcstMdlGrp;
    }

    
    @Column(name="STAT_ID", length=1)
    public String getStatId() {
        return this.statId;
    }
    
    public void setStatId(String statId) {
        this.statId = statId;
    }

    
    @Column(name="SAFETY_STK_ADJ", precision=13, scale=5)
    public BigDecimal getSafetyStkAdj() {
        return this.safetyStkAdj;
    }
    
    public void setSafetyStkAdj(BigDecimal safetyStkAdj) {
        this.safetyStkAdj = safetyStkAdj;
    }

    
    @Column(name="FCST_TYPE_ID", nullable=false, length=1)
    public String getFcstTypeId() {
        return this.fcstTypeId;
    }
    
    public void setFcstTypeId(String fcstTypeId) {
        this.fcstTypeId = fcstTypeId;
    }

    
    @Column(name="REV_LVL", length=5)
    public String getRevLvl() {
        return this.revLvl;
    }
    
    public void setRevLvl(String revLvl) {
        this.revLvl = revLvl;
    }

    
    @Column(name="FC_ITEM_MAST_STAT_ID", nullable=false, length=1)
    public String getFcItemMastStatId() {
        return this.fcItemMastStatId;
    }
    
    public void setFcItemMastStatId(String fcItemMastStatId) {
        this.fcItemMastStatId = fcItemMastStatId;
    }

    
    @Column(name="FC_ITEM_MAST_DESCR", length=30)
    public String getFcItemMastDescr() {
        return this.fcItemMastDescr;
    }
    
    public void setFcItemMastDescr(String fcItemMastDescr) {
        this.fcItemMastDescr = fcItemMastDescr;
    }

    
    @Column(name="SAFETY_STK_ALLOC_QTY", precision=13, scale=5)
    public BigDecimal getSafetyStkAllocQty() {
        return this.safetyStkAllocQty;
    }
    
    public void setSafetyStkAllocQty(BigDecimal safetyStkAllocQty) {
        this.safetyStkAllocQty = safetyStkAllocQty;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="FCST_END_DT", length=7)
    public Date getFcstEndDt() {
        return this.fcstEndDt;
    }
    
    public void setFcstEndDt(Date fcstEndDt) {
        this.fcstEndDt = fcstEndDt;
    }

    
    @Column(name="CUST_REF_CD", length=40)
    public String getCustRefCd() {
        return this.custRefCd;
    }
    
    public void setCustRefCd(String custRefCd) {
        this.custRefCd = custRefCd;
    }

    
    @Column(name="SAFETY_STK_AVAIL_TO_SELL", nullable=false, length=1)
    public String getSafetyStkAvailToSell() {
        return this.safetyStkAvailToSell;
    }
    
    public void setSafetyStkAvailToSell(String safetyStkAvailToSell) {
        this.safetyStkAvailToSell = safetyStkAvailToSell;
    }

    
    @Column(name="HARD_ALLOC_FC_WITHIN_LEAD_TM", nullable=false, length=1)
    public String getHardAllocFcWithinLeadTm() {
        return this.hardAllocFcWithinLeadTm;
    }
    
    public void setHardAllocFcWithinLeadTm(String hardAllocFcWithinLeadTm) {
        this.hardAllocFcWithinLeadTm = hardAllocFcWithinLeadTm;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="fcItemMast")
    public Set<FcHist> getFcHists() {
        return this.fcHists;
    }
    
    public void setFcHists(Set<FcHist> fcHists) {
        this.fcHists = fcHists;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="fcItemMast")
    public Set<FcAdj> getFcAdjs() {
        return this.fcAdjs;
    }
    
    public void setFcAdjs(Set<FcAdj> fcAdjs) {
        this.fcAdjs = fcAdjs;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="fcItemMast")
    public Set<IdlFcFcst> getIdlFcFcsts() {
        return this.idlFcFcsts;
    }
    
    public void setIdlFcFcsts(Set<IdlFcFcst> idlFcFcsts) {
        this.idlFcFcsts = idlFcFcsts;
    }

//@ManyToMany(fetch=FetchType.LAZY, mappedBy="fcItemMasts")
//    public Set<FcAggrMast> getFcAggrMasts() {
//        return this.fcAggrMasts;
//    }
//    
//    public void setFcAggrMasts(Set<FcAggrMast> fcAggrMasts) {
//        this.fcAggrMasts = fcAggrMasts;
//    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="fcItemMast")
    public Set<FcItemAttr> getFcItemAttrs() {
        return this.fcItemAttrs;
    }
    
    public void setFcItemAttrs(Set<FcItemAttr> fcItemAttrs) {
        this.fcItemAttrs = fcItemAttrs;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="fcItemMast")
    public Set<ApsAllocWoSs> getApsAllocWoSses() {
        return this.apsAllocWoSses;
    }
    
    public void setApsAllocWoSses(Set<ApsAllocWoSs> apsAllocWoSses) {
        this.apsAllocWoSses = apsAllocWoSses;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="fcItemMast")
    public Set<FcFcst> getFcFcsts() {
        return this.fcFcsts;
    }
    
    public void setFcFcsts(Set<FcFcst> fcFcsts) {
        this.fcFcsts = fcFcsts;
    }
//
//@OneToOne(fetch=FetchType.LAZY, mappedBy="fcItemMast")
//    public FcQueue getFcQueue() {
//        return this.fcQueue;
//    }
//    
//    public void setFcQueue(FcQueue fcQueue) {
//        this.fcQueue = fcQueue;
//    }




}

