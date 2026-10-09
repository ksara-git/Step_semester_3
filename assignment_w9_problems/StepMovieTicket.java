import java.util.Scanner;

class StepMovieTicket {
    private static final double FEE = 20.0;

    double calculateAmount(String seat, int count) {
        double price = 0;

        if (seat.equals("REGULAR")) {
            price = 150;
        } else if (seat.equals("PREMIUM")) {
            price = 250;
        } else if (seat.equals("RECLINER")) {
            price = 400;
        }

        return (price + FEE) * count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StepMovieTicket ticket = new StepMovieTicket();

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String seat = sc.next();
            int count = sc.nextInt();

            double amount = ticket.calculateAmount(seat, count);

            System.out.printf("%s: %.2f%n", seat, amount);
            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}