package Sliding_Window_Technique;

public class Max_Sum_Subarray_Of_Size_K {
    public static int BruteForce(int[] arr, int k){
        int n = arr.length;
        int maxSum = 0;
        for(int i=0;i< n-k+1;i++){
            int sum = 0;
            for(int j=i;j<i+k;j++){
                sum += arr[j];
            }
            maxSum = Math.max(sum,maxSum);
        }
        return maxSum;
    }

    public static int SlidingWindow(int[] arr, int k){
        int n = arr.length;
        int maxSum = 0;
        int sum = 0;
        // find Sum of k elements
        int index = 0;
        while (index < n && index < k){
            sum = sum + arr[index];
            index++;
        }
        maxSum = sum;
        for (int i = 1;i<n-k+1;i++){
            int prevElement = arr[i-1];
            int nextElement = arr[i+k-1];
            sum = sum - prevElement + nextElement;
            maxSum = Math.max(sum,maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {100,200,300,400};
        int k = 2;
        System.out.println(BruteForce(arr,k));
        System.out.println(SlidingWindow(arr,k));
    }
}
