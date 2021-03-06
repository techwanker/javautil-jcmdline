package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ItemTmp3Id generated by hbm2java
 */
@Embeddable
public class ItemTmp3Id  implements java.io.Serializable {


     private String itemCd;
     private String style;
     private String color;
     private String sz;
     private String prodLine;
     private String status;
     private String season;
     private String neverOut;

    public ItemTmp3Id() {
    }

    public ItemTmp3Id(String itemCd, String style, String color, String sz, String prodLine, String status, String season, String neverOut) {
       this.itemCd = itemCd;
       this.style = style;
       this.color = color;
       this.sz = sz;
       this.prodLine = prodLine;
       this.status = status;
       this.season = season;
       this.neverOut = neverOut;
    }
   


    @Column(name="ITEM_CD", length=50)
    public String getItemCd() {
        return this.itemCd;
    }
    
    public void setItemCd(String itemCd) {
        this.itemCd = itemCd;
    }


    @Column(name="STYLE", length=20)
    public String getStyle() {
        return this.style;
    }
    
    public void setStyle(String style) {
        this.style = style;
    }


    @Column(name="COLOR", length=20)
    public String getColor() {
        return this.color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }


    @Column(name="SZ", length=20)
    public String getSz() {
        return this.sz;
    }
    
    public void setSz(String sz) {
        this.sz = sz;
    }


    @Column(name="PROD_LINE", length=20)
    public String getProdLine() {
        return this.prodLine;
    }
    
    public void setProdLine(String prodLine) {
        this.prodLine = prodLine;
    }


    @Column(name="STATUS", length=10)
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }


    @Column(name="SEASON", length=20)
    public String getSeason() {
        return this.season;
    }
    
    public void setSeason(String season) {
        this.season = season;
    }


    @Column(name="NEVER_OUT", length=10)
    public String getNeverOut() {
        return this.neverOut;
    }
    
    public void setNeverOut(String neverOut) {
        this.neverOut = neverOut;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ItemTmp3Id) ) return false;
		 ItemTmp3Id castOther = ( ItemTmp3Id ) other; 
         
		 return ( (this.getItemCd()==castOther.getItemCd()) || ( this.getItemCd()!=null && castOther.getItemCd()!=null && this.getItemCd().equals(castOther.getItemCd()) ) )
 && ( (this.getStyle()==castOther.getStyle()) || ( this.getStyle()!=null && castOther.getStyle()!=null && this.getStyle().equals(castOther.getStyle()) ) )
 && ( (this.getColor()==castOther.getColor()) || ( this.getColor()!=null && castOther.getColor()!=null && this.getColor().equals(castOther.getColor()) ) )
 && ( (this.getSz()==castOther.getSz()) || ( this.getSz()!=null && castOther.getSz()!=null && this.getSz().equals(castOther.getSz()) ) )
 && ( (this.getProdLine()==castOther.getProdLine()) || ( this.getProdLine()!=null && castOther.getProdLine()!=null && this.getProdLine().equals(castOther.getProdLine()) ) )
 && ( (this.getStatus()==castOther.getStatus()) || ( this.getStatus()!=null && castOther.getStatus()!=null && this.getStatus().equals(castOther.getStatus()) ) )
 && ( (this.getSeason()==castOther.getSeason()) || ( this.getSeason()!=null && castOther.getSeason()!=null && this.getSeason().equals(castOther.getSeason()) ) )
 && ( (this.getNeverOut()==castOther.getNeverOut()) || ( this.getNeverOut()!=null && castOther.getNeverOut()!=null && this.getNeverOut().equals(castOther.getNeverOut()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getItemCd() == null ? 0 : this.getItemCd().hashCode() );
         result = 37 * result + ( getStyle() == null ? 0 : this.getStyle().hashCode() );
         result = 37 * result + ( getColor() == null ? 0 : this.getColor().hashCode() );
         result = 37 * result + ( getSz() == null ? 0 : this.getSz().hashCode() );
         result = 37 * result + ( getProdLine() == null ? 0 : this.getProdLine().hashCode() );
         result = 37 * result + ( getStatus() == null ? 0 : this.getStatus().hashCode() );
         result = 37 * result + ( getSeason() == null ? 0 : this.getSeason().hashCode() );
         result = 37 * result + ( getNeverOut() == null ? 0 : this.getNeverOut().hashCode() );
         return result;
   }   


}


