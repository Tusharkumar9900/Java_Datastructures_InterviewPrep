package Revision;
/*
Question :-
                An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
                typically using all the original letters exactly once.
Given two strings s and t:  return true , if t is an anagram of s, return false otherwise.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Explanation : The input strings “anagram” and “nagaram” exactly contain 3 — ’a’, 1 — ‘g’, 1 — ‘m’, 1 — ’n’ and 1 — ‘r’.
So, “nagaram” can be formed by rearranging the letters of “anagram”. And hence, they are both anagrams of each other.

 */


/*
//optimal Approach using : Count using a frequency array
//in this approach we know about ASCII like 'a' start from 97 and till 'z' = 122.

public class Anagram {
    public static boolean isAnagram(String s, String t){
        int m = s.length();
        int n = t.length();
        if(m != n){
            return false;
        }
        int [] ch = new int[26];
        for(int i=0;i<m;i++){
            ch[s.charAt(i) -'a']++;
            }
        for(int i=0;i<n;i++){
            ch[t.charAt(i)-'a']--;
        }
        for(int i=0;i<ch.length;i++){
            if(ch[i]!=0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
     String s = "anagram";
     String t = "nagram";
     System.out.print(isAnagram(s,t));
    }
}


 */

import java.util.HashMap;

//another better approach using hashmap
public class Anagram {
    public static boolean isAnagram(String s, String t){
        //creating a hashmap for string
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<t.length();i++) {
            char ch = t.charAt(i);
            if (map.containsKey(ch) == false) {
                return false;
            } else if (map.get(ch) == 1) {
                map.remove(ch);
            } else {
                map.put(ch, map.get(ch) - 1);
            }
        }
        return map.isEmpty();
    }
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s,t));
    }
}