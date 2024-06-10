package Revision;

import java.util.ArrayList;
import java.util.Arrays;

/*
given an array of integer, move all zeroes to the end while maintaining the relative order of other elements
input - int arr[] = {0,1,3,0,12};
output- int arr[] = {1,3,12,0,0}
 */

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------

/*
--------------------------------------------------------------------------------------------------------------------------------------------------------
//brute force approach using the additional array to store the non zero element and then add in the array and fill the afterward array with zero.
public class MovingZeros {
    public static int[] movezeroes(int arr[]) {
        ArrayList<Integer> templist = new ArrayList<>();
//        filling non zeroes element in a temporary array
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                templist.add(arr[i]);
            }
        }
        // Adding non-zero elements back to the original array
        int nonzero = templist.size();
        for (int i = 0; i < nonzero; i++) {
            arr[i] = templist.get(i);
        }
        for (int i = nonzero; i < arr.length; i++) {
            arr[i] = 0;
        }
        return arr;
    }

    public static void main(String[] args) {
        int arr[] = {0, 1, 3, 0, 12};
//        movezeroes(arr);
//        System.out.println(Arrays.toString(arr));
        int[] answerarray = movezeroes(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }

    }


 */

//--------------------------------------------------------------------------------------------------------------------------------------------
//optimized approach using the two pointer appraoch
public class MovingZeros{
    //creatung method for nonzeros
    public static int[] zeros(int arr[]){
        int j = -1;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == 0){
                j=i;
                break;
            }
        }
        //handling the test case if there is no zero element just return over there
        if(j == -1){
            return arr;
        }
        for(int i=j+1;i<arr.length;i++){
            if(arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int arr[] = {0, 1, 3, 0, 12};
        int[] answerarray = zeros(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }
    }
