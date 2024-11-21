package org.example.ArraysQuestions;

import java.util.Arrays;

// solution in brute force
/*
Given array int[] arr = {1,2,4,7,7,5};
pehle mereko isko sort krna hoga - Arrays.sort(arr); result me arr -> {1,2,4,5,7,7}
Second largest in an array is 5
 */

//optimized approech
public class SecondLargestPractice {
    public static int secondlargestnumber(int arr[]){
        int largest = Integer.MIN_VALUE;
        int secondlargest = Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++){
            if(arr[i]>largest) {
                secondlargest = largest;
                largest = arr[i];
            }else if(arr[i]>secondlargest && arr[i]!= largest){
                secondlargest = arr[i];
            }
        }
        return secondlargest;
    }
    public static void main(String[] args) {

    }
}


