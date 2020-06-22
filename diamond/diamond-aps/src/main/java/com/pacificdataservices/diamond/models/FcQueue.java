package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * FcQueue generated by hbm2java
 */
@Entity
@Table(name="FC_QUEUE"
)
public class FcQueue  implements java.io.Serializable {


     private int fcItemMastNbr;
     private FcItemMast fcItemMast;
     private String rqstStatId;

    public FcQueue() {
    }

    public FcQueue(FcItemMast fcItemMast, String rqstStatId) {
       this.fcItemMast = fcItemMast;
       this.rqstStatId = rqstStatId;
    }
   

    @Id
    @Column(name="FC_ITEM_MAST_NBR", unique=true, nullable=false, precision=9, scale=0)
    public int getFcItemMastNbr() {
        return this.fcItemMastNbr;
    }
    
    public void setFcItemMastNbr(int fcItemMastNbr) {
        this.fcItemMastNbr = fcItemMastNbr;
    }

//@OneToOne(fetch=FetchType.LAZY)@PrimaryKeyJoinColumn
    public FcItemMast getFcItemMast() {
        return this.fcItemMast;
    }
    
    public void setFcItemMast(FcItemMast fcItemMast) {
        this.fcItemMast = fcItemMast;
    }

    
    @Column(name="RQST_STAT_ID", nullable=false, length=1)
    public String getRqstStatId() {
        return this.rqstStatId;
    }
    
    public void setRqstStatId(String rqstStatId) {
        this.rqstStatId = rqstStatId;
    }




}

