package org.example.LinkedListQuestions;

public class SwapPairs {
    static Node head;
    static Node tail;
    public static class Node{
        Node next;
        int data;
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

    public static Node pairwiseSwap(Node head)
    {
        // code here
        if(head == null || head.next == null){
            return head;
        }

        Node dummyNode = new Node(-1);
        dummyNode.next = head;
        Node dummyPointer = dummyNode; // we are using the pointer over the dummy node
        while(dummyPointer.next != null && dummyPointer.next.next != null)
        {
            Node temp1 = dummyPointer.next;
            Node temp2 = dummyPointer.next.next;

            temp1.next=temp2.next;
            temp2.next = temp1;
            dummyPointer.next = temp2;
            dummyPointer = temp1; //moving our dummyNode pointer to ahead over the temp1
        }
        return dummyNode.next;
    }
    public static void main(String[] args) {
        SwapPairs ll = new SwapPairs();
        LinkedListCreate(1);
        LinkedListCreate(2);
        LinkedListCreate(3);
        LinkedListCreate(4);
        LinkedListCreate(5);

        ll.display();


        head = pairwiseSwap(head); // here we are updating our head after swapping
        ll.display();
    }
}
