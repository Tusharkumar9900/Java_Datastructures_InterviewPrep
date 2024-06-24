package org.example.HashMap;

/*
Repeating Character in a string and we have to count how many times it occuring
Test Case : Case-Insensitive Input
Input: "AbBcCDd"
                 Duplicate characters in the string:
                 b: 2 times
                 d: 2 times
 */



/*


//brute force approach using the two loop
public class RepeatingCharacterString {
    public static void Duplicate(String str){
        char[] character = str.toCharArray();
        for(int i=0;i<character.length;i++){
            if(character[i] == '\0'){
                continue;
            }
            int count =0;
            for(int j=i;j<character.length;j++){
                if(i!=j && character[i] == character[j]){
                    count++;
                    character[j] ='\0';
                }
            }
            if(count>0){
                System.out.println(character[i] + " "+ (count+1));
            }
        }

    }
    public static void main(String[] args) {
     String str = "abcdeeeedefa";
     Duplicate(str);
    }
}


 */
//----------------------------------------------------------------------------------------------------------------------------


//using hashmap optimized approach


import java.util.HashMap;
import java.util.Map;

public class RepeatingCharacterString {
    public static void duplicateCharacter(String str){
        //check one of the test cases
        if(str == null){
            return ;
        }
        if(str.isBlank()){
            System.out.println("String is empty");
            return;
        }
        if(str.length()== 1){
            return;
        }
        Map<Character, Integer> map = new HashMap<>();
        char[] characterArray = str.toCharArray();
        for(char ch : characterArray){
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)+1);
            }else{
                map.put(ch,1);
            }
        }
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            if(entry.getValue()>1){
                System.out.println(entry.getKey()+ " " + entry.getValue());
            }
        }
    }
    public static void main(String[] args) {
        String str = "abdcjhhgfsddg";
        duplicateCharacter(str);
    }
}