package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * ApsCtl generated by hbm2java
 */
@Entity
@Table(name="APS_CTL"
)
public class ApsCtl  implements java.io.Serializable {


     private ApsCtlId id;

    public ApsCtl() {
    }

    public ApsCtl(ApsCtlId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="pipeNm", column=@Column(name="PIPE_NM", length=80) ), 
        @AttributeOverride(name="pipeNmSynch", column=@Column(name="PIPE_NM_SYNCH", length=80) ), 
        @AttributeOverride(name="lockPick", column=@Column(name="LOCK_PICK", length=1) ), 
        @AttributeOverride(name="pushWindowDy", column=@Column(name="PUSH_WINDOW_DY", precision=3, scale=0) ), 
        @AttributeOverride(name="pushLimitCost", column=@Column(name="PUSH_LIMIT_COST", precision=8, scale=0) ), 
        @AttributeOverride(name="pushLimitPct", column=@Column(name="PUSH_LIMIT_PCT", precision=3, scale=0) ), 
        @AttributeOverride(name="pullWindowDy", column=@Column(name="PULL_WINDOW_DY", precision=3, scale=0) ), 
        @AttributeOverride(name="pullLimitPct", column=@Column(name="PULL_LIMIT_PCT", precision=3, scale=0) ), 
        @AttributeOverride(name="asynchNotifyPipeNm", column=@Column(name="ASYNCH_NOTIFY_PIPE_NM", length=80) ) } )
    public ApsCtlId getId() {
        return this.id;
    }
    
    public void setId(ApsCtlId id) {
        this.id = id;
    }




}


