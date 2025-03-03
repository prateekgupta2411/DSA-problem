package Sliding_Window_Technique;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Chocolate_Distribution_Problem {
    public static int Sliding(int arr[], int k){
        int n = arr.length;
        if(k>n){
            return -1;
        }
        Arrays.sort(arr);
        int res = Integer.MAX_VALUE;
        for(int i=0;i<n-k+1;i++){
            int minE = arr[i];
            int maxE = arr[i+k-1];
            res = Math.min(res,maxE - minE);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr ={3,4,1,9,56,7,9,12};
        int k = 5;
        System.out.println(Sliding(arr,k));
    }
}
