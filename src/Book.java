import java.util.Hashtable;

public class Book {


    private String bookName;
    private String bookAuthor;

    private int countBorrowed = 0;

    public void setCountBorrowed() {
        this.countBorrowed += 1;
    }

    public String getBookName() {
        return bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public Book(String bookName, String bookAuthor) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
    }

}
