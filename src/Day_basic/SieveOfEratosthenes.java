package Day_basic;

import java.util.Arrays;

public class SieveOfEratosthenes {

    // Method to find prime numbers up to 'n' using the Sieve of Eratosthenes
    static void findPrimes(int n) {
        // Create a boolean array to mark prime numbers
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true); // Assume all numbers are prime initially
        isPrime[0] = isPrime[1] = false; // 0 and 1 are not prime

        // Loop through numbers from 2 to sqrt(n)
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) { // If the number is still marked as prime
                // Mark all multiples of 'i' as non-prime
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Print all prime numbers
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                System.out.print(i + " "); // Print prime numbers
            }
        }
    }

    public static void main(String[] args) {
        int n = 50; // Example: Find primes up to 50
        findPrimes(n);
    }
}

