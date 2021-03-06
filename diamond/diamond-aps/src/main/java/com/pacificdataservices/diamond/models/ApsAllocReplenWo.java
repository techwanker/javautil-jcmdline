package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ApsAllocReplenWo generated by hbm2java
 */
@Entity
@Table(name="APS_ALLOC_REPLEN_WO"
)
public class ApsAllocReplenWo  implements java.io.Serializable,  AllocReplen {


     private int apsAllocReplenWoNbr;
     private WhFacilityTransReplen whFacilityTransReplen;
     private IcItemMast icItemMast;
     private int woDtlNbr;
     private int poLineDtlNbr;
     private BigDecimal allocQty;
     private String facilityRqst;
     private String facilityAct;
     private String allocTypeId;
	private int apsSplySubPoolNbr;

    public ApsAllocReplenWo() {
    }

	  @Id 

    
    @Column(name="APS_ALLOC_REPLEN_WO_NBR", unique=true, nullable=false, precision=9, scale=0)
    public int getApsAllocReplenWoNbr() {
        return this.apsAllocReplenWoNbr;
    }
    
    public void setApsAllocReplenWoNbr(int apsAllocReplenWoNbr) {
        this.apsAllocReplenWoNbr = apsAllocReplenWoNbr;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="WH_FACILITY_TRANS_REPLEN_NBR")
    public WhFacilityTransReplen getWhFacilityTransReplen() {
        return this.whFacilityTransReplen;
    }
    
    public void setWhFacilityTransReplen(WhFacilityTransReplen whFacilityTransReplen) {
        this.whFacilityTransReplen = whFacilityTransReplen;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ITEM_NBR_RQST", nullable=false)
    public IcItemMast getIcItemMast() {
        return this.icItemMast;
    }
    
    public void setIcItemMast(IcItemMast icItemMast) {
        this.icItemMast = icItemMast;
    }

    
    @Column(name="WO_DTL_NBR", nullable=false, precision=9, scale=0)
    public int getWoDtlNbr() {
        return this.woDtlNbr;
    }
    
    public void setWoDtlNbr(int woDtlNbr) {
        this.woDtlNbr = woDtlNbr;
    }

    
    @Column(name="PO_LINE_DTL_NBR", nullable=false, precision=9, scale=0)
    public int getPoLineDtlNbr() {
        return this.poLineDtlNbr;
    }
    
    public void setPoLineDtlNbr(int poLineDtlNbr) {
        this.poLineDtlNbr = poLineDtlNbr;
    }

    
    @Column(name="ALLOC_QTY", nullable=false, precision=13, scale=5)
    public BigDecimal getAllocQty() {
        return this.allocQty;
    }
    
    public void setAllocQty(BigDecimal allocQty) {
        this.allocQty = allocQty;
    }

    
    @Column(name="FACILITY_RQST", nullable=false, length=16)
    public String getFacilityRqst() {
        return this.facilityRqst;
    }
    
    public void setFacilityRqst(String facilityRqst) {
        this.facilityRqst = facilityRqst;
    }

    
    @Column(name="FACILITY_ACT", length=16)
    public String getFacilityAct() {
        return this.facilityAct;
    }
    
    public void setFacilityAct(String facilityAct) {
        this.facilityAct = facilityAct;
    }

    
    @Column(name="ALLOC_TYPE_ID", nullable=false, length=1)
    public String getAllocTypeId() {
        return this.allocTypeId;
    }
    
    public void setAllocTypeId(String allocTypeId) {
        this.allocTypeId = allocTypeId;
    }


    @Column(name="APS_SPLY_SUB_POOL_NBR", nullable=false, precision=9, scale=0)
    public int getApsSplySubPoolNbr() {
    	return this.apsSplySubPoolNbr;
    }
    
	@Override
	public void setApsSplySubPoolNbr(Integer apsSplySubPoolNbr) {
		this.apsSplySubPoolNbr = apsSplySubPoolNbr;
	}



}


