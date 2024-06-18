package org.example.FastAndSlowPointer;

import java.util.LinkedList;
import java.util.List;

/*

Write an algorithm to determine if a number n is happy.
A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.

Input: n = 19
Output: true
Explanation:
1*1 + 9*9 = 82
8*8 + 2*2 = 68
6*6 + 8*8 = 100
1*1 + 0*0 + 0*0 = 1
 */
public class HappyNumber {
    public boolean ishappy(int number){
        int slow = number;
        int fast = number;
        do{
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        }while(slow !=fast);
        if(slow == 1){
            return true;
        }
        return false;
    }
    public int findSquare(int number){
        int answer =0;

        while(number >0){
            int remainder = number %10;
            answer = answer + remainder*remainder;
            number = number/10;
        }
        return answer;
    }
    public static void main(String[] args) {
        HappyNumber happyNumberCheck = new HappyNumber();
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.addFirst(19);
        System.out.println(list);

        // Iterating through the LinkedList and checking if each number is a happy number
        for (int num : list) {
            boolean isHappy = happyNumberCheck.ishappy(num);
            System.out.println(num + " is happy number :- " + isHappy);
        }

    }
}
