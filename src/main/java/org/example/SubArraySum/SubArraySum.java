package org.example.SubArraySum;

//question is Length of the longest SubArray Sum zero


/*public class SubArraySum {
    public static int subarray(int[] arr){
        int max =0;
        for(int i=0;i<arr.length;i++){
            int sum =0;
            for(int j=i;j<arr.length;j++){
                sum = sum + arr[j];
                if(sum ==0){
                    max = Math.max(max,j-i+1);
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
int arr[] = {2,8,-3,-5,2,-4,6,1,2,1,-3,4};
//        int arr[] = {15,-2,2,-8,1,7,10,23};
System.out.print(subarray(arr));
    }
}

*/
//-------------------------------------------------------------------------------------------------------------------------
//optimized approach using hashmap

import java.util.HashMap;

public class SubArraySum {

    //method for sub array sum using hashmap
    public static int subarray(int[] arr){
        //first Integer will store the prefix sum and second Integer will store the index
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum=0;
        int max = 0;// maximum length subarray
        //now traverse in the array

        for(int i=0;i<arr.length;i++){
            //adding array element to our sum, nya sum calculate krege
            sum = sum + arr[i];
            //sum == 0, we can say that subarray util the current index has a sum =0
            //so we update max with the maximum valueof (max, current_index+1)


            if(sum ==0){
                max = i+ 1; // length of the subarray like current index -previous index +1 goes to the maxlength
            }else{
                if(map.get(sum) != null){
                    max = Math.max(max,i-map.get(sum));
                }else{
                    map.put(sum,i);
                }
            }


        }
        return max;
    }
    public static void main(String[] args) {
        int arr[] ={9,-3,3,-1,6,-5};
        System.out.print(subarray(arr));
    }
}