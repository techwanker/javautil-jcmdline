package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * WhFacilityTransReplen generated by hbm2java
 */
@Entity
@Table(name="WH_FACILITY_TRANS_REPLEN"
)
public class WhFacilityTransReplen  implements java.io.Serializable {


     private int whFacilityTransReplenNbr;
     private ApsSplySubPool apsSplySubPool;
     private PoLineDtl poLineDtl;
     private String rqstStatId;
     private String facilityDest;
     private BigDecimal qtyRqst;
     private Date rqstDt;
     private int utUserNbrRqst;
     private Integer utUserNbrConfirm;
     private int utUserNbr;
     private Date lastModDt;
     private Set<ApsAllocReplenFc> apsAllocReplenFcs = new HashSet<ApsAllocReplenFc>(0);
     private Set<ApsAllocReplenSs> apsAllocReplenSses = new HashSet<ApsAllocReplenSs>(0);
     private Set<ApsAllocReplenWo> apsAllocReplenWos = new HashSet<ApsAllocReplenWo>(0);
     private Set<ApsAllocReplenOo> apsAllocReplenOos = new HashSet<ApsAllocReplenOo>(0);

    public WhFacilityTransReplen() {
    }

	
    public WhFacilityTransReplen(int whFacilityTransReplenNbr, ApsSplySubPool apsSplySubPool, PoLineDtl poLineDtl, String rqstStatId, String facilityDest, BigDecimal qtyRqst, Date rqstDt, int utUserNbrRqst, int utUserNbr, Date lastModDt) {
        this.whFacilityTransReplenNbr = whFacilityTransReplenNbr;
        this.apsSplySubPool = apsSplySubPool;
        this.poLineDtl = poLineDtl;
        this.rqstStatId = rqstStatId;
        this.facilityDest = facilityDest;
        this.qtyRqst = qtyRqst;
        this.rqstDt = rqstDt;
        this.utUserNbrRqst = utUserNbrRqst;
        this.utUserNbr = utUserNbr;
        this.lastModDt = lastModDt;
    }
    public WhFacilityTransReplen(int whFacilityTransReplenNbr, ApsSplySubPool apsSplySubPool, PoLineDtl poLineDtl, String rqstStatId, String facilityDest, BigDecimal qtyRqst, Date rqstDt, int utUserNbrRqst, Integer utUserNbrConfirm, int utUserNbr, Date lastModDt, Set<ApsAllocReplenFc> apsAllocReplenFcs, Set<ApsAllocReplenSs> apsAllocReplenSses, Set<ApsAllocReplenWo> apsAllocReplenWos, Set<ApsAllocReplenOo> apsAllocReplenOos) {
       this.whFacilityTransReplenNbr = whFacilityTransReplenNbr;
       this.apsSplySubPool = apsSplySubPool;
       this.poLineDtl = poLineDtl;
       this.rqstStatId = rqstStatId;
       this.facilityDest = facilityDest;
       this.qtyRqst = qtyRqst;
       this.rqstDt = rqstDt;
       this.utUserNbrRqst = utUserNbrRqst;
       this.utUserNbrConfirm = utUserNbrConfirm;
       this.utUserNbr = utUserNbr;
       this.lastModDt = lastModDt;
       this.apsAllocReplenFcs = apsAllocReplenFcs;
       this.apsAllocReplenSses = apsAllocReplenSses;
       this.apsAllocReplenWos = apsAllocReplenWos;
       this.apsAllocReplenOos = apsAllocReplenOos;
    }
   
     @Id 

    
    @Column(name="WH_FACILITY_TRANS_REPLEN_NBR", unique=true, nullable=false, precision=9, scale=0)
    public int getWhFacilityTransReplenNbr() {
        return this.whFacilityTransReplenNbr;
    }
    
    public void setWhFacilityTransReplenNbr(int whFacilityTransReplenNbr) {
        this.whFacilityTransReplenNbr = whFacilityTransReplenNbr;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="APS_SPLY_SUB_POOL_NBR_DEST", nullable=false)
    public ApsSplySubPool getApsSplySubPool() {
        return this.apsSplySubPool;
    }
    
    public void setApsSplySubPool(ApsSplySubPool apsSplySubPool) {
        this.apsSplySubPool = apsSplySubPool;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PO_LINE_DTL_NBR", nullable=false)
    public PoLineDtl getPoLineDtl() {
        return this.poLineDtl;
    }
    
    public void setPoLineDtl(PoLineDtl poLineDtl) {
        this.poLineDtl = poLineDtl;
    }

    
    @Column(name="RQST_STAT_ID", nullable=false, length=1)
    public String getRqstStatId() {
        return this.rqstStatId;
    }
    
    public void setRqstStatId(String rqstStatId) {
        this.rqstStatId = rqstStatId;
    }

    
    @Column(name="FACILITY_DEST", nullable=false, length=16)
    public String getFacilityDest() {
        return this.facilityDest;
    }
    
    public void setFacilityDest(String facilityDest) {
        this.facilityDest = facilityDest;
    }

    
    @Column(name="QTY_RQST", nullable=false, precision=13, scale=5)
    public BigDecimal getQtyRqst() {
        return this.qtyRqst;
    }
    
    public void setQtyRqst(BigDecimal qtyRqst) {
        this.qtyRqst = qtyRqst;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="RQST_DT", nullable=false, length=7)
    public Date getRqstDt() {
        return this.rqstDt;
    }
    
    public void setRqstDt(Date rqstDt) {
        this.rqstDt = rqstDt;
    }

    
    @Column(name="UT_USER_NBR_RQST", nullable=false, precision=9, scale=0)
    public int getUtUserNbrRqst() {
        return this.utUserNbrRqst;
    }
    
    public void setUtUserNbrRqst(int utUserNbrRqst) {
        this.utUserNbrRqst = utUserNbrRqst;
    }

    
    @Column(name="UT_USER_NBR_CONFIRM", precision=9, scale=0)
    public Integer getUtUserNbrConfirm() {
        return this.utUserNbrConfirm;
    }
    
    public void setUtUserNbrConfirm(Integer utUserNbrConfirm) {
        this.utUserNbrConfirm = utUserNbrConfirm;
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

@OneToMany(fetch=FetchType.LAZY, mappedBy="whFacilityTransReplen")
    public Set<ApsAllocReplenFc> getApsAllocReplenFcs() {
        return this.apsAllocReplenFcs;
    }
    
    public void setApsAllocReplenFcs(Set<ApsAllocReplenFc> apsAllocReplenFcs) {
        this.apsAllocReplenFcs = apsAllocReplenFcs;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="whFacilityTransReplen")
    public Set<ApsAllocReplenSs> getApsAllocReplenSses() {
        return this.apsAllocReplenSses;
    }
    
    public void setApsAllocReplenSses(Set<ApsAllocReplenSs> apsAllocReplenSses) {
        this.apsAllocReplenSses = apsAllocReplenSses;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="whFacilityTransReplen")
    public Set<ApsAllocReplenWo> getApsAllocReplenWos() {
        return this.apsAllocReplenWos;
    }
    
    public void setApsAllocReplenWos(Set<ApsAllocReplenWo> apsAllocReplenWos) {
        this.apsAllocReplenWos = apsAllocReplenWos;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="whFacilityTransReplen")
    public Set<ApsAllocReplenOo> getApsAllocReplenOos() {
        return this.apsAllocReplenOos;
    }
    
    public void setApsAllocReplenOos(Set<ApsAllocReplenOo> apsAllocReplenOos) {
        this.apsAllocReplenOos = apsAllocReplenOos;
    }




}

