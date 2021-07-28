package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CorrespondingCloneThatTree {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Queue<TreeNode> qOriginal = new LinkedList<>();
        Queue<TreeNode> qCloned = new LinkedList<>();
        TreeNode nodeOriginal;
        TreeNode nodeCloned;

        qOriginal.add(original);
        qCloned.add(cloned);

        while(!qCloned.isEmpty()){
            nodeOriginal = qOriginal.remove();
            nodeCloned = qCloned.remove();

            if(nodeOriginal == target){
                return nodeCloned;
            }

            if(nodeOriginal.left != null){
                if(nodeOriginal.left == target){
                    return nodeCloned.left;
                }
                qOriginal.add(nodeOriginal.left);
                qCloned.add(nodeCloned.left);
            }

            if(nodeOriginal.right != null){
                if(nodeOriginal.right == target){
                    return nodeCloned.right;
                }
                qOriginal.add(nodeOriginal.right);
                qCloned.add(nodeCloned.right);
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException {


    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
