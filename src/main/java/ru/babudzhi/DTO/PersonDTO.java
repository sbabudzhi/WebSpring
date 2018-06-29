package ru.babudzhi.DTO;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class PersonDTO {
    private String firstName;
    private String middleName;
    private String lastName;
    private String sessionId;
    private String id;
    private Set<HomeDTO> homeDTO = null;

    public PersonDTO(String lastName, String firstName, String middleName, String sessionId) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.sessionId = sessionId;
        this.id = UUID.randomUUID().toString();
    }
    public PersonDTO(String lastName, String firstName, String middleName, String sessionId,String id, Set<HomeDTO> homeDTO) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.sessionId = sessionId;
        this.id = id;
        this.homeDTO = homeDTO;
    }

    public PersonDTO(){}

    public PersonDTO(String lastName, String firstName, String middleName, String sessionId,String id) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.sessionId = sessionId;
        this.id = id;
    }

    public void setHomeDTO(Set<HomeDTO> homeDTO) {
        System.out.println(homeDTO.size());
        this.homeDTO = homeDTO;
    }

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

    public Set<HomeDTO> getHomeDTO() {
        return this.homeDTO;
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getId() {
        return id;
    }

    public String getLastName() {
        return this.lastName;
    }
}
