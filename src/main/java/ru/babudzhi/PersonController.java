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
import ru.babudzhi.model.Home;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
        model.addAttribute("listHomes",homeService.getHomeList(request.getSession().getId()));
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
    @RequestMapping(value = "/addUserInHome")
    public ModelAndView addUserInHome(Model model, @RequestParam String[] home){
        model.addAttribute("listPersonsWithHome", addUserInHome(home));
        return new ModelAndView("results");
}


    @RequestMapping(value = "/persons", method = RequestMethod.POST)
    public ModelAndView listPersons(Model model, HttpServletRequest request) {
        model.addAttribute("listPersons", personService.getPersonsBySessionId(request.getSession().getId()));
       return new ModelAndView("resultsPerson");
    }
    @RequestMapping(value = "/homes", method = RequestMethod.POST)
    public ModelAndView listHomes(Model model, HttpServletRequest request) {
        model.addAttribute("listHomes", homeService.getHomeListByPerson(request.getSession().getId()));
        return new ModelAndView("resultsHome");
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public ModelAndView removePerson(Model model, HttpServletRequest request, @RequestParam String idPerson){
        this.personService.removePerson(idPerson);
        model.addAttribute("listPerson",this.personService.getPersonsBySessionId(request.getSession().getId()));
        return new ModelAndView("resultsPerson");
    }
    @RequestMapping(value = "/results", method = RequestMethod.POST)
    public ModelAndView results(){
         return new ModelAndView("results");
    }


    public List<PersonDTO> addUserInHome(String home[]){
        Set<Home> homes = new HashSet<Home>();
        String del = "\\_";
        PersonDTO personDTO;
        HomeDTO homeDTO;
        List<PersonDTO> listPerson = new ArrayList<>();

        for(int i = 0; i< home.length; i++){
            personDTO =  new PersonDTO();
            homeDTO = new HomeDTO();
            personDTO.setPerson(personService.getPersonById(home[i].split(del)[0]));
            homeDTO.setHome(homeService.getHomeListByPerson(home[i].split(del)[1]));
            if(i!= 0 && !home[i].split(del)[0].equals(home[i - 1].split(del)[0]))  //если этот персон не является тем же самым, что был прошлый раз
                homes = new HashSet<Home>();
            homes.add(homeDTO.getHome());
            if(i!= 0 && home[i].split(del)[0].equals(home[i-1].split(del)[0]))   //если этот персон является тем же самым, что был прошлый раз
                listPerson.get(listPerson.size()-1).getPerson().setHome(homes); //обновить коллекцию домов
            else{
                    personDTO.getPerson().setHome(homes); //добавить коллекцию
                    listPerson.add(personDTO);//добавить нового персона
            }
        }
        return listPerson;
    }
}
