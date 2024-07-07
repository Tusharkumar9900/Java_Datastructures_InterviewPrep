package org.example.CompanyQuestions;

/*

Company asked this question - Microsoft
There are N balls positioned in a row.
Each of them is either red or white. In one move, we can swap two adjacent balls.
We want to arrange all the red balls into a consistent segment.
What is the minimum number of swaps needed?

Given string S of length N built from characters "R" and "W", representing red and white balls respectively,
returns the minimum number of swaps needed to arrange all the red balls into a consistent segment.
If the result exceeds 10^9, return -1.


Example 1:
Input:WRRWWR
Output: 2


Explanation:
We can move the last ball two positions to the left:
swap R and W -> WRRWRW
swap R and W -> WRRRWW

Example 2:
Input:WWRWWWRWR
Output: 4


Explanation:
We can move the last ball two positions to the left:
swap R and W -> WWRWWWRRW
swap R and W -> WWWRWWRRW
swap R and W -> WWWWRWRRW
swap R and W -> WWWWWRRRW


 */


import java.util.ArrayList;
import java.util.List;

public class RedWhiteBall {


/*


    public static int minimumswap(String s) {
        //initializing variable for counting the R's in the string
        int totalRedBall = 0;
        //count the total number of 'R' balls in the string
        for (char c : s.toCharArray()) {
            if (c == 'R') {
                totalRedBall++;
            }
        }

        //edge case to handle if there is no Red ball in the string
        if (totalRedBall == 0) {
            return 0;
        }

        int n = s.length();
        int left = 0, right = 0, currentSwap = 0, minSwap = Integer.MAX_VALUE;


        // Move the right pointer to form the initial window containing the first group of 'totalRedBall' characters
        while (right < n) {
            if (s.charAt(right) == 'W') {
                currentSwap++;
            }

            if (right - left + 1 == totalRedBall) {
                minSwap = Math.min(minSwap, currentSwap);
                if (s.charAt(left) == 'W') {
                    currentSwap--;
                }
                left++;
            }
            right++;
        }

        // Calculate the minimum swaps needed to move all red balls to the left
        int leftSwaps = 0;
        for (int i = 0; i < totalRedBall; i++) {
            if (s.charAt(i) == 'W') {
                leftSwaps++;
            }
        }

        // Calculate the minimum swaps needed to move all red balls to the right
        int rightSwaps = 0;
        for (int i = n - 1; i >= n - totalRedBall; i--) {
            if (s.charAt(i) == 'W') {
                rightSwaps++;
            }
        }

        return Math.min(minSwap, Math.min(leftSwaps, rightSwaps));
    }


*/



//-------------------------------------------------------------------------------------------------------------------
    public static int minimumswap(String s){
        List<Integer> redBall = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') redBall.add(i);
        }
        int result = 0, mid = redBall.size() / 2;  // mid is the point to get minimum swaps.
        for (int i = 0; i < redBall.size(); i++) {
            result = result + Math.abs(redBall.get(mid) - redBall.get(i)) - Math.abs(mid - i);
        }
        return result;
    }



        public static void main (String[] args){
            String s = "WRRWWR";
            int swap = minimumswap(s);

            System.out.println(swap);
        }
    }

