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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * OeOrdDtl generated by hbm2java
 */
@Entity
@Table(name="OE_ORD_DTL"
)
public class OeOrdDtl  implements java.io.Serializable {


     private int oeOrdDtlNbr;
     private IcUm icUm;
     private NaOrg naOrg;
     private NaOrgAddr naOrgAddr;
     private OeCustContract oeCustContract;
     private OeCustMast oeCustMast;
     private OeOrdHdr oeOrdHdr;
     private IcItemMast icItemMastByItemNbrOrd;
     private IcItemMast icItemMastByItemNbrRqst;
     private short lineNbr;
     private BigDecimal qtyOrd;
     private Date rqstDt;
     private Date promDtOrig;
     private String tieCd;
     private String lineStatId;
     private String itemCdCust;
     private Integer pkgQty;
     private Short pickPrtyCust;
     private Byte pickPrtyRqst;
     private Byte pickPrtyPastDueMult;
     private int utUserNbr;
     private Date lastModDt;
     private String shipViaCd;
     private String custBinCd;
     private String custLineCd;
     private BigDecimal qtyShip;
     private int apsSrcRuleSetNbr;
     private String cancelCd;
     private Date cancelDt;
     private Integer utUserNbrCancel;
     private Date lotNotExpireBeforeDt;
     private Date lotManufactureAfterDt;
     private String cntryCdOrigin;
     private BigDecimal qtyOrdStkUm;
     private String revLvl;
     private BigDecimal unitPriceStkUm;
     private BigDecimal unitPriceDenomStkUm;
     private BigDecimal qtyShipStkUm;
     private String partMismatchReasonCd;
     private BigDecimal unitPriceSellUm;
     private BigDecimal unitPriceDenomSellUm;
     private String custRef;
     private BigDecimal qtyAlloc;
     private BigDecimal qtyAllocStkUm;
     private Date promDtCurr;
     private String shipFromFacility;
     private String shipCmpltFlg;
     private String hotFlg;
     private Short shipLinePct;
     private String oeCloseReasonCd;
     private Date closeTm;
     private Integer utUserNbrClose;
     private Short autoCloseLinePct;
     private Byte maxShipmentsPerLine;
     private Integer whShipPrtyNbr;
     private String paymentMethodCd;
     private Set<ArInvDtl> arInvDtls = new HashSet<ArInvDtl>(0);
     private Set<OeOrdDtlCert> oeOrdDtlCerts = new HashSet<OeOrdDtlCert>(0);
     private Set<SqQteDtl> sqQteDtls = new HashSet<SqQteDtl>(0);
     private Set<ApsAllocWoOo> apsAllocWoOos = new HashSet<ApsAllocWoOo>(0);
     private Set<WhPickDtlCopRqst> whPickDtlCopRqsts = new HashSet<WhPickDtlCopRqst>(0);
     private Set<WoHdr> woHdrs = new HashSet<WoHdr>(0);

    public OeOrdDtl() {
    }

	
    public OeOrdDtl(int oeOrdDtlNbr, IcUm icUm, NaOrgAddr naOrgAddr, OeCustContract oeCustContract, OeCustMast oeCustMast, OeOrdHdr oeOrdHdr, IcItemMast icItemMastByItemNbrOrd, IcItemMast icItemMastByItemNbrRqst, short lineNbr, BigDecimal qtyOrd, Date rqstDt, Date promDtOrig, String lineStatId, int utUserNbr, Date lastModDt, String shipViaCd, int apsSrcRuleSetNbr, BigDecimal qtyOrdStkUm, Date promDtCurr, String shipFromFacility, String shipCmpltFlg, String hotFlg) {
        this.oeOrdDtlNbr = oeOrdDtlNbr;
        this.icUm = icUm;
        this.naOrgAddr = naOrgAddr;
        this.oeCustContract = oeCustContract;
        this.oeCustMast = oeCustMast;
        this.oeOrdHdr = oeOrdHdr;
        this.icItemMastByItemNbrOrd = icItemMastByItemNbrOrd;
        this.icItemMastByItemNbrRqst = icItemMastByItemNbrRqst;
        this.lineNbr = lineNbr;
        this.qtyOrd = qtyOrd;
        this.rqstDt = rqstDt;
        this.promDtOrig = promDtOrig;
        this.lineStatId = lineStatId;
        this.utUserNbr = utUserNbr;
        this.lastModDt = lastModDt;
        this.shipViaCd = shipViaCd;
        this.apsSrcRuleSetNbr = apsSrcRuleSetNbr;
        this.qtyOrdStkUm = qtyOrdStkUm;
        this.promDtCurr = promDtCurr;
        this.shipFromFacility = shipFromFacility;
        this.shipCmpltFlg = shipCmpltFlg;
        this.hotFlg = hotFlg;
    }
    public OeOrdDtl(int oeOrdDtlNbr, IcUm icUm, NaOrg naOrg, NaOrgAddr naOrgAddr, OeCustContract oeCustContract, OeCustMast oeCustMast, OeOrdHdr oeOrdHdr, IcItemMast icItemMastByItemNbrOrd, IcItemMast icItemMastByItemNbrRqst, short lineNbr, BigDecimal qtyOrd, Date rqstDt, Date promDtOrig, String tieCd, String lineStatId, String itemCdCust, Integer pkgQty, Short pickPrtyCust, Byte pickPrtyRqst, Byte pickPrtyPastDueMult, int utUserNbr, Date lastModDt, String shipViaCd, String custBinCd, String custLineCd, BigDecimal qtyShip, int apsSrcRuleSetNbr, String cancelCd, Date cancelDt, Integer utUserNbrCancel, Date lotNotExpireBeforeDt, Date lotManufactureAfterDt, String cntryCdOrigin, BigDecimal qtyOrdStkUm, String revLvl, BigDecimal unitPriceStkUm, BigDecimal unitPriceDenomStkUm, BigDecimal qtyShipStkUm, String partMismatchReasonCd, BigDecimal unitPriceSellUm, BigDecimal unitPriceDenomSellUm, String custRef, BigDecimal qtyAlloc, BigDecimal qtyAllocStkUm, Date promDtCurr, String shipFromFacility, String shipCmpltFlg, String hotFlg, Short shipLinePct, String oeCloseReasonCd, Date closeTm, Integer utUserNbrClose, Short autoCloseLinePct, Byte maxShipmentsPerLine, Integer whShipPrtyNbr, String paymentMethodCd, Set<ArInvDtl> arInvDtls, Set<OeOrdDtlCert> oeOrdDtlCerts, Set<SqQteDtl> sqQteDtls, Set<ApsAllocWoOo> apsAllocWoOos, Set<WhPickDtlCopRqst> whPickDtlCopRqsts, Set<WoHdr> woHdrs) {
       this.oeOrdDtlNbr = oeOrdDtlNbr;
       this.icUm = icUm;
       this.naOrg = naOrg;
       this.naOrgAddr = naOrgAddr;
       this.oeCustContract = oeCustContract;
       this.oeCustMast = oeCustMast;
       this.oeOrdHdr = oeOrdHdr;
       this.icItemMastByItemNbrOrd = icItemMastByItemNbrOrd;
       this.icItemMastByItemNbrRqst = icItemMastByItemNbrRqst;
       this.lineNbr = lineNbr;
       this.qtyOrd = qtyOrd;
       this.rqstDt = rqstDt;
       this.promDtOrig = promDtOrig;
       this.tieCd = tieCd;
       this.lineStatId = lineStatId;
       this.itemCdCust = itemCdCust;
       this.pkgQty = pkgQty;
       this.pickPrtyCust = pickPrtyCust;
       this.pickPrtyRqst = pickPrtyRqst;
       this.pickPrtyPastDueMult = pickPrtyPastDueMult;
       this.utUserNbr = utUserNbr;
       this.lastModDt = lastModDt;
       this.shipViaCd = shipViaCd;
       this.custBinCd = custBinCd;
       this.custLineCd = custLineCd;
       this.qtyShip = qtyShip;
       this.apsSrcRuleSetNbr = apsSrcRuleSetNbr;
       this.cancelCd = cancelCd;
       this.cancelDt = cancelDt;
       this.utUserNbrCancel = utUserNbrCancel;
       this.lotNotExpireBeforeDt = lotNotExpireBeforeDt;
       this.lotManufactureAfterDt = lotManufactureAfterDt;
       this.cntryCdOrigin = cntryCdOrigin;
       this.qtyOrdStkUm = qtyOrdStkUm;
       this.revLvl = revLvl;
       this.unitPriceStkUm = unitPriceStkUm;
       this.unitPriceDenomStkUm = unitPriceDenomStkUm;
       this.qtyShipStkUm = qtyShipStkUm;
       this.partMismatchReasonCd = partMismatchReasonCd;
       this.unitPriceSellUm = unitPriceSellUm;
       this.unitPriceDenomSellUm = unitPriceDenomSellUm;
       this.custRef = custRef;
       this.qtyAlloc = qtyAlloc;
       this.qtyAllocStkUm = qtyAllocStkUm;
       this.promDtCurr = promDtCurr;
       this.shipFromFacility = shipFromFacility;
       this.shipCmpltFlg = shipCmpltFlg;
       this.hotFlg = hotFlg;
       this.shipLinePct = shipLinePct;
       this.oeCloseReasonCd = oeCloseReasonCd;
       this.closeTm = closeTm;
       this.utUserNbrClose = utUserNbrClose;
       this.autoCloseLinePct = autoCloseLinePct;
       this.maxShipmentsPerLine = maxShipmentsPerLine;
       this.whShipPrtyNbr = whShipPrtyNbr;
       this.paymentMethodCd = paymentMethodCd;
       this.arInvDtls = arInvDtls;
       this.oeOrdDtlCerts = oeOrdDtlCerts;
       this.sqQteDtls = sqQteDtls;
       this.apsAllocWoOos = apsAllocWoOos;
       this.whPickDtlCopRqsts = whPickDtlCopRqsts;
       this.woHdrs = woHdrs;
    }
   
     @Id 

    
    @Column(name="OE_ORD_DTL_NBR", unique=true, nullable=false, precision=9, scale=0)
    public int getOeOrdDtlNbr() {
        return this.oeOrdDtlNbr;
    }
    
    public void setOeOrdDtlNbr(int oeOrdDtlNbr) {
        this.oeOrdDtlNbr = oeOrdDtlNbr;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="SELL_UM", nullable=false)
    public IcUm getIcUm() {
        return this.icUm;
    }
    
    public void setIcUm(IcUm icUm) {
        this.icUm = icUm;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ORG_NBR_MFR_RQST")
    public NaOrg getNaOrg() {
        return this.naOrg;
    }
    
    public void setNaOrg(NaOrg naOrg) {
        this.naOrg = naOrg;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="SHIP_TO_ADDR_NBR", nullable=false)
    public NaOrgAddr getNaOrgAddr() {
        return this.naOrgAddr;
    }
    
    public void setNaOrgAddr(NaOrgAddr naOrgAddr) {
        this.naOrgAddr = naOrgAddr;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns( { 
        @JoinColumn(name="ORG_NBR_CUST", referencedColumnName="ORG_NBR_CUST", nullable=false), 
        @JoinColumn(name="CONTRACT_CD", referencedColumnName="CONTRACT_CD", nullable=false) } )
    public OeCustContract getOeCustContract() {
        return this.oeCustContract;
    }
    
    public void setOeCustContract(OeCustContract oeCustContract) {
        this.oeCustContract = oeCustContract;
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
    @JoinColumn(name="OE_ORD_HDR_NBR", nullable=false)
    public OeOrdHdr getOeOrdHdr() {
        return this.oeOrdHdr;
    }
    
    public void setOeOrdHdr(OeOrdHdr oeOrdHdr) {
        this.oeOrdHdr = oeOrdHdr;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ITEM_NBR_ORD", nullable=false)
    public IcItemMast getIcItemMastByItemNbrOrd() {
        return this.icItemMastByItemNbrOrd;
    }
    
    public void setIcItemMastByItemNbrOrd(IcItemMast icItemMastByItemNbrOrd) {
        this.icItemMastByItemNbrOrd = icItemMastByItemNbrOrd;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ITEM_NBR_RQST", nullable=false)
    public IcItemMast getIcItemMastByItemNbrRqst() {
        return this.icItemMastByItemNbrRqst;
    }
    
    public void setIcItemMastByItemNbrRqst(IcItemMast icItemMastByItemNbrRqst) {
        this.icItemMastByItemNbrRqst = icItemMastByItemNbrRqst;
    }

    
    @Column(name="LINE_NBR", nullable=false, precision=4, scale=0)
    public short getLineNbr() {
        return this.lineNbr;
    }
    
    public void setLineNbr(short lineNbr) {
        this.lineNbr = lineNbr;
    }

    
    @Column(name="QTY_ORD", nullable=false, precision=15, scale=5)
    public BigDecimal getQtyOrd() {
        return this.qtyOrd;
    }
    
    public void setQtyOrd(BigDecimal qtyOrd) {
        this.qtyOrd = qtyOrd;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="RQST_DT", nullable=false, length=7)
    public Date getRqstDt() {
        return this.rqstDt;
    }
    
    public void setRqstDt(Date rqstDt) {
        this.rqstDt = rqstDt;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="PROM_DT_ORIG", nullable=false, length=7)
    public Date getPromDtOrig() {
        return this.promDtOrig;
    }
    
    public void setPromDtOrig(Date promDtOrig) {
        this.promDtOrig = promDtOrig;
    }

    
    @Column(name="TIE_CD", length=1)
    public String getTieCd() {
        return this.tieCd;
    }
    
    public void setTieCd(String tieCd) {
        this.tieCd = tieCd;
    }

    
    @Column(name="LINE_STAT_ID", nullable=false, length=1)
    public String getLineStatId() {
        return this.lineStatId;
    }
    
    public void setLineStatId(String lineStatId) {
        this.lineStatId = lineStatId;
    }

    
    @Column(name="ITEM_CD_CUST", length=50)
    public String getItemCdCust() {
        return this.itemCdCust;
    }
    
    public void setItemCdCust(String itemCdCust) {
        this.itemCdCust = itemCdCust;
    }

    
    @Column(name="PKG_QTY", precision=7, scale=0)
    public Integer getPkgQty() {
        return this.pkgQty;
    }
    
    public void setPkgQty(Integer pkgQty) {
        this.pkgQty = pkgQty;
    }

    
    @Column(name="PICK_PRTY_CUST", precision=3, scale=0)
    public Short getPickPrtyCust() {
        return this.pickPrtyCust;
    }
    
    public void setPickPrtyCust(Short pickPrtyCust) {
        this.pickPrtyCust = pickPrtyCust;
    }

    
    @Column(name="PICK_PRTY_RQST", precision=2, scale=0)
    public Byte getPickPrtyRqst() {
        return this.pickPrtyRqst;
    }
    
    public void setPickPrtyRqst(Byte pickPrtyRqst) {
        this.pickPrtyRqst = pickPrtyRqst;
    }

    
    @Column(name="PICK_PRTY_PAST_DUE_MULT", precision=2, scale=0)
    public Byte getPickPrtyPastDueMult() {
        return this.pickPrtyPastDueMult;
    }
    
    public void setPickPrtyPastDueMult(Byte pickPrtyPastDueMult) {
        this.pickPrtyPastDueMult = pickPrtyPastDueMult;
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

    
    @Column(name="SHIP_VIA_CD", nullable=false, length=8)
    public String getShipViaCd() {
        return this.shipViaCd;
    }
    
    public void setShipViaCd(String shipViaCd) {
        this.shipViaCd = shipViaCd;
    }

    
    @Column(name="CUST_BIN_CD", length=40)
    public String getCustBinCd() {
        return this.custBinCd;
    }
    
    public void setCustBinCd(String custBinCd) {
        this.custBinCd = custBinCd;
    }

    
    @Column(name="CUST_LINE_CD", length=5)
    public String getCustLineCd() {
        return this.custLineCd;
    }
    
    public void setCustLineCd(String custLineCd) {
        this.custLineCd = custLineCd;
    }

    
    @Column(name="QTY_SHIP", precision=15, scale=5)
    public BigDecimal getQtyShip() {
        return this.qtyShip;
    }
    
    public void setQtyShip(BigDecimal qtyShip) {
        this.qtyShip = qtyShip;
    }

    
    @Column(name="APS_SRC_RULE_SET_NBR", nullable=false, precision=9, scale=0)
    public int getApsSrcRuleSetNbr() {
        return this.apsSrcRuleSetNbr;
    }
    
    public void setApsSrcRuleSetNbr(int apsSrcRuleSetNbr) {
        this.apsSrcRuleSetNbr = apsSrcRuleSetNbr;
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

    
    @Column(name="CNTRY_CD_ORIGIN", length=3)
    public String getCntryCdOrigin() {
        return this.cntryCdOrigin;
    }
    
    public void setCntryCdOrigin(String cntryCdOrigin) {
        this.cntryCdOrigin = cntryCdOrigin;
    }

    
    @Column(name="QTY_ORD_STK_UM", nullable=false, precision=15, scale=5)
    public BigDecimal getQtyOrdStkUm() {
        return this.qtyOrdStkUm;
    }
    
    public void setQtyOrdStkUm(BigDecimal qtyOrdStkUm) {
        this.qtyOrdStkUm = qtyOrdStkUm;
    }

    
    @Column(name="REV_LVL", length=5)
    public String getRevLvl() {
        return this.revLvl;
    }
    
    public void setRevLvl(String revLvl) {
        this.revLvl = revLvl;
    }

    
    @Column(name="UNIT_PRICE_STK_UM", precision=17, scale=6)
    public BigDecimal getUnitPriceStkUm() {
        return this.unitPriceStkUm;
    }
    
    public void setUnitPriceStkUm(BigDecimal unitPriceStkUm) {
        this.unitPriceStkUm = unitPriceStkUm;
    }

    
    @Column(name="UNIT_PRICE_DENOM_STK_UM", precision=17, scale=6)
    public BigDecimal getUnitPriceDenomStkUm() {
        return this.unitPriceDenomStkUm;
    }
    
    public void setUnitPriceDenomStkUm(BigDecimal unitPriceDenomStkUm) {
        this.unitPriceDenomStkUm = unitPriceDenomStkUm;
    }

    
    @Column(name="QTY_SHIP_STK_UM", precision=15, scale=5)
    public BigDecimal getQtyShipStkUm() {
        return this.qtyShipStkUm;
    }
    
    public void setQtyShipStkUm(BigDecimal qtyShipStkUm) {
        this.qtyShipStkUm = qtyShipStkUm;
    }

    
    @Column(name="PART_MISMATCH_REASON_CD", length=8)
    public String getPartMismatchReasonCd() {
        return this.partMismatchReasonCd;
    }
    
    public void setPartMismatchReasonCd(String partMismatchReasonCd) {
        this.partMismatchReasonCd = partMismatchReasonCd;
    }

    
    @Column(name="UNIT_PRICE_SELL_UM", precision=17, scale=6)
    public BigDecimal getUnitPriceSellUm() {
        return this.unitPriceSellUm;
    }
    
    public void setUnitPriceSellUm(BigDecimal unitPriceSellUm) {
        this.unitPriceSellUm = unitPriceSellUm;
    }

    
    @Column(name="UNIT_PRICE_DENOM_SELL_UM", precision=17, scale=6)
    public BigDecimal getUnitPriceDenomSellUm() {
        return this.unitPriceDenomSellUm;
    }
    
    public void setUnitPriceDenomSellUm(BigDecimal unitPriceDenomSellUm) {
        this.unitPriceDenomSellUm = unitPriceDenomSellUm;
    }

    
    @Column(name="CUST_REF", length=40)
    public String getCustRef() {
        return this.custRef;
    }
    
    public void setCustRef(String custRef) {
        this.custRef = custRef;
    }

    
    @Column(name="QTY_ALLOC", precision=13, scale=5)
    public BigDecimal getQtyAlloc() {
        return this.qtyAlloc;
    }
    
    public void setQtyAlloc(BigDecimal qtyAlloc) {
        this.qtyAlloc = qtyAlloc;
    }

    
    @Column(name="QTY_ALLOC_STK_UM", precision=13, scale=5)
    public BigDecimal getQtyAllocStkUm() {
        return this.qtyAllocStkUm;
    }
    
    public void setQtyAllocStkUm(BigDecimal qtyAllocStkUm) {
        this.qtyAllocStkUm = qtyAllocStkUm;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="PROM_DT_CURR", nullable=false, length=7)
    public Date getPromDtCurr() {
        return this.promDtCurr;
    }
    
    public void setPromDtCurr(Date promDtCurr) {
        this.promDtCurr = promDtCurr;
    }

    
    @Column(name="SHIP_FROM_FACILITY", nullable=false, length=16)
    public String getShipFromFacility() {
        return this.shipFromFacility;
    }
    
    public void setShipFromFacility(String shipFromFacility) {
        this.shipFromFacility = shipFromFacility;
    }

    
    @Column(name="SHIP_CMPLT_FLG", nullable=false, length=1)
    public String getShipCmpltFlg() {
        return this.shipCmpltFlg;
    }
    
    public void setShipCmpltFlg(String shipCmpltFlg) {
        this.shipCmpltFlg = shipCmpltFlg;
    }

    
    @Column(name="HOT_FLG", nullable=false, length=1)
    public String getHotFlg() {
        return this.hotFlg;
    }
    
    public void setHotFlg(String hotFlg) {
        this.hotFlg = hotFlg;
    }

    
    @Column(name="SHIP_LINE_PCT", precision=3, scale=0)
    public Short getShipLinePct() {
        return this.shipLinePct;
    }
    
    public void setShipLinePct(Short shipLinePct) {
        this.shipLinePct = shipLinePct;
    }

    
    @Column(name="OE_CLOSE_REASON_CD", length=8)
    public String getOeCloseReasonCd() {
        return this.oeCloseReasonCd;
    }
    
    public void setOeCloseReasonCd(String oeCloseReasonCd) {
        this.oeCloseReasonCd = oeCloseReasonCd;
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

    
    @Column(name="AUTO_CLOSE_LINE_PCT", precision=3, scale=0)
    public Short getAutoCloseLinePct() {
        return this.autoCloseLinePct;
    }
    
    public void setAutoCloseLinePct(Short autoCloseLinePct) {
        this.autoCloseLinePct = autoCloseLinePct;
    }

    
    @Column(name="MAX_SHIPMENTS_PER_LINE", precision=2, scale=0)
    public Byte getMaxShipmentsPerLine() {
        return this.maxShipmentsPerLine;
    }
    
    public void setMaxShipmentsPerLine(Byte maxShipmentsPerLine) {
        this.maxShipmentsPerLine = maxShipmentsPerLine;
    }

    
    @Column(name="WH_SHIP_PRTY_NBR", precision=5, scale=0)
    public Integer getWhShipPrtyNbr() {
        return this.whShipPrtyNbr;
    }
    
    public void setWhShipPrtyNbr(Integer whShipPrtyNbr) {
        this.whShipPrtyNbr = whShipPrtyNbr;
    }

    
    @Column(name="PAYMENT_METHOD_CD", length=3)
    public String getPaymentMethodCd() {
        return this.paymentMethodCd;
    }
    
    public void setPaymentMethodCd(String paymentMethodCd) {
        this.paymentMethodCd = paymentMethodCd;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="oeOrdDtl")
    public Set<ArInvDtl> getArInvDtls() {
        return this.arInvDtls;
    }
    
    public void setArInvDtls(Set<ArInvDtl> arInvDtls) {
        this.arInvDtls = arInvDtls;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="oeOrdDtl")
    public Set<OeOrdDtlCert> getOeOrdDtlCerts() {
        return this.oeOrdDtlCerts;
    }
    
    public void setOeOrdDtlCerts(Set<OeOrdDtlCert> oeOrdDtlCerts) {
        this.oeOrdDtlCerts = oeOrdDtlCerts;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="oeOrdDtl")
    public Set<SqQteDtl> getSqQteDtls() {
        return this.sqQteDtls;
    }
    
    public void setSqQteDtls(Set<SqQteDtl> sqQteDtls) {
        this.sqQteDtls = sqQteDtls;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="oeOrdDtl")
    public Set<ApsAllocWoOo> getApsAllocWoOos() {
        return this.apsAllocWoOos;
    }
    
    public void setApsAllocWoOos(Set<ApsAllocWoOo> apsAllocWoOos) {
        this.apsAllocWoOos = apsAllocWoOos;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="oeOrdDtl")
    public Set<WhPickDtlCopRqst> getWhPickDtlCopRqsts() {
        return this.whPickDtlCopRqsts;
    }
    
    public void setWhPickDtlCopRqsts(Set<WhPickDtlCopRqst> whPickDtlCopRqsts) {
        this.whPickDtlCopRqsts = whPickDtlCopRqsts;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="oeOrdDtl")
    public Set<WoHdr> getWoHdrs() {
        return this.woHdrs;
    }
    
    public void setWoHdrs(Set<WoHdr> woHdrs) {
        this.woHdrs = woHdrs;
    }




}


