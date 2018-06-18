package ru.babudzhi.personDAO;

import ru.babudzhi.modelPerson.PersonTable;

import java.util.List;

public interface PersonDAO {

    public void addPerson(PersonTable p);
    public void updatePerson(PersonTable p);
    public List<PersonTable> listPersons();
    public PersonTable getPersonById(String sessionId);
    public void removePerson(String sessionId);
}