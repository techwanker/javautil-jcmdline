package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * IcAttr generated by hbm2java
 */
@Entity
@Table(name="IC_ATTR"
)
public class IcAttr  implements java.io.Serializable {


     private int icAttrNbr;
     private String attrNm;
     private String attrDescr;
     private Short attrSeq;
     private String reqrFlg;
     private String attrConstrFlg;
     private int utUserNbr;
     private Date lastModDt;
     private Set<IcItemAttr> icItemAttrs = new HashSet<IcItemAttr>(0);
     private Set<IcAttrVal> icAttrVals = new HashSet<IcAttrVal>(0);
     private Set<FcAggrMastAttr> fcAggrMastAttrs = new HashSet<FcAggrMastAttr>(0);

    public IcAttr() {
    }

	
    public IcAttr(int icAttrNbr, String attrNm, String attrDescr, String reqrFlg, String attrConstrFlg, int utUserNbr, Date lastModDt) {
        this.icAttrNbr = icAttrNbr;
        this.attrNm = attrNm;
        this.attrDescr = attrDescr;
        this.reqrFlg = reqrFlg;
        this.attrConstrFlg = attrConstrFlg;
        this.utUserNbr = utUserNbr;
        this.lastModDt = lastModDt;
    }
    public IcAttr(int icAttrNbr, String attrNm, String attrDescr, Short attrSeq, String reqrFlg, String attrConstrFlg, int utUserNbr, Date lastModDt, Set<IcItemAttr> icItemAttrs, Set<IcAttrVal> icAttrVals, Set<FcAggrMastAttr> fcAggrMastAttrs) {
       this.icAttrNbr = icAttrNbr;
       this.attrNm = attrNm;
       this.attrDescr = attrDescr;
       this.attrSeq = attrSeq;
       this.reqrFlg = reqrFlg;
       this.attrConstrFlg = attrConstrFlg;
       this.utUserNbr = utUserNbr;
       this.lastModDt = lastModDt;
       this.icItemAttrs = icItemAttrs;
       this.icAttrVals = icAttrVals;
       this.fcAggrMastAttrs = fcAggrMastAttrs;
    }
   
     @Id 

    
    @Column(name="IC_ATTR_NBR", unique=true, nullable=false, precision=9, scale=0)
    public int getIcAttrNbr() {
        return this.icAttrNbr;
    }
    
    public void setIcAttrNbr(int icAttrNbr) {
        this.icAttrNbr = icAttrNbr;
    }

    
    @Column(name="ATTR_NM", unique=true, nullable=false, length=16)
    public String getAttrNm() {
        return this.attrNm;
    }
    
    public void setAttrNm(String attrNm) {
        this.attrNm = attrNm;
    }

    
    @Column(name="ATTR_DESCR", nullable=false, length=60)
    public String getAttrDescr() {
        return this.attrDescr;
    }
    
    public void setAttrDescr(String attrDescr) {
        this.attrDescr = attrDescr;
    }

    
    @Column(name="ATTR_SEQ", precision=3, scale=0)
    public Short getAttrSeq() {
        return this.attrSeq;
    }
    
    public void setAttrSeq(Short attrSeq) {
        this.attrSeq = attrSeq;
    }

    
    @Column(name="REQR_FLG", nullable=false, length=1)
    public String getReqrFlg() {
        return this.reqrFlg;
    }
    
    public void setReqrFlg(String reqrFlg) {
        this.reqrFlg = reqrFlg;
    }

    
    @Column(name="ATTR_CONSTR_FLG", nullable=false, length=1)
    public String getAttrConstrFlg() {
        return this.attrConstrFlg;
    }
    
    public void setAttrConstrFlg(String attrConstrFlg) {
        this.attrConstrFlg = attrConstrFlg;
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

@OneToMany(fetch=FetchType.LAZY, mappedBy="icAttr")
    public Set<IcItemAttr> getIcItemAttrs() {
        return this.icItemAttrs;
    }
    
    public void setIcItemAttrs(Set<IcItemAttr> icItemAttrs) {
        this.icItemAttrs = icItemAttrs;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="icAttr")
    public Set<IcAttrVal> getIcAttrVals() {
        return this.icAttrVals;
    }
    
    public void setIcAttrVals(Set<IcAttrVal> icAttrVals) {
        this.icAttrVals = icAttrVals;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="icAttr")
    public Set<FcAggrMastAttr> getFcAggrMastAttrs() {
        return this.fcAggrMastAttrs;
    }
    
    public void setFcAggrMastAttrs(Set<FcAggrMastAttr> fcAggrMastAttrs) {
        this.fcAggrMastAttrs = fcAggrMastAttrs;
    }




}


