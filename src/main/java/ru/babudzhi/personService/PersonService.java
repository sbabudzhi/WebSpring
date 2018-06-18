package ru.babudzhi.personService;
import ru.babudzhi.modelPerson.PersonTable;

import java.util.List;



public interface PersonService {

    public void addPerson(PersonTable p);
    public void updatePerson(PersonTable p);
    public List<PersonTable> listPersons();
    public PersonTable getPersonById(String sessionId);
    public void removePerson(String sessionId);

}