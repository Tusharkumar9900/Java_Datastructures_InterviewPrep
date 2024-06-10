package Revision;

import java.util.Arrays;
/*
//this is the brute force approach for solving the second largest number.
public class SecondLargestnumber {
    public static int secondlargest(int arr[]){
        int n = arr.length;
        Arrays.sort(arr);
        int largest = arr[n-1];
        int secondlargestnumber = arr[n-2];
        for(int i=n-2;i>0;i--){
            if(arr[i] != largest){
                secondlargestnumber = arr[i];
                return arr[i];
            }
        }
        return -1;
    }
    public static void main(String[] args) {
    int arr[] = {1,2,5,7,4,7};
    System.out.println(secondlargest(arr));
    }
}


 */



public class SecondLargestnumber{
    public static int secondlargestnumber(int arr[]){
        int largestnumber = Integer.MIN_VALUE;
        int secondlargestnumber = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>largestnumber){
                secondlargestnumber = largestnumber;
                largestnumber = arr[i];
            }else if(arr[i]>secondlargestnumber && arr[i] != largestnumber){
                secondlargestnumber = arr[i];
            }
        }
        return secondlargestnumber;
    }
    public static void main(String[] args) {
    int arr[] = {1,2,5,3,4,9,4};
    System.out.print(secondlargestnumber(arr));
    }
}