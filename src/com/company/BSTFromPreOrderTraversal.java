package com.company;

import javax.swing.tree.TreeCellRenderer;
import java.io.IOException;
import java.util.Stack;

public class BSTFromPreOrderTraversal {
    static public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for(int i=1 ; i<preorder.length ; i++){
            insert(root, preorder[i]);
        }

        return root;
    }

    static TreeNode insert(TreeNode root, int val){
        if(root == null){
            root = new TreeNode(val);
            return root;
        }

        if(val < root.val){
            root.left = insert(root.left, val);
        }else if(val > root.val){
            root.right = insert(root.right, val);
        }

        return root;
    }
    TreeNode root;
    int val;

    static TreeNode insertIterative(int[] preorde){
        TreeNode root = new TreeNode(preorde[0]);
        Stack<TreeNode> s = new Stack<>();
        s.add(root);
        TreeNode aux;
        for(int i=1 ; i<preorde.length ; i++){
            if(preorde[i] < s.peek().val){
                aux = new TreeNode(preorde[i]);
                s.peek().left = aux;
                s.add(aux);
            }else{
                aux = new TreeNode();
                while(!s.empty() && preorde[i] < s.peek().val){
                    aux = s.pop();
                }
                aux.right = new TreeNode(preorde[i]);
                s.add(aux.right);
            }
        }
        return root;
    }

    public static void main(String[] args) throws IOException {
        int[] arr = {8,5,1,7,10,12};
        bstFromPreorder(arr);
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
