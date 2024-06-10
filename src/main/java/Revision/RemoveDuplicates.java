package Revision;

import java.util.LinkedHashSet;
import java.util.Set;

/*
Problem Statement: Given an integer array sorted in non-decreasing order,
remove the duplicates in place such that each unique element appears only once.
The relative order of the elements should be kept the same.

Example 1:
Input:
 arr[1,1,2,2,2,3,3]

Output:
 arr[1,2,3,_,_,_,_]

Explanation:
 Total number of unique elements are 3, i.e[1,2,3] and Therefore return 3 after assigning [1,2,3] in the beginning of the array.
 */


//--------------------------------------------------------------------------------------------------------------
/*
//brute force approach
public class RemoveDuplicates {
    public static int Duplicate(int arr[]){
        Set<Integer> set = new LinkedHashSet<>();
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }
        int index =0;
        for (int element: set) {
            arr[index++] = element;
        }
        return set.size();
    }
    public static void main(String[] args) {
       int arr[] = {1,1,2,3,3};
//       System.out.println(Duplicate(arr));
        int k = Duplicate(arr);
        System.out.println("The array after removing duplicate elements is ");
        for (int i = 0; i < k; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    }



 */

//-------------------------------------------------------------------------------------------------------------------------------------------------

//optimised approach using two pointer

public class RemoveDuplicates {
    public static int Duplicateremove(int arr[]){
        int i=0;
        for(int j=1;j<arr.length;j++){
            if(arr[j] != arr[i]){
                arr[i+1]= arr[j];
                i++;
            }
        }
        return i+1;
    }
    public static void main(String[] args) {
        int arr[] = {1,1,2,2,3,3,6,8,9,9};
        int k = Duplicateremove(arr);
        System.out.println("The array after removing duplicate elements is ");
        for (int i = 0; i < k; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}