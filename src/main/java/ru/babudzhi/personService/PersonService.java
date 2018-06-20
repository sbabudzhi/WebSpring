package ru.babudzhi.personService;
import ru.babudzhi.modelPerson.Person;

import java.util.List;

public interface PersonService {

    public void addPerson(Person p);
    public void updatePerson(Person p);
    public List<Person> listPersons();
    public List<Person> getPersonsBySessionId(String sessionId);
    public void removePerson(String id);

}