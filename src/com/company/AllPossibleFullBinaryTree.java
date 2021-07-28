package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AllPossibleFullBinaryTree {

    public static List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> list = new ArrayList<>();
        if(N <= 0 ) return null;




        return list;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(allPossibleFBT(7));
    }

    static public class TreeNode {
        int val;
        ValidateBinarySearchTree.TreeNode left;
        ValidateBinarySearchTree.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, ValidateBinarySearchTree.TreeNode left, ValidateBinarySearchTree.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
