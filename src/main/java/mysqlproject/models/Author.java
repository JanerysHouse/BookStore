package mysqlproject.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Author {
    private int id;
    private String name;
    private String birthDate;

    public Author(ResultSet rs) throws SQLException {
        this.id = rs.getInt("id");
        this.name = rs.getString("name");
        this.birthDate = rs.getString("birthDate");
    }

    public Author(int id, String name, String birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }




    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    }


