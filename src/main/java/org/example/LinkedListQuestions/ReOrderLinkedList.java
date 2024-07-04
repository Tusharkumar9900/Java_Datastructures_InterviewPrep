package org.example.LinkedListQuestions;

/*

You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

Input: head = [1,2,3,4]
Output: [1,4,2,3]
 */

//algorithm for this question ->>
// first we are going to find the middle of the linked list using slow and fast pointer and then reverse the second half of the linked list
//then we are using start and end pointer  start from head and end pointer put after reversing linked list and put the element of the linked one by one
//from start and end.(meaning -> Do alternate merge of first and second halves.)
public class ReOrderLinkedList {

    //creating head and tail for our linked list
    static Node head;
    static Node tail;
    //creating a Node class for our linked list
    public static class Node{
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

    //creating a method for creating a Linked List
    public static void LinkedListCreation(int data){
        Node node = new Node(data);
        if(head == null){
            head = node;
            tail = node;
        }else{
            tail.next = node;
            tail = node;
        }
    }

    //method for displaying the linked list
    public void display(){
        Node temp = head;
        if(head == null){
            System.out.println("Empty List");
            return;
        }
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    //reverse method of linked list  using iterative method
    public static Node reverseLinkedList(Node head){
        if(head == null || head.next == null){
            return head;
        }

        Node previous = null;
        Node present = head;
        Node next = present.next;

        while(present!= null){
            present.next = previous;
            previous = present;
            present = next;
            if(next != null){
                next = next.next;
            }
        }
        return previous;
    }
    //for find middle of the linked list adn reversing the second-half of the linked list
    public static void ReorderLinkedList(Node head){
        if(head == null || head.next == null){
            return;
        }
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null){
            fast= fast.next.next;
            slow = slow.next;
        }
        //now after finding middle of the linked list we are going to call the reverse method for reversing the second half of the linked list.
        Node newhead = reverseLinkedList(slow.next);


        Node headFirst = head;
        Node headSecond = newhead;

        while(headFirst != null && headSecond != null){
            Node temp = headFirst.next;
            headFirst.next = headSecond;
            headFirst = temp;
            temp = headSecond.next;
            headSecond.next = headFirst;
            headSecond = temp;
        }
        if(headFirst != null){
            headFirst.next = null;
        }

    }
    public static void main(String[] args) {
        ReOrderLinkedList ll = new ReOrderLinkedList();
        LinkedListCreation(1);
        LinkedListCreation(2);
        LinkedListCreation(3);
        LinkedListCreation(4);
        LinkedListCreation(5);

        ll.display();

        ReorderLinkedList(head);
        ll.display();

    }
}
