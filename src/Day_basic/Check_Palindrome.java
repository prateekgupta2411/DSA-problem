package Day_basic;

public class Check_Palindrome {
    public static boolean check(int n) {
        int original = n;
        int reversed = 0;

        while (n > 0) {
            int rem = n % 10;
            reversed = reversed * 10 + rem;
            n = n / 10;
        }
        return original == reversed; // Compare original and reversed number
    }

    public static void main(String[] args) {
        int n = 121;
        System.out.println(check(n));
    }
}
