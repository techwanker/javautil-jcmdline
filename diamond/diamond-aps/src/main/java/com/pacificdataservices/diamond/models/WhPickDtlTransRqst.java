package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * WhPickDtlTransRqst generated by hbm2java
 */
@Entity
@Table(name="WH_PICK_DTL_TRANS_RQST"
)
public class WhPickDtlTransRqst  implements java.io.Serializable {


     private int whPickDtlTransRqstNbr;
     private WhFacilityTransOnhand whFacilityTransOnhand;
     private IcItemLoc icItemLoc;
     private IcItemLocBox icItemLocBox;
     private int whPickBatchTransNbr;
     private BigDecimal transPickQtyRqst;
     private BigDecimal transPickQtyAct;
     private Integer whPickDtlTransRqstNbrSrc;
     private String boxCdDest;
     private Integer boxCnt;
     private String pickScanCd;

    public WhPickDtlTransRqst() {
    }

	
    public WhPickDtlTransRqst(int whPickDtlTransRqstNbr, WhFacilityTransOnhand whFacilityTransOnhand, int whPickBatchTransNbr, BigDecimal transPickQtyRqst) {
        this.whPickDtlTransRqstNbr = whPickDtlTransRqstNbr;
        this.whFacilityTransOnhand = whFacilityTransOnhand;
        this.whPickBatchTransNbr = whPickBatchTransNbr;
        this.transPickQtyRqst = transPickQtyRqst;
    }
    public WhPickDtlTransRqst(int whPickDtlTransRqstNbr, WhFacilityTransOnhand whFacilityTransOnhand, IcItemLoc icItemLoc, IcItemLocBox icItemLocBox, int whPickBatchTransNbr, BigDecimal transPickQtyRqst, BigDecimal transPickQtyAct, Integer whPickDtlTransRqstNbrSrc, String boxCdDest, Integer boxCnt, String pickScanCd) {
       this.whPickDtlTransRqstNbr = whPickDtlTransRqstNbr;
       this.whFacilityTransOnhand = whFacilityTransOnhand;
       this.icItemLoc = icItemLoc;
       this.icItemLocBox = icItemLocBox;
       this.whPickBatchTransNbr = whPickBatchTransNbr;
       this.transPickQtyRqst = transPickQtyRqst;
       this.transPickQtyAct = transPickQtyAct;
       this.whPickDtlTransRqstNbrSrc = whPickDtlTransRqstNbrSrc;
       this.boxCdDest = boxCdDest;
       this.boxCnt = boxCnt;
       this.pickScanCd = pickScanCd;
    }
   
     @Id 

    
    @Column(name="WH_PICK_DTL_TRANS_RQST_NBR", unique=true, nullable=false, precision=9, scale=0)
    public int getWhPickDtlTransRqstNbr() {
        return this.whPickDtlTransRqstNbr;
    }
    
    public void setWhPickDtlTransRqstNbr(int whPickDtlTransRqstNbr) {
        this.whPickDtlTransRqstNbr = whPickDtlTransRqstNbr;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="WH_FACILITY_TRANS_ONHAND_NBR", nullable=false)
    public WhFacilityTransOnhand getWhFacilityTransOnhand() {
        return this.whFacilityTransOnhand;
    }
    
    public void setWhFacilityTransOnhand(WhFacilityTransOnhand whFacilityTransOnhand) {
        this.whFacilityTransOnhand = whFacilityTransOnhand;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="IC_ITEM_LOC_NBR")
    public IcItemLoc getIcItemLoc() {
        return this.icItemLoc;
    }
    
    public void setIcItemLoc(IcItemLoc icItemLoc) {
        this.icItemLoc = icItemLoc;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="BOX_CD")
    public IcItemLocBox getIcItemLocBox() {
        return this.icItemLocBox;
    }
    
    public void setIcItemLocBox(IcItemLocBox icItemLocBox) {
        this.icItemLocBox = icItemLocBox;
    }

    
    @Column(name="WH_PICK_BATCH_TRANS_NBR", nullable=false, precision=9, scale=0)
    public int getWhPickBatchTransNbr() {
        return this.whPickBatchTransNbr;
    }
    
    public void setWhPickBatchTransNbr(int whPickBatchTransNbr) {
        this.whPickBatchTransNbr = whPickBatchTransNbr;
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




}

