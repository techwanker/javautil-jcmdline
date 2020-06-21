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
 * ApsDmdOo generated by hbm2java
 */
@Entity
@Table(name="APS_DMD_OO"
)
public class ApsDmdOo  implements java.io.Serializable {


     private String dmdCd;
     private String dmdTypeCd;
     private int itemNbrDmd;
     private int oeOrdDtlNbr;
     private Date rqstDt;
     private Date promDtCurr;
     private int apsSrcRuleSetNbr;
     private int orgNbrCust;
     private BigDecimal openQty;
     private BigDecimal openQtyAdj;
     private String orgCdCust;
     private Integer orgNbrMfrRqst;
     private String orgCdMfr;
     private String contractCustFlg;
     private BigDecimal unitPrice;
     private short custAllocPrty;
     private String revLvl;
     private String cntryCdOrigin;
     private Date lotNotExpireBeforeDt;
     private Date lotManufactureAfterDt;
     private String fcstGrp;
     private String shipFromFacility;

    public ApsDmdOo() {
    }

	
    public ApsDmdOo(String dmdCd, int itemNbrDmd, int oeOrdDtlNbr, Date rqstDt, Date promDtCurr, int apsSrcRuleSetNbr, int orgNbrCust, String orgCdCust, short custAllocPrty, String shipFromFacility) {
        this.dmdCd = dmdCd;
        this.itemNbrDmd = itemNbrDmd;
        this.oeOrdDtlNbr = oeOrdDtlNbr;
        this.rqstDt = rqstDt;
        this.promDtCurr = promDtCurr;
        this.apsSrcRuleSetNbr = apsSrcRuleSetNbr;
        this.orgNbrCust = orgNbrCust;
        this.orgCdCust = orgCdCust;
        this.custAllocPrty = custAllocPrty;
        this.shipFromFacility = shipFromFacility;
    }
    public ApsDmdOo(String dmdCd, String dmdTypeCd, int itemNbrDmd, int oeOrdDtlNbr, Date rqstDt, Date promDtCurr, int apsSrcRuleSetNbr, int orgNbrCust, BigDecimal openQty, BigDecimal openQtyAdj, String orgCdCust, Integer orgNbrMfrRqst, String orgCdMfr, String contractCustFlg, BigDecimal unitPrice, short custAllocPrty, String revLvl, String cntryCdOrigin, Date lotNotExpireBeforeDt, Date lotManufactureAfterDt, String fcstGrp, String shipFromFacility) {
       this.dmdCd = dmdCd;
       this.dmdTypeCd = dmdTypeCd;
       this.itemNbrDmd = itemNbrDmd;
       this.oeOrdDtlNbr = oeOrdDtlNbr;
       this.rqstDt = rqstDt;
       this.promDtCurr = promDtCurr;
       this.apsSrcRuleSetNbr = apsSrcRuleSetNbr;
       this.orgNbrCust = orgNbrCust;
       this.openQty = openQty;
       this.openQtyAdj = openQtyAdj;
       this.orgCdCust = orgCdCust;
       this.orgNbrMfrRqst = orgNbrMfrRqst;
       this.orgCdMfr = orgCdMfr;
       this.contractCustFlg = contractCustFlg;
       this.unitPrice = unitPrice;
       this.custAllocPrty = custAllocPrty;
       this.revLvl = revLvl;
       this.cntryCdOrigin = cntryCdOrigin;
       this.lotNotExpireBeforeDt = lotNotExpireBeforeDt;
       this.lotManufactureAfterDt = lotManufactureAfterDt;
       this.fcstGrp = fcstGrp;
       this.shipFromFacility = shipFromFacility;
    }
   
     @Id 

    
    @Column(name="DMD_CD", nullable=false, length=69)
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

    
    @Column(name="OE_ORD_DTL_NBR", nullable=false, precision=9, scale=0)
    public int getOeOrdDtlNbr() {
        return this.oeOrdDtlNbr;
    }
    
    public void setOeOrdDtlNbr(int oeOrdDtlNbr) {
        this.oeOrdDtlNbr = oeOrdDtlNbr;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="RQST_DT", nullable=false, length=7)
    public Date getRqstDt() {
        return this.rqstDt;
    }
    
    public void setRqstDt(Date rqstDt) {
        this.rqstDt = rqstDt;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="PROM_DT_CURR", nullable=false, length=7)
    public Date getPromDtCurr() {
        return this.promDtCurr;
    }
    
    public void setPromDtCurr(Date promDtCurr) {
        this.promDtCurr = promDtCurr;
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

    
    @Column(name="ORG_CD_MFR", length=15)
    public String getOrgCdMfr() {
        return this.orgCdMfr;
    }
    
    public void setOrgCdMfr(String orgCdMfr) {
        this.orgCdMfr = orgCdMfr;
    }

    
    @Column(name="CONTRACT_CUST_FLG", length=1)
    public String getContractCustFlg() {
        return this.contractCustFlg;
    }
    
    public void setContractCustFlg(String contractCustFlg) {
        this.contractCustFlg = contractCustFlg;
    }

    
    @Column(name="UNIT_PRICE", precision=17, scale=6)
    public BigDecimal getUnitPrice() {
        return this.unitPrice;
    }
    
    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    
    @Column(name="CUST_ALLOC_PRTY", nullable=false, precision=3, scale=0)
    public short getCustAllocPrty() {
        return this.custAllocPrty;
    }
    
    public void setCustAllocPrty(short custAllocPrty) {
        this.custAllocPrty = custAllocPrty;
    }

    
    @Column(name="REV_LVL", length=5)
    public String getRevLvl() {
        return this.revLvl;
    }
    
    public void setRevLvl(String revLvl) {
        this.revLvl = revLvl;
    }

    
    @Column(name="CNTRY_CD_ORIGIN", length=3)
    public String getCntryCdOrigin() {
        return this.cntryCdOrigin;
    }
    
    public void setCntryCdOrigin(String cntryCdOrigin) {
        this.cntryCdOrigin = cntryCdOrigin;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="LOT_NOT_EXPIRE_BEFORE_DT", length=7)
    public Date getLotNotExpireBeforeDt() {
        return this.lotNotExpireBeforeDt;
    }
    
    public void setLotNotExpireBeforeDt(Date lotNotExpireBeforeDt) {
        this.lotNotExpireBeforeDt = lotNotExpireBeforeDt;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="LOT_MANUFACTURE_AFTER_DT", length=7)
    public Date getLotManufactureAfterDt() {
        return this.lotManufactureAfterDt;
    }
    
    public void setLotManufactureAfterDt(Date lotManufactureAfterDt) {
        this.lotManufactureAfterDt = lotManufactureAfterDt;
    }

    
    @Column(name="FCST_GRP", length=8)
    public String getFcstGrp() {
        return this.fcstGrp;
    }
    
    public void setFcstGrp(String fcstGrp) {
        this.fcstGrp = fcstGrp;
    }

    
    @Column(name="SHIP_FROM_FACILITY", nullable=false, length=16)
    public String getShipFromFacility() {
        return this.shipFromFacility;
    }
    
    public void setShipFromFacility(String shipFromFacility) {
        this.shipFromFacility = shipFromFacility;
    }




}


