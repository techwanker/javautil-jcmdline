package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UtProperty generated by hbm2java
 */
@Entity
@Table(name="UT_PROPERTY"
)
public class UtProperty  implements java.io.Serializable {


     private String propertyNm;
     private String propertyVal;

    public UtProperty() {
    }

	
    public UtProperty(String propertyNm) {
        this.propertyNm = propertyNm;
    }
    public UtProperty(String propertyNm, String propertyVal) {
       this.propertyNm = propertyNm;
       this.propertyVal = propertyVal;
    }
   
     @Id 

    
    @Column(name="PROPERTY_NM", unique=true, nullable=false)
    public String getPropertyNm() {
        return this.propertyNm;
    }
    
    public void setPropertyNm(String propertyNm) {
        this.propertyNm = propertyNm;
    }

    
    @Column(name="PROPERTY_VAL")
    public String getPropertyVal() {
        return this.propertyVal;
    }
    
    public void setPropertyVal(String propertyVal) {
        this.propertyVal = propertyVal;
    }




}

