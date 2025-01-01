package dp_0_1_knapsack_pattern;

public class Knapsack01_Tabulation {
    public static int knapsack(int val[], int wt[], int W) {
        int n = val.length; // Number of items
        int[][] dp = new int[n + 1][W + 1];

        // Explicitly initialize dp[i][0] = 0 and dp[0][w] = 0
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0; // Zero weight capacity
        }
        for (int w = 0; w <= W; w++) {
            dp[0][w] = 0; // Zero items
        }

        // Build the dp table iteratively
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                if (wt[i - 1] <= w) {
                    // Include the item or skip it
                    dp[i][w] = Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]);
                } else {
                    // Exclude the item
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        return dp[n][W]; // Maximum value that can be achieved with the given weight
    }

    public static void main(String[] args) {
        int val[] = {5, 8, 9, 7, 6};
        int wt[] = {2, 4, 8, 6, 1};
        int W = 9;

        System.out.println(knapsack(val, wt, W)); // Output: 19
    }
}