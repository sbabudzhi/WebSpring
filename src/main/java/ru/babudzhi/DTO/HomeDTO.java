package ru.babudzhi.DTO;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class HomeDTO {
    private String street;
    private String number;
    private String id;
    private String sessionId;
    private Set<PersonDTO> person = new HashSet<PersonDTO>();

    public HomeDTO() {
    }

    public HomeDTO(String street, String number, String sessionId) {
        this.street = street;
        this.number = number;
        this.id = UUID.randomUUID().toString();
        this.sessionId = sessionId;
    }
    public HomeDTO(String street, String number, String sessionId, String id) {
        this.street = street;
        this.number = number;
        this.id = id;
        this.sessionId = sessionId;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public void setPerson(Set<PersonDTO> person) {
        this.person = person;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;}


    public String getId() {
        return id;
    }

    public String getSessionId() {
        return sessionId;
    }

    public Set<PersonDTO> getPerson() {
        return person;
    }
}