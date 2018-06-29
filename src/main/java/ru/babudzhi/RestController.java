package ru.babudzhi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.babudzhi.DTO.PersonDTO;
import ru.babudzhi.Service.PersonService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private PersonService personService;

    @RequestMapping (value="getPersonWithHome", method = RequestMethod.POST)
    public List<PersonDTO> getPersonWithHome(Model model, HttpServletRequest request){
        return personService.getPersonsBySessionId(request.getSession().getId());
    }
}
