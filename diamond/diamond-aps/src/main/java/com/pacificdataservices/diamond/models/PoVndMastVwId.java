package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PoVndMastVwId generated by hbm2java
 */
@Embeddable
public class PoVndMastVwId  implements java.io.Serializable {


     private int orgNbrVnd;
     private String statId;
     private Integer buyIndivNbr;
     private int mailToAddrNbrDflt;
     private String mailToAddrCdDflt;
     private Integer billToAddrNbrDflt;
     private String billToAddrCdDflt;
     private String currCdDflt;
     private String termCdDflt;
     private String shipViaCdDflt;
     private String fobCdDflt;
     private String trdFlg;
     private String trdGlAcct;
     private String orgCdVnd;
     private String orgNmVnd;
     private Date introDt;
     private String replenAllowFlg;
     private String receiveAllowFlg;
     private Integer allocSlipDy;
     private String phnNbrDflt;
     private String faxNbrDflt;
     private Integer indivNbrVndContact;
     private String workOrderRptNm;
     private Date vndUpdDt;

    public PoVndMastVwId() {
    }

	
    public PoVndMastVwId(int orgNbrVnd, String statId, int mailToAddrNbrDflt, String mailToAddrCdDflt, String currCdDflt, String termCdDflt, String shipViaCdDflt, String fobCdDflt, String trdFlg, String orgCdVnd, String orgNmVnd, Date introDt, String replenAllowFlg, String receiveAllowFlg) {
        this.orgNbrVnd = orgNbrVnd;
        this.statId = statId;
        this.mailToAddrNbrDflt = mailToAddrNbrDflt;
        this.mailToAddrCdDflt = mailToAddrCdDflt;
        this.currCdDflt = currCdDflt;
        this.termCdDflt = termCdDflt;
        this.shipViaCdDflt = shipViaCdDflt;
        this.fobCdDflt = fobCdDflt;
        this.trdFlg = trdFlg;
        this.orgCdVnd = orgCdVnd;
        this.orgNmVnd = orgNmVnd;
        this.introDt = introDt;
        this.replenAllowFlg = replenAllowFlg;
        this.receiveAllowFlg = receiveAllowFlg;
    }
    public PoVndMastVwId(int orgNbrVnd, String statId, Integer buyIndivNbr, int mailToAddrNbrDflt, String mailToAddrCdDflt, Integer billToAddrNbrDflt, String billToAddrCdDflt, String currCdDflt, String termCdDflt, String shipViaCdDflt, String fobCdDflt, String trdFlg, String trdGlAcct, String orgCdVnd, String orgNmVnd, Date introDt, String replenAllowFlg, String receiveAllowFlg, Integer allocSlipDy, String phnNbrDflt, String faxNbrDflt, Integer indivNbrVndContact, String workOrderRptNm, Date vndUpdDt) {
       this.orgNbrVnd = orgNbrVnd;
       this.statId = statId;
       this.buyIndivNbr = buyIndivNbr;
       this.mailToAddrNbrDflt = mailToAddrNbrDflt;
       this.mailToAddrCdDflt = mailToAddrCdDflt;
       this.billToAddrNbrDflt = billToAddrNbrDflt;
       this.billToAddrCdDflt = billToAddrCdDflt;
       this.currCdDflt = currCdDflt;
       this.termCdDflt = termCdDflt;
       this.shipViaCdDflt = shipViaCdDflt;
       this.fobCdDflt = fobCdDflt;
       this.trdFlg = trdFlg;
       this.trdGlAcct = trdGlAcct;
       this.orgCdVnd = orgCdVnd;
       this.orgNmVnd = orgNmVnd;
       this.introDt = introDt;
       this.replenAllowFlg = replenAllowFlg;
       this.receiveAllowFlg = receiveAllowFlg;
       this.allocSlipDy = allocSlipDy;
       this.phnNbrDflt = phnNbrDflt;
       this.faxNbrDflt = faxNbrDflt;
       this.indivNbrVndContact = indivNbrVndContact;
       this.workOrderRptNm = workOrderRptNm;
       this.vndUpdDt = vndUpdDt;
    }
   


    @Column(name="ORG_NBR_VND", nullable=false, precision=9, scale=0)
    public int getOrgNbrVnd() {
        return this.orgNbrVnd;
    }
    
    public void setOrgNbrVnd(int orgNbrVnd) {
        this.orgNbrVnd = orgNbrVnd;
    }


    @Column(name="STAT_ID", nullable=false, length=1)
    public String getStatId() {
        return this.statId;
    }
    
    public void setStatId(String statId) {
        this.statId = statId;
    }


    @Column(name="BUY_INDIV_NBR", precision=9, scale=0)
    public Integer getBuyIndivNbr() {
        return this.buyIndivNbr;
    }
    
    public void setBuyIndivNbr(Integer buyIndivNbr) {
        this.buyIndivNbr = buyIndivNbr;
    }


    @Column(name="MAIL_TO_ADDR_NBR_DFLT", nullable=false, precision=9, scale=0)
    public int getMailToAddrNbrDflt() {
        return this.mailToAddrNbrDflt;
    }
    
    public void setMailToAddrNbrDflt(int mailToAddrNbrDflt) {
        this.mailToAddrNbrDflt = mailToAddrNbrDflt;
    }


    @Column(name="MAIL_TO_ADDR_CD_DFLT", nullable=false, length=8)
    public String getMailToAddrCdDflt() {
        return this.mailToAddrCdDflt;
    }
    
    public void setMailToAddrCdDflt(String mailToAddrCdDflt) {
        this.mailToAddrCdDflt = mailToAddrCdDflt;
    }


    @Column(name="BILL_TO_ADDR_NBR_DFLT", precision=9, scale=0)
    public Integer getBillToAddrNbrDflt() {
        return this.billToAddrNbrDflt;
    }
    
    public void setBillToAddrNbrDflt(Integer billToAddrNbrDflt) {
        this.billToAddrNbrDflt = billToAddrNbrDflt;
    }


    @Column(name="BILL_TO_ADDR_CD_DFLT", length=8)
    public String getBillToAddrCdDflt() {
        return this.billToAddrCdDflt;
    }
    
    public void setBillToAddrCdDflt(String billToAddrCdDflt) {
        this.billToAddrCdDflt = billToAddrCdDflt;
    }


    @Column(name="CURR_CD_DFLT", nullable=false, length=3)
    public String getCurrCdDflt() {
        return this.currCdDflt;
    }
    
    public void setCurrCdDflt(String currCdDflt) {
        this.currCdDflt = currCdDflt;
    }


    @Column(name="TERM_CD_DFLT", nullable=false, length=10)
    public String getTermCdDflt() {
        return this.termCdDflt;
    }
    
    public void setTermCdDflt(String termCdDflt) {
        this.termCdDflt = termCdDflt;
    }


    @Column(name="SHIP_VIA_CD_DFLT", nullable=false, length=8)
    public String getShipViaCdDflt() {
        return this.shipViaCdDflt;
    }
    
    public void setShipViaCdDflt(String shipViaCdDflt) {
        this.shipViaCdDflt = shipViaCdDflt;
    }


    @Column(name="FOB_CD_DFLT", nullable=false, length=8)
    public String getFobCdDflt() {
        return this.fobCdDflt;
    }
    
    public void setFobCdDflt(String fobCdDflt) {
        this.fobCdDflt = fobCdDflt;
    }


    @Column(name="TRD_FLG", nullable=false, length=1)
    public String getTrdFlg() {
        return this.trdFlg;
    }
    
    public void setTrdFlg(String trdFlg) {
        this.trdFlg = trdFlg;
    }


    @Column(name="TRD_GL_ACCT", length=20)
    public String getTrdGlAcct() {
        return this.trdGlAcct;
    }
    
    public void setTrdGlAcct(String trdGlAcct) {
        this.trdGlAcct = trdGlAcct;
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


    @Column(name="INTRO_DT", nullable=false, length=7)
    public Date getIntroDt() {
        return this.introDt;
    }
    
    public void setIntroDt(Date introDt) {
        this.introDt = introDt;
    }


    @Column(name="REPLEN_ALLOW_FLG", nullable=false, length=1)
    public String getReplenAllowFlg() {
        return this.replenAllowFlg;
    }
    
    public void setReplenAllowFlg(String replenAllowFlg) {
        this.replenAllowFlg = replenAllowFlg;
    }


    @Column(name="RECEIVE_ALLOW_FLG", nullable=false, length=1)
    public String getReceiveAllowFlg() {
        return this.receiveAllowFlg;
    }
    
    public void setReceiveAllowFlg(String receiveAllowFlg) {
        this.receiveAllowFlg = receiveAllowFlg;
    }


    @Column(name="ALLOC_SLIP_DY", precision=5, scale=0)
    public Integer getAllocSlipDy() {
        return this.allocSlipDy;
    }
    
    public void setAllocSlipDy(Integer allocSlipDy) {
        this.allocSlipDy = allocSlipDy;
    }


    @Column(name="PHN_NBR_DFLT", length=20)
    public String getPhnNbrDflt() {
        return this.phnNbrDflt;
    }
    
    public void setPhnNbrDflt(String phnNbrDflt) {
        this.phnNbrDflt = phnNbrDflt;
    }


    @Column(name="FAX_NBR_DFLT", length=20)
    public String getFaxNbrDflt() {
        return this.faxNbrDflt;
    }
    
    public void setFaxNbrDflt(String faxNbrDflt) {
        this.faxNbrDflt = faxNbrDflt;
    }


    @Column(name="INDIV_NBR_VND_CONTACT", precision=9, scale=0)
    public Integer getIndivNbrVndContact() {
        return this.indivNbrVndContact;
    }
    
    public void setIndivNbrVndContact(Integer indivNbrVndContact) {
        this.indivNbrVndContact = indivNbrVndContact;
    }


    @Column(name="WORK_ORDER_RPT_NM")
    public String getWorkOrderRptNm() {
        return this.workOrderRptNm;
    }
    
    public void setWorkOrderRptNm(String workOrderRptNm) {
        this.workOrderRptNm = workOrderRptNm;
    }


    @Column(name="VND_UPD_DT", length=7)
    public Date getVndUpdDt() {
        return this.vndUpdDt;
    }
    
    public void setVndUpdDt(Date vndUpdDt) {
        this.vndUpdDt = vndUpdDt;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PoVndMastVwId) ) return false;
		 PoVndMastVwId castOther = ( PoVndMastVwId ) other; 
         
		 return (this.getOrgNbrVnd()==castOther.getOrgNbrVnd())
 && ( (this.getStatId()==castOther.getStatId()) || ( this.getStatId()!=null && castOther.getStatId()!=null && this.getStatId().equals(castOther.getStatId()) ) )
 && ( (this.getBuyIndivNbr()==castOther.getBuyIndivNbr()) || ( this.getBuyIndivNbr()!=null && castOther.getBuyIndivNbr()!=null && this.getBuyIndivNbr().equals(castOther.getBuyIndivNbr()) ) )
 && (this.getMailToAddrNbrDflt()==castOther.getMailToAddrNbrDflt())
 && ( (this.getMailToAddrCdDflt()==castOther.getMailToAddrCdDflt()) || ( this.getMailToAddrCdDflt()!=null && castOther.getMailToAddrCdDflt()!=null && this.getMailToAddrCdDflt().equals(castOther.getMailToAddrCdDflt()) ) )
 && ( (this.getBillToAddrNbrDflt()==castOther.getBillToAddrNbrDflt()) || ( this.getBillToAddrNbrDflt()!=null && castOther.getBillToAddrNbrDflt()!=null && this.getBillToAddrNbrDflt().equals(castOther.getBillToAddrNbrDflt()) ) )
 && ( (this.getBillToAddrCdDflt()==castOther.getBillToAddrCdDflt()) || ( this.getBillToAddrCdDflt()!=null && castOther.getBillToAddrCdDflt()!=null && this.getBillToAddrCdDflt().equals(castOther.getBillToAddrCdDflt()) ) )
 && ( (this.getCurrCdDflt()==castOther.getCurrCdDflt()) || ( this.getCurrCdDflt()!=null && castOther.getCurrCdDflt()!=null && this.getCurrCdDflt().equals(castOther.getCurrCdDflt()) ) )
 && ( (this.getTermCdDflt()==castOther.getTermCdDflt()) || ( this.getTermCdDflt()!=null && castOther.getTermCdDflt()!=null && this.getTermCdDflt().equals(castOther.getTermCdDflt()) ) )
 && ( (this.getShipViaCdDflt()==castOther.getShipViaCdDflt()) || ( this.getShipViaCdDflt()!=null && castOther.getShipViaCdDflt()!=null && this.getShipViaCdDflt().equals(castOther.getShipViaCdDflt()) ) )
 && ( (this.getFobCdDflt()==castOther.getFobCdDflt()) || ( this.getFobCdDflt()!=null && castOther.getFobCdDflt()!=null && this.getFobCdDflt().equals(castOther.getFobCdDflt()) ) )
 && ( (this.getTrdFlg()==castOther.getTrdFlg()) || ( this.getTrdFlg()!=null && castOther.getTrdFlg()!=null && this.getTrdFlg().equals(castOther.getTrdFlg()) ) )
 && ( (this.getTrdGlAcct()==castOther.getTrdGlAcct()) || ( this.getTrdGlAcct()!=null && castOther.getTrdGlAcct()!=null && this.getTrdGlAcct().equals(castOther.getTrdGlAcct()) ) )
 && ( (this.getOrgCdVnd()==castOther.getOrgCdVnd()) || ( this.getOrgCdVnd()!=null && castOther.getOrgCdVnd()!=null && this.getOrgCdVnd().equals(castOther.getOrgCdVnd()) ) )
 && ( (this.getOrgNmVnd()==castOther.getOrgNmVnd()) || ( this.getOrgNmVnd()!=null && castOther.getOrgNmVnd()!=null && this.getOrgNmVnd().equals(castOther.getOrgNmVnd()) ) )
 && ( (this.getIntroDt()==castOther.getIntroDt()) || ( this.getIntroDt()!=null && castOther.getIntroDt()!=null && this.getIntroDt().equals(castOther.getIntroDt()) ) )
 && ( (this.getReplenAllowFlg()==castOther.getReplenAllowFlg()) || ( this.getReplenAllowFlg()!=null && castOther.getReplenAllowFlg()!=null && this.getReplenAllowFlg().equals(castOther.getReplenAllowFlg()) ) )
 && ( (this.getReceiveAllowFlg()==castOther.getReceiveAllowFlg()) || ( this.getReceiveAllowFlg()!=null && castOther.getReceiveAllowFlg()!=null && this.getReceiveAllowFlg().equals(castOther.getReceiveAllowFlg()) ) )
 && ( (this.getAllocSlipDy()==castOther.getAllocSlipDy()) || ( this.getAllocSlipDy()!=null && castOther.getAllocSlipDy()!=null && this.getAllocSlipDy().equals(castOther.getAllocSlipDy()) ) )
 && ( (this.getPhnNbrDflt()==castOther.getPhnNbrDflt()) || ( this.getPhnNbrDflt()!=null && castOther.getPhnNbrDflt()!=null && this.getPhnNbrDflt().equals(castOther.getPhnNbrDflt()) ) )
 && ( (this.getFaxNbrDflt()==castOther.getFaxNbrDflt()) || ( this.getFaxNbrDflt()!=null && castOther.getFaxNbrDflt()!=null && this.getFaxNbrDflt().equals(castOther.getFaxNbrDflt()) ) )
 && ( (this.getIndivNbrVndContact()==castOther.getIndivNbrVndContact()) || ( this.getIndivNbrVndContact()!=null && castOther.getIndivNbrVndContact()!=null && this.getIndivNbrVndContact().equals(castOther.getIndivNbrVndContact()) ) )
 && ( (this.getWorkOrderRptNm()==castOther.getWorkOrderRptNm()) || ( this.getWorkOrderRptNm()!=null && castOther.getWorkOrderRptNm()!=null && this.getWorkOrderRptNm().equals(castOther.getWorkOrderRptNm()) ) )
 && ( (this.getVndUpdDt()==castOther.getVndUpdDt()) || ( this.getVndUpdDt()!=null && castOther.getVndUpdDt()!=null && this.getVndUpdDt().equals(castOther.getVndUpdDt()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getOrgNbrVnd();
         result = 37 * result + ( getStatId() == null ? 0 : this.getStatId().hashCode() );
         result = 37 * result + ( getBuyIndivNbr() == null ? 0 : this.getBuyIndivNbr().hashCode() );
         result = 37 * result + this.getMailToAddrNbrDflt();
         result = 37 * result + ( getMailToAddrCdDflt() == null ? 0 : this.getMailToAddrCdDflt().hashCode() );
         result = 37 * result + ( getBillToAddrNbrDflt() == null ? 0 : this.getBillToAddrNbrDflt().hashCode() );
         result = 37 * result + ( getBillToAddrCdDflt() == null ? 0 : this.getBillToAddrCdDflt().hashCode() );
         result = 37 * result + ( getCurrCdDflt() == null ? 0 : this.getCurrCdDflt().hashCode() );
         result = 37 * result + ( getTermCdDflt() == null ? 0 : this.getTermCdDflt().hashCode() );
         result = 37 * result + ( getShipViaCdDflt() == null ? 0 : this.getShipViaCdDflt().hashCode() );
         result = 37 * result + ( getFobCdDflt() == null ? 0 : this.getFobCdDflt().hashCode() );
         result = 37 * result + ( getTrdFlg() == null ? 0 : this.getTrdFlg().hashCode() );
         result = 37 * result + ( getTrdGlAcct() == null ? 0 : this.getTrdGlAcct().hashCode() );
         result = 37 * result + ( getOrgCdVnd() == null ? 0 : this.getOrgCdVnd().hashCode() );
         result = 37 * result + ( getOrgNmVnd() == null ? 0 : this.getOrgNmVnd().hashCode() );
         result = 37 * result + ( getIntroDt() == null ? 0 : this.getIntroDt().hashCode() );
         result = 37 * result + ( getReplenAllowFlg() == null ? 0 : this.getReplenAllowFlg().hashCode() );
         result = 37 * result + ( getReceiveAllowFlg() == null ? 0 : this.getReceiveAllowFlg().hashCode() );
         result = 37 * result + ( getAllocSlipDy() == null ? 0 : this.getAllocSlipDy().hashCode() );
         result = 37 * result + ( getPhnNbrDflt() == null ? 0 : this.getPhnNbrDflt().hashCode() );
         result = 37 * result + ( getFaxNbrDflt() == null ? 0 : this.getFaxNbrDflt().hashCode() );
         result = 37 * result + ( getIndivNbrVndContact() == null ? 0 : this.getIndivNbrVndContact().hashCode() );
         result = 37 * result + ( getWorkOrderRptNm() == null ? 0 : this.getWorkOrderRptNm().hashCode() );
         result = 37 * result + ( getVndUpdDt() == null ? 0 : this.getVndUpdDt().hashCode() );
         return result;
   }   


}

