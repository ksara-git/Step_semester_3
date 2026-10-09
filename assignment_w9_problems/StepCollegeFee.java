import java.util.Scanner;

class StepCollegeFee {

    double calculateFee(String type) {
        double fee = 0;

        if (type.equals("DAY_SCHOLAR")) {
            fee = 40000 + 12000;
        } else if (type.equals("HOSTELLER")) {
            fee = 40000 + 60000;
        } else if (type.equals("SCHOLAR")) {
            fee = 20000 + 12000;
        }

        return fee;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StepCollegeFee college = new StepCollegeFee();

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            double fee = college.calculateFee(type);

            System.out.printf("%s: %.2f%n", name, fee);
            total += fee;
        }

        System.out.printf("Total Collected: %.2f%n", total);
        sc.close();
    }
}