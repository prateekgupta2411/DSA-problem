package prefixSum_Question;

public class prefixSum_Basic {
    public static int[] preSum(int[] arr){
        int n = arr.length;
//        int ans[] = new int[n];
//        ans[0] = arr[0];
        for(int i=1;i<n;i++){
            arr[i] = arr[i-1] + arr[i];
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+ " ");
        }
        return arr;
    }
    public static void main(String[] args) {
        int arr[] = {2,4,8,7,9};
        preSum(arr); // 2, 6, 14, 21, 30
    }
}
