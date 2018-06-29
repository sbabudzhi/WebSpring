package ru.babudzhi.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.babudzhi.model.Home;
import ru.babudzhi.model.Person;
import java.util.List;

@Repository
public class PersonDAOImp implements PersonDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addPerson(Person person) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(person);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Person> listPersons() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Person> personsList = session.createQuery("from Person").list();
        return personsList;
    }

    @Override
    public Person getPersonById(String id) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.load(Person.class,id);
    }

    @Override
    public void update(Person p) {

        Session session = this.sessionFactory.getCurrentSession();
        Person person = session.load(Person.class,p.getId());
        person.setLastName(p.getLastName());
        person.setFirstName(p.getFirstName());
        person.setMiddleName(p.getMiddleName());
        person.setSessionId(p.getSessionId());
        person.setHome(null);
        session.update(person);
        person.setHome(p.getHome());
        session.update(person);
    }

    @Override
    public List<Person> getPersonsBySessionId(String sessionId) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("from Person p where p.sessionId = :sessionId").setParameter("sessionId",sessionId).getResultList();
    }

    @Override
    public void removePerson(String id) {
        Session session = this.sessionFactory.getCurrentSession();
        Person p = new Person();
        p.setId(id);
        session.delete(p);
    }


}
