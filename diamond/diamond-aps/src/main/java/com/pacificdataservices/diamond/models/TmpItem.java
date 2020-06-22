package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TmpItem generated by hbm2java
 */
@Entity
@Table(name="TMP_ITEM"
)
public class TmpItem  implements java.io.Serializable {


     private int itemNbr;

    public TmpItem() {
    }

    public TmpItem(int itemNbr) {
       this.itemNbr = itemNbr;
    }
   
     @Id 

    
    @Column(name="ITEM_NBR", nullable=false, precision=9, scale=0)
    public int getItemNbr() {
        return this.itemNbr;
    }
    
    public void setItemNbr(int itemNbr) {
        this.itemNbr = itemNbr;
    }




}

