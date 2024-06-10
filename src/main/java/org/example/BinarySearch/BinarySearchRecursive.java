package org.example.BinarySearch;

public class BinarySearchRecursive {
    public static int RecursiveMethod(int arr[], int low, int high, int key){
        if(low<= high){
            int mid = low + (high-low)/2;
            if(arr[mid] == key){
                return mid;
            }
            if(arr[mid]<key){
                return RecursiveMethod(arr,mid+1,high,key);
            }else{
                return RecursiveMethod(arr,low,mid-1,key);
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {11,33,38,45,57,68,79,80,88,90};
        int result = BinarySearchRecursive.RecursiveMethod(arr,0,arr.length-1,55);
        System.out.println(result);
    }
}
