package day35_Hashing;

import java.util.HashSet;

public class HashSet_ClassRoom {
    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<Integer>();
        hs.add(1);
        hs.add(2);
        hs.add(3);
        System.out.println(hs); // Output: [1, 2, 3]
        System.out.println(hs.contains(2));
        hs.remove(2);
        System.out.println(hs.contains(2));
        System.out.println(hs); // Output: [1, 3]

        System.out.println(hs.size());
        hs.clear();
        System.out.println(hs.isEmpty()); // Output: true

    }
}
