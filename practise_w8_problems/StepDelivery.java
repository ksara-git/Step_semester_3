import java.util.Scanner;

class StepDelivery {

    double calculateFee(String type, double weight,
                        double distance, double customs) {
        if (type.equals("STANDARD")) {
            return 5 + 0.50 * weight + 0.10 * distance;
        } else if (type.equals("EXPRESS")) {
            return 15 + 1.00 * weight + 0.20 * distance;
        } else {
            return 25 + 2.00 * weight + 0.50 * distance + customs;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StepDelivery d = new StepDelivery();

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();
            double customs = 0;

            if (type.equals("INTERNATIONAL")) {
                customs = sc.nextDouble();
            }

            double fee = d.calculateFee(type, weight, distance, customs);

            System.out.printf("%s: %.2f%n", type, fee);
            total = total + fee;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}