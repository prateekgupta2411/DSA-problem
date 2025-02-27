package Day_basic;

import java.util.ArrayList;
import java.util.List;

public class Prime_Factor {
    // Recursive approach
    public static void findPrimeFactorsRecursive(int n, int divisor) {
        if (n <= 1) return; // Base case

        if (n % divisor == 0) {
            System.out.print(divisor + " ");
            findPrimeFactorsRecursive(n / divisor, divisor);
        } else {
            findPrimeFactorsRecursive(n, divisor + 1);
        }
    }

    // Iterative approach
    public static List<Integer> findPrimeFactorsIterative(int n) {
        List<Integer> factors = new ArrayList<>();

        // Remove factors of 2
        while (n % 2 == 0) {
            factors.add(2);
            n /= 2;
        }

        // Remove odd factors from 3 to sqrt(n)
        for (int i = 3; i * i <= n; i += 2) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }

        // If n is still greater than 2, it's a prime factor
        if (n > 2) {
            factors.add(n);
        }

        return factors;
    }

    public static void main(String[] args) {
        int n = 28;

        // Recursive method call
        System.out.print("Recursive Prime Factors: ");
        findPrimeFactorsRecursive(n, 2);
        System.out.println(); // New line for formatting

        // Iterative method call
        System.out.println("Iterative Prime Factors: " + findPrimeFactorsIterative(n));
    }
}
