package dp_0_1_knapsack_pattern;

public class EqualSum_Partition_Memo {
    public static Boolean EqualPartition(int arr[], int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + arr[i];
        }
        if (sum % 2 != 0) {
            return false;
        } else {
            // Create a memoization table for subsetSum
            Boolean[][] memo = new Boolean[n + 1][sum / 2 + 1];
            return subsetSum(arr, sum / 2, n, memo);
        }
    }

    // Use memoization to store the results of subproblems
    public static boolean subsetSum(int arr[], int sum, int n, Boolean[][] memo) {
        // Base case: sum 0 is always possible with 0 elements
        if (sum == 0) {
            return true;
        }

        // Base case: no sum > 0 is possible with 0 elements
        if (n == 0) {
            return false;
        }

        // If this subproblem has already been solved, return the stored result
        if (memo[n][sum] != null) {
            return memo[n][sum];
        }

        // If the current element is greater than the sum, don't include it
        if (arr[n - 1] > sum) {
            // Store the result of excluding the element in the memoization table
            memo[n][sum] = subsetSum(arr, sum, n - 1, memo);
        } else {
            // Check if sum can be made either by including or excluding the element
            memo[n][sum] = subsetSum(arr, sum, n - 1, memo) || subsetSum(arr, sum - arr[n - 1], n - 1, memo);
        }

        // Return the result stored in the memoization table
        return memo[n][sum];
    }

    public static void main(String[] args) {
        int arr[] = {1, 5, 11, 5};

        boolean result = EqualPartition(arr, arr.length);
        System.out.println(result);
    }
}
