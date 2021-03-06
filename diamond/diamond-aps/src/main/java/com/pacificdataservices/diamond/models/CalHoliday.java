package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * CalHoliday generated by hbm2java
 */
@Entity
@Table(name="CAL_HOLIDAY"
)
public class CalHoliday  implements java.io.Serializable {


     private int calHolidayNbr;
     private String calendar;
     private Byte month;
     private Byte dayOfMonth;
     private String recurs;
     private String align;
     private Date startDt;
     private Date endDt;
     private String occurence;
     private String dayOfWeek;

    public CalHoliday() {
    }

	
    public CalHoliday(int calHolidayNbr) {
        this.calHolidayNbr = calHolidayNbr;
    }
    public CalHoliday(int calHolidayNbr, String calendar, Byte month, Byte dayOfMonth, String recurs, String align, Date startDt, Date endDt, String occurence, String dayOfWeek) {
       this.calHolidayNbr = calHolidayNbr;
       this.calendar = calendar;
       this.month = month;
       this.dayOfMonth = dayOfMonth;
       this.recurs = recurs;
       this.align = align;
       this.startDt = startDt;
       this.endDt = endDt;
       this.occurence = occurence;
       this.dayOfWeek = dayOfWeek;
    }
   
     @Id 

    
    @Column(name="CAL_HOLIDAY_NBR", unique=true, nullable=false, precision=9, scale=0)
    public int getCalHolidayNbr() {
        return this.calHolidayNbr;
    }
    
    public void setCalHolidayNbr(int calHolidayNbr) {
        this.calHolidayNbr = calHolidayNbr;
    }

    
    @Column(name="CALENDAR", length=6)
    public String getCalendar() {
        return this.calendar;
    }
    
    public void setCalendar(String calendar) {
        this.calendar = calendar;
    }

    
    @Column(name="MONTH", precision=2, scale=0)
    public Byte getMonth() {
        return this.month;
    }
    
    public void setMonth(Byte month) {
        this.month = month;
    }

    
    @Column(name="DAY_OF_MONTH", precision=2, scale=0)
    public Byte getDayOfMonth() {
        return this.dayOfMonth;
    }
    
    public void setDayOfMonth(Byte dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    
    @Column(name="RECURS", length=2)
    public String getRecurs() {
        return this.recurs;
    }
    
    public void setRecurs(String recurs) {
        this.recurs = recurs;
    }

    
    @Column(name="ALIGN", length=8)
    public String getAlign() {
        return this.align;
    }
    
    public void setAlign(String align) {
        this.align = align;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="START_DT", length=7)
    public Date getStartDt() {
        return this.startDt;
    }
    
    public void setStartDt(Date startDt) {
        this.startDt = startDt;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="END_DT", length=7)
    public Date getEndDt() {
        return this.endDt;
    }
    
    public void setEndDt(Date endDt) {
        this.endDt = endDt;
    }

    
    @Column(name="OCCURENCE", length=8)
    public String getOccurence() {
        return this.occurence;
    }
    
    public void setOccurence(String occurence) {
        this.occurence = occurence;
    }

    
    @Column(name="DAY_OF_WEEK", length=3)
    public String getDayOfWeek() {
        return this.dayOfWeek;
    }
    
    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }




}


