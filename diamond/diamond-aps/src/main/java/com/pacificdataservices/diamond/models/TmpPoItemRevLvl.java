package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * TmpPoItemRevLvl generated by hbm2java
 */
@Entity
@Table(name="TMP_PO_ITEM_REV_LVL"
)
public class TmpPoItemRevLvl  implements java.io.Serializable {


     private TmpPoItemRevLvlId id;

    public TmpPoItemRevLvl() {
    }

    public TmpPoItemRevLvl(TmpPoItemRevLvlId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="poLineHdrNbr", column=@Column(name="PO_LINE_HDR_NBR", precision=9, scale=0) ), 
        @AttributeOverride(name="poLineDtlNbr", column=@Column(name="PO_LINE_DTL_NBR", precision=9, scale=0) ), 
        @AttributeOverride(name="itemNbr", column=@Column(name="ITEM_NBR", precision=9, scale=0) ), 
        @AttributeOverride(name="revLvl", column=@Column(name="REV_LVL", length=5) ) } )
    public TmpPoItemRevLvlId getId() {
        return this.id;
    }
    
    public void setId(TmpPoItemRevLvlId id) {
        this.id = id;
    }




}


