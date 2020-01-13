package mysqlproject.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Book {
    private int id;
    private String title;
    private int rating;
    private int authorId;

    public Book(ResultSet rs) throws SQLException {
        this.id = rs.getInt("id");
        this.title = rs.getString("title");
        this.rating = rs.getInt("rating");
        this.authorId = rs.getInt("authorid");
    }

    public Book(String title, int rating, int authorId) {
        this.title = title;
        this.rating = rating;
        this.authorId = authorId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getRating() {
        return rating;
    }

    public int getAuthorId() {
        return authorId;
    }

    @Override
    public String toString() {
        return String.format("Книга с названием %s, id = %d, id автора = %d, рейтинг = %s",
                title, id, authorId, rating);
    }
}
