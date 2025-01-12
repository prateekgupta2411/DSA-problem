package dp_0_1_knapsack_pattern;

import java.util.Arrays;

public class Knapsack01_Memoization {
    public static int knapsack(int val[], int wt[], int W, int n, int dp[][]) {
        // base case
        if (n == 0 || W == 0) {
            return 0;
        }
        // Check if the value has already been computed
        if (dp[n][W] != -1) {
            return dp[n][W];
        }
        // recursive function
        if (wt[n - 1] <= W) {
            // include it
            int ans1 = val[n - 1] + knapsack(val, wt, W - wt[n - 1], n - 1, dp);
            // not included
            int ans2 = knapsack(val, wt, W, n - 1, dp);
            return dp[n][W] = Math.max(ans1, ans2);
        } else {
            // if weight is greater than W, we cannot include this item
            return dp[n][W] = knapsack(val, wt, W, n - 1, dp);
        }
    }

    public static void main(String[] args) {
        int val[] = {5, 8, 9, 7, 6};
        int wt[] = {2, 4, 8, 6, 1};
        int W = 9;
        // max profit -> 6+8+5 -> 19

        // 2d array isliye create kiya he because yhaa W and n dono change ho rhe he
        // agr single change ho rha he to 1d array 2 change 2d array 3 change 3d array soOn
        int dp[][] = new int[val.length + 1][W + 1];

//        // Initialize dp table with -1
//        for (int i = 0; i <= val.length; i++) {
//            for (int j = 0; j <= W; j++) {
//                dp[i][j] = -1;
//            }
//        }

        //Simple ways
        // Initialize dp table with -1 using Arrays.fill()
        for (int i = 0; i <= val.length; i++) {
            Arrays.fill(dp[i], -1);  // Fill each row with -1
        }
        System.out.println(knapsack(val, wt, W, val.length, dp));
    }
}
