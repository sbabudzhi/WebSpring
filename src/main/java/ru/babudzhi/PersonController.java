package ru.babudzhi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.babudzhi.modelPerson.Person;
import ru.babudzhi.personService.PersonService;
import javax.servlet.http.HttpServletRequest;

@Controller
public class PersonController {
    /*@Autowired
    ServiceDataBase serviceDataBase;

    Без Hibernate

    @RequestMapping(value = ("/personController"), method = RequestMethod.POST)
    public ModelAndView addPerson(@RequestParam String firstName, @RequestParam String middleName,
                                  @RequestParam String lastName, HttpServletRequest request){

        PersonDTO person = new PersonDTO(lastName, firstName, middleName, new String(request.getSession().getId()));

        serviceDataBase.insertInDataBase(person);
        return new ModelAndView("index");
    }

    @RequestMapping(value=("/personControllerResult"), method = RequestMethod.POST)
    public ModelAndView getResults(HttpServletRequest request) throws SQLException {

        List<PersonDTO> listPerson = serviceDataBase.selectFromDataBase((request.getSession().getId()));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("results");
        modelAndView.addObject("list1", listPerson );
        return modelAndView;
    }*/
    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/")
    public ModelAndView welcomePage(){ return new ModelAndView("index"); }

    @RequestMapping(value = "/persons", method = RequestMethod.POST)
    public ModelAndView listPersons(Model model, HttpServletRequest request) {
        model.addAttribute("listPerson", personService.getPersonById(request.getSession().getId()));
        return new ModelAndView("results");
    }

    @RequestMapping(value= "/add", method = RequestMethod.POST)
    public ModelAndView addPerson(@RequestParam String firstName, @RequestParam String middleName, @RequestParam String lastName,
                                  HttpServletRequest request){
        this.personService.addPerson( new Person(lastName,firstName,middleName, request.getSession().getId()));
        return new ModelAndView("index");
    }

    @RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("sessionId") String sessionId){
        this.personService.removePerson(sessionId);
        return "redirect:/persons";
    }

    @RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("sessionId") String sessionId, Model model){
        model.addAttribute("person", this.personService.getPersonById(sessionId));
        model.addAttribute("listPersons", this.personService.listPersons());
        return "person";
    }

}
