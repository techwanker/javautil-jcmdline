package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ApsDmdSs generated by hbm2java
 */
@Entity
@Table(name="APS_DMD_SS"
)
public class ApsDmdSs  implements java.io.Serializable {


     private String dmdCd;
     private String dmdTypeCd;
     private int itemNbrDmd;
     private int itemNbrAllocRqst;
     private int fcItemMastNbr;
     private Date rqstDt;
     private int apsSrcRuleSetNbr;
     private int orgNbrCust;
     private String orgCdCust;
     private BigDecimal openQty;
     private BigDecimal openQtyAdj;
     private String contractCustFlg;
     private BigDecimal custAllocPrty;
     private String revLvl;
     private Integer orgNbrMfrRqst;
     private String fcstGrp;

    public ApsDmdSs() {
    }

	
    public ApsDmdSs(String dmdCd, int itemNbrDmd, int itemNbrAllocRqst, int fcItemMastNbr, int apsSrcRuleSetNbr, int orgNbrCust, String orgCdCust, String contractCustFlg, String fcstGrp) {
        this.dmdCd = dmdCd;
        this.itemNbrDmd = itemNbrDmd;
        this.itemNbrAllocRqst = itemNbrAllocRqst;
        this.fcItemMastNbr = fcItemMastNbr;
        this.apsSrcRuleSetNbr = apsSrcRuleSetNbr;
        this.orgNbrCust = orgNbrCust;
        this.orgCdCust = orgCdCust;
        this.contractCustFlg = contractCustFlg;
        this.fcstGrp = fcstGrp;
    }
    public ApsDmdSs(String dmdCd, String dmdTypeCd, int itemNbrDmd, int itemNbrAllocRqst, int fcItemMastNbr, Date rqstDt, int apsSrcRuleSetNbr, int orgNbrCust, String orgCdCust, BigDecimal openQty, BigDecimal openQtyAdj, String contractCustFlg, BigDecimal custAllocPrty, String revLvl, Integer orgNbrMfrRqst, String fcstGrp) {
       this.dmdCd = dmdCd;
       this.dmdTypeCd = dmdTypeCd;
       this.itemNbrDmd = itemNbrDmd;
       this.itemNbrAllocRqst = itemNbrAllocRqst;
       this.fcItemMastNbr = fcItemMastNbr;
       this.rqstDt = rqstDt;
       this.apsSrcRuleSetNbr = apsSrcRuleSetNbr;
       this.orgNbrCust = orgNbrCust;
       this.orgCdCust = orgCdCust;
       this.openQty = openQty;
       this.openQtyAdj = openQtyAdj;
       this.contractCustFlg = contractCustFlg;
       this.custAllocPrty = custAllocPrty;
       this.revLvl = revLvl;
       this.orgNbrMfrRqst = orgNbrMfrRqst;
       this.fcstGrp = fcstGrp;
    }
   
     @Id 

    
    @Column(name="DMD_CD", nullable=false, length=42)
    public String getDmdCd() {
        return this.dmdCd;
    }
    
    public void setDmdCd(String dmdCd) {
        this.dmdCd = dmdCd;
    }

    
    @Column(name="DMD_TYPE_CD", length=2)
    public String getDmdTypeCd() {
        return this.dmdTypeCd;
    }
    
    public void setDmdTypeCd(String dmdTypeCd) {
        this.dmdTypeCd = dmdTypeCd;
    }

    
    @Column(name="ITEM_NBR_DMD", nullable=false, precision=9, scale=0)
    public int getItemNbrDmd() {
        return this.itemNbrDmd;
    }
    
    public void setItemNbrDmd(int itemNbrDmd) {
        this.itemNbrDmd = itemNbrDmd;
    }

    
    @Column(name="ITEM_NBR_ALLOC_RQST", nullable=false, precision=9, scale=0)
    public int getItemNbrAllocRqst() {
        return this.itemNbrAllocRqst;
    }
    
    public void setItemNbrAllocRqst(int itemNbrAllocRqst) {
        this.itemNbrAllocRqst = itemNbrAllocRqst;
    }

    
    @Column(name="FC_ITEM_MAST_NBR", nullable=false, precision=9, scale=0)
    public int getFcItemMastNbr() {
        return this.fcItemMastNbr;
    }
    
    public void setFcItemMastNbr(int fcItemMastNbr) {
        this.fcItemMastNbr = fcItemMastNbr;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="RQST_DT", length=7)
    public Date getRqstDt() {
        return this.rqstDt;
    }
    
    public void setRqstDt(Date rqstDt) {
        this.rqstDt = rqstDt;
    }

    
    @Column(name="APS_SRC_RULE_SET_NBR", nullable=false, precision=9, scale=0)
    public int getApsSrcRuleSetNbr() {
        return this.apsSrcRuleSetNbr;
    }
    
    public void setApsSrcRuleSetNbr(int apsSrcRuleSetNbr) {
        this.apsSrcRuleSetNbr = apsSrcRuleSetNbr;
    }

    
    @Column(name="ORG_NBR_CUST", nullable=false, precision=9, scale=0)
    public int getOrgNbrCust() {
        return this.orgNbrCust;
    }
    
    public void setOrgNbrCust(int orgNbrCust) {
        this.orgNbrCust = orgNbrCust;
    }

    
    @Column(name="ORG_CD_CUST", nullable=false, length=15)
    public String getOrgCdCust() {
        return this.orgCdCust;
    }
    
    public void setOrgCdCust(String orgCdCust) {
        this.orgCdCust = orgCdCust;
    }

    
    @Column(name="OPEN_QTY", precision=13, scale=5)
    public BigDecimal getOpenQty() {
        return this.openQty;
    }
    
    public void setOpenQty(BigDecimal openQty) {
        this.openQty = openQty;
    }

    
    @Column(name="OPEN_QTY_ADJ", precision=13, scale=5)
    public BigDecimal getOpenQtyAdj() {
        return this.openQtyAdj;
    }
    
    public void setOpenQtyAdj(BigDecimal openQtyAdj) {
        this.openQtyAdj = openQtyAdj;
    }

    
    @Column(name="CONTRACT_CUST_FLG", nullable=false, length=1)
    public String getContractCustFlg() {
        return this.contractCustFlg;
    }
    
    public void setContractCustFlg(String contractCustFlg) {
        this.contractCustFlg = contractCustFlg;
    }

    
    @Column(name="CUST_ALLOC_PRTY", precision=22, scale=0)
    public BigDecimal getCustAllocPrty() {
        return this.custAllocPrty;
    }
    
    public void setCustAllocPrty(BigDecimal custAllocPrty) {
        this.custAllocPrty = custAllocPrty;
    }

    
    @Column(name="REV_LVL", length=5)
    public String getRevLvl() {
        return this.revLvl;
    }
    
    public void setRevLvl(String revLvl) {
        this.revLvl = revLvl;
    }

    
    @Column(name="ORG_NBR_MFR_RQST", precision=9, scale=0)
    public Integer getOrgNbrMfrRqst() {
        return this.orgNbrMfrRqst;
    }
    
    public void setOrgNbrMfrRqst(Integer orgNbrMfrRqst) {
        this.orgNbrMfrRqst = orgNbrMfrRqst;
    }

    
    @Column(name="FCST_GRP", nullable=false, length=8)
    public String getFcstGrp() {
        return this.fcstGrp;
    }
    
    public void setFcstGrp(String fcstGrp) {
        this.fcstGrp = fcstGrp;
    }




}


