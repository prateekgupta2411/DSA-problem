package Day_basic;

public class Check_Palindrome {
    // Recursive function to reverse the number
    public static int rec(int n, int rev) {
        if (n == 0) {
            return rev;
        }
        int rem = n % 10;
        return rec(n / 10, rev * 10 + rem);
    }

    // Iterative approach to check palindrome
    public static boolean check(int n) {
        int original = n;
        int reversed = 0;
        while (n > 0) {
            int rem = n % 10;
            reversed = reversed * 10 + rem;
            n = n / 10;
        }
        return original == reversed;
    }

    public static void main(String[] args) {
        int n = 121;
        System.out.println("Using Iterative Approach: " + check(n));
        System.out.println("Using Recursive Approach: " + (n == rec(n, 0)));
    }
}
