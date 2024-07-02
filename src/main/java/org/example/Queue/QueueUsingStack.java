package org.example.Queue;


/*

Problem Statement: Given a Stack having some elements stored in it. Can you implement a
Queue using the given Stack?

Queue:    A Queue is a linear data structure that works on the basis of FIFO(First in First out).
          This means the element added at first will be removed first from the Queue.
 */


import java.util.Stack;

public class QueueUsingStack {
    //Implement Stack using Collection Framework
   static Stack<Integer> stack1 = new Stack<>();
   static Stack<Integer> stack2 = new Stack<>();

   //Created a Empty method
    public static boolean isEmpty(){
        return stack1.isEmpty();
    }
    //operation of adding the element
    public static void add(int data){
        while(!stack1.isEmpty()){
            //we pop the element from stack1 and push it to the stack2
            //for example stack1 contain 2 1 then we pop it and push it toh the stack2 like 1 2
            stack2.push(stack1.pop());
        }

        stack1.push(data);
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }

    public static int remove(){
        if(isEmpty()){
            System.out.println("empty queue");
            return -1;
        }
        return stack1.pop();
    }

public static int peek(){
      if(isEmpty()){
          System.out.println("empty queue");
          return -1;
      }
      return stack1.peek();
}


    public static void main(String[] args) {
    QueueUsingStack queue = new QueueUsingStack();
    queue.add(1);
    queue.add(2);
    queue.add(5);
    queue.add(4);

    while(!queue.isEmpty()){
       System.out.print(queue.peek()+" ");
       queue.remove();
    }
    }
}
