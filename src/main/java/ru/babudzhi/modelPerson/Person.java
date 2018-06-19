package ru.babudzhi.modelPerson;

import javax.persistence.*;

@Entity
@Table(name = "TEST123", schema = "PUBLIC", catalog = "TEST")
public class Person {

    private String lastName;
    private String firstName;
    private String middleName;
    private String sessionId;

    public Person(String lastName, String firstName, String middleName, String sessionId){
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.sessionId = sessionId;
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
    @Basic
    @Column(name = "LASTNAME")
    public String getLastName() {
        return lastName;
    }
    @Basic
    @Column(name = "FIRSTNAME")
    public String getFirstName() { return firstName; }
    @Basic
    @Column(name = "MIDDLENAME")
    public String getMiddleName() { return middleName; }
    @Id
    @Column(name = "SESSIONID")
    public String getSessionId() { return sessionId; }


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

