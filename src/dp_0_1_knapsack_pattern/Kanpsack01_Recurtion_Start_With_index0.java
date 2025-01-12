package dp_0_1_knapsack_pattern;

public class Kanpsack01_Recurtion_Start_With_index0 {
    public static int knapsack(int wt[], int val[], int W, int index){
        // Base Condition
        if(index == wt.length || W == 0){
            return 0;
        }
        // recursive Function
        if(wt[index] <= W){
            int ansMeAddKaruga = val[index] + knapsack(wt,val,W-wt[index],index+1);
            int ansMeaddNhiKaruga = knapsack(wt,val,W,index+1);
           return Math.max(ansMeAddKaruga, ansMeaddNhiKaruga);
        }
        else {
            return knapsack(wt,val,W,index+1);
        }
    }
    public static void main(String[] args) {
        int wt[] = {1,3,4,5};
        int val[] = {1,4,5,7};
        int W = 7;
        System.out.println(knapsack(wt,val,W,0));
    }
}
