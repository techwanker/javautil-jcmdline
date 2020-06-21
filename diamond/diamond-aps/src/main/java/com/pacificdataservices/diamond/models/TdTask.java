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
 * TdTask generated by hbm2java
 */
@Entity
@Table(name="TD_TASK"
)
public class TdTask  implements java.io.Serializable {


     private int tdTaskNbr;
     private String descr;
     private Date dueDt;
     private Date completeDt;
     private String statusCd;
     private String whoResponsible;

    public TdTask() {
    }

	
    public TdTask(int tdTaskNbr) {
        this.tdTaskNbr = tdTaskNbr;
    }
    public TdTask(int tdTaskNbr, String descr, Date dueDt, Date completeDt, String statusCd, String whoResponsible) {
       this.tdTaskNbr = tdTaskNbr;
       this.descr = descr;
       this.dueDt = dueDt;
       this.completeDt = completeDt;
       this.statusCd = statusCd;
       this.whoResponsible = whoResponsible;
    }
   
     @Id 

    
    @Column(name="TD_TASK_NBR", unique=true, nullable=false, precision=9, scale=0)
    public int getTdTaskNbr() {
        return this.tdTaskNbr;
    }
    
    public void setTdTaskNbr(int tdTaskNbr) {
        this.tdTaskNbr = tdTaskNbr;
    }

    
    @Column(name="DESCR", length=60)
    public String getDescr() {
        return this.descr;
    }
    
    public void setDescr(String descr) {
        this.descr = descr;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="DUE_DT", length=7)
    public Date getDueDt() {
        return this.dueDt;
    }
    
    public void setDueDt(Date dueDt) {
        this.dueDt = dueDt;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="COMPLETE_DT", length=7)
    public Date getCompleteDt() {
        return this.completeDt;
    }
    
    public void setCompleteDt(Date completeDt) {
        this.completeDt = completeDt;
    }

    
    @Column(name="STATUS_CD", length=4)
    public String getStatusCd() {
        return this.statusCd;
    }
    
    public void setStatusCd(String statusCd) {
        this.statusCd = statusCd;
    }

    
    @Column(name="WHO_RESPONSIBLE", length=4)
    public String getWhoResponsible() {
        return this.whoResponsible;
    }
    
    public void setWhoResponsible(String whoResponsible) {
        this.whoResponsible = whoResponsible;
    }




}


