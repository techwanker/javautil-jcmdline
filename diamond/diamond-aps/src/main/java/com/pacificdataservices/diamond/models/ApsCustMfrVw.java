package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * ApsCustMfrVw generated by hbm2java
 */
@Entity
@Table(name="APS_CUST_MFR_VW"
)
public class ApsCustMfrVw  implements java.io.Serializable {


     private ApsCustMfrVwId id;

    public ApsCustMfrVw() {
    }

    public ApsCustMfrVw(ApsCustMfrVwId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="itemNbr", column=@Column(name="ITEM_NBR", nullable=false, precision=9, scale=0) ), 
        @AttributeOverride(name="itemCd", column=@Column(name="ITEM_CD", nullable=false, length=50) ), 
        @AttributeOverride(name="orgNbrCust", column=@Column(name="ORG_NBR_CUST", nullable=false, precision=9, scale=0) ), 
        @AttributeOverride(name="orgCdCust", column=@Column(name="ORG_CD_CUST", nullable=false, length=15) ), 
        @AttributeOverride(name="orgNmCust", column=@Column(name="ORG_NM_CUST", nullable=false, length=60) ), 
        @AttributeOverride(name="orgNbrMfr", column=@Column(name="ORG_NBR_MFR", nullable=false, precision=9, scale=0) ), 
        @AttributeOverride(name="orgCdMfr", column=@Column(name="ORG_CD_MFR", nullable=false, length=15) ), 
        @AttributeOverride(name="orgNmMfr", column=@Column(name="ORG_NM_MFR", nullable=false, length=60) ), 
        @AttributeOverride(name="mfrRestrictId", column=@Column(name="MFR_RESTRICT_ID", nullable=false, length=1) ), 
        @AttributeOverride(name="effDtBeg", column=@Column(name="EFF_DT_BEG", length=7) ), 
        @AttributeOverride(name="effDtEnd", column=@Column(name="EFF_DT_END", length=7) ) } )
    public ApsCustMfrVwId getId() {
        return this.id;
    }
    
    public void setId(ApsCustMfrVwId id) {
        this.id = id;
    }




}


