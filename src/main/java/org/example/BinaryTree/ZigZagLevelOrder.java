package org.example.BinaryTree;

import java.util.*;

public class ZigZagLevelOrder {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }
    public static class BinaryTree{
        static int index =-1;
        public static Node buildtree(int node[]){
            index++;
            if(index>= node.length || node[index] == -1){
                return null;
            }
            Node newNode = new Node(node[index]);
            newNode.left = buildtree(node);
            newNode.right = buildtree(node);
            return newNode;
        }
    }

    public static List<List<Integer>> ZigzagOrder(Node root){
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToright = true;

        while(!queue.isEmpty()){
            int levelsize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for(int i=0;i<levelsize;i++) {
                Node node = queue.poll();
                int index = leftToright ? i : (levelsize - 1 - i);
                currentLevel.add(index, node.data);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            leftToright = !leftToright;
            result.add(currentLevel);

        }
        return result;

    }
    static void printResult(List<List<Integer>> result) {
        for (List<Integer> row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
//            System.out.println();
        }
    }

    public static void main(String[] args) {
        int node[] = {3,9,20,-1,-1,15,7};
     BinaryTree tree = new BinaryTree();
     Node root = tree.buildtree(node);
        List<List<Integer>> result = ZigZagLevelOrder.ZigzagOrder(root);

        // Print the result
        printResult(result);
    }
}
