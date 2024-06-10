package Revision;

/*
Merge two Sorted Array without extra Space.
Given two sorted arrays arr1[] and arr2[] of sizes n and m in non-decreasing order.
Merge them in sorted order.
Modify arr1 so that it contains the first N elements and modify arr2 so that it contains the last M elements.

Example 1:
Input:

n = 4, arr1[] = [1 4 8 10]
m = 5, arr2[] = [2 3 9]

Output:

arr1[] = [1 2 3 4]
arr2[] = [8 9 10]


Explanation:

After merging the two non-decreasing arrays, we get, 1,2,3,4,8,9,10.
 */


import java.util.Arrays;

public class MergeArray {
    public static int[] sortedmerge(int[] arr1, int[] arr2, int m, int n){
        int i=m-1;
        int j=n-1;
        int k = arr1.length-1;
        while(i>=0 && j>=0){
            if(arr1[i]>arr2[j]){
                arr1[k] = arr1[i];
                k--;
                i--;
            }else{
                arr1[k] = arr2[j];
                k--;
                j--;
            }
        }
       while(j>=0){
           arr1[k] = arr2[j];
           k--;
           j--;
       }
       return arr1;
    }
    public static void main(String[] args) {
    int arr1[] = {1,2,3,0,0,0};
    int arr2[] = {2,5,6};
    sortedmerge(arr1,arr2,3 ,3);
   for(int i=0;i<arr1.length;i++){
       System.out.print(arr1[i] + " ");
   }

    }
}
