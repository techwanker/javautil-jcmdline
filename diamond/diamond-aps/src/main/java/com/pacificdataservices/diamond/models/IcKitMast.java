package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * IcKitMast generated by hbm2java
 */
@Entity
@Table(name="IC_KIT_MAST"
)
public class IcKitMast  implements java.io.Serializable {


     private int itemNbr;
     private ApsSplySubPool apsSplySubPool;
     private ApsSrcRuleSet apsSrcRuleSet;
     private UtFacility utFacility;
     private OeCustMast oeCustMast;
     private IcItemMast icItemMast;
     private int utUserNbr;
     private Date lastModDt;

    public IcKitMast() {
    }

    public IcKitMast(ApsSplySubPool apsSplySubPool, ApsSrcRuleSet apsSrcRuleSet, UtFacility utFacility, OeCustMast oeCustMast, IcItemMast icItemMast, int utUserNbr, Date lastModDt) {
       this.apsSplySubPool = apsSplySubPool;
       this.apsSrcRuleSet = apsSrcRuleSet;
       this.utFacility = utFacility;
       this.oeCustMast = oeCustMast;
       this.icItemMast = icItemMast;
       this.utUserNbr = utUserNbr;
       this.lastModDt = lastModDt;
    }
   

    @Id
    @Column(name="ITEM_NBR", unique=true, nullable=false, precision=9, scale=0)
    public int getItemNbr() {
        return this.itemNbr;
    }
    
    public void setItemNbr(int itemNbr) {
        this.itemNbr = itemNbr;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="APS_SPLY_SUB_POOL_NBR_DFLT", nullable=false)
    public ApsSplySubPool getApsSplySubPool() {
        return this.apsSplySubPool;
    }
    
    public void setApsSplySubPool(ApsSplySubPool apsSplySubPool) {
        this.apsSplySubPool = apsSplySubPool;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="APS_SRC_RULE_SET_NBR_DFLT", nullable=false)
    public ApsSrcRuleSet getApsSrcRuleSet() {
        return this.apsSrcRuleSet;
    }
    
    public void setApsSrcRuleSet(ApsSrcRuleSet apsSrcRuleSet) {
        this.apsSrcRuleSet = apsSrcRuleSet;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="FACILITY_DFLT", nullable=false)
    public UtFacility getUtFacility() {
        return this.utFacility;
    }
    
    public void setUtFacility(UtFacility utFacility) {
        this.utFacility = utFacility;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ORG_NBR_CUST", nullable=false)
    public OeCustMast getOeCustMast() {
        return this.oeCustMast;
    }
    
    public void setOeCustMast(OeCustMast oeCustMast) {
        this.oeCustMast = oeCustMast;
    }

//@OneToOne(fetch=FetchType.LAZY)@PrimaryKeyJoinColumn
    public IcItemMast getIcItemMast() {
        return this.icItemMast;
    }
    
    public void setIcItemMast(IcItemMast icItemMast) {
        this.icItemMast = icItemMast;
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




}


