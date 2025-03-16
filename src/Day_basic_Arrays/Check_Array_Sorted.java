package Day_basic_Arrays;

public class Check_Array_Sorted {
    public static boolean check(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return true;
        }
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr1 = {10, 8, 6, 4};
        int[] arr2 = {1, 2, 2, 3, 5};
        int[] arr3 = {5, 5, 5};
        int[] arr4 = {42};
        int[] arr5 = {3, 6, 9, 12, 15, 11};

        System.out.println(check(arr1)); // false
        System.out.println(check(arr2)); // true
        System.out.println(check(arr3)); // true
        System.out.println(check(arr4)); // true
        System.out.println(check(arr5)); // false
    }
}
