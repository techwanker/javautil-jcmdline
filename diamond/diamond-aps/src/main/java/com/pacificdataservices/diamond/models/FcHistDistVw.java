package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * FcHistDistVw generated by hbm2java
 */
@Entity
@Table(name="FC_HIST_DIST_VW"
)
public class FcHistDistVw  implements java.io.Serializable {


     private FcHistDistVwId id;

    public FcHistDistVw() {
    }

    public FcHistDistVw(FcHistDistVwId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="fcItemMastNbr", column=@Column(name="FC_ITEM_MAST_NBR") ), 
        @AttributeOverride(name="itemNbr", column=@Column(name="ITEM_NBR") ), 
        @AttributeOverride(name="itemCd", column=@Column(name="ITEM_CD") ), 
        @AttributeOverride(name="hist", column=@Column(name="HIST") ), 
        @AttributeOverride(name="pctDistHist", column=@Column(name="PCT_DIST_HIST") ) } )
    public FcHistDistVwId getId() {
        return this.id;
    }
    
    public void setId(FcHistDistVwId id) {
        this.id = id;
    }




}

