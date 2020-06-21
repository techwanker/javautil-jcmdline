package com.pacificdataservices.diamond.models;
// Generated Mar 21, 2019 5:50:00 PM by Hibernate Tools 5.4.1.Final


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * FakeNames generated by hbm2java
 */
@Entity
@Table(name="FAKE_NAMES"
)
public class FakeNames  implements java.io.Serializable {


     private FakeNamesId id;

    public FakeNames() {
    }

    public FakeNames(FakeNamesId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="indivNmBuyer", column=@Column(name="INDIV_NM_BUYER", length=45) ), 
        @AttributeOverride(name="fakeName", column=@Column(name="FAKE_NAME", length=45) ) } )
    public FakeNamesId getId() {
        return this.id;
    }
    
    public void setId(FakeNamesId id) {
        this.id = id;
    }




}


