package org.example.questions;

public class palindrome {
    public static boolean isPalindrome(int n){
        int temp= n;
        int reverse =0;
        while(n>0){
            int remainder = n%10;
            reverse = (reverse *10) + remainder;
            n = n/10;

        }
        if(reverse == temp){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome(131));

    }
}
