package ru.babudzhi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.babudzhi.DTO.HomeDTO;
import ru.babudzhi.DAO.HomeDAO;
import ru.babudzhi.model.Home;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class HomeServiceImpl implements HomeService {

    @Autowired
    private HomeDAO homeDAO;

    @Override
    @Transactional
    public void addHome(HomeDTO home) {
        this.homeDAO.addHome(home.getHome());

    }

    @Override
    @Transactional
    public void removeHome(String id) {
        this.homeDAO.removeHome(id);
    }

    @Override
    @Transactional
    public List<Home> getHomeListByPerson(String sessionId) {
        return this.homeDAO.getHomeListByPerson(sessionId);
    }

    @Override
    public List<Home> getHomeList(String sessionId) {
        return this.homeDAO.getHomeList(sessionId);
    }

    @Override
    @Transactional
    public void updateHome(String id) {
        this.homeDAO.updateHome(id);
    }
}
