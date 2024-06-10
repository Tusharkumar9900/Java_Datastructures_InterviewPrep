package org.example.SubArraySum;

//optimized approach of Subarray sum of array.
public class KadanesAlgorithm {
    public static Long maxsubarray(int[] arr){
        Long sum = 0L;
        Long maxi = Long.MIN_VALUE;
        for(int i=0; i<arr.length;i++){
            sum = sum + arr[i];
            maxi = Math.max(maxi,sum);
            if(sum<0){
                sum = 0L;
            }
        }
        return maxi;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,-2,5};
        System.out.print(KadanesAlgorithm.maxsubarray(arr));
    }
}
