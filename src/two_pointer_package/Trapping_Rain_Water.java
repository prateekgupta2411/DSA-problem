package two_pointer_package;

public class Trapping_Rain_Water {
    public static int trappingRainWater(int[] height) {
        int n = height.length;
        //Calculate left max boundary
        int leftMax[] = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        //Calculate Right max boundary
        int rightMax[] = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
//        System.out.println(trappingRainWater(height));
        System.out.println(optimalSolution(height));
    }
    public static int optimalSolution(int[] height){
        int n = height.length;
        int l =0;
        int r = height.length-1;
        int leftMax = 0;
        int rightMax = 0;
        int ans  =0;
        while (l<r){
            if(height[l] > leftMax){
                leftMax = Math.max(leftMax,height[l]);
            }
            if(height[r] > rightMax){
                rightMax = Math.max(rightMax,height[r]);
            }
            if(leftMax < rightMax){
                ans += leftMax - height[l];
                l++;
            }
            else {
                ans += rightMax-height[r];
                r--;
            }
        }
        return ans;
    }
}
