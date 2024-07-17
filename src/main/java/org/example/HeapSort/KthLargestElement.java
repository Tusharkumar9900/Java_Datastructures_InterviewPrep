package org.example.HeapSort;

import java.util.PriorityQueue;

public class KthLargestElement {
    public static int kthelement(int arr[], int k){
        PriorityQueue<Integer> priorityqueue = new PriorityQueue<>();
        for(int i=0;i<k;i++){
            priorityqueue.add(arr[i]);
        }

        for(int i=k;i<arr.length;i++){
            if(priorityqueue.peek()<arr[i]){
                priorityqueue.poll();
                priorityqueue.add(arr[i]);
            }
        }
        return priorityqueue.peek();
    }

    public static void main(String[] args) {
int arr[] = {3,2,3,1,2,4,5,5,6};
int ans = KthLargestElement.kthelement(arr,4);
System.out.println(ans);
    }
}
