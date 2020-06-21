package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ApsItemGlobalSubstId generated by hbm2java
 */
@Embeddable
public class ApsItemGlobalSubstId  implements java.io.Serializable {


     private int itemNbr;
     private int itemNbrSubst;

    public ApsItemGlobalSubstId() {
    }

    public ApsItemGlobalSubstId(int itemNbr, int itemNbrSubst) {
       this.itemNbr = itemNbr;
       this.itemNbrSubst = itemNbrSubst;
    }
   


    @Column(name="ITEM_NBR", nullable=false, precision=9, scale=0)
    public int getItemNbr() {
        return this.itemNbr;
    }
    
    public void setItemNbr(int itemNbr) {
        this.itemNbr = itemNbr;
    }


    @Column(name="ITEM_NBR_SUBST", nullable=false, precision=9, scale=0)
    public int getItemNbrSubst() {
        return this.itemNbrSubst;
    }
    
    public void setItemNbrSubst(int itemNbrSubst) {
        this.itemNbrSubst = itemNbrSubst;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ApsItemGlobalSubstId) ) return false;
		 ApsItemGlobalSubstId castOther = ( ApsItemGlobalSubstId ) other; 
         
		 return (this.getItemNbr()==castOther.getItemNbr())
 && (this.getItemNbrSubst()==castOther.getItemNbrSubst());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getItemNbr();
         result = 37 * result + this.getItemNbrSubst();
         return result;
   }   


}


