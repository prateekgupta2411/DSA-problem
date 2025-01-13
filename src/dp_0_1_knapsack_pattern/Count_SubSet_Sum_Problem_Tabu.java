package dp_0_1_knapsack_pattern;

public class Count_SubSet_Sum_Problem_Tabu {
    public static int subsetSum(int arr[], int sum) {
        int n = arr.length;

        // Create a dp table where dp[i][j] stores the count of subsets with sum j using the first i elements
        int dp[][] = new int[n + 1][sum + 1];

        // Base case: sum 0 is always possible with any number of elements (empty subset)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1; // There's exactly one subset (the empty subset) with sum 0
        }

        // Base case: No sum > 0 is possible with 0 elements
        for (int j = 1; j <= sum; j++) {
            dp[0][j] = 0; // No subsets possible
        }

        // Fill the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                // If the current element is greater than the sum, exclude it
                if (arr[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // Count subsets by including or excluding the current element
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
                }
            }
        }

        // The value in dp[n][sum] will be the count of subsets with sum equal to 'sum'
        return dp[n][sum];
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 7, 8, 10};
        int sum = 11;

        int result = subsetSum(arr, sum);
        System.out.println("Count of subsets with sum " + sum + ": " + result);
    }
}
