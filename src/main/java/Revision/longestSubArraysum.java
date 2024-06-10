package Revision;
/*
longest subarray sum zero
Questions :- Given an array containing both positive and negative integers,
 we have to find the length of the longest subarray with the sum of all elements equal to zero.

example :- Input Format : N = 6, array[] = {9, -3, 3, -1, 6, -5}
Result: 5
Explanation : The following subarrays sum to zero:
{-3, 3} , {-1, 6, -5}, {-3, 3, -1, 6, -5}
Since we require the length of the longest subarray, our answer is 5!
 */
//------------------------------------------------------------------------------------------------------------------------------

/*


//brute force approach
public class longestSubArraysum {
    public static int maxlength(int arr[]){
        int maxi =0;
        for(int i=0;i<arr.length;i++){
            int sum=0;
            for(int j=i;j<arr.length;j++){
                sum = sum + arr[j];
                if(sum == 0){
                    maxi = Math.max(maxi,j-i+1);
                }
            }
        }
        return maxi;
    }
    public static void main(String[] args) {
      int arr[] = {9, -3, 3, -1, 6, -5};
      System.out.print(maxlength(arr));
    }
}



 */


//--------------------------------------------------------------------------------------------------------------------------

//optimized Approach using hashmap

import java.util.HashMap;

public class longestSubArraysum{
    public static int maxlength(int arr[]){
        int sum=0;
        int maxi =0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            sum = sum + arr[i];
            if(sum == 0){
                maxi = i+1;
            }else if(map.get(sum) != null){
                maxi = Math.max(maxi,i-map.get(sum));
                //maximum = maximum(maximum, currentindex - index from map of sum);
            }else{
                map.put(sum,i);
            }
        }
        return maxi;
    }
    public static void main(String[] args) {
 int arr[] = {2,8,-3,-5,2,-4,6,1,2,1,-3,4};
 System.out.println(maxlength(arr));
    }
}