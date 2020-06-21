package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * OeContractItemLogId generated by hbm2java
 */
@Embeddable
public class OeContractItemLogId  implements java.io.Serializable {


     private int orgNbrCust;
     private String contractCd;
     private String itemCdCust;
     private int itemNbr;
     private Integer itemNbrSupersede;
     private Date effDtBeg;
     private Date effDtEnd;
     private Integer totContractQty;
     private int utUserNbrMod;
     private Date modDt;

    public OeContractItemLogId() {
    }

	
    public OeContractItemLogId(int orgNbrCust, String contractCd, String itemCdCust, int itemNbr, int utUserNbrMod, Date modDt) {
        this.orgNbrCust = orgNbrCust;
        this.contractCd = contractCd;
        this.itemCdCust = itemCdCust;
        this.itemNbr = itemNbr;
        this.utUserNbrMod = utUserNbrMod;
        this.modDt = modDt;
    }
    public OeContractItemLogId(int orgNbrCust, String contractCd, String itemCdCust, int itemNbr, Integer itemNbrSupersede, Date effDtBeg, Date effDtEnd, Integer totContractQty, int utUserNbrMod, Date modDt) {
       this.orgNbrCust = orgNbrCust;
       this.contractCd = contractCd;
       this.itemCdCust = itemCdCust;
       this.itemNbr = itemNbr;
       this.itemNbrSupersede = itemNbrSupersede;
       this.effDtBeg = effDtBeg;
       this.effDtEnd = effDtEnd;
       this.totContractQty = totContractQty;
       this.utUserNbrMod = utUserNbrMod;
       this.modDt = modDt;
    }
   


    @Column(name="ORG_NBR_CUST", nullable=false, precision=9, scale=0)
    public int getOrgNbrCust() {
        return this.orgNbrCust;
    }
    
    public void setOrgNbrCust(int orgNbrCust) {
        this.orgNbrCust = orgNbrCust;
    }


    @Column(name="CONTRACT_CD", nullable=false, length=8)
    public String getContractCd() {
        return this.contractCd;
    }
    
    public void setContractCd(String contractCd) {
        this.contractCd = contractCd;
    }


    @Column(name="ITEM_CD_CUST", nullable=false, length=50)
    public String getItemCdCust() {
        return this.itemCdCust;
    }
    
    public void setItemCdCust(String itemCdCust) {
        this.itemCdCust = itemCdCust;
    }


    @Column(name="ITEM_NBR", nullable=false, precision=9, scale=0)
    public int getItemNbr() {
        return this.itemNbr;
    }
    
    public void setItemNbr(int itemNbr) {
        this.itemNbr = itemNbr;
    }


    @Column(name="ITEM_NBR_SUPERSEDE", precision=9, scale=0)
    public Integer getItemNbrSupersede() {
        return this.itemNbrSupersede;
    }
    
    public void setItemNbrSupersede(Integer itemNbrSupersede) {
        this.itemNbrSupersede = itemNbrSupersede;
    }


    @Column(name="EFF_DT_BEG", length=7)
    public Date getEffDtBeg() {
        return this.effDtBeg;
    }
    
    public void setEffDtBeg(Date effDtBeg) {
        this.effDtBeg = effDtBeg;
    }


    @Column(name="EFF_DT_END", length=7)
    public Date getEffDtEnd() {
        return this.effDtEnd;
    }
    
    public void setEffDtEnd(Date effDtEnd) {
        this.effDtEnd = effDtEnd;
    }


    @Column(name="TOT_CONTRACT_QTY", precision=9, scale=0)
    public Integer getTotContractQty() {
        return this.totContractQty;
    }
    
    public void setTotContractQty(Integer totContractQty) {
        this.totContractQty = totContractQty;
    }


    @Column(name="UT_USER_NBR_MOD", nullable=false, precision=9, scale=0)
    public int getUtUserNbrMod() {
        return this.utUserNbrMod;
    }
    
    public void setUtUserNbrMod(int utUserNbrMod) {
        this.utUserNbrMod = utUserNbrMod;
    }


    @Column(name="MOD_DT", nullable=false, length=7)
    public Date getModDt() {
        return this.modDt;
    }
    
    public void setModDt(Date modDt) {
        this.modDt = modDt;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof OeContractItemLogId) ) return false;
		 OeContractItemLogId castOther = ( OeContractItemLogId ) other; 
         
		 return (this.getOrgNbrCust()==castOther.getOrgNbrCust())
 && ( (this.getContractCd()==castOther.getContractCd()) || ( this.getContractCd()!=null && castOther.getContractCd()!=null && this.getContractCd().equals(castOther.getContractCd()) ) )
 && ( (this.getItemCdCust()==castOther.getItemCdCust()) || ( this.getItemCdCust()!=null && castOther.getItemCdCust()!=null && this.getItemCdCust().equals(castOther.getItemCdCust()) ) )
 && (this.getItemNbr()==castOther.getItemNbr())
 && ( (this.getItemNbrSupersede()==castOther.getItemNbrSupersede()) || ( this.getItemNbrSupersede()!=null && castOther.getItemNbrSupersede()!=null && this.getItemNbrSupersede().equals(castOther.getItemNbrSupersede()) ) )
 && ( (this.getEffDtBeg()==castOther.getEffDtBeg()) || ( this.getEffDtBeg()!=null && castOther.getEffDtBeg()!=null && this.getEffDtBeg().equals(castOther.getEffDtBeg()) ) )
 && ( (this.getEffDtEnd()==castOther.getEffDtEnd()) || ( this.getEffDtEnd()!=null && castOther.getEffDtEnd()!=null && this.getEffDtEnd().equals(castOther.getEffDtEnd()) ) )
 && ( (this.getTotContractQty()==castOther.getTotContractQty()) || ( this.getTotContractQty()!=null && castOther.getTotContractQty()!=null && this.getTotContractQty().equals(castOther.getTotContractQty()) ) )
 && (this.getUtUserNbrMod()==castOther.getUtUserNbrMod())
 && ( (this.getModDt()==castOther.getModDt()) || ( this.getModDt()!=null && castOther.getModDt()!=null && this.getModDt().equals(castOther.getModDt()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getOrgNbrCust();
         result = 37 * result + ( getContractCd() == null ? 0 : this.getContractCd().hashCode() );
         result = 37 * result + ( getItemCdCust() == null ? 0 : this.getItemCdCust().hashCode() );
         result = 37 * result + this.getItemNbr();
         result = 37 * result + ( getItemNbrSupersede() == null ? 0 : this.getItemNbrSupersede().hashCode() );
         result = 37 * result + ( getEffDtBeg() == null ? 0 : this.getEffDtBeg().hashCode() );
         result = 37 * result + ( getEffDtEnd() == null ? 0 : this.getEffDtEnd().hashCode() );
         result = 37 * result + ( getTotContractQty() == null ? 0 : this.getTotContractQty().hashCode() );
         result = 37 * result + this.getUtUserNbrMod();
         result = 37 * result + ( getModDt() == null ? 0 : this.getModDt().hashCode() );
         return result;
   }   


}


