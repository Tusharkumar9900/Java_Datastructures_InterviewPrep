package Revision.Algorithms;

public class BinarySearchRecursive {
    //this is the recursive method for binary serach
    public static int BinarySearch(int[] arr, int key, int low, int high){

        if(low<=high){
            int mid = low + (high - low)/2;
            if(arr[mid] == key){
                return mid;
            }
            if(arr[mid]>key){
                return BinarySearch(arr,key,low,mid-1);
            }else{
                return BinarySearch(arr,key,mid+1,high);
            }
        }
       return -1;
    }
    public static void main(String[] args) {
     int arr[] = {23,45,56,66,72,74,81,82,84,86,99};
     System.out.println(BinarySearch(arr,86,0,arr.length-1));
    }
}
