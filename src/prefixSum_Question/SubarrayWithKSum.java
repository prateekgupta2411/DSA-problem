package prefixSum_Question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class SubarrayWithKSum {
    public static void main(String[] args) {
        int arr[] = {2, 8, 2, 6, -6, 3, 2};

        // Check if there exists a subarray with sum equal to k
        boolean found = checkKSumSubarray(arr, 5);
        System.out.println("found : " + found);

        // Find the starting and ending indices of the first subarray with sum k
        ArrayList<Integer> res = findKSumSubarray(arr, 5);
        if (res.get(0) == -1) { // If no such subarray exists
            System.out.println("Not Found");
            return;
        }
        System.out.println("Res-> [" + res.get(0) + "," + res.get(1) + "]");

        // Find the length of the longest subarray with sum k
        int maxLen = findLongestKSumSubarray(arr, 5);
        System.out.println("maxLen : " + maxLen);

        // Count the total number of subarrays with sum k
        int count = findTotalSumSubarray(arr, 5);
        System.out.println("count : " + count);
    }

    // Method to check if a subarray with sum k exists
    public static boolean checkKSumSubarray(int arr[], int k) {
        HashSet<Integer> mySet = new HashSet<>();
        mySet.add(0); // To handle the case when the prefix sum is exactly equal to k
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            int rem = sum - k; // Calculate the required remainder
            if (mySet.contains(rem)) { // If remainder is found in the set, subarray exists
                return true;
            }
            mySet.add(sum); // Add current prefix sum to the set
        }
        return false; // No subarray with sum k found
    }

    // Method to find the first subarray with sum k and return its indices
    public static ArrayList<Integer> findKSumSubarray(int arr[], int k) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(-1); // Default value if no subarray is found
        HashMap<Integer, Integer> myMap = new HashMap<>();
        myMap.put(0, -1); // To handle prefix sum equal to k
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            int rem = sum - k; // Calculate the required remainder
            if (myMap.containsKey(rem)) { // If remainder exists, subarray is found
                int startingIndex = myMap.get(rem) + 1 + 1; // Adjust indices (1-based indexing)
                list.set(0, startingIndex); // Replace the default value with starting index
                list.add(i + 1); // Add ending index (1-based indexing)
                break;
            }
            myMap.put(sum, i); // Store the prefix sum with its index
        }
        return list;
    }

    // Method to find the length of the longest subarray with sum k
    public static int findLongestKSumSubarray(int arr[], int k) {
        int maxLen = 0, sum = 0;
        HashMap<Integer, Integer> myMap = new HashMap<>();
        myMap.put(0, -1); // To handle prefix sum equal to k
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            int rem = sum - k; // Calculate the required remainder
            if (myMap.containsKey(rem)) { // If remainder exists, calculate the subarray length
                int len = i - myMap.get(rem);
                maxLen = Math.max(maxLen, len); // Update the maximum length
            }
            if (!myMap.containsKey(sum)) { // Only add prefix sum if it's not already present
                myMap.put(sum, i);
            }
        }
        return maxLen;
    }

    // Method to count the total number of subarrays with sum k
    public static int findTotalSumSubarray(int arr[], int k) {
        // Step 1: Initialize variables
        int count = 0; // This will store the total count of subarrays with sum k
        int sum = 0;   // This keeps track of the prefix sum
        HashMap<Integer, Integer> sumFreqMap = new HashMap<>(); // Map to store frequency of prefix sums

        // Step 2: Add an initial entry to handle cases where prefix sum equals k
        sumFreqMap.put(0, 1); // If the prefix sum equals k, it means the subarray starts from index 0

        // Step 3: Traverse the array
        for (int i = 0; i < arr.length; i++) {
            // Step 3.1: Add the current element to the prefix sum
            sum += arr[i];

            // Step 3.2: Calculate the required remainder (sum - k)
            int rem = sum - k;

            // Step 3.3: Check if the remainder exists in the map
            // If it does, it means there are subarrays ending at the current index with sum k
            count += sumFreqMap.getOrDefault(rem, 0);

            // Step 3.4: Update the frequency of the current prefix sum in the map
            // If the prefix sum already exists, increment its count; otherwise, set it to 1
            sumFreqMap.put(sum, sumFreqMap.getOrDefault(sum, 0) + 1);
        }

        // Step 4: Return the total count of subarrays with sum k
        return count;
    }
}
