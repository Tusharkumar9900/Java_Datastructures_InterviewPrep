package org.example.patternQuestions;

/*
in this question we are printing a right-angled triangle without using nested loops.
 */
public class WithoutNestedLoop {
    public static void printstar(int count){
        if(count ==0){
            return;
        }
        System.out.print("* ");
        printstar(count-1);
    }
    public static void printpattern(int n){
        printRow(n,1);
    }
    public static void printRow(int n, int currentRow){
        if(currentRow>n){
            return;
        }
        printstar(currentRow);
        System.out.println();
        printRow(n,currentRow+1);
    }
    public static void main(String[] args) {
        printpattern(5);


    }
}
