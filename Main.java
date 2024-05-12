import java.util.*;

public class Main {
    public static void main(String[] args) {
        Admin admin = new Admin();
        Member member = new Member(101, "John Doe", "john@example.com");
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Library Management System:");
            System.out.println("1. Admin");
            System.out.println("2. Member");
            System.out.println("3. Exit");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    admin.adminMenu();
                    break;
                case 2:
                    List<Book> books = admin.getBooks(); // Pass books to member menu
                    member.memberMenu(books);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
