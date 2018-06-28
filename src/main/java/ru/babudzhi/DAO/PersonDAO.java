package ru.babudzhi.DAO;

import ru.babudzhi.model.Person;
import java.util.List;

public interface PersonDAO {

    public void addPerson(Person p);
    public List<Person> listPersons();
    public List<Person> getPersonsBySessionId(String sessionId);
    public void removePerson(String id);
    public Person getPersonById(String id);
}