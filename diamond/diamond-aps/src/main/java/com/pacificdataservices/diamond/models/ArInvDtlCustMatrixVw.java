package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * ArInvDtlCustMatrixVw generated by hbm2java
 */
@Entity
@Table(name="AR_INV_DTL_CUST_MATRIX_VW"
)
public class ArInvDtlCustMatrixVw  implements java.io.Serializable {


     private ArInvDtlCustMatrixVwId id;

    public ArInvDtlCustMatrixVw() {
    }

    public ArInvDtlCustMatrixVw(ArInvDtlCustMatrixVwId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="cycle", column=@Column(name="CYCLE", length=4) ), 
        @AttributeOverride(name="itemNbr", column=@Column(name="ITEM_NBR", nullable=false, precision=9, scale=0) ), 
        @AttributeOverride(name="orgNmCust", column=@Column(name="ORG_NM_CUST", nullable=false, length=60) ), 
        @AttributeOverride(name="jan", column=@Column(name="JAN", precision=22, scale=0) ), 
        @AttributeOverride(name="feb", column=@Column(name="FEB", precision=22, scale=0) ), 
        @AttributeOverride(name="mar", column=@Column(name="MAR", precision=22, scale=0) ), 
        @AttributeOverride(name="apr", column=@Column(name="APR", precision=22, scale=0) ), 
        @AttributeOverride(name="may", column=@Column(name="MAY", precision=22, scale=0) ), 
        @AttributeOverride(name="jun", column=@Column(name="JUN", precision=22, scale=0) ), 
        @AttributeOverride(name="jul", column=@Column(name="JUL", precision=22, scale=0) ), 
        @AttributeOverride(name="aug", column=@Column(name="AUG", precision=22, scale=0) ), 
        @AttributeOverride(name="sep", column=@Column(name="SEP", precision=22, scale=0) ), 
        @AttributeOverride(name="oct", column=@Column(name="OCT", precision=22, scale=0) ), 
        @AttributeOverride(name="nov", column=@Column(name="NOV", precision=22, scale=0) ), 
        @AttributeOverride(name="dec", column=@Column(name="DEC", precision=22, scale=0) ), 
        @AttributeOverride(name="tot", column=@Column(name="TOT", precision=22, scale=0) ) } )
    public ArInvDtlCustMatrixVwId getId() {
        return this.id;
    }
    
    public void setId(ArInvDtlCustMatrixVwId id) {
        this.id = id;
    }




}


