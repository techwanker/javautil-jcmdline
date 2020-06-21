package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * ApsSupply generated by hbm2java
 */
@Entity
@Table(name="APS_SUPPLY"
)
public class ApsSupply  implements java.io.Serializable {


     private ApsSupplyId id;

    public ApsSupply() {
    }

    public ApsSupply(ApsSupplyId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="splyIdentifier", column=@Column(name="SPLY_IDENTIFIER", length=108) ), 
        @AttributeOverride(name="availTypeCd", column=@Column(name="AVAIL_TYPE_CD", length=1) ), 
        @AttributeOverride(name="lotNbr", column=@Column(name="LOT_NBR", precision=22, scale=0) ), 
        @AttributeOverride(name="itemNbr", column=@Column(name="ITEM_NBR", precision=9, scale=0) ), 
        @AttributeOverride(name="facility", column=@Column(name="FACILITY", length=16) ), 
        @AttributeOverride(name="apsSplySubPoolNbr", column=@Column(name="APS_SPLY_SUB_POOL_NBR", precision=9, scale=0) ), 
        @AttributeOverride(name="orgNbrMfr", column=@Column(name="ORG_NBR_MFR", precision=22, scale=0) ), 
        @AttributeOverride(name="orgNbrVnd", column=@Column(name="ORG_NBR_VND", precision=22, scale=0) ), 
        @AttributeOverride(name="availDt", column=@Column(name="AVAIL_DT", length=7) ), 
        @AttributeOverride(name="grossAvailQty", column=@Column(name="GROSS_AVAIL_QTY", precision=22, scale=0) ), 
        @AttributeOverride(name="lotUm", column=@Column(name="LOT_UM", length=3) ), 
        @AttributeOverride(name="revLvl", column=@Column(name="REV_LVL", length=5) ), 
        @AttributeOverride(name="pkSupply", column=@Column(name="PK_SUPPLY", precision=9, scale=0) ), 
        @AttributeOverride(name="lotCost", column=@Column(name="LOT_COST", precision=22, scale=0) ), 
        @AttributeOverride(name="cntryCdOrigin", column=@Column(name="CNTRY_CD_ORIGIN", length=3) ), 
        @AttributeOverride(name="mfrDate", column=@Column(name="MFR_DATE", length=7) ), 
        @AttributeOverride(name="expireDt", column=@Column(name="EXPIRE_DT", length=7) ), 
        @AttributeOverride(name="rcptDt", column=@Column(name="RCPT_DT", length=7) ), 
        @AttributeOverride(name="apsAvailDt", column=@Column(name="APS_AVAIL_DT", length=7) ), 
        @AttributeOverride(name="woItemNbr", column=@Column(name="WO_ITEM_NBR", precision=22, scale=0) ), 
        @AttributeOverride(name="availDtId", column=@Column(name="AVAIL_DT_ID", length=1) ), 
        @AttributeOverride(name="poLineHdrNbr", column=@Column(name="PO_LINE_HDR_NBR", precision=22, scale=0) ) } )
    public ApsSupplyId getId() {
        return this.id;
    }
    
    public void setId(ApsSupplyId id) {
        this.id = id;
    }




}


