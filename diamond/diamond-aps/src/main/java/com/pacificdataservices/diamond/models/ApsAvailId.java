package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ApsAvailId generated by hbm2java
 */
@Embeddable
public class ApsAvailId  implements java.io.Serializable {


     private String splyIdentifier;
     private Character availTypeCd;
     private BigDecimal lotNbr;
     private Integer itemNbr;
     private String facility;
     private Integer apsSplySubPoolNbr;
     private BigDecimal orgNbrMfr;
     private BigDecimal orgNbrVnd;
     private Date availDt;
     private BigDecimal grossAvailQty;
     private String lotUm;
     private String revLvl;
     private Integer pkSupply;
     private BigDecimal lotCost;
     private String cntryCdOrigin;
     private Date mfrDate;
     private Date expireDt;
     private Date rcptDt;
     private Date apsAvailDt;
     private BigDecimal woItemNbr;
     private String availDtId;

    public ApsAvailId() {
    }

    public ApsAvailId(String splyIdentifier, Character availTypeCd, BigDecimal lotNbr, Integer itemNbr, String facility, Integer apsSplySubPoolNbr, BigDecimal orgNbrMfr, BigDecimal orgNbrVnd, Date availDt, BigDecimal grossAvailQty, String lotUm, String revLvl, Integer pkSupply, BigDecimal lotCost, String cntryCdOrigin, Date mfrDate, Date expireDt, Date rcptDt, Date apsAvailDt, BigDecimal woItemNbr, String availDtId) {
       this.splyIdentifier = splyIdentifier;
       this.availTypeCd = availTypeCd;
       this.lotNbr = lotNbr;
       this.itemNbr = itemNbr;
       this.facility = facility;
       this.apsSplySubPoolNbr = apsSplySubPoolNbr;
       this.orgNbrMfr = orgNbrMfr;
       this.orgNbrVnd = orgNbrVnd;
       this.availDt = availDt;
       this.grossAvailQty = grossAvailQty;
       this.lotUm = lotUm;
       this.revLvl = revLvl;
       this.pkSupply = pkSupply;
       this.lotCost = lotCost;
       this.cntryCdOrigin = cntryCdOrigin;
       this.mfrDate = mfrDate;
       this.expireDt = expireDt;
       this.rcptDt = rcptDt;
       this.apsAvailDt = apsAvailDt;
       this.woItemNbr = woItemNbr;
       this.availDtId = availDtId;
    }
   


    @Column(name="SPLY_IDENTIFIER", length=108)
    public String getSplyIdentifier() {
        return this.splyIdentifier;
    }
    
    public void setSplyIdentifier(String splyIdentifier) {
        this.splyIdentifier = splyIdentifier;
    }


    @Column(name="AVAIL_TYPE_CD", length=1)
    public Character getAvailTypeCd() {
        return this.availTypeCd;
    }
    
    public void setAvailTypeCd(Character availTypeCd) {
        this.availTypeCd = availTypeCd;
    }


    @Column(name="LOT_NBR", precision=22, scale=0)
    public BigDecimal getLotNbr() {
        return this.lotNbr;
    }
    
    public void setLotNbr(BigDecimal lotNbr) {
        this.lotNbr = lotNbr;
    }


    @Column(name="ITEM_NBR", precision=9, scale=0)
    public Integer getItemNbr() {
        return this.itemNbr;
    }
    
    public void setItemNbr(Integer itemNbr) {
        this.itemNbr = itemNbr;
    }


    @Column(name="FACILITY", length=16)
    public String getFacility() {
        return this.facility;
    }
    
    public void setFacility(String facility) {
        this.facility = facility;
    }


    @Column(name="APS_SPLY_SUB_POOL_NBR", precision=9, scale=0)
    public Integer getApsSplySubPoolNbr() {
        return this.apsSplySubPoolNbr;
    }
    
    public void setApsSplySubPoolNbr(Integer apsSplySubPoolNbr) {
        this.apsSplySubPoolNbr = apsSplySubPoolNbr;
    }


    @Column(name="ORG_NBR_MFR", precision=22, scale=0)
    public BigDecimal getOrgNbrMfr() {
        return this.orgNbrMfr;
    }
    
    public void setOrgNbrMfr(BigDecimal orgNbrMfr) {
        this.orgNbrMfr = orgNbrMfr;
    }


    @Column(name="ORG_NBR_VND", precision=22, scale=0)
    public BigDecimal getOrgNbrVnd() {
        return this.orgNbrVnd;
    }
    
    public void setOrgNbrVnd(BigDecimal orgNbrVnd) {
        this.orgNbrVnd = orgNbrVnd;
    }


    @Column(name="AVAIL_DT", length=7)
    public Date getAvailDt() {
        return this.availDt;
    }
    
    public void setAvailDt(Date availDt) {
        this.availDt = availDt;
    }


    @Column(name="GROSS_AVAIL_QTY", precision=22, scale=0)
    public BigDecimal getGrossAvailQty() {
        return this.grossAvailQty;
    }
    
    public void setGrossAvailQty(BigDecimal grossAvailQty) {
        this.grossAvailQty = grossAvailQty;
    }


    @Column(name="LOT_UM", length=3)
    public String getLotUm() {
        return this.lotUm;
    }
    
    public void setLotUm(String lotUm) {
        this.lotUm = lotUm;
    }


    @Column(name="REV_LVL", length=5)
    public String getRevLvl() {
        return this.revLvl;
    }
    
    public void setRevLvl(String revLvl) {
        this.revLvl = revLvl;
    }


    @Column(name="PK_SUPPLY", precision=9, scale=0)
    public Integer getPkSupply() {
        return this.pkSupply;
    }
    
    public void setPkSupply(Integer pkSupply) {
        this.pkSupply = pkSupply;
    }


    @Column(name="LOT_COST", precision=22, scale=0)
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


    @Column(name="APS_AVAIL_DT", length=7)
    public Date getApsAvailDt() {
        return this.apsAvailDt;
    }
    
    public void setApsAvailDt(Date apsAvailDt) {
        this.apsAvailDt = apsAvailDt;
    }


    @Column(name="WO_ITEM_NBR", precision=22, scale=0)
    public BigDecimal getWoItemNbr() {
        return this.woItemNbr;
    }
    
    public void setWoItemNbr(BigDecimal woItemNbr) {
        this.woItemNbr = woItemNbr;
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
		 if ( !(other instanceof ApsAvailId) ) return false;
		 ApsAvailId castOther = ( ApsAvailId ) other; 
         
		 return ( (this.getSplyIdentifier()==castOther.getSplyIdentifier()) || ( this.getSplyIdentifier()!=null && castOther.getSplyIdentifier()!=null && this.getSplyIdentifier().equals(castOther.getSplyIdentifier()) ) )
 && ( (this.getAvailTypeCd()==castOther.getAvailTypeCd()) || ( this.getAvailTypeCd()!=null && castOther.getAvailTypeCd()!=null && this.getAvailTypeCd().equals(castOther.getAvailTypeCd()) ) )
 && ( (this.getLotNbr()==castOther.getLotNbr()) || ( this.getLotNbr()!=null && castOther.getLotNbr()!=null && this.getLotNbr().equals(castOther.getLotNbr()) ) )
 && ( (this.getItemNbr()==castOther.getItemNbr()) || ( this.getItemNbr()!=null && castOther.getItemNbr()!=null && this.getItemNbr().equals(castOther.getItemNbr()) ) )
 && ( (this.getFacility()==castOther.getFacility()) || ( this.getFacility()!=null && castOther.getFacility()!=null && this.getFacility().equals(castOther.getFacility()) ) )
 && ( (this.getApsSplySubPoolNbr()==castOther.getApsSplySubPoolNbr()) || ( this.getApsSplySubPoolNbr()!=null && castOther.getApsSplySubPoolNbr()!=null && this.getApsSplySubPoolNbr().equals(castOther.getApsSplySubPoolNbr()) ) )
 && ( (this.getOrgNbrMfr()==castOther.getOrgNbrMfr()) || ( this.getOrgNbrMfr()!=null && castOther.getOrgNbrMfr()!=null && this.getOrgNbrMfr().equals(castOther.getOrgNbrMfr()) ) )
 && ( (this.getOrgNbrVnd()==castOther.getOrgNbrVnd()) || ( this.getOrgNbrVnd()!=null && castOther.getOrgNbrVnd()!=null && this.getOrgNbrVnd().equals(castOther.getOrgNbrVnd()) ) )
 && ( (this.getAvailDt()==castOther.getAvailDt()) || ( this.getAvailDt()!=null && castOther.getAvailDt()!=null && this.getAvailDt().equals(castOther.getAvailDt()) ) )
 && ( (this.getGrossAvailQty()==castOther.getGrossAvailQty()) || ( this.getGrossAvailQty()!=null && castOther.getGrossAvailQty()!=null && this.getGrossAvailQty().equals(castOther.getGrossAvailQty()) ) )
 && ( (this.getLotUm()==castOther.getLotUm()) || ( this.getLotUm()!=null && castOther.getLotUm()!=null && this.getLotUm().equals(castOther.getLotUm()) ) )
 && ( (this.getRevLvl()==castOther.getRevLvl()) || ( this.getRevLvl()!=null && castOther.getRevLvl()!=null && this.getRevLvl().equals(castOther.getRevLvl()) ) )
 && ( (this.getPkSupply()==castOther.getPkSupply()) || ( this.getPkSupply()!=null && castOther.getPkSupply()!=null && this.getPkSupply().equals(castOther.getPkSupply()) ) )
 && ( (this.getLotCost()==castOther.getLotCost()) || ( this.getLotCost()!=null && castOther.getLotCost()!=null && this.getLotCost().equals(castOther.getLotCost()) ) )
 && ( (this.getCntryCdOrigin()==castOther.getCntryCdOrigin()) || ( this.getCntryCdOrigin()!=null && castOther.getCntryCdOrigin()!=null && this.getCntryCdOrigin().equals(castOther.getCntryCdOrigin()) ) )
 && ( (this.getMfrDate()==castOther.getMfrDate()) || ( this.getMfrDate()!=null && castOther.getMfrDate()!=null && this.getMfrDate().equals(castOther.getMfrDate()) ) )
 && ( (this.getExpireDt()==castOther.getExpireDt()) || ( this.getExpireDt()!=null && castOther.getExpireDt()!=null && this.getExpireDt().equals(castOther.getExpireDt()) ) )
 && ( (this.getRcptDt()==castOther.getRcptDt()) || ( this.getRcptDt()!=null && castOther.getRcptDt()!=null && this.getRcptDt().equals(castOther.getRcptDt()) ) )
 && ( (this.getApsAvailDt()==castOther.getApsAvailDt()) || ( this.getApsAvailDt()!=null && castOther.getApsAvailDt()!=null && this.getApsAvailDt().equals(castOther.getApsAvailDt()) ) )
 && ( (this.getWoItemNbr()==castOther.getWoItemNbr()) || ( this.getWoItemNbr()!=null && castOther.getWoItemNbr()!=null && this.getWoItemNbr().equals(castOther.getWoItemNbr()) ) )
 && ( (this.getAvailDtId()==castOther.getAvailDtId()) || ( this.getAvailDtId()!=null && castOther.getAvailDtId()!=null && this.getAvailDtId().equals(castOther.getAvailDtId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getSplyIdentifier() == null ? 0 : this.getSplyIdentifier().hashCode() );
         result = 37 * result + ( getAvailTypeCd() == null ? 0 : this.getAvailTypeCd().hashCode() );
         result = 37 * result + ( getLotNbr() == null ? 0 : this.getLotNbr().hashCode() );
         result = 37 * result + ( getItemNbr() == null ? 0 : this.getItemNbr().hashCode() );
         result = 37 * result + ( getFacility() == null ? 0 : this.getFacility().hashCode() );
         result = 37 * result + ( getApsSplySubPoolNbr() == null ? 0 : this.getApsSplySubPoolNbr().hashCode() );
         result = 37 * result + ( getOrgNbrMfr() == null ? 0 : this.getOrgNbrMfr().hashCode() );
         result = 37 * result + ( getOrgNbrVnd() == null ? 0 : this.getOrgNbrVnd().hashCode() );
         result = 37 * result + ( getAvailDt() == null ? 0 : this.getAvailDt().hashCode() );
         result = 37 * result + ( getGrossAvailQty() == null ? 0 : this.getGrossAvailQty().hashCode() );
         result = 37 * result + ( getLotUm() == null ? 0 : this.getLotUm().hashCode() );
         result = 37 * result + ( getRevLvl() == null ? 0 : this.getRevLvl().hashCode() );
         result = 37 * result + ( getPkSupply() == null ? 0 : this.getPkSupply().hashCode() );
         result = 37 * result + ( getLotCost() == null ? 0 : this.getLotCost().hashCode() );
         result = 37 * result + ( getCntryCdOrigin() == null ? 0 : this.getCntryCdOrigin().hashCode() );
         result = 37 * result + ( getMfrDate() == null ? 0 : this.getMfrDate().hashCode() );
         result = 37 * result + ( getExpireDt() == null ? 0 : this.getExpireDt().hashCode() );
         result = 37 * result + ( getRcptDt() == null ? 0 : this.getRcptDt().hashCode() );
         result = 37 * result + ( getApsAvailDt() == null ? 0 : this.getApsAvailDt().hashCode() );
         result = 37 * result + ( getWoItemNbr() == null ? 0 : this.getWoItemNbr().hashCode() );
         result = 37 * result + ( getAvailDtId() == null ? 0 : this.getAvailDtId().hashCode() );
         return result;
   }   


}


