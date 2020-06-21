package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * OeCustContract generated by hbm2java
 */
@Entity
@Table(name="OE_CUST_CONTRACT"
)
public class OeCustContract  implements java.io.Serializable {


     private OeCustContractId id;
     private OeCustMast oeCustMast;
     private FcstGrp fcstGrp;
     private int utUserNbr;
     private Date lastModDt;
     private String contractCdDescr;
     private String binGrpReqrFlg;
     private String acceptMultiScanForBinFlg;
     private short ordTurnAroundDy;
     private Set<OeOrdDtl> oeOrdDtls = new HashSet<OeOrdDtl>(0);
     private Set<OeContractItem> oeContractItems = new HashSet<OeContractItem>(0);

    public OeCustContract() {
    }

	
    public OeCustContract(OeCustContractId id, OeCustMast oeCustMast, FcstGrp fcstGrp, int utUserNbr, Date lastModDt, String binGrpReqrFlg, String acceptMultiScanForBinFlg, short ordTurnAroundDy) {
        this.id = id;
        this.oeCustMast = oeCustMast;
        this.fcstGrp = fcstGrp;
        this.utUserNbr = utUserNbr;
        this.lastModDt = lastModDt;
        this.binGrpReqrFlg = binGrpReqrFlg;
        this.acceptMultiScanForBinFlg = acceptMultiScanForBinFlg;
        this.ordTurnAroundDy = ordTurnAroundDy;
    }
    public OeCustContract(OeCustContractId id, OeCustMast oeCustMast, FcstGrp fcstGrp, int utUserNbr, Date lastModDt, String contractCdDescr, String binGrpReqrFlg, String acceptMultiScanForBinFlg, short ordTurnAroundDy, Set<OeOrdDtl> oeOrdDtls, Set<OeContractItem> oeContractItems) {
       this.id = id;
       this.oeCustMast = oeCustMast;
       this.fcstGrp = fcstGrp;
       this.utUserNbr = utUserNbr;
       this.lastModDt = lastModDt;
       this.contractCdDescr = contractCdDescr;
       this.binGrpReqrFlg = binGrpReqrFlg;
       this.acceptMultiScanForBinFlg = acceptMultiScanForBinFlg;
       this.ordTurnAroundDy = ordTurnAroundDy;
       this.oeOrdDtls = oeOrdDtls;
       this.oeContractItems = oeContractItems;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="orgNbrCust", column=@Column(name="ORG_NBR_CUST", nullable=false, precision=9, scale=0) ), 
        @AttributeOverride(name="contractCd", column=@Column(name="CONTRACT_CD", nullable=false, length=8) ) } )
    public OeCustContractId getId() {
        return this.id;
    }
    
    public void setId(OeCustContractId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ORG_NBR_CUST", nullable=false, insertable=false, updatable=false)
    public OeCustMast getOeCustMast() {
        return this.oeCustMast;
    }
    
    public void setOeCustMast(OeCustMast oeCustMast) {
        this.oeCustMast = oeCustMast;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="FCST_GRP", nullable=false)
    public FcstGrp getFcstGrp() {
        return this.fcstGrp;
    }
    
    public void setFcstGrp(FcstGrp fcstGrp) {
        this.fcstGrp = fcstGrp;
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

    
    @Column(name="CONTRACT_CD_DESCR", length=60)
    public String getContractCdDescr() {
        return this.contractCdDescr;
    }
    
    public void setContractCdDescr(String contractCdDescr) {
        this.contractCdDescr = contractCdDescr;
    }

    
    @Column(name="BIN_GRP_REQR_FLG", nullable=false, length=1)
    public String getBinGrpReqrFlg() {
        return this.binGrpReqrFlg;
    }
    
    public void setBinGrpReqrFlg(String binGrpReqrFlg) {
        this.binGrpReqrFlg = binGrpReqrFlg;
    }

    
    @Column(name="ACCEPT_MULTI_SCAN_FOR_BIN_FLG", nullable=false, length=1)
    public String getAcceptMultiScanForBinFlg() {
        return this.acceptMultiScanForBinFlg;
    }
    
    public void setAcceptMultiScanForBinFlg(String acceptMultiScanForBinFlg) {
        this.acceptMultiScanForBinFlg = acceptMultiScanForBinFlg;
    }

    
    @Column(name="ORD_TURN_AROUND_DY", nullable=false, precision=3, scale=0)
    public short getOrdTurnAroundDy() {
        return this.ordTurnAroundDy;
    }
    
    public void setOrdTurnAroundDy(short ordTurnAroundDy) {
        this.ordTurnAroundDy = ordTurnAroundDy;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="oeCustContract")
    public Set<OeOrdDtl> getOeOrdDtls() {
        return this.oeOrdDtls;
    }
    
    public void setOeOrdDtls(Set<OeOrdDtl> oeOrdDtls) {
        this.oeOrdDtls = oeOrdDtls;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="oeCustContract")
    public Set<OeContractItem> getOeContractItems() {
        return this.oeContractItems;
    }
    
    public void setOeContractItems(Set<OeContractItem> oeContractItems) {
        this.oeContractItems = oeContractItems;
    }




}


