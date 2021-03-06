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
 * FcHdrTmp generated by hbm2java
 */
@Entity
@Table(name="FC_HDR_TMP"
)
public class FcHdrTmp  implements java.io.Serializable {


     private FcHdrTmpId id;
     private BigDecimal rawFcstTot;

    public FcHdrTmp() {
    }

	
    public FcHdrTmp(FcHdrTmpId id) {
        this.id = id;
    }
    public FcHdrTmp(FcHdrTmpId id, BigDecimal rawFcstTot) {
       this.id = id;
       this.rawFcstTot = rawFcstTot;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="userFld1", column=@Column(name="USER_FLD_1", nullable=false, length=20) ), 
        @AttributeOverride(name="userFld2", column=@Column(name="USER_FLD_2", nullable=false, length=20) ) } )
    public FcHdrTmpId getId() {
        return this.id;
    }
    
    public void setId(FcHdrTmpId id) {
        this.id = id;
    }

    
    @Column(name="RAW_FCST_TOT", precision=22, scale=0)
    public BigDecimal getRawFcstTot() {
        return this.rawFcstTot;
    }
    
    public void setRawFcstTot(BigDecimal rawFcstTot) {
        this.rawFcstTot = rawFcstTot;
    }




}


