package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * ApsAvailOnhandDtl generated by hbm2java
 */
@Entity
@Table(name="APS_AVAIL_ONHAND_DTL"
)
public class ApsAvailOnhandDtl  implements java.io.Serializable {


     private ApsAvailOnhandDtlId id;

    public ApsAvailOnhandDtl() {
    }

    public ApsAvailOnhandDtl(ApsAvailOnhandDtlId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="facility", column=@Column(name="FACILITY", nullable=false, length=16) ), 
        @AttributeOverride(name="apsSplySubPoolNbr", column=@Column(name="APS_SPLY_SUB_POOL_NBR", nullable=false, precision=9, scale=0) ), 
        @AttributeOverride(name="orgNbrMfr", column=@Column(name="ORG_NBR_MFR", precision=9, scale=0) ), 
        @AttributeOverride(name="orgNbrVnd", column=@Column(name="ORG_NBR_VND", nullable=false, precision=9, scale=0) ), 
        @AttributeOverride(name="lotNbr", column=@Column(name="LOT_NBR", nullable=false, precision=9, scale=0) ), 
        @AttributeOverride(name="lotUm", column=@Column(name="LOT_UM", nullable=false, length=3) ), 
        @AttributeOverride(name="itemNbr", column=@Column(name="ITEM_NBR", nullable=false, precision=9, scale=0) ), 
        @AttributeOverride(name="availDt", column=@Column(name="AVAIL_DT", length=7) ), 
        @AttributeOverride(name="onhandQty", column=@Column(name="ONHAND_QTY", precision=12, scale=5) ), 
        @AttributeOverride(name="revLvl", column=@Column(name="REV_LVL", length=5) ), 
        @AttributeOverride(name="pkSupply", column=@Column(name="PK_SUPPLY", nullable=false, precision=9, scale=0) ), 
        @AttributeOverride(name="splyIdentifier", column=@Column(name="SPLY_IDENTIFIER", length=40) ), 
        @AttributeOverride(name="lotCost", column=@Column(name="LOT_COST", nullable=false, precision=13, scale=6) ), 
        @AttributeOverride(name="cntryCdOrigin", column=@Column(name="CNTRY_CD_ORIGIN", length=3) ), 
        @AttributeOverride(name="mfrDate", column=@Column(name="MFR_DATE", length=7) ), 
        @AttributeOverride(name="expireDt", column=@Column(name="EXPIRE_DT", length=7) ), 
        @AttributeOverride(name="rcptDt", column=@Column(name="RCPT_DT", length=7) ), 
        @AttributeOverride(name="availDtId", column=@Column(name="AVAIL_DT_ID", length=1) ) } )
    public ApsAvailOnhandDtlId getId() {
        return this.id;
    }
    
    public void setId(ApsAvailOnhandDtlId id) {
        this.id = id;
    }




}


