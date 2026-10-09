import java.util.Scanner;
import java.time.LocalDate;

class StepLibrary {

    LocalDate calculateDueDate(String type, LocalDate date) {
        if (type.equals("BOOK")) {
            return date.plusDays(14);
        } else if (type.equals("DVD")) {
            return date.plusDays(7);
        } else {
            return date.plusDays(3);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StepLibrary lib = new StepLibrary();

        int n = sc.nextInt();
        LocalDate date = LocalDate.of(2023, 10, 26);

        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.nextLine().trim();

            if (title.startsWith("\"") && title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);
            }

            LocalDate dueDate = lib.calculateDueDate(type, date);

            System.out.println(title + ": " + dueDate);
        }

        sc.close();
    }
}