package prefixSum_Question;

public class SuffixSum_Basic {
    public static int[] suffSum(int arr[]){
        int n = arr.length;
        int[] suff = new int[n];
        suff[n-1] = arr[n-1];
        for(int i=n-2;i>=0;i--){
            suff[i] = suff[i+1] + arr[i];
        }
        for(int i=0;i<suff.length;i++){
            System.out.print(suff[i] + " ");
        }
        return suff;
    }
    public static void main(String[] args) {
        int arr[] = {2,5,6,1,3};
        suffSum(arr);
    }
}
