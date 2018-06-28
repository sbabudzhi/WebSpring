package ru.babudzhi.DAO;

import ru.babudzhi.model.Home;

import java.util.List;

public interface HomeDAO {

    public void addHome(Home home);

    public void removeHome(String id);

    public Home getHomeListByPerson(String person);

    public List<Home> getHomeList(String sessionId);

    public void updateHome(String id);
}
