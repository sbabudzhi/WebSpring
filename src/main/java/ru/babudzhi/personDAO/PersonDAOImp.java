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
    public List<Person> getPersonById(String sessionId) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Person> personsList = session.createQuery("select NEW ru.babudzhi.modelPerson.Person(lastName,firstName,middleName,sessionId) " +
                "from Person where sessionId = :sessionId").setParameter("sessionId",sessionId).getResultList();
        return personsList;
    }

    @Override
    public void removePerson(String sessionId) {
        Session session = this.sessionFactory.getCurrentSession();
        Person person = (Person) session.load(Person.class, new String(sessionId));
        if(null != person){
            session.delete(person);
        }
    }
}
