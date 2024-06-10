package org.example.BinarySearch;

public class BinarySearchIterative {

    public static void iterativeMethod(int arr[], int key){
        int low=0;
        int high = arr.length-1;
        while(low<=high){ //yha galti ho rhi thi kukyi mne yha equal ni liya tha,
            //low <= high isliye aayga kyuki element at the high index is also checked
            int mid = low + (high - low)/2;
            if(arr[mid]<key){ // 15< 38
                low = mid + 1;
            }else if(arr[mid] == key){
                System.out.println(mid);
                return;
            }else{
                high = mid -1;
            }
        }
        System.out.print("Not found");
    }
    public static void main(String[] args) {
        int arr[] = {2,4,6,8,9,11,15,18,33,38,44,48,78,98};
         // mid = 15
        //key = 38
        BinarySearchIterative.iterativeMethod(arr,38);
    }
}
