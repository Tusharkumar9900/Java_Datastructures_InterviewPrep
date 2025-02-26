package org.example.CompanyQuestions;

import java.util.Arrays;
import java.util.Scanner;

/*
Magnetic Letters
It is your little brother Louie's birthday in a few days.
So, you decided to buy a magnetic letterbox for him as a present.
Louie wants to construct two strings using all the letters in the box.
You must determine whether he can construct both strings using all the letters in the box.
Input The first and the second line of the input contain two strings S, and S2, representing the strings that Louie wants to construct.
The third line of the input contains string R- representing all the letters in the magnetic letters box
Note: Strings only contain uppercase Latin letters.
Output Print "Yes" if Louie can construct given strings using all the letters in the box.
Otherwise, print "No Print the answer without the quotes.
Constraints ->   1<=length of S, S R<= 100
Example #1
Input
SAM
JOHN
SAMJOHN
Output
Yes
Explanation: Louie can use all of the letters from the box to construct strings "SAM" and "JOHN
 */
public class MagneticLetters {
    public static boolean canConstructStrings(String S, String S2, String R){
        String target = S + S2;

        char[] targetArray = target.toCharArray();
        char[] rArray = R.toCharArray();

        Arrays.sort(targetArray);
        Arrays.sort(rArray);
        return Arrays.equals(targetArray,rArray);
    }
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String S = sc.next().trim();
    String S2 = sc.next().trim();
    String R = sc.next().trim();
    sc.close();

    System.out.println(canConstructStrings(S,S2,R)?"Yes":"No");
    }
}
