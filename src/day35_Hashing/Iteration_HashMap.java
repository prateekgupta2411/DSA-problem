package day35_Hashing;

import java.util.HashMap;
import java.util.Set;

public class Iteration_HashMap {
    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        map.put("India",140);
        map.put("USA",338);
        map.put("China",1439);
        map.put("Russia",146);
        map.put("Japan",126);

        //Iterator
        Set<String> keys = map.keySet();
        System.out.println(keys);

        for(String k : keys){
            System.out.println("keys=" + k + ", value=" + map.get(k));

        }
    }
}
