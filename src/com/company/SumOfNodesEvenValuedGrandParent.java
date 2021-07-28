package com.company;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class SumOfNodesEvenValuedGrandParent {

    static public int sumEvenGrandparent(TreeNode root) {
        int sum = 0;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode n;
        q.add(root);

        while(!q.isEmpty()){
            n = q.remove();

            if((n.val%2)==0){
                if(n.left !=null){
                    if(n.left.left !=null){
                        sum+=n.left.left.val;
                    }

                    if(n.left.right !=null){
                        sum+=n.left.right.val;
                    }
                }

                if(n.right !=null){
                    if(n.right.left !=null){
                        sum+=n.right.left.val;
                    }

                    if(n.right.right !=null){
                        sum+=n.right.right.val;
                    }
                }
            }

            if(n.left !=null){
                q.add(n.left);
            }

            if(n.right !=null){
                q.add(n.right);
            }
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(7);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);
        root.left.left.left = new TreeNode(9);
        root.left.right.left = new TreeNode(1);
        root.left.right.right = new TreeNode(4);

        root.right.right = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right.right = new TreeNode(5);


        int node = 3;

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
