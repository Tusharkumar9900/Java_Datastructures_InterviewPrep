package org.example.ArraysQuestions;
/*
 Find the elements that appears more than N/3 times in the array.
Input Format : N = 5, array[] = {1,2,2,3,2}
Result : 2
Explanation:
Here we can see that the Count(1) = 1, Count(2) = 3 and Count(3) = 1.
Therefore, the count of 2 is greater than N/3 times. Hence, 2 is the answer.
 */


//------------------------------------------------------------------------------------------------------------


/*

//brute force approach using loop iterative method
public class MajorityElement {
    public static void majority(int arr[],int n){
        int maxCount =0;
        int index = -1;
        for(int i=0;i<arr.length;i++){
            int count =0;
            for(int j=0;j<arr.length;j++){
                if(arr[i] == arr[j]){
                    count++;
                }
            }
            if(count>maxCount){
                maxCount = count;
                index = arr[i];
            }
        }


        if(maxCount>n/3){
            System.out.println(index);
        }else{
            System.out.println("No majority Element");
        }
    }

    public static void main(String[] args) {
        int arr[] = {1,2,2,3,2};
        int n = arr.length;
       majority(arr,n);
    }
}


 */

//-----------------------------------------------------------------------------------------------


/*
import java.util.HashMap;

//better solution using Hashmap
public class MajorityElement {
    public static void majorityelement(int arr[]){
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        for(int i=0;i<n;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else{
                map.put(arr[i],1);
            }
        }
        for(int key : map.keySet()){
            if(map.get(key)>n/3){
                System.out.println(key);
            }
        }
    }
    public static void main(String[] args) {
int arr[] = {1,2,3,3,3,3,2};
majorityelement(arr);
    }
}


 */

//-------------------------------------------------------------------------------------------------

//optimal approach , to get the best time complexity we use Moore's Voting Algorithm

public class MajorityElement {
    public static int mooresAlgorithm(int arr[]){
      int majorityelement = arr[0]; //let us suppose our first element will be the majority element
        int count =1;
        for(int i=1;i<arr.length;i++){
            if(count ==0){
                count++;
                majorityelement = arr[i]; //at any point in our array if count became 0 we update out element
                //suppose in array first we take 2 then if after moving forward it became 0 we update that element
                //and we increase the count from 1
            }else if(majorityelement == arr[i]){
                //if we found the same element we increase the count
                count++;
            }else{
                //if another element came instead of elment we take, we decrease the count
                count--;
            }
        }
        return majorityelement;
    }
    public static void main(String[] args) {
        int arr[] = {2,2,1,3,1,3,2};
      System.out.println(mooresAlgorithm(arr));

    }
}