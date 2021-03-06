package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * FcHistDistId generated by hbm2java
 */
@Embeddable
public class FcHistDistId  implements java.io.Serializable {


     private int fcItemMastNbr;
     private Integer itemNbr;
     private String itemCd;
     private BigDecimal hist;
     private BigDecimal pctDistHist;

    public FcHistDistId() {
    }

	
    public FcHistDistId(int fcItemMastNbr) {
        this.fcItemMastNbr = fcItemMastNbr;
    }
    public FcHistDistId(int fcItemMastNbr, Integer itemNbr, String itemCd, BigDecimal hist, BigDecimal pctDistHist) {
       this.fcItemMastNbr = fcItemMastNbr;
       this.itemNbr = itemNbr;
       this.itemCd = itemCd;
       this.hist = hist;
       this.pctDistHist = pctDistHist;
    }
   


    @Column(name="FC_ITEM_MAST_NBR", unique=true, nullable=false, precision=9, scale=0)
    public int getFcItemMastNbr() {
        return this.fcItemMastNbr;
    }
    
    public void setFcItemMastNbr(int fcItemMastNbr) {
        this.fcItemMastNbr = fcItemMastNbr;
    }


    @Column(name="ITEM_NBR", precision=9, scale=0)
    public Integer getItemNbr() {
        return this.itemNbr;
    }
    
    public void setItemNbr(Integer itemNbr) {
        this.itemNbr = itemNbr;
    }


    @Column(name="ITEM_CD", length=50)
    public String getItemCd() {
        return this.itemCd;
    }
    
    public void setItemCd(String itemCd) {
        this.itemCd = itemCd;
    }


    @Column(name="HIST", precision=22, scale=0)
    public BigDecimal getHist() {
        return this.hist;
    }
    
    public void setHist(BigDecimal hist) {
        this.hist = hist;
    }


    @Column(name="PCT_DIST_HIST", precision=22, scale=0)
    public BigDecimal getPctDistHist() {
        return this.pctDistHist;
    }
    
    public void setPctDistHist(BigDecimal pctDistHist) {
        this.pctDistHist = pctDistHist;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof FcHistDistId) ) return false;
		 FcHistDistId castOther = ( FcHistDistId ) other; 
         
		 return (this.getFcItemMastNbr()==castOther.getFcItemMastNbr())
 && ( (this.getItemNbr()==castOther.getItemNbr()) || ( this.getItemNbr()!=null && castOther.getItemNbr()!=null && this.getItemNbr().equals(castOther.getItemNbr()) ) )
 && ( (this.getItemCd()==castOther.getItemCd()) || ( this.getItemCd()!=null && castOther.getItemCd()!=null && this.getItemCd().equals(castOther.getItemCd()) ) )
 && ( (this.getHist()==castOther.getHist()) || ( this.getHist()!=null && castOther.getHist()!=null && this.getHist().equals(castOther.getHist()) ) )
 && ( (this.getPctDistHist()==castOther.getPctDistHist()) || ( this.getPctDistHist()!=null && castOther.getPctDistHist()!=null && this.getPctDistHist().equals(castOther.getPctDistHist()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getFcItemMastNbr();
         result = 37 * result + ( getItemNbr() == null ? 0 : this.getItemNbr().hashCode() );
         result = 37 * result + ( getItemCd() == null ? 0 : this.getItemCd().hashCode() );
         result = 37 * result + ( getHist() == null ? 0 : this.getHist().hashCode() );
         result = 37 * result + ( getPctDistHist() == null ? 0 : this.getPctDistHist().hashCode() );
         return result;
   }   


}


