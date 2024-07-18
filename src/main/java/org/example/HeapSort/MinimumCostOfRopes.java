package org.example.HeapSort;

import java.util.PriorityQueue;

/*
Minimum Cost of  Ropes ->
There are given N ropes of different lengths,
we need to connect these ropes into one rope.
The cost to connect two ropes is equal to sum of their lengths.
The task is to connect the ropes with minimum cost.
Given N size array arr[] contains the lengths of the ropes.

Example ->
Input:
n = 4
arr[] = {4, 3, 2, 6}
Output:
29
Explanation:
We can connect the ropes in following ways.
1) First connect ropes of lengths 2 and 3.
Which makes the array {4, 5, 6}. Cost of
this operation 2+3 = 5.
2) Now connect ropes of lengths 4 and 5.
Which makes the array {9, 6}. Cost of
this operation 4+5 = 9.
3) Finally connect the two ropes and all
ropes have connected. Cost of this
operation 9+6 =15
Total cost for connecting all ropes is 5 + 9 + 15 = 29. This is the optimized cost for connecting ropes.
Other ways of connecting ropes would always have same or more cost.
For example, if we connect 4 and 6 first (we get three rope of 3, 2 and 10),
then connect 10 and 3 (we get two rope of 13 and 2).
Finally, we connect 13 and 2. Total cost in this way is 10 + 13 + 15 = 38.
 */
public class MinimumCostOfRopes {
    public static int minimumcost(int arr[]){
        //using priorityqueue because pq implements Min heap.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //traversing the array
        for(int length: arr){
            pq.add(length);
        }
        //for storing the answer
        int answer =0;
        while(pq.size()>1){
            int firstsum =pq.poll();
            int secondsum = pq.poll();

            int sum = firstsum + secondsum;

            answer = answer + sum;

            pq.add(sum);
        }
        return answer;
    }
    public static void main(String[] args) {
        int arr[] = {4, 3, 2, 6};

        int result = minimumcost(arr);
        System.out.println(result);
    }
}
