package org.example.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//this question is from binary tree based on level order
//in this question we use queue Data Structure to print level order
public class LevelOrderTraversal {
    //creating a Node class
 static class Node{
     int data;
     Node left;
     Node right;


     //creating constructor - constructor is a special type of method used to initialise the object
     // Note: It is called constructor because it constructs the values at the time of object creation.
     // It is not necessary to write a constructor for a class.
     // It is because java compiler creates a default constructor if your class doesn't have any.
     Node(int data){
         this.data = data;
         this.left = null;
         this.right = null;

     }
    }
    //creating a build tree class for building our tree
    static class BinaryTree{
     static int index = -1;
     public static Node Buildtree(int node[]){
         index++;
         if(node[index] == -1){
             return null;
         }
         //in this I'm creating a newNode
         Node newNode = new Node(node[index]);
         //builduing our left subtree with no values inside them
         newNode.left = Buildtree(node);
         //building our right subtree with no values inside them
         newNode.right = Buildtree(node);
         return newNode;
     }
    }
    public static List<List<Integer>> levelOrder(Node root) {
        //levelOrder
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        //creating a queue to store the data
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int levelsize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for(int i=0;i<levelsize;i++){
                Node currentNode = queue.poll();
                currentLevel.add(currentNode.data);
                if(currentNode.left != null){
                    queue.add(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.add(currentNode.right);
                }
            }
            result.add(currentLevel);
        }

        return result;
    }
    public static void main(String[] args) {
     int node[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
         Node root = tree.Buildtree(node);
       System.out.println(levelOrder(root));

    }
}
