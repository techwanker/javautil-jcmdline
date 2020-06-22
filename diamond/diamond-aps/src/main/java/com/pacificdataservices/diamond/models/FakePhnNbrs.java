package com.pacificdataservices.diamond.models;
// Generated Mar 21, 2019 5:50:00 PM by Hibernate Tools 5.4.1.Final


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * FakePhnNbrs generated by hbm2java
 */
@Entity
@Table(name="FAKE_PHN_NBRS"
)
public class FakePhnNbrs  implements java.io.Serializable {


     private FakePhnNbrsId id;

    public FakePhnNbrs() {
    }

    public FakePhnNbrs(FakePhnNbrsId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="phnNbr", column=@Column(name="PHN_NBR", length=20) ), 
        @AttributeOverride(name="type", column=@Column(name="TYPE", length=5) ), 
        @AttributeOverride(name="fakePhnNbr", column=@Column(name="FAKE_PHN_NBR", length=20) ) } )
    public FakePhnNbrsId getId() {
        return this.id;
    }
    
    public void setId(FakePhnNbrsId id) {
        this.id = id;
    }




}

