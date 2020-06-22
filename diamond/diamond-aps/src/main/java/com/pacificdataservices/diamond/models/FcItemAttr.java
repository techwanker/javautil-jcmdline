package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * FcItemAttr generated by hbm2java
 */
@Entity
@Table(name="FC_ITEM_ATTR"
)
public class FcItemAttr  implements java.io.Serializable {


     private FcItemAttrId id;
     private FcAttr fcAttr;
     private FcItemMast fcItemMast;
     private String attrVal;

    public FcItemAttr() {
    }

    public FcItemAttr(FcItemAttrId id, FcAttr fcAttr, FcItemMast fcItemMast, String attrVal) {
       this.id = id;
       this.fcAttr = fcAttr;
       this.fcItemMast = fcItemMast;
       this.attrVal = attrVal;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="fcItemMastNbr", column=@Column(name="FC_ITEM_MAST_NBR", nullable=false, precision=9, scale=0) ), 
        @AttributeOverride(name="fcAttrNbr", column=@Column(name="FC_ATTR_NBR", nullable=false, precision=9, scale=0) ) } )
    public FcItemAttrId getId() {
        return this.id;
    }
    
    public void setId(FcItemAttrId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="FC_ATTR_NBR", nullable=false, insertable=false, updatable=false)
    public FcAttr getFcAttr() {
        return this.fcAttr;
    }
    
    public void setFcAttr(FcAttr fcAttr) {
        this.fcAttr = fcAttr;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="FC_ITEM_MAST_NBR", nullable=false, insertable=false, updatable=false)
    public FcItemMast getFcItemMast() {
        return this.fcItemMast;
    }
    
    public void setFcItemMast(FcItemMast fcItemMast) {
        this.fcItemMast = fcItemMast;
    }

    
    @Column(name="ATTR_VAL", nullable=false, length=20)
    public String getAttrVal() {
        return this.attrVal;
    }
    
    public void setAttrVal(String attrVal) {
        this.attrVal = attrVal;
    }




}

