package day10;

public class TrappingRainWater {
    public static int trappingRainWater(int[] height) {
        int n = height.length;
        //Calculate left max boundary - array
        int leftMax[] = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        //Calculate Right max boundary - array
        int rightMax[] = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        int ans = 0;
        //loop
        for (int i = 0; i < n; i++) {
            //waterLevel = min(leftmax bound, rigthmax bound)
            int waterLevel = Math.min(leftMax[i], rightMax[i]);

            //Trapped water = waterLevel - height[i]
            ans += waterLevel - height[i];

        }
        return ans;
    }
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int ans = trappingRainWater(height);
        System.out.println(ans);
    }
}
