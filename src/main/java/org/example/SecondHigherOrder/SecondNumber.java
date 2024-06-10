package org.example.SecondHigherOrder;

import java.util.Arrays;

//in this program we have find the second highest number using one loop
//this is the brute force approach
//public class SecondNumber {
//    public static void SecondLargestNumber(int arr[]){
//        int n = arr.length;
//        if(n<2){
//            System.out.println("Invalid Input");
//            return;
//        }
//        Arrays.sort(arr);
//        for(int i = n-2;i>0;i--){
//            if(arr[i]!= arr[n-1]){
//           System.out.print(arr[i]);
//           return;
//
//            }
//        }
//        System.out.print("no number");
//    }
//    public static void main(String[] args) {
//int arr[] = {1,4,6,8 ,8,7};
//SecondLargestNumber(arr);
//    }
//}


//optimised approach
public class SecondNumber {
    public static int SecondLargestNumber(int arr[]){
        int largest = Integer.MIN_VALUE;
        int SecondLargest = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>largest){
                SecondLargest = largest;
                largest = arr[i];
            }else if(arr[i]>SecondLargest && arr[i] != largest){
                SecondLargest = arr[i];
            }
        }
        return SecondLargest;
    }
    public static void main(String[] args) {
int arr[] = {1,8,8,8 ,8,8};
int print = SecondLargestNumber(arr);
System.out.println(print);
    }
}


