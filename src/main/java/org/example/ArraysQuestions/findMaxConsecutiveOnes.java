package org.example.ArraysQuestions;

/*
Problem Statement:
Given an array that contains only 1 and 0 return the count of maximum consecutive ones in the array.

Example 1:

Input: prices = {1, 1, 0, 1, 1, 1}

Output: 3

Explanation: There are two consecutive 1’s and three consecutive 1’s in the array out of which maximum is 3.
 */
public class findMaxConsecutiveOnes {
    public static int findmaxconsecutiveones(int arr[]){
            int count =0;
            int maxCount =0;
            for(int i=0;i<arr.length;i++){
                if(arr[i]==1){
                    count++;
                }else{
                    count=0;
                }
                maxCount = Math.max(maxCount,count);
            }
            return maxCount;
    }
    public static void main(String[] args) {
        int arr[] = {1,1,0,0,1,1,1};
        int answer = findmaxconsecutiveones(arr);
        System.out.println(answer);
    }

}
