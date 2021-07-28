package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RangeSumBST {
    static public int rangeSumBST(TreeNode root, int L, int R) {

        if (root == null) return 0;
        int sum = 0;
        TreeNode n;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()){
            n = q.remove();

            if(n.val >= L && n.val <= R ){
                sum+= n.val;
            }

            if(n.left != null){
                q.add(n.left);
            }

            if(n.right != null){
                q.add(n.right);
            }
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);

        root.right.right = new TreeNode(4);
        root.right.left = new TreeNode(6);

        System.out.println(rangeSumBST(root, 7, 15));
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
