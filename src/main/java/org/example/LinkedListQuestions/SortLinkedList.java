package org.example.LinkedListQuestions;

/*
we have to sort the linked list 0's , 1's and 2's
Input:
N = 8
value[] = {1,2,2,1,2,0,2,2}
Output: 0 1 1 2 2 2 2 2
Explanation: All the 0s are segregated
to the left end of the linked list,
2s to the right end of the list, and
1s in between.
 */


public class SortLinkedList {
    static Node head;
    static Node tail;
    static class Node{
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

    public static void linkedlistcreate(int data){
        Node node = new Node(data);
        if(head == null){
            head = node;
            tail = node;
        }else{
            tail.next = node;
            tail = node;
        }
    }

    //using data replacement we are doing sorting in the linked list
    public static Node SortLinkedList(Node head){
        int onecount =0;
        int twocount =0;
        int zerocount =0;

        Node temp = head;
        while(temp != null){
            if(temp.data ==0){
                zerocount++;
            }
            else if(temp.data == 1)
            {
                onecount++;
            }
            else if(temp.data == 2)
            {
                twocount++;
            }
            temp= temp.next;
        }

        temp = head;
        while(temp != null){
            if(zerocount != 0){
                temp.data =0;
                zerocount--;
            }else if(onecount != 0){
                temp.data =1;
                onecount--;
            }else if(twocount != 0){
                temp.data = 2;
                twocount--;
            }
            temp = temp.next;
        }
        return head;
    }

    public static void display(){
        Node temp = head;
        if(head == null){
            System.out.print("empty list");
            return;
        }
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
    SortLinkedList sort = new SortLinkedList();
        linkedlistcreate(1);
        linkedlistcreate(2);
        linkedlistcreate(2);
        linkedlistcreate(1);
        linkedlistcreate(2);
        linkedlistcreate(0);
        linkedlistcreate(1);
        linkedlistcreate(2);
        linkedlistcreate(1);

        sort.display();

        SortLinkedList(head);
        sort.display();
    }
}
