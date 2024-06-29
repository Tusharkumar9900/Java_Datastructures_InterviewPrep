package org.example.LinkedListQuestions;

/*
Problem Statement: Given the head of a linked list of integers,
delete the middle node of the linked list and return the modified head. However, if the linked list has an even number of nodes, delete the second middle node.

Input Format:
LL: 1  2  3  4  5
Output: 1 2 4 5
Explanation: Node with value 3 is at the middle node and deleted.
 */
public class DeleteMiddle {
    static Node head;
    static Node tail;
    static class Node{
        Node next;
        int data;

        //creating constructor

        public Node(Node next, int data) {
            this.next = next;
            this.data = data;
        }

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void createLinkedList(int data){
        Node node = new Node(data);
        if(head == null){
            head = node;
            tail = node;
        }else{
            tail.next = node;
            tail = node;
        }
    }

    public static void display(){
        Node temp = head;
        if(head == null){
            System.out.println("Empty list");
            return;
        }
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    //method for delete middle of a linked list
    public static Node DeleteMiddle(Node head){
        if(head == null && head.next == null){
            return null;
        }
        Node fast = head;
        Node slow = head;

        fast = fast.next.next;

        while(fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;
        return head;

    }
    public static void main(String[] args) {
        DeleteMiddle ll = new DeleteMiddle();
        createLinkedList(1);
        createLinkedList(2);
        createLinkedList(3);
        createLinkedList(4);
        createLinkedList(5);
//        createLinkedList(6);

        display();

        ll.DeleteMiddle(head);
        display();
    }
}
