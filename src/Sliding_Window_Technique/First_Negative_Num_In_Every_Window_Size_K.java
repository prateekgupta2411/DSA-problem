package Sliding_Window_Technique;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
// Important question
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
    public static int[] SlidingWindow(int arr[], int k){
        int n = arr.length; // 7
        Queue<Integer> q = new LinkedList<>();
        // calculate for first window
        int index = 0;
        while(index < k){
            if(arr[index] < 0){
                q.offer(arr[index]);
            }
            index++;
        }
        int res[] = new int[n-k+1];
        res[0] = (q.isEmpty()) ? 0 : q.peek();// agr queue khali h to 0 daal doo barna top ki value daal do.
        for(int i=1;i<n-k+1;i++){
            // remove
            if(arr[i-1] < 0){
                q.poll(); // remove
            }
            // add
            if(arr[i+k-1] < 0){
                q.offer(arr[i+k-1]);
            }
            res[i] = (q.isEmpty()) ? 0 : q.peek();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {12, -1, -7, 8, -15, 30, 16};
        int k = 3;

        // Printing the result properly
        System.out.println(Arrays.toString(BruteForce(arr, k)));
        System.out.println(Arrays.toString(SlidingWindow(arr, k)));
    }
}
