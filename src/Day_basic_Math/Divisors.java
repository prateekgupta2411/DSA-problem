package Day_basic_Math;
import java.util.*;

public class Divisors {
    public static void printDivisors(int n) {
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " "); // Print the divisor
                if (i != n / i) {
                    divisors.add(n / i); // Store the second divisor to print later
                }
            }
        }
        // Print the stored divisors in reverse order to maintain ascending order
        Collections.reverse(divisors);
        for (int d : divisors) {
            System.out.print(d + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 36; // Example number
        System.out.println("Divisors of " + n + " are:");
        printDivisors(n);
    }
}
