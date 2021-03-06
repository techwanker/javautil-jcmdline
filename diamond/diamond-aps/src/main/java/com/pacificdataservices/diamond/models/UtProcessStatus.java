package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * UtProcessStatus generated by hbm2java
 */
@Entity
@Table(name="UT_PROCESS_STATUS"
)
public class UtProcessStatus  implements java.io.Serializable {


     private int utProcessStatusNbr;
     private String processNm;
     private String threadNm;
     private int processRunNbr;
     private String statusMsg;
     private String statusId;
     private Date statusTs;

    public UtProcessStatus() {
    }

    public UtProcessStatus(int utProcessStatusNbr, String processNm, String threadNm, int processRunNbr, String statusMsg, String statusId, Date statusTs) {
       this.utProcessStatusNbr = utProcessStatusNbr;
       this.processNm = processNm;
       this.threadNm = threadNm;
       this.processRunNbr = processRunNbr;
       this.statusMsg = statusMsg;
       this.statusId = statusId;
       this.statusTs = statusTs;
    }
   
     @Id 

    
    @Column(name="UT_PROCESS_STATUS_NBR", unique=true, nullable=false, precision=9, scale=0)
    public int getUtProcessStatusNbr() {
        return this.utProcessStatusNbr;
    }
    
    public void setUtProcessStatusNbr(int utProcessStatusNbr) {
        this.utProcessStatusNbr = utProcessStatusNbr;
    }

    
    @Column(name="PROCESS_NM", nullable=false, length=128)
    public String getProcessNm() {
        return this.processNm;
    }
    
    public void setProcessNm(String processNm) {
        this.processNm = processNm;
    }

    
    @Column(name="THREAD_NM", nullable=false, length=128)
    public String getThreadNm() {
        return this.threadNm;
    }
    
    public void setThreadNm(String threadNm) {
        this.threadNm = threadNm;
    }

    
    @Column(name="PROCESS_RUN_NBR", nullable=false, precision=9, scale=0)
    public int getProcessRunNbr() {
        return this.processRunNbr;
    }
    
    public void setProcessRunNbr(int processRunNbr) {
        this.processRunNbr = processRunNbr;
    }

    
    @Column(name="STATUS_MSG", nullable=false, length=2000)
    public String getStatusMsg() {
        return this.statusMsg;
    }
    
    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    
    @Column(name="STATUS_ID", nullable=false, length=1)
    public String getStatusId() {
        return this.statusId;
    }
    
    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="STATUS_TS", nullable=false, length=11)
    public Date getStatusTs() {
        return this.statusTs;
    }
    
    public void setStatusTs(Date statusTs) {
        this.statusTs = statusTs;
    }




}


