package org.example.HeapSort;

import java.util.ArrayList;
import java.util.PriorityQueue;

/*
Problem statement ->
Given k sorted arrays arranged in the form of a matrix of size k * k. The task is to merge them into one sorted array.
Return the merged sorted array (as an ArrayList in java).

Examples :

Input: k = 3, arr[][] = {{1,2,3},{4,5,6},{7,8,9}}
Output: 1 2 3 4 5 6 7 8 9
Explanation: Above test case has 3 sorted arrays of size 3, 3, 3 arr[][] = [[1, 2, 3],[4, 5, 6],[7, 8, 9]].
The merged list will be [1, 2, 3, 4, 5, 6, 7, 8, 9].
 */
public class MergeKSortedArrays {

    // Node class representing an element in the heap, along with its position in the original arrays
    static class Heapnode implements Comparable<Heapnode> {
        int data;
        int i;  // Index of the array from which the element is taken
        int j;  // Index of the element within the array


        public Heapnode(int data, int i, int j) {
            this.data = data;
            this.i = i;
            this.j = j;
        }


        // Comparison method for the priority queue to maintain the min-heap property
        public int compareTo(Heapnode node)
        {
        return data -node.data;
        }

        // Getter for the value of the node
        public int getValue(){
            return data;
        }


        // Method to check if there is a next element in the same row of the matrix
        public boolean hasNext(int[][] arr){
            return j+1<arr[i].length;
        }


        // Method to get the next element in the same row of the matrix
        public Heapnode getNext(int[][] arr){
            return new Heapnode(arr[i][j+1],i,j+1);   // Return the next element in the row
        }
    }

    public static ArrayList<Integer> mergeKArrays(int[][] arr, int K)
    {
        //why we use Object like Heapnode here instead of wrapper class like Integer ->
        //we directly don't put the integer here, if we then we don't understand from which array the first element we get.
        //so we created a Heapnode class which implement the comparable.
        //and we use priorityqueue here because we want the smallest element first in new array, so min heap top element is the minimum element

        PriorityQueue<Heapnode> minheap = new PriorityQueue<Heapnode>();
        //Now we want the first element from every array
        for(int i=0;i<K;i++){
            if(arr[i].length>0){
                minheap.add(new Heapnode(arr[i][0],i,0));  // Add the first element of each array
            }
        }
        // List to store the final sorted elements
        ArrayList<Integer> list = new ArrayList<>();


        // Process the elements in the min-heap until it's empty
        while(!minheap.isEmpty()){
            Heapnode node = minheap.poll();  // Extract the smallest element from the heap
            list.add(node.getValue());   // Add the smallest element to the result list

            // If there is a next element in the same row, add it to the heap
            if(node.hasNext(arr)){
                minheap.add(node.getNext(arr));
            }
        }
        return list;
    }
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int k = 3; // Number of arrays

        // Call the mergeKArrays function and get the merged sorted list
        ArrayList<Integer> result = mergeKArrays(arr, k);

        // Print the merged sorted list
        System.out.println(result);
    }
}
