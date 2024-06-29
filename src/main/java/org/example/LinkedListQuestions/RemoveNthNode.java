package org.example.LinkedListQuestions;

/*
 Given the head of a linked list, remove the nth node from the end of the list and return its head.

 Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
 */
public class RemoveNthNode {
    static Node head;
    static Node tail;
  static  class Node{
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

    public static void display(){
      Node temp = head;
        if(head == null){
            System.out.println("empty list");
            temp = temp.next;
        }
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    //now we going to make a method in which we are doing removing the Nth Node form end of the linked list
    public static Node RemoveNthFromEnd(Node head,int n){

      if(head == null){
          return null;
      }

      Node fast = head;
      Node slow = head;

      for(int i=0;i<n;i++){
          if(fast == null){
              return head;
          }
          fast =fast.next;
      }

      if(fast == null){
//          head = head.next;
          return head.next;
      }

      while(fast.next != null){
          slow = slow.next;
          fast = fast.next;
      }
      slow.next = slow.next.next;
      return head;
    }

    public static void main(String[] args) {
        RemoveNthNode ll = new RemoveNthNode();
        LinkedListCreate(1);
        LinkedListCreate(2);
        LinkedListCreate(3);
        LinkedListCreate(4);
        LinkedListCreate(5);
        //printing the linked list
        ll.display();

        RemoveNthFromEnd(head,2);
        ll.display();
    }
}
