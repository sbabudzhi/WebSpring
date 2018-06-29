package ru.babudzhi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.babudzhi.DTO.HomeDTO;
import ru.babudzhi.model.Home;
import ru.babudzhi.model.Person;
import ru.babudzhi.DTO.PersonDTO;
import ru.babudzhi.DAO.PersonDAO;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class PersonServiceImp implements PersonService {
    @Autowired
    private PersonDAO personDAO;

    @Override
    @Transactional
    public void addPerson(PersonDTO p) {
        Person person = new Person(p.getLastName(), p.getFirstName(), p.getMiddleName(), p.getSessionId(), p.getId());
        this.personDAO.addPerson(person);
    }

    @Override
    @Transactional
    public List<PersonDTO> listPersons() {
        List<Person> listPerson = this.personDAO.listPersons();
        List<PersonDTO> listPDTO = new ArrayList<>();
        addInListPersonDTO(listPDTO,listPerson);
        return listPDTO;
    }

    @Override
    @Transactional
    public List<PersonDTO> getPersonsBySessionId(String sessionId) {
        List<Person> listPerson = this.personDAO.getPersonsBySessionId(sessionId);
        List<PersonDTO> listPDTO = new ArrayList<>();
        addInListPersonDTO(listPDTO,listPerson);
        return listPDTO;
    }

    @Override
    @Transactional
    public void removePerson(String id) {
        this.personDAO.removePerson(id);
    }

    @Override
    public PersonDTO getPersonById(String id) {
    Person person = this.personDAO.getPersonById(id);
        Set<Home> homes = person.getHome();
        Set<HomeDTO> homeDTOSet = new HashSet<>();
        for (Home home : homes) {
            HomeDTO homeDTO = new HomeDTO(home.getStreet(),home.getNumber(),home.getSessionId(),home.getId());
            homeDTOSet.add(homeDTO);
        }
    return new PersonDTO(person.getLastName(), person.getFirstName(),person.getMiddleName(), person.getSessionId(), person.getId(),homeDTOSet);
    }

    @Override
    public void update(PersonDTO p) {
        Set<HomeDTO> homes = p.getHomeDTO();
        Set<Home> setHome = new HashSet<>();
        for (HomeDTO homeDTO : homes) {
            Home home = new Home(homeDTO.getStreet(),homeDTO.getNumber(),homeDTO.getSessionId(),homeDTO.getId());
            setHome.add(home);
        }
        this.personDAO.update(new Person(p.getLastName(),p.getFirstName(),p.getMiddleName(),p.getSessionId(),p.getId(),setHome));
    }

    public void addInListPersonDTO (List<PersonDTO> listPDTO, List<Person> listPerson){
        for (int i = 0; i< listPerson.size(); i++) {
            Set<Home> homes = listPerson.get(i).getHome();
            Set<HomeDTO> setHomeDTO = new HashSet<>();
            for (Home home : homes) {
                HomeDTO homeDTO = new HomeDTO(home.getStreet(), home.getNumber(), home.getSessionId(), home.getId());
                setHomeDTO.add(homeDTO);
            }
            PersonDTO persDTO = new PersonDTO(listPerson.get(i).getLastName(), listPerson.get(i).getFirstName(),
                    listPerson.get(i).getMiddleName(), listPerson.get(i).getSessionId(), listPerson.get(i).getId(), setHomeDTO);
            listPDTO.add(persDTO);

        }
    }
}



