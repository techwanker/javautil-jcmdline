package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * IcItemNarr generated by hbm2java
 */
@Entity
@Table(name="IC_ITEM_NARR"
)
public class IcItemNarr  implements java.io.Serializable {


     private int itemNbr;
     private IcItemMast icItemMast;
     private String itemNarr;
     private int utUserNbr;
     private Date lastModDt;

    public IcItemNarr() {
    }

    public IcItemNarr(IcItemMast icItemMast, String itemNarr, int utUserNbr, Date lastModDt) {
       this.icItemMast = icItemMast;
       this.itemNarr = itemNarr;
       this.utUserNbr = utUserNbr;
       this.lastModDt = lastModDt;
    }
   

    @Id    
    @Column(name="ITEM_NBR", unique=true, nullable=false, precision=9, scale=0)
    public int getItemNbr() {
        return this.itemNbr;
    }
    
    public void setItemNbr(int itemNbr) {
        this.itemNbr = itemNbr;
    }

//@OneToOne(fetch=FetchType.LAZY)@PrimaryKeyJoinColumn
    public IcItemMast getIcItemMast() {
        return this.icItemMast;
    }
    
    public void setIcItemMast(IcItemMast icItemMast) {
        this.icItemMast = icItemMast;
    }

    
    @Column(name="ITEM_NARR", nullable=false, length=4000)
    public String getItemNarr() {
        return this.itemNarr;
    }
    
    public void setItemNarr(String itemNarr) {
        this.itemNarr = itemNarr;
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

