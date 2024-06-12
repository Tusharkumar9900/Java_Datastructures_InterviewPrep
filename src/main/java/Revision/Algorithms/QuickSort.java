package Revision.Algorithms;

import java.util.List;

/*
 Given an array of n integers, sort the array using the Quicksort method.

Example 1:
Input:  N = 5  , Arr[] = {4,1,7,9,3}
Output: 1 3 4 7 9

Explanation: After sorting the array becomes 1, 3, 4, 7, 9
 */

//In this Algorithm we use Array to sort using quick sort.
public class QuickSort {
    // Partition method to find the correct position of the pivot element
    static int partition(int arr[], int low, int high){
        int pivot = arr[low]; // Select the pivot element
        int i = low;
        int j = high;

        // Repeat until the two pointers cross
                while(i<j){
                    // Move the left pointer to the right as long as elements are less than or equal to the pivot
                    while(i<=high-1 && arr[i] <= pivot){
                        i++;
                    }
                    // Move the right pointer to the left as long as elements are greater than the pivot
                 while(low+1<=j && arr[j] > pivot){
                     j--;
                 }
                 if(i<j){
                     // we write swap function here to Swap elements at left and right pointers if they have not crossed
                     int temp = arr[i];
                     arr[i] = arr[j];
                     arr[j] = temp;
                 }
                }
        // Swap the pivot element with the element at the right pointer
                int temp = arr[low];
                arr[low] = arr[j];
                arr[j] = temp;
                return j;
    }
    // QuickSort method to sort the array
    static void quicksort(int arr[], int low, int high){
        // Perform quicksort only if the range is valid
        if(low<high) {
            // Partition the array and get the pivot index
            int pivot = partition(arr,low,high);
            // Recursively sort elements before and after the pivot
            quicksort(arr, low, pivot - 1);
            quicksort(arr,pivot+1,high);
        }
    }
    public static void printarray(int arr[], int n){
        for(int i=0;i<n;i++){
            System.out.print(arr[i] + " ");
//            System.out.println();
        }
    }
    public static void main(String[] args) {
     int arr[] ={4,6,2,5,7,9,1,3};
     int n = arr.length;
     quicksort(arr,0,n-1);
    printarray(arr,n);
    }
}
