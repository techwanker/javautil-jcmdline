package com.pacificdataservices.diamond.models;
// Generated Mar 21, 2019 5:50:00 PM by Hibernate Tools 5.4.1.Final


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * FakeEmailsId generated by hbm2java
 */
@Embeddable
public class FakeEmailsId  implements java.io.Serializable {


     private String buyerEmailAddr;
     private String fakeEmail;

    public FakeEmailsId() {
    }

    public FakeEmailsId(String buyerEmailAddr, String fakeEmail) {
       this.buyerEmailAddr = buyerEmailAddr;
       this.fakeEmail = fakeEmail;
    }
   


    @Column(name="BUYER_EMAIL_ADDR", length=40)
    public String getBuyerEmailAddr() {
        return this.buyerEmailAddr;
    }
    
    public void setBuyerEmailAddr(String buyerEmailAddr) {
        this.buyerEmailAddr = buyerEmailAddr;
    }


    @Column(name="FAKE_EMAIL", length=40)
    public String getFakeEmail() {
        return this.fakeEmail;
    }
    
    public void setFakeEmail(String fakeEmail) {
        this.fakeEmail = fakeEmail;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof FakeEmailsId) ) return false;
		 FakeEmailsId castOther = ( FakeEmailsId ) other; 
         
		 return ( (this.getBuyerEmailAddr()==castOther.getBuyerEmailAddr()) || ( this.getBuyerEmailAddr()!=null && castOther.getBuyerEmailAddr()!=null && this.getBuyerEmailAddr().equals(castOther.getBuyerEmailAddr()) ) )
 && ( (this.getFakeEmail()==castOther.getFakeEmail()) || ( this.getFakeEmail()!=null && castOther.getFakeEmail()!=null && this.getFakeEmail().equals(castOther.getFakeEmail()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getBuyerEmailAddr() == null ? 0 : this.getBuyerEmailAddr().hashCode() );
         result = 37 * result + ( getFakeEmail() == null ? 0 : this.getFakeEmail().hashCode() );
         return result;
   }   


}


