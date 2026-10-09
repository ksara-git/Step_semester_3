import java.util.Scanner;

class StepCityCab {

    double calculateFare(String cab, double km, String time) {
        double rate = 0;

        if (cab.equals("MINI")) {
            rate = 10;
        } else if (cab.equals("SEDAN")) {
            rate = 14;
        } else if (cab.equals("SUV")) {
            rate = 18;
        }

        double fare = km * rate;

        if (fare < 100) {
            fare = 100;
        }

        if (time.equals("NIGHT")) {
            fare = fare + fare * 0.20;
        }

        return fare;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StepCityCab cab = new StepCityCab();

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            if (type.equals("MINI") && time.equals("NIGHT")) {
                System.out.println("MINI: night service not available");
            } else {
                double fare = cab.calculateFare(type, km, time);

                System.out.printf("%s: %.2f%n", type, fare);
                total += fare;
            }
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}