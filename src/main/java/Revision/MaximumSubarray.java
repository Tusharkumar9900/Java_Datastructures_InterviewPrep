package Revision;

/*
Given an integer array arr, find the contiguous subarray (containing at least one number) which
has the largest sum and returns its sum and prints the subarray.

Example 1:
Input:
 arr = [-2,1,-3,4,-1,2,1,-5,4]

Output:
 6

Explanation:
 [4,-1,2,1] has the largest sum = 6.

 */

/*

//using two pointer approach
public class MaximumSubarray {
 public static int subarraysum(int arr[]){
     int maxi = Integer.MIN_VALUE;
     for(int i=0;i<arr.length;i++){
         int sum=0;
         for(int j=i;j<arr.length;j++){
             sum = sum + arr[j];
             maxi = Math.max(maxi,sum);
         }
     }
     return maxi;
 }
    public static void main(String[] args) {
     int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
     System.out.println(subarraysum(arr));
    }
}


 */


//------------------------------------------------------------------------------------------------------

//Optimal approach algorithm named Kadane's algo

public class MaximumSubarray{

    public static int maxisum(int arr[]){
        int maxi = Integer.MIN_VALUE;
        int sum=0;
        //for printing the subarray this step is written
        int start =0;
        int subarraystart = -1, subarrayend =-1;

        for(int i=0;i<arr.length;i++){

            //this step is written for subarrray printing (60-62 line)
            if(sum ==0){
                start =i;
            }
            //step-1
            sum = sum + arr[i];
            //this step is written for subarrray printing (66 - 70)
            if(sum > maxi){
                maxi = sum;
                subarraystart = start;
                subarrayend =i;
            }

            //step -2
            maxi = Math.max(maxi,sum);


            //step -3
            if(sum<0){
               sum =0;
            }
        }
        //printing subarray ( 82 - 86 line )
        System.out.println("printing the subarray");
        for(int i = subarraystart;i<=subarrayend;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        return maxi;
    }
    public static void main(String[] args) {
        int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxisum(arr));
    }
}