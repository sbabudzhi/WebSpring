package ru.babudzhi.DTO;

import ru.babudzhi.model.Person;
import java.util.UUID;

public class PersonDTO {
    Person person;

    public PersonDTO(String lastName, String firstName, String middleName, String sessionId) {
        person = new Person(lastName, firstName, middleName, sessionId);
        person.setId(UUID.randomUUID().toString());
    }
    public PersonDTO(){}

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

}
//    private String firstName;
//    private String middleName;
//    private String lastName;
//    private String sessionId;
//
//    public PersonDTO(String lastName, String firstName, String middleName, String sessionId) {
//        this.lastName = lastName;
//        this.firstName = firstName;
//        this.middleName = middleName;
//        this.sessionId = sessionId;
//    }
//
//
//    public String getFirstName() {
//        return this.firstName;
//    }
//
//    public String getMiddleName() {
//        return this.middleName;
//    }
//
//    public String getLastName() {
//        return this.lastName;
//    }
//
//    public String getSessionId(){ return this.sessionId;}

