package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VqHdrDtlVwId generated by hbm2java
 */
@Embeddable
public class VqHdrDtlVwId  implements java.io.Serializable {


     private int vqQteHdrNbr;
     private String vqQteCd;
     private int orgNbrVnd;
     private String orgCdVnd;
     private String orgNmVnd;
     private Date vqQteDt;
     private String indivNmSpokenTo;
     private String indivPhnNbr;
     private String indivFaxNbr;
     private String indivEmailAddr;
     private String currCdQte;
     private Date vqQteEffDt;
     private Date vqQteExpDt;
     private String vndQteRefCd;
     private String transmitFlg;
     private int vqQteIndivNbr;
     private int vqQteDtlNbr;
     private Integer itemNbrQte;
     private String itemCdQte;
     private String itemCdVnd;
     private String qteUm;
     private BigDecimal qteQty;
     private BigDecimal qteCost;
     private BigDecimal qteCostDenom;
     private BigDecimal qteCostStkUm;
     private BigDecimal qteCostDenomStkUm;
     private Integer orgNbrMfrRqst;
     private String orgCdMfr;
     private String orgNmMfr;
     private String revLvl;
     private Date rqstDt;
     private Date promDt;
     private Short leadTmWkProm;
     private String vqLostCd;

    public VqHdrDtlVwId() {
    }

	
    public VqHdrDtlVwId(int vqQteHdrNbr, String vqQteCd, int orgNbrVnd, String orgCdVnd, String orgNmVnd, Date vqQteDt, String currCdQte, Date vqQteEffDt, Date vqQteExpDt, String transmitFlg, int vqQteIndivNbr, int vqQteDtlNbr, String itemCdQte, String itemCdVnd, String qteUm, BigDecimal qteQty, Date rqstDt) {
        this.vqQteHdrNbr = vqQteHdrNbr;
        this.vqQteCd = vqQteCd;
        this.orgNbrVnd = orgNbrVnd;
        this.orgCdVnd = orgCdVnd;
        this.orgNmVnd = orgNmVnd;
        this.vqQteDt = vqQteDt;
        this.currCdQte = currCdQte;
        this.vqQteEffDt = vqQteEffDt;
        this.vqQteExpDt = vqQteExpDt;
        this.transmitFlg = transmitFlg;
        this.vqQteIndivNbr = vqQteIndivNbr;
        this.vqQteDtlNbr = vqQteDtlNbr;
        this.itemCdQte = itemCdQte;
        this.itemCdVnd = itemCdVnd;
        this.qteUm = qteUm;
        this.qteQty = qteQty;
        this.rqstDt = rqstDt;
    }
    public VqHdrDtlVwId(int vqQteHdrNbr, String vqQteCd, int orgNbrVnd, String orgCdVnd, String orgNmVnd, Date vqQteDt, String indivNmSpokenTo, String indivPhnNbr, String indivFaxNbr, String indivEmailAddr, String currCdQte, Date vqQteEffDt, Date vqQteExpDt, String vndQteRefCd, String transmitFlg, int vqQteIndivNbr, int vqQteDtlNbr, Integer itemNbrQte, String itemCdQte, String itemCdVnd, String qteUm, BigDecimal qteQty, BigDecimal qteCost, BigDecimal qteCostDenom, BigDecimal qteCostStkUm, BigDecimal qteCostDenomStkUm, Integer orgNbrMfrRqst, String orgCdMfr, String orgNmMfr, String revLvl, Date rqstDt, Date promDt, Short leadTmWkProm, String vqLostCd) {
       this.vqQteHdrNbr = vqQteHdrNbr;
       this.vqQteCd = vqQteCd;
       this.orgNbrVnd = orgNbrVnd;
       this.orgCdVnd = orgCdVnd;
       this.orgNmVnd = orgNmVnd;
       this.vqQteDt = vqQteDt;
       this.indivNmSpokenTo = indivNmSpokenTo;
       this.indivPhnNbr = indivPhnNbr;
       this.indivFaxNbr = indivFaxNbr;
       this.indivEmailAddr = indivEmailAddr;
       this.currCdQte = currCdQte;
       this.vqQteEffDt = vqQteEffDt;
       this.vqQteExpDt = vqQteExpDt;
       this.vndQteRefCd = vndQteRefCd;
       this.transmitFlg = transmitFlg;
       this.vqQteIndivNbr = vqQteIndivNbr;
       this.vqQteDtlNbr = vqQteDtlNbr;
       this.itemNbrQte = itemNbrQte;
       this.itemCdQte = itemCdQte;
       this.itemCdVnd = itemCdVnd;
       this.qteUm = qteUm;
       this.qteQty = qteQty;
       this.qteCost = qteCost;
       this.qteCostDenom = qteCostDenom;
       this.qteCostStkUm = qteCostStkUm;
       this.qteCostDenomStkUm = qteCostDenomStkUm;
       this.orgNbrMfrRqst = orgNbrMfrRqst;
       this.orgCdMfr = orgCdMfr;
       this.orgNmMfr = orgNmMfr;
       this.revLvl = revLvl;
       this.rqstDt = rqstDt;
       this.promDt = promDt;
       this.leadTmWkProm = leadTmWkProm;
       this.vqLostCd = vqLostCd;
    }
   


    @Column(name="VQ_QTE_HDR_NBR", nullable=false, precision=9, scale=0)
    public int getVqQteHdrNbr() {
        return this.vqQteHdrNbr;
    }
    
    public void setVqQteHdrNbr(int vqQteHdrNbr) {
        this.vqQteHdrNbr = vqQteHdrNbr;
    }


    @Column(name="VQ_QTE_CD", nullable=false, length=20)
    public String getVqQteCd() {
        return this.vqQteCd;
    }
    
    public void setVqQteCd(String vqQteCd) {
        this.vqQteCd = vqQteCd;
    }


    @Column(name="ORG_NBR_VND", nullable=false, precision=9, scale=0)
    public int getOrgNbrVnd() {
        return this.orgNbrVnd;
    }
    
    public void setOrgNbrVnd(int orgNbrVnd) {
        this.orgNbrVnd = orgNbrVnd;
    }


    @Column(name="ORG_CD_VND", nullable=false, length=15)
    public String getOrgCdVnd() {
        return this.orgCdVnd;
    }
    
    public void setOrgCdVnd(String orgCdVnd) {
        this.orgCdVnd = orgCdVnd;
    }


    @Column(name="ORG_NM_VND", nullable=false, length=60)
    public String getOrgNmVnd() {
        return this.orgNmVnd;
    }
    
    public void setOrgNmVnd(String orgNmVnd) {
        this.orgNmVnd = orgNmVnd;
    }


    @Column(name="VQ_QTE_DT", nullable=false, length=7)
    public Date getVqQteDt() {
        return this.vqQteDt;
    }
    
    public void setVqQteDt(Date vqQteDt) {
        this.vqQteDt = vqQteDt;
    }


    @Column(name="INDIV_NM_SPOKEN_TO", length=40)
    public String getIndivNmSpokenTo() {
        return this.indivNmSpokenTo;
    }
    
    public void setIndivNmSpokenTo(String indivNmSpokenTo) {
        this.indivNmSpokenTo = indivNmSpokenTo;
    }


    @Column(name="INDIV_PHN_NBR", length=20)
    public String getIndivPhnNbr() {
        return this.indivPhnNbr;
    }
    
    public void setIndivPhnNbr(String indivPhnNbr) {
        this.indivPhnNbr = indivPhnNbr;
    }


    @Column(name="INDIV_FAX_NBR", length=20)
    public String getIndivFaxNbr() {
        return this.indivFaxNbr;
    }
    
    public void setIndivFaxNbr(String indivFaxNbr) {
        this.indivFaxNbr = indivFaxNbr;
    }


    @Column(name="INDIV_EMAIL_ADDR", length=40)
    public String getIndivEmailAddr() {
        return this.indivEmailAddr;
    }
    
    public void setIndivEmailAddr(String indivEmailAddr) {
        this.indivEmailAddr = indivEmailAddr;
    }


    @Column(name="CURR_CD_QTE", nullable=false, length=9)
    public String getCurrCdQte() {
        return this.currCdQte;
    }
    
    public void setCurrCdQte(String currCdQte) {
        this.currCdQte = currCdQte;
    }


    @Column(name="VQ_QTE_EFF_DT", nullable=false, length=7)
    public Date getVqQteEffDt() {
        return this.vqQteEffDt;
    }
    
    public void setVqQteEffDt(Date vqQteEffDt) {
        this.vqQteEffDt = vqQteEffDt;
    }


    @Column(name="VQ_QTE_EXP_DT", nullable=false, length=7)
    public Date getVqQteExpDt() {
        return this.vqQteExpDt;
    }
    
    public void setVqQteExpDt(Date vqQteExpDt) {
        this.vqQteExpDt = vqQteExpDt;
    }


    @Column(name="VND_QTE_REF_CD", length=20)
    public String getVndQteRefCd() {
        return this.vndQteRefCd;
    }
    
    public void setVndQteRefCd(String vndQteRefCd) {
        this.vndQteRefCd = vndQteRefCd;
    }


    @Column(name="TRANSMIT_FLG", nullable=false, length=1)
    public String getTransmitFlg() {
        return this.transmitFlg;
    }
    
    public void setTransmitFlg(String transmitFlg) {
        this.transmitFlg = transmitFlg;
    }


    @Column(name="VQ_QTE_INDIV_NBR", nullable=false, precision=9, scale=0)
    public int getVqQteIndivNbr() {
        return this.vqQteIndivNbr;
    }
    
    public void setVqQteIndivNbr(int vqQteIndivNbr) {
        this.vqQteIndivNbr = vqQteIndivNbr;
    }


    @Column(name="VQ_QTE_DTL_NBR", nullable=false, precision=9, scale=0)
    public int getVqQteDtlNbr() {
        return this.vqQteDtlNbr;
    }
    
    public void setVqQteDtlNbr(int vqQteDtlNbr) {
        this.vqQteDtlNbr = vqQteDtlNbr;
    }


    @Column(name="ITEM_NBR_QTE", precision=9, scale=0)
    public Integer getItemNbrQte() {
        return this.itemNbrQte;
    }
    
    public void setItemNbrQte(Integer itemNbrQte) {
        this.itemNbrQte = itemNbrQte;
    }


    @Column(name="ITEM_CD_QTE", nullable=false, length=50)
    public String getItemCdQte() {
        return this.itemCdQte;
    }
    
    public void setItemCdQte(String itemCdQte) {
        this.itemCdQte = itemCdQte;
    }


    @Column(name="ITEM_CD_VND", nullable=false, length=50)
    public String getItemCdVnd() {
        return this.itemCdVnd;
    }
    
    public void setItemCdVnd(String itemCdVnd) {
        this.itemCdVnd = itemCdVnd;
    }


    @Column(name="QTE_UM", nullable=false, length=3)
    public String getQteUm() {
        return this.qteUm;
    }
    
    public void setQteUm(String qteUm) {
        this.qteUm = qteUm;
    }


    @Column(name="QTE_QTY", nullable=false, precision=13, scale=5)
    public BigDecimal getQteQty() {
        return this.qteQty;
    }
    
    public void setQteQty(BigDecimal qteQty) {
        this.qteQty = qteQty;
    }


    @Column(name="QTE_COST", precision=17, scale=6)
    public BigDecimal getQteCost() {
        return this.qteCost;
    }
    
    public void setQteCost(BigDecimal qteCost) {
        this.qteCost = qteCost;
    }


    @Column(name="QTE_COST_DENOM", precision=17, scale=6)
    public BigDecimal getQteCostDenom() {
        return this.qteCostDenom;
    }
    
    public void setQteCostDenom(BigDecimal qteCostDenom) {
        this.qteCostDenom = qteCostDenom;
    }


    @Column(name="QTE_COST_STK_UM", precision=17, scale=6)
    public BigDecimal getQteCostStkUm() {
        return this.qteCostStkUm;
    }
    
    public void setQteCostStkUm(BigDecimal qteCostStkUm) {
        this.qteCostStkUm = qteCostStkUm;
    }


    @Column(name="QTE_COST_DENOM_STK_UM", precision=17, scale=6)
    public BigDecimal getQteCostDenomStkUm() {
        return this.qteCostDenomStkUm;
    }
    
    public void setQteCostDenomStkUm(BigDecimal qteCostDenomStkUm) {
        this.qteCostDenomStkUm = qteCostDenomStkUm;
    }


    @Column(name="ORG_NBR_MFR_RQST", precision=9, scale=0)
    public Integer getOrgNbrMfrRqst() {
        return this.orgNbrMfrRqst;
    }
    
    public void setOrgNbrMfrRqst(Integer orgNbrMfrRqst) {
        this.orgNbrMfrRqst = orgNbrMfrRqst;
    }


    @Column(name="ORG_CD_MFR", length=15)
    public String getOrgCdMfr() {
        return this.orgCdMfr;
    }
    
    public void setOrgCdMfr(String orgCdMfr) {
        this.orgCdMfr = orgCdMfr;
    }


    @Column(name="ORG_NM_MFR", length=60)
    public String getOrgNmMfr() {
        return this.orgNmMfr;
    }
    
    public void setOrgNmMfr(String orgNmMfr) {
        this.orgNmMfr = orgNmMfr;
    }


    @Column(name="REV_LVL", length=5)
    public String getRevLvl() {
        return this.revLvl;
    }
    
    public void setRevLvl(String revLvl) {
        this.revLvl = revLvl;
    }


    @Column(name="RQST_DT", nullable=false, length=7)
    public Date getRqstDt() {
        return this.rqstDt;
    }
    
    public void setRqstDt(Date rqstDt) {
        this.rqstDt = rqstDt;
    }


    @Column(name="PROM_DT", length=7)
    public Date getPromDt() {
        return this.promDt;
    }
    
    public void setPromDt(Date promDt) {
        this.promDt = promDt;
    }


    @Column(name="LEAD_TM_WK_PROM", precision=3, scale=0)
    public Short getLeadTmWkProm() {
        return this.leadTmWkProm;
    }
    
    public void setLeadTmWkProm(Short leadTmWkProm) {
        this.leadTmWkProm = leadTmWkProm;
    }


    @Column(name="VQ_LOST_CD", length=8)
    public String getVqLostCd() {
        return this.vqLostCd;
    }
    
    public void setVqLostCd(String vqLostCd) {
        this.vqLostCd = vqLostCd;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VqHdrDtlVwId) ) return false;
		 VqHdrDtlVwId castOther = ( VqHdrDtlVwId ) other; 
         
		 return (this.getVqQteHdrNbr()==castOther.getVqQteHdrNbr())
 && ( (this.getVqQteCd()==castOther.getVqQteCd()) || ( this.getVqQteCd()!=null && castOther.getVqQteCd()!=null && this.getVqQteCd().equals(castOther.getVqQteCd()) ) )
 && (this.getOrgNbrVnd()==castOther.getOrgNbrVnd())
 && ( (this.getOrgCdVnd()==castOther.getOrgCdVnd()) || ( this.getOrgCdVnd()!=null && castOther.getOrgCdVnd()!=null && this.getOrgCdVnd().equals(castOther.getOrgCdVnd()) ) )
 && ( (this.getOrgNmVnd()==castOther.getOrgNmVnd()) || ( this.getOrgNmVnd()!=null && castOther.getOrgNmVnd()!=null && this.getOrgNmVnd().equals(castOther.getOrgNmVnd()) ) )
 && ( (this.getVqQteDt()==castOther.getVqQteDt()) || ( this.getVqQteDt()!=null && castOther.getVqQteDt()!=null && this.getVqQteDt().equals(castOther.getVqQteDt()) ) )
 && ( (this.getIndivNmSpokenTo()==castOther.getIndivNmSpokenTo()) || ( this.getIndivNmSpokenTo()!=null && castOther.getIndivNmSpokenTo()!=null && this.getIndivNmSpokenTo().equals(castOther.getIndivNmSpokenTo()) ) )
 && ( (this.getIndivPhnNbr()==castOther.getIndivPhnNbr()) || ( this.getIndivPhnNbr()!=null && castOther.getIndivPhnNbr()!=null && this.getIndivPhnNbr().equals(castOther.getIndivPhnNbr()) ) )
 && ( (this.getIndivFaxNbr()==castOther.getIndivFaxNbr()) || ( this.getIndivFaxNbr()!=null && castOther.getIndivFaxNbr()!=null && this.getIndivFaxNbr().equals(castOther.getIndivFaxNbr()) ) )
 && ( (this.getIndivEmailAddr()==castOther.getIndivEmailAddr()) || ( this.getIndivEmailAddr()!=null && castOther.getIndivEmailAddr()!=null && this.getIndivEmailAddr().equals(castOther.getIndivEmailAddr()) ) )
 && ( (this.getCurrCdQte()==castOther.getCurrCdQte()) || ( this.getCurrCdQte()!=null && castOther.getCurrCdQte()!=null && this.getCurrCdQte().equals(castOther.getCurrCdQte()) ) )
 && ( (this.getVqQteEffDt()==castOther.getVqQteEffDt()) || ( this.getVqQteEffDt()!=null && castOther.getVqQteEffDt()!=null && this.getVqQteEffDt().equals(castOther.getVqQteEffDt()) ) )
 && ( (this.getVqQteExpDt()==castOther.getVqQteExpDt()) || ( this.getVqQteExpDt()!=null && castOther.getVqQteExpDt()!=null && this.getVqQteExpDt().equals(castOther.getVqQteExpDt()) ) )
 && ( (this.getVndQteRefCd()==castOther.getVndQteRefCd()) || ( this.getVndQteRefCd()!=null && castOther.getVndQteRefCd()!=null && this.getVndQteRefCd().equals(castOther.getVndQteRefCd()) ) )
 && ( (this.getTransmitFlg()==castOther.getTransmitFlg()) || ( this.getTransmitFlg()!=null && castOther.getTransmitFlg()!=null && this.getTransmitFlg().equals(castOther.getTransmitFlg()) ) )
 && (this.getVqQteIndivNbr()==castOther.getVqQteIndivNbr())
 && (this.getVqQteDtlNbr()==castOther.getVqQteDtlNbr())
 && ( (this.getItemNbrQte()==castOther.getItemNbrQte()) || ( this.getItemNbrQte()!=null && castOther.getItemNbrQte()!=null && this.getItemNbrQte().equals(castOther.getItemNbrQte()) ) )
 && ( (this.getItemCdQte()==castOther.getItemCdQte()) || ( this.getItemCdQte()!=null && castOther.getItemCdQte()!=null && this.getItemCdQte().equals(castOther.getItemCdQte()) ) )
 && ( (this.getItemCdVnd()==castOther.getItemCdVnd()) || ( this.getItemCdVnd()!=null && castOther.getItemCdVnd()!=null && this.getItemCdVnd().equals(castOther.getItemCdVnd()) ) )
 && ( (this.getQteUm()==castOther.getQteUm()) || ( this.getQteUm()!=null && castOther.getQteUm()!=null && this.getQteUm().equals(castOther.getQteUm()) ) )
 && ( (this.getQteQty()==castOther.getQteQty()) || ( this.getQteQty()!=null && castOther.getQteQty()!=null && this.getQteQty().equals(castOther.getQteQty()) ) )
 && ( (this.getQteCost()==castOther.getQteCost()) || ( this.getQteCost()!=null && castOther.getQteCost()!=null && this.getQteCost().equals(castOther.getQteCost()) ) )
 && ( (this.getQteCostDenom()==castOther.getQteCostDenom()) || ( this.getQteCostDenom()!=null && castOther.getQteCostDenom()!=null && this.getQteCostDenom().equals(castOther.getQteCostDenom()) ) )
 && ( (this.getQteCostStkUm()==castOther.getQteCostStkUm()) || ( this.getQteCostStkUm()!=null && castOther.getQteCostStkUm()!=null && this.getQteCostStkUm().equals(castOther.getQteCostStkUm()) ) )
 && ( (this.getQteCostDenomStkUm()==castOther.getQteCostDenomStkUm()) || ( this.getQteCostDenomStkUm()!=null && castOther.getQteCostDenomStkUm()!=null && this.getQteCostDenomStkUm().equals(castOther.getQteCostDenomStkUm()) ) )
 && ( (this.getOrgNbrMfrRqst()==castOther.getOrgNbrMfrRqst()) || ( this.getOrgNbrMfrRqst()!=null && castOther.getOrgNbrMfrRqst()!=null && this.getOrgNbrMfrRqst().equals(castOther.getOrgNbrMfrRqst()) ) )
 && ( (this.getOrgCdMfr()==castOther.getOrgCdMfr()) || ( this.getOrgCdMfr()!=null && castOther.getOrgCdMfr()!=null && this.getOrgCdMfr().equals(castOther.getOrgCdMfr()) ) )
 && ( (this.getOrgNmMfr()==castOther.getOrgNmMfr()) || ( this.getOrgNmMfr()!=null && castOther.getOrgNmMfr()!=null && this.getOrgNmMfr().equals(castOther.getOrgNmMfr()) ) )
 && ( (this.getRevLvl()==castOther.getRevLvl()) || ( this.getRevLvl()!=null && castOther.getRevLvl()!=null && this.getRevLvl().equals(castOther.getRevLvl()) ) )
 && ( (this.getRqstDt()==castOther.getRqstDt()) || ( this.getRqstDt()!=null && castOther.getRqstDt()!=null && this.getRqstDt().equals(castOther.getRqstDt()) ) )
 && ( (this.getPromDt()==castOther.getPromDt()) || ( this.getPromDt()!=null && castOther.getPromDt()!=null && this.getPromDt().equals(castOther.getPromDt()) ) )
 && ( (this.getLeadTmWkProm()==castOther.getLeadTmWkProm()) || ( this.getLeadTmWkProm()!=null && castOther.getLeadTmWkProm()!=null && this.getLeadTmWkProm().equals(castOther.getLeadTmWkProm()) ) )
 && ( (this.getVqLostCd()==castOther.getVqLostCd()) || ( this.getVqLostCd()!=null && castOther.getVqLostCd()!=null && this.getVqLostCd().equals(castOther.getVqLostCd()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getVqQteHdrNbr();
         result = 37 * result + ( getVqQteCd() == null ? 0 : this.getVqQteCd().hashCode() );
         result = 37 * result + this.getOrgNbrVnd();
         result = 37 * result + ( getOrgCdVnd() == null ? 0 : this.getOrgCdVnd().hashCode() );
         result = 37 * result + ( getOrgNmVnd() == null ? 0 : this.getOrgNmVnd().hashCode() );
         result = 37 * result + ( getVqQteDt() == null ? 0 : this.getVqQteDt().hashCode() );
         result = 37 * result + ( getIndivNmSpokenTo() == null ? 0 : this.getIndivNmSpokenTo().hashCode() );
         result = 37 * result + ( getIndivPhnNbr() == null ? 0 : this.getIndivPhnNbr().hashCode() );
         result = 37 * result + ( getIndivFaxNbr() == null ? 0 : this.getIndivFaxNbr().hashCode() );
         result = 37 * result + ( getIndivEmailAddr() == null ? 0 : this.getIndivEmailAddr().hashCode() );
         result = 37 * result + ( getCurrCdQte() == null ? 0 : this.getCurrCdQte().hashCode() );
         result = 37 * result + ( getVqQteEffDt() == null ? 0 : this.getVqQteEffDt().hashCode() );
         result = 37 * result + ( getVqQteExpDt() == null ? 0 : this.getVqQteExpDt().hashCode() );
         result = 37 * result + ( getVndQteRefCd() == null ? 0 : this.getVndQteRefCd().hashCode() );
         result = 37 * result + ( getTransmitFlg() == null ? 0 : this.getTransmitFlg().hashCode() );
         result = 37 * result + this.getVqQteIndivNbr();
         result = 37 * result + this.getVqQteDtlNbr();
         result = 37 * result + ( getItemNbrQte() == null ? 0 : this.getItemNbrQte().hashCode() );
         result = 37 * result + ( getItemCdQte() == null ? 0 : this.getItemCdQte().hashCode() );
         result = 37 * result + ( getItemCdVnd() == null ? 0 : this.getItemCdVnd().hashCode() );
         result = 37 * result + ( getQteUm() == null ? 0 : this.getQteUm().hashCode() );
         result = 37 * result + ( getQteQty() == null ? 0 : this.getQteQty().hashCode() );
         result = 37 * result + ( getQteCost() == null ? 0 : this.getQteCost().hashCode() );
         result = 37 * result + ( getQteCostDenom() == null ? 0 : this.getQteCostDenom().hashCode() );
         result = 37 * result + ( getQteCostStkUm() == null ? 0 : this.getQteCostStkUm().hashCode() );
         result = 37 * result + ( getQteCostDenomStkUm() == null ? 0 : this.getQteCostDenomStkUm().hashCode() );
         result = 37 * result + ( getOrgNbrMfrRqst() == null ? 0 : this.getOrgNbrMfrRqst().hashCode() );
         result = 37 * result + ( getOrgCdMfr() == null ? 0 : this.getOrgCdMfr().hashCode() );
         result = 37 * result + ( getOrgNmMfr() == null ? 0 : this.getOrgNmMfr().hashCode() );
         result = 37 * result + ( getRevLvl() == null ? 0 : this.getRevLvl().hashCode() );
         result = 37 * result + ( getRqstDt() == null ? 0 : this.getRqstDt().hashCode() );
         result = 37 * result + ( getPromDt() == null ? 0 : this.getPromDt().hashCode() );
         result = 37 * result + ( getLeadTmWkProm() == null ? 0 : this.getLeadTmWkProm().hashCode() );
         result = 37 * result + ( getVqLostCd() == null ? 0 : this.getVqLostCd().hashCode() );
         return result;
   }   


}


