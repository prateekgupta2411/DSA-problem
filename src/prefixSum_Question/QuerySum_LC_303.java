package prefixSum_Question;

import java.util.Scanner;

public class QuerySum_LC_303 {
    public static int[] computePrefixSum(int[] arr) {
        int[] prefixSum = new int[arr.length + 1];
        for (int i = 1; i <= arr.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
        }
        return prefixSum;
    }

    public static void main(String[] args) {
        int arr[] = {2, 4, 1, 3, 6};
        int[] prefixSum = computePrefixSum(arr);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of queries:");
        int queries = sc.nextInt();

        for (int i = 0; i < queries; i++) {
            System.out.println("Enter l and r:");
            int l = sc.nextInt();
            int r = sc.nextInt();
            int sum = prefixSum[r] - prefixSum[l - 1];
            System.out.println("Sum from index " + l + " to " + r + " is: " + sum);
        }

        sc.close();
    }
}
