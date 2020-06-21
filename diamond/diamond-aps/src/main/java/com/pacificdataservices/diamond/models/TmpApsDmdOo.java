package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * TmpApsDmdOo generated by hbm2java
 */
@Entity
@Table(name="TMP_APS_DMD_OO"
)
public class TmpApsDmdOo  implements java.io.Serializable {


     private TmpApsDmdOoId id;

    public TmpApsDmdOo() {
    }

    public TmpApsDmdOo(TmpApsDmdOoId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="dmdTypeCd", column=@Column(name="DMD_TYPE_CD", length=2) ), 
        @AttributeOverride(name="dmdCd", column=@Column(name="DMD_CD", length=69) ), 
        @AttributeOverride(name="itemNbrDmd", column=@Column(name="ITEM_NBR_DMD", nullable=false, precision=9, scale=0) ), 
        @AttributeOverride(name="oeOrdDtlNbr", column=@Column(name="OE_ORD_DTL_NBR", nullable=false, precision=9, scale=0) ), 
        @AttributeOverride(name="rqstDt", column=@Column(name="RQST_DT", nullable=false, length=7) ), 
        @AttributeOverride(name="promDtCurr", column=@Column(name="PROM_DT_CURR", nullable=false, length=7) ), 
        @AttributeOverride(name="apsSrcRuleSetNbr", column=@Column(name="APS_SRC_RULE_SET_NBR", nullable=false, precision=9, scale=0) ), 
        @AttributeOverride(name="orgNbrCust", column=@Column(name="ORG_NBR_CUST", nullable=false, precision=9, scale=0) ), 
        @AttributeOverride(name="openQty", column=@Column(name="OPEN_QTY", precision=22, scale=0) ), 
        @AttributeOverride(name="openQtyAdj", column=@Column(name="OPEN_QTY_ADJ", precision=13, scale=5) ), 
        @AttributeOverride(name="orgCdCust", column=@Column(name="ORG_CD_CUST", nullable=false, length=15) ), 
        @AttributeOverride(name="orgNbrMfrRqst", column=@Column(name="ORG_NBR_MFR_RQST", precision=9, scale=0) ), 
        @AttributeOverride(name="orgCdMfr", column=@Column(name="ORG_CD_MFR", length=15) ), 
        @AttributeOverride(name="contractCustFlg", column=@Column(name="CONTRACT_CUST_FLG", length=1) ), 
        @AttributeOverride(name="unitPrice", column=@Column(name="UNIT_PRICE", precision=17, scale=6) ), 
        @AttributeOverride(name="custAllocPrty", column=@Column(name="CUST_ALLOC_PRTY", nullable=false, precision=3, scale=0) ), 
        @AttributeOverride(name="revLvl", column=@Column(name="REV_LVL", length=5) ), 
        @AttributeOverride(name="cntryCdOrigin", column=@Column(name="CNTRY_CD_ORIGIN", length=3) ), 
        @AttributeOverride(name="lotNotExpireBeforeDt", column=@Column(name="LOT_NOT_EXPIRE_BEFORE_DT", length=7) ), 
        @AttributeOverride(name="lotManufactureAfterDt", column=@Column(name="LOT_MANUFACTURE_AFTER_DT", length=7) ), 
        @AttributeOverride(name="fcstGrp", column=@Column(name="FCST_GRP", length=8) ), 
        @AttributeOverride(name="shipFromFacility", column=@Column(name="SHIP_FROM_FACILITY", nullable=false, length=16) ) } )
    public TmpApsDmdOoId getId() {
        return this.id;
    }
    
    public void setId(TmpApsDmdOoId id) {
        this.id = id;
    }




}


