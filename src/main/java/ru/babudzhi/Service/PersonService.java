package ru.babudzhi.Service;

import ru.babudzhi.DTO.PersonDTO;
import java.util.List;

public interface PersonService {

    public void addPerson(PersonDTO p);
    public List<PersonDTO> listPersons();
    public List<PersonDTO> getPersonsBySessionId(String sessionId);
    public void removePerson(String id);
    public PersonDTO getPersonById(String id);
    public void update(PersonDTO p);
}