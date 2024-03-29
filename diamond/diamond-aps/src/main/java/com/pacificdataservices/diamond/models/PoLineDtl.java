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
 * PoLineDtl generated by hbm2java
 */
@Entity
@Table(name="PO_LINE_DTL"
)
public class PoLineDtl  implements java.io.Serializable {


     private int poLineDtlNbr;
     private ApsSplySubPool apsSplySubPool;
     private PoLineHdr poLineHdr;
     private NaOrgAddr naOrgAddr;
     private BigDecimal schedQty;
     private BigDecimal recvQty;
     private Date replenRqstShipDt;
     private Date replenEstShipDt;
     private Date replenCurrEstDt;
     private String shipViaCd;
     private int utUserNbr;
     private Date lastModDt;
     private String facility;
     private String cancelCd;
     private Date cancelDt;
     private Integer utUserNbrCancel;
     private BigDecimal schedQtyStkUm;
     private BigDecimal recvQtyStkUm;
     private Date apsAvailDt;
     private String cannotReschedFlg;
     private String buyReasonCd;
     private Set<WhFacilityTransReplen> whFacilityTransReplens = new HashSet<WhFacilityTransReplen>(0);
     private Set<PoResched> poRescheds = new HashSet<PoResched>(0);

    public PoLineDtl() {
    }

	
    public PoLineDtl(int poLineDtlNbr, ApsSplySubPool apsSplySubPool, PoLineHdr poLineHdr, NaOrgAddr naOrgAddr, BigDecimal schedQty, Date replenRqstShipDt, Date replenEstShipDt, Date replenCurrEstDt, String shipViaCd, int utUserNbr, Date lastModDt, String facility, BigDecimal schedQtyStkUm, Date apsAvailDt, String cannotReschedFlg) {
        this.poLineDtlNbr = poLineDtlNbr;
        this.apsSplySubPool = apsSplySubPool;
        this.poLineHdr = poLineHdr;
        this.naOrgAddr = naOrgAddr;
        this.schedQty = schedQty;
        this.replenRqstShipDt = replenRqstShipDt;
        this.replenEstShipDt = replenEstShipDt;
        this.replenCurrEstDt = replenCurrEstDt;
        this.shipViaCd = shipViaCd;
        this.utUserNbr = utUserNbr;
        this.lastModDt = lastModDt;
        this.facility = facility;
        this.schedQtyStkUm = schedQtyStkUm;
        this.apsAvailDt = apsAvailDt;
        this.cannotReschedFlg = cannotReschedFlg;
    }
    public PoLineDtl(int poLineDtlNbr, ApsSplySubPool apsSplySubPool, PoLineHdr poLineHdr, NaOrgAddr naOrgAddr, BigDecimal schedQty, BigDecimal recvQty, Date replenRqstShipDt, Date replenEstShipDt, Date replenCurrEstDt, String shipViaCd, int utUserNbr, Date lastModDt, String facility, String cancelCd, Date cancelDt, Integer utUserNbrCancel, BigDecimal schedQtyStkUm, BigDecimal recvQtyStkUm, Date apsAvailDt, String cannotReschedFlg, String buyReasonCd, Set<WhFacilityTransReplen> whFacilityTransReplens, Set<PoResched> poRescheds) {
       this.poLineDtlNbr = poLineDtlNbr;
       this.apsSplySubPool = apsSplySubPool;
       this.poLineHdr = poLineHdr;
       this.naOrgAddr = naOrgAddr;
       this.schedQty = schedQty;
       this.recvQty = recvQty;
       this.replenRqstShipDt = replenRqstShipDt;
       this.replenEstShipDt = replenEstShipDt;
       this.replenCurrEstDt = replenCurrEstDt;
       this.shipViaCd = shipViaCd;
       this.utUserNbr = utUserNbr;
       this.lastModDt = lastModDt;
       this.facility = facility;
       this.cancelCd = cancelCd;
       this.cancelDt = cancelDt;
       this.utUserNbrCancel = utUserNbrCancel;
       this.schedQtyStkUm = schedQtyStkUm;
       this.recvQtyStkUm = recvQtyStkUm;
       this.apsAvailDt = apsAvailDt;
       this.cannotReschedFlg = cannotReschedFlg;
       this.buyReasonCd = buyReasonCd;
       this.whFacilityTransReplens = whFacilityTransReplens;
       this.poRescheds = poRescheds;
    }
   
     @Id 

    
    @Column(name="PO_LINE_DTL_NBR", unique=true, nullable=false, precision=9, scale=0)
    public int getPoLineDtlNbr() {
        return this.poLineDtlNbr;
    }
    
    public void setPoLineDtlNbr(int poLineDtlNbr) {
        this.poLineDtlNbr = poLineDtlNbr;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="APS_SPLY_SUB_POOL_NBR", nullable=false)
    public ApsSplySubPool getApsSplySubPool() {
        return this.apsSplySubPool;
    }
    
    public void setApsSplySubPool(ApsSplySubPool apsSplySubPool) {
        this.apsSplySubPool = apsSplySubPool;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PO_LINE_HDR_NBR", nullable=false)
    public PoLineHdr getPoLineHdr() {
        return this.poLineHdr;
    }
    
    public void setPoLineHdr(PoLineHdr poLineHdr) {
        this.poLineHdr = poLineHdr;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="SHIP_TO_ADDR_NBR", nullable=false)
    public NaOrgAddr getNaOrgAddr() {
        return this.naOrgAddr;
    }
    
    public void setNaOrgAddr(NaOrgAddr naOrgAddr) {
        this.naOrgAddr = naOrgAddr;
    }

    
    @Column(name="SCHED_QTY", nullable=false, precision=13, scale=5)
    public BigDecimal getSchedQty() {
        return this.schedQty;
    }
    
    public void setSchedQty(BigDecimal schedQty) {
        this.schedQty = schedQty;
    }

    
    @Column(name="RECV_QTY", precision=13, scale=5)
    public BigDecimal getRecvQty() {
        return this.recvQty;
    }
    
    public void setRecvQty(BigDecimal recvQty) {
        this.recvQty = recvQty;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="REPLEN_RQST_SHIP_DT", nullable=false, length=7)
    public Date getReplenRqstShipDt() {
        return this.replenRqstShipDt;
    }
    
    public void setReplenRqstShipDt(Date replenRqstShipDt) {
        this.replenRqstShipDt = replenRqstShipDt;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="REPLEN_EST_SHIP_DT", nullable=false, length=7)
    public Date getReplenEstShipDt() {
        return this.replenEstShipDt;
    }
    
    public void setReplenEstShipDt(Date replenEstShipDt) {
        this.replenEstShipDt = replenEstShipDt;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="REPLEN_CURR_EST_DT", nullable=false, length=7)
    public Date getReplenCurrEstDt() {
        return this.replenCurrEstDt;
    }
    
    public void setReplenCurrEstDt(Date replenCurrEstDt) {
        this.replenCurrEstDt = replenCurrEstDt;
    }

    
    @Column(name="SHIP_VIA_CD", nullable=false, length=8)
    public String getShipViaCd() {
        return this.shipViaCd;
    }
    
    public void setShipViaCd(String shipViaCd) {
        this.shipViaCd = shipViaCd;
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

    
    @Column(name="FACILITY", nullable=false, length=16)
    public String getFacility() {
        return this.facility;
    }
    
    public void setFacility(String facility) {
        this.facility = facility;
    }

    
    @Column(name="CANCEL_CD", length=8)
    public String getCancelCd() {
        return this.cancelCd;
    }
    
    public void setCancelCd(String cancelCd) {
        this.cancelCd = cancelCd;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="CANCEL_DT", length=7)
    public Date getCancelDt() {
        return this.cancelDt;
    }
    
    public void setCancelDt(Date cancelDt) {
        this.cancelDt = cancelDt;
    }

    
    @Column(name="UT_USER_NBR_CANCEL", precision=9, scale=0)
    public Integer getUtUserNbrCancel() {
        return this.utUserNbrCancel;
    }
    
    public void setUtUserNbrCancel(Integer utUserNbrCancel) {
        this.utUserNbrCancel = utUserNbrCancel;
    }

    
    @Column(name="SCHED_QTY_STK_UM", nullable=false, precision=13, scale=5)
    public BigDecimal getSchedQtyStkUm() {
        return this.schedQtyStkUm;
    }
    
    public void setSchedQtyStkUm(BigDecimal schedQtyStkUm) {
        this.schedQtyStkUm = schedQtyStkUm;
    }

    
    @Column(name="RECV_QTY_STK_UM", precision=13, scale=5)
    public BigDecimal getRecvQtyStkUm() {
        return this.recvQtyStkUm;
    }
    
    public void setRecvQtyStkUm(BigDecimal recvQtyStkUm) {
        this.recvQtyStkUm = recvQtyStkUm;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="APS_AVAIL_DT", nullable=false, length=7)
    public Date getApsAvailDt() {
        return this.apsAvailDt;
    }
    
    public void setApsAvailDt(Date apsAvailDt) {
        this.apsAvailDt = apsAvailDt;
    }

    
    @Column(name="CANNOT_RESCHED_FLG", nullable=false, length=1)
    public String getCannotReschedFlg() {
        return this.cannotReschedFlg;
    }
    
    public void setCannotReschedFlg(String cannotReschedFlg) {
        this.cannotReschedFlg = cannotReschedFlg;
    }

    
    @Column(name="BUY_REASON_CD", length=8)
    public String getBuyReasonCd() {
        return this.buyReasonCd;
    }
    
    public void setBuyReasonCd(String buyReasonCd) {
        this.buyReasonCd = buyReasonCd;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="poLineDtl")
    public Set<WhFacilityTransReplen> getWhFacilityTransReplens() {
        return this.whFacilityTransReplens;
    }
    
    public void setWhFacilityTransReplens(Set<WhFacilityTransReplen> whFacilityTransReplens) {
        this.whFacilityTransReplens = whFacilityTransReplens;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="poLineDtl")
    public Set<PoResched> getPoRescheds() {
        return this.poRescheds;
    }
    
    public void setPoRescheds(Set<PoResched> poRescheds) {
        this.poRescheds = poRescheds;
    }




}


