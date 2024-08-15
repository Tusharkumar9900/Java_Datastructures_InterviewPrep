package org.example.LinkedListQuestions;

/*

Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists.
Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.

Example:
             Input:
                        ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
                        [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]

             Output:
                       [null, null, null, 1, null, -1, null, -1, 3, 4]


Explanation:

LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4



 */

import java.util.HashMap;
import java.util.Map;

class Node{
    Node previous, next;
    int key, value;
    Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}

public class LRUCache {
    Node head =new Node(0,0);
    Node tail = new Node(0,0);
    Map<Integer,Node> map = new HashMap<>();
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next= tail;
        tail.previous = head;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }else{
            Node node = map.get(key);
            remove(node); //we are removing the node form there current position
            insert(node); // and after removing we are adding the node in the front
            return node.value;
        }
    }

    public void put(int key, int value) {
        //check if element already present in hashmap or not
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        if(map.size()== capacity){
            remove(tail.previous);
        }
        insert(new Node(key,value));
    }

    public void insert(Node node){
        map.put(node.key,node);
        node.next = head.next;
        node.next.previous = node;
        head.next=node;
        node.previous =head;
    }

    public void remove(Node node){
        map.remove(node.key);
        node.previous.next = node.next;
        node.next.previous = node.previous;
    }
    public static void main(String[] args) {

    }
}
