package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TmpPoItemRevLvlId generated by hbm2java
 */
@Embeddable
public class TmpPoItemRevLvlId  implements java.io.Serializable {


     private Integer poLineHdrNbr;
     private Integer poLineDtlNbr;
     private Integer itemNbr;
     private String revLvl;

    public TmpPoItemRevLvlId() {
    }

    public TmpPoItemRevLvlId(Integer poLineHdrNbr, Integer poLineDtlNbr, Integer itemNbr, String revLvl) {
       this.poLineHdrNbr = poLineHdrNbr;
       this.poLineDtlNbr = poLineDtlNbr;
       this.itemNbr = itemNbr;
       this.revLvl = revLvl;
    }
   


    @Column(name="PO_LINE_HDR_NBR", precision=9, scale=0)
    public Integer getPoLineHdrNbr() {
        return this.poLineHdrNbr;
    }
    
    public void setPoLineHdrNbr(Integer poLineHdrNbr) {
        this.poLineHdrNbr = poLineHdrNbr;
    }


    @Column(name="PO_LINE_DTL_NBR", precision=9, scale=0)
    public Integer getPoLineDtlNbr() {
        return this.poLineDtlNbr;
    }
    
    public void setPoLineDtlNbr(Integer poLineDtlNbr) {
        this.poLineDtlNbr = poLineDtlNbr;
    }


    @Column(name="ITEM_NBR", precision=9, scale=0)
    public Integer getItemNbr() {
        return this.itemNbr;
    }
    
    public void setItemNbr(Integer itemNbr) {
        this.itemNbr = itemNbr;
    }


    @Column(name="REV_LVL", length=5)
    public String getRevLvl() {
        return this.revLvl;
    }
    
    public void setRevLvl(String revLvl) {
        this.revLvl = revLvl;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof TmpPoItemRevLvlId) ) return false;
		 TmpPoItemRevLvlId castOther = ( TmpPoItemRevLvlId ) other; 
         
		 return ( (this.getPoLineHdrNbr()==castOther.getPoLineHdrNbr()) || ( this.getPoLineHdrNbr()!=null && castOther.getPoLineHdrNbr()!=null && this.getPoLineHdrNbr().equals(castOther.getPoLineHdrNbr()) ) )
 && ( (this.getPoLineDtlNbr()==castOther.getPoLineDtlNbr()) || ( this.getPoLineDtlNbr()!=null && castOther.getPoLineDtlNbr()!=null && this.getPoLineDtlNbr().equals(castOther.getPoLineDtlNbr()) ) )
 && ( (this.getItemNbr()==castOther.getItemNbr()) || ( this.getItemNbr()!=null && castOther.getItemNbr()!=null && this.getItemNbr().equals(castOther.getItemNbr()) ) )
 && ( (this.getRevLvl()==castOther.getRevLvl()) || ( this.getRevLvl()!=null && castOther.getRevLvl()!=null && this.getRevLvl().equals(castOther.getRevLvl()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getPoLineHdrNbr() == null ? 0 : this.getPoLineHdrNbr().hashCode() );
         result = 37 * result + ( getPoLineDtlNbr() == null ? 0 : this.getPoLineDtlNbr().hashCode() );
         result = 37 * result + ( getItemNbr() == null ? 0 : this.getItemNbr().hashCode() );
         result = 37 * result + ( getRevLvl() == null ? 0 : this.getRevLvl().hashCode() );
         return result;
   }   


}


