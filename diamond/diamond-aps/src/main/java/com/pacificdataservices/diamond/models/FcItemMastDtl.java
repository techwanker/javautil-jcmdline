package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * FcItemMastDtl generated by hbm2java
 */
@Entity
@Table(name="FC_ITEM_MAST_DTL"
)
public class FcItemMastDtl  implements java.io.Serializable {


     private FcItemMastDtlId id;

    public FcItemMastDtl() {
    }

    public FcItemMastDtl(FcItemMastDtlId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="fcItemMastNbrSrc", column=@Column(name="FC_ITEM_MAST_NBR_SRC", nullable=false, precision=9, scale=0) ), 
        @AttributeOverride(name="fcItemMastNbr", column=@Column(name="FC_ITEM_MAST_NBR", nullable=false, precision=9, scale=0) ) } )
    public FcItemMastDtlId getId() {
        return this.id;
    }
    
    public void setId(FcItemMastDtlId id) {
        this.id = id;
    }




}


