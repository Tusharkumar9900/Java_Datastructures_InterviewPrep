package org.example.FastAndSlowPointer;

public class IntersectionOfTwoLL {
    static Node head1;
    static Node tail1;
    static Node head2;
    static Node tail2;


    static class Node{
        int data;
        Node next;

        //creating constructor

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }


    public static void createLinkedList1(int data){
        Node node1 = new Node(data);

        if(head1 == null){
            head1 = node1;
            tail1 = node1;
        }else{
            tail1.next = node1;
            tail1 = node1;
        }
    }

    public static void createLinkedList2(int data){
        Node node2 = new Node(data);
        if(head2 == null){
            head2 = node2;
            tail2 = node2;
        }else{
            tail2.next = node2;
            tail2 = node2;
        }
    }


    public static  void displayLinked1(){
        Node temp = head1;
        if(head1 == null){
            System.out.println("Empty List");
            return;
        }
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void displayLinked2(){
        Node temp = head2;
        if(head2 == null){
            System.out.println("Empty List");
            return;
        }
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    //first we get the difference
    public static int differenceoflinkedlist(Node head1, Node head2){
    int lengthOfLinkedList1 =0;
    int lengthOfLinkedList2 =0;

        Node temp1 = head1;
        Node temp2 = head2;
        while(temp1 != null || temp2 != null){
        if(temp1 != null){
            lengthOfLinkedList1++;
            temp1 = temp1.next;
        }
        if(temp2 != null){
            lengthOfLinkedList2++;
            temp2 = temp2.next;
        }
    }
        return lengthOfLinkedList1-lengthOfLinkedList2;
}

    //now according to question we have tyo find the intersection of the linked list
    public static Node IntersectionOfLinkedList(Node head1, Node head2){
        int difference = differenceoflinkedlist(head1,head2);
        if(difference<0) {
            while (difference++ != 0)
                head2 = head2.next;
        }
        else{
                while(difference-- != 0)
                    head1 = head1.next;
            }
        while(head1 != null){
            if(head1 == head2)
                return head1;

            head2 = head2.next;
            head1 = head1.next;
        }
        return head1;
    }

    public static void main(String[] args) {
        IntersectionOfTwoLL ll = new IntersectionOfTwoLL();
        createLinkedList1(1);
        createLinkedList1(3);
        createLinkedList1(1);

        // Create a common intersection node
        Node common = new Node(2);
        tail1.next = common;
        tail1 = common;
        createLinkedList1(4);

        createLinkedList2(3);
        tail2.next = common; // Linking the second list to the intersection node

//        createLinkedList1(2);
//        createLinkedList1(4);
//
//
//        createLinkedList2(3);
//        createLinkedList2(2);
//        createLinkedList2(4);

        //Now displaying both the linked list
        displayLinked1();
        displayLinked2();

       Node answer =  IntersectionOfLinkedList(head1,head2);
        if(answer == null){
            System.out.println("no Intersection");
        }else{
            System.out.print(answer.data);
        }

    }
}
