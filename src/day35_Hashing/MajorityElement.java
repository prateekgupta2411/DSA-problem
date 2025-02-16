package day35_Hashing;

import java.util.HashMap;

public class MajorityElement {
    public static void findMajorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
            if(map.get(num) > nums.length / 3){
                System.out.println(num);
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,3,2,5,1,3,1,5,1};
        findMajorityElement(nums);
    }
}
