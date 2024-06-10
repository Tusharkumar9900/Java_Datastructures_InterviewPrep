package org.example.BinaryTree;

public class BinaryTreeHeight {
    static class Node{
        int data;
        Node left;
        Node right;

       Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static class BuildTree {

        static int index = -1;

        static Node BuildTreeMethod(int node[]) {
            index++;
            if (node[index] == -1) {
                return null;
            }

            Node newNode = new Node(node[index]);
            newNode.left = BuildTreeMethod(node);
            newNode.right = BuildTreeMethod(node);
            return newNode;

        }

        public  static int maxDepth(Node root) {
            if (root == null) {
                return 0;
            }
            int leftheight = maxDepth(root.left);
            int rightheight = maxDepth(root.right);

            return Math.max(leftheight, rightheight) + 1;

        }
    }
    public static void main(String[] args) {
        int node[] = {3,9,20,-1,-1,15,-1,7};
        BuildTree tree = new BuildTree();
        Node root = tree.BuildTreeMethod(node);

       int depth = BuildTree.maxDepth(root);
       System.out.println(depth);
    }
}
