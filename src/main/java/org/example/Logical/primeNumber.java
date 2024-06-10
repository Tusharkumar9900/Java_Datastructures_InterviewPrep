package org.example.Logical;

public class primeNumber {
    public static boolean isPrime(int n){
        if(n<=1){
            return false;
        }
        for(int i=2;i<n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
             		for(int i=1;i<100;i++){
          if(isPrime(i)){
              System.out.println(i);
          }
         }
    }
}
