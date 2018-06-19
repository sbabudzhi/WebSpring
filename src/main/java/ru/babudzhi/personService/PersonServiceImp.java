package ru.babudzhi.personService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.babudzhi.modelPerson.Person;
import ru.babudzhi.personDAO.PersonDAO;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PersonServiceImp implements PersonService {
    @Autowired
    private PersonDAO personDAO;

    @Override
    @Transactional
    public void addPerson(Person p) {
        this.personDAO.addPerson(p);
    }

    @Override
    @Transactional
    public void updatePerson(Person p) {
        this.personDAO.updatePerson(p);
    }

    @Override
    @Transactional
    public List<Person> listPersons() {
        return this.personDAO.listPersons();
    }

    @Override
    @Transactional
    public List<Person> getPersonById(String sessionId) {
        return this.personDAO.getPersonById(sessionId);
    }

    @Override
    public void removePerson(String sessionId) {
        this.personDAO.removePerson(sessionId);
    }
}



