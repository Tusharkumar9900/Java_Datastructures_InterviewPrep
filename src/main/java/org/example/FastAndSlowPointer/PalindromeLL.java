package org.example.FastAndSlowPointer;

public class PalindromeLL {
    static Node head;
    static Node tail;
    public static class Node{
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

    public static void LinkedListCreation(int data){
        Node node = new Node(data);
        if(head == null){
            head = node;
        }
       else{
           tail.next = node;
           tail = node;
        }
    }

    public void dislapy(){
        Node temp = head;
        if(head == null){
            System.out.print("list is empty");
        }
        while(temp!= null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }


    //for palindrome first we have to reverse a linked list which we half of the linked list reverse
    public static Node reverseLLUsingIterative(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node previous = null;
        Node present = head;
        Node next = present.next;

        while(present!= null){
            present.next = previous;
            previous = present;
            present = next;
            if(next != null){
                next = next.next;
            }
        }
        return previous;
    }



    //now we are going to check is our given Linked List is palindromic or Not
    //first we start slow and fast pointer

    public static boolean isPalindrome(Node head){
        if(head == null || head.next == null){
            return true;
        }
        //here we are going to run fast and slow pointer
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //ek nya head jo slow k agge se chlega
        Node newhead = reverseLLUsingIterative(slow.next);
        Node first = head;
        Node second = newhead;
        while(second != null){
            if(first.data != second.data){
                //agr same nhi h toh jo reverse kri h linked list half usko normal krdo reverse se hi  ar return false krdo
                reverseLLUsingIterative(newhead);
                return false;
            }

            first = first.next;
            second = second.next;
        }
        reverseLLUsingIterative(newhead);
return true;

    }

    public static void main(String[] args) {

    }
}
