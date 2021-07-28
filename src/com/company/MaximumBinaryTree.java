package com.company;

import java.io.IOException;
import java.util.Stack;

public class MaximumBinaryTree {
    static public TreeNode constructMaximumBinaryTree(int[] nums) {
        //int root = nums[retGreater(nums, 0, nums.length)];
        TreeNode n = printAllSubArrays(nums,0, nums.length);

        return n;
    }

    int l;
    int r;
    TreeNode nodeRef;

    static public TreeNode printAllSubArraysIterative(int[] nums){
        int l = 0;
        int r = nums.length;
        int index = retGreater(nums, l, r);
        MaximumBinaryTree obj = new MaximumBinaryTree();
        TreeNode root = new TreeNode(nums[index]);
        Stack<MaximumBinaryTree> s = new Stack<>();

        if(l!=index) {
            root.left = new TreeNode();
            obj.l = l;
            obj.r = index;
            obj.nodeRef = root.left;
            s.add(obj);
        }

        if(index+1!=nums.length){
            root.right = new TreeNode();
            obj = new MaximumBinaryTree();;
            obj.l = index+1;
            obj.r = nums.length;
            obj.nodeRef = root.right;
            s.add(obj);
        }

        while(!s.empty()){
            MaximumBinaryTree bt = s.pop();
            l = bt.l;
            r = bt.r;

            index = retGreater(nums, l, r);
            bt.nodeRef.val = nums[index];

            if(l!=index) {
                bt.nodeRef.left = new TreeNode();
                obj.l = l;
                obj.r = index;
                obj.nodeRef = bt.nodeRef.left;
                s.add(obj);
            }

            if(index+1!=r){
                bt.nodeRef.right = new TreeNode();
                obj = new MaximumBinaryTree();
                obj.l = index+1;
                obj.r = nums.length;
                obj.nodeRef = bt.nodeRef.right;
                s.add(obj);
            }

        }

        return root;
    }

    static public TreeNode printAllSubArrays(int[] nums, int l, int r){
        if(l==r) {
            return null;
        }
        int index = retGreater(nums, l, r);
        TreeNode n = new TreeNode(nums[index]);
        System.out.println("");
        System.out.println("index: "+index+" l: "+l+" r: "+r);
        for(int i=l ; i<r ; i++){
            System.out.print(nums[i]+" ");
        }
        n.left = printAllSubArrays(nums, l, index);
        n.right = printAllSubArrays(nums, index + 1, r);

        return n;
    }

    static public void printAllSubArrays(int[] nums, boolean[] b, int l, int r, TreeNode n){
        if(r>1){

            int index = retGreater(nums, l, r);
            if(!b[index]){
                System.out.println("");
                System.out.println("index: "+nums[index]+" l: "+l+" r: "+r);
                for(int i=l ; i<r ; i++){
                    System.out.print(nums[i]+" ");
                }
                b[index] = true;
                printAllSubArrays(nums, b, l, index, n);
                printAllSubArrays(nums, b, index + 1, r, n);
            }
        }
    }

    static public int retGreater(int[] arr, int l, int r){
        int index = l;
        for(int i=l ; i<r; i++){
            if(arr[i]>arr[index]){
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) throws IOException {
        int[] piles = {3,2,1,6,0,5};
        constructMaximumBinaryTree(piles);
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
