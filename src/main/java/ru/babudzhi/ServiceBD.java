package ru.babudzhi;

import org.springframework.stereotype.Service;
import ru.babudzhi.person.Person;
import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.*;
import java.util.List;

@Service
public class ServiceBD {
    private static final String CREATE_QUERY = "CREATE TABLE IF NOT EXISTS TEST123 (name3 VARCHAR(45), name1 VARCHAR(45), name2 varchar (45))";
    private String DATA_QUERY = "";
    private static final String DELETE_QUERY = "DROP TABLE IF EXISTS TEST123";

    public void controller(boolean dropTable, Person pers) throws ServletException, IOException {
        DATA_QUERY = "INSERT INTO TEST123 VALUES ('" + pers.getName3() + "','" + pers.getName1() + "','" + pers.getName2() + "')";
        try {
            DriverManager.registerDriver(new org.h2.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (Connection db = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "")) {
            try (Statement dataQuery = db.createStatement()) {
                if (dropTable == true) dataQuery.execute(DELETE_QUERY);
                dataQuery.execute(CREATE_QUERY);
                if (pers.getName1() != null && pers.getName2() != null && pers.getName3() != null)
                    dataQuery.execute(DATA_QUERY);
            }

        } catch (SQLException ex) {
            System.out.println("Database connection failure: "
                    + ex.getMessage());
        }
    }
    public void select(List<Person> list1) {
        try (Connection db = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "")) {
            try (Statement dataQuery = db.createStatement()) {
                PreparedStatement query = db.prepareStatement("SELECT * FROM TEST123");
                ResultSet rs = query.executeQuery();
                convertToList(rs,list1);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void convertToList(ResultSet rs, List<Person> p2) throws SQLException {
        Person pers1 = new Person();
        while (rs.next()) {
            pers1.setName1(rs.getString(2));
            pers1.setName2(rs.getString(3));
            pers1.setName3(rs.getString(1));
            p2.add(pers1);
        }
    }
}
