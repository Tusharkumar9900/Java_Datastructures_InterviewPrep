package org.example.questions;

//printing number 1 to 100 prime number
public class primeNumber {
    public static boolean isPrime(int n){
        if(n<=1){
            return false;
        }
        for(int i=2;i<n;i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int n = 100;
        for(int i=1;i<n;i++){
            if(isPrime(i)){
                System.out.print(i + " ");
            }
        }
    }
}
