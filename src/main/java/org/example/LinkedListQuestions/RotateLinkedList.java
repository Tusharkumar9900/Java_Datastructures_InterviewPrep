package org.example.LinkedListQuestions;

/*

Given a singly linked list of size N.
The task is to left-shift the linked list by k nodes,
where k is a given positive integer smaller than or equal to length of the linked list.

Input:
N = 5
value[] = {2, 4, 7, 8, 9}
k = 3
Output: 8 9 2 4 7

Explanation:
Rotate 1: 4 -> 7 -> 8 -> 9 -> 2
Rotate 2: 7 -> 8 -> 9 -> 2 -> 4
Rotate 3: 8 -> 9 -> 2 -> 4 -> 7

 */
public class RotateLinkedList {
    static Node head;
    static Node tail;
   public  static class Node{
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
            tail.next = node;
            tail = node;
        }
    }

    public void display(){
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

    public static Node rotateList(Node head, int k){
        if(head == null || head.next == null || k == 0){
            return head;
        }

        Node tail = head;
        int length = 1;
        while(tail.next!= null){
            tail = tail.next;
            length++;
        }
        //connecting last node with first node of linked list
        tail.next = head;
        k = k%length;
        int newlastNode = length-k;
        Node newtail = head;
        for(int i=1;i<newlastNode;i++){
            newtail = newtail.next;
        }

        head = newtail.next; //updating our head
        newtail.next = null;
        return head;
    }
    public static void main(String[] args) {
        RotateLinkedList ll = new RotateLinkedList();
        createlinkedlist(2);
        createlinkedlist(4);
        createlinkedlist(7);
        createlinkedlist(8);
        createlinkedlist(9);

        ll.display();

        //why we write this head = rotate(head,2)
        //When you perform the rotation,
        //the head of the list changes.
        //If you do not update the static head reference,the display method will still refer to the old head,
        //and the rotated list will not be displayed correctly.
        head =rotateList(head,2);
        ll.display();
    }
}
