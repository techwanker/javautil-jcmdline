package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * FcstReportDtlId generated by hbm2java
 */
@Embeddable
public class FcstReportDtlId  implements java.io.Serializable {


     private String sessionId;
     private String groupingString;
     private Short sortSeq;
     private String dmdType;
     private BigDecimal qtyMnth1;
     private BigDecimal qtyMnth2;
     private BigDecimal qtyMnth3;
     private BigDecimal qtyMnth4;
     private BigDecimal qtyMnth5;
     private BigDecimal qtyMnth6;
     private BigDecimal qtyMnth7;
     private BigDecimal qtyMnth8;
     private BigDecimal qtyMnth9;
     private BigDecimal qtyMnth10;
     private BigDecimal qtyMnth11;
     private BigDecimal qtyMnth12;

    public FcstReportDtlId() {
    }

	
    public FcstReportDtlId(String sessionId, String groupingString, String dmdType) {
        this.sessionId = sessionId;
        this.groupingString = groupingString;
        this.dmdType = dmdType;
    }
    public FcstReportDtlId(String sessionId, String groupingString, Short sortSeq, String dmdType, BigDecimal qtyMnth1, BigDecimal qtyMnth2, BigDecimal qtyMnth3, BigDecimal qtyMnth4, BigDecimal qtyMnth5, BigDecimal qtyMnth6, BigDecimal qtyMnth7, BigDecimal qtyMnth8, BigDecimal qtyMnth9, BigDecimal qtyMnth10, BigDecimal qtyMnth11, BigDecimal qtyMnth12) {
       this.sessionId = sessionId;
       this.groupingString = groupingString;
       this.sortSeq = sortSeq;
       this.dmdType = dmdType;
       this.qtyMnth1 = qtyMnth1;
       this.qtyMnth2 = qtyMnth2;
       this.qtyMnth3 = qtyMnth3;
       this.qtyMnth4 = qtyMnth4;
       this.qtyMnth5 = qtyMnth5;
       this.qtyMnth6 = qtyMnth6;
       this.qtyMnth7 = qtyMnth7;
       this.qtyMnth8 = qtyMnth8;
       this.qtyMnth9 = qtyMnth9;
       this.qtyMnth10 = qtyMnth10;
       this.qtyMnth11 = qtyMnth11;
       this.qtyMnth12 = qtyMnth12;
    }
   


    @Column(name="SESSION_ID", nullable=false, length=100)
    public String getSessionId() {
        return this.sessionId;
    }
    
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }


    @Column(name="GROUPING_STRING", nullable=false, length=100)
    public String getGroupingString() {
        return this.groupingString;
    }
    
    public void setGroupingString(String groupingString) {
        this.groupingString = groupingString;
    }


    @Column(name="SORT_SEQ", precision=3, scale=0)
    public Short getSortSeq() {
        return this.sortSeq;
    }
    
    public void setSortSeq(Short sortSeq) {
        this.sortSeq = sortSeq;
    }


    @Column(name="DMD_TYPE", nullable=false, length=40)
    public String getDmdType() {
        return this.dmdType;
    }
    
    public void setDmdType(String dmdType) {
        this.dmdType = dmdType;
    }


    @Column(name="QTY_MNTH_1", precision=22, scale=0)
    public BigDecimal getQtyMnth1() {
        return this.qtyMnth1;
    }
    
    public void setQtyMnth1(BigDecimal qtyMnth1) {
        this.qtyMnth1 = qtyMnth1;
    }


    @Column(name="QTY_MNTH_2", precision=22, scale=0)
    public BigDecimal getQtyMnth2() {
        return this.qtyMnth2;
    }
    
    public void setQtyMnth2(BigDecimal qtyMnth2) {
        this.qtyMnth2 = qtyMnth2;
    }


    @Column(name="QTY_MNTH_3", precision=22, scale=0)
    public BigDecimal getQtyMnth3() {
        return this.qtyMnth3;
    }
    
    public void setQtyMnth3(BigDecimal qtyMnth3) {
        this.qtyMnth3 = qtyMnth3;
    }


    @Column(name="QTY_MNTH_4", precision=22, scale=0)
    public BigDecimal getQtyMnth4() {
        return this.qtyMnth4;
    }
    
    public void setQtyMnth4(BigDecimal qtyMnth4) {
        this.qtyMnth4 = qtyMnth4;
    }


    @Column(name="QTY_MNTH_5", precision=22, scale=0)
    public BigDecimal getQtyMnth5() {
        return this.qtyMnth5;
    }
    
    public void setQtyMnth5(BigDecimal qtyMnth5) {
        this.qtyMnth5 = qtyMnth5;
    }


    @Column(name="QTY_MNTH_6", precision=22, scale=0)
    public BigDecimal getQtyMnth6() {
        return this.qtyMnth6;
    }
    
    public void setQtyMnth6(BigDecimal qtyMnth6) {
        this.qtyMnth6 = qtyMnth6;
    }


    @Column(name="QTY_MNTH_7", precision=22, scale=0)
    public BigDecimal getQtyMnth7() {
        return this.qtyMnth7;
    }
    
    public void setQtyMnth7(BigDecimal qtyMnth7) {
        this.qtyMnth7 = qtyMnth7;
    }


    @Column(name="QTY_MNTH_8", precision=22, scale=0)
    public BigDecimal getQtyMnth8() {
        return this.qtyMnth8;
    }
    
    public void setQtyMnth8(BigDecimal qtyMnth8) {
        this.qtyMnth8 = qtyMnth8;
    }


    @Column(name="QTY_MNTH_9", precision=22, scale=0)
    public BigDecimal getQtyMnth9() {
        return this.qtyMnth9;
    }
    
    public void setQtyMnth9(BigDecimal qtyMnth9) {
        this.qtyMnth9 = qtyMnth9;
    }


    @Column(name="QTY_MNTH_10", precision=22, scale=0)
    public BigDecimal getQtyMnth10() {
        return this.qtyMnth10;
    }
    
    public void setQtyMnth10(BigDecimal qtyMnth10) {
        this.qtyMnth10 = qtyMnth10;
    }


    @Column(name="QTY_MNTH_11", precision=22, scale=0)
    public BigDecimal getQtyMnth11() {
        return this.qtyMnth11;
    }
    
    public void setQtyMnth11(BigDecimal qtyMnth11) {
        this.qtyMnth11 = qtyMnth11;
    }


    @Column(name="QTY_MNTH_12", precision=22, scale=0)
    public BigDecimal getQtyMnth12() {
        return this.qtyMnth12;
    }
    
    public void setQtyMnth12(BigDecimal qtyMnth12) {
        this.qtyMnth12 = qtyMnth12;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof FcstReportDtlId) ) return false;
		 FcstReportDtlId castOther = ( FcstReportDtlId ) other; 
         
		 return ( (this.getSessionId()==castOther.getSessionId()) || ( this.getSessionId()!=null && castOther.getSessionId()!=null && this.getSessionId().equals(castOther.getSessionId()) ) )
 && ( (this.getGroupingString()==castOther.getGroupingString()) || ( this.getGroupingString()!=null && castOther.getGroupingString()!=null && this.getGroupingString().equals(castOther.getGroupingString()) ) )
 && ( (this.getSortSeq()==castOther.getSortSeq()) || ( this.getSortSeq()!=null && castOther.getSortSeq()!=null && this.getSortSeq().equals(castOther.getSortSeq()) ) )
 && ( (this.getDmdType()==castOther.getDmdType()) || ( this.getDmdType()!=null && castOther.getDmdType()!=null && this.getDmdType().equals(castOther.getDmdType()) ) )
 && ( (this.getQtyMnth1()==castOther.getQtyMnth1()) || ( this.getQtyMnth1()!=null && castOther.getQtyMnth1()!=null && this.getQtyMnth1().equals(castOther.getQtyMnth1()) ) )
 && ( (this.getQtyMnth2()==castOther.getQtyMnth2()) || ( this.getQtyMnth2()!=null && castOther.getQtyMnth2()!=null && this.getQtyMnth2().equals(castOther.getQtyMnth2()) ) )
 && ( (this.getQtyMnth3()==castOther.getQtyMnth3()) || ( this.getQtyMnth3()!=null && castOther.getQtyMnth3()!=null && this.getQtyMnth3().equals(castOther.getQtyMnth3()) ) )
 && ( (this.getQtyMnth4()==castOther.getQtyMnth4()) || ( this.getQtyMnth4()!=null && castOther.getQtyMnth4()!=null && this.getQtyMnth4().equals(castOther.getQtyMnth4()) ) )
 && ( (this.getQtyMnth5()==castOther.getQtyMnth5()) || ( this.getQtyMnth5()!=null && castOther.getQtyMnth5()!=null && this.getQtyMnth5().equals(castOther.getQtyMnth5()) ) )
 && ( (this.getQtyMnth6()==castOther.getQtyMnth6()) || ( this.getQtyMnth6()!=null && castOther.getQtyMnth6()!=null && this.getQtyMnth6().equals(castOther.getQtyMnth6()) ) )
 && ( (this.getQtyMnth7()==castOther.getQtyMnth7()) || ( this.getQtyMnth7()!=null && castOther.getQtyMnth7()!=null && this.getQtyMnth7().equals(castOther.getQtyMnth7()) ) )
 && ( (this.getQtyMnth8()==castOther.getQtyMnth8()) || ( this.getQtyMnth8()!=null && castOther.getQtyMnth8()!=null && this.getQtyMnth8().equals(castOther.getQtyMnth8()) ) )
 && ( (this.getQtyMnth9()==castOther.getQtyMnth9()) || ( this.getQtyMnth9()!=null && castOther.getQtyMnth9()!=null && this.getQtyMnth9().equals(castOther.getQtyMnth9()) ) )
 && ( (this.getQtyMnth10()==castOther.getQtyMnth10()) || ( this.getQtyMnth10()!=null && castOther.getQtyMnth10()!=null && this.getQtyMnth10().equals(castOther.getQtyMnth10()) ) )
 && ( (this.getQtyMnth11()==castOther.getQtyMnth11()) || ( this.getQtyMnth11()!=null && castOther.getQtyMnth11()!=null && this.getQtyMnth11().equals(castOther.getQtyMnth11()) ) )
 && ( (this.getQtyMnth12()==castOther.getQtyMnth12()) || ( this.getQtyMnth12()!=null && castOther.getQtyMnth12()!=null && this.getQtyMnth12().equals(castOther.getQtyMnth12()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getSessionId() == null ? 0 : this.getSessionId().hashCode() );
         result = 37 * result + ( getGroupingString() == null ? 0 : this.getGroupingString().hashCode() );
         result = 37 * result + ( getSortSeq() == null ? 0 : this.getSortSeq().hashCode() );
         result = 37 * result + ( getDmdType() == null ? 0 : this.getDmdType().hashCode() );
         result = 37 * result + ( getQtyMnth1() == null ? 0 : this.getQtyMnth1().hashCode() );
         result = 37 * result + ( getQtyMnth2() == null ? 0 : this.getQtyMnth2().hashCode() );
         result = 37 * result + ( getQtyMnth3() == null ? 0 : this.getQtyMnth3().hashCode() );
         result = 37 * result + ( getQtyMnth4() == null ? 0 : this.getQtyMnth4().hashCode() );
         result = 37 * result + ( getQtyMnth5() == null ? 0 : this.getQtyMnth5().hashCode() );
         result = 37 * result + ( getQtyMnth6() == null ? 0 : this.getQtyMnth6().hashCode() );
         result = 37 * result + ( getQtyMnth7() == null ? 0 : this.getQtyMnth7().hashCode() );
         result = 37 * result + ( getQtyMnth8() == null ? 0 : this.getQtyMnth8().hashCode() );
         result = 37 * result + ( getQtyMnth9() == null ? 0 : this.getQtyMnth9().hashCode() );
         result = 37 * result + ( getQtyMnth10() == null ? 0 : this.getQtyMnth10().hashCode() );
         result = 37 * result + ( getQtyMnth11() == null ? 0 : this.getQtyMnth11().hashCode() );
         result = 37 * result + ( getQtyMnth12() == null ? 0 : this.getQtyMnth12().hashCode() );
         return result;
   }   


}

