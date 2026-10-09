import java.util.Scanner;

class StepTransport {

    double calculateFare(String type, double distance, double factor) {
        if (type.equals("BUS")) {
            double fare = 2 + 0.10 * distance;

            if (fare > 10) {
                fare = 10;
            }

            return fare;
        } else if (type.equals("TRAIN")) {
            return 3 + 0.15 * distance;
        } else {
            return (1.50 + 0.20 * distance) * factor;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StepTransport t = new StepTransport();

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();
            double factor = 1.0;

            if (type.equals("METRO")) {
                factor = sc.nextDouble();
            }

            double fare = t.calculateFare(type, distance, factor);

            System.out.printf("%s: %.2f%n", type, fare);
            total = total + fare;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}