package day35_Hashing;

import java.util.HashSet;

public class UnionAndIntersectionOfTwoArray {
    public static void main(String[] args) {
        int arr1[] = {7, 3, 9};
        int arr2[] = {6, 3, 9, 2, 9, 4};

        HashSet<Integer> unionSet = new HashSet<>();
        HashSet<Integer> intersectionSet = new HashSet<>();

        // Adding elements of arr1 to the union set
        for (int num : arr1) {
            unionSet.add(num);
        }
        // Adding elements of arr2 to the union set
        for (int num : arr2) {
            unionSet.add(num);
        }

        // Printing Union
        System.out.println("Union Size -> " + unionSet.size());
        System.out.println("Union Elements -> " + unionSet);

        // Finding Intersection
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr1) {
            set.add(num);
        }

        for (int num : arr2) {
            if (set.contains(num)) {
                intersectionSet.add(num); // To avoid duplicates
                set.remove(num); // Ensures each element is counted only once
            }
        }

        // Printing Intersection
        System.out.println("Intersection Size -> " + intersectionSet.size());
        System.out.println("Intersection Elements -> " + intersectionSet);
    }
}
