package org.example.ArraysQuestions;

/*
We have to find the missing number in an unsorted array
Given an array arr[] of size N-1 with integers in the range of [1, N],
the task is to find the missing number from the first N integers.

Input: arr[] = {1, 2, 4, 6, 3, 7, 8} , N = 8
Output: 5
Explanation: Here the size of the array is 8, so the range will be [1, 8]. The missing number between 1 to 8 is 5
 */

//solving this problem using summation method i.e - as we know the sum of the number from 1-N is n*(n+1)/2 and when we subtract this from the sum of our array
//Time Complexity for this Solution is O(N)
public class MissingNumber {
    public static int missingnumber(int arr[]){
    int n = arr.length;
//this is the sum of the array element i.e actualArraySum
    int actualArraySum =0;
    int N = n+1;
    //now the sum of first n natural number calculate by using the formula
        int totalSum = N*(N+1)/2;
        for(int num : arr){
            actualArraySum = actualArraySum + num;
        }
        return totalSum - actualArraySum;

    }
    public static void main(String[] args) {
   int arr[] = {1, 2, 4, 6, 3, 7, 8};
   System.out.println(missingnumber(arr));
    }
}
