package Sliding_Window_Technique;

public class Smallest_Subarray_With_Sum_Greater_Than_X {
    private static int bruteForce(int arr[], int X) {
        int n = arr.length;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum > X) {
                    minLen = Math.min(minLen, j - i + 1);
                    break;
                }
            }
        }
        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }

    private static int SlidingWindow(int arr[], int X) {
        int n = arr.length;
        int windowStart = 0;
        int windowEnd = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        int len = 0;
        while (windowEnd < n) {
            //Expansion
            sum += arr[windowEnd];
            if (sum > X) {
                len = windowEnd - windowStart + 1;
                minLen = Math.min(minLen, len);
            }
            // Shrinking
            while (windowStart < windowEnd && sum > X) {
                sum -= arr[windowStart];
                windowStart++;
                if (sum > X) {
                    len = windowEnd - windowStart + 1;
                    minLen = Math.min(minLen, len);
                }
            }
            windowEnd++;
        }
        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }

    public static void main(String[] args) {
        int arr[] = {1, 4, 45, 6, 0, 19};
        int X = 51;
        System.out.println(bruteForce(arr, X));
        System.out.println(SlidingWindow(arr, X));
    }
}
