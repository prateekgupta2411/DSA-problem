package Day_basic_Math;

public class Count_Digits {
    public static void main(String[] args) {
        int n = 124;
        int count = 0;
        while (n >0){
            int rem = n % 10;
            count++;
            n /= 10;
        }
        System.out.println(count);
    }
}
