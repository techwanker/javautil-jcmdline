package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * InventoryPipelineVw generated by hbm2java
 */
@Entity
@Table(name="INVENTORY_PIPELINE_VW"
)
public class InventoryPipelineVw  implements java.io.Serializable {


     private InventoryPipelineVwId id;

    public InventoryPipelineVw() {
    }

    public InventoryPipelineVw(InventoryPipelineVwId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="typ", column=@Column(name="TYP", length=12) ), 
        @AttributeOverride(name="mnth1", column=@Column(name="MNTH_1", precision=22, scale=0) ), 
        @AttributeOverride(name="mnth2", column=@Column(name="MNTH_2", precision=22, scale=0) ), 
        @AttributeOverride(name="mnth3", column=@Column(name="MNTH_3", precision=22, scale=0) ), 
        @AttributeOverride(name="mnth4", column=@Column(name="MNTH_4", precision=22, scale=0) ), 
        @AttributeOverride(name="mnth5", column=@Column(name="MNTH_5", precision=22, scale=0) ), 
        @AttributeOverride(name="mnth6", column=@Column(name="MNTH_6", precision=22, scale=0) ), 
        @AttributeOverride(name="mnth7", column=@Column(name="MNTH_7", precision=22, scale=0) ), 
        @AttributeOverride(name="mnth8", column=@Column(name="MNTH_8", precision=22, scale=0) ), 
        @AttributeOverride(name="mnth9", column=@Column(name="MNTH_9", precision=22, scale=0) ), 
        @AttributeOverride(name="mnth10", column=@Column(name="MNTH_10", precision=22, scale=0) ), 
        @AttributeOverride(name="mnth11", column=@Column(name="MNTH_11", precision=22, scale=0) ), 
        @AttributeOverride(name="mnth12", column=@Column(name="MNTH_12", precision=22, scale=0) ), 
        @AttributeOverride(name="total", column=@Column(name="TOTAL", precision=22, scale=0) ) } )
    public InventoryPipelineVwId getId() {
        return this.id;
    }
    
    public void setId(InventoryPipelineVwId id) {
        this.id = id;
    }




}


