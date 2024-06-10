package Revision;

import java.util.Stack;

/*
Check Balanced Parentheses. Given string str containing just the characters '(', ')', '{', '}', '[' and ']',
check if the input string is valid and return true if the string is balanced otherwise return false.

Note: string str is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.

Example 1:

Input: str = “( )[ { } ( ) ]”

Output: True

Explanation: As every open bracket has its corresponding
close bracket. Match parentheses are in correct order
hence they are balanced.
 */
public class ValidParanthese {
    public static boolean isvalidparanthesis(String s){
        Stack<Character> stack = new Stack<>();
        //applying for each loop
        for(char it : s.toCharArray()){
            if(it == '(' || it == '[' || it == '{'){
                stack.push(it);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char ch = stack.pop();
                if((it == ')' && ch == '(') || (it == ']' && ch == '[') || (it == '}' && ch == '{')){
                    continue;
                }
                return false;
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
//    String s = "()[{}()]";
        String s = "[()";
    if(isvalidparanthesis(s)){
        System.out.print(true);
    }else{
        System.out.print(false);
    }
    }
}
