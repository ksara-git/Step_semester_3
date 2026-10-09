import java.util.Scanner;

class StepPaymentSystem {

    double calculateAmount(String type, double amount) {
        if (type.equals("CARD")) {
            return amount + amount * 0.02;
        } else if (type.equals("WALLET")) {
            return amount + amount * 0.01;
        } else {
            return amount;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StepPaymentSystem p = new StepPaymentSystem();

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            double result = p.calculateAmount(type, amount);
            System.out.printf("%s: %.2f%n", type, result);

            total = total + result;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}