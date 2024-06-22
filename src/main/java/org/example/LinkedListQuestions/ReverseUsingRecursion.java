package org.example.LinkedListQuestions;

/*
Reverse a Linked List Using a Recursive Method
 */
public class ReverseUsingRecursion {
    static Node head;
    static Node tail;
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

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

    public static void Display(){
        Node temp = head;
        if(head == null){
            System.out.println("list is empty");
            return;
        }
        while(temp!= null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void RecursiveReverse(Node node){
        if(node == tail){
            head = tail;
            return;
        }
        RecursiveReverse(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }

    public static void main(String[] args) {
        ReverseUsingRecursion LL = new ReverseUsingRecursion();
        LinkedListCreate(1);
        LinkedListCreate(2);
        LinkedListCreate(4);
        LinkedListCreate(5);
        LL.Display();
        RecursiveReverse(head);
        LL.Display();

    }
}
