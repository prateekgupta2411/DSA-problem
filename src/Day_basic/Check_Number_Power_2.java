package Day_basic;

public class Check_Number_Power_2 {
    public static void main(String[] args) {
        int n = 64;
//        System.out.println(isPowerOfTwo(n) ? "Power of 2" : "Not a power of 2");
//    }
//    static boolean isPowerOfTwo(int n) {
//        if (n <= 0) return false;
//        while (n % 2 == 0) {
//            n /= 2;
//        }
//        return n == 1;

        // without function
//        boolean isPowerOf2 = true;
//
//        if (n <= 0) {
//            isPowerOf2 = false;
//        } else {
//            while (n % 2 == 0) {
//                n /= 2;
//            }
//            if (n != 1) {
//                isPowerOf2 = false;
//            }
//        }
//        System.out.println(isPowerOf2 ? "Power of 2" : "Not a power of 2");

//        direct ways

        if (n > 0 && (n & (n - 1)) == 0) {
            System.out.println(n + " is a power of 2");
        } else {
            System.out.println(n + " is NOT a power of 2");
        }
    }
}