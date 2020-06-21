package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IcItemRestrictCustId generated by hbm2java
 */
@Embeddable
public class IcItemRestrictCustId  implements java.io.Serializable {


     private int itemNbr;
     private int orgNbrCust;

    public IcItemRestrictCustId() {
    }

    public IcItemRestrictCustId(int itemNbr, int orgNbrCust) {
       this.itemNbr = itemNbr;
       this.orgNbrCust = orgNbrCust;
    }
   


    @Column(name="ITEM_NBR", nullable=false, precision=9, scale=0)
    public int getItemNbr() {
        return this.itemNbr;
    }
    
    public void setItemNbr(int itemNbr) {
        this.itemNbr = itemNbr;
    }


    @Column(name="ORG_NBR_CUST", nullable=false, precision=9, scale=0)
    public int getOrgNbrCust() {
        return this.orgNbrCust;
    }
    
    public void setOrgNbrCust(int orgNbrCust) {
        this.orgNbrCust = orgNbrCust;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof IcItemRestrictCustId) ) return false;
		 IcItemRestrictCustId castOther = ( IcItemRestrictCustId ) other; 
         
		 return (this.getItemNbr()==castOther.getItemNbr())
 && (this.getOrgNbrCust()==castOther.getOrgNbrCust());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getItemNbr();
         result = 37 * result + this.getOrgNbrCust();
         return result;
   }   


}


