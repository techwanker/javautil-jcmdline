package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import java.sql.Clob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UtXsl generated by hbm2java
 */
@Entity
@Table(name="UT_XSL"
)
public class UtXsl  implements java.io.Serializable {


     private String xslId;
     private long utXslNbr;
     private String fileName;
     private Clob stylesheet;

    public UtXsl() {
    }

	
    public UtXsl(String xslId, long utXslNbr) {
        this.xslId = xslId;
        this.utXslNbr = utXslNbr;
    }
    public UtXsl(String xslId, long utXslNbr, String fileName, Clob stylesheet) {
       this.xslId = xslId;
       this.utXslNbr = utXslNbr;
       this.fileName = fileName;
       this.stylesheet = stylesheet;
    }
   
     @Id 

    
    @Column(name="XSL_ID", unique=true, nullable=false, length=32)
    public String getXslId() {
        return this.xslId;
    }
    
    public void setXslId(String xslId) {
        this.xslId = xslId;
    }

    
    @Column(name="UT_XSL_NBR", unique=true, nullable=false, precision=18, scale=0)
    public long getUtXslNbr() {
        return this.utXslNbr;
    }
    
    public void setUtXslNbr(long utXslNbr) {
        this.utXslNbr = utXslNbr;
    }

    
    @Column(name="FILE_NAME")
    public String getFileName() {
        return this.fileName;
    }
    
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    
    @Column(name="STYLESHEET")
    public Clob getStylesheet() {
        return this.stylesheet;
    }
    
    public void setStylesheet(Clob stylesheet) {
        this.stylesheet = stylesheet;
    }




}

