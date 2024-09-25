package org.example.TwoPointer;

/*

Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string
that is formed from the original string by deleting some (can be none) of the characters
without disturbing the relative positions of the remaining characters.
(i.e., "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:
Input: s = "abc", t = "ahbgdc"
Output: true

Example 2:
Input: s = "axc", t = "ahbgdc"
Output: false

 */
public class isSubsequence {
    public static boolean isStringSubsequence(String s,  String t){
        int i=0;
        int j=0;
        while(i<s.length() && j<t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
                j++;
            }else{
                j++;
            }
        }
        return (i == s.length());
    }
    public static void main(String[] args) {
String s= "acb";
String t ="ahbgdc";
System.out.println(isStringSubsequence(s,t));
    }
}
