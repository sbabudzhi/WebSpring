package ru.babudzhi.person;

public class Person  {
    private String firstName;
    private String middleName;
    private String lastName;
    private String sessionId;

    public Person(String lastName, String firstName, String middleName, String sessionId) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.sessionId = sessionId;
    }


    public String getFirstName() {
        return this.firstName;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getSessionId(){ return this.sessionId;}

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
