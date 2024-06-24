package org.example.BinarySearch;

/*
Approach - as we see given sorted array and we have search then simply we apply BINARY SEARCH ALGO.
Search in a Rotated Sorted Array

problem statement:  Given an integer array arr of size N, sorted in ascending order (with distinct values) and a target value k.
Now the array is rotated at some pivot point unknown to you. Find the index at which k is present and if k is not present return -1.
 */
public class RotatedSortedArray {
    public static int BinarySearch(int arr[],int target){
        int low=0;
        int high = arr.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid] == target){
                return mid;
            }
            if(arr[low]<=arr[mid]){
                if(arr[low]<=target && target <= arr[mid]){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
                }
            else{
                if(arr[mid]<=target && target<=arr[high]) {
                    low = mid + 1;
                }else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
     int arr[] = {7,8,9,1,2,3,4,5,6};
     int target = 1;
     System.out.print(BinarySearch(arr,target));
    }
}
