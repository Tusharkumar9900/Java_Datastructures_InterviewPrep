package org.example.SortingAlgos;

/*

Given an unsorted array of size N, use selection sort to sort arr[] in increasing order.

Input:
N = 5
arr[] = {4, 1, 3, 9, 7}
Output:
1 3 4 7 9
Explanation:
Maintain sorted (in bold) and unsorted subarrays.
Select 1. Array becomes 1 4 3 9 7.
Select 3. Array becomes 1 3 4 9 7.
Select 4. Array becomes 1 3 4 9 7.
Select 7. Array becomes 1 3 4 7 9.
Select 9. Array becomes 1 3 4 7 9.

 */
public class SelectionSort {
  static  int select(int arr[], int i){
        int mini =i;
        for(int j=i+1;j<arr.length;j++){
            if(arr[j]<arr[mini]){
                mini =j;
            }
        }
        return mini;
    }

  static  void selectionsort(int arr[], int n){
        for(int i=0;i<n-1;i++){
            int mini = select(arr, i);
            int temp = arr[mini];
            arr[mini] = arr[i];
            arr[i]= temp;
        }
      for (int i = 0; i < n; i++) {
          System.out.print(arr[i] + " ");
      }
      System.out.println();
    }
    public static void main(String[] args) {
int arr[] ={7,5,9,2,8};
int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
selectionsort(arr,n);
    }
}
