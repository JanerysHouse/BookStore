package mysqlproject;

import mysqlproject.models.Book;
import mysqlproject.sql.Connector;
import mysqlproject.sql.repositories.BookRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *  Основной класс книжного магазина
 */
public class BookStore {

    // константы комманд
    private static final int COMMAND_SHOW_AUTHORS = 1; // команда показать всех авторов
    private static final int COMMAND_SHOW_BOOKS = 2;
    private static final int COMMAND_ADD_NEW_AUTHOR = 3;
    private static final int COMMAND_ADD_NEW_BOOK = 4;
    private static final int COMMAND_QUIT = 0;

    /**
     * пока переменная true программа работает
     */
    private static boolean running = true;
    private BufferedReader reader;

    private BookRepository bookRepository;

    public BookStore() {
        try {
            Connector connector = new Connector();

            bookRepository = new BookRepository(connector);
            reader  = new BufferedReader(new InputStreamReader(System.in));

            run();
        } catch (SQLException e) {
            System.out.println("Ошибка подключения к базе данных. Завершение работы.");
            e.printStackTrace();
        }
    }

    /**
     *  начальное меню
     */
    private void run() {
        while (running) {
            System.out.println("Введите команду: " +
                    "1 - Список авторов, " +
                    "2 - Список книг, " +
                    "3 - Добавить нового автора, " +
                    "4 - Добавит нувую книгу, " +
                    "0 - Завершение работы");
            try {
                processCommand(Integer.parseInt(reader.readLine()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     *
     */
    private void processCommand(int command) {
        switch (command) {
            case COMMAND_SHOW_AUTHORS:
                showAuthorList();
                break;
            case COMMAND_SHOW_BOOKS:
                showBookList();
                break;
            case COMMAND_ADD_NEW_AUTHOR:
                addNewAuthor();
                break;
            case COMMAND_ADD_NEW_BOOK:
                addNewBook();
                break;
            case COMMAND_QUIT:
                quit();
                break;
            default:
                System.out.println("Комманда не найдена");
        }
    }

    private void showAuthorList() {

    }

    /**
     * Вывести в консоль список книг в магазине
     */
    private void showBookList() {
        bookRepository.getBookList().forEach(System.out::println);
    }

    private void addNewBook()  {
        try {
            System.out.println("Введите название новой книги");
            String title = reader.readLine();
            System.out.println("Введите рейтинг книги");
            int rating = Integer.parseInt(reader.readLine());
            System.out.println("Введите id автора");
            int authorId = Integer.parseInt(reader.readLine());
            bookRepository.addNewBook(new Book(title, rating, authorId));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addNewAuthor() {

    }

    private void quit() {
        System.out.println("Завершение работы программы");
        running = false;
    }
}
