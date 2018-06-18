package ru.babudzhi.personDAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.babudzhi.modelPerson.PersonTable;
import java.util.List;

@Repository
public class PersonDAOImp implements PersonDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addPerson(PersonTable personTable) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(personTable);
        session.save(personTable);
         }

    @Override
    public void updatePerson(PersonTable personTable) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(personTable);
          }

    @SuppressWarnings("unchecked")
    @Override
    public List<PersonTable> listPersons() {
        Session session = this.sessionFactory.getCurrentSession();
        List<PersonTable> personsList = session.createQuery("from PersonTable").list();

        return personsList;
    }

    @Override
    public PersonTable getPersonById(String sessionId) {
        Session session = this.sessionFactory.getCurrentSession();
        PersonTable personTable = session.load(PersonTable.class, new String(sessionId));

        return personTable;
    }

    @Override
    public void removePerson(String sessionId) {
        Session session = this.sessionFactory.getCurrentSession();
        PersonTable personTable = (PersonTable) session.load(PersonTable.class, new String(sessionId));
        if(null != personTable){
            session.delete(personTable);
        }

    }
}
