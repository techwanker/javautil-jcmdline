package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * FcHistDist generated by hbm2java
 */
@Entity
@Table(name="FC_HIST_DIST"
)
public class FcHistDist  implements java.io.Serializable {


     private FcHistDistId id;

    public FcHistDist() {
    }

    public FcHistDist(FcHistDistId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="fcItemMastNbr", column=@Column(name="FC_ITEM_MAST_NBR", unique=true, nullable=false, precision=9, scale=0) ), 
        @AttributeOverride(name="itemNbr", column=@Column(name="ITEM_NBR", precision=9, scale=0) ), 
        @AttributeOverride(name="itemCd", column=@Column(name="ITEM_CD", length=50) ), 
        @AttributeOverride(name="hist", column=@Column(name="HIST", precision=22, scale=0) ), 
        @AttributeOverride(name="pctDistHist", column=@Column(name="PCT_DIST_HIST", precision=22, scale=0) ) } )
    public FcHistDistId getId() {
        return this.id;
    }
    
    public void setId(FcHistDistId id) {
        this.id = id;
    }




}

