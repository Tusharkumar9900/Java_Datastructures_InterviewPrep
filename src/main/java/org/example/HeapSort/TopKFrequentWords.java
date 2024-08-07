package org.example.HeapSort;

import java.util.*;

/*

Given an array of strings words and an integer k, return the k most frequent strings.
Return the answer sorted by the frequency from highest to lowest.
Sort the words with the same frequency by their lexicographical order.

Example 1:

Input: words = ["i","love","leetcode","i","love","coding"], k = 2
Output: ["i","love"]
Explanation: "i" and "love" are the two most frequent words.
Note that "i" comes before "love" due to a lower alphabetical order.

Example 2:
Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
Output: ["the","is","sunny","day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.


 */
public class TopKFrequentWords {
    public static  List<String> topKFrequent(String[] words, int k) {

        //creating hashmap
        Map<String, Integer> map = new HashMap<>();
        for(String s : words){
            map.put(s,map.getOrDefault(s,0)+1);
        }

        Queue<String> queue = new PriorityQueue<>((w1, w2)-> map.get(w1).equals(map.get(w2))?
                w2.compareTo(w1):map.get(w1)-map.get(w2));

        for(String word : map.keySet()){
            queue.add(word);
            if(queue.size()>k){
                queue.poll();
            }
        }

        List<String> result = new ArrayList<>();
        while(!queue.isEmpty()){
            result.add(queue.poll());
        }
        Collections.reverse(result);

        return result;
    }
    public static void main(String[] args) {
String[] words = {"i","love","leetcode","i","love","coding"};
int k = 2;
System.out.println(TopKFrequentWords.topKFrequent(words,k));
    }
}
