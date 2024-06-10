package org.example.patternQuestions;

/*
pattern to draw
*
* *
* * *
* * * *
* * * * *
* * * * * *
 */
public class RightAngledTriangle {
    public static void main(String[] args) {
        for(int i=0;i<7;i++){
            for(int j=0;j<i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
