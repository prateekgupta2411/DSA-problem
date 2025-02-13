package two_pointer_package;

public class Sort0and1 {
    public static void sortArray(int[] arr) {
        int zeroes =0;
        int n = arr.length;
        // count zeroes elements
        for(int i=0;i<n;i++){
            if(arr[i] == 0){
                zeroes++;
            }
        }
        // 0 to zeroes-1 : 0,  zeroes to n-1 : 1
        for(int i=0;i<n;i++){
            if(i<zeroes){
                arr[i] =0;
            } else{
                arr[i] = 1;
            }
        }
    }
    public static void twoPointerApproach(int [] arr){
        int n = arr.length;
        int left = 0;
        int right = n-1;
        while (left < right){
            if(arr[left] == 1 && arr[right] == 0){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
            if(arr[left] == 0){
                left++;
            }
            if(arr[right] == 1){
                right--;
            }
        }
    }
    public static void sortEvenAndOdd(int [] arr){
        int n = arr.length;
        int left = 0; int right = n-1;
        while (left < right){
            if(arr[left] % 2 == 1 && arr[right] % 2 == 0){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
            if(arr[left] %2 == 0){
                left++;
            }
            if(arr[right] %2 == 1){
                right--;
            }
        }
    }
    public static int[] findSquareAndSorted(int [] arr){
        int n = arr.length;
        int left = 0; int right = n-1;
        int ans[] = new int[n];
        int k = n-1;
        while (left <= right){
            if(Math.abs(arr[left]) > Math.abs(arr[right])){
                ans[k--] = arr[left]*arr[left];
                left++;
            } else{
                ans[k--] = arr[right]*arr[right];
                right--;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int [] arr ={-10,-3,-2,1,4,5};
//        sortArray(arr);
//        twoPointerApproach(arr);
//        sortEvenAndOdd(arr);
        int ans[] = findSquareAndSorted(arr);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
    }
}
