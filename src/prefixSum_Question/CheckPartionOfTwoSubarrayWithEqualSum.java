package prefixSum_Question;

public class CheckPartionOfTwoSubarrayWithEqualSum {
    public static int findSum(int arr[]){
        int totalSum = 0;
        for(int i=0;i<arr.length;i++){
            totalSum += arr[i];
        }
        return totalSum;
    }
    public static boolean partitionCheck(int arr[]){
        int n = arr.length;
        int totalSum =findSum(arr);
        int prefSum = 0;
        for(int i=0;i<n;i++){
            prefSum = arr[i] + prefSum;
            int suffSum = totalSum - prefSum;
            if(prefSum == suffSum){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int arr[] = {1,3,2,4,5};
        System.out.println(partitionCheck(arr));
    }

}
