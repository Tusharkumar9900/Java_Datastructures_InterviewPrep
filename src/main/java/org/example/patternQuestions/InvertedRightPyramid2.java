package org.example.patternQuestions;
/*
in this question we are printing the pattern like this
Input Format: N = 6
Result:
1 2 3 4 5 6
1 2 3 4 5
1 2 3 4
1 2 3
1 2
1
 */
public class InvertedRightPyramid2 {
    public static void main(String[] args) {
        int n=6;
        for(int i=0;i<=n;i++){
           for(int j=1;j<n-i+1;j++){
               System.out.print(j+ " ");
           }
           System.out.println();
        }
    }
}
