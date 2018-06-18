package ru.babudzhi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.babudzhi.modelPerson.PersonTable;
import ru.babudzhi.person.Person;
import ru.babudzhi.personService.PersonService;
import ru.babudzhi.serviceDB.ServiceDataBase;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

@Controller
public class PersonController {
    @Autowired
    ServiceDataBase serviceDataBase;
//
//    @RequestMapping(value = ("/personController"), method = RequestMethod.POST)
//    public ModelAndView addPerson(@RequestParam String firstName, @RequestParam String middleName,
//                                  @RequestParam String lastName, HttpServletRequest request){
//
//        Person person = new Person(lastName, firstName, middleName, new String(request.getSession().getId()));
//
//        serviceDataBase.insertInDataBase(person);
//        return new ModelAndView("index");
//    }
//
//    @RequestMapping(value=("/personControllerResult"), method = RequestMethod.POST)
//    public ModelAndView getResults(HttpServletRequest request) throws SQLException {
//
//        List<Person> listPerson = serviceDataBase.selectFromDataBase((request.getSession().getId()));
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("results");
//        modelAndView.addObject("list1", listPerson );
//        return modelAndView;
//    }

    private PersonService personService;

    @Autowired(required=true)
  //  @Qualifier(value="personService")
    public void setPersonService(PersonService ps){
        this.personService = ps;
    }

    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public String listPersons(Model model) {
        model.addAttribute("personTable", new PersonTable());
        model.addAttribute("listPersons", this.personService.listPersons());
        return "personTable";
    }

    //For add and update person both
    @RequestMapping(value= "/person/add", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("personTable") PersonTable p,@RequestParam String firstName, @RequestParam String middleName,
                                 @RequestParam String lastName,  HttpServletRequest request){
        p = new PersonTable(lastName,firstName,middleName,new String(request.getSession().getId()));
        this.personService.addPerson(p);
        System.out.println("!!!!!!!!!!!!!новый персон нужен!!!!!!!!!!!");
//        if(p.getSessionId() == ""){
//            //new person, add it
//            this.personService.addPerson(p);
//        }else{
//            //existing person, call update
//            System.out.println("!!!!!!!!!!!!!новый персон не нужен!!!!!!!!!!!");
//
//            //this.personService.updatePerson(p);
//        }

        return "redirect:/persons";

    }

    @RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("sessionId") String sessionId){

        this.personService.removePerson(sessionId);
        return "redirect:/persons";
    }

    @RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("sessionId") String sessionId, Model model){
        model.addAttribute("personTable", this.personService.getPersonById(sessionId));
        model.addAttribute("listPersons", this.personService.listPersons());
        return "personTable";
    }

}
