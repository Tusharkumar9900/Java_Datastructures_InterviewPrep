package org.example.Stack;

import java.util.Arrays;
import java.util.Stack;

/*

We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left).
Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions.
If two asteroids meet, the smaller one will explode.
If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

Example 1:

Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.


 */
public class AestroidCollision {
    public static int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<n;i++){
            if(asteroids[i]>0){
                stack.push(asteroids[i]);
            }else{ //if it is negative element
                while(!stack.isEmpty() && stack.peek()>0 && stack.peek()< Math.abs(asteroids[i])){
                    stack.pop();
                }
                if(!stack.empty() && stack.peek() == Math.abs(asteroids[i])){
                    stack.pop();
                }else if(stack.isEmpty() || stack.peek()<0){
                    stack.push(asteroids[i]);
                }
            }
        }
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
    public static void main(String[] args) {
int[] aestroid ={4,7,1,1,2,-3,-7,17,15,-16};

       System.out.println(Arrays.toString(AestroidCollision.asteroidCollision(aestroid)));
    }
}
