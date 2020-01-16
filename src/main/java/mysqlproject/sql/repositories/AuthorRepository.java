package mysqlproject.sql.repositories;

import mysqlproject.models.Author;
import mysqlproject.sql.Connector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorRepository {

    private static final String GET_ALL_AUTHORS_QUERY = "SELECT * FROM authors ";
    private static final String ADD_NEW_AUTHOR = "INSERT INTO authors (name, birthDate) values (?, ?)";

    private Connector connector;

    public AuthorRepository(Connector connector) {
        this.connector = connector;
    }

    public List<Author> getAuthorList() {
        List<Author> authorList = new ArrayList<>();
        try {
            PreparedStatement ps = connector.getConnection().prepareStatement(GET_ALL_AUTHORS_QUERY);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                authorList.add(new Author(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authorList;
    }

    public void addNewAuthor(Author author) {
        try {
            PreparedStatement ps = connector.getConnection().prepareStatement(ADD_NEW_AUTHOR);
            ps.setString(1, author.getName());
            ps.setString(2, author.getBirthDate());
            ps.execute();
            System.out.println("Автор успешно добавлен в базу данных");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
