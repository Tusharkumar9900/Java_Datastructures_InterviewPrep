package org.example.ArraysQuestions;
/*
Problem Statement: You are given an array of ‘N’ integers.
You need to find the length of the longest sequence which contains the consecutive elements.
Example 1:
Input:
 [100, 200, 1, 3, 2, 4]

Output:
 4

Explanation:
 The longest consecutive subsequence is 1, 2, 3, and 4.

 */



/*


//brute force approach
//For every element x, we will try to find the consecutive elements, x+1, x+2, x+3, and so on using the linear search algorithm.
//Thus, we will check the length of the longest consecutive subsequence we can build for every element x.
//Among all the lengths we will consider the maximum one.
public class LongestConsecutiveSequence {
    public static boolean linearsearch(int arr[], int num){
        int n = arr.length;
        for(int i=0;i<n;i++) {
            if (arr[i] == num) {
                return true;
            }
        }
            return false;

    }
    public static int sequence(int arr[]){
        int longest =1;
        for(int i=0;i<arr.length;i++){
            int x = arr[i];
            int count =1;
            while(linearsearch(arr,x+1)== true){
                x = x+1;
                count = count +1;
            }
            longest = Math.max(longest,count);
        }
        return longest;
    }
    public static void main(String[] args) {
int[] arr = {100,200,4,2,1,101,3,102};
int ans = sequence(arr);
System.out.println(ans);
    }
}



 */

//-----------------------------------------------------------------------------------------


//optimized approach using hashset data structure

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static int longestconsecutivesequence(int arr[]){
        int n = arr.length;
        if(n==0){
            return 0;
        }
        int longestnumber =1;
        //declaring hashset
        HashSet<Integer> set = new HashSet<>();
        // put all the array elements into set
        for(int i=0;i<n;i++){
            set.add(arr[i]);
        }
//finding the longest sequence
        for (int sequence: set) {
            if(!set.contains(sequence-1)){
                int count =1;
                int x = sequence;
                while(set.contains(x+1)){
                    x=x+1;
                    count = count+1;
                }
                longestnumber = Math.max(longestnumber,count);
            }
        }
        return longestnumber;
    }
    public static void main(String[] args) {
        int arr[] ={102,4,100,1,101,3,2,104,1,1,103};
       int ans = longestconsecutivesequence(arr);
       System.out.println(ans);
    }
}