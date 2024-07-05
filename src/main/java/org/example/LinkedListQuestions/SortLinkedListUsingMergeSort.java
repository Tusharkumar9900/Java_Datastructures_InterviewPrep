package org.example.LinkedListQuestions;

import org.example.FastAndSlowPointer.MiddleOfLL;

/*

Given the head of a linked list, return the list after sorting it in ascending order.

we going to sort a linked list using a merge sort algorithm
Input: head = [4,2,1,3]
Output: [1,2,3,4]
 */
public class SortLinkedListUsingMergeSort {
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

    public static void creatinglinkedlist(int data){
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

    public static Node findmiddle(Node head){
        Node fast = head.next; // doing this so we can took the left element of the linked list in even number of linked list
        Node slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node merge2LinkedList(Node list1,Node list2){
        // Create a dummy node to serve
        // as the head of the merged list
        Node dummynode = new Node(-1);
        //creating a temp for traversing
        Node temp = dummynode;
        // Traverse both lists simultaneously
        while(list1 != null && list2 != null){
            //we are not creating a new linked, we are just pointing our dummy node to the smallest node of list1 or list2
            // Compare elements of both lists and
            // link the smaller node to the merged list
            if(list1.data<=list2.data){
                temp.next=list1;
                list1 = list1.next;
            }else{
                temp.next = list2;
                list2 = list2.next;
            }
            // Move the temporary pointer
            // to the next node
            temp = temp.next;
        }
        // If any list still has remaining
        // elements, append them to the merged list
        if(list1 != null){
            temp.next = list1;
        }else{
            temp.next = list2;
        }
        // Return the merged list starting
        // from the next of the dummy node
        return dummynode.next;
    }


    public static Node sortLinkedList(Node head){
        if(head == null || head.next == null){
            return head;
        }
        // Find the middle of the list
        // using the findMiddle function
        Node middle = findmiddle(head);


        Node righthead = middle.next;
        middle.next = null;
        Node lefthead = head;


        // Recursively sort the left and right halves
        lefthead = sortLinkedList(lefthead);
        righthead = sortLinkedList(righthead);

        return merge2LinkedList(lefthead,righthead);
    }

    public static void main(String[] args) {
        SortLinkedListUsingMergeSort ll = new SortLinkedListUsingMergeSort();
        creatinglinkedlist(4);
        creatinglinkedlist(2);
        creatinglinkedlist(1);
        creatinglinkedlist(3);
//        creatinglinkedlist(5);

        ll.display();

        head =sortLinkedList(head);
        ll.display();
    }
}
