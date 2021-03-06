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
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
//import org.hibernate.annotations.GenericGenerator;
//import org.hibernate.annotations.Parameter;

/**
 * OeCustMast generated by hbm2java
 */
@Entity
@Table(name="OE_CUST_MAST"
)
public class OeCustMast  implements java.io.Serializable {


     private int orgNbrCust;
     private NaIndiv naIndivBySellIndivNbr;
     private NaIndiv naIndivByIndivNbrCustContact;
     private NaOrg naOrg;
     private NaOrgAddr naOrgAddrByBillToAddrNbrDflt;
     private NaOrgAddr naOrgAddrByShipToAddrNbrDflt;
     private OeCustMast oeCustMast;
     private Currency currency;
     private FcstGrp fcstGrp;
     private String statId;
     private String custPriceGrp;
     private String custGrp;
     private String sicCd;
     private String reqrPoFlg;
     private String contractCustFlg;
     private String priceChgFlg;
     private String trdFlg;
     private String trdGlAcct;
     private int utUserNbr;
     private Date lastModDt;
     private Date introDt;
     private String virtualCustFlg;
     private String termCdDflt;
     private String shipViaCdDflt;
     private String fobCdDflt;
     private BigDecimal shipPctLineDflt;
     private BigDecimal shipPctDollarDflt;
     private short custAllocPrty;
     private String ordTypeCdDflt;
     private String dupPoAllowFlg;
     private BigDecimal creditLimit;
     private BigDecimal currArBal;
     private String salesTerrCdDflt;
     private String labelNmBag;
     private String labelNmPackBox;
     private String packBoxContentsRptNm;
     private String packSlipRptNm;
     private String showPriceOnPackSlipFlg;
     private byte nbrPackSlipCopies;
     private String addAddrFlg;
     private String summaryInvRptNm;
     private Short avgDaysToPay;
     private byte nbrInvoiceCopies;
     private Date arIntegrationTm;
     private String salesRegionCdDflt;
     private Short shipLinePctDflt;
     private Short autoCloseLinePctDflt;
     private Byte maxShipmentsPerLineDflt;
     private Integer whShipPrtyNbrDflt;
     private String paymentMethodCdDflt;
     private String pricePolicyCd;
     private String transmitPackSlipOnShipFlg;
     private Set<WoHdr> woHdrs = new HashSet<WoHdr>(0);
     private Set<OeCustMastCert> oeCustMastCerts = new HashSet<OeCustMastCert>(0);
     private Set<FcItemMast> fcItemMasts = new HashSet<FcItemMast>(0);
     private Set<OeCustMfr> oeCustMfrs = new HashSet<OeCustMfr>(0);
     private Set<ArRmaRcpt> arRmaRcpts = new HashSet<ArRmaRcpt>(0);
     private Set<IcItemRestrictCust> icItemRestrictCusts = new HashSet<IcItemRestrictCust>(0);
     private Set<OeOrdDtl> oeOrdDtls = new HashSet<OeOrdDtl>(0);
     private Set<OeCustContract> oeCustContracts = new HashSet<OeCustContract>(0);
     private Set<OeCustMast> oeCustMasts = new HashSet<OeCustMast>(0);
     private Set<OeOrdHdr> oeOrdHdrs = new HashSet<OeOrdHdr>(0);
     private Set<IcKitMast> icKitMasts = new HashSet<IcKitMast>(0);
     private Set<ArInvHdr> arInvHdrs = new HashSet<ArInvHdr>(0);
     private Set<IcItemCustSubst> icItemCustSubsts = new HashSet<IcItemCustSubst>(0);
     private Set<SqQteHdr> sqQteHdrs = new HashSet<SqQteHdr>(0);

    public OeCustMast() {
    }
   
     //@GenericGenerator(name="com.pacificdataservices.diamond.models.OeCustMastIdGenerator", strategy="foreign", parameters=@Parameter(name="property", value="naOrg"))
     @Id 
    // @GeneratedValue(generator="com.pacificdataservices.diamond.models.OeCustMastIdGenerator")

    
    @Column(name="ORG_NBR_CUST", unique=true, nullable=false, precision=9, scale=0)
    public int getOrgNbrCust() {
        return this.orgNbrCust;
    }
    
    public void setOrgNbrCust(int orgNbrCust) {
        this.orgNbrCust = orgNbrCust;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="SELL_INDIV_NBR")
    public NaIndiv getNaIndivBySellIndivNbr() {
        return this.naIndivBySellIndivNbr;
    }
    
    public void setNaIndivBySellIndivNbr(NaIndiv naIndivBySellIndivNbr) {
        this.naIndivBySellIndivNbr = naIndivBySellIndivNbr;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="INDIV_NBR_CUST_CONTACT")
    public NaIndiv getNaIndivByIndivNbrCustContact() {
        return this.naIndivByIndivNbrCustContact;
    }
    
    public void setNaIndivByIndivNbrCustContact(NaIndiv naIndivByIndivNbrCustContact) {
        this.naIndivByIndivNbrCustContact = naIndivByIndivNbrCustContact;
    }

@OneToOne(fetch=FetchType.LAZY)@PrimaryKeyJoinColumn
    public NaOrg getNaOrg() {
        return this.naOrg;
    }
    
    public void setNaOrg(NaOrg naOrg) {
    	if (naOrg == null) {
    		throw new IllegalArgumentException("naOrg is null");
    	}
        this.naOrg = naOrg;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="BILL_TO_ADDR_NBR_DFLT", nullable=false)
    public NaOrgAddr getNaOrgAddrByBillToAddrNbrDflt() {
        return this.naOrgAddrByBillToAddrNbrDflt;
    }
    
    public void setNaOrgAddrByBillToAddrNbrDflt(NaOrgAddr naOrgAddrByBillToAddrNbrDflt) {
        this.naOrgAddrByBillToAddrNbrDflt = naOrgAddrByBillToAddrNbrDflt;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="SHIP_TO_ADDR_NBR_DFLT", nullable=false)
    public NaOrgAddr getNaOrgAddrByShipToAddrNbrDflt() {
        return this.naOrgAddrByShipToAddrNbrDflt;
    }
    
    public void setNaOrgAddrByShipToAddrNbrDflt(NaOrgAddr naOrgAddrByShipToAddrNbrDflt) {
        this.naOrgAddrByShipToAddrNbrDflt = naOrgAddrByShipToAddrNbrDflt;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ORG_NBR_CUST_PARENT")
    public OeCustMast getOeCustMast() {
        return this.oeCustMast;
    }
    
    public void setOeCustMast(OeCustMast oeCustMast) {
        this.oeCustMast = oeCustMast;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="CURR_CD_DFLT", nullable=false)
    public Currency getCurrency() {
        return this.currency;
    }
    
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="FCST_GRP", nullable=false)
    public FcstGrp getFcstGrp() {
        return this.fcstGrp;
    }
    
    public void setFcstGrp(FcstGrp fcstGrp) {
        this.fcstGrp = fcstGrp;
    }

    
    @Column(name="STAT_ID", nullable=false, length=1)
    public String getStatId() {
        return this.statId;
    }
    
    public void setStatId(String statId) {
        this.statId = statId;
    }

    
    @Column(name="CUST_PRICE_GRP", length=10)
    public String getCustPriceGrp() {
        return this.custPriceGrp;
    }
    
    public void setCustPriceGrp(String custPriceGrp) {
        this.custPriceGrp = custPriceGrp;
    }

    
    @Column(name="CUST_GRP", length=8)
    public String getCustGrp() {
        return this.custGrp;
    }
    
    public void setCustGrp(String custGrp) {
        this.custGrp = custGrp;
    }

    
    @Column(name="SIC_CD", length=8)
    public String getSicCd() {
        return this.sicCd;
    }
    
    public void setSicCd(String sicCd) {
        this.sicCd = sicCd;
    }

    
    @Column(name="REQR_PO_FLG", nullable=false, length=1)
    public String getReqrPoFlg() {
        return this.reqrPoFlg;
    }
    
    public void setReqrPoFlg(String reqrPoFlg) {
        this.reqrPoFlg = reqrPoFlg;
    }

    
    @Column(name="CONTRACT_CUST_FLG", nullable=false, length=1)
    public String getContractCustFlg() {
        return this.contractCustFlg;
    }
    
    public void setContractCustFlg(String contractCustFlg) {
        this.contractCustFlg = contractCustFlg;
    }

    
    @Column(name="PRICE_CHG_FLG", nullable=false, length=1)
    public String getPriceChgFlg() {
        return this.priceChgFlg;
    }
    
    public void setPriceChgFlg(String priceChgFlg) {
        this.priceChgFlg = priceChgFlg;
    }

    
    @Column(name="TRD_FLG", nullable=false, length=1)
    public String getTrdFlg() {
        return this.trdFlg;
    }
    
    public void setTrdFlg(String trdFlg) {
        this.trdFlg = trdFlg;
    }

    
    @Column(name="TRD_GL_ACCT", length=20)
    public String getTrdGlAcct() {
        return this.trdGlAcct;
    }
    
    public void setTrdGlAcct(String trdGlAcct) {
        this.trdGlAcct = trdGlAcct;
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
    @Column(name="INTRO_DT", nullable=false, length=7)
    public Date getIntroDt() {
        return this.introDt;
    }
    
    public void setIntroDt(Date introDt) {
        this.introDt = introDt;
    }

    
    @Column(name="VIRTUAL_CUST_FLG", nullable=false, length=1)
    public String getVirtualCustFlg() {
        return this.virtualCustFlg;
    }
    
    public void setVirtualCustFlg(String virtualCustFlg) {
        this.virtualCustFlg = virtualCustFlg;
    }

    
    @Column(name="TERM_CD_DFLT", nullable=false, length=10)
    public String getTermCdDflt() {
        return this.termCdDflt;
    }
    
    public void setTermCdDflt(String termCdDflt) {
        this.termCdDflt = termCdDflt;
    }

    
    @Column(name="SHIP_VIA_CD_DFLT", nullable=false, length=8)
    public String getShipViaCdDflt() {
        return this.shipViaCdDflt;
    }
    
    public void setShipViaCdDflt(String shipViaCdDflt) {
        this.shipViaCdDflt = shipViaCdDflt;
    }

    
    @Column(name="FOB_CD_DFLT", nullable=false, length=8)
    public String getFobCdDflt() {
        return this.fobCdDflt;
    }
    
    public void setFobCdDflt(String fobCdDflt) {
        this.fobCdDflt = fobCdDflt;
    }

    
    @Column(name="SHIP_PCT_LINE_DFLT", precision=5)
    public BigDecimal getShipPctLineDflt() {
        return this.shipPctLineDflt;
    }
    
    public void setShipPctLineDflt(BigDecimal shipPctLineDflt) {
        this.shipPctLineDflt = shipPctLineDflt;
    }

    
    @Column(name="SHIP_PCT_DOLLAR_DFLT", precision=5)
    public BigDecimal getShipPctDollarDflt() {
        return this.shipPctDollarDflt;
    }
    
    public void setShipPctDollarDflt(BigDecimal shipPctDollarDflt) {
        this.shipPctDollarDflt = shipPctDollarDflt;
    }

    
    @Column(name="CUST_ALLOC_PRTY", nullable=false, precision=3, scale=0)
    public short getCustAllocPrty() {
        return this.custAllocPrty;
    }
    
    public void setCustAllocPrty(short custAllocPrty) {
        this.custAllocPrty = custAllocPrty;
    }

    
    @Column(name="ORD_TYPE_CD_DFLT", nullable=false, length=8)
    public String getOrdTypeCdDflt() {
        return this.ordTypeCdDflt;
    }
    
    public void setOrdTypeCdDflt(String ordTypeCdDflt) {
        this.ordTypeCdDflt = ordTypeCdDflt;
    }

    
    @Column(name="DUP_PO_ALLOW_FLG", nullable=false, length=1)
    public String getDupPoAllowFlg() {
        return this.dupPoAllowFlg;
    }
    
    public void setDupPoAllowFlg(String dupPoAllowFlg) {
        this.dupPoAllowFlg = dupPoAllowFlg;
    }

    
    @Column(name="CREDIT_LIMIT", precision=12)
    public BigDecimal getCreditLimit() {
        return this.creditLimit;
    }
    
    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    
    @Column(name="CURR_AR_BAL", precision=10)
    public BigDecimal getCurrArBal() {
        return this.currArBal;
    }
    
    public void setCurrArBal(BigDecimal currArBal) {
        this.currArBal = currArBal;
    }

    
    @Column(name="SALES_TERR_CD_DFLT", nullable=false, length=8)
    public String getSalesTerrCdDflt() {
        return this.salesTerrCdDflt;
    }
    
    public void setSalesTerrCdDflt(String salesTerrCdDflt) {
        this.salesTerrCdDflt = salesTerrCdDflt;
    }

    
    @Column(name="LABEL_NM_BAG", length=20)
    public String getLabelNmBag() {
        return this.labelNmBag;
    }
    
    public void setLabelNmBag(String labelNmBag) {
        this.labelNmBag = labelNmBag;
    }

    
    @Column(name="LABEL_NM_PACK_BOX", length=20)
    public String getLabelNmPackBox() {
        return this.labelNmPackBox;
    }
    
    public void setLabelNmPackBox(String labelNmPackBox) {
        this.labelNmPackBox = labelNmPackBox;
    }

    
    @Column(name="PACK_BOX_CONTENTS_RPT_NM")
    public String getPackBoxContentsRptNm() {
        return this.packBoxContentsRptNm;
    }
    
    public void setPackBoxContentsRptNm(String packBoxContentsRptNm) {
        this.packBoxContentsRptNm = packBoxContentsRptNm;
    }

    
    @Column(name="PACK_SLIP_RPT_NM")
    public String getPackSlipRptNm() {
        return this.packSlipRptNm;
    }
    
    public void setPackSlipRptNm(String packSlipRptNm) {
        this.packSlipRptNm = packSlipRptNm;
    }

    
    @Column(name="SHOW_PRICE_ON_PACK_SLIP_FLG", nullable=false, length=1)
    public String getShowPriceOnPackSlipFlg() {
        return this.showPriceOnPackSlipFlg;
    }
    
    public void setShowPriceOnPackSlipFlg(String showPriceOnPackSlipFlg) {
        this.showPriceOnPackSlipFlg = showPriceOnPackSlipFlg;
    }

    
    @Column(name="NBR_PACK_SLIP_COPIES", nullable=false, precision=2, scale=0)
    public byte getNbrPackSlipCopies() {
        return this.nbrPackSlipCopies;
    }
    
    public void setNbrPackSlipCopies(byte nbrPackSlipCopies) {
        this.nbrPackSlipCopies = nbrPackSlipCopies;
    }

    
    @Column(name="ADD_ADDR_FLG", nullable=false, length=1)
    public String getAddAddrFlg() {
        return this.addAddrFlg;
    }
    
    public void setAddAddrFlg(String addAddrFlg) {
        this.addAddrFlg = addAddrFlg;
    }

    
    @Column(name="SUMMARY_INV_RPT_NM")
    public String getSummaryInvRptNm() {
        return this.summaryInvRptNm;
    }
    
    public void setSummaryInvRptNm(String summaryInvRptNm) {
        this.summaryInvRptNm = summaryInvRptNm;
    }

    
    @Column(name="AVG_DAYS_TO_PAY", precision=3, scale=0)
    public Short getAvgDaysToPay() {
        return this.avgDaysToPay;
    }
    
    public void setAvgDaysToPay(Short avgDaysToPay) {
        this.avgDaysToPay = avgDaysToPay;
    }

    
    @Column(name="NBR_INVOICE_COPIES", nullable=false, precision=2, scale=0)
    public byte getNbrInvoiceCopies() {
        return this.nbrInvoiceCopies;
    }
    
    public void setNbrInvoiceCopies(byte nbrInvoiceCopies) {
        this.nbrInvoiceCopies = nbrInvoiceCopies;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="AR_INTEGRATION_TM", length=7)
    public Date getArIntegrationTm() {
        return this.arIntegrationTm;
    }
    
    public void setArIntegrationTm(Date arIntegrationTm) {
        this.arIntegrationTm = arIntegrationTm;
    }

    
    @Column(name="SALES_REGION_CD_DFLT", length=8)
    public String getSalesRegionCdDflt() {
        return this.salesRegionCdDflt;
    }
    
    public void setSalesRegionCdDflt(String salesRegionCdDflt) {
        this.salesRegionCdDflt = salesRegionCdDflt;
    }

    
    @Column(name="SHIP_LINE_PCT_DFLT", precision=3, scale=0)
    public Short getShipLinePctDflt() {
        return this.shipLinePctDflt;
    }
    
    public void setShipLinePctDflt(Short shipLinePctDflt) {
        this.shipLinePctDflt = shipLinePctDflt;
    }

    
    @Column(name="AUTO_CLOSE_LINE_PCT_DFLT", precision=3, scale=0)
    public Short getAutoCloseLinePctDflt() {
        return this.autoCloseLinePctDflt;
    }
    
    public void setAutoCloseLinePctDflt(Short autoCloseLinePctDflt) {
        this.autoCloseLinePctDflt = autoCloseLinePctDflt;
    }

    
    @Column(name="MAX_SHIPMENTS_PER_LINE_DFLT", precision=2, scale=0)
    public Byte getMaxShipmentsPerLineDflt() {
        return this.maxShipmentsPerLineDflt;
    }
    
    public void setMaxShipmentsPerLineDflt(Byte maxShipmentsPerLineDflt) {
        this.maxShipmentsPerLineDflt = maxShipmentsPerLineDflt;
    }

    
    @Column(name="WH_SHIP_PRTY_NBR_DFLT", precision=5, scale=0)
    public Integer getWhShipPrtyNbrDflt() {
        return this.whShipPrtyNbrDflt;
    }
    
    public void setWhShipPrtyNbrDflt(Integer whShipPrtyNbrDflt) {
        this.whShipPrtyNbrDflt = whShipPrtyNbrDflt;
    }

    
    @Column(name="PAYMENT_METHOD_CD_DFLT", length=3)
    public String getPaymentMethodCdDflt() {
        return this.paymentMethodCdDflt;
    }
    
    public void setPaymentMethodCdDflt(String paymentMethodCdDflt) {
        this.paymentMethodCdDflt = paymentMethodCdDflt;
    }

    
    @Column(name="PRICE_POLICY_CD", nullable=false, length=10)
    public String getPricePolicyCd() {
        return this.pricePolicyCd;
    }
    
    public void setPricePolicyCd(String pricePolicyCd) {
        this.pricePolicyCd = pricePolicyCd;
    }

    
    @Column(name="TRANSMIT_PACK_SLIP_ON_SHIP_FLG", nullable=false, length=1)
    public String getTransmitPackSlipOnShipFlg() {
        return this.transmitPackSlipOnShipFlg;
    }
    
    public void setTransmitPackSlipOnShipFlg(String transmitPackSlipOnShipFlg) {
        this.transmitPackSlipOnShipFlg = transmitPackSlipOnShipFlg;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="oeCustMast")
    public Set<WoHdr> getWoHdrs() {
        return this.woHdrs;
    }
    
    public void setWoHdrs(Set<WoHdr> woHdrs) {
        this.woHdrs = woHdrs;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="oeCustMast")
    public Set<OeCustMastCert> getOeCustMastCerts() {
        return this.oeCustMastCerts;
    }
    
    public void setOeCustMastCerts(Set<OeCustMastCert> oeCustMastCerts) {
        this.oeCustMastCerts = oeCustMastCerts;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="oeCustMast")
    public Set<FcItemMast> getFcItemMasts() {
        return this.fcItemMasts;
    }
    
    public void setFcItemMasts(Set<FcItemMast> fcItemMasts) {
        this.fcItemMasts = fcItemMasts;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="oeCustMast")
    public Set<OeCustMfr> getOeCustMfrs() {
        return this.oeCustMfrs;
    }
    
    public void setOeCustMfrs(Set<OeCustMfr> oeCustMfrs) {
        this.oeCustMfrs = oeCustMfrs;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="oeCustMast")
    public Set<ArRmaRcpt> getArRmaRcpts() {
        return this.arRmaRcpts;
    }
    
    public void setArRmaRcpts(Set<ArRmaRcpt> arRmaRcpts) {
        this.arRmaRcpts = arRmaRcpts;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="oeCustMast")
    public Set<IcItemRestrictCust> getIcItemRestrictCusts() {
        return this.icItemRestrictCusts;
    }
    
    public void setIcItemRestrictCusts(Set<IcItemRestrictCust> icItemRestrictCusts) {
        this.icItemRestrictCusts = icItemRestrictCusts;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="oeCustMast")
    public Set<OeOrdDtl> getOeOrdDtls() {
        return this.oeOrdDtls;
    }
    
    public void setOeOrdDtls(Set<OeOrdDtl> oeOrdDtls) {
        this.oeOrdDtls = oeOrdDtls;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="oeCustMast")
    public Set<OeCustContract> getOeCustContracts() {
        return this.oeCustContracts;
    }
    
    public void setOeCustContracts(Set<OeCustContract> oeCustContracts) {
        this.oeCustContracts = oeCustContracts;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="oeCustMast")
    public Set<OeCustMast> getOeCustMasts() {
        return this.oeCustMasts;
    }
    
    public void setOeCustMasts(Set<OeCustMast> oeCustMasts) {
        this.oeCustMasts = oeCustMasts;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="oeCustMast")
    public Set<OeOrdHdr> getOeOrdHdrs() {
        return this.oeOrdHdrs;
    }
    
    public void setOeOrdHdrs(Set<OeOrdHdr> oeOrdHdrs) {
        this.oeOrdHdrs = oeOrdHdrs;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="oeCustMast")
    public Set<IcKitMast> getIcKitMasts() {
        return this.icKitMasts;
    }
    
    public void setIcKitMasts(Set<IcKitMast> icKitMasts) {
        this.icKitMasts = icKitMasts;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="oeCustMast")
    public Set<ArInvHdr> getArInvHdrs() {
        return this.arInvHdrs;
    }
    
    public void setArInvHdrs(Set<ArInvHdr> arInvHdrs) {
        this.arInvHdrs = arInvHdrs;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="oeCustMast")
    public Set<IcItemCustSubst> getIcItemCustSubsts() {
        return this.icItemCustSubsts;
    }
    
    public void setIcItemCustSubsts(Set<IcItemCustSubst> icItemCustSubsts) {
        this.icItemCustSubsts = icItemCustSubsts;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="oeCustMast")
    public Set<SqQteHdr> getSqQteHdrs() {
        return this.sqQteHdrs;
    }
    
    public void setSqQteHdrs(Set<SqQteHdr> sqQteHdrs) {
        this.sqQteHdrs = sqQteHdrs;
    }




}


