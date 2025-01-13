package dp_0_1_knapsack_pattern;

public class Count_SubSet_Sum_Problem {
    public static int subsetSumCountMemo(int arr[], int sum, int n, Integer dp[][]) {
        if (sum == 0) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }
        // Check if the value has already been computed
        if (dp[n][sum] != null) {
            return dp[n][sum];
        }

        // If the current element is greater than the sum, we cannot include it
        if (arr[n - 1] > sum) {
            dp[n][sum] = subsetSumCountMemo(arr, sum, n - 1, dp);
        } else {
            // Either include or exclude the current element
            dp[n][sum] = subsetSumCountMemo(arr, sum - arr[n - 1], n - 1, dp) + subsetSumCountMemo(arr, sum, n - 1, dp);
        }

        return dp[n][sum];
    }
    public static void main(String[] args) {
        int arr[] = {2,3,5,6,8,10};
        int sum = 10;
        int n = arr.length;
        Integer dp[][] = new Integer[n+1][sum+1];

        Integer result = subsetSumCountMemo(arr, sum, arr.length, dp);
        System.out.println(result);
    }
}
