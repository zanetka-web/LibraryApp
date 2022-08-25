import java.util.Scanner;

public class Window {

    String display = """
            Choose the options below:
            1 - register book 
            2 - borrow book 
            3 - return book
            """;
    Library library = new Library();

    public void displayScreen() {
        System.out.println(display);
    }

    public void processOption() {
        Scanner scan = new Scanner(System.in);
        int option = scan.nextInt();
        if (option == 1) {
            firstOption();
        } else if (option == 2) {
            secondOption();

        } else if (option == 3) {
            thirdOption();
        }

    }

    public void firstOption() {
        System.out.println("Give the name of the book");
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        System.out.println("Give the name of the author");
        Scanner scanner2 = new Scanner(System.in);
        String b = scanner2.nextLine();
        Book book = new Book(a, b);
        library.addBook(book);

    }


    public void secondOption() {

        System.out.println("Type the name of the book");
        Scanner scanner = new Scanner(System.in);
        String bookName = scanner.nextLine();
        Boolean isBookExist = library.hasBook(bookName);
        if (!isBookExist) {
            System.out.println("This book doesn't exist");
        } else {
            Book book = library.getBook(bookName);

            System.out.println("Write name of the user");
            Scanner scanner2 = new Scanner(System.in);
            String userName = scanner2.nextLine();
            User user = null;
            if (library.hasUser(userName)) {
                user = library.getUser(userName);
            } else {
                user = new User(userName);
                library.addUser(user);
            }
            if (library.hasUserBook(user)) {
                System.out.println("The user already has a book");
            } else if (library.isBookBorrowed(book)) {
                System.out.println("The book has been already borrowed");
            } else {
                library.borrowedBook(user, book);
                System.out.println("The book has been borrowed");
                book.setCountBorrowed();
            }
        }
    }

    public void thirdOption() {
        System.out.println("Write the name of the user");
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.nextLine();
        Boolean isUserExist = library.hasUser(userName);
        if (!isUserExist) {
            System.out.println("This user doesn't exist");
        } else if (!library.hasUserBook(userName)) {
            System.out.println("You don't have any book to return");
        } else {
             Book book = library.findUserBook(userName);
            System.out.println("Do you want to return ".concat(book.getBookName()).concat(" y/n"));
            Scanner scanner2 = new Scanner(System.in);
            String answer = scanner2.nextLine();
            if (answer.equals("y")) {
                // TODO: remove the book from the borrowed table
                library.removedBorrowedBook(userName);
                System.out.println("Your book is returned , thank you");
            } else {
                System.out.println("Enjoy your time with the book");
            }
        }
    }


}

