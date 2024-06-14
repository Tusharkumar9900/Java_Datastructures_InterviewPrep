package org.example.String.SlidingWindow;

/*
Brute Force Approach
Given a String, find the length of longest substring without any repeating character.
Example 1:
Input: s = ”abcabcbb”
Output: 3

Explanation: The answer is abc with length of 3.
 */



/*
import java.util.HashSet;
import java.util.Set;

//brute force approach using two loop
public class LongestSubstringwithoutrepeating {
  public static int longestsubstring(String s){
      //handling test cases
      if(s.length() == 0){
          return 0;
      }
      if(s.length() == 1){
          return 1;
      }
      //working on string
      int maxlength = Integer.MIN_VALUE;
      //outerloop for traversing
      for(int i =0;i<s.length();i++){
          //declaring set data structure
          Set<Character> ch = new HashSet<>();
          //now we declaring nested loop for getting different
          for(int j=i;j<s.length();j++){
              if(ch.contains(s.charAt(j))){
                  maxlength = Math.max(maxlength,j-i);
                  break;
              }
              ch.add(s.charAt(j));
              maxlength = Math.max(maxlength,j-i+1);
          }
      }
      return maxlength;
  }
    public static void main(String[] args) {
   String s = "abcabcbb";
        System.out.print(longestsubstring(s));
    }
}


 */


import java.util.HashMap;

//optimized Appproach Using the Sliding Window
//in this approach we use two pointer left and right and hashmap to store the character, in hashmap we store character with the index
//initialize our maxlength =0;
public class LongestSubstringwithoutrepeating {
    public static int Substringwithoutrepeating(String S){
        HashMap<Character, Integer> map = new HashMap<>();
        int left =0;
        int right =0;
        int maxlength =0;
        while(right<S.length()){
            if(map.containsKey(S.charAt(right))){
                left = Math.max(map.get(S.charAt(right))+1, left);
            }
            map.put(S.charAt(right), right);
            maxlength = Math.max(maxlength, right-left+1);
            right++;
        }
        return maxlength;
    }
    public static void main(String[] args) {
   String S = "cadbzabcd";
   System.out.print(Substringwithoutrepeating(S));
    }
}