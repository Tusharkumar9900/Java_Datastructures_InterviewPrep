package org.example.Stack;

public class StackUsingLinkedList {
    public static class Node{
        Node next;
        int data;

        //creating a constructor
        Node(int data){
            this.data= data;
            next = null;
        }
    }


    public static Node head;
    public static boolean isEmpty(){
        return head == null;
    }

    public static void push(int data){
        Node newNode = new Node(data);
        if(isEmpty()){
            head = newNode;
            return;
        }
        //in this case already exist linked list and we are adding a new Node in our Linked List
        //our New Node point to head of as linked List which is exist using newNode.next = head
        newNode.next = head;
        //now we move our head to newNode which we add in our linked List
        head = newNode;
    }
//pop function in java delete our top element and also return that deleted element
    public static int pop(){
        //handling test case if there is no element in linked list
        if(isEmpty()){
            return -1;
        }
        //through ths we get the top element of our linked list
        int top = head.data;
        //now we have to delete that element by move the head
        head = head.next;
        return top;
    }

    public static int peek(){
        if(isEmpty()){
            return -1;
        }
        return head.data;
    }
    public static void main(String[] args) {
       StackUsingLinkedList stack = new StackUsingLinkedList();
       stack.push(10);
       stack.push(12);
       stack.push(15);
       stack.push(18);

       while(!stack.isEmpty()){
           System.out.println(stack.peek());
           stack.pop();
       }

    }
}
