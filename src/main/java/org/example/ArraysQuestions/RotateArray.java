package org.example.ArraysQuestions;

import java.util.Arrays;

/*
Rotate array
Problem statement: Given an array, rotate the array to right by K steps,
where K is a non-negative number.
EXAMPLE:
Input: [1,2,3,4,5,6,7,8,9], K = 3
output: [7,8,9,1,2,3,4,5,6]
 */
public class RotateArray {
    public static int[] rotate(int arr[], int k){
        int n = arr.length;
        reverse(arr,0,n-1);
        reverse(arr,0,k-1);
        reverse(arr,k,n-1);
        return arr;
    }
    public static void reverse(int arr[], int start, int end){
        while(start<end){
             int temp = arr[start];
             arr[start]= arr[end];
             arr[end] = temp;
             start++;
             end--;
        }
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9};
        int k=4;
        System.out.println(Arrays.toString(rotate(arr,k)));

    }
}
