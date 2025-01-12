package prefixSum_Question;

public class Subarray_Sum_Equals_K_560 {
    public static int count(int nums[], int k){
        int n = nums.length;
        int count = 0;
        for(int i=0;i<n;i++){
            int sum =0;
            for(int j = i;j<n;j++){
                sum += nums[j];
                if(sum == k){
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5};
        int k = 3;
        System.out.println(count(nums,k));
    }
}
