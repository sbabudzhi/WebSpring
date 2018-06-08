package ru.babudzhi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import ru.babudzhi.person.Person;
import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PersonController {
    @Autowired
    ServiceDataBase serviceDataBase;

    @RequestMapping(value = ("/personController"), method = RequestMethod.POST)
    public ModelAndView doPost(@SessionAttribute String sessionId, @RequestParam String firstName, @RequestParam String middleName,
            @RequestParam String lastName)
            throws IOException, ServletException {

        Person person = new Person( new String(lastName.getBytes("iso-8859-1"), "utf8"),
                new String(firstName.getBytes("iso-8859-1"), "utf8"),
                new String(middleName.getBytes("iso-8859-1"), "utf8"),
                new String(sessionId));

        serviceDataBase.connectWithDataBase();
        serviceDataBase.insertInDataBase(person);
        return new ModelAndView("index");
    }

    @RequestMapping(value=("/personControllerResult"), method = RequestMethod.POST)
    public ModelAndView doPost(@SessionAttribute String sessionId) throws SQLException {

        List<Person> listPerson = new ArrayList<>();
        serviceDataBase.selectFromDataBase(listPerson, sessionId);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("results");
        modelAndView.addObject("list1", listPerson );
        return modelAndView;
    }
}
