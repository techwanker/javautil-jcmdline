package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * ForecastSummaryVw generated by hbm2java
 */
@Entity
@Table(name="FORECAST_SUMMARY_VW"
)
public class ForecastSummaryVw  implements java.io.Serializable {


     private ForecastSummaryVwId id;

    public ForecastSummaryVw() {
    }

    public ForecastSummaryVw(ForecastSummaryVwId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="month", column=@Column(name="MONTH") ), 
        @AttributeOverride(name="itemCd", column=@Column(name="ITEM_CD") ), 
        @AttributeOverride(name="userFld1", column=@Column(name="USER_FLD_1") ), 
        @AttributeOverride(name="userFld2", column=@Column(name="USER_FLD_2") ), 
        @AttributeOverride(name="userFld3", column=@Column(name="USER_FLD_3") ), 
        @AttributeOverride(name="userFld4", column=@Column(name="USER_FLD_4") ), 
        @AttributeOverride(name="userFld5", column=@Column(name="USER_FLD_5") ), 
        @AttributeOverride(name="userFld6", column=@Column(name="USER_FLD_6") ), 
        @AttributeOverride(name="userFld7", column=@Column(name="USER_FLD_7") ), 
        @AttributeOverride(name="userFld8", column=@Column(name="USER_FLD_8") ), 
        @AttributeOverride(name="fcstGrp", column=@Column(name="FCST_GRP") ), 
        @AttributeOverride(name="totalUnits", column=@Column(name="TOTAL_UNITS") ), 
        @AttributeOverride(name="totalCost", column=@Column(name="TOTAL_COST") ), 
        @AttributeOverride(name="totalPrice", column=@Column(name="TOTAL_PRICE") ), 
        @AttributeOverride(name="margin", column=@Column(name="MARGIN") ) } )
    public ForecastSummaryVwId getId() {
        return this.id;
    }
    
    public void setId(ForecastSummaryVwId id) {
        this.id = id;
    }




}


