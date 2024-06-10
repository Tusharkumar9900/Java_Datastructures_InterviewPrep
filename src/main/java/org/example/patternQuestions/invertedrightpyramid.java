package org.example.patternQuestions;

/*
we have to print the pattern like this
Input Format: N = 6
Result:
* * * * * *
* * * * *
* * * *
* * *
* *
*
 */
public class invertedrightpyramid {
    public static void main(String[] args) {
        int n=6;
        for(int i = 0;i<n;i++){
            for(int j=1;j<n-i+1;j++){
                //we can write this for loop like this also :- for(int j=n; j > i; j--){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
