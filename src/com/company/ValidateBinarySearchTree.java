package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ValidateBinarySearchTree {

    static public boolean isValidBST(TreeNode root) {
        if(root == null) return true;

        Stack<TreeNode> s = new Stack<>();
        s.add(root);

        int max = root.val;
        int min = root.val;

        TreeNode n;
        //System.out.println("Stack");
        while(!s.isEmpty()) {
            n = s.pop();
            if(n.left != null){
                System.out.println("n: "+ n.val + " Left: "+n.left.val);
                max = Math.max(max, n.val);
                min = Math.min(min, n.val);
                if(n.left.val >= max || n.left.val<= min) return false;
                s.add(n.left);
            }

            if(n.right != null){
                System.out.println("n: "+ n.val + " right: "+n.right.val);
                min = Math.min(min, n.val);
                max = Math.max(max, n.val);
                if(n.right.val <= min || n.right.val >= max) return false;
                s.add(n.right);
            }

        }
       /* System.out.println("Queue");

        while(!q.isEmpty()) {
            n = q.remove();
            System.out.print(n.val + " ");
            if(n.left != null){
                if(n.left.val >= n.val) return false;
                q.add(n.left);
            }

            if(n.right != null){
                if(n.right.val <= n.val) return false;
                q.add(n.right);
            }

        }*/

        return true;
    }

    static public boolean isBST(TreeNode root) {
        if(root == null) return true;

        Stack<TreeNode> s = new Stack<>();
        s.push(root);

        TreeNode n = root;
        int min = Integer.MIN_VALUE;
        while(!s.isEmpty() || n != null){
            while(n != null || n.left != null){
                s.push(n.left);
                n = n.left;
            }

            n = s.pop();

            if(n.val <= min) return false;
            min = n.val;
            n = n.right;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        ValidateBinarySearchTree.TreeNode root = new ValidateBinarySearchTree.TreeNode(3);
        root.left = new ValidateBinarySearchTree.TreeNode(1);
        root.right = new ValidateBinarySearchTree.TreeNode(5);

        root.left.left = new ValidateBinarySearchTree.TreeNode(0);
        root.left.right = new ValidateBinarySearchTree.TreeNode(2);

        root.right.right = new ValidateBinarySearchTree.TreeNode(4);
        root.right.left = new ValidateBinarySearchTree.TreeNode(6);


        System.out.println(isValidBST(root));
        /*
        root.left.left = new ValidateBinarySearchTree.TreeNode(2);
        root.left.right = new ValidateBinarySearchTree.TreeNode(7);
        root.left.left.left = new ValidateBinarySearchTree.TreeNode(9);
        root.left.right.left = new ValidateBinarySearchTree.TreeNode(1);
        root.left.right.right = new ValidateBinarySearchTree.TreeNode(4);

        root.right.right = new ValidateBinarySearchTree.TreeNode(3);
        root.right.left = new ValidateBinarySearchTree.TreeNode(1);
        root.right.right.right = new ValidateBinarySearchTree.TreeNode(5);*/
    }

    static public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
