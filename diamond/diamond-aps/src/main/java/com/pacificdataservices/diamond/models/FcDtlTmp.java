package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import java.math.BigDecimal;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * FcDtlTmp generated by hbm2java
 */
@Entity
@Table(name="FC_DTL_TMP"
)
public class FcDtlTmp  implements java.io.Serializable {


     private FcDtlTmpId id;
     private int fcItemMastNbr;
     private int itemNbr;
     private String itemCd;
     private BigDecimal rawFcstTot;

    public FcDtlTmp() {
    }

	
    public FcDtlTmp(FcDtlTmpId id, int fcItemMastNbr, int itemNbr, String itemCd) {
        this.id = id;
        this.fcItemMastNbr = fcItemMastNbr;
        this.itemNbr = itemNbr;
        this.itemCd = itemCd;
    }
    public FcDtlTmp(FcDtlTmpId id, int fcItemMastNbr, int itemNbr, String itemCd, BigDecimal rawFcstTot) {
       this.id = id;
       this.fcItemMastNbr = fcItemMastNbr;
       this.itemNbr = itemNbr;
       this.itemCd = itemCd;
       this.rawFcstTot = rawFcstTot;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="userFld1", column=@Column(name="USER_FLD_1", nullable=false, length=20) ), 
        @AttributeOverride(name="userFld2", column=@Column(name="USER_FLD_2", nullable=false, length=20) ), 
        @AttributeOverride(name="userFld3", column=@Column(name="USER_FLD_3", nullable=false, length=20) ) } )
    public FcDtlTmpId getId() {
        return this.id;
    }
    
    public void setId(FcDtlTmpId id) {
        this.id = id;
    }

    
    @Column(name="FC_ITEM_MAST_NBR", unique=true, nullable=false, precision=9, scale=0)
    public int getFcItemMastNbr() {
        return this.fcItemMastNbr;
    }
    
    public void setFcItemMastNbr(int fcItemMastNbr) {
        this.fcItemMastNbr = fcItemMastNbr;
    }

    
    @Column(name="ITEM_NBR", nullable=false, precision=9, scale=0)
    public int getItemNbr() {
        return this.itemNbr;
    }
    
    public void setItemNbr(int itemNbr) {
        this.itemNbr = itemNbr;
    }

    
    @Column(name="ITEM_CD", nullable=false, length=50)
    public String getItemCd() {
        return this.itemCd;
    }
    
    public void setItemCd(String itemCd) {
        this.itemCd = itemCd;
    }

    
    @Column(name="RAW_FCST_TOT", precision=22, scale=0)
    public BigDecimal getRawFcstTot() {
        return this.rawFcstTot;
    }
    
    public void setRawFcstTot(BigDecimal rawFcstTot) {
        this.rawFcstTot = rawFcstTot;
    }




}


