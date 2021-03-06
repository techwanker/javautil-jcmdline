package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * FcAggrHistCycleActVwId generated by hbm2java
 */
@Embeddable
public class FcAggrHistCycleActVwId  implements java.io.Serializable {


     private Serializable fcAggrMastNbr;
     private Serializable fcstGrp;
     private Serializable fcstTypeId;
     private Serializable fcstAggrTypeId;
     private Serializable cycle;
     private Serializable jan;
     private Serializable feb;
     private Serializable mar;
     private Serializable apr;
     private Serializable may;
     private Serializable jun;
     private Serializable jul;
     private Serializable aug;
     private Serializable sep;
     private Serializable oct;
     private Serializable nov;
     private Serializable dec;
     private Serializable tot;

    public FcAggrHistCycleActVwId() {
    }

    public FcAggrHistCycleActVwId(Serializable fcAggrMastNbr, Serializable fcstGrp, Serializable fcstTypeId, Serializable fcstAggrTypeId, Serializable cycle, Serializable jan, Serializable feb, Serializable mar, Serializable apr, Serializable may, Serializable jun, Serializable jul, Serializable aug, Serializable sep, Serializable oct, Serializable nov, Serializable dec, Serializable tot) {
       this.fcAggrMastNbr = fcAggrMastNbr;
       this.fcstGrp = fcstGrp;
       this.fcstTypeId = fcstTypeId;
       this.fcstAggrTypeId = fcstAggrTypeId;
       this.cycle = cycle;
       this.jan = jan;
       this.feb = feb;
       this.mar = mar;
       this.apr = apr;
       this.may = may;
       this.jun = jun;
       this.jul = jul;
       this.aug = aug;
       this.sep = sep;
       this.oct = oct;
       this.nov = nov;
       this.dec = dec;
       this.tot = tot;
    }
   


    @Column(name="FC_AGGR_MAST_NBR")
    public Serializable getFcAggrMastNbr() {
        return this.fcAggrMastNbr;
    }
    
    public void setFcAggrMastNbr(Serializable fcAggrMastNbr) {
        this.fcAggrMastNbr = fcAggrMastNbr;
    }


    @Column(name="FCST_GRP")
    public Serializable getFcstGrp() {
        return this.fcstGrp;
    }
    
    public void setFcstGrp(Serializable fcstGrp) {
        this.fcstGrp = fcstGrp;
    }


    @Column(name="FCST_TYPE_ID")
    public Serializable getFcstTypeId() {
        return this.fcstTypeId;
    }
    
    public void setFcstTypeId(Serializable fcstTypeId) {
        this.fcstTypeId = fcstTypeId;
    }


    @Column(name="FCST_AGGR_TYPE_ID")
    public Serializable getFcstAggrTypeId() {
        return this.fcstAggrTypeId;
    }
    
    public void setFcstAggrTypeId(Serializable fcstAggrTypeId) {
        this.fcstAggrTypeId = fcstAggrTypeId;
    }


    @Column(name="CYCLE")
    public Serializable getCycle() {
        return this.cycle;
    }
    
    public void setCycle(Serializable cycle) {
        this.cycle = cycle;
    }


    @Column(name="JAN")
    public Serializable getJan() {
        return this.jan;
    }
    
    public void setJan(Serializable jan) {
        this.jan = jan;
    }


    @Column(name="FEB")
    public Serializable getFeb() {
        return this.feb;
    }
    
    public void setFeb(Serializable feb) {
        this.feb = feb;
    }


    @Column(name="MAR")
    public Serializable getMar() {
        return this.mar;
    }
    
    public void setMar(Serializable mar) {
        this.mar = mar;
    }


    @Column(name="APR")
    public Serializable getApr() {
        return this.apr;
    }
    
    public void setApr(Serializable apr) {
        this.apr = apr;
    }


    @Column(name="MAY")
    public Serializable getMay() {
        return this.may;
    }
    
    public void setMay(Serializable may) {
        this.may = may;
    }


    @Column(name="JUN")
    public Serializable getJun() {
        return this.jun;
    }
    
    public void setJun(Serializable jun) {
        this.jun = jun;
    }


    @Column(name="JUL")
    public Serializable getJul() {
        return this.jul;
    }
    
    public void setJul(Serializable jul) {
        this.jul = jul;
    }


    @Column(name="AUG")
    public Serializable getAug() {
        return this.aug;
    }
    
    public void setAug(Serializable aug) {
        this.aug = aug;
    }


    @Column(name="SEP")
    public Serializable getSep() {
        return this.sep;
    }
    
    public void setSep(Serializable sep) {
        this.sep = sep;
    }


    @Column(name="OCT")
    public Serializable getOct() {
        return this.oct;
    }
    
    public void setOct(Serializable oct) {
        this.oct = oct;
    }


    @Column(name="NOV")
    public Serializable getNov() {
        return this.nov;
    }
    
    public void setNov(Serializable nov) {
        this.nov = nov;
    }


    @Column(name="DEC")
    public Serializable getDec() {
        return this.dec;
    }
    
    public void setDec(Serializable dec) {
        this.dec = dec;
    }


    @Column(name="TOT")
    public Serializable getTot() {
        return this.tot;
    }
    
    public void setTot(Serializable tot) {
        this.tot = tot;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof FcAggrHistCycleActVwId) ) return false;
		 FcAggrHistCycleActVwId castOther = ( FcAggrHistCycleActVwId ) other; 
         
		 return ( (this.getFcAggrMastNbr()==castOther.getFcAggrMastNbr()) || ( this.getFcAggrMastNbr()!=null && castOther.getFcAggrMastNbr()!=null && this.getFcAggrMastNbr().equals(castOther.getFcAggrMastNbr()) ) )
 && ( (this.getFcstGrp()==castOther.getFcstGrp()) || ( this.getFcstGrp()!=null && castOther.getFcstGrp()!=null && this.getFcstGrp().equals(castOther.getFcstGrp()) ) )
 && ( (this.getFcstTypeId()==castOther.getFcstTypeId()) || ( this.getFcstTypeId()!=null && castOther.getFcstTypeId()!=null && this.getFcstTypeId().equals(castOther.getFcstTypeId()) ) )
 && ( (this.getFcstAggrTypeId()==castOther.getFcstAggrTypeId()) || ( this.getFcstAggrTypeId()!=null && castOther.getFcstAggrTypeId()!=null && this.getFcstAggrTypeId().equals(castOther.getFcstAggrTypeId()) ) )
 && ( (this.getCycle()==castOther.getCycle()) || ( this.getCycle()!=null && castOther.getCycle()!=null && this.getCycle().equals(castOther.getCycle()) ) )
 && ( (this.getJan()==castOther.getJan()) || ( this.getJan()!=null && castOther.getJan()!=null && this.getJan().equals(castOther.getJan()) ) )
 && ( (this.getFeb()==castOther.getFeb()) || ( this.getFeb()!=null && castOther.getFeb()!=null && this.getFeb().equals(castOther.getFeb()) ) )
 && ( (this.getMar()==castOther.getMar()) || ( this.getMar()!=null && castOther.getMar()!=null && this.getMar().equals(castOther.getMar()) ) )
 && ( (this.getApr()==castOther.getApr()) || ( this.getApr()!=null && castOther.getApr()!=null && this.getApr().equals(castOther.getApr()) ) )
 && ( (this.getMay()==castOther.getMay()) || ( this.getMay()!=null && castOther.getMay()!=null && this.getMay().equals(castOther.getMay()) ) )
 && ( (this.getJun()==castOther.getJun()) || ( this.getJun()!=null && castOther.getJun()!=null && this.getJun().equals(castOther.getJun()) ) )
 && ( (this.getJul()==castOther.getJul()) || ( this.getJul()!=null && castOther.getJul()!=null && this.getJul().equals(castOther.getJul()) ) )
 && ( (this.getAug()==castOther.getAug()) || ( this.getAug()!=null && castOther.getAug()!=null && this.getAug().equals(castOther.getAug()) ) )
 && ( (this.getSep()==castOther.getSep()) || ( this.getSep()!=null && castOther.getSep()!=null && this.getSep().equals(castOther.getSep()) ) )
 && ( (this.getOct()==castOther.getOct()) || ( this.getOct()!=null && castOther.getOct()!=null && this.getOct().equals(castOther.getOct()) ) )
 && ( (this.getNov()==castOther.getNov()) || ( this.getNov()!=null && castOther.getNov()!=null && this.getNov().equals(castOther.getNov()) ) )
 && ( (this.getDec()==castOther.getDec()) || ( this.getDec()!=null && castOther.getDec()!=null && this.getDec().equals(castOther.getDec()) ) )
 && ( (this.getTot()==castOther.getTot()) || ( this.getTot()!=null && castOther.getTot()!=null && this.getTot().equals(castOther.getTot()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getFcAggrMastNbr() == null ? 0 : this.getFcAggrMastNbr().hashCode() );
         result = 37 * result + ( getFcstGrp() == null ? 0 : this.getFcstGrp().hashCode() );
         result = 37 * result + ( getFcstTypeId() == null ? 0 : this.getFcstTypeId().hashCode() );
         result = 37 * result + ( getFcstAggrTypeId() == null ? 0 : this.getFcstAggrTypeId().hashCode() );
         result = 37 * result + ( getCycle() == null ? 0 : this.getCycle().hashCode() );
         result = 37 * result + ( getJan() == null ? 0 : this.getJan().hashCode() );
         result = 37 * result + ( getFeb() == null ? 0 : this.getFeb().hashCode() );
         result = 37 * result + ( getMar() == null ? 0 : this.getMar().hashCode() );
         result = 37 * result + ( getApr() == null ? 0 : this.getApr().hashCode() );
         result = 37 * result + ( getMay() == null ? 0 : this.getMay().hashCode() );
         result = 37 * result + ( getJun() == null ? 0 : this.getJun().hashCode() );
         result = 37 * result + ( getJul() == null ? 0 : this.getJul().hashCode() );
         result = 37 * result + ( getAug() == null ? 0 : this.getAug().hashCode() );
         result = 37 * result + ( getSep() == null ? 0 : this.getSep().hashCode() );
         result = 37 * result + ( getOct() == null ? 0 : this.getOct().hashCode() );
         result = 37 * result + ( getNov() == null ? 0 : this.getNov().hashCode() );
         result = 37 * result + ( getDec() == null ? 0 : this.getDec().hashCode() );
         result = 37 * result + ( getTot() == null ? 0 : this.getTot().hashCode() );
         return result;
   }   


}


