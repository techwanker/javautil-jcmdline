package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IcItemVndCostMatrixId generated by hbm2java
 */
@Embeddable
public class IcItemVndCostMatrixId  implements java.io.Serializable {


     private int itemNbr;
     private int orgNbrVnd;
     private BigDecimal qtyOrd;
     private String unitCostCurrCd;

    public IcItemVndCostMatrixId() {
    }

    public IcItemVndCostMatrixId(int itemNbr, int orgNbrVnd, BigDecimal qtyOrd, String unitCostCurrCd) {
       this.itemNbr = itemNbr;
       this.orgNbrVnd = orgNbrVnd;
       this.qtyOrd = qtyOrd;
       this.unitCostCurrCd = unitCostCurrCd;
    }
   


    @Column(name="ITEM_NBR", nullable=false, precision=9, scale=0)
    public int getItemNbr() {
        return this.itemNbr;
    }
    
    public void setItemNbr(int itemNbr) {
        this.itemNbr = itemNbr;
    }


    @Column(name="ORG_NBR_VND", nullable=false, precision=9, scale=0)
    public int getOrgNbrVnd() {
        return this.orgNbrVnd;
    }
    
    public void setOrgNbrVnd(int orgNbrVnd) {
        this.orgNbrVnd = orgNbrVnd;
    }


    @Column(name="QTY_ORD", nullable=false, precision=13, scale=5)
    public BigDecimal getQtyOrd() {
        return this.qtyOrd;
    }
    
    public void setQtyOrd(BigDecimal qtyOrd) {
        this.qtyOrd = qtyOrd;
    }


    @Column(name="UNIT_COST_CURR_CD", nullable=false, length=3)
    public String getUnitCostCurrCd() {
        return this.unitCostCurrCd;
    }
    
    public void setUnitCostCurrCd(String unitCostCurrCd) {
        this.unitCostCurrCd = unitCostCurrCd;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof IcItemVndCostMatrixId) ) return false;
		 IcItemVndCostMatrixId castOther = ( IcItemVndCostMatrixId ) other; 
         
		 return (this.getItemNbr()==castOther.getItemNbr())
 && (this.getOrgNbrVnd()==castOther.getOrgNbrVnd())
 && ( (this.getQtyOrd()==castOther.getQtyOrd()) || ( this.getQtyOrd()!=null && castOther.getQtyOrd()!=null && this.getQtyOrd().equals(castOther.getQtyOrd()) ) )
 && ( (this.getUnitCostCurrCd()==castOther.getUnitCostCurrCd()) || ( this.getUnitCostCurrCd()!=null && castOther.getUnitCostCurrCd()!=null && this.getUnitCostCurrCd().equals(castOther.getUnitCostCurrCd()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getItemNbr();
         result = 37 * result + this.getOrgNbrVnd();
         result = 37 * result + ( getQtyOrd() == null ? 0 : this.getQtyOrd().hashCode() );
         result = 37 * result + ( getUnitCostCurrCd() == null ? 0 : this.getUnitCostCurrCd().hashCode() );
         return result;
   }   


}

