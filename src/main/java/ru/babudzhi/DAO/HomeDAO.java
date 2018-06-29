package ru.babudzhi.DAO;

import ru.babudzhi.model.Home;

import java.util.List;

public interface HomeDAO {

    public void addHome(Home home);

    public Home getHomeById(String person);

    public List<Home> getHomeListBySessionId(String sessionId);
}
