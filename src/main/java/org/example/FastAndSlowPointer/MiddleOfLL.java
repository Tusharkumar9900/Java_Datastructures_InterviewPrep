package org.example.FastAndSlowPointer;

public class MiddleOfLL {
    public static class Node{
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node MiddleLinkedList(Node head){
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    public static Node head = null;
    public static Node tail = null;


    public void insertLinkedList(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }

    }
    public static void main(String[] args) {
//     Node head = new Node(1);
//     head.next = new Node(2);
//     head.next.next = new Node(3);
//     head.next.next.next = new Node(4);
        MiddleOfLL List = new MiddleOfLL();
        List.insertLinkedList(1);
        List.insertLinkedList(2);
        List.insertLinkedList(3);
        List.insertLinkedList(4);
        List.insertLinkedList(5);

    Node middleNode = MiddleLinkedList(head);
    System.out.println(middleNode.data);
    }
}
