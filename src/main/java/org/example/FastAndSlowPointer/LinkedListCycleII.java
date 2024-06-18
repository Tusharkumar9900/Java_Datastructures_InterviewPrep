package org.example.FastAndSlowPointer;



/*
Given the head of a linked list, return the node where the cycle begins.
If there is no cycle, return null.
There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle.
Note that pos is not passed as a parameter.

Do not modify the linked list.
 */
public class LinkedListCycleII {

  public static  Node head;
   public static Node tail;

    public static class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(int data) {
            this.data = data;
        }
    }
        //creating a linked list
        public static void linkedlistcreation(int data){
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
                System.out.println("List is Empty");
                return;
            }
            while(temp!= null){
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }

        public static Node linkedlistcycleII(Node head){
        Node fast = head;
        Node slow = head;
        Node temp = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }
        if(fast == null || fast.next == null){
            return null;
        }
        while(temp != slow){
            temp = temp.next;
            slow = slow.next;
        }
        return slow;
        }
    public static void main(String[] args) {
        LinkedListCycleII list = new LinkedListCycleII();
        list.linkedlistcreation(1);
        list.linkedlistcreation(2);
        list.linkedlistcreation(3);
        list.linkedlistcreation(4);

    }
}
