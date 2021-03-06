package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * FcFcstMdlGrpId generated by hbm2java
 */
@Embeddable
public class FcFcstMdlGrpId  implements java.io.Serializable {


     private String fcstMdlGrp;
     private short fcstMdlNbr;

    public FcFcstMdlGrpId() {
    }

    public FcFcstMdlGrpId(String fcstMdlGrp, short fcstMdlNbr) {
       this.fcstMdlGrp = fcstMdlGrp;
       this.fcstMdlNbr = fcstMdlNbr;
    }
   


    @Column(name="FCST_MDL_GRP", nullable=false, length=16)
    public String getFcstMdlGrp() {
        return this.fcstMdlGrp;
    }
    
    public void setFcstMdlGrp(String fcstMdlGrp) {
        this.fcstMdlGrp = fcstMdlGrp;
    }


    @Column(name="FCST_MDL_NBR", nullable=false, precision=3, scale=0)
    public short getFcstMdlNbr() {
        return this.fcstMdlNbr;
    }
    
    public void setFcstMdlNbr(short fcstMdlNbr) {
        this.fcstMdlNbr = fcstMdlNbr;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof FcFcstMdlGrpId) ) return false;
		 FcFcstMdlGrpId castOther = ( FcFcstMdlGrpId ) other; 
         
		 return ( (this.getFcstMdlGrp()==castOther.getFcstMdlGrp()) || ( this.getFcstMdlGrp()!=null && castOther.getFcstMdlGrp()!=null && this.getFcstMdlGrp().equals(castOther.getFcstMdlGrp()) ) )
 && (this.getFcstMdlNbr()==castOther.getFcstMdlNbr());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getFcstMdlGrp() == null ? 0 : this.getFcstMdlGrp().hashCode() );
         result = 37 * result + this.getFcstMdlNbr();
         return result;
   }   


}


