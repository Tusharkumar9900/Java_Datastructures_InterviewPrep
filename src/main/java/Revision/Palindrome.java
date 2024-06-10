package Revision;

import java.util.Scanner;

//number like 151 1221 are palindrome
//get the remainder of n number then adn remainder in  reverver with reverse *10
//then divide the n number by 10
public class Palindrome {
    public static boolean isPlaindrome(int n){
        int temp = n;
        int reverse =0;

        while(n>0) {
            int remainder = n % 10;
            reverse = (reverse * 10) + remainder;
            n = n / 10;
        }
        if(reverse == temp){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(isPlaindrome(n));
    }
}
