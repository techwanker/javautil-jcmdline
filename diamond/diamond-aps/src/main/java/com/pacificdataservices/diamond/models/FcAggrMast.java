package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * FcAggrMast generated by hbm2java
 */
@Entity
@Table(name="FC_AGGR_MAST"
)
public class FcAggrMast  implements java.io.Serializable {


     private int fcAggrMastNbr;
     private CalCalendar calCalendar;
     private FcstGrp fcstGrp;
     private String fcAggrMastDescr;
     private String fcstTypeId;
     private String fcstAggrTypeId;
     private Short totLeadTime;
     private String storeAltFcstFlg;
     private String fcAggrMastStatId;
     private String trcFileNmAbsolute;
     private Set<FcItemMast> fcItemMasts = new HashSet<FcItemMast>(0);
     private Set<FcFcstAggr> fcFcstAggrs = new HashSet<FcFcstAggr>(0);
     private Set<FcAggrMastAttr> fcAggrMastAttrs = new HashSet<FcAggrMastAttr>(0);

    public FcAggrMast() {
    }

	
    public FcAggrMast(int fcAggrMastNbr, String fcstTypeId, String fcstAggrTypeId, String fcAggrMastStatId) {
        this.fcAggrMastNbr = fcAggrMastNbr;
        this.fcstTypeId = fcstTypeId;
        this.fcstAggrTypeId = fcstAggrTypeId;
        this.fcAggrMastStatId = fcAggrMastStatId;
    }
    public FcAggrMast(int fcAggrMastNbr, CalCalendar calCalendar, FcstGrp fcstGrp, String fcAggrMastDescr, String fcstTypeId, String fcstAggrTypeId, Short totLeadTime, String storeAltFcstFlg, String fcAggrMastStatId, String trcFileNmAbsolute, Set<FcItemMast> fcItemMasts, Set<FcFcstAggr> fcFcstAggrs, Set<FcAggrMastAttr> fcAggrMastAttrs) {
       this.fcAggrMastNbr = fcAggrMastNbr;
       this.calCalendar = calCalendar;
       this.fcstGrp = fcstGrp;
       this.fcAggrMastDescr = fcAggrMastDescr;
       this.fcstTypeId = fcstTypeId;
       this.fcstAggrTypeId = fcstAggrTypeId;
       this.totLeadTime = totLeadTime;
       this.storeAltFcstFlg = storeAltFcstFlg;
       this.fcAggrMastStatId = fcAggrMastStatId;
       this.trcFileNmAbsolute = trcFileNmAbsolute;
       this.fcItemMasts = fcItemMasts;
       this.fcFcstAggrs = fcFcstAggrs;
       this.fcAggrMastAttrs = fcAggrMastAttrs;
    }
   
     @Id 

    
    @Column(name="FC_AGGR_MAST_NBR", unique=true, nullable=false, precision=9, scale=0)
    public int getFcAggrMastNbr() {
        return this.fcAggrMastNbr;
    }
    
    public void setFcAggrMastNbr(int fcAggrMastNbr) {
        this.fcAggrMastNbr = fcAggrMastNbr;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="CALENDAR")
    public CalCalendar getCalCalendar() {
        return this.calCalendar;
    }
    
    public void setCalCalendar(CalCalendar calCalendar) {
        this.calCalendar = calCalendar;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="FCST_GRP")
    public FcstGrp getFcstGrp() {
        return this.fcstGrp;
    }
    
    public void setFcstGrp(FcstGrp fcstGrp) {
        this.fcstGrp = fcstGrp;
    }

    
    @Column(name="FC_AGGR_MAST_DESCR", length=30)
    public String getFcAggrMastDescr() {
        return this.fcAggrMastDescr;
    }
    
    public void setFcAggrMastDescr(String fcAggrMastDescr) {
        this.fcAggrMastDescr = fcAggrMastDescr;
    }

    
    @Column(name="FCST_TYPE_ID", nullable=false, length=1)
    public String getFcstTypeId() {
        return this.fcstTypeId;
    }
    
    public void setFcstTypeId(String fcstTypeId) {
        this.fcstTypeId = fcstTypeId;
    }

    
    @Column(name="FCST_AGGR_TYPE_ID", nullable=false, length=1)
    public String getFcstAggrTypeId() {
        return this.fcstAggrTypeId;
    }
    
    public void setFcstAggrTypeId(String fcstAggrTypeId) {
        this.fcstAggrTypeId = fcstAggrTypeId;
    }

    
    @Column(name="TOT_LEAD_TIME", precision=4, scale=0)
    public Short getTotLeadTime() {
        return this.totLeadTime;
    }
    
    public void setTotLeadTime(Short totLeadTime) {
        this.totLeadTime = totLeadTime;
    }

    
    @Column(name="STORE_ALT_FCST_FLG", length=1)
    public String getStoreAltFcstFlg() {
        return this.storeAltFcstFlg;
    }
    
    public void setStoreAltFcstFlg(String storeAltFcstFlg) {
        this.storeAltFcstFlg = storeAltFcstFlg;
    }

    
    @Column(name="FC_AGGR_MAST_STAT_ID", nullable=false, length=1)
    public String getFcAggrMastStatId() {
        return this.fcAggrMastStatId;
    }
    
    public void setFcAggrMastStatId(String fcAggrMastStatId) {
        this.fcAggrMastStatId = fcAggrMastStatId;
    }

    
    @Column(name="TRC_FILE_NM_ABSOLUTE")
    public String getTrcFileNmAbsolute() {
        return this.trcFileNmAbsolute;
    }
    
    public void setTrcFileNmAbsolute(String trcFileNmAbsolute) {
        this.trcFileNmAbsolute = trcFileNmAbsolute;
    }

//@ManyToMany(fetch=FetchType.LAZY)
//    @JoinTable(name="FC_AGGR_MAST_DTL", , joinColumns = { 
//        @JoinColumn(name="FC_AGGR_MAST_NBR", nullable=false, updatable=false) }, inverseJoinColumns = { 
//        @JoinColumn(name="FC_ITEM_MAST_NBR", nullable=false, updatable=false) })
//    public Set<FcItemMast> getFcItemMasts() {
//        return this.fcItemMasts;
//    }
    
    public void setFcItemMasts(Set<FcItemMast> fcItemMasts) {
        this.fcItemMasts = fcItemMasts;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="fcAggrMast")
    public Set<FcFcstAggr> getFcFcstAggrs() {
        return this.fcFcstAggrs;
    }
    
    public void setFcFcstAggrs(Set<FcFcstAggr> fcFcstAggrs) {
        this.fcFcstAggrs = fcFcstAggrs;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="fcAggrMast")
    public Set<FcAggrMastAttr> getFcAggrMastAttrs() {
        return this.fcAggrMastAttrs;
    }
    
    public void setFcAggrMastAttrs(Set<FcAggrMastAttr> fcAggrMastAttrs) {
        this.fcAggrMastAttrs = fcAggrMastAttrs;
    }




}


