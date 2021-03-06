package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * UtUserVw generated by hbm2java
 */
@Entity
@Table(name="UT_USER_VW"
)
public class UtUserVw  implements java.io.Serializable {


     private UtUserVwId id;

    public UtUserVw() {
    }

    public UtUserVw(UtUserVwId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="orgNbr", column=@Column(name="ORG_NBR", nullable=false, precision=9, scale=0) ), 
        @AttributeOverride(name="utUserNbr", column=@Column(name="UT_USER_NBR", nullable=false, precision=9, scale=0) ), 
        @AttributeOverride(name="userName", column=@Column(name="USER_NAME", nullable=false, length=15) ), 
        @AttributeOverride(name="passwd", column=@Column(name="PASSWD", nullable=false, length=10) ), 
        @AttributeOverride(name="calendar", column=@Column(name="CALENDAR", nullable=false, length=6) ), 
        @AttributeOverride(name="facility", column=@Column(name="FACILITY", length=16) ), 
        @AttributeOverride(name="printer", column=@Column(name="PRINTER", length=50) ), 
        @AttributeOverride(name="printerLabel", column=@Column(name="PRINTER_LABEL", length=50) ), 
        @AttributeOverride(name="pickRuleCd", column=@Column(name="PICK_RULE_CD", length=8) ), 
        @AttributeOverride(name="packStation", column=@Column(name="PACK_STATION", length=16) ), 
        @AttributeOverride(name="rfPasswd", column=@Column(name="RF_PASSWD", length=20) ), 
        @AttributeOverride(name="indivNbr", column=@Column(name="INDIV_NBR", nullable=false, precision=9, scale=0) ), 
        @AttributeOverride(name="lastLoginTm", column=@Column(name="LAST_LOGIN_TM", length=7) ), 
        @AttributeOverride(name="showTooltipFlg", column=@Column(name="SHOW_TOOLTIP_FLG", nullable=false, length=1) ), 
        @AttributeOverride(name="userStatId", column=@Column(name="USER_STAT_ID", nullable=false, length=1) ), 
        @AttributeOverride(name="orgNm", column=@Column(name="ORG_NM", nullable=false, length=60) ) } )
    public UtUserVwId getId() {
        return this.id;
    }
    
    public void setId(UtUserVwId id) {
        this.id = id;
    }




}


