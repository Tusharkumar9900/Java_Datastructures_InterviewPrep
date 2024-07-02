package org.example.LinkedListQuestions;

/*
Problem Statement:

Given the heads of two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.


Input Format:
(Pointer/Access to the head of the two linked lists)

num1  = 243, num2 = 564

l1 = [2,4,3]
l2 = [5,6,4]

Result: sum = 807; L = [7,0,8]

Explanation: Since the digits are stored in reverse order,
reverse the numbers first to get the original number and then add them as → 342 + 465 = 807.
 */



public class AddTwoNumberLL {
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
            this.next = null;
        }

        public Node() {
        }
    }
    //creating as method for adding two number of linked list
    public Node addTwoNumber(Node list1,Node list2){
        Node dummy = new Node();
        Node temp = dummy;
        int carry =0;
        while(list1 != null || list2 != null || carry==1){
            int sum=0;
            if(list1 != null){
                sum = sum + list1.data;
                list1 = list1.next;
            }

            if(list2 != null){
                sum = sum + list2.data;
                list2 = list2.next;
            }

            sum = sum+ carry;
            carry = sum/10;
            int digit = sum %10;
            //create a node
            Node node = new Node(digit);
            temp.next = node;
            temp = temp.next;

        }
        return dummy.next;
    }
    public static void main(String[] args) {

    }
}
