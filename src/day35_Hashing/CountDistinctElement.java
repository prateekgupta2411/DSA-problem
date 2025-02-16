package day35_Hashing;

import java.util.HashSet;

public class CountDistinctElement {
    public static void main(String[] args) {
        int arr[] ={4,3,2,5,6,7,3,4,2,1};
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0; i<arr.length; i++) {
            set.add(arr[i]);
        }
        System.out.println("Number of distinct elements: " + set.size());
    }
}
