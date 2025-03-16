package Day_basic_Math;

public class GCD {
    // recursion
    public static int gcd(int a, int b) {
//        return (b == 0) ? a : gcd(b, a % b);
        // base condition
        if(b == 0) return a;
        return gcd(b, a%b);

    }
    // Function to compute LCM using LCM formula
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b); // Using the relation: LCM(a, b) = (a * b) / GCD(a, b)
    }

    public static void main(String[] args) {
        int divisor = 2;
        int divident = 5;
        int rem = divident % divisor; // Compute initial remainder

        while (rem != 0) {
            divident = divisor;  // Move divisor to divident
            divisor = rem;       // Move remainder to divisor
            rem = divident % divisor; // Compute new remainder
        }

//        System.out.println(divisor); // Output: 1
        System.out.println(gcd(2, 5)); // Output: 1
        System.out.println(lcm(2,16));
    }
}
