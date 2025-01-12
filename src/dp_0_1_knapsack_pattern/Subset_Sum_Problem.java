package dp_0_1_knapsack_pattern;

public class Subset_Sum_Problem {
    public static boolean subsetSumMemo(int arr[], int sum, int n, Boolean dp[][]) {
        if (sum == 0) {
            return true;
        }
        if (n == 0) {
            return false;
        }
        // Check if the value has already been computed
        if (dp[n][sum] != null) {
            return dp[n][sum];
        }

        // If the current element is greater than the sum, we cannot include it
        if (arr[n - 1] > sum) {
            dp[n][sum] = subsetSumMemo(arr, sum, n - 1, dp);
        } else {
            // Either include or exclude the current element
            dp[n][sum] = subsetSumMemo(arr, sum - arr[n - 1], n - 1, dp) || subsetSumMemo(arr, sum, n - 1, dp);
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 7, 8, 10};
        int sum = 11;
        int n = arr.length;
        Boolean dp[][] = new Boolean[n+1][sum+1];

        boolean result = subsetSumMemo(arr, sum, arr.length, dp);
        System.out.println(result);
    }
}
