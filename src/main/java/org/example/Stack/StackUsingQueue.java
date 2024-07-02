package org.example.Stack;

import java.util.LinkedList;
import java.util.Queue;

/*
Implement stack using single queue.
 */
public class StackUsingQueue {
    private Queue<Integer> queue = new LinkedList<>();


    public void push(int data){
        queue.add(data);
        for(int i=1;i<queue.size();i++){
            queue.add(queue.remove());
        }
    }
    public int pop(){
        return queue.remove();
    }

    public int peek(){
        return queue.peek();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }
    public static void main(String[] args) {
        StackUsingQueue stack = new StackUsingQueue();
        stack.push(3);
        stack.push(2);
        stack.push(4);
        stack.push(1);

        System.out.println(stack.peek());

    }
}
