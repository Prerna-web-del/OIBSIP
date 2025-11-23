import java.util.*;

public class Book {
    String title;
    boolean isIssued = false;

    Book(String title) {
        this.title = title;}
    }
    class DigitalLibrary {
    //... rest of code ...
    static ArrayList<Book> books = new ArrayList<>();

    public static void main(String[] args) {
        books.add(new Book("Java Programming"));
        books.add(new Book("Data Structures"));
        books.add(new Book("DBMS"));
        
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Digital Library System ---");
            System.out.println("1. View Books");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();  

            switch (choice) {
                case 1: 
                    viewBooks();
                    break;

                case 2:
                    System.out.print("Enter book name to issue: ");
                    issueBook(sc.nextLine());
                    break;

                case 3:
                    System.out.print("Enter book name to return: ");
                    returnBook(sc.nextLine());
                    break;

                case 4:
                    System.out.println("Thank you for using the library!");
                    return;

                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    static void viewBooks() {
        System.out.println("\nAvailable Books:");
        for (Book b : books) {
            System.out.println("- " + b.title + (b.isIssued ? " (Issued)" : ""));
        }
    }

    static void issueBook(String name) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(name)) {
                if (!b.isIssued) {
                    b.isIssued = true;
                    System.out.println("Book issued successfully!");
                } else {
                    System.out.println("Book is already issued.");
                }
                return;
            }
        }
        System.out.println("Book not found!");
    }

    static void returnBook(String name) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(name)) {
                if (b.isIssued) {
                    b.isIssued = false;
                    System.out.println("Book returned successfully!");
                } else {
                    System.out.println("This book was not issued.");
                }
                return;
            }
        }
        System.out.println("Book not found!");
    }
}
