package ru.babudzhi.DTO;

import ru.babudzhi.model.Home;

import java.util.UUID;

public class HomeDTO {
    private Home home;

    public HomeDTO(String street, String number,String sessionId){
        home= new Home(street,number,sessionId);
    }

    public Home getHome() {
        return home;
    }
}
