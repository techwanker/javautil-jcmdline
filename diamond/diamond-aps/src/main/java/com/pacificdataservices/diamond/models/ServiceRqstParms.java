package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ServiceRqstParms generated by hbm2java
 */
@Entity
@Table(name="SERVICE_RQST_PARMS"
)
public class ServiceRqstParms  implements java.io.Serializable {


     private ServiceRqstParmsId id;
     private ServiceRqst serviceRqst;
     private String parmDataType;
     private String parmNmDescr;

    public ServiceRqstParms() {
    }

    public ServiceRqstParms(ServiceRqstParmsId id, ServiceRqst serviceRqst, String parmDataType, String parmNmDescr) {
       this.id = id;
       this.serviceRqst = serviceRqst;
       this.parmDataType = parmDataType;
       this.parmNmDescr = parmNmDescr;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="serviceRqstCd", column=@Column(name="SERVICE_RQST_CD", nullable=false, length=20) ), 
        @AttributeOverride(name="parmNm", column=@Column(name="PARM_NM", nullable=false, length=30) ) } )
    public ServiceRqstParmsId getId() {
        return this.id;
    }
    
    public void setId(ServiceRqstParmsId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="SERVICE_RQST_CD", nullable=false, insertable=false, updatable=false)
    public ServiceRqst getServiceRqst() {
        return this.serviceRqst;
    }
    
    public void setServiceRqst(ServiceRqst serviceRqst) {
        this.serviceRqst = serviceRqst;
    }

    
    @Column(name="PARM_DATA_TYPE", nullable=false, length=10)
    public String getParmDataType() {
        return this.parmDataType;
    }
    
    public void setParmDataType(String parmDataType) {
        this.parmDataType = parmDataType;
    }

    
    @Column(name="PARM_NM_DESCR", nullable=false, length=60)
    public String getParmNmDescr() {
        return this.parmNmDescr;
    }
    
    public void setParmNmDescr(String parmNmDescr) {
        this.parmNmDescr = parmNmDescr;
    }




}


