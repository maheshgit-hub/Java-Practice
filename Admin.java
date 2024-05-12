import java.util.*;

public class Admin {
    private List<Book> books;
    private List<Member> members;
    private Scanner sc;

    public Admin() {
        books = new ArrayList<>();
        members = new ArrayList<>();
        sc = new Scanner(System.in);
    }

    public void adminMenu() {
        while (true) {
            System.out.println("Admin Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Show All Books");
            System.out.println("4. Search Book");
            System.out.println("5. Update Book");
            System.out.println("6. Add Member");
            System.out.println("7. Remove Member");
            System.out.println("8. Exit");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    showAllBooks();
                    break;
                case 4:
                    searchBook();
                    break;
                case 5:
                    updateBook();
                    break;
                case 6:
                    addMember();
                    break;
                case 7:
                    removeMember();
                    break;
                case 8:
                    System.out.println("Exiting Admin Menu...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addBook() {
        System.out.println("Enter Book ID:");
        int id = sc.nextInt();
        sc.nextLine(); // Consume newline
        System.out.println("Enter Book Name:");
        String name = sc.nextLine();
        System.out.println("Enter Book Author:");
        String author = sc.nextLine();
        System.out.println("Enter Book Quantity:");
        int quantity = sc.nextInt();
        System.out.println("Enter Book Price:");
        double price = sc.nextDouble();

        Book newBook = new Book(id, name, author, quantity, price);

        // Check if the book already exists
        boolean bookExists = false;
        for (Book book : books) {
            if (book.getId() == id || book.getName().equalsIgnoreCase(name)) {
                bookExists = true;
                System.out.println("Book already exists.");
                System.out.println("Do you want to update quantity? (Y/N)");
                String updateChoice = sc.next();
                if (updateChoice.equalsIgnoreCase("Y")) {
                    book.setQuantity(book.getQuantity() + quantity);
                    System.out.println("Quantity updated successfully.");
                }
                break;
            }
        }
        if (!bookExists) {
            books.add(newBook);
            System.out.println("Book added successfully.");
        }
    }

    private void removeBook() {
        System.out.println("Enter Book ID or Name to remove:");
        String input = sc.nextLine();
        boolean removed = false;

        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (String.valueOf(book.getId()).equals(input) || book.getName().equalsIgnoreCase(input)) {
                iterator.remove();
                removed = true;
                break;
            }
        }

        if (removed) {
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found.");
        }

    }

    private void showAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            System.out.println("List of all books:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    private void searchBook() {
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

    private void updateBook() {
        System.out.println("Enter Book Name or ID to update:");
        String input = sc.nextLine();
        boolean updated = false;

        for (Book book : books) {
            if (String.valueOf(book.getId()).equals(input) || book.getName().equalsIgnoreCase(input)) {
                System.out.println("Enter new price:");
                double newPrice = sc.nextDouble();
                book.setPrice(newPrice);
                System.out.println("Enter new quantity:");
                int newQuantity = sc.nextInt();
                book.setQuantity(newQuantity);
                updated = true;
                System.out.println("Book updated successfully.");
                break;
            }
        }

        if (!updated) {
            System.out.println("Book not found.");
        }
    }

    private void addMember() {
        System.out.println("Enter Member ID:");
        int id = sc.nextInt();
        sc.nextLine(); // Consume newline
        System.out.println("Enter Member Name:");
        String name = sc.nextLine();
        System.out.println("Enter Member Email:");
        String email = sc.nextLine();

        Member newMember = new Member(id, name, email);
        members.add(newMember);
        System.out.println("Member added successfully.");
    }

    private void removeMember() {
        System.out.println("Enter Member ID or Name to remove:");
        String input = sc.nextLine();
        boolean removed = false;

        Iterator<Member> iterator = members.iterator();
        while (iterator.hasNext()) {
            Member member = iterator.next();
            if (String.valueOf(member.getId()).equals(input) || member.getName().equalsIgnoreCase(input)) {
                iterator.remove();
                removed = true;
                break;
            }
        }

        if (removed) {
            System.out.println("Member removed successfully.");
        } else {
            System.out.println("Member not found.");
        }
    }

    public List<Book> getBooks() {
        return books;
    }
}
