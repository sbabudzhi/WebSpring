package ru.babudzhi.serviceDB;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttribute;
import ru.babudzhi.person.Person;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceDataBase {
    private static final String CREATE_QUERY = "CREATE TABLE IF NOT EXISTS TEST123 (lastName VARCHAR(45), " +
            "firstName VARCHAR(45), middleName varchar (45)," + " sessionId VARCHAR (45))";

    private String DATA_QUERY = "";
    private Connection db;

    public ServiceDataBase() {
        try {
            DriverManager.registerDriver(new org.h2.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            db = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
        } catch (SQLException ex) {
            System.out.println("Database connection failure: "
                    + ex.getMessage());
        }
    }

    public void insertInDataBase (Person person){

        DATA_QUERY = "INSERT INTO TEST123 VALUES ('" + person.getLastName() + "','" + person.getFirstName() +
                "','" + person.getMiddleName() + "','" + person.getSessionId() +"')";

        try (Statement dataQuery = db.createStatement()) {
            dataQuery.execute(CREATE_QUERY);
            dataQuery.execute(DATA_QUERY);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Person> selectFromDataBase(@SessionAttribute String sessionId) throws SQLException {

        PreparedStatement query = db.prepareStatement("SELECT * FROM TEST123 WHERE sessionId = '" + sessionId + "'");
        ResultSet rs = query.executeQuery();
        List<Person> list1 = new ArrayList<>();
        convertToList(rs,list1);
        return list1;
}

    protected void convertToList(ResultSet rs, List<Person> p2) throws SQLException {
        while (rs.next()) {
            p2.add(new Person(rs.getString(1), rs.getString(2),
                              rs.getString(3), rs.getString(4)));
        }
    }
}
