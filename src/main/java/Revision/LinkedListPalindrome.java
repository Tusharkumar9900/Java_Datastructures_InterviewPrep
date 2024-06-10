package Revision;

/*
Given the head of a singly linked list, return true if it is a
palindrome or false otherwise.
Input: head = [1,2,2,1]
Output: true
 */
public class LinkedListPalindrome {
    //method to reverse the linked list which we have to reverse using iterative method
    public static class Node{
        int data;
        Node next;
        //creating constructor
     public Node(int data, Node next){
         this.data = data;
         this.next = next;
     }
        Node(int data) {
            this.data = data;
            this.next = null;
        }
          }

        public static Node reverselist(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node previous = null;
        Node present = head;
        Node next = present.next;

        while(present != null){
            present.next = previous;
            previous = present;
            present = next;
            if(next!= null){
                next = next.next;
            }
        }
        return previous;
          }

          public static Boolean isPalindrome(Node head){
        if(head == null || head.next == null){
            return true;
        }
        Node slow = head;
        Node fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        Node newhead = reverselist(slow.next);
        Node first = head;
        Node second = newhead;

        while(second != null){
            if(first.data != second.data){
                reverselist(newhead);
                return false;
            }

            first = first.next;
            second = second.next;
        }
        reverselist(newhead);
        return true;
          }

          //function to print the original linked list
    public static void printLinkedList(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
//        head.next = new Node(5);
        head.next = new Node(3);
        head.next.next = new Node(2);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(1);

        System.out.print("Original Linked List" + " ");
        printLinkedList(head);

        if(isPalindrome(head)){
            System.out.println("palindrome hai yeh");
        }else{
            System.out.println("nhi h yeh");
        }
    }
}
