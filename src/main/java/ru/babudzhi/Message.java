package ru.babudzhi;

import org.springframework.beans.factory.annotation.Autowired;
import ru.babudzhi.DTO.PersonDTO;
import ru.babudzhi.Service.PersonService;

import java.util.ArrayList;
import java.util.List;

public class Message {
    List<PersonDTO> personDTOList = new ArrayList<>();
    @Autowired
    PersonService personService;
    public Message (String sessionId){
        personDTOList = personService.getPersonsBySessionId(sessionId);
    }
}
