package org.example.patternQuestions;

/*
Like this we have to print the pattern
    ****
    ****
    ****
    ****
 */
public class RectangularPattern {
    public static void main(String[] args) {
        //using two for loop we are printing the rectangular star pattern.
      for(int i=0;i<4;i++){
          for(int j=0;j<4;j++){
              System.out.print("*");
          }
          System.out.println();
      }
    }
}
