package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * IcItemAttr generated by hbm2java
 */
@Entity
@Table(name="IC_ITEM_ATTR"
)
public class IcItemAttr  implements java.io.Serializable {


     private IcItemAttrId id;
     private IcAttr icAttr;
     private IcItemMast icItemMast;
     private String attrVal;
     private int utUserNbr;
     private Date lastModDt;

    public IcItemAttr() {
    }

    public IcItemAttr(IcItemAttrId id, IcAttr icAttr, IcItemMast icItemMast, String attrVal, int utUserNbr, Date lastModDt) {
       this.id = id;
       this.icAttr = icAttr;
       this.icItemMast = icItemMast;
       this.attrVal = attrVal;
       this.utUserNbr = utUserNbr;
       this.lastModDt = lastModDt;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="itemNbr", column=@Column(name="ITEM_NBR", nullable=false, precision=9, scale=0) ), 
        @AttributeOverride(name="icAttrNbr", column=@Column(name="IC_ATTR_NBR", nullable=false, precision=9, scale=0) ) } )
    public IcItemAttrId getId() {
        return this.id;
    }
    
    public void setId(IcItemAttrId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="IC_ATTR_NBR", nullable=false, insertable=false, updatable=false)
    public IcAttr getIcAttr() {
        return this.icAttr;
    }
    
    public void setIcAttr(IcAttr icAttr) {
        this.icAttr = icAttr;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ITEM_NBR", nullable=false, insertable=false, updatable=false)
    public IcItemMast getIcItemMast() {
        return this.icItemMast;
    }
    
    public void setIcItemMast(IcItemMast icItemMast) {
        this.icItemMast = icItemMast;
    }

    
    @Column(name="ATTR_VAL", nullable=false, length=20)
    public String getAttrVal() {
        return this.attrVal;
    }
    
    public void setAttrVal(String attrVal) {
        this.attrVal = attrVal;
    }

    
    @Column(name="UT_USER_NBR", nullable=false, precision=9, scale=0)
    public int getUtUserNbr() {
        return this.utUserNbr;
    }
    
    public void setUtUserNbr(int utUserNbr) {
        this.utUserNbr = utUserNbr;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="LAST_MOD_DT", nullable=false, length=7)
    public Date getLastModDt() {
        return this.lastModDt;
    }
    
    public void setLastModDt(Date lastModDt) {
        this.lastModDt = lastModDt;
    }




}


