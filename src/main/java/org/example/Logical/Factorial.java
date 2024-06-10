package org.example.Logical;

public class Factorial {
    //factorial of number are - 4! = 4*3*2*1=24;
    //below code are for recursive call
    public static int Factorialnumber(int n){
        if(n==0){
            return 1;
        }else {
            //recursive call
        return    ( n* Factorialnumber( n-1));
        }
    }
    public static void main(String[] args) {
        int fact =1;
        int n = 9;
      fact = Factorialnumber(n);
      System.out.print(fact);
    }

}
