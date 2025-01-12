package dp_0_1_knapsack_pattern;

public class Subset_Sum_Tabulation {
    public static boolean subsetSum(int arr[], int sum) {
        int n = arr.length;

        // Create a dp table where dp[i][j] is true if sum j is possible with first i elements
        boolean dp[][] = new boolean[n + 1][sum + 1];

//        // Base case: sum 0 is always possible with 0 elements
//        for (int i = 0; i <= n; i++) {
//            dp[i][0] = true;  // Sum of 0 is always possible (with empty subset)
//        }

        // Base case: sum 0 is always possible with 0 elements
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;  // Sum of 0 is always possible
        }

        // Base case: no sum > 0 is possible with 0 elements
        for (int j = 1; j <= sum; j++) {
            dp[0][j] = false;  // No sum possible with 0 elements except sum 0
        }

        // Fill the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                // If the current element is greater than the sum, don't include it
                if (arr[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // Check if sum j can be made either by including or excluding the element
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                }
            }
        }

        // The value in dp[n][sum] will be true if sum is possible with all n elements
        return dp[n][sum];
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 7, 8, 10};
        int sum = 11;

        boolean result = subsetSum(arr, sum);
        System.out.println("Subset with sum " + sum + " exists: " + result);
    }
}
