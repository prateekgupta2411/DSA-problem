package dp_questions_fibonacci_pattern;

import java.util.Arrays;

public class Climbing_Stairs {
    // memoization O(n) but use recursion O(2^n)
    public static int totalWays(int n,int dp[]){
        if(n==0){
            return 1;
        }
        if(n < 0){
            return 0;
        }
        if(dp[n] != -1){ //already calculated
            return dp[n];
        }
        dp[n] =  totalWays(n-1,dp) + totalWays(n-2,dp);
        return dp[n];
    }
    public static void main(String[] args) {
        int n = 5; // n= 3 -> 3 and n = 4 -> 5
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(totalWays(n,dp));
    }
}
