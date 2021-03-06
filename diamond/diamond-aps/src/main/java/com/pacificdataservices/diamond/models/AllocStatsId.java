package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * AllocStatsId generated by hbm2java
 */
@Embeddable
public class AllocStatsId  implements java.io.Serializable {


     private Integer nbrOoOld;
     private Integer nbrOoNew;
     private Integer nbrWoOld;
     private Integer nbrWoNew;
     private Integer nbrSsOld;
     private Integer nbrSsNew;
     private Integer nbrFcOld;
     private Integer nbrFcNew;
     private Integer nbrOoAllocFullOld;
     private Integer nbrOoAllocFullNew;
     private Integer nbrWoAllocFullOld;
     private Integer nbrWoAllocFullNew;
     private Integer nbrSsAllocFullOld;
     private Integer nbrSsAllocFullNew;
     private Integer nbrFcAllocFullOld;
     private Integer nbrFcAllocFullNew;
     private Integer nbrOoUnallocOld;
     private Integer nbrOoUnallocNew;
     private Integer nbrWoUnallocOld;
     private Integer nbrWoUnallocNew;
     private Integer nbrSsUnallocOld;
     private Integer nbrSsUnallocNew;
     private Integer nbrFcUnallocOld;
     private Integer nbrFcUnallocNew;
     private Integer nbrOoAllocFullOntimeOld;
     private Integer nbrOoAllocFullOntimeNew;
     private Integer nbrWoAllocFullOntimeOld;
     private Integer nbrWoAllocFullOntimeNew;
     private Integer nbrSsAllocFullOntimeOld;
     private Integer nbrSsAllocFullOntimeNew;
     private Integer nbrFcAllocFullOntimeOld;
     private Integer nbrFcAllocFullOntimeNew;

    public AllocStatsId() {
    }

    public AllocStatsId(Integer nbrOoOld, Integer nbrOoNew, Integer nbrWoOld, Integer nbrWoNew, Integer nbrSsOld, Integer nbrSsNew, Integer nbrFcOld, Integer nbrFcNew, Integer nbrOoAllocFullOld, Integer nbrOoAllocFullNew, Integer nbrWoAllocFullOld, Integer nbrWoAllocFullNew, Integer nbrSsAllocFullOld, Integer nbrSsAllocFullNew, Integer nbrFcAllocFullOld, Integer nbrFcAllocFullNew, Integer nbrOoUnallocOld, Integer nbrOoUnallocNew, Integer nbrWoUnallocOld, Integer nbrWoUnallocNew, Integer nbrSsUnallocOld, Integer nbrSsUnallocNew, Integer nbrFcUnallocOld, Integer nbrFcUnallocNew, Integer nbrOoAllocFullOntimeOld, Integer nbrOoAllocFullOntimeNew, Integer nbrWoAllocFullOntimeOld, Integer nbrWoAllocFullOntimeNew, Integer nbrSsAllocFullOntimeOld, Integer nbrSsAllocFullOntimeNew, Integer nbrFcAllocFullOntimeOld, Integer nbrFcAllocFullOntimeNew) {
       this.nbrOoOld = nbrOoOld;
       this.nbrOoNew = nbrOoNew;
       this.nbrWoOld = nbrWoOld;
       this.nbrWoNew = nbrWoNew;
       this.nbrSsOld = nbrSsOld;
       this.nbrSsNew = nbrSsNew;
       this.nbrFcOld = nbrFcOld;
       this.nbrFcNew = nbrFcNew;
       this.nbrOoAllocFullOld = nbrOoAllocFullOld;
       this.nbrOoAllocFullNew = nbrOoAllocFullNew;
       this.nbrWoAllocFullOld = nbrWoAllocFullOld;
       this.nbrWoAllocFullNew = nbrWoAllocFullNew;
       this.nbrSsAllocFullOld = nbrSsAllocFullOld;
       this.nbrSsAllocFullNew = nbrSsAllocFullNew;
       this.nbrFcAllocFullOld = nbrFcAllocFullOld;
       this.nbrFcAllocFullNew = nbrFcAllocFullNew;
       this.nbrOoUnallocOld = nbrOoUnallocOld;
       this.nbrOoUnallocNew = nbrOoUnallocNew;
       this.nbrWoUnallocOld = nbrWoUnallocOld;
       this.nbrWoUnallocNew = nbrWoUnallocNew;
       this.nbrSsUnallocOld = nbrSsUnallocOld;
       this.nbrSsUnallocNew = nbrSsUnallocNew;
       this.nbrFcUnallocOld = nbrFcUnallocOld;
       this.nbrFcUnallocNew = nbrFcUnallocNew;
       this.nbrOoAllocFullOntimeOld = nbrOoAllocFullOntimeOld;
       this.nbrOoAllocFullOntimeNew = nbrOoAllocFullOntimeNew;
       this.nbrWoAllocFullOntimeOld = nbrWoAllocFullOntimeOld;
       this.nbrWoAllocFullOntimeNew = nbrWoAllocFullOntimeNew;
       this.nbrSsAllocFullOntimeOld = nbrSsAllocFullOntimeOld;
       this.nbrSsAllocFullOntimeNew = nbrSsAllocFullOntimeNew;
       this.nbrFcAllocFullOntimeOld = nbrFcAllocFullOntimeOld;
       this.nbrFcAllocFullOntimeNew = nbrFcAllocFullOntimeNew;
    }
   


    @Column(name="NBR_OO_OLD", precision=9, scale=0)
    public Integer getNbrOoOld() {
        return this.nbrOoOld;
    }
    
    public void setNbrOoOld(Integer nbrOoOld) {
        this.nbrOoOld = nbrOoOld;
    }


    @Column(name="NBR_OO_NEW", precision=9, scale=0)
    public Integer getNbrOoNew() {
        return this.nbrOoNew;
    }
    
    public void setNbrOoNew(Integer nbrOoNew) {
        this.nbrOoNew = nbrOoNew;
    }


    @Column(name="NBR_WO_OLD", precision=9, scale=0)
    public Integer getNbrWoOld() {
        return this.nbrWoOld;
    }
    
    public void setNbrWoOld(Integer nbrWoOld) {
        this.nbrWoOld = nbrWoOld;
    }


    @Column(name="NBR_WO_NEW", precision=9, scale=0)
    public Integer getNbrWoNew() {
        return this.nbrWoNew;
    }
    
    public void setNbrWoNew(Integer nbrWoNew) {
        this.nbrWoNew = nbrWoNew;
    }


    @Column(name="NBR_SS_OLD", precision=9, scale=0)
    public Integer getNbrSsOld() {
        return this.nbrSsOld;
    }
    
    public void setNbrSsOld(Integer nbrSsOld) {
        this.nbrSsOld = nbrSsOld;
    }


    @Column(name="NBR_SS_NEW", precision=9, scale=0)
    public Integer getNbrSsNew() {
        return this.nbrSsNew;
    }
    
    public void setNbrSsNew(Integer nbrSsNew) {
        this.nbrSsNew = nbrSsNew;
    }


    @Column(name="NBR_FC_OLD", precision=9, scale=0)
    public Integer getNbrFcOld() {
        return this.nbrFcOld;
    }
    
    public void setNbrFcOld(Integer nbrFcOld) {
        this.nbrFcOld = nbrFcOld;
    }


    @Column(name="NBR_FC_NEW", precision=9, scale=0)
    public Integer getNbrFcNew() {
        return this.nbrFcNew;
    }
    
    public void setNbrFcNew(Integer nbrFcNew) {
        this.nbrFcNew = nbrFcNew;
    }


    @Column(name="NBR_OO_ALLOC_FULL_OLD", precision=9, scale=0)
    public Integer getNbrOoAllocFullOld() {
        return this.nbrOoAllocFullOld;
    }
    
    public void setNbrOoAllocFullOld(Integer nbrOoAllocFullOld) {
        this.nbrOoAllocFullOld = nbrOoAllocFullOld;
    }


    @Column(name="NBR_OO_ALLOC_FULL_NEW", precision=9, scale=0)
    public Integer getNbrOoAllocFullNew() {
        return this.nbrOoAllocFullNew;
    }
    
    public void setNbrOoAllocFullNew(Integer nbrOoAllocFullNew) {
        this.nbrOoAllocFullNew = nbrOoAllocFullNew;
    }


    @Column(name="NBR_WO_ALLOC_FULL_OLD", precision=9, scale=0)
    public Integer getNbrWoAllocFullOld() {
        return this.nbrWoAllocFullOld;
    }
    
    public void setNbrWoAllocFullOld(Integer nbrWoAllocFullOld) {
        this.nbrWoAllocFullOld = nbrWoAllocFullOld;
    }


    @Column(name="NBR_WO_ALLOC_FULL_NEW", precision=9, scale=0)
    public Integer getNbrWoAllocFullNew() {
        return this.nbrWoAllocFullNew;
    }
    
    public void setNbrWoAllocFullNew(Integer nbrWoAllocFullNew) {
        this.nbrWoAllocFullNew = nbrWoAllocFullNew;
    }


    @Column(name="NBR_SS_ALLOC_FULL_OLD", precision=9, scale=0)
    public Integer getNbrSsAllocFullOld() {
        return this.nbrSsAllocFullOld;
    }
    
    public void setNbrSsAllocFullOld(Integer nbrSsAllocFullOld) {
        this.nbrSsAllocFullOld = nbrSsAllocFullOld;
    }


    @Column(name="NBR_SS_ALLOC_FULL_NEW", precision=9, scale=0)
    public Integer getNbrSsAllocFullNew() {
        return this.nbrSsAllocFullNew;
    }
    
    public void setNbrSsAllocFullNew(Integer nbrSsAllocFullNew) {
        this.nbrSsAllocFullNew = nbrSsAllocFullNew;
    }


    @Column(name="NBR_FC_ALLOC_FULL_OLD", precision=9, scale=0)
    public Integer getNbrFcAllocFullOld() {
        return this.nbrFcAllocFullOld;
    }
    
    public void setNbrFcAllocFullOld(Integer nbrFcAllocFullOld) {
        this.nbrFcAllocFullOld = nbrFcAllocFullOld;
    }


    @Column(name="NBR_FC_ALLOC_FULL_NEW", precision=9, scale=0)
    public Integer getNbrFcAllocFullNew() {
        return this.nbrFcAllocFullNew;
    }
    
    public void setNbrFcAllocFullNew(Integer nbrFcAllocFullNew) {
        this.nbrFcAllocFullNew = nbrFcAllocFullNew;
    }


    @Column(name="NBR_OO_UNALLOC_OLD", precision=9, scale=0)
    public Integer getNbrOoUnallocOld() {
        return this.nbrOoUnallocOld;
    }
    
    public void setNbrOoUnallocOld(Integer nbrOoUnallocOld) {
        this.nbrOoUnallocOld = nbrOoUnallocOld;
    }


    @Column(name="NBR_OO_UNALLOC_NEW", precision=9, scale=0)
    public Integer getNbrOoUnallocNew() {
        return this.nbrOoUnallocNew;
    }
    
    public void setNbrOoUnallocNew(Integer nbrOoUnallocNew) {
        this.nbrOoUnallocNew = nbrOoUnallocNew;
    }


    @Column(name="NBR_WO_UNALLOC_OLD", precision=9, scale=0)
    public Integer getNbrWoUnallocOld() {
        return this.nbrWoUnallocOld;
    }
    
    public void setNbrWoUnallocOld(Integer nbrWoUnallocOld) {
        this.nbrWoUnallocOld = nbrWoUnallocOld;
    }


    @Column(name="NBR_WO_UNALLOC_NEW", precision=9, scale=0)
    public Integer getNbrWoUnallocNew() {
        return this.nbrWoUnallocNew;
    }
    
    public void setNbrWoUnallocNew(Integer nbrWoUnallocNew) {
        this.nbrWoUnallocNew = nbrWoUnallocNew;
    }


    @Column(name="NBR_SS_UNALLOC_OLD", precision=9, scale=0)
    public Integer getNbrSsUnallocOld() {
        return this.nbrSsUnallocOld;
    }
    
    public void setNbrSsUnallocOld(Integer nbrSsUnallocOld) {
        this.nbrSsUnallocOld = nbrSsUnallocOld;
    }


    @Column(name="NBR_SS_UNALLOC_NEW", precision=9, scale=0)
    public Integer getNbrSsUnallocNew() {
        return this.nbrSsUnallocNew;
    }
    
    public void setNbrSsUnallocNew(Integer nbrSsUnallocNew) {
        this.nbrSsUnallocNew = nbrSsUnallocNew;
    }


    @Column(name="NBR_FC_UNALLOC_OLD", precision=9, scale=0)
    public Integer getNbrFcUnallocOld() {
        return this.nbrFcUnallocOld;
    }
    
    public void setNbrFcUnallocOld(Integer nbrFcUnallocOld) {
        this.nbrFcUnallocOld = nbrFcUnallocOld;
    }


    @Column(name="NBR_FC_UNALLOC_NEW", precision=9, scale=0)
    public Integer getNbrFcUnallocNew() {
        return this.nbrFcUnallocNew;
    }
    
    public void setNbrFcUnallocNew(Integer nbrFcUnallocNew) {
        this.nbrFcUnallocNew = nbrFcUnallocNew;
    }


    @Column(name="NBR_OO_ALLOC_FULL_ONTIME_OLD", precision=9, scale=0)
    public Integer getNbrOoAllocFullOntimeOld() {
        return this.nbrOoAllocFullOntimeOld;
    }
    
    public void setNbrOoAllocFullOntimeOld(Integer nbrOoAllocFullOntimeOld) {
        this.nbrOoAllocFullOntimeOld = nbrOoAllocFullOntimeOld;
    }


    @Column(name="NBR_OO_ALLOC_FULL_ONTIME_NEW", precision=9, scale=0)
    public Integer getNbrOoAllocFullOntimeNew() {
        return this.nbrOoAllocFullOntimeNew;
    }
    
    public void setNbrOoAllocFullOntimeNew(Integer nbrOoAllocFullOntimeNew) {
        this.nbrOoAllocFullOntimeNew = nbrOoAllocFullOntimeNew;
    }


    @Column(name="NBR_WO_ALLOC_FULL_ONTIME_OLD", precision=9, scale=0)
    public Integer getNbrWoAllocFullOntimeOld() {
        return this.nbrWoAllocFullOntimeOld;
    }
    
    public void setNbrWoAllocFullOntimeOld(Integer nbrWoAllocFullOntimeOld) {
        this.nbrWoAllocFullOntimeOld = nbrWoAllocFullOntimeOld;
    }


    @Column(name="NBR_WO_ALLOC_FULL_ONTIME_NEW", precision=9, scale=0)
    public Integer getNbrWoAllocFullOntimeNew() {
        return this.nbrWoAllocFullOntimeNew;
    }
    
    public void setNbrWoAllocFullOntimeNew(Integer nbrWoAllocFullOntimeNew) {
        this.nbrWoAllocFullOntimeNew = nbrWoAllocFullOntimeNew;
    }


    @Column(name="NBR_SS_ALLOC_FULL_ONTIME_OLD", precision=9, scale=0)
    public Integer getNbrSsAllocFullOntimeOld() {
        return this.nbrSsAllocFullOntimeOld;
    }
    
    public void setNbrSsAllocFullOntimeOld(Integer nbrSsAllocFullOntimeOld) {
        this.nbrSsAllocFullOntimeOld = nbrSsAllocFullOntimeOld;
    }


    @Column(name="NBR_SS_ALLOC_FULL_ONTIME_NEW", precision=9, scale=0)
    public Integer getNbrSsAllocFullOntimeNew() {
        return this.nbrSsAllocFullOntimeNew;
    }
    
    public void setNbrSsAllocFullOntimeNew(Integer nbrSsAllocFullOntimeNew) {
        this.nbrSsAllocFullOntimeNew = nbrSsAllocFullOntimeNew;
    }


    @Column(name="NBR_FC_ALLOC_FULL_ONTIME_OLD", precision=9, scale=0)
    public Integer getNbrFcAllocFullOntimeOld() {
        return this.nbrFcAllocFullOntimeOld;
    }
    
    public void setNbrFcAllocFullOntimeOld(Integer nbrFcAllocFullOntimeOld) {
        this.nbrFcAllocFullOntimeOld = nbrFcAllocFullOntimeOld;
    }


    @Column(name="NBR_FC_ALLOC_FULL_ONTIME_NEW", precision=9, scale=0)
    public Integer getNbrFcAllocFullOntimeNew() {
        return this.nbrFcAllocFullOntimeNew;
    }
    
    public void setNbrFcAllocFullOntimeNew(Integer nbrFcAllocFullOntimeNew) {
        this.nbrFcAllocFullOntimeNew = nbrFcAllocFullOntimeNew;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof AllocStatsId) ) return false;
		 AllocStatsId castOther = ( AllocStatsId ) other; 
         
		 return ( (this.getNbrOoOld()==castOther.getNbrOoOld()) || ( this.getNbrOoOld()!=null && castOther.getNbrOoOld()!=null && this.getNbrOoOld().equals(castOther.getNbrOoOld()) ) )
 && ( (this.getNbrOoNew()==castOther.getNbrOoNew()) || ( this.getNbrOoNew()!=null && castOther.getNbrOoNew()!=null && this.getNbrOoNew().equals(castOther.getNbrOoNew()) ) )
 && ( (this.getNbrWoOld()==castOther.getNbrWoOld()) || ( this.getNbrWoOld()!=null && castOther.getNbrWoOld()!=null && this.getNbrWoOld().equals(castOther.getNbrWoOld()) ) )
 && ( (this.getNbrWoNew()==castOther.getNbrWoNew()) || ( this.getNbrWoNew()!=null && castOther.getNbrWoNew()!=null && this.getNbrWoNew().equals(castOther.getNbrWoNew()) ) )
 && ( (this.getNbrSsOld()==castOther.getNbrSsOld()) || ( this.getNbrSsOld()!=null && castOther.getNbrSsOld()!=null && this.getNbrSsOld().equals(castOther.getNbrSsOld()) ) )
 && ( (this.getNbrSsNew()==castOther.getNbrSsNew()) || ( this.getNbrSsNew()!=null && castOther.getNbrSsNew()!=null && this.getNbrSsNew().equals(castOther.getNbrSsNew()) ) )
 && ( (this.getNbrFcOld()==castOther.getNbrFcOld()) || ( this.getNbrFcOld()!=null && castOther.getNbrFcOld()!=null && this.getNbrFcOld().equals(castOther.getNbrFcOld()) ) )
 && ( (this.getNbrFcNew()==castOther.getNbrFcNew()) || ( this.getNbrFcNew()!=null && castOther.getNbrFcNew()!=null && this.getNbrFcNew().equals(castOther.getNbrFcNew()) ) )
 && ( (this.getNbrOoAllocFullOld()==castOther.getNbrOoAllocFullOld()) || ( this.getNbrOoAllocFullOld()!=null && castOther.getNbrOoAllocFullOld()!=null && this.getNbrOoAllocFullOld().equals(castOther.getNbrOoAllocFullOld()) ) )
 && ( (this.getNbrOoAllocFullNew()==castOther.getNbrOoAllocFullNew()) || ( this.getNbrOoAllocFullNew()!=null && castOther.getNbrOoAllocFullNew()!=null && this.getNbrOoAllocFullNew().equals(castOther.getNbrOoAllocFullNew()) ) )
 && ( (this.getNbrWoAllocFullOld()==castOther.getNbrWoAllocFullOld()) || ( this.getNbrWoAllocFullOld()!=null && castOther.getNbrWoAllocFullOld()!=null && this.getNbrWoAllocFullOld().equals(castOther.getNbrWoAllocFullOld()) ) )
 && ( (this.getNbrWoAllocFullNew()==castOther.getNbrWoAllocFullNew()) || ( this.getNbrWoAllocFullNew()!=null && castOther.getNbrWoAllocFullNew()!=null && this.getNbrWoAllocFullNew().equals(castOther.getNbrWoAllocFullNew()) ) )
 && ( (this.getNbrSsAllocFullOld()==castOther.getNbrSsAllocFullOld()) || ( this.getNbrSsAllocFullOld()!=null && castOther.getNbrSsAllocFullOld()!=null && this.getNbrSsAllocFullOld().equals(castOther.getNbrSsAllocFullOld()) ) )
 && ( (this.getNbrSsAllocFullNew()==castOther.getNbrSsAllocFullNew()) || ( this.getNbrSsAllocFullNew()!=null && castOther.getNbrSsAllocFullNew()!=null && this.getNbrSsAllocFullNew().equals(castOther.getNbrSsAllocFullNew()) ) )
 && ( (this.getNbrFcAllocFullOld()==castOther.getNbrFcAllocFullOld()) || ( this.getNbrFcAllocFullOld()!=null && castOther.getNbrFcAllocFullOld()!=null && this.getNbrFcAllocFullOld().equals(castOther.getNbrFcAllocFullOld()) ) )
 && ( (this.getNbrFcAllocFullNew()==castOther.getNbrFcAllocFullNew()) || ( this.getNbrFcAllocFullNew()!=null && castOther.getNbrFcAllocFullNew()!=null && this.getNbrFcAllocFullNew().equals(castOther.getNbrFcAllocFullNew()) ) )
 && ( (this.getNbrOoUnallocOld()==castOther.getNbrOoUnallocOld()) || ( this.getNbrOoUnallocOld()!=null && castOther.getNbrOoUnallocOld()!=null && this.getNbrOoUnallocOld().equals(castOther.getNbrOoUnallocOld()) ) )
 && ( (this.getNbrOoUnallocNew()==castOther.getNbrOoUnallocNew()) || ( this.getNbrOoUnallocNew()!=null && castOther.getNbrOoUnallocNew()!=null && this.getNbrOoUnallocNew().equals(castOther.getNbrOoUnallocNew()) ) )
 && ( (this.getNbrWoUnallocOld()==castOther.getNbrWoUnallocOld()) || ( this.getNbrWoUnallocOld()!=null && castOther.getNbrWoUnallocOld()!=null && this.getNbrWoUnallocOld().equals(castOther.getNbrWoUnallocOld()) ) )
 && ( (this.getNbrWoUnallocNew()==castOther.getNbrWoUnallocNew()) || ( this.getNbrWoUnallocNew()!=null && castOther.getNbrWoUnallocNew()!=null && this.getNbrWoUnallocNew().equals(castOther.getNbrWoUnallocNew()) ) )
 && ( (this.getNbrSsUnallocOld()==castOther.getNbrSsUnallocOld()) || ( this.getNbrSsUnallocOld()!=null && castOther.getNbrSsUnallocOld()!=null && this.getNbrSsUnallocOld().equals(castOther.getNbrSsUnallocOld()) ) )
 && ( (this.getNbrSsUnallocNew()==castOther.getNbrSsUnallocNew()) || ( this.getNbrSsUnallocNew()!=null && castOther.getNbrSsUnallocNew()!=null && this.getNbrSsUnallocNew().equals(castOther.getNbrSsUnallocNew()) ) )
 && ( (this.getNbrFcUnallocOld()==castOther.getNbrFcUnallocOld()) || ( this.getNbrFcUnallocOld()!=null && castOther.getNbrFcUnallocOld()!=null && this.getNbrFcUnallocOld().equals(castOther.getNbrFcUnallocOld()) ) )
 && ( (this.getNbrFcUnallocNew()==castOther.getNbrFcUnallocNew()) || ( this.getNbrFcUnallocNew()!=null && castOther.getNbrFcUnallocNew()!=null && this.getNbrFcUnallocNew().equals(castOther.getNbrFcUnallocNew()) ) )
 && ( (this.getNbrOoAllocFullOntimeOld()==castOther.getNbrOoAllocFullOntimeOld()) || ( this.getNbrOoAllocFullOntimeOld()!=null && castOther.getNbrOoAllocFullOntimeOld()!=null && this.getNbrOoAllocFullOntimeOld().equals(castOther.getNbrOoAllocFullOntimeOld()) ) )
 && ( (this.getNbrOoAllocFullOntimeNew()==castOther.getNbrOoAllocFullOntimeNew()) || ( this.getNbrOoAllocFullOntimeNew()!=null && castOther.getNbrOoAllocFullOntimeNew()!=null && this.getNbrOoAllocFullOntimeNew().equals(castOther.getNbrOoAllocFullOntimeNew()) ) )
 && ( (this.getNbrWoAllocFullOntimeOld()==castOther.getNbrWoAllocFullOntimeOld()) || ( this.getNbrWoAllocFullOntimeOld()!=null && castOther.getNbrWoAllocFullOntimeOld()!=null && this.getNbrWoAllocFullOntimeOld().equals(castOther.getNbrWoAllocFullOntimeOld()) ) )
 && ( (this.getNbrWoAllocFullOntimeNew()==castOther.getNbrWoAllocFullOntimeNew()) || ( this.getNbrWoAllocFullOntimeNew()!=null && castOther.getNbrWoAllocFullOntimeNew()!=null && this.getNbrWoAllocFullOntimeNew().equals(castOther.getNbrWoAllocFullOntimeNew()) ) )
 && ( (this.getNbrSsAllocFullOntimeOld()==castOther.getNbrSsAllocFullOntimeOld()) || ( this.getNbrSsAllocFullOntimeOld()!=null && castOther.getNbrSsAllocFullOntimeOld()!=null && this.getNbrSsAllocFullOntimeOld().equals(castOther.getNbrSsAllocFullOntimeOld()) ) )
 && ( (this.getNbrSsAllocFullOntimeNew()==castOther.getNbrSsAllocFullOntimeNew()) || ( this.getNbrSsAllocFullOntimeNew()!=null && castOther.getNbrSsAllocFullOntimeNew()!=null && this.getNbrSsAllocFullOntimeNew().equals(castOther.getNbrSsAllocFullOntimeNew()) ) )
 && ( (this.getNbrFcAllocFullOntimeOld()==castOther.getNbrFcAllocFullOntimeOld()) || ( this.getNbrFcAllocFullOntimeOld()!=null && castOther.getNbrFcAllocFullOntimeOld()!=null && this.getNbrFcAllocFullOntimeOld().equals(castOther.getNbrFcAllocFullOntimeOld()) ) )
 && ( (this.getNbrFcAllocFullOntimeNew()==castOther.getNbrFcAllocFullOntimeNew()) || ( this.getNbrFcAllocFullOntimeNew()!=null && castOther.getNbrFcAllocFullOntimeNew()!=null && this.getNbrFcAllocFullOntimeNew().equals(castOther.getNbrFcAllocFullOntimeNew()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getNbrOoOld() == null ? 0 : this.getNbrOoOld().hashCode() );
         result = 37 * result + ( getNbrOoNew() == null ? 0 : this.getNbrOoNew().hashCode() );
         result = 37 * result + ( getNbrWoOld() == null ? 0 : this.getNbrWoOld().hashCode() );
         result = 37 * result + ( getNbrWoNew() == null ? 0 : this.getNbrWoNew().hashCode() );
         result = 37 * result + ( getNbrSsOld() == null ? 0 : this.getNbrSsOld().hashCode() );
         result = 37 * result + ( getNbrSsNew() == null ? 0 : this.getNbrSsNew().hashCode() );
         result = 37 * result + ( getNbrFcOld() == null ? 0 : this.getNbrFcOld().hashCode() );
         result = 37 * result + ( getNbrFcNew() == null ? 0 : this.getNbrFcNew().hashCode() );
         result = 37 * result + ( getNbrOoAllocFullOld() == null ? 0 : this.getNbrOoAllocFullOld().hashCode() );
         result = 37 * result + ( getNbrOoAllocFullNew() == null ? 0 : this.getNbrOoAllocFullNew().hashCode() );
         result = 37 * result + ( getNbrWoAllocFullOld() == null ? 0 : this.getNbrWoAllocFullOld().hashCode() );
         result = 37 * result + ( getNbrWoAllocFullNew() == null ? 0 : this.getNbrWoAllocFullNew().hashCode() );
         result = 37 * result + ( getNbrSsAllocFullOld() == null ? 0 : this.getNbrSsAllocFullOld().hashCode() );
         result = 37 * result + ( getNbrSsAllocFullNew() == null ? 0 : this.getNbrSsAllocFullNew().hashCode() );
         result = 37 * result + ( getNbrFcAllocFullOld() == null ? 0 : this.getNbrFcAllocFullOld().hashCode() );
         result = 37 * result + ( getNbrFcAllocFullNew() == null ? 0 : this.getNbrFcAllocFullNew().hashCode() );
         result = 37 * result + ( getNbrOoUnallocOld() == null ? 0 : this.getNbrOoUnallocOld().hashCode() );
         result = 37 * result + ( getNbrOoUnallocNew() == null ? 0 : this.getNbrOoUnallocNew().hashCode() );
         result = 37 * result + ( getNbrWoUnallocOld() == null ? 0 : this.getNbrWoUnallocOld().hashCode() );
         result = 37 * result + ( getNbrWoUnallocNew() == null ? 0 : this.getNbrWoUnallocNew().hashCode() );
         result = 37 * result + ( getNbrSsUnallocOld() == null ? 0 : this.getNbrSsUnallocOld().hashCode() );
         result = 37 * result + ( getNbrSsUnallocNew() == null ? 0 : this.getNbrSsUnallocNew().hashCode() );
         result = 37 * result + ( getNbrFcUnallocOld() == null ? 0 : this.getNbrFcUnallocOld().hashCode() );
         result = 37 * result + ( getNbrFcUnallocNew() == null ? 0 : this.getNbrFcUnallocNew().hashCode() );
         result = 37 * result + ( getNbrOoAllocFullOntimeOld() == null ? 0 : this.getNbrOoAllocFullOntimeOld().hashCode() );
         result = 37 * result + ( getNbrOoAllocFullOntimeNew() == null ? 0 : this.getNbrOoAllocFullOntimeNew().hashCode() );
         result = 37 * result + ( getNbrWoAllocFullOntimeOld() == null ? 0 : this.getNbrWoAllocFullOntimeOld().hashCode() );
         result = 37 * result + ( getNbrWoAllocFullOntimeNew() == null ? 0 : this.getNbrWoAllocFullOntimeNew().hashCode() );
         result = 37 * result + ( getNbrSsAllocFullOntimeOld() == null ? 0 : this.getNbrSsAllocFullOntimeOld().hashCode() );
         result = 37 * result + ( getNbrSsAllocFullOntimeNew() == null ? 0 : this.getNbrSsAllocFullOntimeNew().hashCode() );
         result = 37 * result + ( getNbrFcAllocFullOntimeOld() == null ? 0 : this.getNbrFcAllocFullOntimeOld().hashCode() );
         result = 37 * result + ( getNbrFcAllocFullOntimeNew() == null ? 0 : this.getNbrFcAllocFullOntimeNew().hashCode() );
         return result;
   }   


}


