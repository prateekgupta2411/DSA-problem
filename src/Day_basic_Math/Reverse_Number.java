package Day_basic_Math;

public class Reverse_Number {
    // recursion
    public static int rec(int n, int rev){
        if(n == 0){
            return rev;
        }
        int rem = n % 10;
        return rec(n/10,rev * 10 +rem);
    }
    public static void main(String[] args) {
        int n = 44499;
        int reverse = 0;
        while(n>0){
            int rem = n % 10;
            reverse = reverse * 10 + rem;
            n = n / 10;
        }
        System.out.println(reverse);
        System.out.println(rec(44499,0));
    }
}
