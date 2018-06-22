package ru.babudzhi.Service;

import ru.babudzhi.DTO.HomeDTO;
import ru.babudzhi.model.Home;

import java.util.List;

public interface HomeService  {
    public void addHome(HomeDTO home);
    public void removeHome (String id);
    public List<Home> getHomeListByPerson(String sessionId);
    public List<Home> getHomeList(String sessionId);
    public void updateHome(String id);
}
