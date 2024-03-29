package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * ApsResultDtlDistinctDmdVw generated by hbm2java
 */
@Entity
@Table(name="APS_RESULT_DTL_DISTINCT_DMD_VW"
)
public class ApsResultDtlDistinctDmdVw  implements java.io.Serializable {


     private ApsResultDtlDistinctDmdVwId id;

    public ApsResultDtlDistinctDmdVw() {
    }

    public ApsResultDtlDistinctDmdVw(ApsResultDtlDistinctDmdVwId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="apsResultDtlDmdNbr", column=@Column(name="APS_RESULT_DTL_DMD_NBR", nullable=false, precision=9, scale=0) ), 
        @AttributeOverride(name="itemNbrRqst", column=@Column(name="ITEM_NBR_RQST", precision=9, scale=0) ), 
        @AttributeOverride(name="dmdIdentifier", column=@Column(name="DMD_IDENTIFIER", length=20) ), 
        @AttributeOverride(name="oeOrdDtlNbr", column=@Column(name="OE_ORD_DTL_NBR", precision=9, scale=0) ), 
        @AttributeOverride(name="woDtlNbr", column=@Column(name="WO_DTL_NBR", precision=9, scale=0) ), 
        @AttributeOverride(name="fcFcstNbr", column=@Column(name="FC_FCST_NBR", precision=9, scale=0) ), 
        @AttributeOverride(name="fcItemMastNbr", column=@Column(name="FC_ITEM_MAST_NBR", precision=9, scale=0) ), 
        @AttributeOverride(name="dmdQty", column=@Column(name="DMD_QTY", precision=13, scale=5) ), 
        @AttributeOverride(name="dmdQtyAdj", column=@Column(name="DMD_QTY_ADJ", precision=13, scale=5) ), 
        @AttributeOverride(name="allocQty", column=@Column(name="ALLOC_QTY", precision=13, scale=5) ), 
        @AttributeOverride(name="rqstDt", column=@Column(name="RQST_DT", length=7) ), 
        @AttributeOverride(name="promDtCurr", column=@Column(name="PROM_DT_CURR", length=7) ), 
        @AttributeOverride(name="rqstDtAllocQty", column=@Column(name="RQST_DT_ALLOC_QTY", precision=13, scale=5) ), 
        @AttributeOverride(name="availDt", column=@Column(name="AVAIL_DT", length=7) ), 
        @AttributeOverride(name="apsSrcRuleSetNbrDmd", column=@Column(name="APS_SRC_RULE_SET_NBR_DMD", precision=9, scale=0) ), 
        @AttributeOverride(name="orgNbrCust", column=@Column(name="ORG_NBR_CUST", precision=9, scale=0) ), 
        @AttributeOverride(name="orgNbrMfrRqst", column=@Column(name="ORG_NBR_MFR_RQST", precision=9, scale=0) ), 
        @AttributeOverride(name="itemCd", column=@Column(name="ITEM_CD", nullable=false, length=50) ), 
        @AttributeOverride(name="itemDescr", column=@Column(name="ITEM_DESCR", nullable=false, length=50) ), 
        @AttributeOverride(name="icCategoryNbr", column=@Column(name="IC_CATEGORY_NBR", nullable=false, precision=9, scale=0) ), 
        @AttributeOverride(name="poVndSetHdrNbr", column=@Column(name="PO_VND_SET_HDR_NBR", precision=9, scale=0) ), 
        @AttributeOverride(name="facilityRqst", column=@Column(name="FACILITY_RQST", nullable=false, length=16) ), 
        @AttributeOverride(name="orgCdCust", column=@Column(name="ORG_CD_CUST", nullable=false, length=15) ), 
        @AttributeOverride(name="orgNmCust", column=@Column(name="ORG_NM_CUST", nullable=false, length=60) ), 
        @AttributeOverride(name="cntryCdOrigin", column=@Column(name="CNTRY_CD_ORIGIN", length=3) ), 
        @AttributeOverride(name="revLvl", column=@Column(name="REV_LVL", length=5) ), 
        @AttributeOverride(name="lotManufactureAfterDt", column=@Column(name="LOT_MANUFACTURE_AFTER_DT", length=7) ), 
        @AttributeOverride(name="lotNotExpireBeforeDt", column=@Column(name="LOT_NOT_EXPIRE_BEFORE_DT", length=7) ), 
        @AttributeOverride(name="orgCdMfr", column=@Column(name="ORG_CD_MFR", length=15) ), 
        @AttributeOverride(name="orgNmMfr", column=@Column(name="ORG_NM_MFR", length=60) ) } )
    public ApsResultDtlDistinctDmdVwId getId() {
        return this.id;
    }
    
    public void setId(ApsResultDtlDistinctDmdVwId id) {
        this.id = id;
    }




}


