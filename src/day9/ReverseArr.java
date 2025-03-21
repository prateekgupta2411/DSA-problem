package day9;

import java.util.Arrays;

public class ReverseArr {

    public static void reverse(int arr[]) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {1, 4, 5, 8, 4, 8, 9};
        reverse(arr);
//        System.out.println(Arrays.toString(arr));
    }
}
