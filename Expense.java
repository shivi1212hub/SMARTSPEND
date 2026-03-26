class Expense {
    int id;
    double amount;
    String category;
    String date;

    Expense(int id, double amount, String category, String date) {
        this.id = id;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    public String toString() {
        return id + " " + amount + " " + category + " " + date;
    }
}