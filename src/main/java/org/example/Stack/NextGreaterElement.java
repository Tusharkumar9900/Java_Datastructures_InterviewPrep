package org.example.Stack;

/*

Problem Statement:
                     Given a circular integer array A, return the next greater element for every element in A.
                     The next greater element for an element x is the first element greater than x that we come across while traversing the array in a clockwise manner.
                     If it doesn't exist, return -1 for this element.

Example 1:

Input: N = 11, A[] = {3,10,4,2,1,2,6,1,7,2,9};
Output: 10,-1,6,6,2,6,7,7,9,9,10

Explanation: For the first element in A ,i.e, 3, the greater element which comes next to it while traversing and is closest to it is 10.
Hence,10 is present on index 0 in the resultant array.
Now for the second element,i.e, 10, there is no greater number and hence -1 is it’s next greater element (NGE).
Similarly, we got the NGEs for all other elements present in A.

Example 2:

Input:  N = 6, A[] = {5,7,1,7,6,0}
Output: 7,-1,7,-1,7,5

 */

import java.util.Stack;
//in this when single array is given ->
public class NextGreaterElement {

    public static int[] nextGreaterElements(int[] arr) {

        int n = arr.length;
        int nge[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=n-1;i>=0;i--)
        {
        while(!stack.isEmpty() && stack.peek()<= arr[i])
        {
        stack.pop();
        }
        if(i<n) {
            if (!stack.isEmpty()) {
                nge[i] = stack.peek();
            }else{
                nge[i] = -1;
            }
        }
        stack.push(arr[i]);

}
        return nge;
    }
    public static void main(String[] args) {
        int arr[]={5,7,1,2,6,0};
        int arr2[] = nextGreaterElements(arr);
        System.out.println("The next greater elements are ");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
    }
}
