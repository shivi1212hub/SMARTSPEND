import java.util.*;

public class Main {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            ExpenseService service = new ExpenseService();

            while (true) {
                System.out.println("1 Add 2 View 3 Exit");

                int ch = sc.nextInt();

                switch (ch) {
                    case 1:
                        System.out.print("ID: ");
                        int id = sc.nextInt();

                        System.out.print("Amount: ");
                        double amt = sc.nextDouble();

                        sc.nextLine(); // fix input issue

                        System.out.print("Category: ");
                        String cat = sc.nextLine();

                        System.out.print("Date: ");
                        String date = sc.nextLine();

                        service.add(new Expense(id, amt, cat, date));
                        break;
                    case 2:
                        service.view();
                        break;
                    default:
                        break;
                }
                if (ch != 1 && ch != 2) {
                    break;
                }
            }
        }
    }
}