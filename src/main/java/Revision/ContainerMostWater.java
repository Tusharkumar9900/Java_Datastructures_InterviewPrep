package Revision;

/*


You are given an integer array height of length n.
There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
In this case, the max area of water (blue section) the container can contain is 49.

 */
public class ContainerMostWater {
    public static int MaxAreaOfWater(int arr[]){
        int maximum = Integer.MIN_VALUE;
        int left = 0;
        int right= arr.length -1;

        while(left<right){
            int width = right - left;
            int height = Math.min(arr[left],arr[right]);
            int area = width * height;
            maximum = Math.max(maximum,area);
            if(arr[left]<arr[right]){
                left++;
            }else{
                right--;
            }
        }
        return maximum;
    }
    public static void main(String[] args) {
        //      int arr[]= {1,8,6,2,5,4,8,3,7};
        int arr[]= {1,4,2,3};
        System.out.print("Maximum amount of water container can hold is "+ MaxAreaOfWater(arr));


    }
}
