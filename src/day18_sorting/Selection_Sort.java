package day18_sorting;

import java.util.Arrays;

public class Selection_Sort {
    // TC = O(n^2);
    public static void selectionSort(int[] arr){
        int n = arr.length;
        for(int i=0;i<n-1;i++){
            int smallest =i;
            for(int j = i+1;j<n;j++){
                if(arr[smallest] > arr[j]){
                    smallest = j;
                }
            }
            int temp = arr[smallest];
            arr[smallest] =  arr[i];
            arr[i] = temp;
        }
    }
    public static void main(String[] args) {
        int[] arr= {1,8,3,7,2};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
