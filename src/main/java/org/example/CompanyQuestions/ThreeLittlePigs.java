package org.example.CompanyQuestions;

import java.util.Arrays;
import java.util.Scanner;

/*
Three Little Pigs Three little pigs want to build houses along the river.
There are many apple trees along the river.
Each tree has its own quality level which affects the overall quality of the garden.
A positive value means that the tree is good.
A zero or negative value means that the tree is bad.
The little pigs want to divide the territory in such a way that each of them gets gardens of the same quality.
They need your help to determine how many ways they can divide the territory.

Input
The first line of input contains an integer N. representing the number of apple trees along the river The second line of input contains N space seperated integers as a,, a... aN, where a represents the quality of ith tree.
Output
print the number of ways the three little pigs can divide the territory.

Input
5
-2 4 2 1 1
output
1
 */
public class ThreeLittlePigs {
    public static int countWaysToDivide(int[] arr){
        int n = arr.length;
        int totalSum = Arrays.stream(arr).sum();

        if(totalSum % 3 != 0){
            return 0;
        }

        int target = totalSum/3;
        int prefixSum = 0;
        int firstPartitionCount =0;
        int ways = 0;

        for(int i=0;i<n-1;i++){
            prefixSum += arr[i];
            if(prefixSum == 2 * target){
                ways += firstPartitionCount;
            }
            if(prefixSum == target){
                firstPartitionCount++;
            }
        }
        return ways;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(countWaysToDivide(arr));
        sc.close();
    }
}
