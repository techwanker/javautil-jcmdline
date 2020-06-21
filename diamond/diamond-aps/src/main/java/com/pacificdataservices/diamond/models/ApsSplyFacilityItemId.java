package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ApsSplyFacilityItemId generated by hbm2java
 */
@Embeddable
public class ApsSplyFacilityItemId  implements java.io.Serializable {


     private int itemNbr;
     private String facility;
     private int apsSplySubPoolNbr;

    public ApsSplyFacilityItemId() {
    }

    public ApsSplyFacilityItemId(int itemNbr, String facility, int apsSplySubPoolNbr) {
       this.itemNbr = itemNbr;
       this.facility = facility;
       this.apsSplySubPoolNbr = apsSplySubPoolNbr;
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


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ApsSplyFacilityItemId) ) return false;
		 ApsSplyFacilityItemId castOther = ( ApsSplyFacilityItemId ) other; 
         
		 return (this.getItemNbr()==castOther.getItemNbr())
 && ( (this.getFacility()==castOther.getFacility()) || ( this.getFacility()!=null && castOther.getFacility()!=null && this.getFacility().equals(castOther.getFacility()) ) )
 && (this.getApsSplySubPoolNbr()==castOther.getApsSplySubPoolNbr());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getItemNbr();
         result = 37 * result + ( getFacility() == null ? 0 : this.getFacility().hashCode() );
         result = 37 * result + this.getApsSplySubPoolNbr();
         return result;
   }   


}


