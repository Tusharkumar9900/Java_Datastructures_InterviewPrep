package org.example.CompanyQuestions;

/*
Question Statement ->
                        Count minimum steps to get the given desired array
                        Consider an array with n elements and value of all the elements is zero. We can perform following operations on the array.

Incremental operations:Choose 1 element from the array and increment its value by 1.
Doubling operation: Double the values of all the elements of array.
We are given desired array target[] containing n elements. Compute and return the smallest possible number of the operations needed to change the array from all zeros to desired array.

Example ->
           Input: target[] = {2, 3}
           Output: 4
To get the target array from {0, 0}, we
first increment both elements by 1 (2
operations), then double the array (1
operation). Finally increment second
element (1 more operation)

 */


//Approach Using Bit Manipulation
public class MinimumSteps {
    public static int minOperations(int[] target){
        int maxDouble =0;
        int increments = 0;

        for(int nums : target){
            int steps =0;
            while(nums>0){
                if(nums%2 == 1){
                    increments++;
                }
                nums/=2;
                steps++;
            }
            maxDouble = Math.max(maxDouble, steps -1);
        }
        return increments + maxDouble;
    }
    public static void main(String[] args) {
        int[] target ={16,16,16};
        System.out.println(minOperations(target));
    }
}
