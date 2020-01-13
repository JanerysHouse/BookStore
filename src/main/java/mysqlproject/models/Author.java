package mysqlproject.models;

import java.sql.Date;

public class Author {
    private int id;
    private String name;
    private Date birthDate;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }
}
