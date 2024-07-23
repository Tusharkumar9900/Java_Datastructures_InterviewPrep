package org.example.HeapSort;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
Problem statement ->

Given two integer array A and B of size N each.
        A sum combination is made by adding one element from array A and another element of array B.
        Return the maximum K valid sum combinations from all the possible sum combinations.

        Note : Output array must be sorted in non-increasing order.


Example 1:

Input:
N = 2
K = 2
A [ ] = {3, 2}
B [ ] = {1, 4}
Output: {7, 6}
Explanation:
7 -> (A : 3) + (B : 4)
6 -> (A : 2) + (B : 4)

 */
public class MaximumSumCombination {

    public static List<Integer> maxCombinations(int N, int K, int A[], int B[]){
        List<Integer> list = new ArrayList<>();
        Arrays.sort(A);
        Arrays.sort(B);

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // min heap implement
        for(int i=N-1;i>N-1-K;i--){
            for(int j=N-1;j>N-1-K;j--){
                int sum = A[i]+B[j];
                if(pq.size()<K){
                    pq.add(sum);
                }else if(sum>pq.peek()){
                    pq.poll();
                    pq.add(sum);
                }else{
                    break;
                }
            }
        }
        //traverse over the priorityqueue and transfer this priority into list
        while(pq.size()>0 && K>0){
            list.add(0, pq.poll());
        }
        return list;
    }
    public static void main(String[] args) {
    int A[] = {2,4,1,3};
    int B[] = {5,1,6,2};
    System.out.println(maxCombinations(4,3,A,B));
    }
}
