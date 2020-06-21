package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * OeContractItemId generated by hbm2java
 */
@Embeddable
public class OeContractItemId  implements java.io.Serializable {


     private String itemCdCust;
     private String contractCd;
     private int orgNbrCust;

    public OeContractItemId() {
    }

    public OeContractItemId(String itemCdCust, String contractCd, int orgNbrCust) {
       this.itemCdCust = itemCdCust;
       this.contractCd = contractCd;
       this.orgNbrCust = orgNbrCust;
    }
   


    @Column(name="ITEM_CD_CUST", nullable=false, length=50)
    public String getItemCdCust() {
        return this.itemCdCust;
    }
    
    public void setItemCdCust(String itemCdCust) {
        this.itemCdCust = itemCdCust;
    }


    @Column(name="CONTRACT_CD", nullable=false, length=8)
    public String getContractCd() {
        return this.contractCd;
    }
    
    public void setContractCd(String contractCd) {
        this.contractCd = contractCd;
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
		 if ( !(other instanceof OeContractItemId) ) return false;
		 OeContractItemId castOther = ( OeContractItemId ) other; 
         
		 return ( (this.getItemCdCust()==castOther.getItemCdCust()) || ( this.getItemCdCust()!=null && castOther.getItemCdCust()!=null && this.getItemCdCust().equals(castOther.getItemCdCust()) ) )
 && ( (this.getContractCd()==castOther.getContractCd()) || ( this.getContractCd()!=null && castOther.getContractCd()!=null && this.getContractCd().equals(castOther.getContractCd()) ) )
 && (this.getOrgNbrCust()==castOther.getOrgNbrCust());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getItemCdCust() == null ? 0 : this.getItemCdCust().hashCode() );
         result = 37 * result + ( getContractCd() == null ? 0 : this.getContractCd().hashCode() );
         result = 37 * result + this.getOrgNbrCust();
         return result;
   }   


}


