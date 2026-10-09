import java.util.Scanner;

class StepExamGrader {

    double calculateScore(String type, String correct,
                          String answer, double points) {
        if (type.equals("MCQ") || type.equals("TF")) {
            if (correct.equals(answer)) {
                return points;
            }
            return 0;
        }

        String[] keywords = correct.split(",");
        int count = 0;

        for (int i = 0; i < keywords.length; i++) {
            if (answer.toLowerCase().contains(
                    keywords[i].trim().toLowerCase())) {
                count++;
            }
        }

        if (count >= 2) {
            return points * 0.75;
        } else if (count == 1) {
            return points * 0.50;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StepExamGrader grader = new StepExamGrader();

        int n = sc.nextInt();
        sc.nextLine();

        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String question = sc.next();

            String correct = sc.next();
            String answer = sc.next();
            double points = sc.nextDouble();

            double score = grader.calculateScore(
                    type, correct, answer, points);

            System.out.printf("%s: %.2f%n", type, score);
            total = total + score;
        }

        System.out.printf("Total Score: %.2f%n", total);
        sc.close();
    }
}