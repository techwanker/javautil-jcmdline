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
 * IdlIcItemMast generated by hbm2java
 */
@Entity
@Table(name="IDL_IC_ITEM_MAST"
)
public class IdlIcItemMast  implements java.io.Serializable {


     private int idlIcItemMastNbr;
     private String itemCd;
     private String itemDescr;
     private String stkUm;
     private BigDecimal stdCost;
     private String icCategoryNm;
     private Date introDt;
     private BigDecimal listPrice;

    public IdlIcItemMast() {
    }

	
    public IdlIcItemMast(int idlIcItemMastNbr, String itemCd, String stkUm) {
        this.idlIcItemMastNbr = idlIcItemMastNbr;
        this.itemCd = itemCd;
        this.stkUm = stkUm;
    }
    public IdlIcItemMast(int idlIcItemMastNbr, String itemCd, String itemDescr, String stkUm, BigDecimal stdCost, String icCategoryNm, Date introDt, BigDecimal listPrice) {
       this.idlIcItemMastNbr = idlIcItemMastNbr;
       this.itemCd = itemCd;
       this.itemDescr = itemDescr;
       this.stkUm = stkUm;
       this.stdCost = stdCost;
       this.icCategoryNm = icCategoryNm;
       this.introDt = introDt;
       this.listPrice = listPrice;
    }
   
     @Id 

    
    @Column(name="IDL_IC_ITEM_MAST_NBR", unique=true, nullable=false, precision=9, scale=0)
    public int getIdlIcItemMastNbr() {
        return this.idlIcItemMastNbr;
    }
    
    public void setIdlIcItemMastNbr(int idlIcItemMastNbr) {
        this.idlIcItemMastNbr = idlIcItemMastNbr;
    }

    
    @Column(name="ITEM_CD", nullable=false, length=50)
    public String getItemCd() {
        return this.itemCd;
    }
    
    public void setItemCd(String itemCd) {
        this.itemCd = itemCd;
    }

    
    @Column(name="ITEM_DESCR", length=50)
    public String getItemDescr() {
        return this.itemDescr;
    }
    
    public void setItemDescr(String itemDescr) {
        this.itemDescr = itemDescr;
    }

    
    @Column(name="STK_UM", nullable=false, length=3)
    public String getStkUm() {
        return this.stkUm;
    }
    
    public void setStkUm(String stkUm) {
        this.stkUm = stkUm;
    }

    
    @Column(name="STD_COST", precision=22, scale=0)
    public BigDecimal getStdCost() {
        return this.stdCost;
    }
    
    public void setStdCost(BigDecimal stdCost) {
        this.stdCost = stdCost;
    }

    
    @Column(name="IC_CATEGORY_NM", length=16)
    public String getIcCategoryNm() {
        return this.icCategoryNm;
    }
    
    public void setIcCategoryNm(String icCategoryNm) {
        this.icCategoryNm = icCategoryNm;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="INTRO_DT", length=7)
    public Date getIntroDt() {
        return this.introDt;
    }
    
    public void setIntroDt(Date introDt) {
        this.introDt = introDt;
    }

    
    @Column(name="LIST_PRICE", precision=22, scale=0)
    public BigDecimal getListPrice() {
        return this.listPrice;
    }
    
    public void setListPrice(BigDecimal listPrice) {
        this.listPrice = listPrice;
    }




}


