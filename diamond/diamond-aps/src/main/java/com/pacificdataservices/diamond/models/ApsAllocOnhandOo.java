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
 * ApsAllocOnhandOo generated by hbm2java
 */
@Entity
@Table(name="APS_ALLOC_ONHAND_OO"
)
public class ApsAllocOnhandOo  implements java.io.Serializable, AllocOnhand {


     private int apsAllocOnhandOoNbr;
     private WhFacilityTransOnhand whFacilityTransOnhand;
     private IcItemMast icItemMast;
     private int oeOrdDtlNbr;
     private int lotNbr;
     private BigDecimal allocQty;
     private int apsSplySubPoolNbr;
     private String substId;
     private String facilityRqst;
     private String facilityAct;
     private BigDecimal unitPriceSellUm;
     private BigDecimal unitPriceDenomSellUm;
     private BigDecimal unitPriceStkUm;
     private BigDecimal unitPriceDenomStkUm;
     private String allocTypeId;
     private Date availDt;
     private String availDtTypeId;
     private Set<WhPickDtlCopRqst> whPickDtlCopRqsts = new HashSet<WhPickDtlCopRqst>(0);

    public ApsAllocOnhandOo() {
    }

	
    public ApsAllocOnhandOo(int apsAllocOnhandOoNbr, IcItemMast icItemMast, int oeOrdDtlNbr, int lotNbr, BigDecimal allocQty, int apsSplySubPoolNbr, String facilityRqst, String facilityAct, String allocTypeId, Date availDt, String availDtTypeId) {
        this.apsAllocOnhandOoNbr = apsAllocOnhandOoNbr;
        this.icItemMast = icItemMast;
        this.oeOrdDtlNbr = oeOrdDtlNbr;
        this.lotNbr = lotNbr;
        this.allocQty = allocQty;
        this.apsSplySubPoolNbr = apsSplySubPoolNbr;
        this.facilityRqst = facilityRqst;
        this.facilityAct = facilityAct;
        this.allocTypeId = allocTypeId;
        this.availDt = availDt;
        this.availDtTypeId = availDtTypeId;
    }
    public ApsAllocOnhandOo(int apsAllocOnhandOoNbr, WhFacilityTransOnhand whFacilityTransOnhand, IcItemMast icItemMast, int oeOrdDtlNbr, int lotNbr, BigDecimal allocQty, int apsSplySubPoolNbr, String substId, String facilityRqst, String facilityAct, BigDecimal unitPriceSellUm, BigDecimal unitPriceDenomSellUm, BigDecimal unitPriceStkUm, BigDecimal unitPriceDenomStkUm, String allocTypeId, Date availDt, String availDtTypeId, Set<WhPickDtlCopRqst> whPickDtlCopRqsts) {
       this.apsAllocOnhandOoNbr = apsAllocOnhandOoNbr;
       this.whFacilityTransOnhand = whFacilityTransOnhand;
       this.icItemMast = icItemMast;
       this.oeOrdDtlNbr = oeOrdDtlNbr;
       this.lotNbr = lotNbr;
       this.allocQty = allocQty;
       this.apsSplySubPoolNbr = apsSplySubPoolNbr;
       this.substId = substId;
       this.facilityRqst = facilityRqst;
       this.facilityAct = facilityAct;
       this.unitPriceSellUm = unitPriceSellUm;
       this.unitPriceDenomSellUm = unitPriceDenomSellUm;
       this.unitPriceStkUm = unitPriceStkUm;
       this.unitPriceDenomStkUm = unitPriceDenomStkUm;
       this.allocTypeId = allocTypeId;
       this.availDt = availDt;
       this.availDtTypeId = availDtTypeId;
       this.whPickDtlCopRqsts = whPickDtlCopRqsts;
    }
   
     @Id 

    
    @Column(name="APS_ALLOC_ONHAND_OO_NBR", unique=true, nullable=false, precision=9, scale=0)
    public int getApsAllocOnhandOoNbr() {
        return this.apsAllocOnhandOoNbr;
    }
    
    public void setApsAllocOnhandOoNbr(int apsAllocOnhandOoNbr) {
        this.apsAllocOnhandOoNbr = apsAllocOnhandOoNbr;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="WH_FACILITY_TRANS_ONHAND_NBR")
    public WhFacilityTransOnhand getWhFacilityTransOnhand() {
        return this.whFacilityTransOnhand;
    }
    
    public void setWhFacilityTransOnhand(WhFacilityTransOnhand whFacilityTransOnhand) {
        this.whFacilityTransOnhand = whFacilityTransOnhand;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ITEM_NBR_RQST", nullable=false)
    public IcItemMast getIcItemMast() {
        return this.icItemMast;
    }
    
    public void setIcItemMast(IcItemMast icItemMast) {
        this.icItemMast = icItemMast;
    }

    
    @Column(name="OE_ORD_DTL_NBR", nullable=false, precision=9, scale=0)
    public int getOeOrdDtlNbr() {
        return this.oeOrdDtlNbr;
    }
    
    public void setOeOrdDtlNbr(int oeOrdDtlNbr) {
        this.oeOrdDtlNbr = oeOrdDtlNbr;
    }

    
    @Column(name="LOT_NBR", nullable=false, precision=9, scale=0)
    public int getLotNbr() {
        return this.lotNbr;
    }
    
    public void setLotNbr(int lotNbr) {
        this.lotNbr = lotNbr;
    }

    
    @Column(name="ALLOC_QTY", nullable=false, precision=13, scale=5)
    public BigDecimal getAllocQty() {
        return this.allocQty;
    }
    
    public void setAllocQty(BigDecimal allocQty) {
        this.allocQty = allocQty;
    }

    
    @Column(name="APS_SPLY_SUB_POOL_NBR", nullable=false, precision=9, scale=0)
    public int getApsSplySubPoolNbr() {
        return this.apsSplySubPoolNbr;
    }
    
    public void setApsSplySubPoolNbr(int apsSplySubPoolNbr) {
        this.apsSplySubPoolNbr = apsSplySubPoolNbr;
    }

    
    @Column(name="SUBST_ID", length=1)
    public String getSubstId() {
        return this.substId;
    }
    
    public void setSubstId(String substId) {
        this.substId = substId;
    }

    
    @Column(name="FACILITY_RQST", nullable=false, length=16)
    public String getFacilityRqst() {
        return this.facilityRqst;
    }
    
    public void setFacilityRqst(String facilityRqst) {
        this.facilityRqst = facilityRqst;
    }

    
    @Column(name="FACILITY_ACT", nullable=false, length=16)
    public String getFacilityAct() {
        return this.facilityAct;
    }
    
    public void setFacilityAct(String facilityAct) {
        this.facilityAct = facilityAct;
    }

    
    @Column(name="UNIT_PRICE_SELL_UM", precision=17, scale=6)
    public BigDecimal getUnitPriceSellUm() {
        return this.unitPriceSellUm;
    }
    
    public void setUnitPriceSellUm(BigDecimal unitPriceSellUm) {
        this.unitPriceSellUm = unitPriceSellUm;
    }

    
    @Column(name="UNIT_PRICE_DENOM_SELL_UM", precision=17, scale=6)
    public BigDecimal getUnitPriceDenomSellUm() {
        return this.unitPriceDenomSellUm;
    }
    
    public void setUnitPriceDenomSellUm(BigDecimal unitPriceDenomSellUm) {
        this.unitPriceDenomSellUm = unitPriceDenomSellUm;
    }

    
    @Column(name="UNIT_PRICE_STK_UM", precision=17, scale=6)
    public BigDecimal getUnitPriceStkUm() {
        return this.unitPriceStkUm;
    }
    
    public void setUnitPriceStkUm(BigDecimal unitPriceStkUm) {
        this.unitPriceStkUm = unitPriceStkUm;
    }

    
    @Column(name="UNIT_PRICE_DENOM_STK_UM", precision=17, scale=6)
    public BigDecimal getUnitPriceDenomStkUm() {
        return this.unitPriceDenomStkUm;
    }
    
    public void setUnitPriceDenomStkUm(BigDecimal unitPriceDenomStkUm) {
        this.unitPriceDenomStkUm = unitPriceDenomStkUm;
    }

    
    @Column(name="ALLOC_TYPE_ID", nullable=false, length=1)
    public String getAllocTypeId() {
        return this.allocTypeId;
    }
    
    public void setAllocTypeId(String allocTypeId) {
        this.allocTypeId = allocTypeId;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="AVAIL_DT", nullable=false, length=7)
    public Date getAvailDt() {
        return this.availDt;
    }
    
    public void setAvailDt(Date availDt) {
        this.availDt = availDt;
    }

    
    @Column(name="AVAIL_DT_TYPE_ID", nullable=false, length=1)
    public String getAvailDtTypeId() {
        return this.availDtTypeId;
    }
    
    public void setAvailDtTypeId(String availDtTypeId) {
        this.availDtTypeId = availDtTypeId;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="apsAllocOnhandOo")
    public Set<WhPickDtlCopRqst> getWhPickDtlCopRqsts() {
        return this.whPickDtlCopRqsts;
    }
    
    public void setWhPickDtlCopRqsts(Set<WhPickDtlCopRqst> whPickDtlCopRqsts) {
        this.whPickDtlCopRqsts = whPickDtlCopRqsts;
    }




}


