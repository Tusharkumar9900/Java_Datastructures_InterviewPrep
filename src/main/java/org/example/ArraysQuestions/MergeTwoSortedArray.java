package org.example.ArraysQuestions;

/*

We have to merge a two sorted array
EXAMPLE:  int arr1[] = {1,4,8,10};
        int arr2[] = {2,3,9};

        Output: arr[] :- {1,2,3,4,8,9,10};

 */




/*

//merging two sorted array using third array:- In this approach we are merging two arrays which are sorted in third array

public class MergeTwoSortedArray {
    public static void mergearray(int[] arr1, int m,int[] arr2, int n, int[] arr3){
     int i=0, j=0, k=0;
     while(i<m && j<n){
         if(arr1[i]<arr2[j]){
             arr3[k++] = arr1[i++];
//             k++;
//             i++;
         }
         else
         {
             arr3[k++] = arr2[j++];
//             k++;
//             j++;
         }
     }

//now we are going to do the operation in which we there is element left in any array we will directly copy in array
//because array is already sorted.
        while(i<m){
            arr3[k]=arr1[i];
            k++;
            i++;
        }
        while(j<n){
            arr3[k]= arr2[j];
            k++;
            j++;
        }
    }

    public static void display(int ans[],int n){
     for(int i=0;i<n;i++){
         System.out.print(ans[i]+" ");
     }
    }
    public static void main(String[] args) {
        int arr1[] = {1,4,8,10};
        int arr2[] = {2,3,9};
        int arr3[] = new int[arr1.length + arr2.length];

//calling the function by giving arrays and array length with third array in which we are going to merge
        mergearray(arr1, 4,arr2,3,arr3);

        //display function
        display(arr3,arr3.length);
    }
}



 */


//now we have to merge the two sorted array without using any extra space that is any other array
//Example: Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//Output: [1,2,2,3,5,6]
//Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
//The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
public class MergeTwoSortedArray {
    public static int[] mergearray(int arr1[], int m, int arr2[], int n){
        int i = m-1;
        int j=n-1;
        int k = arr1.length-1;

        while(i>=0 && j>=0){
            if(arr1[i]>arr2[j]){
                arr1[k--]= arr1[i--];
            }else{
                arr1[k--]= arr2[j--];
            }
        }
        while(j>=0){
            arr1[k--] = arr2[j--];
        }
        return arr1;
    }
    public static void main(String[] args) {
int arr1[] = {1,2,3,0,0,0};
int arr2[]= {2,5,6};
mergearray(arr1,3,arr2,3);
for(int i=0;i<arr1.length;i++){
    System.out.print(arr1[i]+" ");
}
    }
}