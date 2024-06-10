package org.example.ArraysQuestions;

import java.util.Arrays;

/*
//brute force approach
public class SecondLargestElement {
    public static int secondlargest(int arr[]){
        int n = arr.length;
        Arrays.sort(arr);
        int largest = arr[n-1];
        int secondlargest = arr[n-2];
        for(int i = n-2;i>0;i--){
            if(arr[i] != largest){
                secondlargest = arr[i];
                return arr[i];
            }
        }
       return -1;
    }
    public static void main(String[] args) {
     int arr[] = {2,4,6,8,10,13,14};
     System.out.print(secondlargest(arr));
    }
}


 */


public class SecondLargestElement{
    public static int secondLargestNumber(int arr[]){
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++){
            if(arr[i] >largest){
                secondLargest = largest;
                largest = arr[i];
            }else if(arr[i]>secondLargest && arr[i] != largest){
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }
    public static void main(String[] args) {
        int arr[] = {2,4,6,8,9,11,14,16};
        int result = secondLargestNumber(arr); // Call the method and store the result
        System.out.println(result);
    }
}