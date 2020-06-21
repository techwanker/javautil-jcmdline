package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


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
 * PoLineHdrCert generated by hbm2java
 */
@Entity
@Table(name="PO_LINE_HDR_CERT"
)
public class PoLineHdrCert  implements java.io.Serializable {


     private PoLineHdrCertId id;
     private PoLineHdr poLineHdr;
     private IcCertCd icCertCd;
     private int utUserNbr;
     private Date lastModDt;

    public PoLineHdrCert() {
    }

    public PoLineHdrCert(PoLineHdrCertId id, PoLineHdr poLineHdr, IcCertCd icCertCd, int utUserNbr, Date lastModDt) {
       this.id = id;
       this.poLineHdr = poLineHdr;
       this.icCertCd = icCertCd;
       this.utUserNbr = utUserNbr;
       this.lastModDt = lastModDt;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="poLineHdrNbr", column=@Column(name="PO_LINE_HDR_NBR", nullable=false, precision=9, scale=0) ), 
        @AttributeOverride(name="certCd", column=@Column(name="CERT_CD", nullable=false, length=8) ) } )
    public PoLineHdrCertId getId() {
        return this.id;
    }
    
    public void setId(PoLineHdrCertId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PO_LINE_HDR_NBR", nullable=false, insertable=false, updatable=false)
    public PoLineHdr getPoLineHdr() {
        return this.poLineHdr;
    }
    
    public void setPoLineHdr(PoLineHdr poLineHdr) {
        this.poLineHdr = poLineHdr;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="CERT_CD", nullable=false, insertable=false, updatable=false)
    public IcCertCd getIcCertCd() {
        return this.icCertCd;
    }
    
    public void setIcCertCd(IcCertCd icCertCd) {
        this.icCertCd = icCertCd;
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


