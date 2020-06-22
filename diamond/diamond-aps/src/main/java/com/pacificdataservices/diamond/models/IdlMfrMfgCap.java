package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * IdlMfrMfgCap generated by hbm2java
 */
@Entity
@Table(name="IDL_MFR_MFG_CAP"
)
public class IdlMfrMfgCap  implements java.io.Serializable {


     private int idlMfrMfgCapNbr;
     private String orgCdMfr;
     private BigDecimal dailyCap;
     private String icCategoryNm;

    public IdlMfrMfgCap() {
    }

    public IdlMfrMfgCap(int idlMfrMfgCapNbr, String orgCdMfr, BigDecimal dailyCap, String icCategoryNm) {
       this.idlMfrMfgCapNbr = idlMfrMfgCapNbr;
       this.orgCdMfr = orgCdMfr;
       this.dailyCap = dailyCap;
       this.icCategoryNm = icCategoryNm;
    }
   
     @Id 

    
    @Column(name="IDL_MFR_MFG_CAP_NBR", unique=true, nullable=false, precision=9, scale=0)
    public int getIdlMfrMfgCapNbr() {
        return this.idlMfrMfgCapNbr;
    }
    
    public void setIdlMfrMfgCapNbr(int idlMfrMfgCapNbr) {
        this.idlMfrMfgCapNbr = idlMfrMfgCapNbr;
    }

    
    @Column(name="ORG_CD_MFR", nullable=false, length=16)
    public String getOrgCdMfr() {
        return this.orgCdMfr;
    }
    
    public void setOrgCdMfr(String orgCdMfr) {
        this.orgCdMfr = orgCdMfr;
    }

    
    @Column(name="DAILY_CAP", nullable=false, precision=22, scale=0)
    public BigDecimal getDailyCap() {
        return this.dailyCap;
    }
    
    public void setDailyCap(BigDecimal dailyCap) {
        this.dailyCap = dailyCap;
    }

    
    @Column(name="IC_CATEGORY_NM", nullable=false, length=16)
    public String getIcCategoryNm() {
        return this.icCategoryNm;
    }
    
    public void setIcCategoryNm(String icCategoryNm) {
        this.icCategoryNm = icCategoryNm;
    }




}

