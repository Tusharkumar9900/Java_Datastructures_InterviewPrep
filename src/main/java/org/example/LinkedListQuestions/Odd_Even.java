package org.example.LinkedListQuestions;
/*
odd even linked list
in this we have to rearrange the linked list based on indexes firstly we have to put the odd one out afterward even.
Problem Statement:
Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

The first node is considered odd, and the second node is even, and so on.

Note that the relative order inside both the even and odd groups should remain as it was in the input.

You must solve the problem in O(1) extra space complexity and O(n) time complexity.

Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]
 */
public class Odd_Even {
    static Node head;
    static Node tail;
    public static class Node{
        Node next;
        int data;

        public Node(Node next, int data) {
            this.next = next;
            this.data = data;
        }

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void createlinkedlist(int data){
        Node node = new Node(data);
        if(head == null){
            head = node;
            tail = node;
        }else{
            tail.next=node;
            tail = node;
        }
    }

    public void display(){
        Node temp = head;
        if(head == null){
            System.out.print("Empty list");
           return;
        }
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static Node oddEvenList(Node head) {
        if(head == null || head.next == null){
            return head;
        }
        Node odd = head;
        Node even = head.next;
        Node evenhead = head.next;

        while(even != null && even.next != null){
            odd.next = odd.next.next;
            even.next = even.next.next;


            odd = odd.next;
            even = even.next;
        }
        odd.next = evenhead;
        return head;
    }
    public static void main(String[] args) {
        Odd_Even ll = new Odd_Even();
        createlinkedlist(2);
        createlinkedlist(3);
        createlinkedlist(1);
        createlinkedlist(4);
        createlinkedlist(5);
        createlinkedlist(6);
        ll.display();

        oddEvenList(head);
        ll.display();
    }
}
