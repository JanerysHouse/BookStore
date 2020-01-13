package mysqlproject.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

    private Connection connection;

    public Connector() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bookStore?serverTimezone=UTC","root","123456");
        System.out.println("Подключились к базе успешно!");
    }

    public Connection getConnection() {
        return connection;
    }
}
