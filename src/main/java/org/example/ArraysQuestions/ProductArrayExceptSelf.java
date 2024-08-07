package org.example.ArraysQuestions;

/*

Problem Statement ->
                     Given an array arr[] of integers, you need to return the product of given array elements except including the element itself.
NOTE - You should not use division operator ‘ / ’

Example:

Input: N = 5, array[] = {1,2,3,4,5}
Output: 120 60 40 30 24


Explanation:
For 0th index, excluding 1 from product of whole array will give 120
For 1th index, excluding 2 from product of whole array will give 60
For 2nd index , excluding 3 from product of whole array will give 40
For 3rd index, excluding 4 from product of whole array will give 30
For 4th index , excluding 5 from product of whole array will give 24


 */

import java.util.Arrays;

public class ProductArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        //create array for left side , matlb prefix k liye
        int[] prefix = new int[nums.length];

        //for storing right side, mtlb suffix k liye
        int[] suffix = new int[nums.length];

        prefix[0] = 1;
        for(int i=1;i<nums.length;i++){
            prefix[i]= prefix[i-1]*nums[i-1];
        }

        //for suffix
        suffix[suffix.length-1]=1;
        for(int i=nums.length-2;i>=0;i--){
            suffix[i] = suffix[i+1]*nums[i+1];
        }
        int[] ans = new int[nums.length];
        for(int i=0;i<ans.length;i++){
            ans[i]=prefix[i]*suffix[i];
        }
        return ans;
    }
    public static void main(String[] args) {
int arr[] = {1,2,3,4,5};
System.out.println(Arrays.toString(ProductArrayExceptSelf.productExceptSelf(arr)));
    }
}
