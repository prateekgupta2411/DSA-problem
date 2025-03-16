package day18_sorting;

import java.util.Arrays;

public class Insertion_Sort {
    // O(n^2)
    public static void insertion_Sort(int[] arr){
        int n =arr.length;
        for(int i=1;i<n;i++){
            int current = arr[i];
            int j = i-1;
            while (j>=0 && current < arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            // placement
            arr[j+1] = current;
        }
    }
    public static void main(String[] args) {
        int[] arr = {7,8,3,1,2};
        insertion_Sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
