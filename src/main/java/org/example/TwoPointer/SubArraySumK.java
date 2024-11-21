package org.example.TwoPointer;

/*
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.
 */

//brute force code
public class SubArraySumK {
    public static int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count =0;

        for(int i=0; i<n;i++){
            for(int j=i;j<n;j++){
                int sum =0;
                for(int K =i;K<=j;K++){
                    sum += nums[K];
                }
                if(sum == k){
                    count++;
                }

            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        int k = 6;
        int cnt = subarraySum(arr, k);
        System.out.println("The number of subarrays is: " + cnt);
    }
}
