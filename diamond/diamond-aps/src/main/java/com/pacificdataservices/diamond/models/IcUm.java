package com.pacificdataservices.diamond.models;
// Generated Feb 5, 2019 2:39:27 AM by Hibernate Tools 5.4.1.Final


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * IcUm generated by hbm2java
 */
@Entity
@Table(name="IC_UM"
)
public class IcUm  implements java.io.Serializable {


     private String umId;
     private String umIdDescr;
     private String umFamily;
     private int utUserNbr;
     private Date lastModDt;
     private Boolean umPrecision;
     private Set<PoLineHdr> poLineHdrs = new HashSet<PoLineHdr>(0);
     private Set<IcUmCnvtItem> icUmCnvtItemsForUmIdTo = new HashSet<IcUmCnvtItem>(0);
//     private Set<WoHdr> woHdrs = new HashSet<WoHdr>(0);
 //    private Set<ArInvDtl> arInvDtls = new HashSet<ArInvDtl>(0);
 //    private Set<ArRmaRcpt> arRmaRcpts = new HashSet<ArRmaRcpt>(0);
//     private Set<IcLotMast> icLotMasts = new HashSet<IcLotMast>(0);
  //   private Set<OeOrdDtl> oeOrdDtls = new HashSet<OeOrdDtl>(0);
//     private Set<IcItemMast> icItemMastsForStkUm = new HashSet<IcItemMast>(0);
//     private Set<IcItemMast> icItemMastsForSellUm = new HashSet<IcItemMast>(0);
//     private Set<WoDtl> woDtls = new HashSet<WoDtl>(0);
  //   private Set<IcUmCnvtItem> icUmCnvtItemsForUmIdFrom = new HashSet<IcUmCnvtItem>(0);
 //    private Set<ArRmaDtl> arRmaDtls = new HashSet<ArRmaDtl>(0);

    public IcUm() {
    }

	
    public IcUm(String umId, String umIdDescr, String umFamily, int utUserNbr, Date lastModDt) {
        this.umId = umId;
        this.umIdDescr = umIdDescr;
        this.umFamily = umFamily;
        this.utUserNbr = utUserNbr;
        this.lastModDt = lastModDt;
    }
    public IcUm(String umId, String umIdDescr, String umFamily, int utUserNbr, Date lastModDt, Boolean umPrecision, Set<PoLineHdr> poLineHdrs, Set<IcUmCnvtItem> icUmCnvtItemsForUmIdTo, Set<WoHdr> woHdrs, Set<ArInvDtl> arInvDtls, Set<ArRmaRcpt> arRmaRcpts, Set<IcLotMast> icLotMasts, Set<OeOrdDtl> oeOrdDtls, Set<IcItemMast> icItemMastsForStkUm, Set<IcItemMast> icItemMastsForSellUm, Set<WoDtl> woDtls, Set<IcUmCnvtItem> icUmCnvtItemsForUmIdFrom, Set<ArRmaDtl> arRmaDtls) {
       this.umId = umId;
       this.umIdDescr = umIdDescr;
       this.umFamily = umFamily;
       this.utUserNbr = utUserNbr;
       this.lastModDt = lastModDt;
       this.umPrecision = umPrecision;
       this.poLineHdrs = poLineHdrs;
  //     this.icUmCnvtItemsForUmIdTo = icUmCnvtItemsForUmIdTo;
  //     this.woHdrs = woHdrs;
 //      this.arInvDtls = arInvDtls;
   //    this.arRmaRcpts = arRmaRcpts;
//       this.icLotMasts = icLotMasts;
//       this.oeOrdDtls = oeOrdDtls;
//       this.icItemMastsForStkUm = icItemMastsForStkUm;
//       this.icItemMastsForSellUm = icItemMastsForSellUm;
//       this.woDtls = woDtls;
//       this.icUmCnvtItemsForUmIdFrom = icUmCnvtItemsForUmIdFrom;
 //      this.arRmaDtls = arRmaDtls;
    }
   
     @Id 
    @Column(name="UM_ID", unique=true, nullable=false, length=3)
    public String getUmId() {
        return this.umId;
    }
    
    public void setUmId(String umId) {
        this.umId = umId;
    }

    
    @Column(name="UM_ID_DESCR", nullable=false, length=30)
    public String getUmIdDescr() {
        return this.umIdDescr;
    }
    
    public void setUmIdDescr(String umIdDescr) {
        this.umIdDescr = umIdDescr;
    }

    
    @Column(name="UM_FAMILY", nullable=false, length=8)
    public String getUmFamily() {
        return this.umFamily;
    }
    
    public void setUmFamily(String umFamily) {
        this.umFamily = umFamily;
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

    
    @Column(name="UM_PRECISION", precision=1, scale=0)
    public Boolean getUmPrecision() {
        return this.umPrecision;
    }
    
    public void setUmPrecision(Boolean umPrecision) {
        this.umPrecision = umPrecision;
    }
//
//@OneToMany(fetch=FetchType.LAZY, mappedBy="icUm")
//    public Set<PoLineHdr> getPoLineHdrs() {
//        return this.poLineHdrs;
//    }
//    
//    public void setPoLineHdrs(Set<PoLineHdr> poLineHdrs) {
//        this.poLineHdrs = poLineHdrs;
//    }
//
//@OneToMany(fetch=FetchType.LAZY, mappedBy="icUmByUmIdTo")
//    public Set<IcUmCnvtItem> getIcUmCnvtItemsForUmIdTo() {
//        return this.icUmCnvtItemsForUmIdTo;
//    }
//    
//    public void setIcUmCnvtItemsForUmIdTo(Set<IcUmCnvtItem> icUmCnvtItemsForUmIdTo) {
//        this.icUmCnvtItemsForUmIdTo = icUmCnvtItemsForUmIdTo;
//    }

//@OneToMany(fetch=FetchType.LAZY, mappedBy="icUm")
//    public Set<WoHdr> getWoHdrs() {
//        return this.woHdrs;
//    }
//    
//    public void setWoHdrs(Set<WoHdr> woHdrs) {
//        this.woHdrs = woHdrs;
//    }

//@OneToMany(fetch=FetchType.LAZY, mappedBy="icUm")
//    public Set<ArInvDtl> getArInvDtls() {
//        return this.arInvDtls;
//    }
//    
//    public void setArInvDtls(Set<ArInvDtl> arInvDtls) {
//        this.arInvDtls = arInvDtls;
//    }

//@OneToMany(fetch=FetchType.LAZY, mappedBy="icUm")
//    public Set<ArRmaRcpt> getArRmaRcpts() {
//        return this.arRmaRcpts;
//    }
//    
//    public void setArRmaRcpts(Set<ArRmaRcpt> arRmaRcpts) {
//        this.arRmaRcpts = arRmaRcpts;
//    }

//@OneToMany(fetch=FetchType.LAZY, mappedBy="icUm")
//    public Set<IcLotMast> getIcLotMasts() {
//        return this.icLotMasts;
//    }
//    
//    public void setIcLotMasts(Set<IcLotMast> icLotMasts) {
//        this.icLotMasts = icLotMasts;
//    }

//@OneToMany(fetch=FetchType.LAZY, mappedBy="icUm")
//    public Set<OeOrdDtl> getOeOrdDtls() {
//        return this.oeOrdDtls;
//    }
//    
//    public void setOeOrdDtls(Set<OeOrdDtl> oeOrdDtls) {
//        this.oeOrdDtls = oeOrdDtls;
//    }

//@OneToMany(fetch=FetchType.LAZY, mappedBy="icUmByStkUm")
//    public Set<IcItemMast> getIcItemMastsForStkUm() {
//        return this.icItemMastsForStkUm;
//    }
//    
//    public void setIcItemMastsForStkUm(Set<IcItemMast> icItemMastsForStkUm) {
//        this.icItemMastsForStkUm = icItemMastsForStkUm;
//    }
//
//@OneToMany(fetch=FetchType.LAZY, mappedBy="icUmBySellUm")
//    public Set<IcItemMast> getIcItemMastsForSellUm() {
//        return this.icItemMastsForSellUm;
//    }
//    
//    public void setIcItemMastsForSellUm(Set<IcItemMast> icItemMastsForSellUm) {
//        this.icItemMastsForSellUm = icItemMastsForSellUm;
//    }
//
//@OneToMany(fetch=FetchType.LAZY, mappedBy="icUm")
//    public Set<WoDtl> getWoDtls() {
//        return this.woDtls;
//    }
//    
//    public void setWoDtls(Set<WoDtl> woDtls) {
//        this.woDtls = woDtls;
//    }

//@OneToMany(fetch=FetchType.LAZY, mappedBy="icUmByUmIdFrom")
//    public Set<IcUmCnvtItem> getIcUmCnvtItemsForUmIdFrom() {
//        return this.icUmCnvtItemsForUmIdFrom;
//    }
//    
//    public void setIcUmCnvtItemsForUmIdFrom(Set<IcUmCnvtItem> icUmCnvtItemsForUmIdFrom) {
//        this.icUmCnvtItemsForUmIdFrom = icUmCnvtItemsForUmIdFrom;
//    }

//@OneToMany(fetch=FetchType.LAZY, mappedBy="icUm")
//    public Set<ArRmaDtl> getArRmaDtls() {
//        return this.arRmaDtls;
//    }
//    
//    public void setArRmaDtls(Set<ArRmaDtl> arRmaDtls) {
//        this.arRmaDtls = arRmaDtls;
//    }




}


