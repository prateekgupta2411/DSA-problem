package prefixSum_Question;

public class QuerySum_LC_303 {
    public static int[] computePrefixSum(int[] arr) {
        int n = arr.length;
        int ans[] = new int[n+1];
        for (int i = 1; i <= n; i++) {
            ans[i]  = ans[i-1] +  arr[i - 1];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 4, 1, 3, 6};
       int[] prefSum =  computePrefixSum(arr);
        int start = 1;
        int end = 3;
        int sum = prefSum[end] - prefSum[start-1];
        System.out.println(sum);
    }
}
