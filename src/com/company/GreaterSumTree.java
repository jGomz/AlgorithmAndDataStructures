package com.company;

import com.sun.source.tree.Tree;

import java.io.IOException;
import java.util.Stack;

public class GreaterSumTree {
    public TreeNode bstToGst(TreeNode root) {
        return null;
    }

    static public void inOderTraverse(TreeNode node){
        if(node == null)
            return;
        inOderTraverse(node.right);
        System.out.println(node.val);
        inOderTraverse(node.left);
    }

    static public void inOderTraverseStack(TreeNode root){
        Stack<TreeNode> s = new Stack<>();
        TreeNode currentNode = root;
        int currSum = 0;

        while(currentNode!=null || s.size() > 0){
            while(currentNode!=null) {
                s.push(currentNode);
                currentNode = currentNode.right;
            }
            currentNode = s.pop();
            currentNode.val = currentNode.val+currSum;
            System.out.println(currentNode.val);
            currSum = currentNode.val;
            currentNode=currentNode.left;
        }
    }

    public static void main(String[] args) throws IOException {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);

        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);

        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(8);

        inOderTraverseStack(root);
    }

    static public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;this.left = left;
          this.right = right;
      }
  }
}
