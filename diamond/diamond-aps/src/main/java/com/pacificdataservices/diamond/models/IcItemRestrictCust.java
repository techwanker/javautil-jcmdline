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
 * IcItemRestrictCust generated by hbm2java
 */
@Entity
@Table(name="IC_ITEM_RESTRICT_CUST"
)
public class IcItemRestrictCust  implements java.io.Serializable {


     private IcItemRestrictCustId id;
     private OeCustMast oeCustMast;
     private IcItemMast icItemMast;
     private int utUserNbr;
     private Date lastModDt;

    public IcItemRestrictCust() {
    }

    public IcItemRestrictCust(IcItemRestrictCustId id, OeCustMast oeCustMast, IcItemMast icItemMast, int utUserNbr, Date lastModDt) {
       this.id = id;
       this.oeCustMast = oeCustMast;
       this.icItemMast = icItemMast;
       this.utUserNbr = utUserNbr;
       this.lastModDt = lastModDt;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="itemNbr", column=@Column(name="ITEM_NBR", nullable=false, precision=9, scale=0) ), 
        @AttributeOverride(name="orgNbrCust", column=@Column(name="ORG_NBR_CUST", nullable=false, precision=9, scale=0) ) } )
    public IcItemRestrictCustId getId() {
        return this.id;
    }
    
    public void setId(IcItemRestrictCustId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ORG_NBR_CUST", nullable=false, insertable=false, updatable=false)
    public OeCustMast getOeCustMast() {
        return this.oeCustMast;
    }
    
    public void setOeCustMast(OeCustMast oeCustMast) {
        this.oeCustMast = oeCustMast;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ITEM_NBR", nullable=false, insertable=false, updatable=false)
    public IcItemMast getIcItemMast() {
        return this.icItemMast;
    }
    
    public void setIcItemMast(IcItemMast icItemMast) {
        this.icItemMast = icItemMast;
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

