package org.example.HeapSort;


import java.util.Collections;
import java.util.PriorityQueue;

/*
Median in a Stream :-
Given an input stream of N integers.
The task is to insert these numbers into a new stream
and find the median of the stream formed by each insertion of X to the new stream.


Example 1:

Input:
N = 4
X[] = 5,15,1,3
Output:
5
10
5
4

Explanation:Flow in stream : 5, 15, 1, 3
5 goes to stream --> median 5 (5)
15 goes to stream --> median 10 (5,15)
1 goes to stream --> median 5 (5,15,1)
3 goes to stream --> median 4 (5,15,1 3)


 */

public class MedianInStream {
   private PriorityQueue<Integer> maxheap;
   private PriorityQueue<Integer> minheap;

   public  MedianInStream(){
       maxheap = new PriorityQueue<>(Collections.reverseOrder());
       minheap = new PriorityQueue<>();
   }

   public void addNum(int num){
       if(maxheap.isEmpty() || maxheap.peek()>=num)
       {
           maxheap.add(num);
       }
       else
       {
           minheap.add(num);
       }

       if(maxheap.size()>minheap.size()+1){
           minheap.add(maxheap.poll());
       }else if(maxheap.size()<minheap.size()){
           maxheap.add(minheap.poll());
       }

   }

   public double findMedian(){
       if(maxheap.size() == minheap.size()){
           return maxheap.peek()/2.0 + minheap.peek()/2.0;
       }
       return maxheap.peek();
   }
    public static void main(String[] args) {
        MedianInStream medianstream = new MedianInStream();
        medianstream.addNum(1);
        medianstream.addNum(2);
        System.out.println("The median of number is : "+ medianstream.findMedian());
        medianstream.addNum(3);
        System.out.println("The median of number is : "+ medianstream.findMedian());

    }
}
