package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * FcFcstCycleVwId generated by hbm2java
 */
@Embeddable
public class FcFcstCycleVwId  implements java.io.Serializable {


     private Serializable fcItemMastNbr;
     private Serializable orgNbrCust;
     private Serializable orgCdCust;
     private Serializable orgNmCust;
     private Serializable fcstGrp;
     private Serializable itemNbr;
     private Serializable itemCd;
     private Serializable itemDescr;
     private Serializable stkUm;
     private Serializable stdCost;
     private Serializable listPrice;
     private Serializable cycle;
     private Serializable fcItemFcstMdlNbr;
     private Serializable chosenFlg;
     private Serializable rawFcstJan;
     private Serializable rawFcstFeb;
     private Serializable rawFcstMar;
     private Serializable rawFcstApr;
     private Serializable rawFcstMay;
     private Serializable rawFcstJun;
     private Serializable rawFcstJul;
     private Serializable rawFcstAug;
     private Serializable rawFcstSep;
     private Serializable rawFcstOct;
     private Serializable rawFcstNov;
     private Serializable rawFcstDec;
     private Serializable rawFcstTot;
     private Serializable adjFcstJan;
     private Serializable adjFcstFeb;
     private Serializable adjFcstMar;
     private Serializable adjFcstApr;
     private Serializable adjFcstMay;
     private Serializable adjFcstJun;
     private Serializable adjFcstJul;
     private Serializable adjFcstAug;
     private Serializable adjFcstSep;
     private Serializable adjFcstOct;
     private Serializable adjFcstNov;
     private Serializable adjFcstDec;
     private Serializable adjFcstTot;
     private Serializable consumedFcstJan;
     private Serializable consumedFcstFeb;
     private Serializable consumedFcstMar;
     private Serializable consumedFcstApr;
     private Serializable consumedFcstMay;
     private Serializable consumedFcstJun;
     private Serializable consumedFcstJul;
     private Serializable consumedFcstAug;
     private Serializable consumedFcstSep;
     private Serializable consumedFcstOct;
     private Serializable consumedFcstNov;
     private Serializable consumedFcstDec;
     private Serializable consumedFcstTot;

    public FcFcstCycleVwId() {
    }

    public FcFcstCycleVwId(Serializable fcItemMastNbr, Serializable orgNbrCust, Serializable orgCdCust, Serializable orgNmCust, Serializable fcstGrp, Serializable itemNbr, Serializable itemCd, Serializable itemDescr, Serializable stkUm, Serializable stdCost, Serializable listPrice, Serializable cycle, Serializable fcItemFcstMdlNbr, Serializable chosenFlg, Serializable rawFcstJan, Serializable rawFcstFeb, Serializable rawFcstMar, Serializable rawFcstApr, Serializable rawFcstMay, Serializable rawFcstJun, Serializable rawFcstJul, Serializable rawFcstAug, Serializable rawFcstSep, Serializable rawFcstOct, Serializable rawFcstNov, Serializable rawFcstDec, Serializable rawFcstTot, Serializable adjFcstJan, Serializable adjFcstFeb, Serializable adjFcstMar, Serializable adjFcstApr, Serializable adjFcstMay, Serializable adjFcstJun, Serializable adjFcstJul, Serializable adjFcstAug, Serializable adjFcstSep, Serializable adjFcstOct, Serializable adjFcstNov, Serializable adjFcstDec, Serializable adjFcstTot, Serializable consumedFcstJan, Serializable consumedFcstFeb, Serializable consumedFcstMar, Serializable consumedFcstApr, Serializable consumedFcstMay, Serializable consumedFcstJun, Serializable consumedFcstJul, Serializable consumedFcstAug, Serializable consumedFcstSep, Serializable consumedFcstOct, Serializable consumedFcstNov, Serializable consumedFcstDec, Serializable consumedFcstTot) {
       this.fcItemMastNbr = fcItemMastNbr;
       this.orgNbrCust = orgNbrCust;
       this.orgCdCust = orgCdCust;
       this.orgNmCust = orgNmCust;
       this.fcstGrp = fcstGrp;
       this.itemNbr = itemNbr;
       this.itemCd = itemCd;
       this.itemDescr = itemDescr;
       this.stkUm = stkUm;
       this.stdCost = stdCost;
       this.listPrice = listPrice;
       this.cycle = cycle;
       this.fcItemFcstMdlNbr = fcItemFcstMdlNbr;
       this.chosenFlg = chosenFlg;
       this.rawFcstJan = rawFcstJan;
       this.rawFcstFeb = rawFcstFeb;
       this.rawFcstMar = rawFcstMar;
       this.rawFcstApr = rawFcstApr;
       this.rawFcstMay = rawFcstMay;
       this.rawFcstJun = rawFcstJun;
       this.rawFcstJul = rawFcstJul;
       this.rawFcstAug = rawFcstAug;
       this.rawFcstSep = rawFcstSep;
       this.rawFcstOct = rawFcstOct;
       this.rawFcstNov = rawFcstNov;
       this.rawFcstDec = rawFcstDec;
       this.rawFcstTot = rawFcstTot;
       this.adjFcstJan = adjFcstJan;
       this.adjFcstFeb = adjFcstFeb;
       this.adjFcstMar = adjFcstMar;
       this.adjFcstApr = adjFcstApr;
       this.adjFcstMay = adjFcstMay;
       this.adjFcstJun = adjFcstJun;
       this.adjFcstJul = adjFcstJul;
       this.adjFcstAug = adjFcstAug;
       this.adjFcstSep = adjFcstSep;
       this.adjFcstOct = adjFcstOct;
       this.adjFcstNov = adjFcstNov;
       this.adjFcstDec = adjFcstDec;
       this.adjFcstTot = adjFcstTot;
       this.consumedFcstJan = consumedFcstJan;
       this.consumedFcstFeb = consumedFcstFeb;
       this.consumedFcstMar = consumedFcstMar;
       this.consumedFcstApr = consumedFcstApr;
       this.consumedFcstMay = consumedFcstMay;
       this.consumedFcstJun = consumedFcstJun;
       this.consumedFcstJul = consumedFcstJul;
       this.consumedFcstAug = consumedFcstAug;
       this.consumedFcstSep = consumedFcstSep;
       this.consumedFcstOct = consumedFcstOct;
       this.consumedFcstNov = consumedFcstNov;
       this.consumedFcstDec = consumedFcstDec;
       this.consumedFcstTot = consumedFcstTot;
    }
   


    @Column(name="FC_ITEM_MAST_NBR")
    public Serializable getFcItemMastNbr() {
        return this.fcItemMastNbr;
    }
    
    public void setFcItemMastNbr(Serializable fcItemMastNbr) {
        this.fcItemMastNbr = fcItemMastNbr;
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


    @Column(name="ORG_NM_CUST")
    public Serializable getOrgNmCust() {
        return this.orgNmCust;
    }
    
    public void setOrgNmCust(Serializable orgNmCust) {
        this.orgNmCust = orgNmCust;
    }


    @Column(name="FCST_GRP")
    public Serializable getFcstGrp() {
        return this.fcstGrp;
    }
    
    public void setFcstGrp(Serializable fcstGrp) {
        this.fcstGrp = fcstGrp;
    }


    @Column(name="ITEM_NBR")
    public Serializable getItemNbr() {
        return this.itemNbr;
    }
    
    public void setItemNbr(Serializable itemNbr) {
        this.itemNbr = itemNbr;
    }


    @Column(name="ITEM_CD")
    public Serializable getItemCd() {
        return this.itemCd;
    }
    
    public void setItemCd(Serializable itemCd) {
        this.itemCd = itemCd;
    }


    @Column(name="ITEM_DESCR")
    public Serializable getItemDescr() {
        return this.itemDescr;
    }
    
    public void setItemDescr(Serializable itemDescr) {
        this.itemDescr = itemDescr;
    }


    @Column(name="STK_UM")
    public Serializable getStkUm() {
        return this.stkUm;
    }
    
    public void setStkUm(Serializable stkUm) {
        this.stkUm = stkUm;
    }


    @Column(name="STD_COST")
    public Serializable getStdCost() {
        return this.stdCost;
    }
    
    public void setStdCost(Serializable stdCost) {
        this.stdCost = stdCost;
    }


    @Column(name="LIST_PRICE")
    public Serializable getListPrice() {
        return this.listPrice;
    }
    
    public void setListPrice(Serializable listPrice) {
        this.listPrice = listPrice;
    }


    @Column(name="CYCLE")
    public Serializable getCycle() {
        return this.cycle;
    }
    
    public void setCycle(Serializable cycle) {
        this.cycle = cycle;
    }


    @Column(name="FC_ITEM_FCST_MDL_NBR")
    public Serializable getFcItemFcstMdlNbr() {
        return this.fcItemFcstMdlNbr;
    }
    
    public void setFcItemFcstMdlNbr(Serializable fcItemFcstMdlNbr) {
        this.fcItemFcstMdlNbr = fcItemFcstMdlNbr;
    }


    @Column(name="CHOSEN_FLG")
    public Serializable getChosenFlg() {
        return this.chosenFlg;
    }
    
    public void setChosenFlg(Serializable chosenFlg) {
        this.chosenFlg = chosenFlg;
    }


    @Column(name="RAW_FCST_JAN")
    public Serializable getRawFcstJan() {
        return this.rawFcstJan;
    }
    
    public void setRawFcstJan(Serializable rawFcstJan) {
        this.rawFcstJan = rawFcstJan;
    }


    @Column(name="RAW_FCST_FEB")
    public Serializable getRawFcstFeb() {
        return this.rawFcstFeb;
    }
    
    public void setRawFcstFeb(Serializable rawFcstFeb) {
        this.rawFcstFeb = rawFcstFeb;
    }


    @Column(name="RAW_FCST_MAR")
    public Serializable getRawFcstMar() {
        return this.rawFcstMar;
    }
    
    public void setRawFcstMar(Serializable rawFcstMar) {
        this.rawFcstMar = rawFcstMar;
    }


    @Column(name="RAW_FCST_APR")
    public Serializable getRawFcstApr() {
        return this.rawFcstApr;
    }
    
    public void setRawFcstApr(Serializable rawFcstApr) {
        this.rawFcstApr = rawFcstApr;
    }


    @Column(name="RAW_FCST_MAY")
    public Serializable getRawFcstMay() {
        return this.rawFcstMay;
    }
    
    public void setRawFcstMay(Serializable rawFcstMay) {
        this.rawFcstMay = rawFcstMay;
    }


    @Column(name="RAW_FCST_JUN")
    public Serializable getRawFcstJun() {
        return this.rawFcstJun;
    }
    
    public void setRawFcstJun(Serializable rawFcstJun) {
        this.rawFcstJun = rawFcstJun;
    }


    @Column(name="RAW_FCST_JUL")
    public Serializable getRawFcstJul() {
        return this.rawFcstJul;
    }
    
    public void setRawFcstJul(Serializable rawFcstJul) {
        this.rawFcstJul = rawFcstJul;
    }


    @Column(name="RAW_FCST_AUG")
    public Serializable getRawFcstAug() {
        return this.rawFcstAug;
    }
    
    public void setRawFcstAug(Serializable rawFcstAug) {
        this.rawFcstAug = rawFcstAug;
    }


    @Column(name="RAW_FCST_SEP")
    public Serializable getRawFcstSep() {
        return this.rawFcstSep;
    }
    
    public void setRawFcstSep(Serializable rawFcstSep) {
        this.rawFcstSep = rawFcstSep;
    }


    @Column(name="RAW_FCST_OCT")
    public Serializable getRawFcstOct() {
        return this.rawFcstOct;
    }
    
    public void setRawFcstOct(Serializable rawFcstOct) {
        this.rawFcstOct = rawFcstOct;
    }


    @Column(name="RAW_FCST_NOV")
    public Serializable getRawFcstNov() {
        return this.rawFcstNov;
    }
    
    public void setRawFcstNov(Serializable rawFcstNov) {
        this.rawFcstNov = rawFcstNov;
    }


    @Column(name="RAW_FCST_DEC")
    public Serializable getRawFcstDec() {
        return this.rawFcstDec;
    }
    
    public void setRawFcstDec(Serializable rawFcstDec) {
        this.rawFcstDec = rawFcstDec;
    }


    @Column(name="RAW_FCST_TOT")
    public Serializable getRawFcstTot() {
        return this.rawFcstTot;
    }
    
    public void setRawFcstTot(Serializable rawFcstTot) {
        this.rawFcstTot = rawFcstTot;
    }


    @Column(name="ADJ_FCST_JAN")
    public Serializable getAdjFcstJan() {
        return this.adjFcstJan;
    }
    
    public void setAdjFcstJan(Serializable adjFcstJan) {
        this.adjFcstJan = adjFcstJan;
    }


    @Column(name="ADJ_FCST_FEB")
    public Serializable getAdjFcstFeb() {
        return this.adjFcstFeb;
    }
    
    public void setAdjFcstFeb(Serializable adjFcstFeb) {
        this.adjFcstFeb = adjFcstFeb;
    }


    @Column(name="ADJ_FCST_MAR")
    public Serializable getAdjFcstMar() {
        return this.adjFcstMar;
    }
    
    public void setAdjFcstMar(Serializable adjFcstMar) {
        this.adjFcstMar = adjFcstMar;
    }


    @Column(name="ADJ_FCST_APR")
    public Serializable getAdjFcstApr() {
        return this.adjFcstApr;
    }
    
    public void setAdjFcstApr(Serializable adjFcstApr) {
        this.adjFcstApr = adjFcstApr;
    }


    @Column(name="ADJ_FCST_MAY")
    public Serializable getAdjFcstMay() {
        return this.adjFcstMay;
    }
    
    public void setAdjFcstMay(Serializable adjFcstMay) {
        this.adjFcstMay = adjFcstMay;
    }


    @Column(name="ADJ_FCST_JUN")
    public Serializable getAdjFcstJun() {
        return this.adjFcstJun;
    }
    
    public void setAdjFcstJun(Serializable adjFcstJun) {
        this.adjFcstJun = adjFcstJun;
    }


    @Column(name="ADJ_FCST_JUL")
    public Serializable getAdjFcstJul() {
        return this.adjFcstJul;
    }
    
    public void setAdjFcstJul(Serializable adjFcstJul) {
        this.adjFcstJul = adjFcstJul;
    }


    @Column(name="ADJ_FCST_AUG")
    public Serializable getAdjFcstAug() {
        return this.adjFcstAug;
    }
    
    public void setAdjFcstAug(Serializable adjFcstAug) {
        this.adjFcstAug = adjFcstAug;
    }


    @Column(name="ADJ_FCST_SEP")
    public Serializable getAdjFcstSep() {
        return this.adjFcstSep;
    }
    
    public void setAdjFcstSep(Serializable adjFcstSep) {
        this.adjFcstSep = adjFcstSep;
    }


    @Column(name="ADJ_FCST_OCT")
    public Serializable getAdjFcstOct() {
        return this.adjFcstOct;
    }
    
    public void setAdjFcstOct(Serializable adjFcstOct) {
        this.adjFcstOct = adjFcstOct;
    }


    @Column(name="ADJ_FCST_NOV")
    public Serializable getAdjFcstNov() {
        return this.adjFcstNov;
    }
    
    public void setAdjFcstNov(Serializable adjFcstNov) {
        this.adjFcstNov = adjFcstNov;
    }


    @Column(name="ADJ_FCST_DEC")
    public Serializable getAdjFcstDec() {
        return this.adjFcstDec;
    }
    
    public void setAdjFcstDec(Serializable adjFcstDec) {
        this.adjFcstDec = adjFcstDec;
    }


    @Column(name="ADJ_FCST_TOT")
    public Serializable getAdjFcstTot() {
        return this.adjFcstTot;
    }
    
    public void setAdjFcstTot(Serializable adjFcstTot) {
        this.adjFcstTot = adjFcstTot;
    }


    @Column(name="CONSUMED_FCST_JAN")
    public Serializable getConsumedFcstJan() {
        return this.consumedFcstJan;
    }
    
    public void setConsumedFcstJan(Serializable consumedFcstJan) {
        this.consumedFcstJan = consumedFcstJan;
    }


    @Column(name="CONSUMED_FCST_FEB")
    public Serializable getConsumedFcstFeb() {
        return this.consumedFcstFeb;
    }
    
    public void setConsumedFcstFeb(Serializable consumedFcstFeb) {
        this.consumedFcstFeb = consumedFcstFeb;
    }


    @Column(name="CONSUMED_FCST_MAR")
    public Serializable getConsumedFcstMar() {
        return this.consumedFcstMar;
    }
    
    public void setConsumedFcstMar(Serializable consumedFcstMar) {
        this.consumedFcstMar = consumedFcstMar;
    }


    @Column(name="CONSUMED_FCST_APR")
    public Serializable getConsumedFcstApr() {
        return this.consumedFcstApr;
    }
    
    public void setConsumedFcstApr(Serializable consumedFcstApr) {
        this.consumedFcstApr = consumedFcstApr;
    }


    @Column(name="CONSUMED_FCST_MAY")
    public Serializable getConsumedFcstMay() {
        return this.consumedFcstMay;
    }
    
    public void setConsumedFcstMay(Serializable consumedFcstMay) {
        this.consumedFcstMay = consumedFcstMay;
    }


    @Column(name="CONSUMED_FCST_JUN")
    public Serializable getConsumedFcstJun() {
        return this.consumedFcstJun;
    }
    
    public void setConsumedFcstJun(Serializable consumedFcstJun) {
        this.consumedFcstJun = consumedFcstJun;
    }


    @Column(name="CONSUMED_FCST_JUL")
    public Serializable getConsumedFcstJul() {
        return this.consumedFcstJul;
    }
    
    public void setConsumedFcstJul(Serializable consumedFcstJul) {
        this.consumedFcstJul = consumedFcstJul;
    }


    @Column(name="CONSUMED_FCST_AUG")
    public Serializable getConsumedFcstAug() {
        return this.consumedFcstAug;
    }
    
    public void setConsumedFcstAug(Serializable consumedFcstAug) {
        this.consumedFcstAug = consumedFcstAug;
    }


    @Column(name="CONSUMED_FCST_SEP")
    public Serializable getConsumedFcstSep() {
        return this.consumedFcstSep;
    }
    
    public void setConsumedFcstSep(Serializable consumedFcstSep) {
        this.consumedFcstSep = consumedFcstSep;
    }


    @Column(name="CONSUMED_FCST_OCT")
    public Serializable getConsumedFcstOct() {
        return this.consumedFcstOct;
    }
    
    public void setConsumedFcstOct(Serializable consumedFcstOct) {
        this.consumedFcstOct = consumedFcstOct;
    }


    @Column(name="CONSUMED_FCST_NOV")
    public Serializable getConsumedFcstNov() {
        return this.consumedFcstNov;
    }
    
    public void setConsumedFcstNov(Serializable consumedFcstNov) {
        this.consumedFcstNov = consumedFcstNov;
    }


    @Column(name="CONSUMED_FCST_DEC")
    public Serializable getConsumedFcstDec() {
        return this.consumedFcstDec;
    }
    
    public void setConsumedFcstDec(Serializable consumedFcstDec) {
        this.consumedFcstDec = consumedFcstDec;
    }


    @Column(name="CONSUMED_FCST_TOT")
    public Serializable getConsumedFcstTot() {
        return this.consumedFcstTot;
    }
    
    public void setConsumedFcstTot(Serializable consumedFcstTot) {
        this.consumedFcstTot = consumedFcstTot;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof FcFcstCycleVwId) ) return false;
		 FcFcstCycleVwId castOther = ( FcFcstCycleVwId ) other; 
         
		 return ( (this.getFcItemMastNbr()==castOther.getFcItemMastNbr()) || ( this.getFcItemMastNbr()!=null && castOther.getFcItemMastNbr()!=null && this.getFcItemMastNbr().equals(castOther.getFcItemMastNbr()) ) )
 && ( (this.getOrgNbrCust()==castOther.getOrgNbrCust()) || ( this.getOrgNbrCust()!=null && castOther.getOrgNbrCust()!=null && this.getOrgNbrCust().equals(castOther.getOrgNbrCust()) ) )
 && ( (this.getOrgCdCust()==castOther.getOrgCdCust()) || ( this.getOrgCdCust()!=null && castOther.getOrgCdCust()!=null && this.getOrgCdCust().equals(castOther.getOrgCdCust()) ) )
 && ( (this.getOrgNmCust()==castOther.getOrgNmCust()) || ( this.getOrgNmCust()!=null && castOther.getOrgNmCust()!=null && this.getOrgNmCust().equals(castOther.getOrgNmCust()) ) )
 && ( (this.getFcstGrp()==castOther.getFcstGrp()) || ( this.getFcstGrp()!=null && castOther.getFcstGrp()!=null && this.getFcstGrp().equals(castOther.getFcstGrp()) ) )
 && ( (this.getItemNbr()==castOther.getItemNbr()) || ( this.getItemNbr()!=null && castOther.getItemNbr()!=null && this.getItemNbr().equals(castOther.getItemNbr()) ) )
 && ( (this.getItemCd()==castOther.getItemCd()) || ( this.getItemCd()!=null && castOther.getItemCd()!=null && this.getItemCd().equals(castOther.getItemCd()) ) )
 && ( (this.getItemDescr()==castOther.getItemDescr()) || ( this.getItemDescr()!=null && castOther.getItemDescr()!=null && this.getItemDescr().equals(castOther.getItemDescr()) ) )
 && ( (this.getStkUm()==castOther.getStkUm()) || ( this.getStkUm()!=null && castOther.getStkUm()!=null && this.getStkUm().equals(castOther.getStkUm()) ) )
 && ( (this.getStdCost()==castOther.getStdCost()) || ( this.getStdCost()!=null && castOther.getStdCost()!=null && this.getStdCost().equals(castOther.getStdCost()) ) )
 && ( (this.getListPrice()==castOther.getListPrice()) || ( this.getListPrice()!=null && castOther.getListPrice()!=null && this.getListPrice().equals(castOther.getListPrice()) ) )
 && ( (this.getCycle()==castOther.getCycle()) || ( this.getCycle()!=null && castOther.getCycle()!=null && this.getCycle().equals(castOther.getCycle()) ) )
 && ( (this.getFcItemFcstMdlNbr()==castOther.getFcItemFcstMdlNbr()) || ( this.getFcItemFcstMdlNbr()!=null && castOther.getFcItemFcstMdlNbr()!=null && this.getFcItemFcstMdlNbr().equals(castOther.getFcItemFcstMdlNbr()) ) )
 && ( (this.getChosenFlg()==castOther.getChosenFlg()) || ( this.getChosenFlg()!=null && castOther.getChosenFlg()!=null && this.getChosenFlg().equals(castOther.getChosenFlg()) ) )
 && ( (this.getRawFcstJan()==castOther.getRawFcstJan()) || ( this.getRawFcstJan()!=null && castOther.getRawFcstJan()!=null && this.getRawFcstJan().equals(castOther.getRawFcstJan()) ) )
 && ( (this.getRawFcstFeb()==castOther.getRawFcstFeb()) || ( this.getRawFcstFeb()!=null && castOther.getRawFcstFeb()!=null && this.getRawFcstFeb().equals(castOther.getRawFcstFeb()) ) )
 && ( (this.getRawFcstMar()==castOther.getRawFcstMar()) || ( this.getRawFcstMar()!=null && castOther.getRawFcstMar()!=null && this.getRawFcstMar().equals(castOther.getRawFcstMar()) ) )
 && ( (this.getRawFcstApr()==castOther.getRawFcstApr()) || ( this.getRawFcstApr()!=null && castOther.getRawFcstApr()!=null && this.getRawFcstApr().equals(castOther.getRawFcstApr()) ) )
 && ( (this.getRawFcstMay()==castOther.getRawFcstMay()) || ( this.getRawFcstMay()!=null && castOther.getRawFcstMay()!=null && this.getRawFcstMay().equals(castOther.getRawFcstMay()) ) )
 && ( (this.getRawFcstJun()==castOther.getRawFcstJun()) || ( this.getRawFcstJun()!=null && castOther.getRawFcstJun()!=null && this.getRawFcstJun().equals(castOther.getRawFcstJun()) ) )
 && ( (this.getRawFcstJul()==castOther.getRawFcstJul()) || ( this.getRawFcstJul()!=null && castOther.getRawFcstJul()!=null && this.getRawFcstJul().equals(castOther.getRawFcstJul()) ) )
 && ( (this.getRawFcstAug()==castOther.getRawFcstAug()) || ( this.getRawFcstAug()!=null && castOther.getRawFcstAug()!=null && this.getRawFcstAug().equals(castOther.getRawFcstAug()) ) )
 && ( (this.getRawFcstSep()==castOther.getRawFcstSep()) || ( this.getRawFcstSep()!=null && castOther.getRawFcstSep()!=null && this.getRawFcstSep().equals(castOther.getRawFcstSep()) ) )
 && ( (this.getRawFcstOct()==castOther.getRawFcstOct()) || ( this.getRawFcstOct()!=null && castOther.getRawFcstOct()!=null && this.getRawFcstOct().equals(castOther.getRawFcstOct()) ) )
 && ( (this.getRawFcstNov()==castOther.getRawFcstNov()) || ( this.getRawFcstNov()!=null && castOther.getRawFcstNov()!=null && this.getRawFcstNov().equals(castOther.getRawFcstNov()) ) )
 && ( (this.getRawFcstDec()==castOther.getRawFcstDec()) || ( this.getRawFcstDec()!=null && castOther.getRawFcstDec()!=null && this.getRawFcstDec().equals(castOther.getRawFcstDec()) ) )
 && ( (this.getRawFcstTot()==castOther.getRawFcstTot()) || ( this.getRawFcstTot()!=null && castOther.getRawFcstTot()!=null && this.getRawFcstTot().equals(castOther.getRawFcstTot()) ) )
 && ( (this.getAdjFcstJan()==castOther.getAdjFcstJan()) || ( this.getAdjFcstJan()!=null && castOther.getAdjFcstJan()!=null && this.getAdjFcstJan().equals(castOther.getAdjFcstJan()) ) )
 && ( (this.getAdjFcstFeb()==castOther.getAdjFcstFeb()) || ( this.getAdjFcstFeb()!=null && castOther.getAdjFcstFeb()!=null && this.getAdjFcstFeb().equals(castOther.getAdjFcstFeb()) ) )
 && ( (this.getAdjFcstMar()==castOther.getAdjFcstMar()) || ( this.getAdjFcstMar()!=null && castOther.getAdjFcstMar()!=null && this.getAdjFcstMar().equals(castOther.getAdjFcstMar()) ) )
 && ( (this.getAdjFcstApr()==castOther.getAdjFcstApr()) || ( this.getAdjFcstApr()!=null && castOther.getAdjFcstApr()!=null && this.getAdjFcstApr().equals(castOther.getAdjFcstApr()) ) )
 && ( (this.getAdjFcstMay()==castOther.getAdjFcstMay()) || ( this.getAdjFcstMay()!=null && castOther.getAdjFcstMay()!=null && this.getAdjFcstMay().equals(castOther.getAdjFcstMay()) ) )
 && ( (this.getAdjFcstJun()==castOther.getAdjFcstJun()) || ( this.getAdjFcstJun()!=null && castOther.getAdjFcstJun()!=null && this.getAdjFcstJun().equals(castOther.getAdjFcstJun()) ) )
 && ( (this.getAdjFcstJul()==castOther.getAdjFcstJul()) || ( this.getAdjFcstJul()!=null && castOther.getAdjFcstJul()!=null && this.getAdjFcstJul().equals(castOther.getAdjFcstJul()) ) )
 && ( (this.getAdjFcstAug()==castOther.getAdjFcstAug()) || ( this.getAdjFcstAug()!=null && castOther.getAdjFcstAug()!=null && this.getAdjFcstAug().equals(castOther.getAdjFcstAug()) ) )
 && ( (this.getAdjFcstSep()==castOther.getAdjFcstSep()) || ( this.getAdjFcstSep()!=null && castOther.getAdjFcstSep()!=null && this.getAdjFcstSep().equals(castOther.getAdjFcstSep()) ) )
 && ( (this.getAdjFcstOct()==castOther.getAdjFcstOct()) || ( this.getAdjFcstOct()!=null && castOther.getAdjFcstOct()!=null && this.getAdjFcstOct().equals(castOther.getAdjFcstOct()) ) )
 && ( (this.getAdjFcstNov()==castOther.getAdjFcstNov()) || ( this.getAdjFcstNov()!=null && castOther.getAdjFcstNov()!=null && this.getAdjFcstNov().equals(castOther.getAdjFcstNov()) ) )
 && ( (this.getAdjFcstDec()==castOther.getAdjFcstDec()) || ( this.getAdjFcstDec()!=null && castOther.getAdjFcstDec()!=null && this.getAdjFcstDec().equals(castOther.getAdjFcstDec()) ) )
 && ( (this.getAdjFcstTot()==castOther.getAdjFcstTot()) || ( this.getAdjFcstTot()!=null && castOther.getAdjFcstTot()!=null && this.getAdjFcstTot().equals(castOther.getAdjFcstTot()) ) )
 && ( (this.getConsumedFcstJan()==castOther.getConsumedFcstJan()) || ( this.getConsumedFcstJan()!=null && castOther.getConsumedFcstJan()!=null && this.getConsumedFcstJan().equals(castOther.getConsumedFcstJan()) ) )
 && ( (this.getConsumedFcstFeb()==castOther.getConsumedFcstFeb()) || ( this.getConsumedFcstFeb()!=null && castOther.getConsumedFcstFeb()!=null && this.getConsumedFcstFeb().equals(castOther.getConsumedFcstFeb()) ) )
 && ( (this.getConsumedFcstMar()==castOther.getConsumedFcstMar()) || ( this.getConsumedFcstMar()!=null && castOther.getConsumedFcstMar()!=null && this.getConsumedFcstMar().equals(castOther.getConsumedFcstMar()) ) )
 && ( (this.getConsumedFcstApr()==castOther.getConsumedFcstApr()) || ( this.getConsumedFcstApr()!=null && castOther.getConsumedFcstApr()!=null && this.getConsumedFcstApr().equals(castOther.getConsumedFcstApr()) ) )
 && ( (this.getConsumedFcstMay()==castOther.getConsumedFcstMay()) || ( this.getConsumedFcstMay()!=null && castOther.getConsumedFcstMay()!=null && this.getConsumedFcstMay().equals(castOther.getConsumedFcstMay()) ) )
 && ( (this.getConsumedFcstJun()==castOther.getConsumedFcstJun()) || ( this.getConsumedFcstJun()!=null && castOther.getConsumedFcstJun()!=null && this.getConsumedFcstJun().equals(castOther.getConsumedFcstJun()) ) )
 && ( (this.getConsumedFcstJul()==castOther.getConsumedFcstJul()) || ( this.getConsumedFcstJul()!=null && castOther.getConsumedFcstJul()!=null && this.getConsumedFcstJul().equals(castOther.getConsumedFcstJul()) ) )
 && ( (this.getConsumedFcstAug()==castOther.getConsumedFcstAug()) || ( this.getConsumedFcstAug()!=null && castOther.getConsumedFcstAug()!=null && this.getConsumedFcstAug().equals(castOther.getConsumedFcstAug()) ) )
 && ( (this.getConsumedFcstSep()==castOther.getConsumedFcstSep()) || ( this.getConsumedFcstSep()!=null && castOther.getConsumedFcstSep()!=null && this.getConsumedFcstSep().equals(castOther.getConsumedFcstSep()) ) )
 && ( (this.getConsumedFcstOct()==castOther.getConsumedFcstOct()) || ( this.getConsumedFcstOct()!=null && castOther.getConsumedFcstOct()!=null && this.getConsumedFcstOct().equals(castOther.getConsumedFcstOct()) ) )
 && ( (this.getConsumedFcstNov()==castOther.getConsumedFcstNov()) || ( this.getConsumedFcstNov()!=null && castOther.getConsumedFcstNov()!=null && this.getConsumedFcstNov().equals(castOther.getConsumedFcstNov()) ) )
 && ( (this.getConsumedFcstDec()==castOther.getConsumedFcstDec()) || ( this.getConsumedFcstDec()!=null && castOther.getConsumedFcstDec()!=null && this.getConsumedFcstDec().equals(castOther.getConsumedFcstDec()) ) )
 && ( (this.getConsumedFcstTot()==castOther.getConsumedFcstTot()) || ( this.getConsumedFcstTot()!=null && castOther.getConsumedFcstTot()!=null && this.getConsumedFcstTot().equals(castOther.getConsumedFcstTot()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getFcItemMastNbr() == null ? 0 : this.getFcItemMastNbr().hashCode() );
         result = 37 * result + ( getOrgNbrCust() == null ? 0 : this.getOrgNbrCust().hashCode() );
         result = 37 * result + ( getOrgCdCust() == null ? 0 : this.getOrgCdCust().hashCode() );
         result = 37 * result + ( getOrgNmCust() == null ? 0 : this.getOrgNmCust().hashCode() );
         result = 37 * result + ( getFcstGrp() == null ? 0 : this.getFcstGrp().hashCode() );
         result = 37 * result + ( getItemNbr() == null ? 0 : this.getItemNbr().hashCode() );
         result = 37 * result + ( getItemCd() == null ? 0 : this.getItemCd().hashCode() );
         result = 37 * result + ( getItemDescr() == null ? 0 : this.getItemDescr().hashCode() );
         result = 37 * result + ( getStkUm() == null ? 0 : this.getStkUm().hashCode() );
         result = 37 * result + ( getStdCost() == null ? 0 : this.getStdCost().hashCode() );
         result = 37 * result + ( getListPrice() == null ? 0 : this.getListPrice().hashCode() );
         result = 37 * result + ( getCycle() == null ? 0 : this.getCycle().hashCode() );
         result = 37 * result + ( getFcItemFcstMdlNbr() == null ? 0 : this.getFcItemFcstMdlNbr().hashCode() );
         result = 37 * result + ( getChosenFlg() == null ? 0 : this.getChosenFlg().hashCode() );
         result = 37 * result + ( getRawFcstJan() == null ? 0 : this.getRawFcstJan().hashCode() );
         result = 37 * result + ( getRawFcstFeb() == null ? 0 : this.getRawFcstFeb().hashCode() );
         result = 37 * result + ( getRawFcstMar() == null ? 0 : this.getRawFcstMar().hashCode() );
         result = 37 * result + ( getRawFcstApr() == null ? 0 : this.getRawFcstApr().hashCode() );
         result = 37 * result + ( getRawFcstMay() == null ? 0 : this.getRawFcstMay().hashCode() );
         result = 37 * result + ( getRawFcstJun() == null ? 0 : this.getRawFcstJun().hashCode() );
         result = 37 * result + ( getRawFcstJul() == null ? 0 : this.getRawFcstJul().hashCode() );
         result = 37 * result + ( getRawFcstAug() == null ? 0 : this.getRawFcstAug().hashCode() );
         result = 37 * result + ( getRawFcstSep() == null ? 0 : this.getRawFcstSep().hashCode() );
         result = 37 * result + ( getRawFcstOct() == null ? 0 : this.getRawFcstOct().hashCode() );
         result = 37 * result + ( getRawFcstNov() == null ? 0 : this.getRawFcstNov().hashCode() );
         result = 37 * result + ( getRawFcstDec() == null ? 0 : this.getRawFcstDec().hashCode() );
         result = 37 * result + ( getRawFcstTot() == null ? 0 : this.getRawFcstTot().hashCode() );
         result = 37 * result + ( getAdjFcstJan() == null ? 0 : this.getAdjFcstJan().hashCode() );
         result = 37 * result + ( getAdjFcstFeb() == null ? 0 : this.getAdjFcstFeb().hashCode() );
         result = 37 * result + ( getAdjFcstMar() == null ? 0 : this.getAdjFcstMar().hashCode() );
         result = 37 * result + ( getAdjFcstApr() == null ? 0 : this.getAdjFcstApr().hashCode() );
         result = 37 * result + ( getAdjFcstMay() == null ? 0 : this.getAdjFcstMay().hashCode() );
         result = 37 * result + ( getAdjFcstJun() == null ? 0 : this.getAdjFcstJun().hashCode() );
         result = 37 * result + ( getAdjFcstJul() == null ? 0 : this.getAdjFcstJul().hashCode() );
         result = 37 * result + ( getAdjFcstAug() == null ? 0 : this.getAdjFcstAug().hashCode() );
         result = 37 * result + ( getAdjFcstSep() == null ? 0 : this.getAdjFcstSep().hashCode() );
         result = 37 * result + ( getAdjFcstOct() == null ? 0 : this.getAdjFcstOct().hashCode() );
         result = 37 * result + ( getAdjFcstNov() == null ? 0 : this.getAdjFcstNov().hashCode() );
         result = 37 * result + ( getAdjFcstDec() == null ? 0 : this.getAdjFcstDec().hashCode() );
         result = 37 * result + ( getAdjFcstTot() == null ? 0 : this.getAdjFcstTot().hashCode() );
         result = 37 * result + ( getConsumedFcstJan() == null ? 0 : this.getConsumedFcstJan().hashCode() );
         result = 37 * result + ( getConsumedFcstFeb() == null ? 0 : this.getConsumedFcstFeb().hashCode() );
         result = 37 * result + ( getConsumedFcstMar() == null ? 0 : this.getConsumedFcstMar().hashCode() );
         result = 37 * result + ( getConsumedFcstApr() == null ? 0 : this.getConsumedFcstApr().hashCode() );
         result = 37 * result + ( getConsumedFcstMay() == null ? 0 : this.getConsumedFcstMay().hashCode() );
         result = 37 * result + ( getConsumedFcstJun() == null ? 0 : this.getConsumedFcstJun().hashCode() );
         result = 37 * result + ( getConsumedFcstJul() == null ? 0 : this.getConsumedFcstJul().hashCode() );
         result = 37 * result + ( getConsumedFcstAug() == null ? 0 : this.getConsumedFcstAug().hashCode() );
         result = 37 * result + ( getConsumedFcstSep() == null ? 0 : this.getConsumedFcstSep().hashCode() );
         result = 37 * result + ( getConsumedFcstOct() == null ? 0 : this.getConsumedFcstOct().hashCode() );
         result = 37 * result + ( getConsumedFcstNov() == null ? 0 : this.getConsumedFcstNov().hashCode() );
         result = 37 * result + ( getConsumedFcstDec() == null ? 0 : this.getConsumedFcstDec().hashCode() );
         result = 37 * result + ( getConsumedFcstTot() == null ? 0 : this.getConsumedFcstTot().hashCode() );
         return result;
   }   


}


