package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * IcItemMastEquivRef generated by hbm2java
 */
@Entity
@Table(name="IC_ITEM_MAST_EQUIV_REF"
)
public class IcItemMastEquivRef  implements java.io.Serializable {


     private IcItemMastEquivRefId id;
     private int utUserNbr;
     private Date lastModDt;

    public IcItemMastEquivRef() {
    }

    public IcItemMastEquivRef(IcItemMastEquivRefId id, int utUserNbr, Date lastModDt) {
       this.id = id;
       this.utUserNbr = utUserNbr;
       this.lastModDt = lastModDt;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="itemNbr", column=@Column(name="ITEM_NBR", nullable=false, precision=9, scale=0) ), 
        @AttributeOverride(name="itemNbrEquiv", column=@Column(name="ITEM_NBR_EQUIV", nullable=false, precision=9, scale=0) ) } )
    public IcItemMastEquivRefId getId() {
        return this.id;
    }
    
    public void setId(IcItemMastEquivRefId id) {
        this.id = id;
    }

    
    @Column(name="UT_USER_NBR", nullable=false, precision=9, scale=0)
    public int getUtUserNbr() {
        return this.utUserNbr;
    }
    
    public void setUtUserNbr(int utUserNbr) {
        this.utUserNbr = utUserNbr;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="LAST_MOD_DT", nullable=false, length=7)
    public Date getLastModDt() {
        return this.lastModDt;
    }
    
    public void setLastModDt(Date lastModDt) {
        this.lastModDt = lastModDt;
    }




}


