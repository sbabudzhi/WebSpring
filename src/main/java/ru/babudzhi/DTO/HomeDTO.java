package ru.babudzhi.DTO;

import ru.babudzhi.model.Home;

public class HomeDTO {
    private Home home;

    public HomeDTO(String street, String number,String sessionId){
        home= new Home(street,number,sessionId);
    }

    public HomeDTO(){}

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }
}
