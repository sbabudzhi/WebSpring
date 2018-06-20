package ru.babudzhi.personDAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.babudzhi.modelPerson.Person;
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

    @Override
    public void updatePerson(Person person) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(person);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Person> listPersons() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Person> personsList = session.createQuery("from Person").list();
        return personsList;
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
