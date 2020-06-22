package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TmpIcItemMastAttr generated by hbm2java
 */
@Entity
@Table(name="TMP_IC_ITEM_MAST_ATTR"
)
public class TmpIcItemMastAttr  implements java.io.Serializable {


     private int itemNbr;
     private String userFld1;
     private String userFld2;
     private String userFld3;
     private String userFld4;
     private String userFld5;
     private String userFld6;
     private String userFld7;
     private String userFld8;
     private String attrString;

    public TmpIcItemMastAttr() {
    }

	
    public TmpIcItemMastAttr(int itemNbr) {
        this.itemNbr = itemNbr;
    }
    public TmpIcItemMastAttr(int itemNbr, String userFld1, String userFld2, String userFld3, String userFld4, String userFld5, String userFld6, String userFld7, String userFld8, String attrString) {
       this.itemNbr = itemNbr;
       this.userFld1 = userFld1;
       this.userFld2 = userFld2;
       this.userFld3 = userFld3;
       this.userFld4 = userFld4;
       this.userFld5 = userFld5;
       this.userFld6 = userFld6;
       this.userFld7 = userFld7;
       this.userFld8 = userFld8;
       this.attrString = attrString;
    }
   
     @Id 

    
    @Column(name="ITEM_NBR", unique=true, nullable=false, precision=9, scale=0)
    public int getItemNbr() {
        return this.itemNbr;
    }
    
    public void setItemNbr(int itemNbr) {
        this.itemNbr = itemNbr;
    }

    
    @Column(name="USER_FLD_1", length=20)
    public String getUserFld1() {
        return this.userFld1;
    }
    
    public void setUserFld1(String userFld1) {
        this.userFld1 = userFld1;
    }

    
    @Column(name="USER_FLD_2", length=20)
    public String getUserFld2() {
        return this.userFld2;
    }
    
    public void setUserFld2(String userFld2) {
        this.userFld2 = userFld2;
    }

    
    @Column(name="USER_FLD_3", length=20)
    public String getUserFld3() {
        return this.userFld3;
    }
    
    public void setUserFld3(String userFld3) {
        this.userFld3 = userFld3;
    }

    
    @Column(name="USER_FLD_4", length=20)
    public String getUserFld4() {
        return this.userFld4;
    }
    
    public void setUserFld4(String userFld4) {
        this.userFld4 = userFld4;
    }

    
    @Column(name="USER_FLD_5", length=20)
    public String getUserFld5() {
        return this.userFld5;
    }
    
    public void setUserFld5(String userFld5) {
        this.userFld5 = userFld5;
    }

    
    @Column(name="USER_FLD_6", length=20)
    public String getUserFld6() {
        return this.userFld6;
    }
    
    public void setUserFld6(String userFld6) {
        this.userFld6 = userFld6;
    }

    
    @Column(name="USER_FLD_7", length=20)
    public String getUserFld7() {
        return this.userFld7;
    }
    
    public void setUserFld7(String userFld7) {
        this.userFld7 = userFld7;
    }

    
    @Column(name="USER_FLD_8", length=20)
    public String getUserFld8() {
        return this.userFld8;
    }
    
    public void setUserFld8(String userFld8) {
        this.userFld8 = userFld8;
    }

    
    @Column(name="ATTR_STRING", length=200)
    public String getAttrString() {
        return this.attrString;
    }
    
    public void setAttrString(String attrString) {
        this.attrString = attrString;
    }




}

