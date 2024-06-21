package org.example.Stack;

/*
Implementing Stack using Array

Note: Stack is a data structure that follows the Last In First Out (LIFO) rule.
 */
public class StackUsingArray {
    int arr[];
    int top;
    int capacity;

    //creating constructor
    public StackUsingArray(int size){
        this.capacity = size;
        arr = new int[capacity];
        top =-1;
    }

    public  boolean isFull(){
        return top == capacity-1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public int size(){
        return top+1;
    }
    public void push(int data){
        if(isFull()){
            System.out.println("stack overflow");
            return ;
        }
        top++;
        arr[top] = data; //this line assign the "data" value to the position indicated by the top pointer
    }


    public void pop(){
        if(isEmpty()){
            System.out.println("Stack UnderFlow");
            return;
        }
        top--;
    }

    public void peek(){
        if(isEmpty()){
            System.out.println("underflow");
            return;
        }
        System.out.println(arr[top]);
    }


    public static void main(String[] args) {
        StackUsingArray stack = new StackUsingArray(100);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);

        System.out.println("Top of the stack before deleting any element");
        stack.peek();
        System.out.println("Size of the stack before deleting any element ");
        System.out.println(stack.size());
        System.out.println("The element deleted is ");
        stack.pop();
        System.out.println("Size of the stack after deleting an element " );
        System.out.println(stack.size());
        System.out.println("Top of the stack after deleting an element ");
        stack.peek();

    }
}
