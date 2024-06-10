package org.example.BinaryTree;

//Diameter of a binary Tree
//Longest path between any two nodes in a tree
//this path may or may not pass through the root


public class Diameter {

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = right;
        }
    }

    public static class BinaryTree{
        static int index=-1;
        public static Node BuildTree(int node[]){
            index++;
            if(node[index] == -1){
                return null;
            }

            Node newNode = new Node(node[index]);
            newNode.left = BuildTree(node);
            newNode.right = BuildTree(node);
            return newNode;
        }
    }
//    public static int height(Node root){
//        if(root == null){
//            return 0;
//        }
//        int leftheight = height(root.left);
//        int rightheight = height(root.right);
//        return Math.max(leftheight, rightheight) + 1;
//    }
   static int Diameter = 0;
    public static int diameter(Node root) {
        height(root);
        return Diameter - 1;
    }
       static int height(Node root){
            if(root == null){
                return 0;
            }
            int leftheight = height(root.left);
            int rightheight = height(root.right);

            int dia = leftheight + rightheight + 1;
            Diameter = Math.max(Diameter, dia);
            return Math.max(leftheight, rightheight)+1;
        }

    public static void main(String[] args) {
 int node[] = {1,2,3,4,5};
 BinaryTree tree = new BinaryTree();
 Node root = tree.BuildTree(node);

 diameter(root);

    }
}
