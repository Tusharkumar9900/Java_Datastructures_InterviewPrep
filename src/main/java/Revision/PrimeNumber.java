package Revision;

//printing number from 1 to upto n who are prime number
public class PrimeNumber {
    public static boolean isPrime(int n){
       if(n==0 || n == 1){
           return false;
       }
       for(int i =2;i<n;i++){
           if(n%i == 0){
               return false;
           }
       }
       return true;
    }
    public static void main(String[] args) {
        int n =100;
        for(int i=0;i<n;i++){
            if(isPrime(i)){
                System.out.println(i);
            }
        }
    }
}
