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
 * PoLineHdr generated by hbm2java
 */
@Entity
@Table(name="PO_LINE_HDR"
)
public class PoLineHdr  implements java.io.Serializable {


     private int poLineHdrNbr;
     private PoMfrMast poMfrMast;
     private PoOrdHdr poOrdHdr;
     private IcUm icUm;
     private IcItemMast icItemMast;
     private short poLineNbr;
     private BigDecimal unitCost;
     private BigDecimal unitCostDenom;
     private String revLvl;
     private String lineStatId;
     private String vndrOrdLineCd;
     private String cntryCdOrigin;
     private int utUserNbr;
     private Date lastModDt;
     private Date enterDt;
     private String itemCdVnd;
     private String cancelCd;
     private Date cancelDt;
     private Integer utUserNbrCancel;
     private Date lotNotExpireBeforeDt;
     private Date lotManufactureAfterDt;
     private BigDecimal replenQty;
     private BigDecimal replenQtyStkUm;
     private BigDecimal unitCostStkUm;
     private BigDecimal unitCostDenomStkUm;
     private String poCloseReasonCd;
     private Date closeTm;
     private Integer utUserNbrClose;
     private Set<PoLineDtl> poLineDtls = new HashSet<PoLineDtl>(0);
     private Set<PoLineHdrCert> poLineHdrCerts = new HashSet<PoLineHdrCert>(0);
     private Set<PoLineMultipleCert> poLineMultipleCerts = new HashSet<PoLineMultipleCert>(0);
     private Set<PoUnplannedRcpt> poUnplannedRcpts = new HashSet<PoUnplannedRcpt>(0);
     private Set<IcLotMast> icLotMasts = new HashSet<IcLotMast>(0);

    public PoLineHdr() {
    }

	
    public PoLineHdr(int poLineHdrNbr, PoOrdHdr poOrdHdr, IcUm icUm, IcItemMast icItemMast, short poLineNbr, BigDecimal unitCost, BigDecimal unitCostDenom, String lineStatId, int utUserNbr, Date lastModDt, Date enterDt, BigDecimal replenQty, BigDecimal replenQtyStkUm, BigDecimal unitCostStkUm) {
        this.poLineHdrNbr = poLineHdrNbr;
        this.poOrdHdr = poOrdHdr;
        this.icUm = icUm;
        this.icItemMast = icItemMast;
        this.poLineNbr = poLineNbr;
        this.unitCost = unitCost;
        this.unitCostDenom = unitCostDenom;
        this.lineStatId = lineStatId;
        this.utUserNbr = utUserNbr;
        this.lastModDt = lastModDt;
        this.enterDt = enterDt;
        this.replenQty = replenQty;
        this.replenQtyStkUm = replenQtyStkUm;
        this.unitCostStkUm = unitCostStkUm;
    }
    public PoLineHdr(int poLineHdrNbr, PoMfrMast poMfrMast, PoOrdHdr poOrdHdr, IcUm icUm, IcItemMast icItemMast, short poLineNbr, BigDecimal unitCost, BigDecimal unitCostDenom, String revLvl, String lineStatId, String vndrOrdLineCd, String cntryCdOrigin, int utUserNbr, Date lastModDt, Date enterDt, String itemCdVnd, String cancelCd, Date cancelDt, Integer utUserNbrCancel, Date lotNotExpireBeforeDt, Date lotManufactureAfterDt, BigDecimal replenQty, BigDecimal replenQtyStkUm, BigDecimal unitCostStkUm, BigDecimal unitCostDenomStkUm, String poCloseReasonCd, Date closeTm, Integer utUserNbrClose, Set<PoLineDtl> poLineDtls, Set<PoLineHdrCert> poLineHdrCerts, Set<PoLineMultipleCert> poLineMultipleCerts, Set<PoUnplannedRcpt> poUnplannedRcpts, Set<IcLotMast> icLotMasts) {
       this.poLineHdrNbr = poLineHdrNbr;
       this.poMfrMast = poMfrMast;
       this.poOrdHdr = poOrdHdr;
       this.icUm = icUm;
       this.icItemMast = icItemMast;
       this.poLineNbr = poLineNbr;
       this.unitCost = unitCost;
       this.unitCostDenom = unitCostDenom;
       this.revLvl = revLvl;
       this.lineStatId = lineStatId;
       this.vndrOrdLineCd = vndrOrdLineCd;
       this.cntryCdOrigin = cntryCdOrigin;
       this.utUserNbr = utUserNbr;
       this.lastModDt = lastModDt;
       this.enterDt = enterDt;
       this.itemCdVnd = itemCdVnd;
       this.cancelCd = cancelCd;
       this.cancelDt = cancelDt;
       this.utUserNbrCancel = utUserNbrCancel;
       this.lotNotExpireBeforeDt = lotNotExpireBeforeDt;
       this.lotManufactureAfterDt = lotManufactureAfterDt;
       this.replenQty = replenQty;
       this.replenQtyStkUm = replenQtyStkUm;
       this.unitCostStkUm = unitCostStkUm;
       this.unitCostDenomStkUm = unitCostDenomStkUm;
       this.poCloseReasonCd = poCloseReasonCd;
       this.closeTm = closeTm;
       this.utUserNbrClose = utUserNbrClose;
       this.poLineDtls = poLineDtls;
       this.poLineHdrCerts = poLineHdrCerts;
       this.poLineMultipleCerts = poLineMultipleCerts;
       this.poUnplannedRcpts = poUnplannedRcpts;
       this.icLotMasts = icLotMasts;
    }
   
     @Id 

    
    @Column(name="PO_LINE_HDR_NBR", unique=true, nullable=false, precision=9, scale=0)
    public int getPoLineHdrNbr() {
        return this.poLineHdrNbr;
    }
    
    public void setPoLineHdrNbr(int poLineHdrNbr) {
        this.poLineHdrNbr = poLineHdrNbr;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ORG_NBR_MFR")
    public PoMfrMast getPoMfrMast() {
        return this.poMfrMast;
    }
    
    public void setPoMfrMast(PoMfrMast poMfrMast) {
        this.poMfrMast = poMfrMast;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PO_ORD_HDR_NBR", nullable=false)
    public PoOrdHdr getPoOrdHdr() {
        return this.poOrdHdr;
    }
    
    public void setPoOrdHdr(PoOrdHdr poOrdHdr) {
        this.poOrdHdr = poOrdHdr;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="REPLEN_UM", nullable=false)
    public IcUm getIcUm() {
        return this.icUm;
    }
    
    public void setIcUm(IcUm icUm) {
        this.icUm = icUm;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ITEM_NBR", nullable=false)
    public IcItemMast getIcItemMast() {
        return this.icItemMast;
    }
    
    public void setIcItemMast(IcItemMast icItemMast) {
        this.icItemMast = icItemMast;
    }

    
    @Column(name="PO_LINE_NBR", nullable=false, precision=3, scale=0)
    public short getPoLineNbr() {
        return this.poLineNbr;
    }
    
    public void setPoLineNbr(short poLineNbr) {
        this.poLineNbr = poLineNbr;
    }

    
    @Column(name="UNIT_COST", nullable=false, precision=13, scale=5)
    public BigDecimal getUnitCost() {
        return this.unitCost;
    }
    
    public void setUnitCost(BigDecimal unitCost) {
        this.unitCost = unitCost;
    }

    
    @Column(name="UNIT_COST_DENOM", nullable=false, precision=13, scale=5)
    public BigDecimal getUnitCostDenom() {
        return this.unitCostDenom;
    }
    
    public void setUnitCostDenom(BigDecimal unitCostDenom) {
        this.unitCostDenom = unitCostDenom;
    }

    
    @Column(name="REV_LVL", length=5)
    public String getRevLvl() {
        return this.revLvl;
    }
    
    public void setRevLvl(String revLvl) {
        this.revLvl = revLvl;
    }

    
    @Column(name="LINE_STAT_ID", nullable=false, length=1)
    public String getLineStatId() {
        return this.lineStatId;
    }
    
    public void setLineStatId(String lineStatId) {
        this.lineStatId = lineStatId;
    }

    
    @Column(name="VNDR_ORD_LINE_CD", length=3)
    public String getVndrOrdLineCd() {
        return this.vndrOrdLineCd;
    }
    
    public void setVndrOrdLineCd(String vndrOrdLineCd) {
        this.vndrOrdLineCd = vndrOrdLineCd;
    }

    
    @Column(name="CNTRY_CD_ORIGIN", length=3)
    public String getCntryCdOrigin() {
        return this.cntryCdOrigin;
    }
    
    public void setCntryCdOrigin(String cntryCdOrigin) {
        this.cntryCdOrigin = cntryCdOrigin;
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

    @Temporal(TemporalType.DATE)
    @Column(name="ENTER_DT", nullable=false, length=7)
    public Date getEnterDt() {
        return this.enterDt;
    }
    
    public void setEnterDt(Date enterDt) {
        this.enterDt = enterDt;
    }

    
    @Column(name="ITEM_CD_VND", length=50)
    public String getItemCdVnd() {
        return this.itemCdVnd;
    }
    
    public void setItemCdVnd(String itemCdVnd) {
        this.itemCdVnd = itemCdVnd;
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

    @Temporal(TemporalType.DATE)
    @Column(name="LOT_NOT_EXPIRE_BEFORE_DT", length=7)
    public Date getLotNotExpireBeforeDt() {
        return this.lotNotExpireBeforeDt;
    }
    
    public void setLotNotExpireBeforeDt(Date lotNotExpireBeforeDt) {
        this.lotNotExpireBeforeDt = lotNotExpireBeforeDt;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="LOT_MANUFACTURE_AFTER_DT", length=7)
    public Date getLotManufactureAfterDt() {
        return this.lotManufactureAfterDt;
    }
    
    public void setLotManufactureAfterDt(Date lotManufactureAfterDt) {
        this.lotManufactureAfterDt = lotManufactureAfterDt;
    }

    
    @Column(name="REPLEN_QTY", nullable=false, precision=13, scale=5)
    public BigDecimal getReplenQty() {
        return this.replenQty;
    }
    
    public void setReplenQty(BigDecimal replenQty) {
        this.replenQty = replenQty;
    }

    
    @Column(name="REPLEN_QTY_STK_UM", nullable=false, precision=13, scale=5)
    public BigDecimal getReplenQtyStkUm() {
        return this.replenQtyStkUm;
    }
    
    public void setReplenQtyStkUm(BigDecimal replenQtyStkUm) {
        this.replenQtyStkUm = replenQtyStkUm;
    }

    
    @Column(name="UNIT_COST_STK_UM", nullable=false, precision=17, scale=6)
    public BigDecimal getUnitCostStkUm() {
        return this.unitCostStkUm;
    }
    
    public void setUnitCostStkUm(BigDecimal unitCostStkUm) {
        this.unitCostStkUm = unitCostStkUm;
    }

    
    @Column(name="UNIT_COST_DENOM_STK_UM", precision=17, scale=6)
    public BigDecimal getUnitCostDenomStkUm() {
        return this.unitCostDenomStkUm;
    }
    
    public void setUnitCostDenomStkUm(BigDecimal unitCostDenomStkUm) {
        this.unitCostDenomStkUm = unitCostDenomStkUm;
    }

    
    @Column(name="PO_CLOSE_REASON_CD", length=8)
    public String getPoCloseReasonCd() {
        return this.poCloseReasonCd;
    }
    
    public void setPoCloseReasonCd(String poCloseReasonCd) {
        this.poCloseReasonCd = poCloseReasonCd;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="CLOSE_TM", length=7)
    public Date getCloseTm() {
        return this.closeTm;
    }
    
    public void setCloseTm(Date closeTm) {
        this.closeTm = closeTm;
    }

    
    @Column(name="UT_USER_NBR_CLOSE", precision=9, scale=0)
    public Integer getUtUserNbrClose() {
        return this.utUserNbrClose;
    }
    
    public void setUtUserNbrClose(Integer utUserNbrClose) {
        this.utUserNbrClose = utUserNbrClose;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="poLineHdr")
    public Set<PoLineDtl> getPoLineDtls() {
        return this.poLineDtls;
    }
    
    public void setPoLineDtls(Set<PoLineDtl> poLineDtls) {
        this.poLineDtls = poLineDtls;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="poLineHdr")
    public Set<PoLineHdrCert> getPoLineHdrCerts() {
        return this.poLineHdrCerts;
    }
    
    public void setPoLineHdrCerts(Set<PoLineHdrCert> poLineHdrCerts) {
        this.poLineHdrCerts = poLineHdrCerts;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="poLineHdr")
    public Set<PoLineMultipleCert> getPoLineMultipleCerts() {
        return this.poLineMultipleCerts;
    }
    
    public void setPoLineMultipleCerts(Set<PoLineMultipleCert> poLineMultipleCerts) {
        this.poLineMultipleCerts = poLineMultipleCerts;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="poLineHdr")
    public Set<PoUnplannedRcpt> getPoUnplannedRcpts() {
        return this.poUnplannedRcpts;
    }
    
    public void setPoUnplannedRcpts(Set<PoUnplannedRcpt> poUnplannedRcpts) {
        this.poUnplannedRcpts = poUnplannedRcpts;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="poLineHdr")
    public Set<IcLotMast> getIcLotMasts() {
        return this.icLotMasts;
    }
    
    public void setIcLotMasts(Set<IcLotMast> icLotMasts) {
        this.icLotMasts = icLotMasts;
    }




}

