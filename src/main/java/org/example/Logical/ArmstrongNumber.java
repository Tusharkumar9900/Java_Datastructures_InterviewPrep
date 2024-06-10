package org.example.Logical;

public class ArmstrongNumber {
    public static void main(String[] args) {
        int n=372;
        int temp = n;
        int remender, sum =0;
        while(n>0){
            remender = n%10;
            n = n/10;
            sum = sum + remender*remender*remender;
        }

        if(temp == sum){
            System.out.print("Number is armstrong");
        }else{
            System.out.print("Number is not armstrong");
        }
    }
}
