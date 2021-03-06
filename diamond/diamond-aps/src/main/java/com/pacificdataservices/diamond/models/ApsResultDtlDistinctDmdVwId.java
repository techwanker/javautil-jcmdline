package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ApsResultDtlDistinctDmdVwId generated by hbm2java
 */
@Embeddable
public class ApsResultDtlDistinctDmdVwId  implements java.io.Serializable {


     private int apsResultDtlDmdNbr;
     private Integer itemNbrRqst;
     private String dmdIdentifier;
     private Integer oeOrdDtlNbr;
     private Integer woDtlNbr;
     private Integer fcFcstNbr;
     private Integer fcItemMastNbr;
     private BigDecimal dmdQty;
     private BigDecimal dmdQtyAdj;
     private BigDecimal allocQty;
     private Date rqstDt;
     private Date promDtCurr;
     private BigDecimal rqstDtAllocQty;
     private Date availDt;
     private Integer apsSrcRuleSetNbrDmd;
     private Integer orgNbrCust;
     private Integer orgNbrMfrRqst;
     private String itemCd;
     private String itemDescr;
     private int icCategoryNbr;
     private Integer poVndSetHdrNbr;
     private String facilityRqst;
     private String orgCdCust;
     private String orgNmCust;
     private String cntryCdOrigin;
     private String revLvl;
     private Date lotManufactureAfterDt;
     private Date lotNotExpireBeforeDt;
     private String orgCdMfr;
     private String orgNmMfr;

    public ApsResultDtlDistinctDmdVwId() {
    }

	
    public ApsResultDtlDistinctDmdVwId(int apsResultDtlDmdNbr, String itemCd, String itemDescr, int icCategoryNbr, String facilityRqst, String orgCdCust, String orgNmCust) {
        this.apsResultDtlDmdNbr = apsResultDtlDmdNbr;
        this.itemCd = itemCd;
        this.itemDescr = itemDescr;
        this.icCategoryNbr = icCategoryNbr;
        this.facilityRqst = facilityRqst;
        this.orgCdCust = orgCdCust;
        this.orgNmCust = orgNmCust;
    }
    public ApsResultDtlDistinctDmdVwId(int apsResultDtlDmdNbr, Integer itemNbrRqst, String dmdIdentifier, Integer oeOrdDtlNbr, Integer woDtlNbr, Integer fcFcstNbr, Integer fcItemMastNbr, BigDecimal dmdQty, BigDecimal dmdQtyAdj, BigDecimal allocQty, Date rqstDt, Date promDtCurr, BigDecimal rqstDtAllocQty, Date availDt, Integer apsSrcRuleSetNbrDmd, Integer orgNbrCust, Integer orgNbrMfrRqst, String itemCd, String itemDescr, int icCategoryNbr, Integer poVndSetHdrNbr, String facilityRqst, String orgCdCust, String orgNmCust, String cntryCdOrigin, String revLvl, Date lotManufactureAfterDt, Date lotNotExpireBeforeDt, String orgCdMfr, String orgNmMfr) {
       this.apsResultDtlDmdNbr = apsResultDtlDmdNbr;
       this.itemNbrRqst = itemNbrRqst;
       this.dmdIdentifier = dmdIdentifier;
       this.oeOrdDtlNbr = oeOrdDtlNbr;
       this.woDtlNbr = woDtlNbr;
       this.fcFcstNbr = fcFcstNbr;
       this.fcItemMastNbr = fcItemMastNbr;
       this.dmdQty = dmdQty;
       this.dmdQtyAdj = dmdQtyAdj;
       this.allocQty = allocQty;
       this.rqstDt = rqstDt;
       this.promDtCurr = promDtCurr;
       this.rqstDtAllocQty = rqstDtAllocQty;
       this.availDt = availDt;
       this.apsSrcRuleSetNbrDmd = apsSrcRuleSetNbrDmd;
       this.orgNbrCust = orgNbrCust;
       this.orgNbrMfrRqst = orgNbrMfrRqst;
       this.itemCd = itemCd;
       this.itemDescr = itemDescr;
       this.icCategoryNbr = icCategoryNbr;
       this.poVndSetHdrNbr = poVndSetHdrNbr;
       this.facilityRqst = facilityRqst;
       this.orgCdCust = orgCdCust;
       this.orgNmCust = orgNmCust;
       this.cntryCdOrigin = cntryCdOrigin;
       this.revLvl = revLvl;
       this.lotManufactureAfterDt = lotManufactureAfterDt;
       this.lotNotExpireBeforeDt = lotNotExpireBeforeDt;
       this.orgCdMfr = orgCdMfr;
       this.orgNmMfr = orgNmMfr;
    }
   


    @Column(name="APS_RESULT_DTL_DMD_NBR", nullable=false, precision=9, scale=0)
    public int getApsResultDtlDmdNbr() {
        return this.apsResultDtlDmdNbr;
    }
    
    public void setApsResultDtlDmdNbr(int apsResultDtlDmdNbr) {
        this.apsResultDtlDmdNbr = apsResultDtlDmdNbr;
    }


    @Column(name="ITEM_NBR_RQST", precision=9, scale=0)
    public Integer getItemNbrRqst() {
        return this.itemNbrRqst;
    }
    
    public void setItemNbrRqst(Integer itemNbrRqst) {
        this.itemNbrRqst = itemNbrRqst;
    }


    @Column(name="DMD_IDENTIFIER", length=20)
    public String getDmdIdentifier() {
        return this.dmdIdentifier;
    }
    
    public void setDmdIdentifier(String dmdIdentifier) {
        this.dmdIdentifier = dmdIdentifier;
    }


    @Column(name="OE_ORD_DTL_NBR", precision=9, scale=0)
    public Integer getOeOrdDtlNbr() {
        return this.oeOrdDtlNbr;
    }
    
    public void setOeOrdDtlNbr(Integer oeOrdDtlNbr) {
        this.oeOrdDtlNbr = oeOrdDtlNbr;
    }


    @Column(name="WO_DTL_NBR", precision=9, scale=0)
    public Integer getWoDtlNbr() {
        return this.woDtlNbr;
    }
    
    public void setWoDtlNbr(Integer woDtlNbr) {
        this.woDtlNbr = woDtlNbr;
    }


    @Column(name="FC_FCST_NBR", precision=9, scale=0)
    public Integer getFcFcstNbr() {
        return this.fcFcstNbr;
    }
    
    public void setFcFcstNbr(Integer fcFcstNbr) {
        this.fcFcstNbr = fcFcstNbr;
    }


    @Column(name="FC_ITEM_MAST_NBR", precision=9, scale=0)
    public Integer getFcItemMastNbr() {
        return this.fcItemMastNbr;
    }
    
    public void setFcItemMastNbr(Integer fcItemMastNbr) {
        this.fcItemMastNbr = fcItemMastNbr;
    }


    @Column(name="DMD_QTY", precision=13, scale=5)
    public BigDecimal getDmdQty() {
        return this.dmdQty;
    }
    
    public void setDmdQty(BigDecimal dmdQty) {
        this.dmdQty = dmdQty;
    }


    @Column(name="DMD_QTY_ADJ", precision=13, scale=5)
    public BigDecimal getDmdQtyAdj() {
        return this.dmdQtyAdj;
    }
    
    public void setDmdQtyAdj(BigDecimal dmdQtyAdj) {
        this.dmdQtyAdj = dmdQtyAdj;
    }


    @Column(name="ALLOC_QTY", precision=13, scale=5)
    public BigDecimal getAllocQty() {
        return this.allocQty;
    }
    
    public void setAllocQty(BigDecimal allocQty) {
        this.allocQty = allocQty;
    }


    @Column(name="RQST_DT", length=7)
    public Date getRqstDt() {
        return this.rqstDt;
    }
    
    public void setRqstDt(Date rqstDt) {
        this.rqstDt = rqstDt;
    }


    @Column(name="PROM_DT_CURR", length=7)
    public Date getPromDtCurr() {
        return this.promDtCurr;
    }
    
    public void setPromDtCurr(Date promDtCurr) {
        this.promDtCurr = promDtCurr;
    }


    @Column(name="RQST_DT_ALLOC_QTY", precision=13, scale=5)
    public BigDecimal getRqstDtAllocQty() {
        return this.rqstDtAllocQty;
    }
    
    public void setRqstDtAllocQty(BigDecimal rqstDtAllocQty) {
        this.rqstDtAllocQty = rqstDtAllocQty;
    }


    @Column(name="AVAIL_DT", length=7)
    public Date getAvailDt() {
        return this.availDt;
    }
    
    public void setAvailDt(Date availDt) {
        this.availDt = availDt;
    }


    @Column(name="APS_SRC_RULE_SET_NBR_DMD", precision=9, scale=0)
    public Integer getApsSrcRuleSetNbrDmd() {
        return this.apsSrcRuleSetNbrDmd;
    }
    
    public void setApsSrcRuleSetNbrDmd(Integer apsSrcRuleSetNbrDmd) {
        this.apsSrcRuleSetNbrDmd = apsSrcRuleSetNbrDmd;
    }


    @Column(name="ORG_NBR_CUST", precision=9, scale=0)
    public Integer getOrgNbrCust() {
        return this.orgNbrCust;
    }
    
    public void setOrgNbrCust(Integer orgNbrCust) {
        this.orgNbrCust = orgNbrCust;
    }


    @Column(name="ORG_NBR_MFR_RQST", precision=9, scale=0)
    public Integer getOrgNbrMfrRqst() {
        return this.orgNbrMfrRqst;
    }
    
    public void setOrgNbrMfrRqst(Integer orgNbrMfrRqst) {
        this.orgNbrMfrRqst = orgNbrMfrRqst;
    }


    @Column(name="ITEM_CD", nullable=false, length=50)
    public String getItemCd() {
        return this.itemCd;
    }
    
    public void setItemCd(String itemCd) {
        this.itemCd = itemCd;
    }


    @Column(name="ITEM_DESCR", nullable=false, length=50)
    public String getItemDescr() {
        return this.itemDescr;
    }
    
    public void setItemDescr(String itemDescr) {
        this.itemDescr = itemDescr;
    }


    @Column(name="IC_CATEGORY_NBR", nullable=false, precision=9, scale=0)
    public int getIcCategoryNbr() {
        return this.icCategoryNbr;
    }
    
    public void setIcCategoryNbr(int icCategoryNbr) {
        this.icCategoryNbr = icCategoryNbr;
    }


    @Column(name="PO_VND_SET_HDR_NBR", precision=9, scale=0)
    public Integer getPoVndSetHdrNbr() {
        return this.poVndSetHdrNbr;
    }
    
    public void setPoVndSetHdrNbr(Integer poVndSetHdrNbr) {
        this.poVndSetHdrNbr = poVndSetHdrNbr;
    }


    @Column(name="FACILITY_RQST", nullable=false, length=16)
    public String getFacilityRqst() {
        return this.facilityRqst;
    }
    
    public void setFacilityRqst(String facilityRqst) {
        this.facilityRqst = facilityRqst;
    }


    @Column(name="ORG_CD_CUST", nullable=false, length=15)
    public String getOrgCdCust() {
        return this.orgCdCust;
    }
    
    public void setOrgCdCust(String orgCdCust) {
        this.orgCdCust = orgCdCust;
    }


    @Column(name="ORG_NM_CUST", nullable=false, length=60)
    public String getOrgNmCust() {
        return this.orgNmCust;
    }
    
    public void setOrgNmCust(String orgNmCust) {
        this.orgNmCust = orgNmCust;
    }


    @Column(name="CNTRY_CD_ORIGIN", length=3)
    public String getCntryCdOrigin() {
        return this.cntryCdOrigin;
    }
    
    public void setCntryCdOrigin(String cntryCdOrigin) {
        this.cntryCdOrigin = cntryCdOrigin;
    }


    @Column(name="REV_LVL", length=5)
    public String getRevLvl() {
        return this.revLvl;
    }
    
    public void setRevLvl(String revLvl) {
        this.revLvl = revLvl;
    }


    @Column(name="LOT_MANUFACTURE_AFTER_DT", length=7)
    public Date getLotManufactureAfterDt() {
        return this.lotManufactureAfterDt;
    }
    
    public void setLotManufactureAfterDt(Date lotManufactureAfterDt) {
        this.lotManufactureAfterDt = lotManufactureAfterDt;
    }


    @Column(name="LOT_NOT_EXPIRE_BEFORE_DT", length=7)
    public Date getLotNotExpireBeforeDt() {
        return this.lotNotExpireBeforeDt;
    }
    
    public void setLotNotExpireBeforeDt(Date lotNotExpireBeforeDt) {
        this.lotNotExpireBeforeDt = lotNotExpireBeforeDt;
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


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ApsResultDtlDistinctDmdVwId) ) return false;
		 ApsResultDtlDistinctDmdVwId castOther = ( ApsResultDtlDistinctDmdVwId ) other; 
         
		 return (this.getApsResultDtlDmdNbr()==castOther.getApsResultDtlDmdNbr())
 && ( (this.getItemNbrRqst()==castOther.getItemNbrRqst()) || ( this.getItemNbrRqst()!=null && castOther.getItemNbrRqst()!=null && this.getItemNbrRqst().equals(castOther.getItemNbrRqst()) ) )
 && ( (this.getDmdIdentifier()==castOther.getDmdIdentifier()) || ( this.getDmdIdentifier()!=null && castOther.getDmdIdentifier()!=null && this.getDmdIdentifier().equals(castOther.getDmdIdentifier()) ) )
 && ( (this.getOeOrdDtlNbr()==castOther.getOeOrdDtlNbr()) || ( this.getOeOrdDtlNbr()!=null && castOther.getOeOrdDtlNbr()!=null && this.getOeOrdDtlNbr().equals(castOther.getOeOrdDtlNbr()) ) )
 && ( (this.getWoDtlNbr()==castOther.getWoDtlNbr()) || ( this.getWoDtlNbr()!=null && castOther.getWoDtlNbr()!=null && this.getWoDtlNbr().equals(castOther.getWoDtlNbr()) ) )
 && ( (this.getFcFcstNbr()==castOther.getFcFcstNbr()) || ( this.getFcFcstNbr()!=null && castOther.getFcFcstNbr()!=null && this.getFcFcstNbr().equals(castOther.getFcFcstNbr()) ) )
 && ( (this.getFcItemMastNbr()==castOther.getFcItemMastNbr()) || ( this.getFcItemMastNbr()!=null && castOther.getFcItemMastNbr()!=null && this.getFcItemMastNbr().equals(castOther.getFcItemMastNbr()) ) )
 && ( (this.getDmdQty()==castOther.getDmdQty()) || ( this.getDmdQty()!=null && castOther.getDmdQty()!=null && this.getDmdQty().equals(castOther.getDmdQty()) ) )
 && ( (this.getDmdQtyAdj()==castOther.getDmdQtyAdj()) || ( this.getDmdQtyAdj()!=null && castOther.getDmdQtyAdj()!=null && this.getDmdQtyAdj().equals(castOther.getDmdQtyAdj()) ) )
 && ( (this.getAllocQty()==castOther.getAllocQty()) || ( this.getAllocQty()!=null && castOther.getAllocQty()!=null && this.getAllocQty().equals(castOther.getAllocQty()) ) )
 && ( (this.getRqstDt()==castOther.getRqstDt()) || ( this.getRqstDt()!=null && castOther.getRqstDt()!=null && this.getRqstDt().equals(castOther.getRqstDt()) ) )
 && ( (this.getPromDtCurr()==castOther.getPromDtCurr()) || ( this.getPromDtCurr()!=null && castOther.getPromDtCurr()!=null && this.getPromDtCurr().equals(castOther.getPromDtCurr()) ) )
 && ( (this.getRqstDtAllocQty()==castOther.getRqstDtAllocQty()) || ( this.getRqstDtAllocQty()!=null && castOther.getRqstDtAllocQty()!=null && this.getRqstDtAllocQty().equals(castOther.getRqstDtAllocQty()) ) )
 && ( (this.getAvailDt()==castOther.getAvailDt()) || ( this.getAvailDt()!=null && castOther.getAvailDt()!=null && this.getAvailDt().equals(castOther.getAvailDt()) ) )
 && ( (this.getApsSrcRuleSetNbrDmd()==castOther.getApsSrcRuleSetNbrDmd()) || ( this.getApsSrcRuleSetNbrDmd()!=null && castOther.getApsSrcRuleSetNbrDmd()!=null && this.getApsSrcRuleSetNbrDmd().equals(castOther.getApsSrcRuleSetNbrDmd()) ) )
 && ( (this.getOrgNbrCust()==castOther.getOrgNbrCust()) || ( this.getOrgNbrCust()!=null && castOther.getOrgNbrCust()!=null && this.getOrgNbrCust().equals(castOther.getOrgNbrCust()) ) )
 && ( (this.getOrgNbrMfrRqst()==castOther.getOrgNbrMfrRqst()) || ( this.getOrgNbrMfrRqst()!=null && castOther.getOrgNbrMfrRqst()!=null && this.getOrgNbrMfrRqst().equals(castOther.getOrgNbrMfrRqst()) ) )
 && ( (this.getItemCd()==castOther.getItemCd()) || ( this.getItemCd()!=null && castOther.getItemCd()!=null && this.getItemCd().equals(castOther.getItemCd()) ) )
 && ( (this.getItemDescr()==castOther.getItemDescr()) || ( this.getItemDescr()!=null && castOther.getItemDescr()!=null && this.getItemDescr().equals(castOther.getItemDescr()) ) )
 && (this.getIcCategoryNbr()==castOther.getIcCategoryNbr())
 && ( (this.getPoVndSetHdrNbr()==castOther.getPoVndSetHdrNbr()) || ( this.getPoVndSetHdrNbr()!=null && castOther.getPoVndSetHdrNbr()!=null && this.getPoVndSetHdrNbr().equals(castOther.getPoVndSetHdrNbr()) ) )
 && ( (this.getFacilityRqst()==castOther.getFacilityRqst()) || ( this.getFacilityRqst()!=null && castOther.getFacilityRqst()!=null && this.getFacilityRqst().equals(castOther.getFacilityRqst()) ) )
 && ( (this.getOrgCdCust()==castOther.getOrgCdCust()) || ( this.getOrgCdCust()!=null && castOther.getOrgCdCust()!=null && this.getOrgCdCust().equals(castOther.getOrgCdCust()) ) )
 && ( (this.getOrgNmCust()==castOther.getOrgNmCust()) || ( this.getOrgNmCust()!=null && castOther.getOrgNmCust()!=null && this.getOrgNmCust().equals(castOther.getOrgNmCust()) ) )
 && ( (this.getCntryCdOrigin()==castOther.getCntryCdOrigin()) || ( this.getCntryCdOrigin()!=null && castOther.getCntryCdOrigin()!=null && this.getCntryCdOrigin().equals(castOther.getCntryCdOrigin()) ) )
 && ( (this.getRevLvl()==castOther.getRevLvl()) || ( this.getRevLvl()!=null && castOther.getRevLvl()!=null && this.getRevLvl().equals(castOther.getRevLvl()) ) )
 && ( (this.getLotManufactureAfterDt()==castOther.getLotManufactureAfterDt()) || ( this.getLotManufactureAfterDt()!=null && castOther.getLotManufactureAfterDt()!=null && this.getLotManufactureAfterDt().equals(castOther.getLotManufactureAfterDt()) ) )
 && ( (this.getLotNotExpireBeforeDt()==castOther.getLotNotExpireBeforeDt()) || ( this.getLotNotExpireBeforeDt()!=null && castOther.getLotNotExpireBeforeDt()!=null && this.getLotNotExpireBeforeDt().equals(castOther.getLotNotExpireBeforeDt()) ) )
 && ( (this.getOrgCdMfr()==castOther.getOrgCdMfr()) || ( this.getOrgCdMfr()!=null && castOther.getOrgCdMfr()!=null && this.getOrgCdMfr().equals(castOther.getOrgCdMfr()) ) )
 && ( (this.getOrgNmMfr()==castOther.getOrgNmMfr()) || ( this.getOrgNmMfr()!=null && castOther.getOrgNmMfr()!=null && this.getOrgNmMfr().equals(castOther.getOrgNmMfr()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getApsResultDtlDmdNbr();
         result = 37 * result + ( getItemNbrRqst() == null ? 0 : this.getItemNbrRqst().hashCode() );
         result = 37 * result + ( getDmdIdentifier() == null ? 0 : this.getDmdIdentifier().hashCode() );
         result = 37 * result + ( getOeOrdDtlNbr() == null ? 0 : this.getOeOrdDtlNbr().hashCode() );
         result = 37 * result + ( getWoDtlNbr() == null ? 0 : this.getWoDtlNbr().hashCode() );
         result = 37 * result + ( getFcFcstNbr() == null ? 0 : this.getFcFcstNbr().hashCode() );
         result = 37 * result + ( getFcItemMastNbr() == null ? 0 : this.getFcItemMastNbr().hashCode() );
         result = 37 * result + ( getDmdQty() == null ? 0 : this.getDmdQty().hashCode() );
         result = 37 * result + ( getDmdQtyAdj() == null ? 0 : this.getDmdQtyAdj().hashCode() );
         result = 37 * result + ( getAllocQty() == null ? 0 : this.getAllocQty().hashCode() );
         result = 37 * result + ( getRqstDt() == null ? 0 : this.getRqstDt().hashCode() );
         result = 37 * result + ( getPromDtCurr() == null ? 0 : this.getPromDtCurr().hashCode() );
         result = 37 * result + ( getRqstDtAllocQty() == null ? 0 : this.getRqstDtAllocQty().hashCode() );
         result = 37 * result + ( getAvailDt() == null ? 0 : this.getAvailDt().hashCode() );
         result = 37 * result + ( getApsSrcRuleSetNbrDmd() == null ? 0 : this.getApsSrcRuleSetNbrDmd().hashCode() );
         result = 37 * result + ( getOrgNbrCust() == null ? 0 : this.getOrgNbrCust().hashCode() );
         result = 37 * result + ( getOrgNbrMfrRqst() == null ? 0 : this.getOrgNbrMfrRqst().hashCode() );
         result = 37 * result + ( getItemCd() == null ? 0 : this.getItemCd().hashCode() );
         result = 37 * result + ( getItemDescr() == null ? 0 : this.getItemDescr().hashCode() );
         result = 37 * result + this.getIcCategoryNbr();
         result = 37 * result + ( getPoVndSetHdrNbr() == null ? 0 : this.getPoVndSetHdrNbr().hashCode() );
         result = 37 * result + ( getFacilityRqst() == null ? 0 : this.getFacilityRqst().hashCode() );
         result = 37 * result + ( getOrgCdCust() == null ? 0 : this.getOrgCdCust().hashCode() );
         result = 37 * result + ( getOrgNmCust() == null ? 0 : this.getOrgNmCust().hashCode() );
         result = 37 * result + ( getCntryCdOrigin() == null ? 0 : this.getCntryCdOrigin().hashCode() );
         result = 37 * result + ( getRevLvl() == null ? 0 : this.getRevLvl().hashCode() );
         result = 37 * result + ( getLotManufactureAfterDt() == null ? 0 : this.getLotManufactureAfterDt().hashCode() );
         result = 37 * result + ( getLotNotExpireBeforeDt() == null ? 0 : this.getLotNotExpireBeforeDt().hashCode() );
         result = 37 * result + ( getOrgCdMfr() == null ? 0 : this.getOrgCdMfr().hashCode() );
         result = 37 * result + ( getOrgNmMfr() == null ? 0 : this.getOrgNmMfr().hashCode() );
         return result;
   }   


}


