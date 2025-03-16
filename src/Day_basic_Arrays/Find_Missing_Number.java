package Day_basic_Arrays;

public class Find_Missing_Number {
    public static int missing1(int arr[]) {
        int n = arr.length + 1;
        int expectedSum = n * (n + 1) / 2;

        int actualSum = 0;
        for (int sum : arr) {
            actualSum += sum;
        }
        return expectedSum - actualSum;
    }

    public static int missing2(int arr[]) {
        int n = arr.length + 1;
        int x1 = 0;  // XOR of all numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            x1 ^= i;
        }

        int x2 = 0;  // XOR of all elements in the array
        for (int num : arr) {
            x2 ^= num;
        }

        // XOR of x1 and x2 gives the missing number
        return x1 ^ x2;
    }

    public static void main(String[] args) {
        int arr[] = {1,2, 3, 4, 6};
        System.out.println("Missing number using Sum Formula: " + missing1(arr));
        System.out.println("Missing number using XOR: " + missing2(arr));
    }
}
