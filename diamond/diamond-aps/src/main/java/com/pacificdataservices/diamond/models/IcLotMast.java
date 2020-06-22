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
 * IcLotMast generated by hbm2java
 */
@Entity
@Table(name="IC_LOT_MAST"
)
public class IcLotMast  implements java.io.Serializable {


     private int lotNbr;
     private PoLineHdr poLineHdr;
     private PoMfrMast poMfrMast;
     private PoOrdHdr poOrdHdr;
     private PoVndMast poVndMast;
     private IcLotMast icLotMast;
     private IcUm icUm;
     private Currency currency;
     private IcItemMast icItemMast;
     private String revLvl;
     private String mfrLotCd;
     private Date rcptDt;
     private BigDecimal lotCost;
     private BigDecimal lotCostDenom;
     private String lotCostCurrCdDenom;
     private String lotStatId;
     private Date mfrDate;
     private String lotCreComm;
     private BigDecimal recvQty;
     private BigDecimal inspectQty;
     private Integer utUserNbrInspect;
     private BigDecimal acceptQty;
     private Date inspectDt;
     private BigDecimal rejQty;
     private String trdFlg;
     private int utUserNbr;
     private Date lastModDt;
     private String itemCdVnd;
     private String cntryCdOrigin;
     private Date expireDt;
     private Integer boxQty;
     private String qtyOnHandFlg;
     private String rejectCd;
     private BigDecimal lotCostLandedOrig;
     private BigDecimal lotCostLandedDenomOrig;
     private BigDecimal lotCostLandedCurr;
     private BigDecimal lotCostLandedDenomCurr;
     private String processedForApFlg;
     private String lotCd;
     private Integer woHdrNbr;
     private Integer woReleaseNbr;
     private Integer utUserNbrRecv;
     private Set<IcMultipleCert> icMultipleCerts = new HashSet<IcMultipleCert>(0);
     private Set<WhFacilityTransOnhand> whFacilityTransOnhands = new HashSet<WhFacilityTransOnhand>(0);
     private Set<ArInvDtl> arInvDtls = new HashSet<ArInvDtl>(0);
     private Set<IcLotMastCert> icLotMastCerts = new HashSet<IcLotMastCert>(0);
     private Set<PoUnplannedRcpt> poUnplannedRcpts = new HashSet<PoUnplannedRcpt>(0);
     private Set<ArRmaRcpt> arRmaRcpts = new HashSet<ArRmaRcpt>(0);
     private Set<IcItemLoc> icItemLocs = new HashSet<IcItemLoc>(0);
     private Set<IcLotMast> icLotMasts = new HashSet<IcLotMast>(0);
     private Set<PosDtl> posDtls = new HashSet<PosDtl>(0);

    public IcLotMast() {
    }

	
    public IcLotMast(int lotNbr, PoVndMast poVndMast, IcLotMast icLotMast, IcUm icUm, IcItemMast icItemMast, BigDecimal lotCost, String lotStatId, BigDecimal recvQty, String trdFlg, int utUserNbr, Date lastModDt, String qtyOnHandFlg, String processedForApFlg) {
        this.lotNbr = lotNbr;
        this.poVndMast = poVndMast;
        this.icLotMast = icLotMast;
        this.icUm = icUm;
        this.icItemMast = icItemMast;
        this.lotCost = lotCost;
        this.lotStatId = lotStatId;
        this.recvQty = recvQty;
        this.trdFlg = trdFlg;
        this.utUserNbr = utUserNbr;
        this.lastModDt = lastModDt;
        this.qtyOnHandFlg = qtyOnHandFlg;
        this.processedForApFlg = processedForApFlg;
    }
    public IcLotMast(int lotNbr, PoLineHdr poLineHdr, PoMfrMast poMfrMast, PoOrdHdr poOrdHdr, PoVndMast poVndMast, IcLotMast icLotMast, IcUm icUm, Currency currency, IcItemMast icItemMast, String revLvl, String mfrLotCd, Date rcptDt, BigDecimal lotCost, BigDecimal lotCostDenom, String lotCostCurrCdDenom, String lotStatId, Date mfrDate, String lotCreComm, BigDecimal recvQty, BigDecimal inspectQty, Integer utUserNbrInspect, BigDecimal acceptQty, Date inspectDt, BigDecimal rejQty, String trdFlg, int utUserNbr, Date lastModDt, String itemCdVnd, String cntryCdOrigin, Date expireDt, Integer boxQty, String qtyOnHandFlg, String rejectCd, BigDecimal lotCostLandedOrig, BigDecimal lotCostLandedDenomOrig, BigDecimal lotCostLandedCurr, BigDecimal lotCostLandedDenomCurr, String processedForApFlg, String lotCd, Integer woHdrNbr, Integer woReleaseNbr, Integer utUserNbrRecv, Set<IcMultipleCert> icMultipleCerts, Set<WhFacilityTransOnhand> whFacilityTransOnhands, Set<ArInvDtl> arInvDtls, Set<IcLotMastCert> icLotMastCerts, Set<PoUnplannedRcpt> poUnplannedRcpts, Set<ArRmaRcpt> arRmaRcpts, Set<IcItemLoc> icItemLocs, Set<IcLotMast> icLotMasts, Set<PosDtl> posDtls) {
       this.lotNbr = lotNbr;
       this.poLineHdr = poLineHdr;
       this.poMfrMast = poMfrMast;
       this.poOrdHdr = poOrdHdr;
       this.poVndMast = poVndMast;
       this.icLotMast = icLotMast;
       this.icUm = icUm;
       this.currency = currency;
       this.icItemMast = icItemMast;
       this.revLvl = revLvl;
       this.mfrLotCd = mfrLotCd;
       this.rcptDt = rcptDt;
       this.lotCost = lotCost;
       this.lotCostDenom = lotCostDenom;
       this.lotCostCurrCdDenom = lotCostCurrCdDenom;
       this.lotStatId = lotStatId;
       this.mfrDate = mfrDate;
       this.lotCreComm = lotCreComm;
       this.recvQty = recvQty;
       this.inspectQty = inspectQty;
       this.utUserNbrInspect = utUserNbrInspect;
       this.acceptQty = acceptQty;
       this.inspectDt = inspectDt;
       this.rejQty = rejQty;
       this.trdFlg = trdFlg;
       this.utUserNbr = utUserNbr;
       this.lastModDt = lastModDt;
       this.itemCdVnd = itemCdVnd;
       this.cntryCdOrigin = cntryCdOrigin;
       this.expireDt = expireDt;
       this.boxQty = boxQty;
       this.qtyOnHandFlg = qtyOnHandFlg;
       this.rejectCd = rejectCd;
       this.lotCostLandedOrig = lotCostLandedOrig;
       this.lotCostLandedDenomOrig = lotCostLandedDenomOrig;
       this.lotCostLandedCurr = lotCostLandedCurr;
       this.lotCostLandedDenomCurr = lotCostLandedDenomCurr;
       this.processedForApFlg = processedForApFlg;
       this.lotCd = lotCd;
       this.woHdrNbr = woHdrNbr;
       this.woReleaseNbr = woReleaseNbr;
       this.utUserNbrRecv = utUserNbrRecv;
       this.icMultipleCerts = icMultipleCerts;
       this.whFacilityTransOnhands = whFacilityTransOnhands;
       this.arInvDtls = arInvDtls;
       this.icLotMastCerts = icLotMastCerts;
       this.poUnplannedRcpts = poUnplannedRcpts;
       this.arRmaRcpts = arRmaRcpts;
       this.icItemLocs = icItemLocs;
       this.icLotMasts = icLotMasts;
       this.posDtls = posDtls;
    }
   
     @Id 

    
    @Column(name="LOT_NBR", unique=true, nullable=false, precision=9, scale=0)
    public int getLotNbr() {
        return this.lotNbr;
    }
    
    public void setLotNbr(int lotNbr) {
        this.lotNbr = lotNbr;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PO_LINE_HDR_NBR")
    public PoLineHdr getPoLineHdr() {
        return this.poLineHdr;
    }
    
    public void setPoLineHdr(PoLineHdr poLineHdr) {
        this.poLineHdr = poLineHdr;
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
    @JoinColumn(name="PO_ORD_HDR_NBR")
    public PoOrdHdr getPoOrdHdr() {
        return this.poOrdHdr;
    }
    
    public void setPoOrdHdr(PoOrdHdr poOrdHdr) {
        this.poOrdHdr = poOrdHdr;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ORG_NBR_VND", nullable=false)
    public PoVndMast getPoVndMast() {
        return this.poVndMast;
    }
    
    public void setPoVndMast(PoVndMast poVndMast) {
        this.poVndMast = poVndMast;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="LOT_NBR_ORIG", nullable=false)
    public IcLotMast getIcLotMast() {
        return this.icLotMast;
    }
    
    public void setIcLotMast(IcLotMast icLotMast) {
        this.icLotMast = icLotMast;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="LOT_COST_UM", nullable=false)
    public IcUm getIcUm() {
        return this.icUm;
    }
    
    public void setIcUm(IcUm icUm) {
        this.icUm = icUm;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="LOT_COST_CURR_CD")
    public Currency getCurrency() {
        return this.currency;
    }
    
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ITEM_NBR", nullable=false)
    public IcItemMast getIcItemMast() {
        return this.icItemMast;
    }
    
    public void setIcItemMast(IcItemMast icItemMast) {
        this.icItemMast = icItemMast;
    }

    
    @Column(name="REV_LVL", length=5)
    public String getRevLvl() {
        return this.revLvl;
    }
    
    public void setRevLvl(String revLvl) {
        this.revLvl = revLvl;
    }

    
    @Column(name="MFR_LOT_CD", length=20)
    public String getMfrLotCd() {
        return this.mfrLotCd;
    }
    
    public void setMfrLotCd(String mfrLotCd) {
        this.mfrLotCd = mfrLotCd;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="RCPT_DT", length=7)
    public Date getRcptDt() {
        return this.rcptDt;
    }
    
    public void setRcptDt(Date rcptDt) {
        this.rcptDt = rcptDt;
    }

    
    @Column(name="LOT_COST", nullable=false, precision=13, scale=6)
    public BigDecimal getLotCost() {
        return this.lotCost;
    }
    
    public void setLotCost(BigDecimal lotCost) {
        this.lotCost = lotCost;
    }

    
    @Column(name="LOT_COST_DENOM", precision=13, scale=6)
    public BigDecimal getLotCostDenom() {
        return this.lotCostDenom;
    }
    
    public void setLotCostDenom(BigDecimal lotCostDenom) {
        this.lotCostDenom = lotCostDenom;
    }

    
    @Column(name="LOT_COST_CURR_CD_DENOM", length=3)
    public String getLotCostCurrCdDenom() {
        return this.lotCostCurrCdDenom;
    }
    
    public void setLotCostCurrCdDenom(String lotCostCurrCdDenom) {
        this.lotCostCurrCdDenom = lotCostCurrCdDenom;
    }

    
    @Column(name="LOT_STAT_ID", nullable=false, length=1)
    public String getLotStatId() {
        return this.lotStatId;
    }
    
    public void setLotStatId(String lotStatId) {
        this.lotStatId = lotStatId;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="MFR_DATE", length=7)
    public Date getMfrDate() {
        return this.mfrDate;
    }
    
    public void setMfrDate(Date mfrDate) {
        this.mfrDate = mfrDate;
    }

    
    @Column(name="LOT_CRE_COMM", length=200)
    public String getLotCreComm() {
        return this.lotCreComm;
    }
    
    public void setLotCreComm(String lotCreComm) {
        this.lotCreComm = lotCreComm;
    }

    
    @Column(name="RECV_QTY", nullable=false, precision=22, scale=0)
    public BigDecimal getRecvQty() {
        return this.recvQty;
    }
    
    public void setRecvQty(BigDecimal recvQty) {
        this.recvQty = recvQty;
    }

    
    @Column(name="INSPECT_QTY", precision=10)
    public BigDecimal getInspectQty() {
        return this.inspectQty;
    }
    
    public void setInspectQty(BigDecimal inspectQty) {
        this.inspectQty = inspectQty;
    }

    
    @Column(name="UT_USER_NBR_INSPECT", precision=9, scale=0)
    public Integer getUtUserNbrInspect() {
        return this.utUserNbrInspect;
    }
    
    public void setUtUserNbrInspect(Integer utUserNbrInspect) {
        this.utUserNbrInspect = utUserNbrInspect;
    }

    
    @Column(name="ACCEPT_QTY", precision=22, scale=0)
    public BigDecimal getAcceptQty() {
        return this.acceptQty;
    }
    
    public void setAcceptQty(BigDecimal acceptQty) {
        this.acceptQty = acceptQty;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="INSPECT_DT", length=7)
    public Date getInspectDt() {
        return this.inspectDt;
    }
    
    public void setInspectDt(Date inspectDt) {
        this.inspectDt = inspectDt;
    }

    
    @Column(name="REJ_QTY", precision=10)
    public BigDecimal getRejQty() {
        return this.rejQty;
    }
    
    public void setRejQty(BigDecimal rejQty) {
        this.rejQty = rejQty;
    }

    
    @Column(name="TRD_FLG", nullable=false, length=1)
    public String getTrdFlg() {
        return this.trdFlg;
    }
    
    public void setTrdFlg(String trdFlg) {
        this.trdFlg = trdFlg;
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

    
    @Column(name="ITEM_CD_VND", length=50)
    public String getItemCdVnd() {
        return this.itemCdVnd;
    }
    
    public void setItemCdVnd(String itemCdVnd) {
        this.itemCdVnd = itemCdVnd;
    }

    
    @Column(name="CNTRY_CD_ORIGIN", length=3)
    public String getCntryCdOrigin() {
        return this.cntryCdOrigin;
    }
    
    public void setCntryCdOrigin(String cntryCdOrigin) {
        this.cntryCdOrigin = cntryCdOrigin;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="EXPIRE_DT", length=7)
    public Date getExpireDt() {
        return this.expireDt;
    }
    
    public void setExpireDt(Date expireDt) {
        this.expireDt = expireDt;
    }

    
    @Column(name="BOX_QTY", precision=7, scale=0)
    public Integer getBoxQty() {
        return this.boxQty;
    }
    
    public void setBoxQty(Integer boxQty) {
        this.boxQty = boxQty;
    }

    
    @Column(name="QTY_ON_HAND_FLG", nullable=false, length=1)
    public String getQtyOnHandFlg() {
        return this.qtyOnHandFlg;
    }
    
    public void setQtyOnHandFlg(String qtyOnHandFlg) {
        this.qtyOnHandFlg = qtyOnHandFlg;
    }

    
    @Column(name="REJECT_CD", length=8)
    public String getRejectCd() {
        return this.rejectCd;
    }
    
    public void setRejectCd(String rejectCd) {
        this.rejectCd = rejectCd;
    }

    
    @Column(name="LOT_COST_LANDED_ORIG", precision=17, scale=6)
    public BigDecimal getLotCostLandedOrig() {
        return this.lotCostLandedOrig;
    }
    
    public void setLotCostLandedOrig(BigDecimal lotCostLandedOrig) {
        this.lotCostLandedOrig = lotCostLandedOrig;
    }

    
    @Column(name="LOT_COST_LANDED_DENOM_ORIG", precision=17, scale=6)
    public BigDecimal getLotCostLandedDenomOrig() {
        return this.lotCostLandedDenomOrig;
    }
    
    public void setLotCostLandedDenomOrig(BigDecimal lotCostLandedDenomOrig) {
        this.lotCostLandedDenomOrig = lotCostLandedDenomOrig;
    }

    
    @Column(name="LOT_COST_LANDED_CURR", precision=17, scale=6)
    public BigDecimal getLotCostLandedCurr() {
        return this.lotCostLandedCurr;
    }
    
    public void setLotCostLandedCurr(BigDecimal lotCostLandedCurr) {
        this.lotCostLandedCurr = lotCostLandedCurr;
    }

    
    @Column(name="LOT_COST_LANDED_DENOM_CURR", precision=17, scale=6)
    public BigDecimal getLotCostLandedDenomCurr() {
        return this.lotCostLandedDenomCurr;
    }
    
    public void setLotCostLandedDenomCurr(BigDecimal lotCostLandedDenomCurr) {
        this.lotCostLandedDenomCurr = lotCostLandedDenomCurr;
    }

    
    @Column(name="PROCESSED_FOR_AP_FLG", nullable=false, length=1)
    public String getProcessedForApFlg() {
        return this.processedForApFlg;
    }
    
    public void setProcessedForApFlg(String processedForApFlg) {
        this.processedForApFlg = processedForApFlg;
    }

    
    @Column(name="LOT_CD", length=20)
    public String getLotCd() {
        return this.lotCd;
    }
    
    public void setLotCd(String lotCd) {
        this.lotCd = lotCd;
    }

    
    @Column(name="WO_HDR_NBR", precision=9, scale=0)
    public Integer getWoHdrNbr() {
        return this.woHdrNbr;
    }
    
    public void setWoHdrNbr(Integer woHdrNbr) {
        this.woHdrNbr = woHdrNbr;
    }

    
    @Column(name="WO_RELEASE_NBR", precision=9, scale=0)
    public Integer getWoReleaseNbr() {
        return this.woReleaseNbr;
    }
    
    public void setWoReleaseNbr(Integer woReleaseNbr) {
        this.woReleaseNbr = woReleaseNbr;
    }

    
    @Column(name="UT_USER_NBR_RECV", precision=9, scale=0)
    public Integer getUtUserNbrRecv() {
        return this.utUserNbrRecv;
    }
    
    public void setUtUserNbrRecv(Integer utUserNbrRecv) {
        this.utUserNbrRecv = utUserNbrRecv;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="icLotMast")
    public Set<IcMultipleCert> getIcMultipleCerts() {
        return this.icMultipleCerts;
    }
    
    public void setIcMultipleCerts(Set<IcMultipleCert> icMultipleCerts) {
        this.icMultipleCerts = icMultipleCerts;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="icLotMast")
    public Set<WhFacilityTransOnhand> getWhFacilityTransOnhands() {
        return this.whFacilityTransOnhands;
    }
    
    public void setWhFacilityTransOnhands(Set<WhFacilityTransOnhand> whFacilityTransOnhands) {
        this.whFacilityTransOnhands = whFacilityTransOnhands;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="icLotMast")
    public Set<ArInvDtl> getArInvDtls() {
        return this.arInvDtls;
    }
    
    public void setArInvDtls(Set<ArInvDtl> arInvDtls) {
        this.arInvDtls = arInvDtls;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="icLotMast")
    public Set<IcLotMastCert> getIcLotMastCerts() {
        return this.icLotMastCerts;
    }
    
    public void setIcLotMastCerts(Set<IcLotMastCert> icLotMastCerts) {
        this.icLotMastCerts = icLotMastCerts;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="icLotMast")
    public Set<PoUnplannedRcpt> getPoUnplannedRcpts() {
        return this.poUnplannedRcpts;
    }
    
    public void setPoUnplannedRcpts(Set<PoUnplannedRcpt> poUnplannedRcpts) {
        this.poUnplannedRcpts = poUnplannedRcpts;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="icLotMast")
    public Set<ArRmaRcpt> getArRmaRcpts() {
        return this.arRmaRcpts;
    }
    
    public void setArRmaRcpts(Set<ArRmaRcpt> arRmaRcpts) {
        this.arRmaRcpts = arRmaRcpts;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="icLotMast")
    public Set<IcItemLoc> getIcItemLocs() {
        return this.icItemLocs;
    }
    
    public void setIcItemLocs(Set<IcItemLoc> icItemLocs) {
        this.icItemLocs = icItemLocs;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="icLotMast")
    public Set<IcLotMast> getIcLotMasts() {
        return this.icLotMasts;
    }
    
    public void setIcLotMasts(Set<IcLotMast> icLotMasts) {
        this.icLotMasts = icLotMasts;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="icLotMast")
    public Set<PosDtl> getPosDtls() {
        return this.posDtls;
    }
    
    public void setPosDtls(Set<PosDtl> posDtls) {
        this.posDtls = posDtls;
    }




}

