package org.example.CompanyQuestions;

import java.util.Arrays;

/*
This Question asked in morgan stanley in QA round

Find the minimum number of groups who's sum of each group is at max 3, and every element must be in a group.
Given an Array like: [1.01, 1.01, 3.0, 2.7, 1.99, 2.3, 1.7]
return the minimum number of groups, in this case it would be 5 groups: (1.01 , 1.99), (1.01, 1.7), (3.0), (2.7), (2.3)
Constraint: all elements are between 1.01-3 inclusive, and each groups sum is at max 3

Example:
Given the array [1.01, 1.01, 3.0, 2.7, 1.99, 2.3, 1.7], the goal is to group these numbers so that the sum of each group is no more than 3.

Breakdown of the Example:
One possible solution is grouping as follows:
(1.01, 1.99) → Sum = 3.00
(1.01, 1.7) → Sum = 2.71
(3.0) → Sum = 3.00
(2.7) → Sum = 2.70
(2.3) → Sum = 2.30
This results in 5 groups, and the sum of elements in each group is at most 3.
 */
public class minimumnumberofgroups {
    public static int mingroups(double[] arr){
        Arrays.sort(arr);

        int left =0;
        int right =arr.length-1;
        int groups =0;

        while(left<=right){
            if(arr[left]+arr[right]<=3.0){
                left++;
            }
            right--;
            groups++;

        }
        return groups;
    }

    public static void main(String[] args) {
double arr[] ={1.01,1.01,3.0,2.7,1.99,2.33,1.7};
        System.out.println("Minimum number of groups: " + mingroups(arr));
    }
}
