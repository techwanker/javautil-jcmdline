package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ApsCtlId generated by hbm2java
 */
@Embeddable
public class ApsCtlId  implements java.io.Serializable {


     private String pipeNm;
     private String pipeNmSynch;
     private String lockPick;
     private Short pushWindowDy;
     private Integer pushLimitCost;
     private Short pushLimitPct;
     private Short pullWindowDy;
     private Short pullLimitPct;
     private String asynchNotifyPipeNm;

    public ApsCtlId() {
    }

    public ApsCtlId(String pipeNm, String pipeNmSynch, String lockPick, Short pushWindowDy, Integer pushLimitCost, Short pushLimitPct, Short pullWindowDy, Short pullLimitPct, String asynchNotifyPipeNm) {
       this.pipeNm = pipeNm;
       this.pipeNmSynch = pipeNmSynch;
       this.lockPick = lockPick;
       this.pushWindowDy = pushWindowDy;
       this.pushLimitCost = pushLimitCost;
       this.pushLimitPct = pushLimitPct;
       this.pullWindowDy = pullWindowDy;
       this.pullLimitPct = pullLimitPct;
       this.asynchNotifyPipeNm = asynchNotifyPipeNm;
    }
   


    @Column(name="PIPE_NM", length=80)
    public String getPipeNm() {
        return this.pipeNm;
    }
    
    public void setPipeNm(String pipeNm) {
        this.pipeNm = pipeNm;
    }


    @Column(name="PIPE_NM_SYNCH", length=80)
    public String getPipeNmSynch() {
        return this.pipeNmSynch;
    }
    
    public void setPipeNmSynch(String pipeNmSynch) {
        this.pipeNmSynch = pipeNmSynch;
    }


    @Column(name="LOCK_PICK", length=1)
    public String getLockPick() {
        return this.lockPick;
    }
    
    public void setLockPick(String lockPick) {
        this.lockPick = lockPick;
    }


    @Column(name="PUSH_WINDOW_DY", precision=3, scale=0)
    public Short getPushWindowDy() {
        return this.pushWindowDy;
    }
    
    public void setPushWindowDy(Short pushWindowDy) {
        this.pushWindowDy = pushWindowDy;
    }


    @Column(name="PUSH_LIMIT_COST", precision=8, scale=0)
    public Integer getPushLimitCost() {
        return this.pushLimitCost;
    }
    
    public void setPushLimitCost(Integer pushLimitCost) {
        this.pushLimitCost = pushLimitCost;
    }


    @Column(name="PUSH_LIMIT_PCT", precision=3, scale=0)
    public Short getPushLimitPct() {
        return this.pushLimitPct;
    }
    
    public void setPushLimitPct(Short pushLimitPct) {
        this.pushLimitPct = pushLimitPct;
    }


    @Column(name="PULL_WINDOW_DY", precision=3, scale=0)
    public Short getPullWindowDy() {
        return this.pullWindowDy;
    }
    
    public void setPullWindowDy(Short pullWindowDy) {
        this.pullWindowDy = pullWindowDy;
    }


    @Column(name="PULL_LIMIT_PCT", precision=3, scale=0)
    public Short getPullLimitPct() {
        return this.pullLimitPct;
    }
    
    public void setPullLimitPct(Short pullLimitPct) {
        this.pullLimitPct = pullLimitPct;
    }


    @Column(name="ASYNCH_NOTIFY_PIPE_NM", length=80)
    public String getAsynchNotifyPipeNm() {
        return this.asynchNotifyPipeNm;
    }
    
    public void setAsynchNotifyPipeNm(String asynchNotifyPipeNm) {
        this.asynchNotifyPipeNm = asynchNotifyPipeNm;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ApsCtlId) ) return false;
		 ApsCtlId castOther = ( ApsCtlId ) other; 
         
		 return ( (this.getPipeNm()==castOther.getPipeNm()) || ( this.getPipeNm()!=null && castOther.getPipeNm()!=null && this.getPipeNm().equals(castOther.getPipeNm()) ) )
 && ( (this.getPipeNmSynch()==castOther.getPipeNmSynch()) || ( this.getPipeNmSynch()!=null && castOther.getPipeNmSynch()!=null && this.getPipeNmSynch().equals(castOther.getPipeNmSynch()) ) )
 && ( (this.getLockPick()==castOther.getLockPick()) || ( this.getLockPick()!=null && castOther.getLockPick()!=null && this.getLockPick().equals(castOther.getLockPick()) ) )
 && ( (this.getPushWindowDy()==castOther.getPushWindowDy()) || ( this.getPushWindowDy()!=null && castOther.getPushWindowDy()!=null && this.getPushWindowDy().equals(castOther.getPushWindowDy()) ) )
 && ( (this.getPushLimitCost()==castOther.getPushLimitCost()) || ( this.getPushLimitCost()!=null && castOther.getPushLimitCost()!=null && this.getPushLimitCost().equals(castOther.getPushLimitCost()) ) )
 && ( (this.getPushLimitPct()==castOther.getPushLimitPct()) || ( this.getPushLimitPct()!=null && castOther.getPushLimitPct()!=null && this.getPushLimitPct().equals(castOther.getPushLimitPct()) ) )
 && ( (this.getPullWindowDy()==castOther.getPullWindowDy()) || ( this.getPullWindowDy()!=null && castOther.getPullWindowDy()!=null && this.getPullWindowDy().equals(castOther.getPullWindowDy()) ) )
 && ( (this.getPullLimitPct()==castOther.getPullLimitPct()) || ( this.getPullLimitPct()!=null && castOther.getPullLimitPct()!=null && this.getPullLimitPct().equals(castOther.getPullLimitPct()) ) )
 && ( (this.getAsynchNotifyPipeNm()==castOther.getAsynchNotifyPipeNm()) || ( this.getAsynchNotifyPipeNm()!=null && castOther.getAsynchNotifyPipeNm()!=null && this.getAsynchNotifyPipeNm().equals(castOther.getAsynchNotifyPipeNm()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getPipeNm() == null ? 0 : this.getPipeNm().hashCode() );
         result = 37 * result + ( getPipeNmSynch() == null ? 0 : this.getPipeNmSynch().hashCode() );
         result = 37 * result + ( getLockPick() == null ? 0 : this.getLockPick().hashCode() );
         result = 37 * result + ( getPushWindowDy() == null ? 0 : this.getPushWindowDy().hashCode() );
         result = 37 * result + ( getPushLimitCost() == null ? 0 : this.getPushLimitCost().hashCode() );
         result = 37 * result + ( getPushLimitPct() == null ? 0 : this.getPushLimitPct().hashCode() );
         result = 37 * result + ( getPullWindowDy() == null ? 0 : this.getPullWindowDy().hashCode() );
         result = 37 * result + ( getPullLimitPct() == null ? 0 : this.getPullLimitPct().hashCode() );
         result = 37 * result + ( getAsynchNotifyPipeNm() == null ? 0 : this.getAsynchNotifyPipeNm().hashCode() );
         return result;
   }   


}


