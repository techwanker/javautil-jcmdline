package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 5:38:54 AM by Hibernate Tools 5.4.1.Final


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
 * ApsSrcRuleSet generated by hbm2java
 */
@Entity
@Table(name="APS_SRC_RULE_SET"
)
public class ApsSrcRuleSet  implements java.io.Serializable {


     private int apsSrcRuleSetNbr;
     private ApsSplyPool apsSplyPool;
   //  private Integer apsSrcRuleNbrPrimary;
  //   private ApsSrcRule apsSrcRuleByApsSrcRuleNbrPrimary;
 //    private ApsSrcRule apsSrcRuleByApsSrcRuleNbrReplen;
     private UtFacility utFacility;
     private String apsSrcRuleSetCd;
     private String apsSrcRuleSetDescr;
     private int utUserNbr;
     private Date lastModDt;
     private String srcRuleSetStatId;
     private Set<WoHdr> woHdrs = new HashSet<WoHdr>(0);
     private Set<ApsSrcRule> apsSrcRules = new HashSet<ApsSrcRule>(0);
     private Set<ApsDmdRuleSetItem> apsDmdRuleSetItems = new HashSet<ApsDmdRuleSetItem>(0);
     private Set<FcItemMast> fcItemMasts = new HashSet<FcItemMast>(0);
     private Set<IcKitMast> icKitMasts = new HashSet<IcKitMast>(0);

    public ApsSrcRuleSet() {
    }

   
     @Id 
    @Column(name="APS_SRC_RULE_SET_NBR", unique=true, nullable=false, precision=9, scale=0)
    public int getApsSrcRuleSetNbr() {
        return this.apsSrcRuleSetNbr;
    }
    
    public void setApsSrcRuleSetNbr(int apsSrcRuleSetNbr) {
        this.apsSrcRuleSetNbr = apsSrcRuleSetNbr;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="APS_SPLY_POOL_CD_FCST_CONSUME", nullable=false)
    public ApsSplyPool getApsSplyPool() {
        return this.apsSplyPool;
    }
    
    public void setApsSplyPool(ApsSplyPool apsSplyPool) {
        this.apsSplyPool = apsSplyPool;
    }
//
//@ManyToOne(fetch=FetchType.LAZY)
//    @JoinColumn(name="APS_SRC_RULE_NBR_PRIMARY", insertable=false, updatable=false)
//    public ApsSrcRule getApsSrcRuleByApsSrcRuleNbrPrimary() {
//        return this.apsSrcRuleByApsSrcRuleNbrPrimary;
//    }
//    
//    public void setApsSrcRuleByApsSrcRuleNbrPrimary(ApsSrcRule apsSrcRuleByApsSrcRuleNbrPrimary) {
//        this.apsSrcRuleByApsSrcRuleNbrPrimary = apsSrcRuleByApsSrcRuleNbrPrimary;
//    }
//
//@ManyToOne(fetch=FetchType.LAZY)
//    @JoinColumn(name="APS_SRC_RULE_NBR_REPLEN")
//    public ApsSrcRule getApsSrcRuleByApsSrcRuleNbrReplen() {
//        return this.apsSrcRuleByApsSrcRuleNbrReplen;
//    }
//    
//    public void setApsSrcRuleByApsSrcRuleNbrReplen(ApsSrcRule apsSrcRuleByApsSrcRuleNbrReplen) {
//        this.apsSrcRuleByApsSrcRuleNbrReplen = apsSrcRuleByApsSrcRuleNbrReplen;
//    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="FACILITY_FCST_CONSUME", nullable=false)
    public UtFacility getUtFacility() {
        return this.utFacility;
    }
    
    public void setUtFacility(UtFacility utFacility) {
        this.utFacility = utFacility;
    }

    
    @Column(name="APS_SRC_RULE_SET_CD", unique=true, nullable=false, length=20)
    public String getApsSrcRuleSetCd() {
        return this.apsSrcRuleSetCd;
    }
    
    public void setApsSrcRuleSetCd(String apsSrcRuleSetCd) {
        this.apsSrcRuleSetCd = apsSrcRuleSetCd;
    }

    
    @Column(name="APS_SRC_RULE_SET_DESCR", length=60)
    public String getApsSrcRuleSetDescr() {
        return this.apsSrcRuleSetDescr;
    }
    
    public void setApsSrcRuleSetDescr(String apsSrcRuleSetDescr) {
        this.apsSrcRuleSetDescr = apsSrcRuleSetDescr;
    }

    
    @Column(name="UT_USER_NBR", nullable=false, precision=9, scale=0)
    public int getUtUserNbr() {
        return this.utUserNbr;
    }
    
    public void setUtUserNbr(int utUserNbr) {
        this.utUserNbr = utUserNbr;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="LAST_MOD_DT", nullable=false, length=7)
    public Date getLastModDt() {
        return this.lastModDt;
    }
    
    public void setLastModDt(Date lastModDt) {
        this.lastModDt = lastModDt;
    }

    
    @Column(name="SRC_RULE_SET_STAT_ID", nullable=false, length=1)
    public String getSrcRuleSetStatId() {
        return this.srcRuleSetStatId;
    }
    
    public void setSrcRuleSetStatId(String srcRuleSetStatId) {
        this.srcRuleSetStatId = srcRuleSetStatId;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="apsSrcRuleSet")
    public Set<WoHdr> getWoHdrs() {
        return this.woHdrs;
    }
    
    public void setWoHdrs(Set<WoHdr> woHdrs) {
        this.woHdrs = woHdrs;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="apsSrcRuleSet")
    public Set<ApsSrcRule> getApsSrcRules() {
        return this.apsSrcRules;
    }
    
    public void setApsSrcRules(Set<ApsSrcRule> apsSrcRules) {
        this.apsSrcRules = apsSrcRules;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="apsSrcRuleSet")
    public Set<ApsDmdRuleSetItem> getApsDmdRuleSetItems() {
        return this.apsDmdRuleSetItems;
    }
    
    public void setApsDmdRuleSetItems(Set<ApsDmdRuleSetItem> apsDmdRuleSetItems) {
        this.apsDmdRuleSetItems = apsDmdRuleSetItems;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="apsSrcRuleSet")
    public Set<FcItemMast> getFcItemMasts() {
        return this.fcItemMasts;
    }
    
    public void setFcItemMasts(Set<FcItemMast> fcItemMasts) {
        this.fcItemMasts = fcItemMasts;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="apsSrcRuleSet")
    public Set<IcKitMast> getIcKitMasts() {
        return this.icKitMasts;
    }
    
    public void setIcKitMasts(Set<IcKitMast> icKitMasts) {
        this.icKitMasts = icKitMasts;
    }

//    @Column(name="APS_SRC_RULE_NBR_PRIMARY") // TODO DUAL
//	public Integer getApsSrcRuleNbrPrimary() {
//		return apsSrcRuleNbrPrimary;
//	}
//
//
//	public void setApsSrcRuleNbrPrimary(Integer apsSrcRuleNbrPrimary) {
//		this.apsSrcRuleNbrPrimary = apsSrcRuleNbrPrimary;
//	}
}


