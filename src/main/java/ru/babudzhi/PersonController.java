package ru.babudzhi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.babudzhi.person.Person;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Controller
public class PersonController {
    @Autowired
    ServiceDataBase serviceDataBase;

    @RequestMapping(value = ("/personController"), method = RequestMethod.POST)
    public ModelAndView addPerson(@RequestParam String firstName, @RequestParam String middleName,
                                  @RequestParam String lastName, HttpServletRequest request){

        Person person = new Person(lastName, firstName, middleName, new String(request.getSession().getId()));

        serviceDataBase.insertInDataBase(person);
        return new ModelAndView("index");
    }

    @RequestMapping(value=("/personControllerResult"), method = RequestMethod.POST)
    public ModelAndView getResults(HttpServletRequest request) throws SQLException {

        List<Person> listPerson = serviceDataBase.selectFromDataBase((request.getSession().getId()));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("results");
        modelAndView.addObject("list1", listPerson );
        return modelAndView;
    }
}
