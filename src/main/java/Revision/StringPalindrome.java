package Revision;

import java.util.Locale;

/*
 Java program to check whether a string is a Palindrome.
 Using two pointing variables.
 */
public class StringPalindrome {
    public static boolean isPalindromeString(String str){
        int i=0;
        int j = str.length()-1;
        while(i<j){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
      String str = "abba";
      str = str.toLowerCase();
      if(isPalindromeString(str)){
          System.out.println("yes yeh palindrome hai");
      }else{
          System.out.println("yeh ni h bhai koi dusra dekho");
      }
    }
}
