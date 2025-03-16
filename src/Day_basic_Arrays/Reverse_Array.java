package Day_basic_Arrays;

import java.util.Arrays;

public class Reverse_Array {
    public static void rev(int[] arr){
        int i=0;
        int j = arr.length-1;
        while (i<=j){
            // swap
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    public static void main(String[] args) {
        int arr[] = {2,4,8,9,4,7,6};
        System.out.println("Original Array: " + Arrays.toString(arr));
        rev(arr);
        System.out.println("Reversed Array: " + Arrays.toString(arr));;
    }
}
