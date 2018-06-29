package ru.babudzhi.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.babudzhi.model.Home;

import java.util.List;

@Repository
public class HomeDAOImpl implements HomeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addHome(Home home) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(home);
    }

    @Override
    public Home getHomeById(String id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Home.class,id);
    }

    @Override
    public List<Home> getHomeListBySessionId(String sessionId){
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Home where sessionId =:sessionId ").setParameter("sessionId",sessionId).list();
    }

}
