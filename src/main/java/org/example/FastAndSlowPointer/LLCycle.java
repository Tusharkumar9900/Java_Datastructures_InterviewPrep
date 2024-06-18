package org.example.FastAndSlowPointer;

/*

Given head, the head of a linked list, determine if the linked list has a cycle in it.
There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.
 */
public class LLCycle {
    private static Node head;
    private static Node tail;
    private static int size;

    public LLCycle(){
        this.size =0;
    }
    private static  class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(int data) {
            this.data = data;
        }
    }

        /*
        //this method is used to add node at very first when linked list is given
        public void insertFirst(int data){
            //create a first node
            Node node = new Node(data);

//            Make next of new Node as head
            node.next = head;
//            Move the head to point to new Node
            head = node;

            if(tail == null){
                tail = head;
            }
        }

         */

        //now this method is where we create a linked list
        public static void linkedlistcreation(int data){
            Node node = new Node(data);
            if(head == null){
                head = node;
                tail = node;
            }else{
                tail.next = node; // Link the new node at the end of the list
                tail = node; // Update the tail to point to the new node
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

        //after creating linked list we are going to find the linked cycle presnt there on not
    public static boolean hasCycle(Node head){
            Node fast = head;
            Node slow = head;

//            if(head == null){
//                return;
//            }
            while(fast != null && fast.next != null){
                fast = fast.next.next;
                slow = slow.next;
                if(fast == slow){
                    return true;
                }
            }
return false;
    }

    public static void main(String[] args) {
        LLCycle list = new LLCycle();
        list.linkedlistcreation(3);
        list.linkedlistcreation(2);
        list.linkedlistcreation(0);
        list.linkedlistcreation(-4);

        list.display();
        if(hasCycle(head)) {
            System.out.print("loop found");
        }else{
            System.out.println("No loop");
        }

    }
}
