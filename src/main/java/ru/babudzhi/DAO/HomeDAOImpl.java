package ru.babudzhi.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.babudzhi.model.Home;
import ru.babudzhi.model.Person;

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
    public void removeHome(String id) {
        Session session = sessionFactory.getCurrentSession();
        Home home = new Home();
        home.setId(id);
        session.delete(home);

    }

    @Override
    public List<Home> getHomeListByPerson(String sessionId) {
        Session session = sessionFactory.getCurrentSession();
        return null;// session.createQuery("from  Home   where id =:id").setParameter("id",Person.class).getResultList();
    }

    @Override
    public List<Home> getHomeList(String sessionId){
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Home where sessionId =:sessionId ").setParameter("sessionId",sessionId).list();
    }

    @Override
    public void updateHome(String id) {

    }
}
