package org.example.LinkedListQuestions;

import java.util.HashSet;

/*
Given the head of a sorted linked list,
delete all duplicates such that each element appears only once. Return the linked list sorted as well.
 */
public class RemoveDuplicateLL {

    static Node head;
    static Node tail;


    public static class Node{
        Node next;
        int data;

        public  Node(Node next, int data) {
            this.next = next;
            this.data = data;
        }

        public Node(int data) {
            this.data = data;
            this.next = null;
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

    public void display(){
        Node temp = head;
        if(head == null){
            System.out.println("Empty Linked List");
            return;
        }

        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    //this method is for sorted Linked List
    //creating method to remove duplicate from linked list
    public static Node duplicateRemove(Node head){
        Node curr = head;
        if(curr == null){
            return curr;
        }
        while(curr.next != null){
            if(curr.data == curr.next.data){
                curr.next =curr.next.next;
            }else{
                curr = curr.next;
            }
        }
        return head;
    }

    //this method for unsorted Linked List using hashset method
    public static Node RemoveDuplicateUnsorted(Node head){
        HashSet<Integer> set = new HashSet<>();
        Node curr = head;
        Node previous = null;
        while(curr != null){
            if(set.contains(curr.data)){
                previous.next = curr.next;
            }else{
                set.add(curr.data);
                previous = curr;
            }
            curr = curr.next;
        }
        return head;
    }

    public static void main(String[] args) {
    RemoveDuplicateLL ll = new RemoveDuplicateLL();
    LinkedListCreate(1);
    LinkedListCreate(2);
    LinkedListCreate(4);
    LinkedListCreate(5);
    LinkedListCreate(3);
    LinkedListCreate(6);
    LinkedListCreate(4);
    LinkedListCreate(2);
    LinkedListCreate(5);

    //for displaying linked list
    ll.display();

    //for sorted Linked List
//    duplicateRemove(head);
//    ll.display();


    RemoveDuplicateUnsorted(head);
    ll.display();
    }
}
