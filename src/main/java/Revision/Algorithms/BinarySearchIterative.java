package Revision.Algorithms;

public class BinarySearchIterative {
    //key  because we have to find the number
    public static int binarysearch(int[] arr, int key){
        int low =0;
        int high = arr.length-1;
        while(low<high){
            int  mid = low + (high - low)/2;
            if(arr[mid]<key){ // means key  bdi h toh key elemnt mereko right side m milega
                low = mid+1;
            }else if(arr[mid]==key){
//                System.out.println(mid);
                  return mid;
            }else{
                high = mid-1;
            }
        }
//        System.out.println("Element which you are finding not found in given arrey");
        return -1;
    }
    public static void main(String[] args) {
       int arr[] = {2,4,7,9,11,15,24,64,87,97};
       int key = 12;
       int number = binarysearch(arr,key);
       System.out.println(number);
    }
}
