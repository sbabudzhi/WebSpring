package ru.babudzhi.Service;
import ru.babudzhi.model.Person;
import ru.babudzhi.DTO.PersonDTO;

import java.util.List;

public interface PersonService {

    public void addPerson(PersonDTO p);
    public List<Person> listPersons();
    public List<Person> getPersonsBySessionId(String sessionId);
    public void removePerson(String id);

}