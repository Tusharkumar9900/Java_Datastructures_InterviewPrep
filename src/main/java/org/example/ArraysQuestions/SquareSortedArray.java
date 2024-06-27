package org.example.ArraysQuestions;

import java.util.Arrays;

/*

Given an integer array nums sorted in non-decreasing order,
return an array of the squares of each number sorted in non-decreasing order.

Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].


 */



/*
The map() method can be used to perform a wide range of transformations on a stream of objects.
For example, it can be used to:

Convert a stream of objects of one type to a stream of objects of another type, or
Extract a specific property or field from each object in a stream.


 */


/*

public class SquareSortedArray {
    //using stream we are going to solve the problem
    public static int[] sortedSquare(int[] nums){
        int[] arr = Arrays.stream(nums).map(i-> i*i).toArray();
        Arrays.sort(arr);
        return arr;
    }
    public static void main(String[] args) {
    int nums[] = {-5,-4,0,2,3};
    System.out.println(Arrays.toString(sortedSquare(nums)));
    }
}


 */

//--------------------------------------------------------------------------------------

//using two pointer optimized approach
public class SquareSortedArray {
    public static int[] sortedarray(int[] arr){
        int i=0,j=arr.length-1; //declaring two pointers one in the starting point and another one at end point of the array.
        int index = arr.length-1; // we took one pointer which help us to put the square of the number at the last of array i.e larger one
        int[] result = new int[arr.length]; //for storing the result
        while(i<j){
            if(Math.abs(arr[i])>Math.abs(arr[j])){
                result[index] = arr[i]*arr[i];
                index--;
                i++;
            }else{
                result[index] = arr[j]*arr[j];
                index--;
                j--;
            }
        }
        return result;
    }
    public static void main(String[] args) {
int arr[] = {-4,-2,0,3,10};
System.out.println(Arrays.toString(sortedarray(arr)));
    }
}