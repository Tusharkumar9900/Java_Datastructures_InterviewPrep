package org.example.HeapSort;

/*
Problem statement ->
Given an integer array nums and an integer k,
return the k most frequent elements. You may return the answer in any order.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
 */


//------------------------------------------------------------------------------


/*
import java.sql.Array;
import java.util.*;

//Brute Force Solution -> Using HasMap
//First we Iterate Over the array and store each element in the hashmap
// and then we iterate in the hashmap in frequency and store the frequency and integer in resultant arraylist.
//afterward we sort them and return the top k element
public class topKFrequentElements {
    public static int[] topKFrequent(int[] arr, int k){
        HashMap<Integer, Integer> map = new HashMap<>();

        //traversing over the array and store the element in hashmap
        for(int n : arr){
            map.put(n, map.getOrDefault(n,0)+1);
        }

        //creating a list of map entries
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        //now we sort the list based on the frequency in descending order
        list.sort((a,b)->b.getValue()-a.getValue());

        //extract the top k frequent element
        int[] result = new int[k];
        for(int i=0;i<k;i++){
            result[i]= list.get(i).getKey();
        }
        return result;

    }
    public static void main(String[] args) {
int arr[] = {1,1,1,2,2,3,3};
int k =2;
       int[] ans = topKFrequent(arr,k);
       System.out.println(Arrays.toString(ans));
    }
}


 */


//----------------------------------------------------------------------------------------------------------

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

//better approach using heap sort - maxheap
public class topKFrequentElements {
    public static int[] topKFrequent(int[] arr, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : arr){
            if(map.containsKey(num)){
                map.put(num,map.getOrDefault(num,0)+1);
            }else{
                map.put(num,1);
            }
        }

        //create a priorityqueue to sort the elements based on their frequencies
        PriorityQueue<Integer> priorityqueue = new PriorityQueue<>((a,b)->map.get(b)-map.get(a));

        //add element in the priority queue
        priorityqueue.addAll(map.keySet()); //by using keyset we can add all elements without for loop

        // Step 4: Extract top k elements
        int[] topElements = new int[k];
        for (int i = 0; i < k; i++) {
            topElements[i] = priorityqueue.poll();
        }

        return topElements;
    }
    public static void main(String[] args) {
int arr[] = {1,1,1,2,2,3};
int k =2;

int[] ans = topKFrequent(arr,k);
System.out.println(Arrays.toString(ans));
    }
}