package Day_basic;

public class Count_Digits_Number {
    public static void main(String[] args) {
        int n = 1255554;
        int count = 0;
        while (n >0){
            int rem = n % 10;
            count++;
            n /= 10;
        }
        System.out.println(count);
    }
}
