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
 * UtFacility generated by hbm2java
 */
@Entity
@Table(name="UT_FACILITY"
)
public class UtFacility  implements java.io.Serializable {


     private String facility;
     private CalCalendar calCalendar;
     private NaOrgAddr naOrgAddr;
     private int utUserNbr;
     private Date lastModDt;
     private String facilityStatId;
     private Set<PoUnplannedRcpt> poUnplannedRcpts = new HashSet<PoUnplannedRcpt>(0);
     private Set<ApsSrcRuleSet> apsSrcRuleSets = new HashSet<ApsSrcRuleSet>(0);
     private Set<IcBin> icBins = new HashSet<IcBin>(0);
     private Set<ApsSummaryDat> apsSummaryDats = new HashSet<ApsSummaryDat>(0);
     private Set<ApsSplyFacilityItem> apsSplyFacilityItems = new HashSet<ApsSplyFacilityItem>(0);
     private Set<ApsSummaryDatAmt> apsSummaryDatAmts = new HashSet<ApsSummaryDatAmt>(0);
     private Set<UtUser> utUsers = new HashSet<UtUser>(0);
     private Set<WhFacilityTransOnhand> whFacilityTransOnhands = new HashSet<WhFacilityTransOnhand>(0);
     private Set<ApsSrcRule> apsSrcRules = new HashSet<ApsSrcRule>(0);
     private Set<IcKitMast> icKitMasts = new HashSet<IcKitMast>(0);
     private Set<ArInvDtl> arInvDtls = new HashSet<ArInvDtl>(0);

    public UtFacility() {
    }

	
    public UtFacility(String facility, CalCalendar calCalendar, int utUserNbr, Date lastModDt, String facilityStatId) {
        this.facility = facility;
        this.calCalendar = calCalendar;
        this.utUserNbr = utUserNbr;
        this.lastModDt = lastModDt;
        this.facilityStatId = facilityStatId;
    }
    public UtFacility(String facility, CalCalendar calCalendar, NaOrgAddr naOrgAddr, int utUserNbr, Date lastModDt, String facilityStatId, Set<PoUnplannedRcpt> poUnplannedRcpts, Set<ApsSrcRuleSet> apsSrcRuleSets, Set<IcBin> icBins, Set<ApsSummaryDat> apsSummaryDats, Set<ApsSplyFacilityItem> apsSplyFacilityItems, Set<ApsSummaryDatAmt> apsSummaryDatAmts, Set<UtUser> utUsers, Set<WhFacilityTransOnhand> whFacilityTransOnhands, Set<ApsSrcRule> apsSrcRules, Set<IcKitMast> icKitMasts, Set<ArInvDtl> arInvDtls) {
       this.facility = facility;
       this.calCalendar = calCalendar;
       this.naOrgAddr = naOrgAddr;
       this.utUserNbr = utUserNbr;
       this.lastModDt = lastModDt;
       this.facilityStatId = facilityStatId;
       this.poUnplannedRcpts = poUnplannedRcpts;
       this.apsSrcRuleSets = apsSrcRuleSets;
       this.icBins = icBins;
       this.apsSummaryDats = apsSummaryDats;
       this.apsSplyFacilityItems = apsSplyFacilityItems;
       this.apsSummaryDatAmts = apsSummaryDatAmts;
       this.utUsers = utUsers;
       this.whFacilityTransOnhands = whFacilityTransOnhands;
       this.apsSrcRules = apsSrcRules;
       this.icKitMasts = icKitMasts;
       this.arInvDtls = arInvDtls;
    }
   
     @Id 

    
    @Column(name="FACILITY", unique=true, nullable=false, length=16)
    public String getFacility() {
        return this.facility;
    }
    
    public void setFacility(String facility) {
        this.facility = facility;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="CALENDAR", nullable=false)
    public CalCalendar getCalCalendar() {
        return this.calCalendar;
    }
    
    public void setCalCalendar(CalCalendar calCalendar) {
        this.calCalendar = calCalendar;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PRIMARY_ADDR_NBR")
    public NaOrgAddr getNaOrgAddr() {
        return this.naOrgAddr;
    }
    
    public void setNaOrgAddr(NaOrgAddr naOrgAddr) {
        this.naOrgAddr = naOrgAddr;
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

    
    @Column(name="FACILITY_STAT_ID", nullable=false, length=1)
    public String getFacilityStatId() {
        return this.facilityStatId;
    }
    
    public void setFacilityStatId(String facilityStatId) {
        this.facilityStatId = facilityStatId;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="utFacility")
    public Set<PoUnplannedRcpt> getPoUnplannedRcpts() {
        return this.poUnplannedRcpts;
    }
    
    public void setPoUnplannedRcpts(Set<PoUnplannedRcpt> poUnplannedRcpts) {
        this.poUnplannedRcpts = poUnplannedRcpts;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="utFacility")
    public Set<ApsSrcRuleSet> getApsSrcRuleSets() {
        return this.apsSrcRuleSets;
    }
    
    public void setApsSrcRuleSets(Set<ApsSrcRuleSet> apsSrcRuleSets) {
        this.apsSrcRuleSets = apsSrcRuleSets;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="utFacility")
    public Set<IcBin> getIcBins() {
        return this.icBins;
    }
    
    public void setIcBins(Set<IcBin> icBins) {
        this.icBins = icBins;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="utFacility")
    public Set<ApsSummaryDat> getApsSummaryDats() {
        return this.apsSummaryDats;
    }
    
    public void setApsSummaryDats(Set<ApsSummaryDat> apsSummaryDats) {
        this.apsSummaryDats = apsSummaryDats;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="utFacility")
    public Set<ApsSplyFacilityItem> getApsSplyFacilityItems() {
        return this.apsSplyFacilityItems;
    }
    
    public void setApsSplyFacilityItems(Set<ApsSplyFacilityItem> apsSplyFacilityItems) {
        this.apsSplyFacilityItems = apsSplyFacilityItems;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="utFacility")
    public Set<ApsSummaryDatAmt> getApsSummaryDatAmts() {
        return this.apsSummaryDatAmts;
    }
    
    public void setApsSummaryDatAmts(Set<ApsSummaryDatAmt> apsSummaryDatAmts) {
        this.apsSummaryDatAmts = apsSummaryDatAmts;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="utFacility")
    public Set<UtUser> getUtUsers() {
        return this.utUsers;
    }
    
    public void setUtUsers(Set<UtUser> utUsers) {
        this.utUsers = utUsers;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="utFacility")
    public Set<WhFacilityTransOnhand> getWhFacilityTransOnhands() {
        return this.whFacilityTransOnhands;
    }
    
    public void setWhFacilityTransOnhands(Set<WhFacilityTransOnhand> whFacilityTransOnhands) {
        this.whFacilityTransOnhands = whFacilityTransOnhands;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="utFacility")
    public Set<ApsSrcRule> getApsSrcRules() {
        return this.apsSrcRules;
    }
    
    public void setApsSrcRules(Set<ApsSrcRule> apsSrcRules) {
        this.apsSrcRules = apsSrcRules;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="utFacility")
    public Set<IcKitMast> getIcKitMasts() {
        return this.icKitMasts;
    }
    
    public void setIcKitMasts(Set<IcKitMast> icKitMasts) {
        this.icKitMasts = icKitMasts;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="utFacility")
    public Set<ArInvDtl> getArInvDtls() {
        return this.arInvDtls;
    }
    
    public void setArInvDtls(Set<ArInvDtl> arInvDtls) {
        this.arInvDtls = arInvDtls;
    }




}


