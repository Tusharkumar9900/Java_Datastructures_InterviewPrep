package org.example.BinaryTree;

public class RightSideView {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.right= null;
            this.left = null;
        }
    }

    public static class BinaryTree{
        static int index = -1;
        public static Node BuildTree(int node[]){
            index++;
            if(index >= node.length || node[index] == -1){
                return null;
            }


            Node newNode = new Node(node[index]);
            newNode.left =BuildTree(node);
            newNode.right =BuildTree(node);
            return newNode;
        }
    }

    
    public static void main(String[] args) {
//        int[] node = { 1 ,2, 3, 4, 10, 9 ,11, -1, 5, -1, -1, -1, -1, -1, -1, -1, 6 };
        int[] node = {1,2,3,-1,5,-1,4};
        BinaryTree tree = new BinaryTree();
        Node root = tree.BuildTree(node);
        System.out.println(root.data);
    }
}
