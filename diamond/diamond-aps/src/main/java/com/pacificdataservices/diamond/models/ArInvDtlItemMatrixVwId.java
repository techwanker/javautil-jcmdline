package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ArInvDtlItemMatrixVwId generated by hbm2java
 */
@Embeddable
public class ArInvDtlItemMatrixVwId  implements java.io.Serializable {


     private String cycle;
     private int itemNbr;
     private String itemCd;
     private BigDecimal jan;
     private BigDecimal feb;
     private BigDecimal mar;
     private BigDecimal apr;
     private BigDecimal may;
     private BigDecimal jun;
     private BigDecimal jul;
     private BigDecimal aug;
     private BigDecimal sep;
     private BigDecimal oct;
     private BigDecimal nov;
     private BigDecimal dec;
     private BigDecimal tot;

    public ArInvDtlItemMatrixVwId() {
    }

	
    public ArInvDtlItemMatrixVwId(int itemNbr, String itemCd) {
        this.itemNbr = itemNbr;
        this.itemCd = itemCd;
    }
    public ArInvDtlItemMatrixVwId(String cycle, int itemNbr, String itemCd, BigDecimal jan, BigDecimal feb, BigDecimal mar, BigDecimal apr, BigDecimal may, BigDecimal jun, BigDecimal jul, BigDecimal aug, BigDecimal sep, BigDecimal oct, BigDecimal nov, BigDecimal dec, BigDecimal tot) {
       this.cycle = cycle;
       this.itemNbr = itemNbr;
       this.itemCd = itemCd;
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
   


    @Column(name="CYCLE", length=4)
    public String getCycle() {
        return this.cycle;
    }
    
    public void setCycle(String cycle) {
        this.cycle = cycle;
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


    @Column(name="JAN", precision=22, scale=0)
    public BigDecimal getJan() {
        return this.jan;
    }
    
    public void setJan(BigDecimal jan) {
        this.jan = jan;
    }


    @Column(name="FEB", precision=22, scale=0)
    public BigDecimal getFeb() {
        return this.feb;
    }
    
    public void setFeb(BigDecimal feb) {
        this.feb = feb;
    }


    @Column(name="MAR", precision=22, scale=0)
    public BigDecimal getMar() {
        return this.mar;
    }
    
    public void setMar(BigDecimal mar) {
        this.mar = mar;
    }


    @Column(name="APR", precision=22, scale=0)
    public BigDecimal getApr() {
        return this.apr;
    }
    
    public void setApr(BigDecimal apr) {
        this.apr = apr;
    }


    @Column(name="MAY", precision=22, scale=0)
    public BigDecimal getMay() {
        return this.may;
    }
    
    public void setMay(BigDecimal may) {
        this.may = may;
    }


    @Column(name="JUN", precision=22, scale=0)
    public BigDecimal getJun() {
        return this.jun;
    }
    
    public void setJun(BigDecimal jun) {
        this.jun = jun;
    }


    @Column(name="JUL", precision=22, scale=0)
    public BigDecimal getJul() {
        return this.jul;
    }
    
    public void setJul(BigDecimal jul) {
        this.jul = jul;
    }


    @Column(name="AUG", precision=22, scale=0)
    public BigDecimal getAug() {
        return this.aug;
    }
    
    public void setAug(BigDecimal aug) {
        this.aug = aug;
    }


    @Column(name="SEP", precision=22, scale=0)
    public BigDecimal getSep() {
        return this.sep;
    }
    
    public void setSep(BigDecimal sep) {
        this.sep = sep;
    }


    @Column(name="OCT", precision=22, scale=0)
    public BigDecimal getOct() {
        return this.oct;
    }
    
    public void setOct(BigDecimal oct) {
        this.oct = oct;
    }


    @Column(name="NOV", precision=22, scale=0)
    public BigDecimal getNov() {
        return this.nov;
    }
    
    public void setNov(BigDecimal nov) {
        this.nov = nov;
    }


    @Column(name="DEC", precision=22, scale=0)
    public BigDecimal getDec() {
        return this.dec;
    }
    
    public void setDec(BigDecimal dec) {
        this.dec = dec;
    }


    @Column(name="TOT", precision=22, scale=0)
    public BigDecimal getTot() {
        return this.tot;
    }
    
    public void setTot(BigDecimal tot) {
        this.tot = tot;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ArInvDtlItemMatrixVwId) ) return false;
		 ArInvDtlItemMatrixVwId castOther = ( ArInvDtlItemMatrixVwId ) other; 
         
		 return ( (this.getCycle()==castOther.getCycle()) || ( this.getCycle()!=null && castOther.getCycle()!=null && this.getCycle().equals(castOther.getCycle()) ) )
 && (this.getItemNbr()==castOther.getItemNbr())
 && ( (this.getItemCd()==castOther.getItemCd()) || ( this.getItemCd()!=null && castOther.getItemCd()!=null && this.getItemCd().equals(castOther.getItemCd()) ) )
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
         
         result = 37 * result + ( getCycle() == null ? 0 : this.getCycle().hashCode() );
         result = 37 * result + this.getItemNbr();
         result = 37 * result + ( getItemCd() == null ? 0 : this.getItemCd().hashCode() );
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

