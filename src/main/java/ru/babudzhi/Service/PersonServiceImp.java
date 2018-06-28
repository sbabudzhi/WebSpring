package ru.babudzhi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.babudzhi.Service.PersonService;
import ru.babudzhi.model.Person;
import ru.babudzhi.DTO.PersonDTO;
import ru.babudzhi.DAO.PersonDAO;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PersonServiceImp implements PersonService {
    @Autowired
    private PersonDAO personDAO;

    @Override
    @Transactional
    public void addPerson(PersonDTO p) {
        this.personDAO.addPerson(p.getPerson());
    }

    @Override
    @Transactional
    public List<Person> listPersons() {
        return this.personDAO.listPersons();
    }

    @Override
    @Transactional
    public List<Person> getPersonsBySessionId(String sessionId) {return this.personDAO.getPersonsBySessionId(sessionId);}

    @Override
    @Transactional
    public void removePerson(String id) {
        this.personDAO.removePerson(id);
    }

    @Override
    public Person getPersonById(String id) {
            return this.personDAO.getPersonById(id);
    }
}



