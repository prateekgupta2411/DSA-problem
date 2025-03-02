package Sliding_Window_Technique;

import java.util.Arrays;

public class First_Negative_Num_In_Every_Window_Size_K {
    public static int[] BruteForce(int arr[], int k) {
        int n = arr.length;
        int[] ans = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            ans[i] = 0;
            for (int j = i; j < i + k; j++) {
                if (arr[j] < 0) {
                    ans[i] = arr[j];
                    break;
                }
            }
        }
        return ans;
    }
//    public static int[] SlidingWindow(int arr[], int k){
//
//    }

    public static void main(String[] args) {
        int[] arr = {12, -1, -7, 8, -15, 30, 16};
        int k = 3;

        // Printing the result properly
        System.out.println(Arrays.toString(BruteForce(arr, k)));
    }
}
