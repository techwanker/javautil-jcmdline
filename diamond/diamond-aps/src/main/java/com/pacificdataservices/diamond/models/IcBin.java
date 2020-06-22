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
 * IcBin generated by hbm2java
 */
@Entity
@Table(name="IC_BIN"
)
public class IcBin  implements java.io.Serializable {


     private int binNbr;
     private UtFacility utFacility;
     private String binCd;
     private String pickFlg;
     private String packStationFlg;
     private String inspectFlg;
     private String binStatCd;
     private Integer walkSeq;
     private int utUserNbr;
     private Date lastModDt;
     private Boolean pickEase;
     private String deleteWhenEmptyFlg;
     private String putAwayFlg;
     private String mrbFlg;
     private Integer whWhseZoneNbr;
     private String workStationFlg;
     private String transitBinFlg;
     private Integer binConsumeSeq;
     private Set<IcItemLoc> icItemLocs = new HashSet<IcItemLoc>(0);
     private Set<ArRmaRcpt> arRmaRcpts = new HashSet<ArRmaRcpt>(0);
     private Set<PoUnplannedRcpt> poUnplannedRcpts = new HashSet<PoUnplannedRcpt>(0);

    public IcBin() {
    }

	
    public IcBin(int binNbr, UtFacility utFacility, String binCd, String pickFlg, String packStationFlg, String inspectFlg, int utUserNbr, Date lastModDt, String deleteWhenEmptyFlg, String putAwayFlg, String mrbFlg, String workStationFlg, String transitBinFlg) {
        this.binNbr = binNbr;
        this.utFacility = utFacility;
        this.binCd = binCd;
        this.pickFlg = pickFlg;
        this.packStationFlg = packStationFlg;
        this.inspectFlg = inspectFlg;
        this.utUserNbr = utUserNbr;
        this.lastModDt = lastModDt;
        this.deleteWhenEmptyFlg = deleteWhenEmptyFlg;
        this.putAwayFlg = putAwayFlg;
        this.mrbFlg = mrbFlg;
        this.workStationFlg = workStationFlg;
        this.transitBinFlg = transitBinFlg;
    }
    public IcBin(int binNbr, UtFacility utFacility, String binCd, String pickFlg, String packStationFlg, String inspectFlg, String binStatCd, Integer walkSeq, int utUserNbr, Date lastModDt, Boolean pickEase, String deleteWhenEmptyFlg, String putAwayFlg, String mrbFlg, Integer whWhseZoneNbr, String workStationFlg, String transitBinFlg, Integer binConsumeSeq, Set<IcItemLoc> icItemLocs, Set<ArRmaRcpt> arRmaRcpts, Set<PoUnplannedRcpt> poUnplannedRcpts) {
       this.binNbr = binNbr;
       this.utFacility = utFacility;
       this.binCd = binCd;
       this.pickFlg = pickFlg;
       this.packStationFlg = packStationFlg;
       this.inspectFlg = inspectFlg;
       this.binStatCd = binStatCd;
       this.walkSeq = walkSeq;
       this.utUserNbr = utUserNbr;
       this.lastModDt = lastModDt;
       this.pickEase = pickEase;
       this.deleteWhenEmptyFlg = deleteWhenEmptyFlg;
       this.putAwayFlg = putAwayFlg;
       this.mrbFlg = mrbFlg;
       this.whWhseZoneNbr = whWhseZoneNbr;
       this.workStationFlg = workStationFlg;
       this.transitBinFlg = transitBinFlg;
       this.binConsumeSeq = binConsumeSeq;
       this.icItemLocs = icItemLocs;
       this.arRmaRcpts = arRmaRcpts;
       this.poUnplannedRcpts = poUnplannedRcpts;
    }
   
     @Id 

    
    @Column(name="BIN_NBR", unique=true, nullable=false, precision=9, scale=0)
    public int getBinNbr() {
        return this.binNbr;
    }
    
    public void setBinNbr(int binNbr) {
        this.binNbr = binNbr;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="FACILITY", nullable=false)
    public UtFacility getUtFacility() {
        return this.utFacility;
    }
    
    public void setUtFacility(UtFacility utFacility) {
        this.utFacility = utFacility;
    }

    
    @Column(name="BIN_CD", nullable=false, length=16)
    public String getBinCd() {
        return this.binCd;
    }
    
    public void setBinCd(String binCd) {
        this.binCd = binCd;
    }

    
    @Column(name="PICK_FLG", nullable=false, length=1)
    public String getPickFlg() {
        return this.pickFlg;
    }
    
    public void setPickFlg(String pickFlg) {
        this.pickFlg = pickFlg;
    }

    
    @Column(name="PACK_STATION_FLG", nullable=false, length=1)
    public String getPackStationFlg() {
        return this.packStationFlg;
    }
    
    public void setPackStationFlg(String packStationFlg) {
        this.packStationFlg = packStationFlg;
    }

    
    @Column(name="INSPECT_FLG", nullable=false, length=1)
    public String getInspectFlg() {
        return this.inspectFlg;
    }
    
    public void setInspectFlg(String inspectFlg) {
        this.inspectFlg = inspectFlg;
    }

    
    @Column(name="BIN_STAT_CD", length=1)
    public String getBinStatCd() {
        return this.binStatCd;
    }
    
    public void setBinStatCd(String binStatCd) {
        this.binStatCd = binStatCd;
    }

    
    @Column(name="WALK_SEQ", precision=5, scale=0)
    public Integer getWalkSeq() {
        return this.walkSeq;
    }
    
    public void setWalkSeq(Integer walkSeq) {
        this.walkSeq = walkSeq;
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

    
    @Column(name="PICK_EASE", precision=1, scale=0)
    public Boolean getPickEase() {
        return this.pickEase;
    }
    
    public void setPickEase(Boolean pickEase) {
        this.pickEase = pickEase;
    }

    
    @Column(name="DELETE_WHEN_EMPTY_FLG", nullable=false, length=1)
    public String getDeleteWhenEmptyFlg() {
        return this.deleteWhenEmptyFlg;
    }
    
    public void setDeleteWhenEmptyFlg(String deleteWhenEmptyFlg) {
        this.deleteWhenEmptyFlg = deleteWhenEmptyFlg;
    }

    
    @Column(name="PUT_AWAY_FLG", nullable=false, length=1)
    public String getPutAwayFlg() {
        return this.putAwayFlg;
    }
    
    public void setPutAwayFlg(String putAwayFlg) {
        this.putAwayFlg = putAwayFlg;
    }

    
    @Column(name="MRB_FLG", nullable=false, length=1)
    public String getMrbFlg() {
        return this.mrbFlg;
    }
    
    public void setMrbFlg(String mrbFlg) {
        this.mrbFlg = mrbFlg;
    }

    
    @Column(name="WH_WHSE_ZONE_NBR", precision=9, scale=0)
    public Integer getWhWhseZoneNbr() {
        return this.whWhseZoneNbr;
    }
    
    public void setWhWhseZoneNbr(Integer whWhseZoneNbr) {
        this.whWhseZoneNbr = whWhseZoneNbr;
    }

    
    @Column(name="WORK_STATION_FLG", nullable=false, length=1)
    public String getWorkStationFlg() {
        return this.workStationFlg;
    }
    
    public void setWorkStationFlg(String workStationFlg) {
        this.workStationFlg = workStationFlg;
    }

    
    @Column(name="TRANSIT_BIN_FLG", nullable=false, length=1)
    public String getTransitBinFlg() {
        return this.transitBinFlg;
    }
    
    public void setTransitBinFlg(String transitBinFlg) {
        this.transitBinFlg = transitBinFlg;
    }

    
    @Column(name="BIN_CONSUME_SEQ", precision=5, scale=0)
    public Integer getBinConsumeSeq() {
        return this.binConsumeSeq;
    }
    
    public void setBinConsumeSeq(Integer binConsumeSeq) {
        this.binConsumeSeq = binConsumeSeq;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="icBin")
    public Set<IcItemLoc> getIcItemLocs() {
        return this.icItemLocs;
    }
    
    public void setIcItemLocs(Set<IcItemLoc> icItemLocs) {
        this.icItemLocs = icItemLocs;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="icBin")
    public Set<ArRmaRcpt> getArRmaRcpts() {
        return this.arRmaRcpts;
    }
    
    public void setArRmaRcpts(Set<ArRmaRcpt> arRmaRcpts) {
        this.arRmaRcpts = arRmaRcpts;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="icBin")
    public Set<PoUnplannedRcpt> getPoUnplannedRcpts() {
        return this.poUnplannedRcpts;
    }
    
    public void setPoUnplannedRcpts(Set<PoUnplannedRcpt> poUnplannedRcpts) {
        this.poUnplannedRcpts = poUnplannedRcpts;
    }




}

