package ru.babudzhi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.babudzhi.DTO.HomeDTO;
import ru.babudzhi.Service.HomeService;
import ru.babudzhi.DTO.PersonDTO;
import ru.babudzhi.Service.PersonService;
import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Set;

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
        List<PersonDTO> listPersons = serviceDataBase.selectFromDataBase((request.getSession().getId()));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("results");
        modelAndView.addObject("list1", listPersons );
        return modelAndView;
    }*/
    @Autowired
    private PersonService personService;

    @Autowired
    private HomeService homeService;

    @RequestMapping(value = "/")
    public ModelAndView welcomePage(){ return new ModelAndView("index"); }

    @RequestMapping(value = "/userEnter", method = RequestMethod.POST)
    public ModelAndView userEnter(){
        return new ModelAndView("userEnter");
    }
    @RequestMapping(value = "/homeEnter", method = RequestMethod.POST)
    public ModelAndView homeEnter(){
        return new ModelAndView("homeEnter");
    }
    @RequestMapping(value = "/userInHome")
    public ModelAndView userInHome(Model model,HttpServletRequest request){
        model.addAttribute("listHomes",homeService.getHomeListBySessionId(request.getSession().getId()));
        model.addAttribute("listPersons", personService.getPersonsBySessionId(request.getSession().getId()));
        return new ModelAndView("userInHome");
    }

    @RequestMapping(value= "/add", method = RequestMethod.POST)
    public ModelAndView addPerson(@RequestParam String firstName, @RequestParam String middleName, @RequestParam String lastName,
                                  HttpServletRequest request){
        this.personService.addPerson( new PersonDTO(lastName,firstName,middleName, request.getSession().getId()));
        return new ModelAndView("userEnter");
    }
    @RequestMapping(value = "/addHome", method = RequestMethod.POST)
    public ModelAndView addHome(Model model, @RequestParam String street, @RequestParam String number, HttpServletRequest request){
        this.homeService.addHome(new HomeDTO(street, number,request.getSession().getId()));
        return new ModelAndView("homeEnter");
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////убралаTRansactional
    @RequestMapping(value = "/addUserInHome", method = RequestMethod.POST)
    public String addUserInHome(Model model, @RequestParam String[] home){
        addUserInHome(home);
        return ("forward:/persons");
    }

    @RequestMapping(value = "/persons", method = RequestMethod.POST)
    public ModelAndView listPersons(Model model, HttpServletRequest request) {
        model.addAttribute("listPersons", personService.getPersonsBySessionId(request.getSession().getId()));
        return new ModelAndView("resultsPerson");
    }
    @RequestMapping(value = "/homes", method = RequestMethod.POST)
    public ModelAndView listHomes(Model model, HttpServletRequest request) {
        model.addAttribute("listHomes", homeService.getHomeById(request.getSession().getId()));
        return new ModelAndView("resultsHome");
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public ModelAndView removePerson(Model model, HttpServletRequest request, @RequestParam String idPerson){
        this.personService.removePerson(idPerson);
        model.addAttribute("listPersons",this.personService.getPersonsBySessionId(request.getSession().getId()));
        return new ModelAndView("resultsPerson");
    }
    @RequestMapping(value = "/results", method = RequestMethod.POST)
    public ModelAndView results(){
         return new ModelAndView("results");
    }


    public void addUserInHome(String home[]){

        Set<HomeDTO> homes = new HashSet<HomeDTO>();
        PersonDTO personDTO;
        String del = "\\_";
        for(int i = 0; i< home.length; i++) {
            if (i != 0 && !home[i].split(del)[0].equals(home[i - 1].split(del)[0])) {  //если этот персон не является тем же самым, что был прошлый раз
                homes = new HashSet<>();
            }
            homes.add(homeService.getHomeById(home[i].split(del)[1]));
            personDTO = personService.getPersonById(home[i].split(del)[0]);
            personDTO.setHomeDTO(homes); //добавить коллекцию
            this.personService.update(personDTO); //добавить коллекцию
         }
    }
}
