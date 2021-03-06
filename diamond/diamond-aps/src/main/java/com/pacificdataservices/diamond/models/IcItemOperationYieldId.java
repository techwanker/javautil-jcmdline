package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IcItemOperationYieldId generated by hbm2java
 */
@Embeddable
public class IcItemOperationYieldId  implements java.io.Serializable {


     private int itemNbr;
     private String operationCd;

    public IcItemOperationYieldId() {
    }

    public IcItemOperationYieldId(int itemNbr, String operationCd) {
       this.itemNbr = itemNbr;
       this.operationCd = operationCd;
    }
   


    @Column(name="ITEM_NBR", nullable=false, precision=9, scale=0)
    public int getItemNbr() {
        return this.itemNbr;
    }
    
    public void setItemNbr(int itemNbr) {
        this.itemNbr = itemNbr;
    }


    @Column(name="OPERATION_CD", nullable=false, length=16)
    public String getOperationCd() {
        return this.operationCd;
    }
    
    public void setOperationCd(String operationCd) {
        this.operationCd = operationCd;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof IcItemOperationYieldId) ) return false;
		 IcItemOperationYieldId castOther = ( IcItemOperationYieldId ) other; 
         
		 return (this.getItemNbr()==castOther.getItemNbr())
 && ( (this.getOperationCd()==castOther.getOperationCd()) || ( this.getOperationCd()!=null && castOther.getOperationCd()!=null && this.getOperationCd().equals(castOther.getOperationCd()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getItemNbr();
         result = 37 * result + ( getOperationCd() == null ? 0 : this.getOperationCd().hashCode() );
         return result;
   }   


}


