package org.example.Logical;

public class Fibonacci {
    public static void fib(int n) {
        //recursive call
//        if (n <= 1) {
//            return n;
//        } else {
//
//            return fib(n - 1) + fib(n - 2);
//        }

        //using iteration
        int num1 = 0, num2 =1;
        for(int i=0;i<n;i++){
            System.out.print(num1 + " ");
            int num3 = num2 + num1;
            num1 = num2;
            num2 = num3;
        }
    }
    public static void main(String[] args) {
        //these statements below are for recursive call
//        int n = 10;
//        for(int i=0;i<n;i++){
//            System.out.print(fib(n) + " ");
//        }


//------------------------------------------------------------
        //call for iterative method
        int n = 10;
        fib(n);

    }
}

//-----------------------------------------------------------------------------------------

//
//// printing fibonacci series using dp method
//public class fibonacci {
//    public static int fib(int n){
//        /* Declare an array to store Fibonacci numbers. */
//        int f[] = new int[n+2]; // 1 extra to handle case, n = 0
//        f[0] = 0;
//        f[1]= 1;
//        for(int i=2;i<=n;i++){
//            /* Add the previous 2 numbers in the series
//              and store it */
//            f[i] = f[i-1] + f[i-2];
//        }
//        return f[n];
//    }
//    public static void main(String[] args) {
//        int n=10;
//        for(int i=0;i<=n;i++){
//            System.out.print(fib(i)+" ");
//        }
//
//
//    }
//}
