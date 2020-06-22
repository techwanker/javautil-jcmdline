package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PoOrdDtlId generated by hbm2java
 */
@Embeddable
public class PoOrdDtlId  implements java.io.Serializable {


     private int poLineDtlNbr;
     private int poOrdHdrNbr;
     private int poLineHdrNbr;
     private short poLineNbr;
     private String poCd;
     private Date poDt;
     private String vndrOrdCd;
     private String currCd;
     private String trdFlg;
     private int orgNbrVnd;
     private String orgCdVnd;
     private String orgNmVnd;
     private String vndrOrdLineCd;
     private BigDecimal replenQty;
     private BigDecimal unitCost;
     private BigDecimal unitCostDenom;
     private BigDecimal schedQty;
     private int itemNbr;
     private String itemCd;
     private String itemDescr;
     private String stkUm;
     private String itemCdVnd;
     private String replenUm;
     private BigDecimal recvQty;
     private Date replenEstShipDt;
     private Date replenRqstShipDt;
     private Date replenCurrEstDt;
     private String revLvl;
     private Integer orgNbrMfr;
     private String orgCdMfr;
     private String orgNmMfr;
     private String lineStatId;
     private String cntryCdOrigin;
     private String facility;
     private int apsSplySubPoolNbr;
     private String shipViaCd;
     private int shipToAddrNbr;
     private String apsSplyPoolCd;
     private String apsSplySubPoolCd;
     private int icCategoryNbr;
     private String poCancelCd;
     private String lineCancelCd;
     private String schedCancelCd;
     private String reqrMfrFlg;
     private BigDecimal stdCost;
     private BigDecimal listPrice;
     private int indivNbrBuy;
     private String indivNmSeller;
     private String sellerPhnNbr;
     private String sellerEmailAddr;
     private BigDecimal schedQtyStkUm;
     private BigDecimal recvQtyStkUm;
     private BigDecimal unitCostStkUm;
     private BigDecimal unitCostDenomStkUm;
     private String ordStatId;
     private Date lotManufactureAfterDt;
     private Date lotNotExpireBeforeDt;
     private Date apsAvailDt;
     private String buyReasonCd;

    public PoOrdDtlId() {
    }

	
    public PoOrdDtlId(int poLineDtlNbr, int poOrdHdrNbr, int poLineHdrNbr, short poLineNbr, String poCd, Date poDt, String currCd, String trdFlg, int orgNbrVnd, String orgCdVnd, String orgNmVnd, BigDecimal replenQty, BigDecimal unitCost, BigDecimal unitCostDenom, BigDecimal schedQty, int itemNbr, String itemCd, String itemDescr, String stkUm, String replenUm, Date replenEstShipDt, Date replenRqstShipDt, Date replenCurrEstDt, String lineStatId, String facility, int apsSplySubPoolNbr, String shipViaCd, int shipToAddrNbr, String apsSplyPoolCd, String apsSplySubPoolCd, int icCategoryNbr, String reqrMfrFlg, int indivNbrBuy, BigDecimal schedQtyStkUm, BigDecimal unitCostStkUm, String ordStatId, Date apsAvailDt) {
        this.poLineDtlNbr = poLineDtlNbr;
        this.poOrdHdrNbr = poOrdHdrNbr;
        this.poLineHdrNbr = poLineHdrNbr;
        this.poLineNbr = poLineNbr;
        this.poCd = poCd;
        this.poDt = poDt;
        this.currCd = currCd;
        this.trdFlg = trdFlg;
        this.orgNbrVnd = orgNbrVnd;
        this.orgCdVnd = orgCdVnd;
        this.orgNmVnd = orgNmVnd;
        this.replenQty = replenQty;
        this.unitCost = unitCost;
        this.unitCostDenom = unitCostDenom;
        this.schedQty = schedQty;
        this.itemNbr = itemNbr;
        this.itemCd = itemCd;
        this.itemDescr = itemDescr;
        this.stkUm = stkUm;
        this.replenUm = replenUm;
        this.replenEstShipDt = replenEstShipDt;
        this.replenRqstShipDt = replenRqstShipDt;
        this.replenCurrEstDt = replenCurrEstDt;
        this.lineStatId = lineStatId;
        this.facility = facility;
        this.apsSplySubPoolNbr = apsSplySubPoolNbr;
        this.shipViaCd = shipViaCd;
        this.shipToAddrNbr = shipToAddrNbr;
        this.apsSplyPoolCd = apsSplyPoolCd;
        this.apsSplySubPoolCd = apsSplySubPoolCd;
        this.icCategoryNbr = icCategoryNbr;
        this.reqrMfrFlg = reqrMfrFlg;
        this.indivNbrBuy = indivNbrBuy;
        this.schedQtyStkUm = schedQtyStkUm;
        this.unitCostStkUm = unitCostStkUm;
        this.ordStatId = ordStatId;
        this.apsAvailDt = apsAvailDt;
    }
    public PoOrdDtlId(int poLineDtlNbr, int poOrdHdrNbr, int poLineHdrNbr, short poLineNbr, String poCd, Date poDt, String vndrOrdCd, String currCd, String trdFlg, int orgNbrVnd, String orgCdVnd, String orgNmVnd, String vndrOrdLineCd, BigDecimal replenQty, BigDecimal unitCost, BigDecimal unitCostDenom, BigDecimal schedQty, int itemNbr, String itemCd, String itemDescr, String stkUm, String itemCdVnd, String replenUm, BigDecimal recvQty, Date replenEstShipDt, Date replenRqstShipDt, Date replenCurrEstDt, String revLvl, Integer orgNbrMfr, String orgCdMfr, String orgNmMfr, String lineStatId, String cntryCdOrigin, String facility, int apsSplySubPoolNbr, String shipViaCd, int shipToAddrNbr, String apsSplyPoolCd, String apsSplySubPoolCd, int icCategoryNbr, String poCancelCd, String lineCancelCd, String schedCancelCd, String reqrMfrFlg, BigDecimal stdCost, BigDecimal listPrice, int indivNbrBuy, String indivNmSeller, String sellerPhnNbr, String sellerEmailAddr, BigDecimal schedQtyStkUm, BigDecimal recvQtyStkUm, BigDecimal unitCostStkUm, BigDecimal unitCostDenomStkUm, String ordStatId, Date lotManufactureAfterDt, Date lotNotExpireBeforeDt, Date apsAvailDt, String buyReasonCd) {
       this.poLineDtlNbr = poLineDtlNbr;
       this.poOrdHdrNbr = poOrdHdrNbr;
       this.poLineHdrNbr = poLineHdrNbr;
       this.poLineNbr = poLineNbr;
       this.poCd = poCd;
       this.poDt = poDt;
       this.vndrOrdCd = vndrOrdCd;
       this.currCd = currCd;
       this.trdFlg = trdFlg;
       this.orgNbrVnd = orgNbrVnd;
       this.orgCdVnd = orgCdVnd;
       this.orgNmVnd = orgNmVnd;
       this.vndrOrdLineCd = vndrOrdLineCd;
       this.replenQty = replenQty;
       this.unitCost = unitCost;
       this.unitCostDenom = unitCostDenom;
       this.schedQty = schedQty;
       this.itemNbr = itemNbr;
       this.itemCd = itemCd;
       this.itemDescr = itemDescr;
       this.stkUm = stkUm;
       this.itemCdVnd = itemCdVnd;
       this.replenUm = replenUm;
       this.recvQty = recvQty;
       this.replenEstShipDt = replenEstShipDt;
       this.replenRqstShipDt = replenRqstShipDt;
       this.replenCurrEstDt = replenCurrEstDt;
       this.revLvl = revLvl;
       this.orgNbrMfr = orgNbrMfr;
       this.orgCdMfr = orgCdMfr;
       this.orgNmMfr = orgNmMfr;
       this.lineStatId = lineStatId;
       this.cntryCdOrigin = cntryCdOrigin;
       this.facility = facility;
       this.apsSplySubPoolNbr = apsSplySubPoolNbr;
       this.shipViaCd = shipViaCd;
       this.shipToAddrNbr = shipToAddrNbr;
       this.apsSplyPoolCd = apsSplyPoolCd;
       this.apsSplySubPoolCd = apsSplySubPoolCd;
       this.icCategoryNbr = icCategoryNbr;
       this.poCancelCd = poCancelCd;
       this.lineCancelCd = lineCancelCd;
       this.schedCancelCd = schedCancelCd;
       this.reqrMfrFlg = reqrMfrFlg;
       this.stdCost = stdCost;
       this.listPrice = listPrice;
       this.indivNbrBuy = indivNbrBuy;
       this.indivNmSeller = indivNmSeller;
       this.sellerPhnNbr = sellerPhnNbr;
       this.sellerEmailAddr = sellerEmailAddr;
       this.schedQtyStkUm = schedQtyStkUm;
       this.recvQtyStkUm = recvQtyStkUm;
       this.unitCostStkUm = unitCostStkUm;
       this.unitCostDenomStkUm = unitCostDenomStkUm;
       this.ordStatId = ordStatId;
       this.lotManufactureAfterDt = lotManufactureAfterDt;
       this.lotNotExpireBeforeDt = lotNotExpireBeforeDt;
       this.apsAvailDt = apsAvailDt;
       this.buyReasonCd = buyReasonCd;
    }
   


    @Column(name="PO_LINE_DTL_NBR", nullable=false, precision=9, scale=0)
    public int getPoLineDtlNbr() {
        return this.poLineDtlNbr;
    }
    
    public void setPoLineDtlNbr(int poLineDtlNbr) {
        this.poLineDtlNbr = poLineDtlNbr;
    }


    @Column(name="PO_ORD_HDR_NBR", nullable=false, precision=9, scale=0)
    public int getPoOrdHdrNbr() {
        return this.poOrdHdrNbr;
    }
    
    public void setPoOrdHdrNbr(int poOrdHdrNbr) {
        this.poOrdHdrNbr = poOrdHdrNbr;
    }


    @Column(name="PO_LINE_HDR_NBR", nullable=false, precision=9, scale=0)
    public int getPoLineHdrNbr() {
        return this.poLineHdrNbr;
    }
    
    public void setPoLineHdrNbr(int poLineHdrNbr) {
        this.poLineHdrNbr = poLineHdrNbr;
    }


    @Column(name="PO_LINE_NBR", nullable=false, precision=3, scale=0)
    public short getPoLineNbr() {
        return this.poLineNbr;
    }
    
    public void setPoLineNbr(short poLineNbr) {
        this.poLineNbr = poLineNbr;
    }


    @Column(name="PO_CD", nullable=false, length=20)
    public String getPoCd() {
        return this.poCd;
    }
    
    public void setPoCd(String poCd) {
        this.poCd = poCd;
    }


    @Column(name="PO_DT", nullable=false, length=7)
    public Date getPoDt() {
        return this.poDt;
    }
    
    public void setPoDt(Date poDt) {
        this.poDt = poDt;
    }


    @Column(name="VNDR_ORD_CD", length=20)
    public String getVndrOrdCd() {
        return this.vndrOrdCd;
    }
    
    public void setVndrOrdCd(String vndrOrdCd) {
        this.vndrOrdCd = vndrOrdCd;
    }


    @Column(name="CURR_CD", nullable=false, length=3)
    public String getCurrCd() {
        return this.currCd;
    }
    
    public void setCurrCd(String currCd) {
        this.currCd = currCd;
    }


    @Column(name="TRD_FLG", nullable=false, length=1)
    public String getTrdFlg() {
        return this.trdFlg;
    }
    
    public void setTrdFlg(String trdFlg) {
        this.trdFlg = trdFlg;
    }


    @Column(name="ORG_NBR_VND", nullable=false, precision=9, scale=0)
    public int getOrgNbrVnd() {
        return this.orgNbrVnd;
    }
    
    public void setOrgNbrVnd(int orgNbrVnd) {
        this.orgNbrVnd = orgNbrVnd;
    }


    @Column(name="ORG_CD_VND", nullable=false, length=15)
    public String getOrgCdVnd() {
        return this.orgCdVnd;
    }
    
    public void setOrgCdVnd(String orgCdVnd) {
        this.orgCdVnd = orgCdVnd;
    }


    @Column(name="ORG_NM_VND", nullable=false, length=60)
    public String getOrgNmVnd() {
        return this.orgNmVnd;
    }
    
    public void setOrgNmVnd(String orgNmVnd) {
        this.orgNmVnd = orgNmVnd;
    }


    @Column(name="VNDR_ORD_LINE_CD", length=3)
    public String getVndrOrdLineCd() {
        return this.vndrOrdLineCd;
    }
    
    public void setVndrOrdLineCd(String vndrOrdLineCd) {
        this.vndrOrdLineCd = vndrOrdLineCd;
    }


    @Column(name="REPLEN_QTY", nullable=false, precision=13, scale=5)
    public BigDecimal getReplenQty() {
        return this.replenQty;
    }
    
    public void setReplenQty(BigDecimal replenQty) {
        this.replenQty = replenQty;
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


    @Column(name="SCHED_QTY", nullable=false, precision=13, scale=5)
    public BigDecimal getSchedQty() {
        return this.schedQty;
    }
    
    public void setSchedQty(BigDecimal schedQty) {
        this.schedQty = schedQty;
    }


    @Column(name="ITEM_NBR", nullable=false, precision=9, scale=0)
    public int getItemNbr() {
        return this.itemNbr;
    }
    
    public void setItemNbr(int itemNbr) {
        this.itemNbr = itemNbr;
    }


    @Column(name="ITEM_CD", nullable=false, length=50)
    public String getItemCd() {
        return this.itemCd;
    }
    
    public void setItemCd(String itemCd) {
        this.itemCd = itemCd;
    }


    @Column(name="ITEM_DESCR", nullable=false, length=50)
    public String getItemDescr() {
        return this.itemDescr;
    }
    
    public void setItemDescr(String itemDescr) {
        this.itemDescr = itemDescr;
    }


    @Column(name="STK_UM", nullable=false, length=3)
    public String getStkUm() {
        return this.stkUm;
    }
    
    public void setStkUm(String stkUm) {
        this.stkUm = stkUm;
    }


    @Column(name="ITEM_CD_VND", length=50)
    public String getItemCdVnd() {
        return this.itemCdVnd;
    }
    
    public void setItemCdVnd(String itemCdVnd) {
        this.itemCdVnd = itemCdVnd;
    }


    @Column(name="REPLEN_UM", nullable=false, length=3)
    public String getReplenUm() {
        return this.replenUm;
    }
    
    public void setReplenUm(String replenUm) {
        this.replenUm = replenUm;
    }


    @Column(name="RECV_QTY", precision=13, scale=5)
    public BigDecimal getRecvQty() {
        return this.recvQty;
    }
    
    public void setRecvQty(BigDecimal recvQty) {
        this.recvQty = recvQty;
    }


    @Column(name="REPLEN_EST_SHIP_DT", nullable=false, length=7)
    public Date getReplenEstShipDt() {
        return this.replenEstShipDt;
    }
    
    public void setReplenEstShipDt(Date replenEstShipDt) {
        this.replenEstShipDt = replenEstShipDt;
    }


    @Column(name="REPLEN_RQST_SHIP_DT", nullable=false, length=7)
    public Date getReplenRqstShipDt() {
        return this.replenRqstShipDt;
    }
    
    public void setReplenRqstShipDt(Date replenRqstShipDt) {
        this.replenRqstShipDt = replenRqstShipDt;
    }


    @Column(name="REPLEN_CURR_EST_DT", nullable=false, length=7)
    public Date getReplenCurrEstDt() {
        return this.replenCurrEstDt;
    }
    
    public void setReplenCurrEstDt(Date replenCurrEstDt) {
        this.replenCurrEstDt = replenCurrEstDt;
    }


    @Column(name="REV_LVL", length=5)
    public String getRevLvl() {
        return this.revLvl;
    }
    
    public void setRevLvl(String revLvl) {
        this.revLvl = revLvl;
    }


    @Column(name="ORG_NBR_MFR", precision=9, scale=0)
    public Integer getOrgNbrMfr() {
        return this.orgNbrMfr;
    }
    
    public void setOrgNbrMfr(Integer orgNbrMfr) {
        this.orgNbrMfr = orgNbrMfr;
    }


    @Column(name="ORG_CD_MFR", length=15)
    public String getOrgCdMfr() {
        return this.orgCdMfr;
    }
    
    public void setOrgCdMfr(String orgCdMfr) {
        this.orgCdMfr = orgCdMfr;
    }


    @Column(name="ORG_NM_MFR", length=60)
    public String getOrgNmMfr() {
        return this.orgNmMfr;
    }
    
    public void setOrgNmMfr(String orgNmMfr) {
        this.orgNmMfr = orgNmMfr;
    }


    @Column(name="LINE_STAT_ID", nullable=false, length=1)
    public String getLineStatId() {
        return this.lineStatId;
    }
    
    public void setLineStatId(String lineStatId) {
        this.lineStatId = lineStatId;
    }


    @Column(name="CNTRY_CD_ORIGIN", length=3)
    public String getCntryCdOrigin() {
        return this.cntryCdOrigin;
    }
    
    public void setCntryCdOrigin(String cntryCdOrigin) {
        this.cntryCdOrigin = cntryCdOrigin;
    }


    @Column(name="FACILITY", nullable=false, length=16)
    public String getFacility() {
        return this.facility;
    }
    
    public void setFacility(String facility) {
        this.facility = facility;
    }


    @Column(name="APS_SPLY_SUB_POOL_NBR", nullable=false, precision=9, scale=0)
    public int getApsSplySubPoolNbr() {
        return this.apsSplySubPoolNbr;
    }
    
    public void setApsSplySubPoolNbr(int apsSplySubPoolNbr) {
        this.apsSplySubPoolNbr = apsSplySubPoolNbr;
    }


    @Column(name="SHIP_VIA_CD", nullable=false, length=8)
    public String getShipViaCd() {
        return this.shipViaCd;
    }
    
    public void setShipViaCd(String shipViaCd) {
        this.shipViaCd = shipViaCd;
    }


    @Column(name="SHIP_TO_ADDR_NBR", nullable=false, precision=9, scale=0)
    public int getShipToAddrNbr() {
        return this.shipToAddrNbr;
    }
    
    public void setShipToAddrNbr(int shipToAddrNbr) {
        this.shipToAddrNbr = shipToAddrNbr;
    }


    @Column(name="APS_SPLY_POOL_CD", nullable=false, length=20)
    public String getApsSplyPoolCd() {
        return this.apsSplyPoolCd;
    }
    
    public void setApsSplyPoolCd(String apsSplyPoolCd) {
        this.apsSplyPoolCd = apsSplyPoolCd;
    }


    @Column(name="APS_SPLY_SUB_POOL_CD", nullable=false, length=20)
    public String getApsSplySubPoolCd() {
        return this.apsSplySubPoolCd;
    }
    
    public void setApsSplySubPoolCd(String apsSplySubPoolCd) {
        this.apsSplySubPoolCd = apsSplySubPoolCd;
    }


    @Column(name="IC_CATEGORY_NBR", nullable=false, precision=9, scale=0)
    public int getIcCategoryNbr() {
        return this.icCategoryNbr;
    }
    
    public void setIcCategoryNbr(int icCategoryNbr) {
        this.icCategoryNbr = icCategoryNbr;
    }


    @Column(name="PO_CANCEL_CD", length=8)
    public String getPoCancelCd() {
        return this.poCancelCd;
    }
    
    public void setPoCancelCd(String poCancelCd) {
        this.poCancelCd = poCancelCd;
    }


    @Column(name="LINE_CANCEL_CD", length=8)
    public String getLineCancelCd() {
        return this.lineCancelCd;
    }
    
    public void setLineCancelCd(String lineCancelCd) {
        this.lineCancelCd = lineCancelCd;
    }


    @Column(name="SCHED_CANCEL_CD", length=8)
    public String getSchedCancelCd() {
        return this.schedCancelCd;
    }
    
    public void setSchedCancelCd(String schedCancelCd) {
        this.schedCancelCd = schedCancelCd;
    }


    @Column(name="REQR_MFR_FLG", nullable=false, length=1)
    public String getReqrMfrFlg() {
        return this.reqrMfrFlg;
    }
    
    public void setReqrMfrFlg(String reqrMfrFlg) {
        this.reqrMfrFlg = reqrMfrFlg;
    }


    @Column(name="STD_COST", precision=17, scale=6)
    public BigDecimal getStdCost() {
        return this.stdCost;
    }
    
    public void setStdCost(BigDecimal stdCost) {
        this.stdCost = stdCost;
    }


    @Column(name="LIST_PRICE", precision=17, scale=6)
    public BigDecimal getListPrice() {
        return this.listPrice;
    }
    
    public void setListPrice(BigDecimal listPrice) {
        this.listPrice = listPrice;
    }


    @Column(name="INDIV_NBR_BUY", nullable=false, precision=9, scale=0)
    public int getIndivNbrBuy() {
        return this.indivNbrBuy;
    }
    
    public void setIndivNbrBuy(int indivNbrBuy) {
        this.indivNbrBuy = indivNbrBuy;
    }


    @Column(name="INDIV_NM_SELLER", length=45)
    public String getIndivNmSeller() {
        return this.indivNmSeller;
    }
    
    public void setIndivNmSeller(String indivNmSeller) {
        this.indivNmSeller = indivNmSeller;
    }


    @Column(name="SELLER_PHN_NBR", length=20)
    public String getSellerPhnNbr() {
        return this.sellerPhnNbr;
    }
    
    public void setSellerPhnNbr(String sellerPhnNbr) {
        this.sellerPhnNbr = sellerPhnNbr;
    }


    @Column(name="SELLER_EMAIL_ADDR", length=40)
    public String getSellerEmailAddr() {
        return this.sellerEmailAddr;
    }
    
    public void setSellerEmailAddr(String sellerEmailAddr) {
        this.sellerEmailAddr = sellerEmailAddr;
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


    @Column(name="ORD_STAT_ID", nullable=false, length=1)
    public String getOrdStatId() {
        return this.ordStatId;
    }
    
    public void setOrdStatId(String ordStatId) {
        this.ordStatId = ordStatId;
    }


    @Column(name="LOT_MANUFACTURE_AFTER_DT", length=7)
    public Date getLotManufactureAfterDt() {
        return this.lotManufactureAfterDt;
    }
    
    public void setLotManufactureAfterDt(Date lotManufactureAfterDt) {
        this.lotManufactureAfterDt = lotManufactureAfterDt;
    }


    @Column(name="LOT_NOT_EXPIRE_BEFORE_DT", length=7)
    public Date getLotNotExpireBeforeDt() {
        return this.lotNotExpireBeforeDt;
    }
    
    public void setLotNotExpireBeforeDt(Date lotNotExpireBeforeDt) {
        this.lotNotExpireBeforeDt = lotNotExpireBeforeDt;
    }


    @Column(name="APS_AVAIL_DT", nullable=false, length=7)
    public Date getApsAvailDt() {
        return this.apsAvailDt;
    }
    
    public void setApsAvailDt(Date apsAvailDt) {
        this.apsAvailDt = apsAvailDt;
    }


    @Column(name="BUY_REASON_CD", length=8)
    public String getBuyReasonCd() {
        return this.buyReasonCd;
    }
    
    public void setBuyReasonCd(String buyReasonCd) {
        this.buyReasonCd = buyReasonCd;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PoOrdDtlId) ) return false;
		 PoOrdDtlId castOther = ( PoOrdDtlId ) other; 
         
		 return (this.getPoLineDtlNbr()==castOther.getPoLineDtlNbr())
 && (this.getPoOrdHdrNbr()==castOther.getPoOrdHdrNbr())
 && (this.getPoLineHdrNbr()==castOther.getPoLineHdrNbr())
 && (this.getPoLineNbr()==castOther.getPoLineNbr())
 && ( (this.getPoCd()==castOther.getPoCd()) || ( this.getPoCd()!=null && castOther.getPoCd()!=null && this.getPoCd().equals(castOther.getPoCd()) ) )
 && ( (this.getPoDt()==castOther.getPoDt()) || ( this.getPoDt()!=null && castOther.getPoDt()!=null && this.getPoDt().equals(castOther.getPoDt()) ) )
 && ( (this.getVndrOrdCd()==castOther.getVndrOrdCd()) || ( this.getVndrOrdCd()!=null && castOther.getVndrOrdCd()!=null && this.getVndrOrdCd().equals(castOther.getVndrOrdCd()) ) )
 && ( (this.getCurrCd()==castOther.getCurrCd()) || ( this.getCurrCd()!=null && castOther.getCurrCd()!=null && this.getCurrCd().equals(castOther.getCurrCd()) ) )
 && ( (this.getTrdFlg()==castOther.getTrdFlg()) || ( this.getTrdFlg()!=null && castOther.getTrdFlg()!=null && this.getTrdFlg().equals(castOther.getTrdFlg()) ) )
 && (this.getOrgNbrVnd()==castOther.getOrgNbrVnd())
 && ( (this.getOrgCdVnd()==castOther.getOrgCdVnd()) || ( this.getOrgCdVnd()!=null && castOther.getOrgCdVnd()!=null && this.getOrgCdVnd().equals(castOther.getOrgCdVnd()) ) )
 && ( (this.getOrgNmVnd()==castOther.getOrgNmVnd()) || ( this.getOrgNmVnd()!=null && castOther.getOrgNmVnd()!=null && this.getOrgNmVnd().equals(castOther.getOrgNmVnd()) ) )
 && ( (this.getVndrOrdLineCd()==castOther.getVndrOrdLineCd()) || ( this.getVndrOrdLineCd()!=null && castOther.getVndrOrdLineCd()!=null && this.getVndrOrdLineCd().equals(castOther.getVndrOrdLineCd()) ) )
 && ( (this.getReplenQty()==castOther.getReplenQty()) || ( this.getReplenQty()!=null && castOther.getReplenQty()!=null && this.getReplenQty().equals(castOther.getReplenQty()) ) )
 && ( (this.getUnitCost()==castOther.getUnitCost()) || ( this.getUnitCost()!=null && castOther.getUnitCost()!=null && this.getUnitCost().equals(castOther.getUnitCost()) ) )
 && ( (this.getUnitCostDenom()==castOther.getUnitCostDenom()) || ( this.getUnitCostDenom()!=null && castOther.getUnitCostDenom()!=null && this.getUnitCostDenom().equals(castOther.getUnitCostDenom()) ) )
 && ( (this.getSchedQty()==castOther.getSchedQty()) || ( this.getSchedQty()!=null && castOther.getSchedQty()!=null && this.getSchedQty().equals(castOther.getSchedQty()) ) )
 && (this.getItemNbr()==castOther.getItemNbr())
 && ( (this.getItemCd()==castOther.getItemCd()) || ( this.getItemCd()!=null && castOther.getItemCd()!=null && this.getItemCd().equals(castOther.getItemCd()) ) )
 && ( (this.getItemDescr()==castOther.getItemDescr()) || ( this.getItemDescr()!=null && castOther.getItemDescr()!=null && this.getItemDescr().equals(castOther.getItemDescr()) ) )
 && ( (this.getStkUm()==castOther.getStkUm()) || ( this.getStkUm()!=null && castOther.getStkUm()!=null && this.getStkUm().equals(castOther.getStkUm()) ) )
 && ( (this.getItemCdVnd()==castOther.getItemCdVnd()) || ( this.getItemCdVnd()!=null && castOther.getItemCdVnd()!=null && this.getItemCdVnd().equals(castOther.getItemCdVnd()) ) )
 && ( (this.getReplenUm()==castOther.getReplenUm()) || ( this.getReplenUm()!=null && castOther.getReplenUm()!=null && this.getReplenUm().equals(castOther.getReplenUm()) ) )
 && ( (this.getRecvQty()==castOther.getRecvQty()) || ( this.getRecvQty()!=null && castOther.getRecvQty()!=null && this.getRecvQty().equals(castOther.getRecvQty()) ) )
 && ( (this.getReplenEstShipDt()==castOther.getReplenEstShipDt()) || ( this.getReplenEstShipDt()!=null && castOther.getReplenEstShipDt()!=null && this.getReplenEstShipDt().equals(castOther.getReplenEstShipDt()) ) )
 && ( (this.getReplenRqstShipDt()==castOther.getReplenRqstShipDt()) || ( this.getReplenRqstShipDt()!=null && castOther.getReplenRqstShipDt()!=null && this.getReplenRqstShipDt().equals(castOther.getReplenRqstShipDt()) ) )
 && ( (this.getReplenCurrEstDt()==castOther.getReplenCurrEstDt()) || ( this.getReplenCurrEstDt()!=null && castOther.getReplenCurrEstDt()!=null && this.getReplenCurrEstDt().equals(castOther.getReplenCurrEstDt()) ) )
 && ( (this.getRevLvl()==castOther.getRevLvl()) || ( this.getRevLvl()!=null && castOther.getRevLvl()!=null && this.getRevLvl().equals(castOther.getRevLvl()) ) )
 && ( (this.getOrgNbrMfr()==castOther.getOrgNbrMfr()) || ( this.getOrgNbrMfr()!=null && castOther.getOrgNbrMfr()!=null && this.getOrgNbrMfr().equals(castOther.getOrgNbrMfr()) ) )
 && ( (this.getOrgCdMfr()==castOther.getOrgCdMfr()) || ( this.getOrgCdMfr()!=null && castOther.getOrgCdMfr()!=null && this.getOrgCdMfr().equals(castOther.getOrgCdMfr()) ) )
 && ( (this.getOrgNmMfr()==castOther.getOrgNmMfr()) || ( this.getOrgNmMfr()!=null && castOther.getOrgNmMfr()!=null && this.getOrgNmMfr().equals(castOther.getOrgNmMfr()) ) )
 && ( (this.getLineStatId()==castOther.getLineStatId()) || ( this.getLineStatId()!=null && castOther.getLineStatId()!=null && this.getLineStatId().equals(castOther.getLineStatId()) ) )
 && ( (this.getCntryCdOrigin()==castOther.getCntryCdOrigin()) || ( this.getCntryCdOrigin()!=null && castOther.getCntryCdOrigin()!=null && this.getCntryCdOrigin().equals(castOther.getCntryCdOrigin()) ) )
 && ( (this.getFacility()==castOther.getFacility()) || ( this.getFacility()!=null && castOther.getFacility()!=null && this.getFacility().equals(castOther.getFacility()) ) )
 && (this.getApsSplySubPoolNbr()==castOther.getApsSplySubPoolNbr())
 && ( (this.getShipViaCd()==castOther.getShipViaCd()) || ( this.getShipViaCd()!=null && castOther.getShipViaCd()!=null && this.getShipViaCd().equals(castOther.getShipViaCd()) ) )
 && (this.getShipToAddrNbr()==castOther.getShipToAddrNbr())
 && ( (this.getApsSplyPoolCd()==castOther.getApsSplyPoolCd()) || ( this.getApsSplyPoolCd()!=null && castOther.getApsSplyPoolCd()!=null && this.getApsSplyPoolCd().equals(castOther.getApsSplyPoolCd()) ) )
 && ( (this.getApsSplySubPoolCd()==castOther.getApsSplySubPoolCd()) || ( this.getApsSplySubPoolCd()!=null && castOther.getApsSplySubPoolCd()!=null && this.getApsSplySubPoolCd().equals(castOther.getApsSplySubPoolCd()) ) )
 && (this.getIcCategoryNbr()==castOther.getIcCategoryNbr())
 && ( (this.getPoCancelCd()==castOther.getPoCancelCd()) || ( this.getPoCancelCd()!=null && castOther.getPoCancelCd()!=null && this.getPoCancelCd().equals(castOther.getPoCancelCd()) ) )
 && ( (this.getLineCancelCd()==castOther.getLineCancelCd()) || ( this.getLineCancelCd()!=null && castOther.getLineCancelCd()!=null && this.getLineCancelCd().equals(castOther.getLineCancelCd()) ) )
 && ( (this.getSchedCancelCd()==castOther.getSchedCancelCd()) || ( this.getSchedCancelCd()!=null && castOther.getSchedCancelCd()!=null && this.getSchedCancelCd().equals(castOther.getSchedCancelCd()) ) )
 && ( (this.getReqrMfrFlg()==castOther.getReqrMfrFlg()) || ( this.getReqrMfrFlg()!=null && castOther.getReqrMfrFlg()!=null && this.getReqrMfrFlg().equals(castOther.getReqrMfrFlg()) ) )
 && ( (this.getStdCost()==castOther.getStdCost()) || ( this.getStdCost()!=null && castOther.getStdCost()!=null && this.getStdCost().equals(castOther.getStdCost()) ) )
 && ( (this.getListPrice()==castOther.getListPrice()) || ( this.getListPrice()!=null && castOther.getListPrice()!=null && this.getListPrice().equals(castOther.getListPrice()) ) )
 && (this.getIndivNbrBuy()==castOther.getIndivNbrBuy())
 && ( (this.getIndivNmSeller()==castOther.getIndivNmSeller()) || ( this.getIndivNmSeller()!=null && castOther.getIndivNmSeller()!=null && this.getIndivNmSeller().equals(castOther.getIndivNmSeller()) ) )
 && ( (this.getSellerPhnNbr()==castOther.getSellerPhnNbr()) || ( this.getSellerPhnNbr()!=null && castOther.getSellerPhnNbr()!=null && this.getSellerPhnNbr().equals(castOther.getSellerPhnNbr()) ) )
 && ( (this.getSellerEmailAddr()==castOther.getSellerEmailAddr()) || ( this.getSellerEmailAddr()!=null && castOther.getSellerEmailAddr()!=null && this.getSellerEmailAddr().equals(castOther.getSellerEmailAddr()) ) )
 && ( (this.getSchedQtyStkUm()==castOther.getSchedQtyStkUm()) || ( this.getSchedQtyStkUm()!=null && castOther.getSchedQtyStkUm()!=null && this.getSchedQtyStkUm().equals(castOther.getSchedQtyStkUm()) ) )
 && ( (this.getRecvQtyStkUm()==castOther.getRecvQtyStkUm()) || ( this.getRecvQtyStkUm()!=null && castOther.getRecvQtyStkUm()!=null && this.getRecvQtyStkUm().equals(castOther.getRecvQtyStkUm()) ) )
 && ( (this.getUnitCostStkUm()==castOther.getUnitCostStkUm()) || ( this.getUnitCostStkUm()!=null && castOther.getUnitCostStkUm()!=null && this.getUnitCostStkUm().equals(castOther.getUnitCostStkUm()) ) )
 && ( (this.getUnitCostDenomStkUm()==castOther.getUnitCostDenomStkUm()) || ( this.getUnitCostDenomStkUm()!=null && castOther.getUnitCostDenomStkUm()!=null && this.getUnitCostDenomStkUm().equals(castOther.getUnitCostDenomStkUm()) ) )
 && ( (this.getOrdStatId()==castOther.getOrdStatId()) || ( this.getOrdStatId()!=null && castOther.getOrdStatId()!=null && this.getOrdStatId().equals(castOther.getOrdStatId()) ) )
 && ( (this.getLotManufactureAfterDt()==castOther.getLotManufactureAfterDt()) || ( this.getLotManufactureAfterDt()!=null && castOther.getLotManufactureAfterDt()!=null && this.getLotManufactureAfterDt().equals(castOther.getLotManufactureAfterDt()) ) )
 && ( (this.getLotNotExpireBeforeDt()==castOther.getLotNotExpireBeforeDt()) || ( this.getLotNotExpireBeforeDt()!=null && castOther.getLotNotExpireBeforeDt()!=null && this.getLotNotExpireBeforeDt().equals(castOther.getLotNotExpireBeforeDt()) ) )
 && ( (this.getApsAvailDt()==castOther.getApsAvailDt()) || ( this.getApsAvailDt()!=null && castOther.getApsAvailDt()!=null && this.getApsAvailDt().equals(castOther.getApsAvailDt()) ) )
 && ( (this.getBuyReasonCd()==castOther.getBuyReasonCd()) || ( this.getBuyReasonCd()!=null && castOther.getBuyReasonCd()!=null && this.getBuyReasonCd().equals(castOther.getBuyReasonCd()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getPoLineDtlNbr();
         result = 37 * result + this.getPoOrdHdrNbr();
         result = 37 * result + this.getPoLineHdrNbr();
         result = 37 * result + this.getPoLineNbr();
         result = 37 * result + ( getPoCd() == null ? 0 : this.getPoCd().hashCode() );
         result = 37 * result + ( getPoDt() == null ? 0 : this.getPoDt().hashCode() );
         result = 37 * result + ( getVndrOrdCd() == null ? 0 : this.getVndrOrdCd().hashCode() );
         result = 37 * result + ( getCurrCd() == null ? 0 : this.getCurrCd().hashCode() );
         result = 37 * result + ( getTrdFlg() == null ? 0 : this.getTrdFlg().hashCode() );
         result = 37 * result + this.getOrgNbrVnd();
         result = 37 * result + ( getOrgCdVnd() == null ? 0 : this.getOrgCdVnd().hashCode() );
         result = 37 * result + ( getOrgNmVnd() == null ? 0 : this.getOrgNmVnd().hashCode() );
         result = 37 * result + ( getVndrOrdLineCd() == null ? 0 : this.getVndrOrdLineCd().hashCode() );
         result = 37 * result + ( getReplenQty() == null ? 0 : this.getReplenQty().hashCode() );
         result = 37 * result + ( getUnitCost() == null ? 0 : this.getUnitCost().hashCode() );
         result = 37 * result + ( getUnitCostDenom() == null ? 0 : this.getUnitCostDenom().hashCode() );
         result = 37 * result + ( getSchedQty() == null ? 0 : this.getSchedQty().hashCode() );
         result = 37 * result + this.getItemNbr();
         result = 37 * result + ( getItemCd() == null ? 0 : this.getItemCd().hashCode() );
         result = 37 * result + ( getItemDescr() == null ? 0 : this.getItemDescr().hashCode() );
         result = 37 * result + ( getStkUm() == null ? 0 : this.getStkUm().hashCode() );
         result = 37 * result + ( getItemCdVnd() == null ? 0 : this.getItemCdVnd().hashCode() );
         result = 37 * result + ( getReplenUm() == null ? 0 : this.getReplenUm().hashCode() );
         result = 37 * result + ( getRecvQty() == null ? 0 : this.getRecvQty().hashCode() );
         result = 37 * result + ( getReplenEstShipDt() == null ? 0 : this.getReplenEstShipDt().hashCode() );
         result = 37 * result + ( getReplenRqstShipDt() == null ? 0 : this.getReplenRqstShipDt().hashCode() );
         result = 37 * result + ( getReplenCurrEstDt() == null ? 0 : this.getReplenCurrEstDt().hashCode() );
         result = 37 * result + ( getRevLvl() == null ? 0 : this.getRevLvl().hashCode() );
         result = 37 * result + ( getOrgNbrMfr() == null ? 0 : this.getOrgNbrMfr().hashCode() );
         result = 37 * result + ( getOrgCdMfr() == null ? 0 : this.getOrgCdMfr().hashCode() );
         result = 37 * result + ( getOrgNmMfr() == null ? 0 : this.getOrgNmMfr().hashCode() );
         result = 37 * result + ( getLineStatId() == null ? 0 : this.getLineStatId().hashCode() );
         result = 37 * result + ( getCntryCdOrigin() == null ? 0 : this.getCntryCdOrigin().hashCode() );
         result = 37 * result + ( getFacility() == null ? 0 : this.getFacility().hashCode() );
         result = 37 * result + this.getApsSplySubPoolNbr();
         result = 37 * result + ( getShipViaCd() == null ? 0 : this.getShipViaCd().hashCode() );
         result = 37 * result + this.getShipToAddrNbr();
         result = 37 * result + ( getApsSplyPoolCd() == null ? 0 : this.getApsSplyPoolCd().hashCode() );
         result = 37 * result + ( getApsSplySubPoolCd() == null ? 0 : this.getApsSplySubPoolCd().hashCode() );
         result = 37 * result + this.getIcCategoryNbr();
         result = 37 * result + ( getPoCancelCd() == null ? 0 : this.getPoCancelCd().hashCode() );
         result = 37 * result + ( getLineCancelCd() == null ? 0 : this.getLineCancelCd().hashCode() );
         result = 37 * result + ( getSchedCancelCd() == null ? 0 : this.getSchedCancelCd().hashCode() );
         result = 37 * result + ( getReqrMfrFlg() == null ? 0 : this.getReqrMfrFlg().hashCode() );
         result = 37 * result + ( getStdCost() == null ? 0 : this.getStdCost().hashCode() );
         result = 37 * result + ( getListPrice() == null ? 0 : this.getListPrice().hashCode() );
         result = 37 * result + this.getIndivNbrBuy();
         result = 37 * result + ( getIndivNmSeller() == null ? 0 : this.getIndivNmSeller().hashCode() );
         result = 37 * result + ( getSellerPhnNbr() == null ? 0 : this.getSellerPhnNbr().hashCode() );
         result = 37 * result + ( getSellerEmailAddr() == null ? 0 : this.getSellerEmailAddr().hashCode() );
         result = 37 * result + ( getSchedQtyStkUm() == null ? 0 : this.getSchedQtyStkUm().hashCode() );
         result = 37 * result + ( getRecvQtyStkUm() == null ? 0 : this.getRecvQtyStkUm().hashCode() );
         result = 37 * result + ( getUnitCostStkUm() == null ? 0 : this.getUnitCostStkUm().hashCode() );
         result = 37 * result + ( getUnitCostDenomStkUm() == null ? 0 : this.getUnitCostDenomStkUm().hashCode() );
         result = 37 * result + ( getOrdStatId() == null ? 0 : this.getOrdStatId().hashCode() );
         result = 37 * result + ( getLotManufactureAfterDt() == null ? 0 : this.getLotManufactureAfterDt().hashCode() );
         result = 37 * result + ( getLotNotExpireBeforeDt() == null ? 0 : this.getLotNotExpireBeforeDt().hashCode() );
         result = 37 * result + ( getApsAvailDt() == null ? 0 : this.getApsAvailDt().hashCode() );
         result = 37 * result + ( getBuyReasonCd() == null ? 0 : this.getBuyReasonCd().hashCode() );
         return result;
   }   


}

