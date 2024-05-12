import java.util.*;

public class Member {
    private int id;
    private String name;
    private String email;
    private List<Book> issuedBooks;
    private Scanner sc;

    public Member(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.issuedBooks = new ArrayList<>();
        this.sc = new Scanner(System.in);
    }

    public void memberMenu(List<Book> books) {
        while (true) {
            System.out.println("Member Menu:");
            System.out.println("1. Search Book");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    searchBook(books);
                    break;
                case 2:
                    issueBook(books);
                    break;
                case 3:
                    returnBook(books);
                    break;
                case 4:
                    System.out.println("Exiting Member Menu...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void searchBook(List<Book> books) {
        System.out.println("Enter Book Name, ID, or Author to search:");
        String input = sc.nextLine();
        boolean found = false;

        for (Book book : books) {
            if (String.valueOf(book.getId()).equals(input) ||
                    book.getName().equalsIgnoreCase(input) ||
                    book.getAuthor().equalsIgnoreCase(input)) {
                System.out.println("Book found: " + book);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Book not found.");
        }
    }

    private void issueBook(List<Book> books) {
        System.out.println("Enter Book Name, ID, or Author to issue:");
        String input = sc.nextLine();
        boolean found = false;

        for (Book book : books) {
            if (String.valueOf(book.getId()).equals(input) ||
                    book.getName().equalsIgnoreCase(input) ||
                    book.getAuthor().equalsIgnoreCase(input)) {
                issuedBooks.add(book);
                System.out.println("Book issued: " + book);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Book not found.");
        }
    }

    private void returnBook(List<Book> books) {
        System.out.println("Enter Book Name, ID, or Author to return:");
        String input = sc.nextLine();
        boolean found = false;

        for (Book book : issuedBooks) {
            if (String.valueOf(book.getId()).equals(input) ||
                    book.getName().equalsIgnoreCase(input) ||
                    book.getAuthor().equalsIgnoreCase(input)) {
                found = true;
                // Calculate fines based on issue date (pseudo code)
                // Date currentDate = new Date();
                // long daysBetween = Days.between(book.getIssueDate(), currentDate);
                // double fine = daysBetween > 3 ? (daysBetween - 3) * 5 : 0;
                // System.out.println("Fine for late return: $" + fine);

                // Remove the book from issued books
                issuedBooks.remove(book);
                System.out.println("Book returned successfully.");
                break;
            }
        }

        if (!found) {
            System.out.println("Book not found in your issued books.");
        }

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}