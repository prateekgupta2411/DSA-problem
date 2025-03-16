package Day_basic_Math;

public class Armstrong_Number {
    public static void main(String[] args) {
        int n = 153;
        int original = n;
        int arm = 0;
        int numDigits = String.valueOf(n).length();  // Get number of digits

        while (n > 0) {
            int rem = n % 10;
            arm += Math.pow(rem, numDigits);
            n /= 10;
        }

        if (arm == original) {
            System.out.println(original + " is an Armstrong Number.");
        } else {
            System.out.println(original + " is Not an Armstrong Number.");
        }
    }
}
