package org.example.HeapSort;


//in this code we are creating heap and insertion in heap using array
//the heap we working here is MAX HEAP.
public class Heap {
    static int arr[]; //array for storing the elements.
    static int size; //current no of element in heap.
    static int capacity;

    Heap(int capacity){
        this.capacity = capacity;
        size =0;
        arr = new int[capacity];
    }

    //we write left and right based on  zero based indexing
    static int parent(int index){
        return (index-1)/2;
    }
    static int left(int index){
        return 2*index+1;
    }
    static int right(int index){
        return 2*index+2;
    }

    public static void swap(int arr[],int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void Insert(int data){
        if(size == capacity){
            System.out.println("heap is overflow");
            return;
        }
        size++;
        int index = size-1;
        arr[index] = data;

        //fixing the MAX HEAP property
        while(index>0 && arr[parent(index)]<arr[index]){
            swap(arr,index,parent(index));
            index = parent(index);
        }

        /*

        //Fixing the MIN HEAP property
        while(index>0 && arr[parent(index)]>arr[index]){
        swap(arr,index,parent(index));
        index = parent(index);
        }

         */
    }

    //delete operation , we have to delete a node then we can do -
    //which node(here we are deleting first node or we can say root node) we have to delete take it place it at the end and delete the last node
    public static void Delete(){
        //check our condition
        if(size == 0){
            System.out.println("Nothing to delete");
            return;
        }

//        step 1- Replace the root of the heap with the last element
        arr[0] = arr[size-1];
        size--;

        int index =0;
        while(index<size){
            int leftIndex = left(index);
            int rightIndex = right(index);
            int largest = index;

            if(leftIndex<size && arr[leftIndex]>arr[largest] ){
                largest = leftIndex;
            }
            if(rightIndex<size && arr[rightIndex]>arr[largest]){
                largest = rightIndex;
            }
         if(largest != index){
             swap(arr,index,largest);
             index = largest;
         }else{
             break;
         }
        }

    }

    public static void main(String[] args) {
     Heap heap = new Heap(100);
     int arr[] = {50, 55, 53, 52, 54};


        for(int value : arr){
            heap.Insert(value);
        }

        // Print the heap array
        for(int i = 0; i < heap.size; i++){
            System.out.print(heap.arr[i] + " ");
        }


        heap.Delete();

        // Print the heap array after deletion
        System.out.print("Heap after deleting max: ");
        for(int i = 0; i < heap.size; i++){
            System.out.print(heap.arr[i] + " ");
        }
    }
}