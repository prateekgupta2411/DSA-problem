package dp_0_1_knapsack_pattern;

public class Subset_Sum_Problem {
    public static boolean recur(int arr[], int sum, int i) {
        // Base cases
        if (sum == 0) {
            return true; // Subset found
        }
        if (i >= arr.length || sum < 0) {
            return false; // No subset possible
        }

        // Recursive calls: pick or not pick the current element
        boolean pick = recur(arr, sum - arr[i], i + 1);
        boolean notPick = recur(arr, sum, i + 1);

        // Return true if any of the two options is true
        return pick || notPick;
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 7, 8, 10};
        int sum = 50;

        boolean result = recur(arr, sum, 0);
        System.out.println("Subset with sum " + sum + " exists: " + result);
    }
}
