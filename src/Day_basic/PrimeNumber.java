package Day_basic;

public class PrimeNumber {
    // Way 1 check no is prime or not
    public static boolean checkPrime(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count += 1;
            }
        }
        if (count == 2) return true;
        return false;
    }

    // Way 2 check no is prime or not
    public static boolean checkPrime1(int n) {
        //corner cases
        if (n < 2) return false;
//        if(n == 2) return true;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Way 3 check no is prime or not
    static boolean checkPrime3(int n) {
        int cnt = 0;

        // Loop through numbers from 1
        // to the square root of n.
        for (int i = 1; i <= Math.sqrt(n); i++) {

            // If n is divisible by i
            // without any remainder.
            if (n % i == 0) {
                // Increment the counter.
                cnt = cnt + 1;
                // If n is not a perfect square,
                // count its reciprocal factor.
                if (n / i != i) {
                    cnt = cnt + 1;
                }
            }
        }
        // If the number of
        // factors is exactly 2.
        if (cnt == 2) {
            // Return true, indicating
            // that the number is prime.
            return true;
        }
        // If the number of
        // factors is not 2.
        else {
            // Return false, indicating
            // that the number is not prime.
            return false;
        }
    }

    public static void printPrimesInRange(int n) {
        for (int i = 0; i <= n; i++) {
            if (checkPrime1(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int n = 10;
//        boolean isPrime = checkPrime1(n);
//        if (isPrime) {
//            System.out.println(n + " is a prime number.");
//        } else {
//            System.out.println(n + " is not a prime number.");
//        }

        printPrimesInRange(n);
    }
}
