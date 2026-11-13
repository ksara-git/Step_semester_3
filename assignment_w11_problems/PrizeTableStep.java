
import java.util.Arrays;

public class PrizeTableStep {

    public static int prizeTable(int[] marks) {
        int swaps = 0;

        for (int i = 0; i < marks.length - 1; i++) {
            int max = i;

            for (int j = i + 1; j < marks.length; j++) {
                if (marks[j] > marks[max])
                    max = j;
            }

            if (max != i) {
                int temp = marks[i];
                marks[i] = marks[max];
                marks[max] = temp;

                swaps++;
            }
        }

        return swaps;
    }

    public static void main(String[] args) {
        int[] a = {45, 90, 60, 75};
        int[] b = {80, 70, 60};

        System.out.println(Arrays.toString(a));
        System.out.println("Swaps = " + prizeTable(a));

        System.out.println(Arrays.toString(b));
        System.out.println("Swaps = " + prizeTable(b));
    }
}
