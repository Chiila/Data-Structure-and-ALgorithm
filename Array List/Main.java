import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override

    public String toString() {
        return title + " by " + author;
    }
}

class Library {
    private ArrayList<Book> catalog = new ArrayList<>();
    private Stack<Book> borrowedBooks = new Stack<>();

    public void addBook(Book book) {
        catalog.add(book);
    }

    public void displayCatalog() {
        System.out.println("Available Books:");
        for (Book book : catalog) {
            System.out.println(book);
        }
    }

    public void borrowBook(String title) {
        for (Book book : catalog) {
            if (book.getTitle().equals(title)) {
                catalog.remove(book);
                borrowedBooks.push(book);
                System.out.println("You've borrowed: " + book);
                return;
            }
        }
        System.out.println("Book not found in the catalog.");
    }

    public void returnBook() {
        if (!borrowedBooks.isEmpty()) {
            Book returnedBook = borrowedBooks.pop();
            catalog.add(returnedBook);
            System.out.println("You've returned: " + returnedBook);
        } else {
            System.out.println("No books to return.");
        }
    }
    
    public void displayBorrowedBooks() {
        System.out.println("Borrowed Books:");
        for (Book book : borrowedBooks) {
            System.out.println(book);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Book("Sofia the first", "Duday"));
        library.addBook(new Book("Cilla Ganda", "Cilla"));
        library.addBook(new Book("Haduken", "Irish"));

Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nLibrary Option:");
            System.out.println("[1] Display Catalog");
            System.out.println("[2] Borrow a Book");
            System.out.println("[3] Return a Book");
            System.out.println("[4] Display Borrowed Books");
            System.out.println("[5] Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    library.displayCatalog();
                    break;

                case 2:
                    System.out.print("Enter the title of the book you want to borrow: ");
                    String titleToBorrow = scanner.nextLine();
                    library.borrowBook(titleToBorrow);
                    break;

                case 3:
                    library.returnBook();
                    break;

                case 4:
                    library.displayBorrowedBooks();
                    break;

                case 5:
                    System.out.println("Haynako!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }
}