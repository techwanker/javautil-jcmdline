package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * FcFcstMdl generated by hbm2java
 */
@Entity
@Table(name="FC_FCST_MDL"
)
public class FcFcstMdl  implements java.io.Serializable {


     private short fcFcstMdlNbr;
     private String className;
     private BigDecimal alpha1;
     private BigDecimal alpha2;
     private BigDecimal alpha3;
     private String fcstMdlDescr;
     private Byte mdlIntvlCntMin;
     private Byte mdlIntvlCntMax;
     private Byte minNonZeroIntvlPrevCycle;
     private String mdlStatId;

    public FcFcstMdl() {
    }

	
    public FcFcstMdl(short fcFcstMdlNbr, String mdlStatId) {
        this.fcFcstMdlNbr = fcFcstMdlNbr;
        this.mdlStatId = mdlStatId;
    }
    public FcFcstMdl(short fcFcstMdlNbr, String className, BigDecimal alpha1, BigDecimal alpha2, BigDecimal alpha3, String fcstMdlDescr, Byte mdlIntvlCntMin, Byte mdlIntvlCntMax, Byte minNonZeroIntvlPrevCycle, String mdlStatId) {
       this.fcFcstMdlNbr = fcFcstMdlNbr;
       this.className = className;
       this.alpha1 = alpha1;
       this.alpha2 = alpha2;
       this.alpha3 = alpha3;
       this.fcstMdlDescr = fcstMdlDescr;
       this.mdlIntvlCntMin = mdlIntvlCntMin;
       this.mdlIntvlCntMax = mdlIntvlCntMax;
       this.minNonZeroIntvlPrevCycle = minNonZeroIntvlPrevCycle;
       this.mdlStatId = mdlStatId;
    }
   
     @Id 

    
    @Column(name="FC_FCST_MDL_NBR", unique=true, nullable=false, precision=3, scale=0)
    public short getFcFcstMdlNbr() {
        return this.fcFcstMdlNbr;
    }
    
    public void setFcFcstMdlNbr(short fcFcstMdlNbr) {
        this.fcFcstMdlNbr = fcFcstMdlNbr;
    }

    
    @Column(name="CLASS_NAME")
    public String getClassName() {
        return this.className;
    }
    
    public void setClassName(String className) {
        this.className = className;
    }

    
    @Column(name="ALPHA_1", precision=4)
    public BigDecimal getAlpha1() {
        return this.alpha1;
    }
    
    public void setAlpha1(BigDecimal alpha1) {
        this.alpha1 = alpha1;
    }

    
    @Column(name="ALPHA_2", precision=4)
    public BigDecimal getAlpha2() {
        return this.alpha2;
    }
    
    public void setAlpha2(BigDecimal alpha2) {
        this.alpha2 = alpha2;
    }

    
    @Column(name="ALPHA_3", precision=4)
    public BigDecimal getAlpha3() {
        return this.alpha3;
    }
    
    public void setAlpha3(BigDecimal alpha3) {
        this.alpha3 = alpha3;
    }

    
    @Column(name="FCST_MDL_DESCR", length=60)
    public String getFcstMdlDescr() {
        return this.fcstMdlDescr;
    }
    
    public void setFcstMdlDescr(String fcstMdlDescr) {
        this.fcstMdlDescr = fcstMdlDescr;
    }

    
    @Column(name="MDL_INTVL_CNT_MIN", precision=2, scale=0)
    public Byte getMdlIntvlCntMin() {
        return this.mdlIntvlCntMin;
    }
    
    public void setMdlIntvlCntMin(Byte mdlIntvlCntMin) {
        this.mdlIntvlCntMin = mdlIntvlCntMin;
    }

    
    @Column(name="MDL_INTVL_CNT_MAX", precision=2, scale=0)
    public Byte getMdlIntvlCntMax() {
        return this.mdlIntvlCntMax;
    }
    
    public void setMdlIntvlCntMax(Byte mdlIntvlCntMax) {
        this.mdlIntvlCntMax = mdlIntvlCntMax;
    }

    
    @Column(name="MIN_NON_ZERO_INTVL_PREV_CYCLE", precision=2, scale=0)
    public Byte getMinNonZeroIntvlPrevCycle() {
        return this.minNonZeroIntvlPrevCycle;
    }
    
    public void setMinNonZeroIntvlPrevCycle(Byte minNonZeroIntvlPrevCycle) {
        this.minNonZeroIntvlPrevCycle = minNonZeroIntvlPrevCycle;
    }

    
    @Column(name="MDL_STAT_ID", nullable=false, length=1)
    public String getMdlStatId() {
        return this.mdlStatId;
    }
    
    public void setMdlStatId(String mdlStatId) {
        this.mdlStatId = mdlStatId;
    }




}

