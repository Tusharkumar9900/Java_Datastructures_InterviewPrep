package org.example.TwoPointer;

/*

A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters,
it reads the same forward and backward.
Alphanumeric characters include letters and numbers.
Given a string s, return true if it is a palindrome, or false otherwise.
EXAMPLE ->
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

 */
public class ValidPalindromeString {
public static boolean isPalindrome(String s){
    s = s.toLowerCase().replaceAll("[^A-Za-z0-9]","");
    int left =0;
    int right = s.length()-1;
    while(left<=right){
        if(s.charAt(left) != s.charAt(right)){
            return false;
        }
        left++;
        right--;
    }
    return true;
}
    public static void main(String[] args) {
String s = "A man, a plan, a canal: Panama";
System.out.println(isPalindrome(s));
    }
}
