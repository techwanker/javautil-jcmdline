package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * IcItemOperationYield generated by hbm2java
 */
@Entity
@Table(name="IC_ITEM_OPERATION_YIELD"
)
public class IcItemOperationYield  implements java.io.Serializable {


     private IcItemOperationYieldId id;
     private IcItemMast icItemMast;
     private BigDecimal yieldPct;
     private int utUserNbr;
     private Date lastModDt;

    public IcItemOperationYield() {
    }

    public IcItemOperationYield(IcItemOperationYieldId id, IcItemMast icItemMast, BigDecimal yieldPct, int utUserNbr, Date lastModDt) {
       this.id = id;
       this.icItemMast = icItemMast;
       this.yieldPct = yieldPct;
       this.utUserNbr = utUserNbr;
       this.lastModDt = lastModDt;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="itemNbr", column=@Column(name="ITEM_NBR", nullable=false, precision=9, scale=0) ), 
        @AttributeOverride(name="operationCd", column=@Column(name="OPERATION_CD", nullable=false, length=16) ) } )
    public IcItemOperationYieldId getId() {
        return this.id;
    }
    
    public void setId(IcItemOperationYieldId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ITEM_NBR", nullable=false, insertable=false, updatable=false)
    public IcItemMast getIcItemMast() {
        return this.icItemMast;
    }
    
    public void setIcItemMast(IcItemMast icItemMast) {
        this.icItemMast = icItemMast;
    }

    
    @Column(name="YIELD_PCT", nullable=false, precision=5)
    public BigDecimal getYieldPct() {
        return this.yieldPct;
    }
    
    public void setYieldPct(BigDecimal yieldPct) {
        this.yieldPct = yieldPct;
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


