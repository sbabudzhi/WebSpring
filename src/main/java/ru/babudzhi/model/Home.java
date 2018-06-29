package ru.babudzhi.model;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.*;
@Transactional
@Entity
@Table(name = "HOME")
public class Home {
    private String street;
    private String number;
    private String id;
    private String sessionId;
    private Set<Person> person = new HashSet<Person>();

    public Home(){}

    public Home(String street, String number, String sessionId, String id){
        this.street = street;
        this.number = number;
        this.id = id;
        this.sessionId = sessionId;
        person = new HashSet<>();
    }
    public Home(String street, String number, String sessionId){
        this.street = street;
        this.number = number;
        this.id = UUID.randomUUID().toString();
        this.sessionId = sessionId;
    }
    public void setStreet(String street){
        this.street = street;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSessionId(String sessionId){
        this.sessionId = sessionId;
    }

    public void setPerson(Set<Person> person) {
        this.person = person;
    }

    @Basic
    @Column(name = "STREET")
    public String getStreet(){
        return street;
    }
    @Basic
    @Column(name = "NUMBER")
    public String getNumber(){
        return number;
    }
    @Id
    @Column(name = "ID")
    public  String getId(){
        return id;
    }
    @Basic
    @Column(name = "SESSIONID")
    public String getSessionId(){return sessionId;}
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "PERSONHOME", joinColumns = {@JoinColumn(name = "homeId")}, inverseJoinColumns = {@JoinColumn(name = "personId")})
    public Set<Person> getPerson() {
        return person;
    }



}
