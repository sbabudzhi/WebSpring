package ru.babudzhi.personHome;

import javax.persistence.*;

@Table(name = "PERSONHOME")
public class PersonHome {

    @ManyToMany
    @JoinColumn(name = "PERSONID")
    String personId;
    @ManyToMany
    @JoinColumn(name = "HOMEID")
    String homeId;

    public PersonHome(){}
    public PersonHome(String personId, String homeId){
        this.homeId = homeId;
        this.personId = personId;

    }

    public void setHomeId(String homeId) {
        this.homeId = homeId;
    }
    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getHomeId() {
        return homeId;
    }

    public String getPersonId() {
        return personId;
    }
}
