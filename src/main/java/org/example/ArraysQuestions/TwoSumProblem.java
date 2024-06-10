package org.example.ArraysQuestions;

import java.util.Arrays;
import java.util.HashMap;

/*
//problem - two sum question
//Brute force approach using two pointer
//time complexity of above code is O(n^2) and space Coplexity for code is O(1)
public class TwoSumProblem {
    public static int[] Sum(int arr[], int target){
        int n = arr.length;
        int[] ans = new int[2];
        ans[0] = ans[1] = -1;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]+arr[j] == target){
                    ans[0]= i;
                    ans[1]= j;
                    return ans;
                }
            }
        }
       return ans;
    }
    public static void main(String[] args) {
        int arr[] ={2,7,11,15,8,13,5,21};
        int target = 15;
        int[] ans = Sum(arr, target);
        System.out.print(Arrays.toString(ans));
    }
}


 */

//----------------------------------------------------------------------------------------------------------------------


//Optimised Approach using hashmap
public class TwoSumProblem{
    public static int[] Sum(int[] arr, int target){
        int[] ans = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int result = target - arr[i];
            if(map.containsKey(result)){
                ans[0] = map.get(result);
                ans[1] = i;
                return ans;
            }
            map.put(arr[i],i);
        }
        return ans;
    }
    public static void main(String[] args) {
        int ans[] = {2,7,11,8,13,5,21};
        int target = 26;
        System.out.print(Arrays.toString(TwoSumProblem.Sum(ans,target)));

    }
}