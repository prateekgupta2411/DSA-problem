package day18_sorting;

import java.util.Arrays;

public class Bubble_Sort {
    // TC -> O(n^2)
    public static void bubbleSort(int[] arr){
        int n = arr.length;
        for(int i=0;i<n-1;i++){
            int swap = 0;
            for(int j =0;j<n-i-1;j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if(swap == 0){
                System.out.println("Array is already sorted");
                break;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
