package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TmpApsDmdFcPrdId generated by hbm2java
 */
@Embeddable
public class TmpApsDmdFcPrdId  implements java.io.Serializable {


     private Serializable dmdTypeCd;
     private Serializable dmdCd;
     private Serializable itemNbrDmd;
     private Serializable rqstDt;
     private Serializable apsSrcRuleSetNbr;
     private Serializable orgNbrCust;
     private Serializable orgCdCust;
     private Serializable openQty;
     private Serializable openQtyAdj;
     private Serializable contractCustFlg;
     private Serializable custAllocPrty;
     private Serializable revLvl;
     private Serializable orgNbrMfrRqst;
     private Serializable identifier;
     private Serializable fcItemMastNbr;
     private Serializable fcstGrp;

    public TmpApsDmdFcPrdId() {
    }

    public TmpApsDmdFcPrdId(Serializable dmdTypeCd, Serializable dmdCd, Serializable itemNbrDmd, Serializable rqstDt, Serializable apsSrcRuleSetNbr, Serializable orgNbrCust, Serializable orgCdCust, Serializable openQty, Serializable openQtyAdj, Serializable contractCustFlg, Serializable custAllocPrty, Serializable revLvl, Serializable orgNbrMfrRqst, Serializable identifier, Serializable fcItemMastNbr, Serializable fcstGrp) {
       this.dmdTypeCd = dmdTypeCd;
       this.dmdCd = dmdCd;
       this.itemNbrDmd = itemNbrDmd;
       this.rqstDt = rqstDt;
       this.apsSrcRuleSetNbr = apsSrcRuleSetNbr;
       this.orgNbrCust = orgNbrCust;
       this.orgCdCust = orgCdCust;
       this.openQty = openQty;
       this.openQtyAdj = openQtyAdj;
       this.contractCustFlg = contractCustFlg;
       this.custAllocPrty = custAllocPrty;
       this.revLvl = revLvl;
       this.orgNbrMfrRqst = orgNbrMfrRqst;
       this.identifier = identifier;
       this.fcItemMastNbr = fcItemMastNbr;
       this.fcstGrp = fcstGrp;
    }
   


    @Column(name="DMD_TYPE_CD")
    public Serializable getDmdTypeCd() {
        return this.dmdTypeCd;
    }
    
    public void setDmdTypeCd(Serializable dmdTypeCd) {
        this.dmdTypeCd = dmdTypeCd;
    }


    @Column(name="DMD_CD")
    public Serializable getDmdCd() {
        return this.dmdCd;
    }
    
    public void setDmdCd(Serializable dmdCd) {
        this.dmdCd = dmdCd;
    }


    @Column(name="ITEM_NBR_DMD")
    public Serializable getItemNbrDmd() {
        return this.itemNbrDmd;
    }
    
    public void setItemNbrDmd(Serializable itemNbrDmd) {
        this.itemNbrDmd = itemNbrDmd;
    }


    @Column(name="RQST_DT")
    public Serializable getRqstDt() {
        return this.rqstDt;
    }
    
    public void setRqstDt(Serializable rqstDt) {
        this.rqstDt = rqstDt;
    }


    @Column(name="APS_SRC_RULE_SET_NBR")
    public Serializable getApsSrcRuleSetNbr() {
        return this.apsSrcRuleSetNbr;
    }
    
    public void setApsSrcRuleSetNbr(Serializable apsSrcRuleSetNbr) {
        this.apsSrcRuleSetNbr = apsSrcRuleSetNbr;
    }


    @Column(name="ORG_NBR_CUST")
    public Serializable getOrgNbrCust() {
        return this.orgNbrCust;
    }
    
    public void setOrgNbrCust(Serializable orgNbrCust) {
        this.orgNbrCust = orgNbrCust;
    }


    @Column(name="ORG_CD_CUST")
    public Serializable getOrgCdCust() {
        return this.orgCdCust;
    }
    
    public void setOrgCdCust(Serializable orgCdCust) {
        this.orgCdCust = orgCdCust;
    }


    @Column(name="OPEN_QTY")
    public Serializable getOpenQty() {
        return this.openQty;
    }
    
    public void setOpenQty(Serializable openQty) {
        this.openQty = openQty;
    }


    @Column(name="OPEN_QTY_ADJ")
    public Serializable getOpenQtyAdj() {
        return this.openQtyAdj;
    }
    
    public void setOpenQtyAdj(Serializable openQtyAdj) {
        this.openQtyAdj = openQtyAdj;
    }


    @Column(name="CONTRACT_CUST_FLG")
    public Serializable getContractCustFlg() {
        return this.contractCustFlg;
    }
    
    public void setContractCustFlg(Serializable contractCustFlg) {
        this.contractCustFlg = contractCustFlg;
    }


    @Column(name="CUST_ALLOC_PRTY")
    public Serializable getCustAllocPrty() {
        return this.custAllocPrty;
    }
    
    public void setCustAllocPrty(Serializable custAllocPrty) {
        this.custAllocPrty = custAllocPrty;
    }


    @Column(name="REV_LVL")
    public Serializable getRevLvl() {
        return this.revLvl;
    }
    
    public void setRevLvl(Serializable revLvl) {
        this.revLvl = revLvl;
    }


    @Column(name="ORG_NBR_MFR_RQST")
    public Serializable getOrgNbrMfrRqst() {
        return this.orgNbrMfrRqst;
    }
    
    public void setOrgNbrMfrRqst(Serializable orgNbrMfrRqst) {
        this.orgNbrMfrRqst = orgNbrMfrRqst;
    }


    @Column(name="IDENTIFIER")
    public Serializable getIdentifier() {
        return this.identifier;
    }
    
    public void setIdentifier(Serializable identifier) {
        this.identifier = identifier;
    }


    @Column(name="FC_ITEM_MAST_NBR")
    public Serializable getFcItemMastNbr() {
        return this.fcItemMastNbr;
    }
    
    public void setFcItemMastNbr(Serializable fcItemMastNbr) {
        this.fcItemMastNbr = fcItemMastNbr;
    }


    @Column(name="FCST_GRP")
    public Serializable getFcstGrp() {
        return this.fcstGrp;
    }
    
    public void setFcstGrp(Serializable fcstGrp) {
        this.fcstGrp = fcstGrp;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof TmpApsDmdFcPrdId) ) return false;
		 TmpApsDmdFcPrdId castOther = ( TmpApsDmdFcPrdId ) other; 
         
		 return ( (this.getDmdTypeCd()==castOther.getDmdTypeCd()) || ( this.getDmdTypeCd()!=null && castOther.getDmdTypeCd()!=null && this.getDmdTypeCd().equals(castOther.getDmdTypeCd()) ) )
 && ( (this.getDmdCd()==castOther.getDmdCd()) || ( this.getDmdCd()!=null && castOther.getDmdCd()!=null && this.getDmdCd().equals(castOther.getDmdCd()) ) )
 && ( (this.getItemNbrDmd()==castOther.getItemNbrDmd()) || ( this.getItemNbrDmd()!=null && castOther.getItemNbrDmd()!=null && this.getItemNbrDmd().equals(castOther.getItemNbrDmd()) ) )
 && ( (this.getRqstDt()==castOther.getRqstDt()) || ( this.getRqstDt()!=null && castOther.getRqstDt()!=null && this.getRqstDt().equals(castOther.getRqstDt()) ) )
 && ( (this.getApsSrcRuleSetNbr()==castOther.getApsSrcRuleSetNbr()) || ( this.getApsSrcRuleSetNbr()!=null && castOther.getApsSrcRuleSetNbr()!=null && this.getApsSrcRuleSetNbr().equals(castOther.getApsSrcRuleSetNbr()) ) )
 && ( (this.getOrgNbrCust()==castOther.getOrgNbrCust()) || ( this.getOrgNbrCust()!=null && castOther.getOrgNbrCust()!=null && this.getOrgNbrCust().equals(castOther.getOrgNbrCust()) ) )
 && ( (this.getOrgCdCust()==castOther.getOrgCdCust()) || ( this.getOrgCdCust()!=null && castOther.getOrgCdCust()!=null && this.getOrgCdCust().equals(castOther.getOrgCdCust()) ) )
 && ( (this.getOpenQty()==castOther.getOpenQty()) || ( this.getOpenQty()!=null && castOther.getOpenQty()!=null && this.getOpenQty().equals(castOther.getOpenQty()) ) )
 && ( (this.getOpenQtyAdj()==castOther.getOpenQtyAdj()) || ( this.getOpenQtyAdj()!=null && castOther.getOpenQtyAdj()!=null && this.getOpenQtyAdj().equals(castOther.getOpenQtyAdj()) ) )
 && ( (this.getContractCustFlg()==castOther.getContractCustFlg()) || ( this.getContractCustFlg()!=null && castOther.getContractCustFlg()!=null && this.getContractCustFlg().equals(castOther.getContractCustFlg()) ) )
 && ( (this.getCustAllocPrty()==castOther.getCustAllocPrty()) || ( this.getCustAllocPrty()!=null && castOther.getCustAllocPrty()!=null && this.getCustAllocPrty().equals(castOther.getCustAllocPrty()) ) )
 && ( (this.getRevLvl()==castOther.getRevLvl()) || ( this.getRevLvl()!=null && castOther.getRevLvl()!=null && this.getRevLvl().equals(castOther.getRevLvl()) ) )
 && ( (this.getOrgNbrMfrRqst()==castOther.getOrgNbrMfrRqst()) || ( this.getOrgNbrMfrRqst()!=null && castOther.getOrgNbrMfrRqst()!=null && this.getOrgNbrMfrRqst().equals(castOther.getOrgNbrMfrRqst()) ) )
 && ( (this.getIdentifier()==castOther.getIdentifier()) || ( this.getIdentifier()!=null && castOther.getIdentifier()!=null && this.getIdentifier().equals(castOther.getIdentifier()) ) )
 && ( (this.getFcItemMastNbr()==castOther.getFcItemMastNbr()) || ( this.getFcItemMastNbr()!=null && castOther.getFcItemMastNbr()!=null && this.getFcItemMastNbr().equals(castOther.getFcItemMastNbr()) ) )
 && ( (this.getFcstGrp()==castOther.getFcstGrp()) || ( this.getFcstGrp()!=null && castOther.getFcstGrp()!=null && this.getFcstGrp().equals(castOther.getFcstGrp()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getDmdTypeCd() == null ? 0 : this.getDmdTypeCd().hashCode() );
         result = 37 * result + ( getDmdCd() == null ? 0 : this.getDmdCd().hashCode() );
         result = 37 * result + ( getItemNbrDmd() == null ? 0 : this.getItemNbrDmd().hashCode() );
         result = 37 * result + ( getRqstDt() == null ? 0 : this.getRqstDt().hashCode() );
         result = 37 * result + ( getApsSrcRuleSetNbr() == null ? 0 : this.getApsSrcRuleSetNbr().hashCode() );
         result = 37 * result + ( getOrgNbrCust() == null ? 0 : this.getOrgNbrCust().hashCode() );
         result = 37 * result + ( getOrgCdCust() == null ? 0 : this.getOrgCdCust().hashCode() );
         result = 37 * result + ( getOpenQty() == null ? 0 : this.getOpenQty().hashCode() );
         result = 37 * result + ( getOpenQtyAdj() == null ? 0 : this.getOpenQtyAdj().hashCode() );
         result = 37 * result + ( getContractCustFlg() == null ? 0 : this.getContractCustFlg().hashCode() );
         result = 37 * result + ( getCustAllocPrty() == null ? 0 : this.getCustAllocPrty().hashCode() );
         result = 37 * result + ( getRevLvl() == null ? 0 : this.getRevLvl().hashCode() );
         result = 37 * result + ( getOrgNbrMfrRqst() == null ? 0 : this.getOrgNbrMfrRqst().hashCode() );
         result = 37 * result + ( getIdentifier() == null ? 0 : this.getIdentifier().hashCode() );
         result = 37 * result + ( getFcItemMastNbr() == null ? 0 : this.getFcItemMastNbr().hashCode() );
         result = 37 * result + ( getFcstGrp() == null ? 0 : this.getFcstGrp().hashCode() );
         return result;
   }   


}

