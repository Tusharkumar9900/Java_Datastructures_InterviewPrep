package Revision;

/*

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Example 1:
Input Format: N = 5, arr[] = {2,6,5,8,11}, target = 14
 Result: [1, 3]
 Explanation: arr[1] + arr[3] = 14. So, the answer is [1, 3].

 Example 2:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

 */


//-----------------------------------------------------------------------------------------------------------------------------------


//brute force approach

/*
public class TwoSum {
    public static int[] sumnumber(int arr[], int target){
        //create a array of two index in which we get the number
        int[] ans = new int[2];
        ans[0] = ans[1] = -1;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]+arr[j] == target){
                    ans[0] =i;
                    ans[1] =j;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
//    int[] arr = {2,6,5,8,11};
        int[] arr = {2,7,11,15};
    int target = 9;
    int[] answer = sumnumber(arr,target);
    System.out.print(answer[0] +" " + answer[1]);
    }
}


 */

//-----------------------------------------------------------------------------------------------------------------------------


//optimized approach using HashMap


import java.util.HashMap;

public class TwoSum {
    //creating a method to find the sum of two number
    public static int[] twosum(int[] arr, int target){
        int ans[] = new int[2];
        ans[0] = ans[1] = -1;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int result = target -arr[i];
            if(map.containsKey(result)){
                ans[0]= map.get(result);
                ans[1] = i;
                return ans;
            }else{
                map.put(arr[i], i);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
    int[] arr= {3,2,4};
    int target = 6;
    int[] answer = twosum(arr,target);
    System.out.print(answer[0] +" " + answer[1]);
    }
    }
