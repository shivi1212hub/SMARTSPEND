import java.io.*;
import java.util.*;

class FileHandler {

    private static final String FILE = "expenses.txt";

    public static void save(ArrayList<Expense> list) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE))) {

            for (Expense e : list) {
                bw.write(e.id + "," + e.amount + "," + e.category + "," + e.date);
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error saving file");
        }
    }

    public static ArrayList<Expense> load() {
        ArrayList<Expense> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {

            String line;
            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                double amount = Double.parseDouble(data[1]);
                String category = data[2];
                String date = data[3];

                list.add(new Expense(id, amount, category, date));
            }

        } catch (Exception e) {
            System.out.println("No previous data");
        }

        return list;
    }

    public static void export(ArrayList<Expense> list) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("report.txt"))) {

            double total = 0;

            for (Expense e : list) {
                bw.write(e.toString());
                bw.newLine();
                total += e.amount;
            }

            bw.write("Total: " + total);
            bw.newLine();

            HashMap<String, Double> map = new HashMap<>();

            for (Expense e : list) {
                map.put(e.category,
                        map.getOrDefault(e.category, 0.0) + e.amount);
            }

            for (String key : map.keySet()) {
                bw.write(key + " : " + map.get(key));
                bw.newLine();
            }

        } catch (Exception e) {
            System.out.println("Error exporting");
        }
    }
}