package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * SsTmp generated by hbm2java
 */
@Entity
@Table(name="SS_TMP"
)
public class SsTmp  implements java.io.Serializable {


     private SsTmpId id;

    public SsTmp() {
    }

    public SsTmp(SsTmpId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="fcItemMastNbr", column=@Column(name="FC_ITEM_MAST_NBR", nullable=false, precision=9, scale=0) ), 
        @AttributeOverride(name="ssAdj", column=@Column(name="SS_ADJ", precision=22, scale=0) ) } )
    public SsTmpId getId() {
        return this.id;
    }
    
    public void setId(SsTmpId id) {
        this.id = id;
    }




}


