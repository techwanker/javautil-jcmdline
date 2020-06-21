package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * IcItemMastUpdQueue generated by hbm2java
 */
@Entity
@Table(name="IC_ITEM_MAST_UPD_QUEUE"
)
public class IcItemMastUpdQueue  implements java.io.Serializable {


     private int itemNbr;
     private UtUser utUser;
     private IcItemMast icItemMast;
     private int leadTmDyNew;

    public IcItemMastUpdQueue() {
    }

    public IcItemMastUpdQueue(UtUser utUser, IcItemMast icItemMast, int leadTmDyNew) {
       this.utUser = utUser;
       this.icItemMast = icItemMast;
       this.leadTmDyNew = leadTmDyNew;
    }
   

    @Id
    @Column(name="ITEM_NBR", unique=true, nullable=false, precision=9, scale=0)
    public int getItemNbr() {
        return this.itemNbr;
    }
    
    public void setItemNbr(int itemNbr) {
        this.itemNbr = itemNbr;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="UT_USER_NBR_UPD", nullable=false)
    public UtUser getUtUser() {
        return this.utUser;
    }
    
    public void setUtUser(UtUser utUser) {
        this.utUser = utUser;
    }

//@OneToOne(fetch=FetchType.LAZY)@PrimaryKeyJoinColumn
    public IcItemMast getIcItemMast() {
        return this.icItemMast;
    }
    
    public void setIcItemMast(IcItemMast icItemMast) {
        this.icItemMast = icItemMast;
    }

    
    @Column(name="LEAD_TM_DY_NEW", nullable=false, precision=5, scale=0)
    public int getLeadTmDyNew() {
        return this.leadTmDyNew;
    }
    
    public void setLeadTmDyNew(int leadTmDyNew) {
        this.leadTmDyNew = leadTmDyNew;
    }




}


