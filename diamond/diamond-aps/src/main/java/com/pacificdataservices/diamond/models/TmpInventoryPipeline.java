package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * TmpInventoryPipeline generated by hbm2java
 */
@Entity
@Table(name="TMP_INVENTORY_PIPELINE"
)
public class TmpInventoryPipeline  implements java.io.Serializable {


     private TmpInventoryPipelineId id;

    public TmpInventoryPipeline() {
    }

    public TmpInventoryPipeline(TmpInventoryPipelineId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="pipelineDt", column=@Column(name="PIPELINE_DT", nullable=false, length=7) ), 
        @AttributeOverride(name="qtyOnHand", column=@Column(name="QTY_ON_HAND", precision=22, scale=0) ), 
        @AttributeOverride(name="openPoQty", column=@Column(name="OPEN_PO_QTY", precision=22, scale=0) ), 
        @AttributeOverride(name="openSoQty", column=@Column(name="OPEN_SO_QTY", precision=22, scale=0) ), 
        @AttributeOverride(name="safetyStkQty", column=@Column(name="SAFETY_STK_QTY", precision=22, scale=0) ), 
        @AttributeOverride(name="fcstQty", column=@Column(name="FCST_QTY", precision=22, scale=0) ), 
        @AttributeOverride(name="qtyOnHandRemain", column=@Column(name="QTY_ON_HAND_REMAIN", precision=22, scale=0) ), 
        @AttributeOverride(name="aroQty", column=@Column(name="ARO_QTY", precision=22, scale=0) ), 
        @AttributeOverride(name="onhandValue", column=@Column(name="ONHAND_VALUE", precision=22, scale=0) ), 
        @AttributeOverride(name="openPoValue", column=@Column(name="OPEN_PO_VALUE", precision=22, scale=0) ), 
        @AttributeOverride(name="openSoValue", column=@Column(name="OPEN_SO_VALUE", precision=22, scale=0) ), 
        @AttributeOverride(name="safetyStkValue", column=@Column(name="SAFETY_STK_VALUE", precision=22, scale=0) ), 
        @AttributeOverride(name="fcstValue", column=@Column(name="FCST_VALUE", precision=22, scale=0) ), 
        @AttributeOverride(name="remainValue", column=@Column(name="REMAIN_VALUE", precision=22, scale=0) ), 
        @AttributeOverride(name="aroValue", column=@Column(name="ARO_VALUE", precision=22, scale=0) ) } )
    public TmpInventoryPipelineId getId() {
        return this.id;
    }
    
    public void setId(TmpInventoryPipelineId id) {
        this.id = id;
    }




}


