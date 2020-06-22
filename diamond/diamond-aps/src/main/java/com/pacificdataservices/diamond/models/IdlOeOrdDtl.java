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
 * IdlOeOrdDtl generated by hbm2java
 */
@Entity
@Table(name="IDL_OE_ORD_DTL"
)
public class IdlOeOrdDtl  implements java.io.Serializable {


     private String idlOeOrdDtlNbr;
     private String ordCd;
     private Date ordDt;
     private String ordTypeCd;
     private String orgCdCust;
     private String custPoCd;
     private String termCd;
     private String shipViaCd;
     private String fobCd;
     private String currCd;
     private String salesTerrCd;
     private String lineNbr;
     private String itemCd;
     private String itemCdCust;
     private BigDecimal qtyOrd;
     private String sellUm;
     private Date rqstDt;
     private Date promDt;
     private String shipFromFacility;
     private String ordDtText;
     private String rqstDtText;
     private String promDtText;

    public IdlOeOrdDtl() {
    }

	
    public IdlOeOrdDtl(String idlOeOrdDtlNbr, String ordCd, String orgCdCust, String itemCd, BigDecimal qtyOrd) {
        this.idlOeOrdDtlNbr = idlOeOrdDtlNbr;
        this.ordCd = ordCd;
        this.orgCdCust = orgCdCust;
        this.itemCd = itemCd;
        this.qtyOrd = qtyOrd;
    }
    public IdlOeOrdDtl(String idlOeOrdDtlNbr, String ordCd, Date ordDt, String ordTypeCd, String orgCdCust, String custPoCd, String termCd, String shipViaCd, String fobCd, String currCd, String salesTerrCd, String lineNbr, String itemCd, String itemCdCust, BigDecimal qtyOrd, String sellUm, Date rqstDt, Date promDt, String shipFromFacility, String ordDtText, String rqstDtText, String promDtText) {
       this.idlOeOrdDtlNbr = idlOeOrdDtlNbr;
       this.ordCd = ordCd;
       this.ordDt = ordDt;
       this.ordTypeCd = ordTypeCd;
       this.orgCdCust = orgCdCust;
       this.custPoCd = custPoCd;
       this.termCd = termCd;
       this.shipViaCd = shipViaCd;
       this.fobCd = fobCd;
       this.currCd = currCd;
       this.salesTerrCd = salesTerrCd;
       this.lineNbr = lineNbr;
       this.itemCd = itemCd;
       this.itemCdCust = itemCdCust;
       this.qtyOrd = qtyOrd;
       this.sellUm = sellUm;
       this.rqstDt = rqstDt;
       this.promDt = promDt;
       this.shipFromFacility = shipFromFacility;
       this.ordDtText = ordDtText;
       this.rqstDtText = rqstDtText;
       this.promDtText = promDtText;
    }
   
     @Id 

    
    @Column(name="IDL_OE_ORD_DTL_NBR", unique=true, nullable=false, length=9)
    public String getIdlOeOrdDtlNbr() {
        return this.idlOeOrdDtlNbr;
    }
    
    public void setIdlOeOrdDtlNbr(String idlOeOrdDtlNbr) {
        this.idlOeOrdDtlNbr = idlOeOrdDtlNbr;
    }

    
    @Column(name="ORD_CD", nullable=false, length=20)
    public String getOrdCd() {
        return this.ordCd;
    }
    
    public void setOrdCd(String ordCd) {
        this.ordCd = ordCd;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="ORD_DT", length=7)
    public Date getOrdDt() {
        return this.ordDt;
    }
    
    public void setOrdDt(Date ordDt) {
        this.ordDt = ordDt;
    }

    
    @Column(name="ORD_TYPE_CD", length=8)
    public String getOrdTypeCd() {
        return this.ordTypeCd;
    }
    
    public void setOrdTypeCd(String ordTypeCd) {
        this.ordTypeCd = ordTypeCd;
    }

    
    @Column(name="ORG_CD_CUST", nullable=false, length=16)
    public String getOrgCdCust() {
        return this.orgCdCust;
    }
    
    public void setOrgCdCust(String orgCdCust) {
        this.orgCdCust = orgCdCust;
    }

    
    @Column(name="CUST_PO_CD", length=30)
    public String getCustPoCd() {
        return this.custPoCd;
    }
    
    public void setCustPoCd(String custPoCd) {
        this.custPoCd = custPoCd;
    }

    
    @Column(name="TERM_CD", length=10)
    public String getTermCd() {
        return this.termCd;
    }
    
    public void setTermCd(String termCd) {
        this.termCd = termCd;
    }

    
    @Column(name="SHIP_VIA_CD", length=16)
    public String getShipViaCd() {
        return this.shipViaCd;
    }
    
    public void setShipViaCd(String shipViaCd) {
        this.shipViaCd = shipViaCd;
    }

    
    @Column(name="FOB_CD", length=16)
    public String getFobCd() {
        return this.fobCd;
    }
    
    public void setFobCd(String fobCd) {
        this.fobCd = fobCd;
    }

    
    @Column(name="CURR_CD", length=3)
    public String getCurrCd() {
        return this.currCd;
    }
    
    public void setCurrCd(String currCd) {
        this.currCd = currCd;
    }

    
    @Column(name="SALES_TERR_CD", length=8)
    public String getSalesTerrCd() {
        return this.salesTerrCd;
    }
    
    public void setSalesTerrCd(String salesTerrCd) {
        this.salesTerrCd = salesTerrCd;
    }

    
    @Column(name="LINE_NBR", length=5)
    public String getLineNbr() {
        return this.lineNbr;
    }
    
    public void setLineNbr(String lineNbr) {
        this.lineNbr = lineNbr;
    }

    
    @Column(name="ITEM_CD", nullable=false, length=50)
    public String getItemCd() {
        return this.itemCd;
    }
    
    public void setItemCd(String itemCd) {
        this.itemCd = itemCd;
    }

    
    @Column(name="ITEM_CD_CUST", length=50)
    public String getItemCdCust() {
        return this.itemCdCust;
    }
    
    public void setItemCdCust(String itemCdCust) {
        this.itemCdCust = itemCdCust;
    }

    
    @Column(name="QTY_ORD", nullable=false, precision=22, scale=0)
    public BigDecimal getQtyOrd() {
        return this.qtyOrd;
    }
    
    public void setQtyOrd(BigDecimal qtyOrd) {
        this.qtyOrd = qtyOrd;
    }

    
    @Column(name="SELL_UM", length=3)
    public String getSellUm() {
        return this.sellUm;
    }
    
    public void setSellUm(String sellUm) {
        this.sellUm = sellUm;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="RQST_DT", length=7)
    public Date getRqstDt() {
        return this.rqstDt;
    }
    
    public void setRqstDt(Date rqstDt) {
        this.rqstDt = rqstDt;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="PROM_DT", length=7)
    public Date getPromDt() {
        return this.promDt;
    }
    
    public void setPromDt(Date promDt) {
        this.promDt = promDt;
    }

    
    @Column(name="SHIP_FROM_FACILITY", length=16)
    public String getShipFromFacility() {
        return this.shipFromFacility;
    }
    
    public void setShipFromFacility(String shipFromFacility) {
        this.shipFromFacility = shipFromFacility;
    }

    
    @Column(name="ORD_DT_TEXT", length=16)
    public String getOrdDtText() {
        return this.ordDtText;
    }
    
    public void setOrdDtText(String ordDtText) {
        this.ordDtText = ordDtText;
    }

    
    @Column(name="RQST_DT_TEXT", length=16)
    public String getRqstDtText() {
        return this.rqstDtText;
    }
    
    public void setRqstDtText(String rqstDtText) {
        this.rqstDtText = rqstDtText;
    }

    
    @Column(name="PROM_DT_TEXT", length=16)
    public String getPromDtText() {
        return this.promDtText;
    }
    
    public void setPromDtText(String promDtText) {
        this.promDtText = promDtText;
    }




}

