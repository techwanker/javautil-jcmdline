package com.pacificdataservices.diamond.models;
// Generated Feb 10, 2019 3:34:51 PM by Hibernate Tools 5.4.1.Final


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * UserFieldCtl generated by hbm2java
 */
@Entity
@Table(name="USER_FIELD_CTL"
)
public class UserFieldCtl  implements java.io.Serializable {


     private UserFieldCtlId id;

    public UserFieldCtl() {
    }

    public UserFieldCtl(UserFieldCtlId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="tableName", column=@Column(name="TABLE_NAME", length=32) ), 
        @AttributeOverride(name="columnName", column=@Column(name="COLUMN_NAME", length=32) ), 
        @AttributeOverride(name="header", column=@Column(name="HEADER", length=16) ), 
        @AttributeOverride(name="label", column=@Column(name="LABEL", length=32) ), 
        @AttributeOverride(name="columnValuesQuery", column=@Column(name="COLUMN_VALUES_QUERY", length=2048) ), 
        @AttributeOverride(name="refTableName", column=@Column(name="REF_TABLE_NAME", length=32) ), 
        @AttributeOverride(name="refTableColumn", column=@Column(name="REF_TABLE_COLUMN", length=32) ), 
        @AttributeOverride(name="refTableColumnVal", column=@Column(name="REF_TABLE_COLUMN_VAL", length=16) ), 
        @AttributeOverride(name="refTableUserVal", column=@Column(name="REF_TABLE_USER_VAL", length=16) ) } )
    public UserFieldCtlId getId() {
        return this.id;
    }
    
    public void setId(UserFieldCtlId id) {
        this.id = id;
    }




}

