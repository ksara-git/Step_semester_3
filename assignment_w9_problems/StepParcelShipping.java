import java.util.Scanner;

class StepParcelShipping {

    double calculateCharge(String type, double weight) {
        if (type.equals("STANDARD")) {
            return 40 + 10 * weight;
        } else if (type.equals("EXPRESS")) {
            return 80 + 15 * weight;
        } else {
            return 40 + 10 * weight + 50;
        }
    }

    double calculateInsurance(String type, double value) {
        if (type.equals("EXPRESS") || type.equals("FRAGILE")) {
            return value * 0.02;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StepParcelShipping parcel = new StepParcelShipping();

        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();

            double charge = parcel.calculateCharge(type, weight);
            double insurance = parcel.calculateInsurance(type, value);
            double total = charge + insurance;

            System.out.printf(
                "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                type, charge, insurance, total
            );

            grandTotal += total;
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);
        sc.close();
    }
}