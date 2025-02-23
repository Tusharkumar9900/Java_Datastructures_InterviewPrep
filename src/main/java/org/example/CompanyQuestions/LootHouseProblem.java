package org.example.CompanyQuestions;

/*
A thief is planning to steal from several houses along a street.
Each house has a certain amount of money stashed.
However, the thief cannot loot two adjacent houses.
Determine the maximum amount of money the thief can steal
without looting two consecutive houses.

Input - The first line contains an integer 'N', representing the number of houses.
The second line contains 'N' space-separated integers,
representing the money available in each house.

Output -
The maximum amount of money the thief can loot without looting two consecutive houses.

Example -
Input N =4
values =[6,7,1,30]

Output
36
 */

/*-----------------------------------------------------------------------------------------------------------
//brute force
public class LootHouseProblem {

    public static int maxlootRec(int[] values, int index){
        if(index>= values.length){
            return 0;
        }
        //case 1 : loot this house and skip the next one
        int loot = values[index] + maxlootRec(values, index+2);

        //case 2 : skip this house and move to the next one
        int skip = maxlootRec(values, index+1);

        //skip represents the best possible loot from index + 1 onward.
        //loot represents the money collected when looting index and skipping index + 1.
        return Math.max(loot, skip);
    }
    public static void main(String[] args) {
        int[] values = {6,7,1,3,8,2,4};
        int maxloot = maxlootRec(values, 0);
        System.out.println(maxloot);

    }
}


 */

import java.util.Arrays;

//Better Approach using DP memoization
public class LootHouseProblem{

    public static int maxlootmemo(int[] values, int index, int[] dp){
        if(index >= values.length){
            return 0;
        }
        if(dp[index] != -1){
            return dp[index];
        }

        int loot = values[index] + maxlootmemo(values, index+2, dp);
        int skip = maxlootmemo(values, index+1, dp);
        return dp[index] = Math.max(loot,skip);
    }
    public static void main(String[] args) {
        int[] values ={6,7,1,3,8,2,4};
        int n = values.length;
//        This initializes a memoization array dp to store results for each index.
//        -1 means that value for that index is not yet computed.

        int[] dp = new int[n];

        Arrays.fill(dp,-1);
        int maxloot = maxlootmemo(values,0,dp);
        System.out.println(maxloot);
    }
}