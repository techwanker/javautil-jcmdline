package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ArUnplannedRma generated by hbm2java
 */
@Entity
@Table(name="AR_UNPLANNED_RMA"
)
public class ArUnplannedRma  implements java.io.Serializable {


     private int arUnplannedRmaNbr;
     private Date rcptDt;
     private String rmaCd;
     private Short rmaLineNbr;
     private int itemNbr;
     private BigDecimal qtyReceived;
     private String rmaUm;
     private Integer binNbrStage;
     private String rmaComments;
     private String rmaStatId;
     private Date processDt;
     private int utUserNbrRecv;
     private int utUserNbr;
     private Date lastModDt;

    public ArUnplannedRma() {
    }

	
    public ArUnplannedRma(int arUnplannedRmaNbr, Date rcptDt, int itemNbr, BigDecimal qtyReceived, String rmaUm, String rmaStatId, int utUserNbrRecv, int utUserNbr, Date lastModDt) {
        this.arUnplannedRmaNbr = arUnplannedRmaNbr;
        this.rcptDt = rcptDt;
        this.itemNbr = itemNbr;
        this.qtyReceived = qtyReceived;
        this.rmaUm = rmaUm;
        this.rmaStatId = rmaStatId;
        this.utUserNbrRecv = utUserNbrRecv;
        this.utUserNbr = utUserNbr;
        this.lastModDt = lastModDt;
    }
    public ArUnplannedRma(int arUnplannedRmaNbr, Date rcptDt, String rmaCd, Short rmaLineNbr, int itemNbr, BigDecimal qtyReceived, String rmaUm, Integer binNbrStage, String rmaComments, String rmaStatId, Date processDt, int utUserNbrRecv, int utUserNbr, Date lastModDt) {
       this.arUnplannedRmaNbr = arUnplannedRmaNbr;
       this.rcptDt = rcptDt;
       this.rmaCd = rmaCd;
       this.rmaLineNbr = rmaLineNbr;
       this.itemNbr = itemNbr;
       this.qtyReceived = qtyReceived;
       this.rmaUm = rmaUm;
       this.binNbrStage = binNbrStage;
       this.rmaComments = rmaComments;
       this.rmaStatId = rmaStatId;
       this.processDt = processDt;
       this.utUserNbrRecv = utUserNbrRecv;
       this.utUserNbr = utUserNbr;
       this.lastModDt = lastModDt;
    }
   
     @Id 

    
    @Column(name="AR_UNPLANNED_RMA_NBR", unique=true, nullable=false, precision=9, scale=0)
    public int getArUnplannedRmaNbr() {
        return this.arUnplannedRmaNbr;
    }
    
    public void setArUnplannedRmaNbr(int arUnplannedRmaNbr) {
        this.arUnplannedRmaNbr = arUnplannedRmaNbr;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="RCPT_DT", nullable=false, length=7)
    public Date getRcptDt() {
        return this.rcptDt;
    }
    
    public void setRcptDt(Date rcptDt) {
        this.rcptDt = rcptDt;
    }

    
    @Column(name="RMA_CD", length=20)
    public String getRmaCd() {
        return this.rmaCd;
    }
    
    public void setRmaCd(String rmaCd) {
        this.rmaCd = rmaCd;
    }

    
    @Column(name="RMA_LINE_NBR", precision=3, scale=0)
    public Short getRmaLineNbr() {
        return this.rmaLineNbr;
    }
    
    public void setRmaLineNbr(Short rmaLineNbr) {
        this.rmaLineNbr = rmaLineNbr;
    }

    
    @Column(name="ITEM_NBR", nullable=false, precision=9, scale=0)
    public int getItemNbr() {
        return this.itemNbr;
    }
    
    public void setItemNbr(int itemNbr) {
        this.itemNbr = itemNbr;
    }

    
    @Column(name="QTY_RECEIVED", nullable=false, precision=13, scale=5)
    public BigDecimal getQtyReceived() {
        return this.qtyReceived;
    }
    
    public void setQtyReceived(BigDecimal qtyReceived) {
        this.qtyReceived = qtyReceived;
    }

    
    @Column(name="RMA_UM", nullable=false, length=3)
    public String getRmaUm() {
        return this.rmaUm;
    }
    
    public void setRmaUm(String rmaUm) {
        this.rmaUm = rmaUm;
    }

    
    @Column(name="BIN_NBR_STAGE", precision=9, scale=0)
    public Integer getBinNbrStage() {
        return this.binNbrStage;
    }
    
    public void setBinNbrStage(Integer binNbrStage) {
        this.binNbrStage = binNbrStage;
    }

    
    @Column(name="RMA_COMMENTS")
    public String getRmaComments() {
        return this.rmaComments;
    }
    
    public void setRmaComments(String rmaComments) {
        this.rmaComments = rmaComments;
    }

    
    @Column(name="RMA_STAT_ID", nullable=false, length=1)
    public String getRmaStatId() {
        return this.rmaStatId;
    }
    
    public void setRmaStatId(String rmaStatId) {
        this.rmaStatId = rmaStatId;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="PROCESS_DT", length=7)
    public Date getProcessDt() {
        return this.processDt;
    }
    
    public void setProcessDt(Date processDt) {
        this.processDt = processDt;
    }

    
    @Column(name="UT_USER_NBR_RECV", nullable=false, precision=9, scale=0)
    public int getUtUserNbrRecv() {
        return this.utUserNbrRecv;
    }
    
    public void setUtUserNbrRecv(int utUserNbrRecv) {
        this.utUserNbrRecv = utUserNbrRecv;
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




}


