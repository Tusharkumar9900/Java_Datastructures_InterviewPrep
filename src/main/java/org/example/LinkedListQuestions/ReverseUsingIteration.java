package org.example.LinkedListQuestions;


/*
Reversing a Linked List Using Iterative Method
Problem Statement :- Given the head of a singly linked list, write a program to reverse the linked list,
and return the head pointer to the reversed list.

Example:-
Input Format:

LL: 1   3   2   4

Output :
LL: 4   3   2   1
 */
public class ReverseUsingIteration {

    //creating head and tail for our linked list
    static Node head;
    static Node tail;


    //creating a Linked List
    static class Node{
        Node next;
        int data;

        //creating a constructor
        Node(int data){
            this.data = data;
            this.next = null;
        }

        public Node(Node next, int data) {
            this.next = next;
            this.data = data;
        }
    }

    //now we create a Linked List
    public static void LinkedListCreate(int data){
        Node node = new Node(data);
        if(head == null){
            head = node;
            tail = node;
        }else{
            tail.next = node;
            tail = node;
        }
    }

    //display method to display the Linked List
    public void display(){
        Node temp = head;
        if(head == null){
            System.out.println("List is Empty");
            return;
        }
        while(temp!= null){
            System.out.print(temp.data+ " ");
            temp = temp.next;
        }
        System.out.println();
    }


    //now we are doing our operation to reverse a linked list Using a Iterative Method
    public static void iterativeReverse(){
        Node previous = null;
        Node present = head;
        Node next = present.next;

        while(present!= null){
            present.next = previous;
            previous = present;
            present = next;
            if(next!= null){
                next = next.next;
            }
        }
        head = previous;
    }

    public static void main(String[] args) {
        ReverseUsingIteration LL = new ReverseUsingIteration();
        LL.LinkedListCreate(10);
        LL.LinkedListCreate(20);
        LL.LinkedListCreate(30);
        LL.LinkedListCreate(40);
        LL.LinkedListCreate(50);
        LL.LinkedListCreate(60);

        LL.display();

       iterativeReverse();

       LL.display();
    }
}
