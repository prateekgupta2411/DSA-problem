package two_pointer_package;

public class Container_With_Most_Water {
    public static int maxAreaOFTwoLines(int arr[]){
        int maxArea = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                int width = j-i;
                int height = Math.min(arr[i],arr[j]);
                int area = width * height;
                maxArea = Math.max(maxArea,area);
            }
        }
        return maxArea;
    }
    public static int Approach2(int arr[]){
        int i=0;
        int j = arr.length-1;
        int maxArea = 0;
        while (i<j){
            int width = j-i;
            int height = Math.min(arr[i],arr[j]);
            int area = width*height;
            maxArea = Math.max(maxArea,area);
            if(arr[i] < arr[j]){
                i++;
            } else{
                j--;
            }

        }
        return maxArea;
    }
    public static void main(String[] args) {
        int arr[] = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxAreaOFTwoLines(arr));
        System.out.println(Approach2(arr));
    }
}
