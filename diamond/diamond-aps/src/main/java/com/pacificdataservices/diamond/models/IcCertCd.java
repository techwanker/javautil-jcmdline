package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * IcCertCd generated by hbm2java
 */
@Entity
@Table(name="IC_CERT_CD"
)
public class IcCertCd  implements java.io.Serializable {


     private String certCd;
     private String certCdDescr;
     private int utUserNbr;
     private Date lastModDt;
     private String docFlg;
     private Short certValue;
     private String certSrcId;
     private String statId;
     private Set<IcBomCert> icBomCerts = new HashSet<IcBomCert>(0);
     private Set<OeOrdDtlCert> oeOrdDtlCerts = new HashSet<OeOrdDtlCert>(0);
     private Set<OeCustMastCert> oeCustMastCerts = new HashSet<OeCustMastCert>(0);
     private Set<WoDtl> woDtls = new HashSet<WoDtl>(0);
     private Set<WoHdrCert> woHdrCerts = new HashSet<WoHdrCert>(0);
     private Set<PoLineHdrCert> poLineHdrCerts = new HashSet<PoLineHdrCert>(0);
     private Set<IcItemMastCert> icItemMastCerts = new HashSet<IcItemMastCert>(0);
     private Set<IcLotMastCert> icLotMastCerts = new HashSet<IcLotMastCert>(0);

    public IcCertCd() {
    }

	
    public IcCertCd(String certCd, int utUserNbr, Date lastModDt, String docFlg, String certSrcId) {
        this.certCd = certCd;
        this.utUserNbr = utUserNbr;
        this.lastModDt = lastModDt;
        this.docFlg = docFlg;
        this.certSrcId = certSrcId;
    }
    public IcCertCd(String certCd, String certCdDescr, int utUserNbr, Date lastModDt, String docFlg, Short certValue, String certSrcId, String statId, Set<IcBomCert> icBomCerts, Set<OeOrdDtlCert> oeOrdDtlCerts, Set<OeCustMastCert> oeCustMastCerts, Set<WoDtl> woDtls, Set<WoHdrCert> woHdrCerts, Set<PoLineHdrCert> poLineHdrCerts, Set<IcItemMastCert> icItemMastCerts, Set<IcLotMastCert> icLotMastCerts) {
       this.certCd = certCd;
       this.certCdDescr = certCdDescr;
       this.utUserNbr = utUserNbr;
       this.lastModDt = lastModDt;
       this.docFlg = docFlg;
       this.certValue = certValue;
       this.certSrcId = certSrcId;
       this.statId = statId;
       this.icBomCerts = icBomCerts;
       this.oeOrdDtlCerts = oeOrdDtlCerts;
       this.oeCustMastCerts = oeCustMastCerts;
       this.woDtls = woDtls;
       this.woHdrCerts = woHdrCerts;
       this.poLineHdrCerts = poLineHdrCerts;
       this.icItemMastCerts = icItemMastCerts;
       this.icLotMastCerts = icLotMastCerts;
    }
   
     @Id 

    
    @Column(name="CERT_CD", unique=true, nullable=false, length=8)
    public String getCertCd() {
        return this.certCd;
    }
    
    public void setCertCd(String certCd) {
        this.certCd = certCd;
    }

    
    @Column(name="CERT_CD_DESCR", length=60)
    public String getCertCdDescr() {
        return this.certCdDescr;
    }
    
    public void setCertCdDescr(String certCdDescr) {
        this.certCdDescr = certCdDescr;
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

    
    @Column(name="DOC_FLG", nullable=false, length=1)
    public String getDocFlg() {
        return this.docFlg;
    }
    
    public void setDocFlg(String docFlg) {
        this.docFlg = docFlg;
    }

    
    @Column(name="CERT_VALUE", precision=3, scale=0)
    public Short getCertValue() {
        return this.certValue;
    }
    
    public void setCertValue(Short certValue) {
        this.certValue = certValue;
    }

    
    @Column(name="CERT_SRC_ID", nullable=false, length=1)
    public String getCertSrcId() {
        return this.certSrcId;
    }
    
    public void setCertSrcId(String certSrcId) {
        this.certSrcId = certSrcId;
    }

    
    @Column(name="STAT_ID", length=1)
    public String getStatId() {
        return this.statId;
    }
    
    public void setStatId(String statId) {
        this.statId = statId;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="icCertCd")
    public Set<IcBomCert> getIcBomCerts() {
        return this.icBomCerts;
    }
    
    public void setIcBomCerts(Set<IcBomCert> icBomCerts) {
        this.icBomCerts = icBomCerts;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="icCertCd")
    public Set<OeOrdDtlCert> getOeOrdDtlCerts() {
        return this.oeOrdDtlCerts;
    }
    
    public void setOeOrdDtlCerts(Set<OeOrdDtlCert> oeOrdDtlCerts) {
        this.oeOrdDtlCerts = oeOrdDtlCerts;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="icCertCd")
    public Set<OeCustMastCert> getOeCustMastCerts() {
        return this.oeCustMastCerts;
    }
    
    public void setOeCustMastCerts(Set<OeCustMastCert> oeCustMastCerts) {
        this.oeCustMastCerts = oeCustMastCerts;
    }

@ManyToMany(fetch=FetchType.LAZY, mappedBy="icCertCds")
    public Set<WoDtl> getWoDtls() {
        return this.woDtls;
    }
    
    public void setWoDtls(Set<WoDtl> woDtls) {
        this.woDtls = woDtls;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="icCertCd")
    public Set<WoHdrCert> getWoHdrCerts() {
        return this.woHdrCerts;
    }
    
    public void setWoHdrCerts(Set<WoHdrCert> woHdrCerts) {
        this.woHdrCerts = woHdrCerts;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="icCertCd")
    public Set<PoLineHdrCert> getPoLineHdrCerts() {
        return this.poLineHdrCerts;
    }
    
    public void setPoLineHdrCerts(Set<PoLineHdrCert> poLineHdrCerts) {
        this.poLineHdrCerts = poLineHdrCerts;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="icCertCd")
    public Set<IcItemMastCert> getIcItemMastCerts() {
        return this.icItemMastCerts;
    }
    
    public void setIcItemMastCerts(Set<IcItemMastCert> icItemMastCerts) {
        this.icItemMastCerts = icItemMastCerts;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="icCertCd")
    public Set<IcLotMastCert> getIcLotMastCerts() {
        return this.icLotMastCerts;
    }
    
    public void setIcLotMastCerts(Set<IcLotMastCert> icLotMastCerts) {
        this.icLotMastCerts = icLotMastCerts;
    }




}

