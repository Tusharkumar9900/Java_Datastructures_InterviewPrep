package org.example.HeapSort;

public class HeapSortAlgorithm {
    static int arr[];  // Static array to store heap elements
    static int size;   // Static variable to track the current number of elements in the heap
    static int capacity;  // Static variable to track the maximum capacity of the heap


    // Constructor to initialize the heap with a given capacity
    HeapSortAlgorithm(int capacity){
        this.capacity = capacity;
        size =0;
        arr = new int[capacity]; // Create an array with the specified capacity
    }


    // Method to swap elements at indices i and j in the array
    public static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Method to maintain the heap property for a MAX HEAP
    public static void heapify(int arr[], int size, int i){
        int leftChild = 2*i +1;
        int rightChild = 2*i +2;
        int largest = i;  // Initialize largest as the root

        // If the left child is larger than the root
        if(leftChild <size && arr[leftChild] >arr[largest]){
            largest = leftChild;
        }

//        If the right child is larger than the largest so far
        if(rightChild<size && arr[rightChild] > arr[largest]){
            largest = rightChild;
        }

        // If largest is not root
        if(largest != i){
            swap(arr,i,largest); // Swap the root with the largest
            heapify(arr,size,largest);  // Recursively heapify the affected subtree
        }
    }

    // Method to perform heap sort on an array
    public static void heapsort(int arr[], int n){
        //heap creation
       for(int i=n/2-1;i>=0;i--){  // Initial Value: i = n / 2 - 1
        //   n / 2 gives the index of the first leaf node (since in a zero-indexed array, the leaf nodes start from n/2 to n-1).
        //   Subtracting 1 gives the index of the last non-leaf node.


           //Calls the heapify function on each non-leaf node,
           //ensuring that the subtree rooted at i satisfies the max heap property.
           heapify(arr,n,i);
       }
       //running loop from last,  One by one extract an element from heap
       for(int i=n-1;i>=0;i--){
           swap(arr,0,i); //swap first element with last element
           heapify(arr,i,0); //root node ko correct position pe le aoo yaani heapify function use krna h
       }
    }
    public static void display(int arr[], int n){
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
int arr[] = {54,53,55,52,50};
int n=arr.length;
heapsort(arr,n);
display(arr,n);
    }
}
