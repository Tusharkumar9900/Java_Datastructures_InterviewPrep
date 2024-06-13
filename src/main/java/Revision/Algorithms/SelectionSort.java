package Revision.Algorithms;

/*
Selection sort algorithm :-
                          Selection sort is a simple and efficient sorting algorithm
                          that works by repeatedly selecting the smallest (or largest) element
                          from the unsorted portion of the list and moving it to the sorted portion of the list.

                          Selection sort is generally used when -

                                                       A small array is to be sorted
                                                       Swapping cost doesn't matter
                                                       It is compulsory to check all elements

Example 1:
Input: N = 6, array[] = {13,46,24,52,20,9}
Output: 9,13,20,24,46,52
Explanation: After sorting the array is: 9, 13, 20, 24, 46, 52
key point - Algorithm is all about SELECT MINIMUM AND SWAP.
 */
public class SelectionSort {
    public static void selectionsort(int arr[]){
        for(int i=0;i<arr.length-2;i++){
            int mini = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[mini]){
                    //for above line let us suppose from our array we took our first element i.e 13
                    // 13 < 13 - no
                    // now we j pointer and it goes to 46 is 46<13 it no then it moves till it reaches a element that is less than
                    // like at 5th index 9<13 it's true - then mini gets updated to 5th index that is mini = j;(mini value is 9 from index 5)
                    mini = j;
                }
            }
            // after updating mini we swap mini with ith index element.
            int temp = arr[mini];
            arr[mini] = arr[i];
            arr[i] = temp;
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
      int arr[] = {13, 46, 24, 52, 20, 9};
      selectionsort(arr);
    }
}
