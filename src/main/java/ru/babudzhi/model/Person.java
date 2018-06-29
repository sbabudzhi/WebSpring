package ru.babudzhi.model;

import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
@Transactional
@Entity
@Table(name = "TEST123", schema = "PUBLIC", catalog = "TEST")
public class Person {

    private String lastName;
    private String firstName;
    private String middleName;
    private String sessionId;
    private String id;
    private Set<Home> home = null;

    public Person(String lastName, String firstName, String middleName, String sessionId, String id){
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.sessionId = sessionId;
        this.id=id;
    }
    public Person(String lastName, String firstName, String middleName, String sessionId, String id,Set<Home> homeSet){
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.sessionId = sessionId;
        this.id=id;
        this.home = homeSet;
    }
    public Person(){}

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setHome(Set<Home> home) {
        this.home = home;
    }
    @Basic
    @Column(name = "LASTNAME")
    public String getLastName() {return lastName;}
    @Basic
    @Column(name = "FIRSTNAME")
    public String getFirstName() { return firstName; }
    @Basic
    @Column(name = "MIDDLENAME")
    public String getMiddleName() { return middleName; }
    @Basic
    @Column(name = "SESSIONID")
    public String getSessionId() { return sessionId; }

    @Id
    @Column(name = "ID")
    public String getId() { return id; }

    @ManyToMany()
    @JoinTable(name = "PERSONHOME", joinColumns = {@JoinColumn(name = "personId")}, inverseJoinColumns = {@JoinColumn(name = "homeId")})
    public Set<Home> getHome() {
        return home;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person that = (Person) o;

        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (middleName != null ? !middleName.equals(that.middleName) : that.middleName != null) return false;
        if (sessionId != null ? !sessionId.equals(that.sessionId) : that.sessionId != null) return false;

        return true;
    }


}

