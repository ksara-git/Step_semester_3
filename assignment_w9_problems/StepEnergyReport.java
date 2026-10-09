import java.util.Scanner;

class StepEnergyReport {

    double getPower(String appliance) {
        if (appliance.equals("FRIDGE")) {
            return 150;
        } else if (appliance.equals("AC")) {
            return 1500;
        } else if (appliance.equals("TV")) {
            return 100;
        } else {
            return 500;
        }
    }

    boolean supportsSaver(String appliance) {
        return appliance.equals("AC") || appliance.equals("WASHER");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StepEnergyReport report = new StepEnergyReport();

        int n = sc.nextInt();
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String appliance = sc.next();
            double hours = sc.nextDouble();

            boolean saver = false;

            if (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                saver = line.equals("SAVER");
            }

            if (saver && !report.supportsSaver(appliance)) {
                System.out.println(appliance + ": saver mode not supported");
                continue;
            }

            double units = report.getPower(appliance) * hours / 1000;

            if (saver) {
                units = units * 0.75;
            }

            double cost = units * 8;

            System.out.printf(
                "%s: Units=%.2f Cost=%.2f%n",
                appliance, units, cost
            );

            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}