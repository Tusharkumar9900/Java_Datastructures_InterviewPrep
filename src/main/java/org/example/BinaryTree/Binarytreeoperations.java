package org.example.BinaryTree;

public class Binarytreeoperations {
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

    //in this class we are building our tree first step take index initialise to -1 so it increment till last and then check if index is -1 then return null for null node
    static class Binarytree{
        static int index = -1; // taaki isko increment kr kr ke isko iski length tk lekr jaa ske
        public static Node buildtree(int node[]){ //return krdeyga root node ko
           index++; // in this step our index will be 0.
           //agr hmara index -1 hota yaani wha pr koi ni hai toh hm usse null return krdeyge.
           if(index >= node.length || node[index] == -1){
               return null;
           }

           //next step we have to create a new node for our next data
            Node newNode = new Node(node[index]);
           //sbse pehle left subtree ko create krege
           newNode.left = buildtree(node); // buildtree se jo bhi nikl k aayga usko left m daal deyge
            newNode.right = buildtree(node);
            return newNode;
        }
    }

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
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        int node[] = {1,2,4,-1,-1,6,-1,-1,3,6,-1,-1};
        Binarytree tree = new Binarytree();
        Node root = tree.buildtree(node);
        System.out.println(root.data);

        preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);
    }
}
