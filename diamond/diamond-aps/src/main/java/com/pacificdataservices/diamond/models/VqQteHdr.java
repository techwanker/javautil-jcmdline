package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * VqQteHdr generated by hbm2java
 */
@Entity
@Table(name="VQ_QTE_HDR"
)
public class VqQteHdr  implements java.io.Serializable {


     private int vqQteHdrNbr;
     private PoVndMast poVndMast;
     private String vqQteCd;
     private Date vqQteDt;
     private String currCdQte;
     private String indivNmSpokenTo;
     private String indivPhnNbr;
     private String indivFaxNbr;
     private String indivEmailAddr;
     private Date vqQteEffDt;
     private Date vqQteExpDt;
     private String vndQteRefCd;
     private int vqQteIndivNbr;
     private int utUserNbr;
     private Date lastModDt;
     private String transmitFlg;
     private Set<VqQteDtl> vqQteDtls = new HashSet<VqQteDtl>(0);

    public VqQteHdr() {
    }

	
    public VqQteHdr(int vqQteHdrNbr, PoVndMast poVndMast, String vqQteCd, Date vqQteDt, String currCdQte, Date vqQteEffDt, Date vqQteExpDt, int vqQteIndivNbr, int utUserNbr, Date lastModDt, String transmitFlg) {
        this.vqQteHdrNbr = vqQteHdrNbr;
        this.poVndMast = poVndMast;
        this.vqQteCd = vqQteCd;
        this.vqQteDt = vqQteDt;
        this.currCdQte = currCdQte;
        this.vqQteEffDt = vqQteEffDt;
        this.vqQteExpDt = vqQteExpDt;
        this.vqQteIndivNbr = vqQteIndivNbr;
        this.utUserNbr = utUserNbr;
        this.lastModDt = lastModDt;
        this.transmitFlg = transmitFlg;
    }
    public VqQteHdr(int vqQteHdrNbr, PoVndMast poVndMast, String vqQteCd, Date vqQteDt, String currCdQte, String indivNmSpokenTo, String indivPhnNbr, String indivFaxNbr, String indivEmailAddr, Date vqQteEffDt, Date vqQteExpDt, String vndQteRefCd, int vqQteIndivNbr, int utUserNbr, Date lastModDt, String transmitFlg, Set<VqQteDtl> vqQteDtls) {
       this.vqQteHdrNbr = vqQteHdrNbr;
       this.poVndMast = poVndMast;
       this.vqQteCd = vqQteCd;
       this.vqQteDt = vqQteDt;
       this.currCdQte = currCdQte;
       this.indivNmSpokenTo = indivNmSpokenTo;
       this.indivPhnNbr = indivPhnNbr;
       this.indivFaxNbr = indivFaxNbr;
       this.indivEmailAddr = indivEmailAddr;
       this.vqQteEffDt = vqQteEffDt;
       this.vqQteExpDt = vqQteExpDt;
       this.vndQteRefCd = vndQteRefCd;
       this.vqQteIndivNbr = vqQteIndivNbr;
       this.utUserNbr = utUserNbr;
       this.lastModDt = lastModDt;
       this.transmitFlg = transmitFlg;
       this.vqQteDtls = vqQteDtls;
    }
   
     @Id 

    
    @Column(name="VQ_QTE_HDR_NBR", unique=true, nullable=false, precision=9, scale=0)
    public int getVqQteHdrNbr() {
        return this.vqQteHdrNbr;
    }
    
    public void setVqQteHdrNbr(int vqQteHdrNbr) {
        this.vqQteHdrNbr = vqQteHdrNbr;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ORG_NBR_VND", nullable=false)
    public PoVndMast getPoVndMast() {
        return this.poVndMast;
    }
    
    public void setPoVndMast(PoVndMast poVndMast) {
        this.poVndMast = poVndMast;
    }

    
    @Column(name="VQ_QTE_CD", unique=true, nullable=false, length=20)
    public String getVqQteCd() {
        return this.vqQteCd;
    }
    
    public void setVqQteCd(String vqQteCd) {
        this.vqQteCd = vqQteCd;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="VQ_QTE_DT", nullable=false, length=7)
    public Date getVqQteDt() {
        return this.vqQteDt;
    }
    
    public void setVqQteDt(Date vqQteDt) {
        this.vqQteDt = vqQteDt;
    }

    
    @Column(name="CURR_CD_QTE", nullable=false, length=9)
    public String getCurrCdQte() {
        return this.currCdQte;
    }
    
    public void setCurrCdQte(String currCdQte) {
        this.currCdQte = currCdQte;
    }

    
    @Column(name="INDIV_NM_SPOKEN_TO", length=40)
    public String getIndivNmSpokenTo() {
        return this.indivNmSpokenTo;
    }
    
    public void setIndivNmSpokenTo(String indivNmSpokenTo) {
        this.indivNmSpokenTo = indivNmSpokenTo;
    }

    
    @Column(name="INDIV_PHN_NBR", length=20)
    public String getIndivPhnNbr() {
        return this.indivPhnNbr;
    }
    
    public void setIndivPhnNbr(String indivPhnNbr) {
        this.indivPhnNbr = indivPhnNbr;
    }

    
    @Column(name="INDIV_FAX_NBR", length=20)
    public String getIndivFaxNbr() {
        return this.indivFaxNbr;
    }
    
    public void setIndivFaxNbr(String indivFaxNbr) {
        this.indivFaxNbr = indivFaxNbr;
    }

    
    @Column(name="INDIV_EMAIL_ADDR", length=40)
    public String getIndivEmailAddr() {
        return this.indivEmailAddr;
    }
    
    public void setIndivEmailAddr(String indivEmailAddr) {
        this.indivEmailAddr = indivEmailAddr;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="VQ_QTE_EFF_DT", nullable=false, length=7)
    public Date getVqQteEffDt() {
        return this.vqQteEffDt;
    }
    
    public void setVqQteEffDt(Date vqQteEffDt) {
        this.vqQteEffDt = vqQteEffDt;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="VQ_QTE_EXP_DT", nullable=false, length=7)
    public Date getVqQteExpDt() {
        return this.vqQteExpDt;
    }
    
    public void setVqQteExpDt(Date vqQteExpDt) {
        this.vqQteExpDt = vqQteExpDt;
    }

    
    @Column(name="VND_QTE_REF_CD", length=20)
    public String getVndQteRefCd() {
        return this.vndQteRefCd;
    }
    
    public void setVndQteRefCd(String vndQteRefCd) {
        this.vndQteRefCd = vndQteRefCd;
    }

    
    @Column(name="VQ_QTE_INDIV_NBR", nullable=false, precision=9, scale=0)
    public int getVqQteIndivNbr() {
        return this.vqQteIndivNbr;
    }
    
    public void setVqQteIndivNbr(int vqQteIndivNbr) {
        this.vqQteIndivNbr = vqQteIndivNbr;
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

    
    @Column(name="TRANSMIT_FLG", nullable=false, length=1)
    public String getTransmitFlg() {
        return this.transmitFlg;
    }
    
    public void setTransmitFlg(String transmitFlg) {
        this.transmitFlg = transmitFlg;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="vqQteHdr")
    public Set<VqQteDtl> getVqQteDtls() {
        return this.vqQteDtls;
    }
    
    public void setVqQteDtls(Set<VqQteDtl> vqQteDtls) {
        this.vqQteDtls = vqQteDtls;
    }




}

