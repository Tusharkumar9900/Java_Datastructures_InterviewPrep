package Revision.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
In this class we are doing operations like Inorder, preorder and postorder and also levelorder after building tree.
 */
public class Operations {
   static class Node{
        Node left;
        Node right;
        int data;

        //creating constructor
       public Node(int data){
           this.data = data;
           this.left = null;
           this.right = null;
       }
    }

    static class BuildTree {
        static int index = -1;

        public static Node Binarytreebuilding(int node[]) {
            index++;
            if (index >= node.length || node[index] == -1) {
                return null;
            }
            Node newNode = new Node(node[index]);
            newNode.left = Binarytreebuilding(node);
            newNode.right = Binarytreebuilding(node);
            return newNode;
        }
    }
       //for printing preorder tree
        public static void preorder(Node root){
           if(root == null){
               return;
           }
           System.out.print(root.data + " ");
           preorder(root.left);
           preorder(root.right);
        }

        public static void inorder(Node root){
       if(root == null){
           return;
       }
       inorder(root.left);
       System.out.print(root.data + " ");
       inorder(root.right);
        }

        public static void postorder(Node root){
       if(root == null){
           return;
       }
       postorder(root.left);
       postorder(root.right);
       System.out.print(root.data+" ");
        }

        //levelorder traversal
       public static List<List<Integer>> levelorder(Node root){
       List<List<Integer>> result = new ArrayList<>();
       if(root == null){
           return result;
       }
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
        int node[] = {2,3,5,6,7,-1,8,-1,-1,9,-1,-1,10};
        BuildTree tree = new BuildTree();
        Node root = tree.Binarytreebuilding(node);
        System.out.println(root.data);

        // for printing preorder
        preorder(root);

        System.out.println("empty line here");
        //inorder calling
        inorder(root);
        System.out.println();
        postorder(root);
//       System.out.print(levelorder(root));
        System.out.println("Level order:");
        List<List<Integer>> levels = levelorder(root);
        for (List<Integer> level : levels) {
            System.out.println(level);
        }
    }

}
