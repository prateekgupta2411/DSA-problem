package Day_basic_Arrays;

import java.util.HashMap;
import java.util.Map;

public class Find_Unique {
    private static int unique1(int[] arr){
        int unique = 0;
        for (int num : arr){
            unique = unique ^ num;
        }
        return unique;
    }
    private static int unique2(int[] arr){// use hashmap
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : arr){
            map.put(num, map.getOrDefault(num,0) +1);
        }
        // Finding the element with frequency 1
        for (int num : arr) {
            if (map.get(num) == 1) {
                return num;
            }
        }

        return -1;  // In case no unique element exists
    }


    public static void main(String[] args) {
        int arr[] = {2,3,3,2,4};
        System.out.println(unique1(arr));
    }
}
