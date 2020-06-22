package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import java.math.BigDecimal;
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
 * PosDtl generated by hbm2java
 */
@Entity
@Table(name="POS_DTL"
)
public class PosDtl  implements java.io.Serializable {


     private int posDtlNbr;
     private IcLotMast icLotMast;
     private IcItemMast icItemMast;
     private int posHdrNbr;
     private String boxCd;
     private BigDecimal qtyShip;
     private BigDecimal qtyShipStkUm;
     private String facility;
     private int apsSplySubPoolNbr;
     private BigDecimal unitPriceDenomSellUm;
     private BigDecimal unitPriceSellUm;
     private BigDecimal unitPriceDenomStkUm;
     private BigDecimal unitPriceStkUm;
     private String contractCd;
     private String custBinCd;
     private int utUserNbr;
     private Date lastModDt;
     private String itemCdCust;
     private Integer oeOrdDtlNbr;
     private Integer oeOrdLineNbr;

    public PosDtl() {
    }

	
    public PosDtl(int posDtlNbr, IcLotMast icLotMast, IcItemMast icItemMast, int posHdrNbr, String boxCd, BigDecimal qtyShip, BigDecimal qtyShipStkUm, String facility, int apsSplySubPoolNbr, BigDecimal unitPriceDenomSellUm, BigDecimal unitPriceSellUm, BigDecimal unitPriceDenomStkUm, BigDecimal unitPriceStkUm, int utUserNbr, Date lastModDt) {
        this.posDtlNbr = posDtlNbr;
        this.icLotMast = icLotMast;
        this.icItemMast = icItemMast;
        this.posHdrNbr = posHdrNbr;
        this.boxCd = boxCd;
        this.qtyShip = qtyShip;
        this.qtyShipStkUm = qtyShipStkUm;
        this.facility = facility;
        this.apsSplySubPoolNbr = apsSplySubPoolNbr;
        this.unitPriceDenomSellUm = unitPriceDenomSellUm;
        this.unitPriceSellUm = unitPriceSellUm;
        this.unitPriceDenomStkUm = unitPriceDenomStkUm;
        this.unitPriceStkUm = unitPriceStkUm;
        this.utUserNbr = utUserNbr;
        this.lastModDt = lastModDt;
    }
    public PosDtl(int posDtlNbr, IcLotMast icLotMast, IcItemMast icItemMast, int posHdrNbr, String boxCd, BigDecimal qtyShip, BigDecimal qtyShipStkUm, String facility, int apsSplySubPoolNbr, BigDecimal unitPriceDenomSellUm, BigDecimal unitPriceSellUm, BigDecimal unitPriceDenomStkUm, BigDecimal unitPriceStkUm, String contractCd, String custBinCd, int utUserNbr, Date lastModDt, String itemCdCust, Integer oeOrdDtlNbr, Integer oeOrdLineNbr) {
       this.posDtlNbr = posDtlNbr;
       this.icLotMast = icLotMast;
       this.icItemMast = icItemMast;
       this.posHdrNbr = posHdrNbr;
       this.boxCd = boxCd;
       this.qtyShip = qtyShip;
       this.qtyShipStkUm = qtyShipStkUm;
       this.facility = facility;
       this.apsSplySubPoolNbr = apsSplySubPoolNbr;
       this.unitPriceDenomSellUm = unitPriceDenomSellUm;
       this.unitPriceSellUm = unitPriceSellUm;
       this.unitPriceDenomStkUm = unitPriceDenomStkUm;
       this.unitPriceStkUm = unitPriceStkUm;
       this.contractCd = contractCd;
       this.custBinCd = custBinCd;
       this.utUserNbr = utUserNbr;
       this.lastModDt = lastModDt;
       this.itemCdCust = itemCdCust;
       this.oeOrdDtlNbr = oeOrdDtlNbr;
       this.oeOrdLineNbr = oeOrdLineNbr;
    }
   
     @Id 

    
    @Column(name="POS_DTL_NBR", unique=true, nullable=false, precision=9, scale=0)
    public int getPosDtlNbr() {
        return this.posDtlNbr;
    }
    
    public void setPosDtlNbr(int posDtlNbr) {
        this.posDtlNbr = posDtlNbr;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="LOT_NBR", nullable=false)
    public IcLotMast getIcLotMast() {
        return this.icLotMast;
    }
    
    public void setIcLotMast(IcLotMast icLotMast) {
        this.icLotMast = icLotMast;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ITEM_NBR_SHIP", nullable=false)
    public IcItemMast getIcItemMast() {
        return this.icItemMast;
    }
    
    public void setIcItemMast(IcItemMast icItemMast) {
        this.icItemMast = icItemMast;
    }

    
    @Column(name="POS_HDR_NBR", nullable=false, precision=9, scale=0)
    public int getPosHdrNbr() {
        return this.posHdrNbr;
    }
    
    public void setPosHdrNbr(int posHdrNbr) {
        this.posHdrNbr = posHdrNbr;
    }

    
    @Column(name="BOX_CD", nullable=false, length=20)
    public String getBoxCd() {
        return this.boxCd;
    }
    
    public void setBoxCd(String boxCd) {
        this.boxCd = boxCd;
    }

    
    @Column(name="QTY_SHIP", nullable=false, precision=13, scale=5)
    public BigDecimal getQtyShip() {
        return this.qtyShip;
    }
    
    public void setQtyShip(BigDecimal qtyShip) {
        this.qtyShip = qtyShip;
    }

    
    @Column(name="QTY_SHIP_STK_UM", nullable=false, precision=13, scale=5)
    public BigDecimal getQtyShipStkUm() {
        return this.qtyShipStkUm;
    }
    
    public void setQtyShipStkUm(BigDecimal qtyShipStkUm) {
        this.qtyShipStkUm = qtyShipStkUm;
    }

    
    @Column(name="FACILITY", nullable=false, length=16)
    public String getFacility() {
        return this.facility;
    }
    
    public void setFacility(String facility) {
        this.facility = facility;
    }

    
    @Column(name="APS_SPLY_SUB_POOL_NBR", nullable=false, precision=9, scale=0)
    public int getApsSplySubPoolNbr() {
        return this.apsSplySubPoolNbr;
    }
    
    public void setApsSplySubPoolNbr(int apsSplySubPoolNbr) {
        this.apsSplySubPoolNbr = apsSplySubPoolNbr;
    }

    
    @Column(name="UNIT_PRICE_DENOM_SELL_UM", nullable=false, precision=17, scale=6)
    public BigDecimal getUnitPriceDenomSellUm() {
        return this.unitPriceDenomSellUm;
    }
    
    public void setUnitPriceDenomSellUm(BigDecimal unitPriceDenomSellUm) {
        this.unitPriceDenomSellUm = unitPriceDenomSellUm;
    }

    
    @Column(name="UNIT_PRICE_SELL_UM", nullable=false, precision=17, scale=6)
    public BigDecimal getUnitPriceSellUm() {
        return this.unitPriceSellUm;
    }
    
    public void setUnitPriceSellUm(BigDecimal unitPriceSellUm) {
        this.unitPriceSellUm = unitPriceSellUm;
    }

    
    @Column(name="UNIT_PRICE_DENOM_STK_UM", nullable=false, precision=17, scale=6)
    public BigDecimal getUnitPriceDenomStkUm() {
        return this.unitPriceDenomStkUm;
    }
    
    public void setUnitPriceDenomStkUm(BigDecimal unitPriceDenomStkUm) {
        this.unitPriceDenomStkUm = unitPriceDenomStkUm;
    }

    
    @Column(name="UNIT_PRICE_STK_UM", nullable=false, precision=17, scale=6)
    public BigDecimal getUnitPriceStkUm() {
        return this.unitPriceStkUm;
    }
    
    public void setUnitPriceStkUm(BigDecimal unitPriceStkUm) {
        this.unitPriceStkUm = unitPriceStkUm;
    }

    
    @Column(name="CONTRACT_CD", length=8)
    public String getContractCd() {
        return this.contractCd;
    }
    
    public void setContractCd(String contractCd) {
        this.contractCd = contractCd;
    }

    
    @Column(name="CUST_BIN_CD", length=40)
    public String getCustBinCd() {
        return this.custBinCd;
    }
    
    public void setCustBinCd(String custBinCd) {
        this.custBinCd = custBinCd;
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

    
    @Column(name="ITEM_CD_CUST", length=50)
    public String getItemCdCust() {
        return this.itemCdCust;
    }
    
    public void setItemCdCust(String itemCdCust) {
        this.itemCdCust = itemCdCust;
    }

    
    @Column(name="OE_ORD_DTL_NBR", precision=9, scale=0)
    public Integer getOeOrdDtlNbr() {
        return this.oeOrdDtlNbr;
    }
    
    public void setOeOrdDtlNbr(Integer oeOrdDtlNbr) {
        this.oeOrdDtlNbr = oeOrdDtlNbr;
    }

    
    @Column(name="OE_ORD_LINE_NBR", precision=9, scale=0)
    public Integer getOeOrdLineNbr() {
        return this.oeOrdLineNbr;
    }
    
    public void setOeOrdLineNbr(Integer oeOrdLineNbr) {
        this.oeOrdLineNbr = oeOrdLineNbr;
    }




}

