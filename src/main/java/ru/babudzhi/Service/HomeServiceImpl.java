package ru.babudzhi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.babudzhi.DTO.HomeDTO;
import ru.babudzhi.DAO.HomeDAO;
import ru.babudzhi.model.Home;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class HomeServiceImpl implements HomeService {

    @Autowired
    private HomeDAO homeDAO;

    @Override
    @Transactional
    public void addHome(HomeDTO home) {

        this.homeDAO.addHome(new Home(home.getStreet(),home.getNumber(),home.getSessionId(),home.getId()));
    }
    @Override
    @Transactional
    public HomeDTO getHomeById(String id) {
        Home home = this.homeDAO.getHomeById(id);
        return new HomeDTO(home.getStreet(),home.getNumber(),home.getSessionId(),home.getId());
    }

    @Override
    public List<HomeDTO> getHomeListBySessionId(String sessionId) {
        List<Home> listHome = this.homeDAO.getHomeListBySessionId(sessionId);
        List<HomeDTO> listHDTO = new ArrayList<>();
        for (int i = 0; i< listHome.size(); i++) {
             HomeDTO persDTO = new HomeDTO(listHome.get(i).getStreet(),listHome.get(i).getNumber(),
                    listHome.get(i).getSessionId(), listHome.get(i).getId());
            listHDTO.add(persDTO);

        }
        return listHDTO;
    }
}
