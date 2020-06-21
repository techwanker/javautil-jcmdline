package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IcItemPriceMatrixId generated by hbm2java
 */
@Embeddable
public class IcItemPriceMatrixId  implements java.io.Serializable {


     private int itemNbr;
     private BigDecimal qtyOrd;
     private String currCd;

    public IcItemPriceMatrixId() {
    }

    public IcItemPriceMatrixId(int itemNbr, BigDecimal qtyOrd, String currCd) {
       this.itemNbr = itemNbr;
       this.qtyOrd = qtyOrd;
       this.currCd = currCd;
    }
   


    @Column(name="ITEM_NBR", nullable=false, precision=9, scale=0)
    public int getItemNbr() {
        return this.itemNbr;
    }
    
    public void setItemNbr(int itemNbr) {
        this.itemNbr = itemNbr;
    }


    @Column(name="QTY_ORD", nullable=false, precision=13, scale=5)
    public BigDecimal getQtyOrd() {
        return this.qtyOrd;
    }
    
    public void setQtyOrd(BigDecimal qtyOrd) {
        this.qtyOrd = qtyOrd;
    }


    @Column(name="CURR_CD", nullable=false, length=3)
    public String getCurrCd() {
        return this.currCd;
    }
    
    public void setCurrCd(String currCd) {
        this.currCd = currCd;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof IcItemPriceMatrixId) ) return false;
		 IcItemPriceMatrixId castOther = ( IcItemPriceMatrixId ) other; 
         
		 return (this.getItemNbr()==castOther.getItemNbr())
 && ( (this.getQtyOrd()==castOther.getQtyOrd()) || ( this.getQtyOrd()!=null && castOther.getQtyOrd()!=null && this.getQtyOrd().equals(castOther.getQtyOrd()) ) )
 && ( (this.getCurrCd()==castOther.getCurrCd()) || ( this.getCurrCd()!=null && castOther.getCurrCd()!=null && this.getCurrCd().equals(castOther.getCurrCd()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getItemNbr();
         result = 37 * result + ( getQtyOrd() == null ? 0 : this.getQtyOrd().hashCode() );
         result = 37 * result + ( getCurrCd() == null ? 0 : this.getCurrCd().hashCode() );
         return result;
   }   


}


