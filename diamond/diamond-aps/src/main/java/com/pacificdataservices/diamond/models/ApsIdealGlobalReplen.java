package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import java.math.BigDecimal;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * ApsIdealGlobalReplen generated by hbm2java
 */
@Entity
@Table(name="APS_IDEAL_GLOBAL_REPLEN"
)
public class ApsIdealGlobalReplen  implements java.io.Serializable {


     private ApsIdealGlobalReplenId id;
     private BigDecimal replenQty;

    public ApsIdealGlobalReplen() {
    }

	
    public ApsIdealGlobalReplen(ApsIdealGlobalReplenId id) {
        this.id = id;
    }
    public ApsIdealGlobalReplen(ApsIdealGlobalReplenId id, BigDecimal replenQty) {
       this.id = id;
       this.replenQty = replenQty;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="itemNbr", column=@Column(name="ITEM_NBR", nullable=false, precision=9, scale=0) ), 
        @AttributeOverride(name="replenDt", column=@Column(name="REPLEN_DT", nullable=false, length=7) ) } )
    public ApsIdealGlobalReplenId getId() {
        return this.id;
    }
    
    public void setId(ApsIdealGlobalReplenId id) {
        this.id = id;
    }

    
    @Column(name="REPLEN_QTY", precision=17, scale=5)
    public BigDecimal getReplenQty() {
        return this.replenQty;
    }
    
    public void setReplenQty(BigDecimal replenQty) {
        this.replenQty = replenQty;
    }




}


