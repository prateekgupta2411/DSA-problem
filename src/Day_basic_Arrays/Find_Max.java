package Day_basic_Arrays;

public class Find_Max {
    public static int max(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
    public static void secondMax(int[] arr){
        int max = Integer.MIN_VALUE;
        int sMax = Integer.MIN_VALUE;
        int n = arr.length;
        for(int i=0;i<n;i++){
            if(arr[i] > max){
                sMax = max;
                max = arr[i];
            }
            if(arr[i] > sMax && arr[i] <max) {
                sMax = arr[i];
            }
        }
        System.out.println(max);
        System.out.println(sMax);
    }
    public static void main(String[] args) {
        int[] arr = {4,8,2,9,12,14,18,0};
        secondMax(arr);
        System.out.println(max(arr));
    }
}
