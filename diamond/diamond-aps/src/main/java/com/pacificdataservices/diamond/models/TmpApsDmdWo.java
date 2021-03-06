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
 * TmpApsDmdWo generated by hbm2java
 */
@Entity
@Table(name="TMP_APS_DMD_WO"
)
public class TmpApsDmdWo  implements java.io.Serializable {


     private String dmdCd;
     private String dmdTypeCd;
     private int itemNbrDmd;
     private int woDtlNbr;
     private Date needByDt;
     private int apsSrcRuleSetNbr;
     private int orgNbrCust;
     private String orgCdCust;
     private Integer orgNbrMfrRqst;
     private String orgCdMfrRqst;
     private String revLvl;
     private BigDecimal openQty;
     private BigDecimal openQtyAdj;
     private String fcstGrp;
     private String mixMfrLotFlg;
     private BigDecimal componentQtyPerUnit;
     private short custAllocPrty;

    public TmpApsDmdWo() {
    }

	
    public TmpApsDmdWo(String dmdCd, int itemNbrDmd, int woDtlNbr, Date needByDt, int apsSrcRuleSetNbr, int orgNbrCust, String orgCdCust, String fcstGrp, String mixMfrLotFlg, BigDecimal componentQtyPerUnit, short custAllocPrty) {
        this.dmdCd = dmdCd;
        this.itemNbrDmd = itemNbrDmd;
        this.woDtlNbr = woDtlNbr;
        this.needByDt = needByDt;
        this.apsSrcRuleSetNbr = apsSrcRuleSetNbr;
        this.orgNbrCust = orgNbrCust;
        this.orgCdCust = orgCdCust;
        this.fcstGrp = fcstGrp;
        this.mixMfrLotFlg = mixMfrLotFlg;
        this.componentQtyPerUnit = componentQtyPerUnit;
        this.custAllocPrty = custAllocPrty;
    }
    public TmpApsDmdWo(String dmdCd, String dmdTypeCd, int itemNbrDmd, int woDtlNbr, Date needByDt, int apsSrcRuleSetNbr, int orgNbrCust, String orgCdCust, Integer orgNbrMfrRqst, String orgCdMfrRqst, String revLvl, BigDecimal openQty, BigDecimal openQtyAdj, String fcstGrp, String mixMfrLotFlg, BigDecimal componentQtyPerUnit, short custAllocPrty) {
       this.dmdCd = dmdCd;
       this.dmdTypeCd = dmdTypeCd;
       this.itemNbrDmd = itemNbrDmd;
       this.woDtlNbr = woDtlNbr;
       this.needByDt = needByDt;
       this.apsSrcRuleSetNbr = apsSrcRuleSetNbr;
       this.orgNbrCust = orgNbrCust;
       this.orgCdCust = orgCdCust;
       this.orgNbrMfrRqst = orgNbrMfrRqst;
       this.orgCdMfrRqst = orgCdMfrRqst;
       this.revLvl = revLvl;
       this.openQty = openQty;
       this.openQtyAdj = openQtyAdj;
       this.fcstGrp = fcstGrp;
       this.mixMfrLotFlg = mixMfrLotFlg;
       this.componentQtyPerUnit = componentQtyPerUnit;
       this.custAllocPrty = custAllocPrty;
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

    
    @Column(name="WO_DTL_NBR", nullable=false, precision=9, scale=0)
    public int getWoDtlNbr() {
        return this.woDtlNbr;
    }
    
    public void setWoDtlNbr(int woDtlNbr) {
        this.woDtlNbr = woDtlNbr;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="NEED_BY_DT", nullable=false, length=7)
    public Date getNeedByDt() {
        return this.needByDt;
    }
    
    public void setNeedByDt(Date needByDt) {
        this.needByDt = needByDt;
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

    
    @Column(name="ORG_NBR_MFR_RQST", precision=9, scale=0)
    public Integer getOrgNbrMfrRqst() {
        return this.orgNbrMfrRqst;
    }
    
    public void setOrgNbrMfrRqst(Integer orgNbrMfrRqst) {
        this.orgNbrMfrRqst = orgNbrMfrRqst;
    }

    
    @Column(name="ORG_CD_MFR_RQST", length=15)
    public String getOrgCdMfrRqst() {
        return this.orgCdMfrRqst;
    }
    
    public void setOrgCdMfrRqst(String orgCdMfrRqst) {
        this.orgCdMfrRqst = orgCdMfrRqst;
    }

    
    @Column(name="REV_LVL", length=5)
    public String getRevLvl() {
        return this.revLvl;
    }
    
    public void setRevLvl(String revLvl) {
        this.revLvl = revLvl;
    }

    
    @Column(name="OPEN_QTY", precision=22, scale=0)
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

    
    @Column(name="FCST_GRP", nullable=false, length=8)
    public String getFcstGrp() {
        return this.fcstGrp;
    }
    
    public void setFcstGrp(String fcstGrp) {
        this.fcstGrp = fcstGrp;
    }

    
    @Column(name="MIX_MFR_LOT_FLG", nullable=false, length=1)
    public String getMixMfrLotFlg() {
        return this.mixMfrLotFlg;
    }
    
    public void setMixMfrLotFlg(String mixMfrLotFlg) {
        this.mixMfrLotFlg = mixMfrLotFlg;
    }

    
    @Column(name="COMPONENT_QTY_PER_UNIT", nullable=false, precision=13, scale=5)
    public BigDecimal getComponentQtyPerUnit() {
        return this.componentQtyPerUnit;
    }
    
    public void setComponentQtyPerUnit(BigDecimal componentQtyPerUnit) {
        this.componentQtyPerUnit = componentQtyPerUnit;
    }

    
    @Column(name="CUST_ALLOC_PRTY", nullable=false, precision=3, scale=0)
    public short getCustAllocPrty() {
        return this.custAllocPrty;
    }
    
    public void setCustAllocPrty(short custAllocPrty) {
        this.custAllocPrty = custAllocPrty;
    }




}


