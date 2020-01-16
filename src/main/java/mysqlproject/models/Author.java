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

    public Author(String name, String birthDate) {
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


    @Override
    public String toString() {
        return String.format("Имя автора %s, День рождения %s", name, birthDate);
    }
}

