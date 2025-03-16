package day18_sorting;

import java.util.Arrays;

public class MergeSort {
    public static void divide(int arr[], int si, int ei){
        // Base case
        if(si >= ei){
            return;
        }
        // Split the array into halves
        int mid = si + (ei - si) / 2;
        divide(arr, si, mid); // Left half
        divide(arr, mid + 1, ei); // Right half
        conquer(arr, si, mid, ei);
    }
    public static void conquer(int arr[], int si, int mid, int ei){
        int temp[] = new int[ei - si + 1];
        int i = si; // Iterator for left part
        int j = mid + 1; // Iterator for right part
        int k = 0; // Iterator for temp array

        // Merge both parts into temp[]
        while (i <= mid && j <= ei) {
            if(arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        // Copy remaining elements from the left part
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        // Copy remaining elements from the right part
        while (j <= ei) {
            temp[k++] = arr[j++];
        }
        // Copy sorted elements back into the original array
        for(k = 0, i = si; i <= ei; k++, i++) {
            arr[i] = temp[k];
        }
    }
    public static void main(String[] args) {
        int arr[] = {6, 3, 9, 5, 2, 8,-2};
        divide(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
 }
