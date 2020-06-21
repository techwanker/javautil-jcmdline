package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * WhPickDtlTransRqstExtVwId generated by hbm2java
 */
@Embeddable
public class WhPickDtlTransRqstExtVwId  implements java.io.Serializable {


     private int whPickDtlTransRqstNbr;
     private int whPickBatchTransNbr;
     private Integer icItemLocNbr;
     private String boxCd;
     private BigDecimal transPickQtyRqst;
     private BigDecimal transPickQtyAct;
     private int whFacilityTransOnhandNbr;
     private Integer whPickDtlTransRqstNbrSrc;
     private String boxCdDest;
     private Integer boxCnt;
     private String pickScanCd;
     private String itemCd;
     private String itemDescr;
     private int binNbr;
     private String binCd;
     private String facility;
     private Integer whWhseZoneNbr;
     private int itemNbr;
     private Integer orgNbrMfr;
     private String mfrLotCd;
     private int apsSplySubPoolNbr;
     private String boxStatId;
     private int lotNbr;
     private String revLvl;
     private String lotCostUm;
     private String mfrSerialCd;
     private String serialCd;
     private Integer walkSeq;
     private String facilitySrc;
     private String facilityDest;
     private int apsSplySubPoolNbrSrc;
     private int apsSplySubPoolNbrDest;
     private BigDecimal qtyRqst;
     private Date rqstDt;
     private String upcCd;
     private String ean;
     private String pickScanId;
     private String splitAtBinFlg;
     private BigDecimal qtyPerBox;

    public WhPickDtlTransRqstExtVwId() {
    }

	
    public WhPickDtlTransRqstExtVwId(int whPickDtlTransRqstNbr, int whPickBatchTransNbr, BigDecimal transPickQtyRqst, int whFacilityTransOnhandNbr, String itemCd, String itemDescr, int binNbr, String binCd, String facility, int itemNbr, int apsSplySubPoolNbr, String boxStatId, int lotNbr, String lotCostUm, String facilitySrc, String facilityDest, int apsSplySubPoolNbrSrc, int apsSplySubPoolNbrDest, BigDecimal qtyRqst, Date rqstDt, String pickScanId, String splitAtBinFlg) {
        this.whPickDtlTransRqstNbr = whPickDtlTransRqstNbr;
        this.whPickBatchTransNbr = whPickBatchTransNbr;
        this.transPickQtyRqst = transPickQtyRqst;
        this.whFacilityTransOnhandNbr = whFacilityTransOnhandNbr;
        this.itemCd = itemCd;
        this.itemDescr = itemDescr;
        this.binNbr = binNbr;
        this.binCd = binCd;
        this.facility = facility;
        this.itemNbr = itemNbr;
        this.apsSplySubPoolNbr = apsSplySubPoolNbr;
        this.boxStatId = boxStatId;
        this.lotNbr = lotNbr;
        this.lotCostUm = lotCostUm;
        this.facilitySrc = facilitySrc;
        this.facilityDest = facilityDest;
        this.apsSplySubPoolNbrSrc = apsSplySubPoolNbrSrc;
        this.apsSplySubPoolNbrDest = apsSplySubPoolNbrDest;
        this.qtyRqst = qtyRqst;
        this.rqstDt = rqstDt;
        this.pickScanId = pickScanId;
        this.splitAtBinFlg = splitAtBinFlg;
    }
    public WhPickDtlTransRqstExtVwId(int whPickDtlTransRqstNbr, int whPickBatchTransNbr, Integer icItemLocNbr, String boxCd, BigDecimal transPickQtyRqst, BigDecimal transPickQtyAct, int whFacilityTransOnhandNbr, Integer whPickDtlTransRqstNbrSrc, String boxCdDest, Integer boxCnt, String pickScanCd, String itemCd, String itemDescr, int binNbr, String binCd, String facility, Integer whWhseZoneNbr, int itemNbr, Integer orgNbrMfr, String mfrLotCd, int apsSplySubPoolNbr, String boxStatId, int lotNbr, String revLvl, String lotCostUm, String mfrSerialCd, String serialCd, Integer walkSeq, String facilitySrc, String facilityDest, int apsSplySubPoolNbrSrc, int apsSplySubPoolNbrDest, BigDecimal qtyRqst, Date rqstDt, String upcCd, String ean, String pickScanId, String splitAtBinFlg, BigDecimal qtyPerBox) {
       this.whPickDtlTransRqstNbr = whPickDtlTransRqstNbr;
       this.whPickBatchTransNbr = whPickBatchTransNbr;
       this.icItemLocNbr = icItemLocNbr;
       this.boxCd = boxCd;
       this.transPickQtyRqst = transPickQtyRqst;
       this.transPickQtyAct = transPickQtyAct;
       this.whFacilityTransOnhandNbr = whFacilityTransOnhandNbr;
       this.whPickDtlTransRqstNbrSrc = whPickDtlTransRqstNbrSrc;
       this.boxCdDest = boxCdDest;
       this.boxCnt = boxCnt;
       this.pickScanCd = pickScanCd;
       this.itemCd = itemCd;
       this.itemDescr = itemDescr;
       this.binNbr = binNbr;
       this.binCd = binCd;
       this.facility = facility;
       this.whWhseZoneNbr = whWhseZoneNbr;
       this.itemNbr = itemNbr;
       this.orgNbrMfr = orgNbrMfr;
       this.mfrLotCd = mfrLotCd;
       this.apsSplySubPoolNbr = apsSplySubPoolNbr;
       this.boxStatId = boxStatId;
       this.lotNbr = lotNbr;
       this.revLvl = revLvl;
       this.lotCostUm = lotCostUm;
       this.mfrSerialCd = mfrSerialCd;
       this.serialCd = serialCd;
       this.walkSeq = walkSeq;
       this.facilitySrc = facilitySrc;
       this.facilityDest = facilityDest;
       this.apsSplySubPoolNbrSrc = apsSplySubPoolNbrSrc;
       this.apsSplySubPoolNbrDest = apsSplySubPoolNbrDest;
       this.qtyRqst = qtyRqst;
       this.rqstDt = rqstDt;
       this.upcCd = upcCd;
       this.ean = ean;
       this.pickScanId = pickScanId;
       this.splitAtBinFlg = splitAtBinFlg;
       this.qtyPerBox = qtyPerBox;
    }
   


    @Column(name="WH_PICK_DTL_TRANS_RQST_NBR", nullable=false, precision=9, scale=0)
    public int getWhPickDtlTransRqstNbr() {
        return this.whPickDtlTransRqstNbr;
    }
    
    public void setWhPickDtlTransRqstNbr(int whPickDtlTransRqstNbr) {
        this.whPickDtlTransRqstNbr = whPickDtlTransRqstNbr;
    }


    @Column(name="WH_PICK_BATCH_TRANS_NBR", nullable=false, precision=9, scale=0)
    public int getWhPickBatchTransNbr() {
        return this.whPickBatchTransNbr;
    }
    
    public void setWhPickBatchTransNbr(int whPickBatchTransNbr) {
        this.whPickBatchTransNbr = whPickBatchTransNbr;
    }


    @Column(name="IC_ITEM_LOC_NBR", precision=9, scale=0)
    public Integer getIcItemLocNbr() {
        return this.icItemLocNbr;
    }
    
    public void setIcItemLocNbr(Integer icItemLocNbr) {
        this.icItemLocNbr = icItemLocNbr;
    }


    @Column(name="BOX_CD", length=20)
    public String getBoxCd() {
        return this.boxCd;
    }
    
    public void setBoxCd(String boxCd) {
        this.boxCd = boxCd;
    }


    @Column(name="TRANS_PICK_QTY_RQST", nullable=false, precision=13, scale=5)
    public BigDecimal getTransPickQtyRqst() {
        return this.transPickQtyRqst;
    }
    
    public void setTransPickQtyRqst(BigDecimal transPickQtyRqst) {
        this.transPickQtyRqst = transPickQtyRqst;
    }


    @Column(name="TRANS_PICK_QTY_ACT", precision=13, scale=5)
    public BigDecimal getTransPickQtyAct() {
        return this.transPickQtyAct;
    }
    
    public void setTransPickQtyAct(BigDecimal transPickQtyAct) {
        this.transPickQtyAct = transPickQtyAct;
    }


    @Column(name="WH_FACILITY_TRANS_ONHAND_NBR", nullable=false, precision=9, scale=0)
    public int getWhFacilityTransOnhandNbr() {
        return this.whFacilityTransOnhandNbr;
    }
    
    public void setWhFacilityTransOnhandNbr(int whFacilityTransOnhandNbr) {
        this.whFacilityTransOnhandNbr = whFacilityTransOnhandNbr;
    }


    @Column(name="WH_PICK_DTL_TRANS_RQST_NBR_SRC", precision=9, scale=0)
    public Integer getWhPickDtlTransRqstNbrSrc() {
        return this.whPickDtlTransRqstNbrSrc;
    }
    
    public void setWhPickDtlTransRqstNbrSrc(Integer whPickDtlTransRqstNbrSrc) {
        this.whPickDtlTransRqstNbrSrc = whPickDtlTransRqstNbrSrc;
    }


    @Column(name="BOX_CD_DEST", length=20)
    public String getBoxCdDest() {
        return this.boxCdDest;
    }
    
    public void setBoxCdDest(String boxCdDest) {
        this.boxCdDest = boxCdDest;
    }


    @Column(name="BOX_CNT", precision=5, scale=0)
    public Integer getBoxCnt() {
        return this.boxCnt;
    }
    
    public void setBoxCnt(Integer boxCnt) {
        this.boxCnt = boxCnt;
    }


    @Column(name="PICK_SCAN_CD", length=20)
    public String getPickScanCd() {
        return this.pickScanCd;
    }
    
    public void setPickScanCd(String pickScanCd) {
        this.pickScanCd = pickScanCd;
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


    @Column(name="BIN_NBR", nullable=false, precision=9, scale=0)
    public int getBinNbr() {
        return this.binNbr;
    }
    
    public void setBinNbr(int binNbr) {
        this.binNbr = binNbr;
    }


    @Column(name="BIN_CD", nullable=false, length=16)
    public String getBinCd() {
        return this.binCd;
    }
    
    public void setBinCd(String binCd) {
        this.binCd = binCd;
    }


    @Column(name="FACILITY", nullable=false, length=16)
    public String getFacility() {
        return this.facility;
    }
    
    public void setFacility(String facility) {
        this.facility = facility;
    }


    @Column(name="WH_WHSE_ZONE_NBR", precision=9, scale=0)
    public Integer getWhWhseZoneNbr() {
        return this.whWhseZoneNbr;
    }
    
    public void setWhWhseZoneNbr(Integer whWhseZoneNbr) {
        this.whWhseZoneNbr = whWhseZoneNbr;
    }


    @Column(name="ITEM_NBR", nullable=false, precision=9, scale=0)
    public int getItemNbr() {
        return this.itemNbr;
    }
    
    public void setItemNbr(int itemNbr) {
        this.itemNbr = itemNbr;
    }


    @Column(name="ORG_NBR_MFR", precision=9, scale=0)
    public Integer getOrgNbrMfr() {
        return this.orgNbrMfr;
    }
    
    public void setOrgNbrMfr(Integer orgNbrMfr) {
        this.orgNbrMfr = orgNbrMfr;
    }


    @Column(name="MFR_LOT_CD", length=20)
    public String getMfrLotCd() {
        return this.mfrLotCd;
    }
    
    public void setMfrLotCd(String mfrLotCd) {
        this.mfrLotCd = mfrLotCd;
    }


    @Column(name="APS_SPLY_SUB_POOL_NBR", nullable=false, precision=9, scale=0)
    public int getApsSplySubPoolNbr() {
        return this.apsSplySubPoolNbr;
    }
    
    public void setApsSplySubPoolNbr(int apsSplySubPoolNbr) {
        this.apsSplySubPoolNbr = apsSplySubPoolNbr;
    }


    @Column(name="BOX_STAT_ID", nullable=false, length=3)
    public String getBoxStatId() {
        return this.boxStatId;
    }
    
    public void setBoxStatId(String boxStatId) {
        this.boxStatId = boxStatId;
    }


    @Column(name="LOT_NBR", nullable=false, precision=9, scale=0)
    public int getLotNbr() {
        return this.lotNbr;
    }
    
    public void setLotNbr(int lotNbr) {
        this.lotNbr = lotNbr;
    }


    @Column(name="REV_LVL", length=5)
    public String getRevLvl() {
        return this.revLvl;
    }
    
    public void setRevLvl(String revLvl) {
        this.revLvl = revLvl;
    }


    @Column(name="LOT_COST_UM", nullable=false, length=3)
    public String getLotCostUm() {
        return this.lotCostUm;
    }
    
    public void setLotCostUm(String lotCostUm) {
        this.lotCostUm = lotCostUm;
    }


    @Column(name="MFR_SERIAL_CD", length=20)
    public String getMfrSerialCd() {
        return this.mfrSerialCd;
    }
    
    public void setMfrSerialCd(String mfrSerialCd) {
        this.mfrSerialCd = mfrSerialCd;
    }


    @Column(name="SERIAL_CD", length=20)
    public String getSerialCd() {
        return this.serialCd;
    }
    
    public void setSerialCd(String serialCd) {
        this.serialCd = serialCd;
    }


    @Column(name="WALK_SEQ", precision=5, scale=0)
    public Integer getWalkSeq() {
        return this.walkSeq;
    }
    
    public void setWalkSeq(Integer walkSeq) {
        this.walkSeq = walkSeq;
    }


    @Column(name="FACILITY_SRC", nullable=false, length=16)
    public String getFacilitySrc() {
        return this.facilitySrc;
    }
    
    public void setFacilitySrc(String facilitySrc) {
        this.facilitySrc = facilitySrc;
    }


    @Column(name="FACILITY_DEST", nullable=false, length=16)
    public String getFacilityDest() {
        return this.facilityDest;
    }
    
    public void setFacilityDest(String facilityDest) {
        this.facilityDest = facilityDest;
    }


    @Column(name="APS_SPLY_SUB_POOL_NBR_SRC", nullable=false, precision=9, scale=0)
    public int getApsSplySubPoolNbrSrc() {
        return this.apsSplySubPoolNbrSrc;
    }
    
    public void setApsSplySubPoolNbrSrc(int apsSplySubPoolNbrSrc) {
        this.apsSplySubPoolNbrSrc = apsSplySubPoolNbrSrc;
    }


    @Column(name="APS_SPLY_SUB_POOL_NBR_DEST", nullable=false, precision=9, scale=0)
    public int getApsSplySubPoolNbrDest() {
        return this.apsSplySubPoolNbrDest;
    }
    
    public void setApsSplySubPoolNbrDest(int apsSplySubPoolNbrDest) {
        this.apsSplySubPoolNbrDest = apsSplySubPoolNbrDest;
    }


    @Column(name="QTY_RQST", nullable=false, precision=13, scale=5)
    public BigDecimal getQtyRqst() {
        return this.qtyRqst;
    }
    
    public void setQtyRqst(BigDecimal qtyRqst) {
        this.qtyRqst = qtyRqst;
    }


    @Column(name="RQST_DT", nullable=false, length=7)
    public Date getRqstDt() {
        return this.rqstDt;
    }
    
    public void setRqstDt(Date rqstDt) {
        this.rqstDt = rqstDt;
    }


    @Column(name="UPC_CD", length=20)
    public String getUpcCd() {
        return this.upcCd;
    }
    
    public void setUpcCd(String upcCd) {
        this.upcCd = upcCd;
    }


    @Column(name="EAN", length=50)
    public String getEan() {
        return this.ean;
    }
    
    public void setEan(String ean) {
        this.ean = ean;
    }


    @Column(name="PICK_SCAN_ID", nullable=false, length=1)
    public String getPickScanId() {
        return this.pickScanId;
    }
    
    public void setPickScanId(String pickScanId) {
        this.pickScanId = pickScanId;
    }


    @Column(name="SPLIT_AT_BIN_FLG", nullable=false, length=1)
    public String getSplitAtBinFlg() {
        return this.splitAtBinFlg;
    }
    
    public void setSplitAtBinFlg(String splitAtBinFlg) {
        this.splitAtBinFlg = splitAtBinFlg;
    }


    @Column(name="QTY_PER_BOX", precision=22, scale=0)
    public BigDecimal getQtyPerBox() {
        return this.qtyPerBox;
    }
    
    public void setQtyPerBox(BigDecimal qtyPerBox) {
        this.qtyPerBox = qtyPerBox;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof WhPickDtlTransRqstExtVwId) ) return false;
		 WhPickDtlTransRqstExtVwId castOther = ( WhPickDtlTransRqstExtVwId ) other; 
         
		 return (this.getWhPickDtlTransRqstNbr()==castOther.getWhPickDtlTransRqstNbr())
 && (this.getWhPickBatchTransNbr()==castOther.getWhPickBatchTransNbr())
 && ( (this.getIcItemLocNbr()==castOther.getIcItemLocNbr()) || ( this.getIcItemLocNbr()!=null && castOther.getIcItemLocNbr()!=null && this.getIcItemLocNbr().equals(castOther.getIcItemLocNbr()) ) )
 && ( (this.getBoxCd()==castOther.getBoxCd()) || ( this.getBoxCd()!=null && castOther.getBoxCd()!=null && this.getBoxCd().equals(castOther.getBoxCd()) ) )
 && ( (this.getTransPickQtyRqst()==castOther.getTransPickQtyRqst()) || ( this.getTransPickQtyRqst()!=null && castOther.getTransPickQtyRqst()!=null && this.getTransPickQtyRqst().equals(castOther.getTransPickQtyRqst()) ) )
 && ( (this.getTransPickQtyAct()==castOther.getTransPickQtyAct()) || ( this.getTransPickQtyAct()!=null && castOther.getTransPickQtyAct()!=null && this.getTransPickQtyAct().equals(castOther.getTransPickQtyAct()) ) )
 && (this.getWhFacilityTransOnhandNbr()==castOther.getWhFacilityTransOnhandNbr())
 && ( (this.getWhPickDtlTransRqstNbrSrc()==castOther.getWhPickDtlTransRqstNbrSrc()) || ( this.getWhPickDtlTransRqstNbrSrc()!=null && castOther.getWhPickDtlTransRqstNbrSrc()!=null && this.getWhPickDtlTransRqstNbrSrc().equals(castOther.getWhPickDtlTransRqstNbrSrc()) ) )
 && ( (this.getBoxCdDest()==castOther.getBoxCdDest()) || ( this.getBoxCdDest()!=null && castOther.getBoxCdDest()!=null && this.getBoxCdDest().equals(castOther.getBoxCdDest()) ) )
 && ( (this.getBoxCnt()==castOther.getBoxCnt()) || ( this.getBoxCnt()!=null && castOther.getBoxCnt()!=null && this.getBoxCnt().equals(castOther.getBoxCnt()) ) )
 && ( (this.getPickScanCd()==castOther.getPickScanCd()) || ( this.getPickScanCd()!=null && castOther.getPickScanCd()!=null && this.getPickScanCd().equals(castOther.getPickScanCd()) ) )
 && ( (this.getItemCd()==castOther.getItemCd()) || ( this.getItemCd()!=null && castOther.getItemCd()!=null && this.getItemCd().equals(castOther.getItemCd()) ) )
 && ( (this.getItemDescr()==castOther.getItemDescr()) || ( this.getItemDescr()!=null && castOther.getItemDescr()!=null && this.getItemDescr().equals(castOther.getItemDescr()) ) )
 && (this.getBinNbr()==castOther.getBinNbr())
 && ( (this.getBinCd()==castOther.getBinCd()) || ( this.getBinCd()!=null && castOther.getBinCd()!=null && this.getBinCd().equals(castOther.getBinCd()) ) )
 && ( (this.getFacility()==castOther.getFacility()) || ( this.getFacility()!=null && castOther.getFacility()!=null && this.getFacility().equals(castOther.getFacility()) ) )
 && ( (this.getWhWhseZoneNbr()==castOther.getWhWhseZoneNbr()) || ( this.getWhWhseZoneNbr()!=null && castOther.getWhWhseZoneNbr()!=null && this.getWhWhseZoneNbr().equals(castOther.getWhWhseZoneNbr()) ) )
 && (this.getItemNbr()==castOther.getItemNbr())
 && ( (this.getOrgNbrMfr()==castOther.getOrgNbrMfr()) || ( this.getOrgNbrMfr()!=null && castOther.getOrgNbrMfr()!=null && this.getOrgNbrMfr().equals(castOther.getOrgNbrMfr()) ) )
 && ( (this.getMfrLotCd()==castOther.getMfrLotCd()) || ( this.getMfrLotCd()!=null && castOther.getMfrLotCd()!=null && this.getMfrLotCd().equals(castOther.getMfrLotCd()) ) )
 && (this.getApsSplySubPoolNbr()==castOther.getApsSplySubPoolNbr())
 && ( (this.getBoxStatId()==castOther.getBoxStatId()) || ( this.getBoxStatId()!=null && castOther.getBoxStatId()!=null && this.getBoxStatId().equals(castOther.getBoxStatId()) ) )
 && (this.getLotNbr()==castOther.getLotNbr())
 && ( (this.getRevLvl()==castOther.getRevLvl()) || ( this.getRevLvl()!=null && castOther.getRevLvl()!=null && this.getRevLvl().equals(castOther.getRevLvl()) ) )
 && ( (this.getLotCostUm()==castOther.getLotCostUm()) || ( this.getLotCostUm()!=null && castOther.getLotCostUm()!=null && this.getLotCostUm().equals(castOther.getLotCostUm()) ) )
 && ( (this.getMfrSerialCd()==castOther.getMfrSerialCd()) || ( this.getMfrSerialCd()!=null && castOther.getMfrSerialCd()!=null && this.getMfrSerialCd().equals(castOther.getMfrSerialCd()) ) )
 && ( (this.getSerialCd()==castOther.getSerialCd()) || ( this.getSerialCd()!=null && castOther.getSerialCd()!=null && this.getSerialCd().equals(castOther.getSerialCd()) ) )
 && ( (this.getWalkSeq()==castOther.getWalkSeq()) || ( this.getWalkSeq()!=null && castOther.getWalkSeq()!=null && this.getWalkSeq().equals(castOther.getWalkSeq()) ) )
 && ( (this.getFacilitySrc()==castOther.getFacilitySrc()) || ( this.getFacilitySrc()!=null && castOther.getFacilitySrc()!=null && this.getFacilitySrc().equals(castOther.getFacilitySrc()) ) )
 && ( (this.getFacilityDest()==castOther.getFacilityDest()) || ( this.getFacilityDest()!=null && castOther.getFacilityDest()!=null && this.getFacilityDest().equals(castOther.getFacilityDest()) ) )
 && (this.getApsSplySubPoolNbrSrc()==castOther.getApsSplySubPoolNbrSrc())
 && (this.getApsSplySubPoolNbrDest()==castOther.getApsSplySubPoolNbrDest())
 && ( (this.getQtyRqst()==castOther.getQtyRqst()) || ( this.getQtyRqst()!=null && castOther.getQtyRqst()!=null && this.getQtyRqst().equals(castOther.getQtyRqst()) ) )
 && ( (this.getRqstDt()==castOther.getRqstDt()) || ( this.getRqstDt()!=null && castOther.getRqstDt()!=null && this.getRqstDt().equals(castOther.getRqstDt()) ) )
 && ( (this.getUpcCd()==castOther.getUpcCd()) || ( this.getUpcCd()!=null && castOther.getUpcCd()!=null && this.getUpcCd().equals(castOther.getUpcCd()) ) )
 && ( (this.getEan()==castOther.getEan()) || ( this.getEan()!=null && castOther.getEan()!=null && this.getEan().equals(castOther.getEan()) ) )
 && ( (this.getPickScanId()==castOther.getPickScanId()) || ( this.getPickScanId()!=null && castOther.getPickScanId()!=null && this.getPickScanId().equals(castOther.getPickScanId()) ) )
 && ( (this.getSplitAtBinFlg()==castOther.getSplitAtBinFlg()) || ( this.getSplitAtBinFlg()!=null && castOther.getSplitAtBinFlg()!=null && this.getSplitAtBinFlg().equals(castOther.getSplitAtBinFlg()) ) )
 && ( (this.getQtyPerBox()==castOther.getQtyPerBox()) || ( this.getQtyPerBox()!=null && castOther.getQtyPerBox()!=null && this.getQtyPerBox().equals(castOther.getQtyPerBox()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getWhPickDtlTransRqstNbr();
         result = 37 * result + this.getWhPickBatchTransNbr();
         result = 37 * result + ( getIcItemLocNbr() == null ? 0 : this.getIcItemLocNbr().hashCode() );
         result = 37 * result + ( getBoxCd() == null ? 0 : this.getBoxCd().hashCode() );
         result = 37 * result + ( getTransPickQtyRqst() == null ? 0 : this.getTransPickQtyRqst().hashCode() );
         result = 37 * result + ( getTransPickQtyAct() == null ? 0 : this.getTransPickQtyAct().hashCode() );
         result = 37 * result + this.getWhFacilityTransOnhandNbr();
         result = 37 * result + ( getWhPickDtlTransRqstNbrSrc() == null ? 0 : this.getWhPickDtlTransRqstNbrSrc().hashCode() );
         result = 37 * result + ( getBoxCdDest() == null ? 0 : this.getBoxCdDest().hashCode() );
         result = 37 * result + ( getBoxCnt() == null ? 0 : this.getBoxCnt().hashCode() );
         result = 37 * result + ( getPickScanCd() == null ? 0 : this.getPickScanCd().hashCode() );
         result = 37 * result + ( getItemCd() == null ? 0 : this.getItemCd().hashCode() );
         result = 37 * result + ( getItemDescr() == null ? 0 : this.getItemDescr().hashCode() );
         result = 37 * result + this.getBinNbr();
         result = 37 * result + ( getBinCd() == null ? 0 : this.getBinCd().hashCode() );
         result = 37 * result + ( getFacility() == null ? 0 : this.getFacility().hashCode() );
         result = 37 * result + ( getWhWhseZoneNbr() == null ? 0 : this.getWhWhseZoneNbr().hashCode() );
         result = 37 * result + this.getItemNbr();
         result = 37 * result + ( getOrgNbrMfr() == null ? 0 : this.getOrgNbrMfr().hashCode() );
         result = 37 * result + ( getMfrLotCd() == null ? 0 : this.getMfrLotCd().hashCode() );
         result = 37 * result + this.getApsSplySubPoolNbr();
         result = 37 * result + ( getBoxStatId() == null ? 0 : this.getBoxStatId().hashCode() );
         result = 37 * result + this.getLotNbr();
         result = 37 * result + ( getRevLvl() == null ? 0 : this.getRevLvl().hashCode() );
         result = 37 * result + ( getLotCostUm() == null ? 0 : this.getLotCostUm().hashCode() );
         result = 37 * result + ( getMfrSerialCd() == null ? 0 : this.getMfrSerialCd().hashCode() );
         result = 37 * result + ( getSerialCd() == null ? 0 : this.getSerialCd().hashCode() );
         result = 37 * result + ( getWalkSeq() == null ? 0 : this.getWalkSeq().hashCode() );
         result = 37 * result + ( getFacilitySrc() == null ? 0 : this.getFacilitySrc().hashCode() );
         result = 37 * result + ( getFacilityDest() == null ? 0 : this.getFacilityDest().hashCode() );
         result = 37 * result + this.getApsSplySubPoolNbrSrc();
         result = 37 * result + this.getApsSplySubPoolNbrDest();
         result = 37 * result + ( getQtyRqst() == null ? 0 : this.getQtyRqst().hashCode() );
         result = 37 * result + ( getRqstDt() == null ? 0 : this.getRqstDt().hashCode() );
         result = 37 * result + ( getUpcCd() == null ? 0 : this.getUpcCd().hashCode() );
         result = 37 * result + ( getEan() == null ? 0 : this.getEan().hashCode() );
         result = 37 * result + ( getPickScanId() == null ? 0 : this.getPickScanId().hashCode() );
         result = 37 * result + ( getSplitAtBinFlg() == null ? 0 : this.getSplitAtBinFlg().hashCode() );
         result = 37 * result + ( getQtyPerBox() == null ? 0 : this.getQtyPerBox().hashCode() );
         return result;
   }   


}


