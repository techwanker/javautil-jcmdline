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
 * ApsAvailWo generated by hbm2java
 */
@Entity
@Table(name="APS_AVAIL_WO"
)
public class ApsAvailWo  implements java.io.Serializable {


     private String splyIdentifier;
     private int itemNbr;
     private String facility;
     private int apsSplySubPoolNbr;
     private Date availDt;
     private BigDecimal grossAvailQty;
     private String woUm;
     private int woHdrNbr;

    public ApsAvailWo() {
    }

	
    public ApsAvailWo(String splyIdentifier, int itemNbr, String facility, int apsSplySubPoolNbr, Date availDt, String woUm, int woHdrNbr) {
        this.splyIdentifier = splyIdentifier;
        this.itemNbr = itemNbr;
        this.facility = facility;
        this.apsSplySubPoolNbr = apsSplySubPoolNbr;
        this.availDt = availDt;
        this.woUm = woUm;
        this.woHdrNbr = woHdrNbr;
    }
    public ApsAvailWo(String splyIdentifier, int itemNbr, String facility, int apsSplySubPoolNbr, Date availDt, BigDecimal grossAvailQty, String woUm, int woHdrNbr) {
       this.splyIdentifier = splyIdentifier;
       this.itemNbr = itemNbr;
       this.facility = facility;
       this.apsSplySubPoolNbr = apsSplySubPoolNbr;
       this.availDt = availDt;
       this.grossAvailQty = grossAvailQty;
       this.woUm = woUm;
       this.woHdrNbr = woHdrNbr;
    }
   
     @Id 

    
    @Column(name="SPLY_IDENTIFIER", nullable=false, length=40)
    public String getSplyIdentifier() {
        return this.splyIdentifier;
    }
    
    public void setSplyIdentifier(String splyIdentifier) {
        this.splyIdentifier = splyIdentifier;
    }

    
    @Column(name="ITEM_NBR", nullable=false, precision=9, scale=0)
    public int getItemNbr() {
        return this.itemNbr;
    }
    
    public void setItemNbr(int itemNbr) {
        this.itemNbr = itemNbr;
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

    @Temporal(TemporalType.DATE)
    @Column(name="AVAIL_DT", nullable=false, length=7)
    public Date getAvailDt() {
        return this.availDt;
    }
    
    public void setAvailDt(Date availDt) {
        this.availDt = availDt;
    }

    
    @Column(name="GROSS_AVAIL_QTY", precision=22, scale=0)
    public BigDecimal getGrossAvailQty() {
        return this.grossAvailQty;
    }
    
    public void setGrossAvailQty(BigDecimal grossAvailQty) {
        this.grossAvailQty = grossAvailQty;
    }

    
    @Column(name="WO_UM", nullable=false, length=3)
    public String getWoUm() {
        return this.woUm;
    }
    
    public void setWoUm(String woUm) {
        this.woUm = woUm;
    }

    
    @Column(name="WO_HDR_NBR", nullable=false, precision=9, scale=0)
    public int getWoHdrNbr() {
        return this.woHdrNbr;
    }
    
    public void setWoHdrNbr(int woHdrNbr) {
        this.woHdrNbr = woHdrNbr;
    }




}


