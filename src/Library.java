import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class Library {

    Hashtable<String, Book> bookTable = new Hashtable();
    int countBorrow = 0;

    public void addBook(Book book) {
        if (bookTable.containsKey(book.getBookName())) {
            System.out.println("The book already exist and cannot be register");
        } else {
            bookTable.put(book.getBookName(), book);
            System.out.println("The book ".concat(book.getBookName()).concat(" has been registered"));
        }
    }

    public boolean hasBook(String bookName) {
        return this.bookTable.containsKey(bookName);
    }

    public Book getBook(String bookName) {
        return bookTable.get(bookName);
    }


    // List<String> listOfUsers = new ArrayList<String>();

    //  public void addUser(User user){
    //      listOfUsers.add(user.getUserName());
    //  }


    private Hashtable<String, User> userTable = new Hashtable();

    public void addUser(User user) {
        userTable.put(user.getUserName(), user);
    }

    public boolean hasUser(String userName) {
        return userTable.containsKey(userName);
    }

    public User getUser(String userName) {
        return userTable.get(userName);
    }

    private Hashtable<String, Book> borrowedBookTable = new Hashtable();

    public void borrowedBook(User user, Book book) {
        borrowedBookTable.put(user.getUserName(), book);
    }

    public boolean hasUserBook(User user) {
        return borrowedBookTable.containsKey(user.getUserName());
    }

    public boolean hasUserBook(String user) {
        return borrowedBookTable.containsKey(user);
    }

    public boolean isBookBorrowed(Book book) {
        return borrowedBookTable.contains(book);
    }

    public Book findUserBook(String userName) {
        return borrowedBookTable.get(userName);
    }

    public void removedBorrowedBook(String user){
        borrowedBookTable.remove(user);
    }
}
