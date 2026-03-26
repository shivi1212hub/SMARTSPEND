import java.util.*;

class ExpenseService {
    ArrayList<Expense> list = new ArrayList<>();

    void add(Expense e) {
        list.add(e);
        System.out.println("Added");
    }

    void view() {
        for (Expense e : list) {
            System.out.println(e);
        }
    }
}