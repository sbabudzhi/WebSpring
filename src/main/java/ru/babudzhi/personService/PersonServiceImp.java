package ru.babudzhi.personService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ru.babudzhi.modelPerson.PersonTable;
import ru.babudzhi.personDAO.PersonDAO;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PersonServiceImp implements PersonService {
    @Autowired
    private PersonDAO personDAO;

    public void setPersonDAO(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    @Transactional
    public void addPerson(PersonTable p) {
        this.personDAO.addPerson(p);
    }

    @Override
    @Transactional
    public void updatePerson(PersonTable p) {
        this.personDAO.updatePerson(p);
    }

    @Override
    @Transactional
    public List<PersonTable> listPersons() {
        return this.personDAO.listPersons();
    }

    @Override
    @Transactional
    public PersonTable getPersonById(String sessionId) {
        return this.personDAO.getPersonById(sessionId);
    }

    @Override
    public void removePerson(String sessionId) {
        this.personDAO.removePerson(sessionId);
    }
}



