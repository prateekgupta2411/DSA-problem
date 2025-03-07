package Day_basic;

import java.util.Arrays;

public class SieveOfEratosthenes {
    static void findPrimes(int n) {
        boolean[] arr = new boolean[n + 1];
        Arrays.fill(arr, true);
        arr[0] = arr[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (arr[i]) {
                for (int j = i * i; j <= n; j += i) {
                    arr[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (arr[i]) {
                count++;
                System.out.print(i + " ");
            }
        }
        System.out.println();
        System.out.println(count);
    }
    public static void main(String[] args) {
        int n = 30;
        findPrimes(n);
    }
}
