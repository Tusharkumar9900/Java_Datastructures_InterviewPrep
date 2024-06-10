package org.example.BinarySearch;

/*
//brute force approach

public class SingleElement {
    public static int SingleElement(int arr[]){
        int n = arr.length;
        if(n == 1){
            return arr[0];
        }
        for(int i=0;i<n;i++){
            if(i==0){
               if(arr[i] != arr[i+1])
                   return arr[i];
            }else if(i == n-1){
                if(arr[i] != arr[i-1])
                    return arr[i];
            }else{
                if(arr[i] != arr[i+1] && arr[i] != arr[i-1])
                    return arr[i];
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {1,1,3,3,4,4,5,7,7,8,8};
        System.out.print(SingleElement.SingleElement(arr));

    }
}
*/

//---------------------------------------------------------------------------------------------------------------------

//optimized approach
public class SingleElement {
    public static int SingleElement(int arr[]){
        int n = arr.length;
        if(n == 1){
            return arr[0];
        }

        if(arr[0] != arr[1]){
            return arr[0];
        }

        if(arr[n-1] != arr[n-2]){
            return arr[n-1];
        }

        int low = 1;
        int high = n-2;
        while(low<= high){
            int mid= low + (high-low)/2;
            if((arr[mid]!= arr[mid+1]) && (arr[mid] != arr[mid-1])){
                return arr[mid];
            }
            if((mid % 2 == 1 && arr[mid] == arr[mid-1]) || (mid %2 == 0 && arr[mid] == arr[mid+1])){
                low = mid + 1;
            }
            else{
                high = mid -1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {1,1,2,3,3,4,4,5,5,6,6};
        System.out.println(SingleElement.SingleElement(arr));
    }
}