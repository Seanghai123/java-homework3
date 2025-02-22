import java.util.ArrayList;
import java.util.Scanner;

class Book {
    public static int counter = 1;
    public int id;
    public String title;
    public String author;
    public int publishedYear;
    public int status;
    public Book(String title, String author, int publishedYear, int status) {
        this.id = counter++;
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

public class toulkok {
    private static ArrayList<Book> library = new ArrayList<>();

    public static void main(String[] args) {
        int op = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Library's Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Library's Address: ");
        String address = sc.nextLine();

        do {
            System.out.println("1. Add Book");
            System.out.println("2. Show All Books");
            System.out.println("3. Show Available Books");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            op = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (op) {
                case 1:
                    addBook(sc);
                    break;
                case 2:
                    showAllBooks();
                    break;
                case 3:
                    System.out.print("show Available Books: ");
//                    showAvailableBooks();
                    break;
                case 4:
                    System.out.print("Borrow Book: ");
//                    borrowBook(sc);
                    break;
                case 5:
                    System.out.print("Return Book: ");
//                    returnBook(sc);
                    break;
                case 6:
                    System.out.println("Exiting system Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("input Please try again.");
            }
        } while (op <= 6);
    }

    static void addBook(Scanner sc) {
        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Book Author: ");
        String author = sc.nextLine();
        System.out.print("Enter Published Year: ");
        int publishedYear = sc.nextInt();
        sc.nextLine();
        Book newBook = new Book(title, author, publishedYear, 0);
        library.add(newBook);
        System.out.println("Book add successfully!");
    }
    static void showAllBooks() {
        if (library.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("All Books:");
            for (Book book : library) {
                System.out.println("ID: " + book.getId() + ",Title: " + book.getTitle() + ",Author: " + book.getAuthor() +
                        ",Year: " + book.getPublishedYear() + ",Status: " + (book.getStatus() == 0 ? "Available" : "Borrowed"));
            }
        }
    }
}