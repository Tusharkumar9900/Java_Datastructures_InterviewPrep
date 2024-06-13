package Revision.Algorithms;

/*
key point to remember :- Take an element and place it in its correct order
 Asked in companies :- Microsoft, MAQ Software, Juniper Networks, Cisco, Accenture, Dell, Veritas, Grofers
 */
public class InsertionSort {
    public static void insertionsort(int arr[]){
        for(int i=0;i<=arr.length-1;i++){
           int  j=i;
            while(j>0 && arr[j-1]> arr[j]){
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
        System.out.println("after insertion sort ");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args) {
    int arr[] = {13, 46, 24, 52, 20, 9};
        insertionsort(arr);
    }
}
