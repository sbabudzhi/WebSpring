package ru.babudzhi.Service;

import ru.babudzhi.DTO.HomeDTO;

import java.util.List;

public interface HomeService  {
    public void addHome(HomeDTO home);
    public HomeDTO getHomeById(String sessionId);
    public List<HomeDTO> getHomeListBySessionId(String sessionId);
}
