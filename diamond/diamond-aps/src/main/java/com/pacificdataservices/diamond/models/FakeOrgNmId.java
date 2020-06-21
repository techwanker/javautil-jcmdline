package com.pacificdataservices.diamond.models;
// Generated Mar 21, 2019 5:50:00 PM by Hibernate Tools 5.4.1.Final


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * FakeOrgNmId generated by hbm2java
 */
@Embeddable
public class FakeOrgNmId  implements java.io.Serializable {


     private String orgNm;
     private String fakeOrgNm;

    public FakeOrgNmId() {
    }

    public FakeOrgNmId(String orgNm, String fakeOrgNm) {
       this.orgNm = orgNm;
       this.fakeOrgNm = fakeOrgNm;
    }
   


    @Column(name="ORG_NM", length=60)
    public String getOrgNm() {
        return this.orgNm;
    }
    
    public void setOrgNm(String orgNm) {
        this.orgNm = orgNm;
    }


    @Column(name="FAKE_ORG_NM", length=60)
    public String getFakeOrgNm() {
        return this.fakeOrgNm;
    }
    
    public void setFakeOrgNm(String fakeOrgNm) {
        this.fakeOrgNm = fakeOrgNm;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof FakeOrgNmId) ) return false;
		 FakeOrgNmId castOther = ( FakeOrgNmId ) other; 
         
		 return ( (this.getOrgNm()==castOther.getOrgNm()) || ( this.getOrgNm()!=null && castOther.getOrgNm()!=null && this.getOrgNm().equals(castOther.getOrgNm()) ) )
 && ( (this.getFakeOrgNm()==castOther.getFakeOrgNm()) || ( this.getFakeOrgNm()!=null && castOther.getFakeOrgNm()!=null && this.getFakeOrgNm().equals(castOther.getFakeOrgNm()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getOrgNm() == null ? 0 : this.getOrgNm().hashCode() );
         result = 37 * result + ( getFakeOrgNm() == null ? 0 : this.getFakeOrgNm().hashCode() );
         return result;
   }   


}


