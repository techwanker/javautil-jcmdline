package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * QaTstRslt generated by hbm2java
 */
@Entity
@Table(name="QA_TST_RSLT"
)
public class QaTstRslt  implements java.io.Serializable {


     private int qaTstRsltNbr;
     private PoVndMast poVndMast;
     private String qaProjCd;
     private String qaTstCd;
     private int orgNbrMfr;
     private int itemNbr;
     private String tstRslt;
     private BigDecimal qtyOnHand;
     private Integer sampleSize;
     private String sampleSizeUm;
     private String mfrLotCd;
     private Integer orgNbrCust;
     private int lotNbr;
     private String recvIndicator;
     private int icAttrNbr;
     private String attrVal;
     private String testLab;
     private Date sentToTstFacilityDt;
     private Date recvFromTstFacilityDt;
     private String tstInvoicedFlg;
     private BigDecimal testCost;
     private String qaTstSteCd;
     private Integer planNbr;
     private Short planLineNbr;
     private Integer rcptCnt;
     private Integer cycleCnt;
     private String skipFlg;
     private Date tstCreDt;

    public QaTstRslt() {
    }

	
    public QaTstRslt(int qaTstRsltNbr, PoVndMast poVndMast, String qaProjCd, String qaTstCd, int orgNbrMfr, int itemNbr, int lotNbr, int icAttrNbr, String attrVal, String tstInvoicedFlg, String skipFlg, Date tstCreDt) {
        this.qaTstRsltNbr = qaTstRsltNbr;
        this.poVndMast = poVndMast;
        this.qaProjCd = qaProjCd;
        this.qaTstCd = qaTstCd;
        this.orgNbrMfr = orgNbrMfr;
        this.itemNbr = itemNbr;
        this.lotNbr = lotNbr;
        this.icAttrNbr = icAttrNbr;
        this.attrVal = attrVal;
        this.tstInvoicedFlg = tstInvoicedFlg;
        this.skipFlg = skipFlg;
        this.tstCreDt = tstCreDt;
    }
    public QaTstRslt(int qaTstRsltNbr, PoVndMast poVndMast, String qaProjCd, String qaTstCd, int orgNbrMfr, int itemNbr, String tstRslt, BigDecimal qtyOnHand, Integer sampleSize, String sampleSizeUm, String mfrLotCd, Integer orgNbrCust, int lotNbr, String recvIndicator, int icAttrNbr, String attrVal, String testLab, Date sentToTstFacilityDt, Date recvFromTstFacilityDt, String tstInvoicedFlg, BigDecimal testCost, String qaTstSteCd, Integer planNbr, Short planLineNbr, Integer rcptCnt, Integer cycleCnt, String skipFlg, Date tstCreDt) {
       this.qaTstRsltNbr = qaTstRsltNbr;
       this.poVndMast = poVndMast;
       this.qaProjCd = qaProjCd;
       this.qaTstCd = qaTstCd;
       this.orgNbrMfr = orgNbrMfr;
       this.itemNbr = itemNbr;
       this.tstRslt = tstRslt;
       this.qtyOnHand = qtyOnHand;
       this.sampleSize = sampleSize;
       this.sampleSizeUm = sampleSizeUm;
       this.mfrLotCd = mfrLotCd;
       this.orgNbrCust = orgNbrCust;
       this.lotNbr = lotNbr;
       this.recvIndicator = recvIndicator;
       this.icAttrNbr = icAttrNbr;
       this.attrVal = attrVal;
       this.testLab = testLab;
       this.sentToTstFacilityDt = sentToTstFacilityDt;
       this.recvFromTstFacilityDt = recvFromTstFacilityDt;
       this.tstInvoicedFlg = tstInvoicedFlg;
       this.testCost = testCost;
       this.qaTstSteCd = qaTstSteCd;
       this.planNbr = planNbr;
       this.planLineNbr = planLineNbr;
       this.rcptCnt = rcptCnt;
       this.cycleCnt = cycleCnt;
       this.skipFlg = skipFlg;
       this.tstCreDt = tstCreDt;
    }
   
     @Id 

    
    @Column(name="QA_TST_RSLT_NBR", unique=true, nullable=false, precision=9, scale=0)
    public int getQaTstRsltNbr() {
        return this.qaTstRsltNbr;
    }
    
    public void setQaTstRsltNbr(int qaTstRsltNbr) {
        this.qaTstRsltNbr = qaTstRsltNbr;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ORG_NBR_VND", nullable=false)
    public PoVndMast getPoVndMast() {
        return this.poVndMast;
    }
    
    public void setPoVndMast(PoVndMast poVndMast) {
        this.poVndMast = poVndMast;
    }

    
    @Column(name="QA_PROJ_CD", nullable=false, length=16)
    public String getQaProjCd() {
        return this.qaProjCd;
    }
    
    public void setQaProjCd(String qaProjCd) {
        this.qaProjCd = qaProjCd;
    }

    
    @Column(name="QA_TST_CD", nullable=false, length=16)
    public String getQaTstCd() {
        return this.qaTstCd;
    }
    
    public void setQaTstCd(String qaTstCd) {
        this.qaTstCd = qaTstCd;
    }

    
    @Column(name="ORG_NBR_MFR", nullable=false, precision=9, scale=0)
    public int getOrgNbrMfr() {
        return this.orgNbrMfr;
    }
    
    public void setOrgNbrMfr(int orgNbrMfr) {
        this.orgNbrMfr = orgNbrMfr;
    }

    
    @Column(name="ITEM_NBR", nullable=false, precision=9, scale=0)
    public int getItemNbr() {
        return this.itemNbr;
    }
    
    public void setItemNbr(int itemNbr) {
        this.itemNbr = itemNbr;
    }

    
    @Column(name="TST_RSLT", length=1)
    public String getTstRslt() {
        return this.tstRslt;
    }
    
    public void setTstRslt(String tstRslt) {
        this.tstRslt = tstRslt;
    }

    
    @Column(name="QTY_ON_HAND", precision=15, scale=5)
    public BigDecimal getQtyOnHand() {
        return this.qtyOnHand;
    }
    
    public void setQtyOnHand(BigDecimal qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    
    @Column(name="SAMPLE_SIZE", precision=5, scale=0)
    public Integer getSampleSize() {
        return this.sampleSize;
    }
    
    public void setSampleSize(Integer sampleSize) {
        this.sampleSize = sampleSize;
    }

    
    @Column(name="SAMPLE_SIZE_UM", length=3)
    public String getSampleSizeUm() {
        return this.sampleSizeUm;
    }
    
    public void setSampleSizeUm(String sampleSizeUm) {
        this.sampleSizeUm = sampleSizeUm;
    }

    
    @Column(name="MFR_LOT_CD", length=20)
    public String getMfrLotCd() {
        return this.mfrLotCd;
    }
    
    public void setMfrLotCd(String mfrLotCd) {
        this.mfrLotCd = mfrLotCd;
    }

    
    @Column(name="ORG_NBR_CUST", precision=9, scale=0)
    public Integer getOrgNbrCust() {
        return this.orgNbrCust;
    }
    
    public void setOrgNbrCust(Integer orgNbrCust) {
        this.orgNbrCust = orgNbrCust;
    }

    
    @Column(name="LOT_NBR", nullable=false, precision=9, scale=0)
    public int getLotNbr() {
        return this.lotNbr;
    }
    
    public void setLotNbr(int lotNbr) {
        this.lotNbr = lotNbr;
    }

    
    @Column(name="RECV_INDICATOR", length=1)
    public String getRecvIndicator() {
        return this.recvIndicator;
    }
    
    public void setRecvIndicator(String recvIndicator) {
        this.recvIndicator = recvIndicator;
    }

    
    @Column(name="IC_ATTR_NBR", nullable=false, precision=9, scale=0)
    public int getIcAttrNbr() {
        return this.icAttrNbr;
    }
    
    public void setIcAttrNbr(int icAttrNbr) {
        this.icAttrNbr = icAttrNbr;
    }

    
    @Column(name="ATTR_VAL", nullable=false, length=20)
    public String getAttrVal() {
        return this.attrVal;
    }
    
    public void setAttrVal(String attrVal) {
        this.attrVal = attrVal;
    }

    
    @Column(name="TEST_LAB", length=5)
    public String getTestLab() {
        return this.testLab;
    }
    
    public void setTestLab(String testLab) {
        this.testLab = testLab;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="SENT_TO_TST_FACILITY_DT", length=7)
    public Date getSentToTstFacilityDt() {
        return this.sentToTstFacilityDt;
    }
    
    public void setSentToTstFacilityDt(Date sentToTstFacilityDt) {
        this.sentToTstFacilityDt = sentToTstFacilityDt;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="RECV_FROM_TST_FACILITY_DT", length=7)
    public Date getRecvFromTstFacilityDt() {
        return this.recvFromTstFacilityDt;
    }
    
    public void setRecvFromTstFacilityDt(Date recvFromTstFacilityDt) {
        this.recvFromTstFacilityDt = recvFromTstFacilityDt;
    }

    
    @Column(name="TST_INVOICED_FLG", nullable=false, length=1)
    public String getTstInvoicedFlg() {
        return this.tstInvoicedFlg;
    }
    
    public void setTstInvoicedFlg(String tstInvoicedFlg) {
        this.tstInvoicedFlg = tstInvoicedFlg;
    }

    
    @Column(name="TEST_COST", precision=7)
    public BigDecimal getTestCost() {
        return this.testCost;
    }
    
    public void setTestCost(BigDecimal testCost) {
        this.testCost = testCost;
    }

    
    @Column(name="QA_TST_STE_CD", length=16)
    public String getQaTstSteCd() {
        return this.qaTstSteCd;
    }
    
    public void setQaTstSteCd(String qaTstSteCd) {
        this.qaTstSteCd = qaTstSteCd;
    }

    
    @Column(name="PLAN_NBR", precision=9, scale=0)
    public Integer getPlanNbr() {
        return this.planNbr;
    }
    
    public void setPlanNbr(Integer planNbr) {
        this.planNbr = planNbr;
    }

    
    @Column(name="PLAN_LINE_NBR", precision=3, scale=0)
    public Short getPlanLineNbr() {
        return this.planLineNbr;
    }
    
    public void setPlanLineNbr(Short planLineNbr) {
        this.planLineNbr = planLineNbr;
    }

    
    @Column(name="RCPT_CNT", precision=5, scale=0)
    public Integer getRcptCnt() {
        return this.rcptCnt;
    }
    
    public void setRcptCnt(Integer rcptCnt) {
        this.rcptCnt = rcptCnt;
    }

    
    @Column(name="CYCLE_CNT", precision=5, scale=0)
    public Integer getCycleCnt() {
        return this.cycleCnt;
    }
    
    public void setCycleCnt(Integer cycleCnt) {
        this.cycleCnt = cycleCnt;
    }

    
    @Column(name="SKIP_FLG", nullable=false, length=1)
    public String getSkipFlg() {
        return this.skipFlg;
    }
    
    public void setSkipFlg(String skipFlg) {
        this.skipFlg = skipFlg;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="TST_CRE_DT", nullable=false, length=7)
    public Date getTstCreDt() {
        return this.tstCreDt;
    }
    
    public void setTstCreDt(Date tstCreDt) {
        this.tstCreDt = tstCreDt;
    }




}


