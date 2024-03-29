package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ApsAvailOnhandDtlId generated by hbm2java
 */
@Embeddable
public class ApsAvailOnhandDtlId  implements java.io.Serializable {


     private String facility;
     private int apsSplySubPoolNbr;
     private Integer orgNbrMfr;
     private int orgNbrVnd;
     private int lotNbr;
     private String lotUm;
     private int itemNbr;
     private Date availDt;
     private BigDecimal onhandQty;
     private String revLvl;
     private int pkSupply;
     private String splyIdentifier;
     private BigDecimal lotCost;
     private String cntryCdOrigin;
     private Date mfrDate;
     private Date expireDt;
     private Date rcptDt;
     private String availDtId;

    public ApsAvailOnhandDtlId() {
    }

	
    public ApsAvailOnhandDtlId(String facility, int apsSplySubPoolNbr, int orgNbrVnd, int lotNbr, String lotUm, int itemNbr, int pkSupply, BigDecimal lotCost) {
        this.facility = facility;
        this.apsSplySubPoolNbr = apsSplySubPoolNbr;
        this.orgNbrVnd = orgNbrVnd;
        this.lotNbr = lotNbr;
        this.lotUm = lotUm;
        this.itemNbr = itemNbr;
        this.pkSupply = pkSupply;
        this.lotCost = lotCost;
    }
    public ApsAvailOnhandDtlId(String facility, int apsSplySubPoolNbr, Integer orgNbrMfr, int orgNbrVnd, int lotNbr, String lotUm, int itemNbr, Date availDt, BigDecimal onhandQty, String revLvl, int pkSupply, String splyIdentifier, BigDecimal lotCost, String cntryCdOrigin, Date mfrDate, Date expireDt, Date rcptDt, String availDtId) {
       this.facility = facility;
       this.apsSplySubPoolNbr = apsSplySubPoolNbr;
       this.orgNbrMfr = orgNbrMfr;
       this.orgNbrVnd = orgNbrVnd;
       this.lotNbr = lotNbr;
       this.lotUm = lotUm;
       this.itemNbr = itemNbr;
       this.availDt = availDt;
       this.onhandQty = onhandQty;
       this.revLvl = revLvl;
       this.pkSupply = pkSupply;
       this.splyIdentifier = splyIdentifier;
       this.lotCost = lotCost;
       this.cntryCdOrigin = cntryCdOrigin;
       this.mfrDate = mfrDate;
       this.expireDt = expireDt;
       this.rcptDt = rcptDt;
       this.availDtId = availDtId;
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


    @Column(name="ORG_NBR_MFR", precision=9, scale=0)
    public Integer getOrgNbrMfr() {
        return this.orgNbrMfr;
    }
    
    public void setOrgNbrMfr(Integer orgNbrMfr) {
        this.orgNbrMfr = orgNbrMfr;
    }


    @Column(name="ORG_NBR_VND", nullable=false, precision=9, scale=0)
    public int getOrgNbrVnd() {
        return this.orgNbrVnd;
    }
    
    public void setOrgNbrVnd(int orgNbrVnd) {
        this.orgNbrVnd = orgNbrVnd;
    }


    @Column(name="LOT_NBR", nullable=false, precision=9, scale=0)
    public int getLotNbr() {
        return this.lotNbr;
    }
    
    public void setLotNbr(int lotNbr) {
        this.lotNbr = lotNbr;
    }


    @Column(name="LOT_UM", nullable=false, length=3)
    public String getLotUm() {
        return this.lotUm;
    }
    
    public void setLotUm(String lotUm) {
        this.lotUm = lotUm;
    }


    @Column(name="ITEM_NBR", nullable=false, precision=9, scale=0)
    public int getItemNbr() {
        return this.itemNbr;
    }
    
    public void setItemNbr(int itemNbr) {
        this.itemNbr = itemNbr;
    }


    @Column(name="AVAIL_DT", length=7)
    public Date getAvailDt() {
        return this.availDt;
    }
    
    public void setAvailDt(Date availDt) {
        this.availDt = availDt;
    }


    @Column(name="ONHAND_QTY", precision=12, scale=5)
    public BigDecimal getOnhandQty() {
        return this.onhandQty;
    }
    
    public void setOnhandQty(BigDecimal onhandQty) {
        this.onhandQty = onhandQty;
    }


    @Column(name="REV_LVL", length=5)
    public String getRevLvl() {
        return this.revLvl;
    }
    
    public void setRevLvl(String revLvl) {
        this.revLvl = revLvl;
    }


    @Column(name="PK_SUPPLY", nullable=false, precision=9, scale=0)
    public int getPkSupply() {
        return this.pkSupply;
    }
    
    public void setPkSupply(int pkSupply) {
        this.pkSupply = pkSupply;
    }


    @Column(name="SPLY_IDENTIFIER", length=40)
    public String getSplyIdentifier() {
        return this.splyIdentifier;
    }
    
    public void setSplyIdentifier(String splyIdentifier) {
        this.splyIdentifier = splyIdentifier;
    }


    @Column(name="LOT_COST", nullable=false, precision=13, scale=6)
    public BigDecimal getLotCost() {
        return this.lotCost;
    }
    
    public void setLotCost(BigDecimal lotCost) {
        this.lotCost = lotCost;
    }


    @Column(name="CNTRY_CD_ORIGIN", length=3)
    public String getCntryCdOrigin() {
        return this.cntryCdOrigin;
    }
    
    public void setCntryCdOrigin(String cntryCdOrigin) {
        this.cntryCdOrigin = cntryCdOrigin;
    }


    @Column(name="MFR_DATE", length=7)
    public Date getMfrDate() {
        return this.mfrDate;
    }
    
    public void setMfrDate(Date mfrDate) {
        this.mfrDate = mfrDate;
    }


    @Column(name="EXPIRE_DT", length=7)
    public Date getExpireDt() {
        return this.expireDt;
    }
    
    public void setExpireDt(Date expireDt) {
        this.expireDt = expireDt;
    }


    @Column(name="RCPT_DT", length=7)
    public Date getRcptDt() {
        return this.rcptDt;
    }
    
    public void setRcptDt(Date rcptDt) {
        this.rcptDt = rcptDt;
    }


    @Column(name="AVAIL_DT_ID", length=1)
    public String getAvailDtId() {
        return this.availDtId;
    }
    
    public void setAvailDtId(String availDtId) {
        this.availDtId = availDtId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ApsAvailOnhandDtlId) ) return false;
		 ApsAvailOnhandDtlId castOther = ( ApsAvailOnhandDtlId ) other; 
         
		 return ( (this.getFacility()==castOther.getFacility()) || ( this.getFacility()!=null && castOther.getFacility()!=null && this.getFacility().equals(castOther.getFacility()) ) )
 && (this.getApsSplySubPoolNbr()==castOther.getApsSplySubPoolNbr())
 && ( (this.getOrgNbrMfr()==castOther.getOrgNbrMfr()) || ( this.getOrgNbrMfr()!=null && castOther.getOrgNbrMfr()!=null && this.getOrgNbrMfr().equals(castOther.getOrgNbrMfr()) ) )
 && (this.getOrgNbrVnd()==castOther.getOrgNbrVnd())
 && (this.getLotNbr()==castOther.getLotNbr())
 && ( (this.getLotUm()==castOther.getLotUm()) || ( this.getLotUm()!=null && castOther.getLotUm()!=null && this.getLotUm().equals(castOther.getLotUm()) ) )
 && (this.getItemNbr()==castOther.getItemNbr())
 && ( (this.getAvailDt()==castOther.getAvailDt()) || ( this.getAvailDt()!=null && castOther.getAvailDt()!=null && this.getAvailDt().equals(castOther.getAvailDt()) ) )
 && ( (this.getOnhandQty()==castOther.getOnhandQty()) || ( this.getOnhandQty()!=null && castOther.getOnhandQty()!=null && this.getOnhandQty().equals(castOther.getOnhandQty()) ) )
 && ( (this.getRevLvl()==castOther.getRevLvl()) || ( this.getRevLvl()!=null && castOther.getRevLvl()!=null && this.getRevLvl().equals(castOther.getRevLvl()) ) )
 && (this.getPkSupply()==castOther.getPkSupply())
 && ( (this.getSplyIdentifier()==castOther.getSplyIdentifier()) || ( this.getSplyIdentifier()!=null && castOther.getSplyIdentifier()!=null && this.getSplyIdentifier().equals(castOther.getSplyIdentifier()) ) )
 && ( (this.getLotCost()==castOther.getLotCost()) || ( this.getLotCost()!=null && castOther.getLotCost()!=null && this.getLotCost().equals(castOther.getLotCost()) ) )
 && ( (this.getCntryCdOrigin()==castOther.getCntryCdOrigin()) || ( this.getCntryCdOrigin()!=null && castOther.getCntryCdOrigin()!=null && this.getCntryCdOrigin().equals(castOther.getCntryCdOrigin()) ) )
 && ( (this.getMfrDate()==castOther.getMfrDate()) || ( this.getMfrDate()!=null && castOther.getMfrDate()!=null && this.getMfrDate().equals(castOther.getMfrDate()) ) )
 && ( (this.getExpireDt()==castOther.getExpireDt()) || ( this.getExpireDt()!=null && castOther.getExpireDt()!=null && this.getExpireDt().equals(castOther.getExpireDt()) ) )
 && ( (this.getRcptDt()==castOther.getRcptDt()) || ( this.getRcptDt()!=null && castOther.getRcptDt()!=null && this.getRcptDt().equals(castOther.getRcptDt()) ) )
 && ( (this.getAvailDtId()==castOther.getAvailDtId()) || ( this.getAvailDtId()!=null && castOther.getAvailDtId()!=null && this.getAvailDtId().equals(castOther.getAvailDtId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getFacility() == null ? 0 : this.getFacility().hashCode() );
         result = 37 * result + this.getApsSplySubPoolNbr();
         result = 37 * result + ( getOrgNbrMfr() == null ? 0 : this.getOrgNbrMfr().hashCode() );
         result = 37 * result + this.getOrgNbrVnd();
         result = 37 * result + this.getLotNbr();
         result = 37 * result + ( getLotUm() == null ? 0 : this.getLotUm().hashCode() );
         result = 37 * result + this.getItemNbr();
         result = 37 * result + ( getAvailDt() == null ? 0 : this.getAvailDt().hashCode() );
         result = 37 * result + ( getOnhandQty() == null ? 0 : this.getOnhandQty().hashCode() );
         result = 37 * result + ( getRevLvl() == null ? 0 : this.getRevLvl().hashCode() );
         result = 37 * result + this.getPkSupply();
         result = 37 * result + ( getSplyIdentifier() == null ? 0 : this.getSplyIdentifier().hashCode() );
         result = 37 * result + ( getLotCost() == null ? 0 : this.getLotCost().hashCode() );
         result = 37 * result + ( getCntryCdOrigin() == null ? 0 : this.getCntryCdOrigin().hashCode() );
         result = 37 * result + ( getMfrDate() == null ? 0 : this.getMfrDate().hashCode() );
         result = 37 * result + ( getExpireDt() == null ? 0 : this.getExpireDt().hashCode() );
         result = 37 * result + ( getRcptDt() == null ? 0 : this.getRcptDt().hashCode() );
         result = 37 * result + ( getAvailDtId() == null ? 0 : this.getAvailDtId().hashCode() );
         return result;
   }   


}


