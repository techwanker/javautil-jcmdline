package com.pacificdataservices.diamond.models;
// Generated Apr 30, 2019 9:16:47 PM by Hibernate Tools 5.4.1.Final


import java.math.BigDecimal;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * OeItemHistFcstGrp generated by hbm2java
 */
@Entity
@Table(name="OE_ITEM_HIST_FCST_GRP"
    ,schema="AERODEMO"
)
public class OeItemHistFcstGrp  implements java.io.Serializable {


     private OeItemHistFcstGrpId id;
     private BigDecimal qtyOrdSum;

    public OeItemHistFcstGrp() {
    }

	
    public OeItemHistFcstGrp(OeItemHistFcstGrpId id) {
        this.id = id;
    }
    public OeItemHistFcstGrp(OeItemHistFcstGrpId id, BigDecimal qtyOrdSum) {
       this.id = id;
       this.qtyOrdSum = qtyOrdSum;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="itemNbrRqst", column=@Column(name="ITEM_NBR_RQST", nullable=false, precision=9, scale=0) ), 
        @AttributeOverride(name="itemCd", column=@Column(name="ITEM_CD", nullable=false, length=50) ), 
        @AttributeOverride(name="ordDtMm", column=@Column(name="ORD_DT_MM", nullable=false, length=7) ), 
        @AttributeOverride(name="fcstGrp", column=@Column(name="FCST_GRP", nullable=false, length=8) ) } )
    public OeItemHistFcstGrpId getId() {
        return this.id;
    }
    
    public void setId(OeItemHistFcstGrpId id) {
        this.id = id;
    }

    
    @Column(name="QTY_ORD_SUM", precision=22, scale=0)
    public BigDecimal getQtyOrdSum() {
        return this.qtyOrdSum;
    }
    
    public void setQtyOrdSum(BigDecimal qtyOrdSum) {
        this.qtyOrdSum = qtyOrdSum;
    }




}


