package day35_Hashing;

import java.util.HashMap;

public class HashMap_ClassRoom {
    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("India", 250);
        map.put("USA", 327);
        map.put("China", 1439);
        System.out.println(map);

        System.out.println(map.get("India"));

        System.out.println(map.containsKey("Japan")); // false
        System.out.println(map.containsValue(250)); // true
        System.out.println(map.isEmpty()); // false
        map.remove("China");
        System.out.println(map);
        System.out.println(map.size());
        map.clear();
        System.out.println(map.isEmpty()); // true
    }
}
