package org.Rahul.dataStructures;

import java.util.LinkedList;
import java.util.Stack;
@SuppressWarnings("unused")

public class BinaryTree {

    //    private BinaryTree(){}
    public static class Node {
        int data;
        Node left, right;
        public Node(int data){
            this.data = data;
            left=right=null;
        }
    }
    public static boolean isLeaf(Node node){
        return node.left == null && node.right == null ;
    }

    public Node add( Node root, int data){
        if (root == null){
            root = new Node(data);
            return root;
        }
        else if (data< root.data) root.left=add(root.left,data);
        else root.right=add(root.right,data);
        return root;
    }
    public void inorder(Node root){
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public void preorder(Node root){//print root right  left
        if (root == null)
            return;
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public void postOrder(Node root){//print left root right
        if (root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }
    //to get no of leaf nodes available in a Binary tree
    public  int noOfLeaves(Node root){
        if (root == null) return 0;
        if (isLeaf(root)) return 1;
        return noOfLeaves(root.left) + noOfLeaves(root.right);
    }
    //To get all the path of tree from root to leaf
    public void getAllPaths(Node root , Stack<Integer>st) {
        if (root == null) return;
        st.push(root.data); //add element to stack to keep record
        if (isLeaf(root)){ // if there are no child nodes ie if it is a leaf node
            System.out.println(st); //print the stack
            st.pop();  //remove the top element to one level up in tree
            return;
        }
        getAllPaths(root.left, st);//recurse through left
        getAllPaths(root.right,st);
        st.pop();//remove element to change the position
    }
    public static void addLeftBoundary(Node root, LinkedList<Integer> li){
        Node cur = root.left;
        while (cur != null){
            if (!isLeaf(cur)) li.add(cur.data);
            if (cur.left == null) cur = cur.right;
            else cur = cur.left;
        }
    }
    public static void addRightBoundary(Node root, LinkedList<Integer>li){
        Node cur = root.right;
        LinkedList<Integer> tem = new LinkedList<>();
        while (cur != null){
            if (!isLeaf(cur)) tem.add(cur.data);
            if (cur.right == null) cur = cur.left;
            else cur = cur.right;
        }
        for (int i = tem.size()-1; i >=0 ; i--) { //left boundary elements to be added in reverse order
            li.add(tem.get(i));                   //as it is an anticlockwise approach
        }
    }
    private static void addLeaf(Node root,LinkedList<Integer>li){
        if (isLeaf(root)) {
            li.add(root.data);
            return;
        }
        if (root.left != null) addLeaf(root.left,li);
        if (root.right != null) addLeaf(root.right,li);
    }
    public LinkedList<Integer> boundaryTraversal(Node root){
        LinkedList<Integer> arr = new LinkedList<>();
        if (!isLeaf(root)) arr.add(root.data);
        addLeftBoundary(root,arr);
        addLeaf(root,arr);
        addRightBoundary(root,arr);
        return arr;
    }

    public static int maxHeight(Node root,int[] diam){
        if (root == null) return 0;
        int lh = maxHeight(root.left,diam);
        int rh = maxHeight(root.right,diam);
        diam[0] =Math.max(diam[0] , lh+rh);

        return 1 + Math.max(lh,rh);
    }
    public static int maxHeight(Node root) {
        if (root == null) return 0;
        int lh = maxHeight(root.left);
        int rh = maxHeight(root.right);

        return 1 + Math.max(lh,rh);
    }
    public static int diameter(Node root){
        int[] diam = new int[1];
        maxHeight(root,diam);
        return diam[0];
    }
    public static boolean isBST(Node root){
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public static boolean isBST(Node root, long minVal, long maxVal){
        if (root == null) return true;
        if (root.data >= maxVal || root.data <= minVal) return false;

        return isBST(root.left, minVal, root.data) && isBST(root.right, root.data, maxVal);

    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();

        int[] arr = {25,15,50,10,22,35,70,4,12,18,24,31,44,66,90};
        BinaryTree tree = new BinaryTree();
        Node root = null;

        for (int j : arr) {
            root = tree.add(root, j);
        }

        System.out.println("Inorder");
        tree.inorder(root);

        System.out.println("\npre order");
        tree.preorder(root);

        System.out.println("\npost order");
        tree.postOrder(root);

        System.out.println("\nBoundary traversal "+tree.boundaryTraversal(root));

        System.out.println("\nno of leaves is "+tree.noOfLeaves(root));

        System.out.println("\nAll the paths are ");
        tree.getAllPaths(root,st);

        System.out.println("Max height of tree is "+ maxHeight(root));

        System.out.println("Diameter of tree is "+diameter(root));

        System.out.println("is the given tree is BST "+isBST(root));
    }
}