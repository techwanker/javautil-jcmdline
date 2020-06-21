package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IcBomId generated by hbm2java
 */
@Embeddable
public class IcBomId  implements java.io.Serializable {


     private int itemNbr;
     private Integer itemNbrParent;
     private BigDecimal childQty;
     private String childUm;
     private int utUserNbr;
     private Date lastModDt;
     private String mixMfrLotFlg;
     private String printBagLblFlg;
     private String revLvl;
     private Integer orgNbrMfrRqst;
     private String mandatoryItemFlg;

    public IcBomId() {
    }

	
    public IcBomId(int itemNbr, BigDecimal childQty, String childUm, int utUserNbr, Date lastModDt, String mixMfrLotFlg, String printBagLblFlg, String mandatoryItemFlg) {
        this.itemNbr = itemNbr;
        this.childQty = childQty;
        this.childUm = childUm;
        this.utUserNbr = utUserNbr;
        this.lastModDt = lastModDt;
        this.mixMfrLotFlg = mixMfrLotFlg;
        this.printBagLblFlg = printBagLblFlg;
        this.mandatoryItemFlg = mandatoryItemFlg;
    }
    public IcBomId(int itemNbr, Integer itemNbrParent, BigDecimal childQty, String childUm, int utUserNbr, Date lastModDt, String mixMfrLotFlg, String printBagLblFlg, String revLvl, Integer orgNbrMfrRqst, String mandatoryItemFlg) {
       this.itemNbr = itemNbr;
       this.itemNbrParent = itemNbrParent;
       this.childQty = childQty;
       this.childUm = childUm;
       this.utUserNbr = utUserNbr;
       this.lastModDt = lastModDt;
       this.mixMfrLotFlg = mixMfrLotFlg;
       this.printBagLblFlg = printBagLblFlg;
       this.revLvl = revLvl;
       this.orgNbrMfrRqst = orgNbrMfrRqst;
       this.mandatoryItemFlg = mandatoryItemFlg;
    }
   


    @Column(name="ITEM_NBR", nullable=false, precision=9, scale=0)
    public int getItemNbr() {
        return this.itemNbr;
    }
    
    public void setItemNbr(int itemNbr) {
        this.itemNbr = itemNbr;
    }


    @Column(name="ITEM_NBR_PARENT", precision=9, scale=0)
    public Integer getItemNbrParent() {
        return this.itemNbrParent;
    }
    
    public void setItemNbrParent(Integer itemNbrParent) {
        this.itemNbrParent = itemNbrParent;
    }


    @Column(name="CHILD_QTY", nullable=false, precision=13, scale=6)
    public BigDecimal getChildQty() {
        return this.childQty;
    }
    
    public void setChildQty(BigDecimal childQty) {
        this.childQty = childQty;
    }


    @Column(name="CHILD_UM", nullable=false, length=3)
    public String getChildUm() {
        return this.childUm;
    }
    
    public void setChildUm(String childUm) {
        this.childUm = childUm;
    }


    @Column(name="UT_USER_NBR", nullable=false, precision=9, scale=0)
    public int getUtUserNbr() {
        return this.utUserNbr;
    }
    
    public void setUtUserNbr(int utUserNbr) {
        this.utUserNbr = utUserNbr;
    }


    @Column(name="LAST_MOD_DT", nullable=false, length=7)
    public Date getLastModDt() {
        return this.lastModDt;
    }
    
    public void setLastModDt(Date lastModDt) {
        this.lastModDt = lastModDt;
    }


    @Column(name="MIX_MFR_LOT_FLG", nullable=false, length=1)
    public String getMixMfrLotFlg() {
        return this.mixMfrLotFlg;
    }
    
    public void setMixMfrLotFlg(String mixMfrLotFlg) {
        this.mixMfrLotFlg = mixMfrLotFlg;
    }


    @Column(name="PRINT_BAG_LBL_FLG", nullable=false, length=1)
    public String getPrintBagLblFlg() {
        return this.printBagLblFlg;
    }
    
    public void setPrintBagLblFlg(String printBagLblFlg) {
        this.printBagLblFlg = printBagLblFlg;
    }


    @Column(name="REV_LVL", length=5)
    public String getRevLvl() {
        return this.revLvl;
    }
    
    public void setRevLvl(String revLvl) {
        this.revLvl = revLvl;
    }


    @Column(name="ORG_NBR_MFR_RQST", precision=9, scale=0)
    public Integer getOrgNbrMfrRqst() {
        return this.orgNbrMfrRqst;
    }
    
    public void setOrgNbrMfrRqst(Integer orgNbrMfrRqst) {
        this.orgNbrMfrRqst = orgNbrMfrRqst;
    }


    @Column(name="MANDATORY_ITEM_FLG", nullable=false, length=1)
    public String getMandatoryItemFlg() {
        return this.mandatoryItemFlg;
    }
    
    public void setMandatoryItemFlg(String mandatoryItemFlg) {
        this.mandatoryItemFlg = mandatoryItemFlg;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof IcBomId) ) return false;
		 IcBomId castOther = ( IcBomId ) other; 
         
		 return (this.getItemNbr()==castOther.getItemNbr())
 && ( (this.getItemNbrParent()==castOther.getItemNbrParent()) || ( this.getItemNbrParent()!=null && castOther.getItemNbrParent()!=null && this.getItemNbrParent().equals(castOther.getItemNbrParent()) ) )
 && ( (this.getChildQty()==castOther.getChildQty()) || ( this.getChildQty()!=null && castOther.getChildQty()!=null && this.getChildQty().equals(castOther.getChildQty()) ) )
 && ( (this.getChildUm()==castOther.getChildUm()) || ( this.getChildUm()!=null && castOther.getChildUm()!=null && this.getChildUm().equals(castOther.getChildUm()) ) )
 && (this.getUtUserNbr()==castOther.getUtUserNbr())
 && ( (this.getLastModDt()==castOther.getLastModDt()) || ( this.getLastModDt()!=null && castOther.getLastModDt()!=null && this.getLastModDt().equals(castOther.getLastModDt()) ) )
 && ( (this.getMixMfrLotFlg()==castOther.getMixMfrLotFlg()) || ( this.getMixMfrLotFlg()!=null && castOther.getMixMfrLotFlg()!=null && this.getMixMfrLotFlg().equals(castOther.getMixMfrLotFlg()) ) )
 && ( (this.getPrintBagLblFlg()==castOther.getPrintBagLblFlg()) || ( this.getPrintBagLblFlg()!=null && castOther.getPrintBagLblFlg()!=null && this.getPrintBagLblFlg().equals(castOther.getPrintBagLblFlg()) ) )
 && ( (this.getRevLvl()==castOther.getRevLvl()) || ( this.getRevLvl()!=null && castOther.getRevLvl()!=null && this.getRevLvl().equals(castOther.getRevLvl()) ) )
 && ( (this.getOrgNbrMfrRqst()==castOther.getOrgNbrMfrRqst()) || ( this.getOrgNbrMfrRqst()!=null && castOther.getOrgNbrMfrRqst()!=null && this.getOrgNbrMfrRqst().equals(castOther.getOrgNbrMfrRqst()) ) )
 && ( (this.getMandatoryItemFlg()==castOther.getMandatoryItemFlg()) || ( this.getMandatoryItemFlg()!=null && castOther.getMandatoryItemFlg()!=null && this.getMandatoryItemFlg().equals(castOther.getMandatoryItemFlg()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getItemNbr();
         result = 37 * result + ( getItemNbrParent() == null ? 0 : this.getItemNbrParent().hashCode() );
         result = 37 * result + ( getChildQty() == null ? 0 : this.getChildQty().hashCode() );
         result = 37 * result + ( getChildUm() == null ? 0 : this.getChildUm().hashCode() );
         result = 37 * result + this.getUtUserNbr();
         result = 37 * result + ( getLastModDt() == null ? 0 : this.getLastModDt().hashCode() );
         result = 37 * result + ( getMixMfrLotFlg() == null ? 0 : this.getMixMfrLotFlg().hashCode() );
         result = 37 * result + ( getPrintBagLblFlg() == null ? 0 : this.getPrintBagLblFlg().hashCode() );
         result = 37 * result + ( getRevLvl() == null ? 0 : this.getRevLvl().hashCode() );
         result = 37 * result + ( getOrgNbrMfrRqst() == null ? 0 : this.getOrgNbrMfrRqst().hashCode() );
         result = 37 * result + ( getMandatoryItemFlg() == null ? 0 : this.getMandatoryItemFlg().hashCode() );
         return result;
   }   


}


