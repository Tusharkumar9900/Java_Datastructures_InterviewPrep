package org.example.LinkedListQuestions;

/*
LeetCode Question Number - 138.
Copy List with Random Pointer
problem statement :-
                     A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.
Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node.
Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state.
None of the pointers in the new list should point to nodes in the original list.
For example, if there are two nodes X and Y in the original list,
where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.

Return the head of the copied linked list.

The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
Your code will only be given the head of the original linked list.




Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 */
public class CopyLinkedList {
    public static class Node{
        Node next;
        int val; // instead of data we took val
        Node random; // random pointer

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        public Node(Node next, int val) {
            this.next = next;
            this.val = val;
        }

    }
    public Node copyRandomList(Node head) {
        // if(head == null || head.next == null){
        //     return head;
        // }
        //original list -> temp1 and copy list -> temp2

        Node head2 = new Node(0); //new node extra to help me get nodes
        Node temp1 = head; //original list head and temp1 pointing over the head
        Node temp2 = head2; // for traversing over copy list
        while(temp1 != null){
            Node t = new Node(temp1.val);
            temp2.next = t;
            temp2 = t;
            temp1 = temp1.next;
        }
        head2 =  head2.next;
        temp2 = head2;
        temp1 = head; //putting back to original place

        //step -2 creating alternate connections
        Node temp = new Node(0);
        while(temp1!= null){
            temp.next = temp1;
            temp1 = temp1.next;
            temp = temp.next;

            temp.next = temp2;
            temp2 = temp2.next;
            temp = temp.next;
        }
        temp2 = head2;
        temp1 = head;

        //assigning random pointer
        while(temp1!= null ){
            if(temp1.random == null){
                temp2.random = null;
            }else{
                temp2.random= temp1.random.next;
            }

            temp1 = temp2.next;
            if(temp1!= null){
                temp2 = temp1.next;
            }
        }


        //assigning temps to there original places
        temp2 = head2;
        temp1 = head;
        //step -4
        while(temp1 != null){
            temp1.next = temp2.next;
            temp1 = temp1.next;
            if(temp1== null)break;
            temp2.next = temp1.next;
            if(temp2.next == null)break;
            temp2 = temp2.next;
        }

        return head2;
    }
}
