
public class PairSumSortedStep {

    public static void pairSum(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == target) {
                System.out.println("(" + arr[left] + ", " + arr[right] + ")");
                return;
            }
            else if (sum < target)
                left++;
            else
                right--;
        }

        System.out.println("Not Found");
    }

    public static void main(String[] args) {
        int[] arr = {-4, -1, 0, 3, 5, 9};

        pairSum(arr, 4);
    }
}
