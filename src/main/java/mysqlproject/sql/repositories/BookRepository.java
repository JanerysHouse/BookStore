package mysqlproject.sql.repositories;

import mysqlproject.models.Book;
import mysqlproject.sql.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    private static final String GET_ALL_BOOKS_QUERY = "SELECT * FROM books";
    private static final String ADD_NEW_BOOK = "INSERT INTO books (title, rating, authorid) values (?, ?, ?)";

    private Connector connector;

    public BookRepository(Connector connector) {
        this.connector = connector;
    }

    public List<Book> getBookList() {
        List<Book> bookList = new ArrayList<>();
        try {
            PreparedStatement ps = connector.getConnection().prepareStatement(GET_ALL_BOOKS_QUERY);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                bookList.add(new Book(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    public void addNewBook(Book book) {
        try {
            PreparedStatement ps = connector.getConnection().prepareStatement(ADD_NEW_BOOK);
            ps.setString(1, book.getTitle());
            ps.setInt(2, book.getRating());
            ps.setInt(3, book.getAuthorId());
            ps.execute();
            System.out.println("Книга успешно добавлена в базу данных");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
