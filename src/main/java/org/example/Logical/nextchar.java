package org.example.Logical;

public class nextchar {
    public static void main(String[] args) {
        String input = "pqrs";
        String output = convertString(input);
        System.out.println(input + " ");
        System.out.println(output+ " ");
    }

    public static String convertString(String input){
        String result = "";
        for(char ch : input.toCharArray()){
            if(Character.isLetter(ch)){ // check letter is there in our string not number ar any special character
                if(ch == 'z'){
                    result = result + 'a';
                }else if(ch == 'Z'){
                    result = result + 'A';
                }else{
                    result = result + (char)(ch + 1);
                }
            }else{
                result = result+ ch;
            }
        }
        return result;
    }
}
