package Revision;

/*

Find the intersection of two sorted arrays. OR in other words, Given 2 sorted arrays,
find all the elements which occur in both the arrays.

Example 1:
Input:
A: [1 2 3 3 4 5 6], B: [3 3 5]
Output: 3,3,5
Explanation: We are given two arrays A and B. The elements present in both the arrays are 3,3 and 5.
 */

import java.util.ArrayList;

//Approach we are using is TWO POINTER
public class ArrayIntersection {
    //method for finding intersection between two arrays
    public static ArrayList<Integer> intersection(int[] arr1, int[] arr2){
        ArrayList<Integer> list = new ArrayList<>();
        int i=0;
        int j=0;
        while(i<arr1.length && j< arr2.length){
            if(arr1[i]<arr2[j]){
                i++;
            }else if(arr2[j] < arr1[i]){
                j++;
            }else{
                list.add(arr1[i]);
                i++;
                j++;
            }
        }
        return list;
    }
    public static void main(String[] args) {
    int arr1[] = {1,2,3,4,6};
    int arr2[] = {3,3,5};
    System.out.print(intersection(arr1,arr2));
    }
}
