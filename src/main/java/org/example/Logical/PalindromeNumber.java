package org.example.Logical;

public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(ispalindrome(434));
    }
    public static boolean ispalindrome(int n){

        int temp =n;
        int rev=0;
        while(n>0){
           int remainder = n%10;
           rev = (rev*10) + remainder;
           n = n/10;
        }
        if(rev == temp) {
            return true;
        }else{
            return false;
        }
    }
}
