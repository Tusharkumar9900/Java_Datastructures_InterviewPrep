package org.example.BinaryTree;

public class BalancedBinaryTree {
    static class Node {
        int data;
        Node left;
        Node right;

        // Constructor for the Node class
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static class BinaryTreeBuilding {
        static int index = -1;

        // Method to build a binary tree from an array
        public static Node buildTree(int[] nodes) {
            index++;
            if (index >= nodes.length || nodes[index] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[index]);
            System.out.println("Created node with data: " + newNode.data);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }

    // Method to find the height of the tree
    public static int heightOfTree(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
    public static boolean isBalancedBinaryTree(Node root){
        if(root == null){
            return true;
        }
        int leftheight = heightOfTree(root.left);
        int rightheight = heightOfTree(root.right);

        if(Math.abs(leftheight-rightheight)<= 1 && isBalancedBinaryTree(root.left) && isBalancedBinaryTree(root.right)){
            return true;
        }
        else return false;
    }

    public static void main(String[] args) {
        int[] nodes = {3, 9, -1, -1, 15, 7,8};
        BinaryTreeBuilding tree = new BinaryTreeBuilding();
        Node root = tree.buildTree(nodes);
        System.out.println("root for the above tree is : " + root.data);
        System.out.println("Height of the tree: " + heightOfTree(root));

       System.out.println(isBalancedBinaryTree(root));
    }
}
