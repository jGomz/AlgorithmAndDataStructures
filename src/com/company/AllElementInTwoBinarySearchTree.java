package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllElementInTwoBinarySearchTree {
    int val;
    AllElementInTwoBinarySearchTree left;
    AllElementInTwoBinarySearchTree right;
    AllElementInTwoBinarySearchTree() {}
    AllElementInTwoBinarySearchTree(int val) { this.val = val; }
    AllElementInTwoBinarySearchTree(int val, AllElementInTwoBinarySearchTree left, AllElementInTwoBinarySearchTree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


    List<Integer> listOfNodes = new ArrayList<>();

    void printTree(AllElementInTwoBinarySearchTree node)
    {
        if(node == null) return;
        printTree(node.left );
        System.out.println(node.val);
        printTree(node.right);
    }

    static List<Integer> returnList(AllElementInTwoBinarySearchTree node,  List<Integer> list)
    {
        if(node == null) return list;
        returnList(node.left, list);
        System.out.println(node.val);
        list.add(node.val);
        returnList(node.right, list);

        return list;
    }

    public List<Integer> merge(AllElementInTwoBinarySearchTree root1,AllElementInTwoBinarySearchTree root2)
    {
        if(root1==null && root2==null) return null;

        if(root1==null) {
            System.out.println("root2 "+root2.val);
            System.out.println(" ");
            listOfNodes.add(root2.val);
        }else if(root2==null){
            System.out.println("root1 "+root1.val);
            System.out.println(" ");
            listOfNodes.add(root1.val);
        }else{
            merge(root1.left, root2.left);
            System.out.println("root1 "+root1.val);
            System.out.println("root2 "+root2.val);
            System.out.println(" ");
            if (root1.val < root2.val) {
                listOfNodes.add(root1.val);
                listOfNodes.add(root2.val);
            } else {
                listOfNodes.add(root2.val);
                listOfNodes.add(root1.val);
            }
            merge(root1.right, root2.right);
        }

        return listOfNodes;

    }

    public static void main(String[] args) throws IOException {
        AllElementInTwoBinarySearchTree root = new AllElementInTwoBinarySearchTree(1);
       //root.left = new AllElementInTwoBinarySearchTree(-10);
       root.right = new AllElementInTwoBinarySearchTree(8);

        AllElementInTwoBinarySearchTree root2 = new AllElementInTwoBinarySearchTree(8);
        root2.left = new AllElementInTwoBinarySearchTree(1);
        //root2.right = new AllElementInTwoBinarySearchTree(7);
       // root2.left.left = new AllElementInTwoBinarySearchTree(0);
        //root2.left.right = new AllElementInTwoBinarySearchTree(2);

        List<Integer> listRoot1 = new ArrayList<>();
        List<Integer> listRoot2 = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        listRoot1 = returnList(root, listRoot1);
        listRoot2 = returnList(root2, listRoot2);

        System.out.println(Arrays.toString(listRoot1.toArray()));
        System.out.println(Arrays.toString(listRoot2.toArray()));

        int count1 = 0;
        int count2 = 0;

        if(listRoot1.size() > 0) {
            for (int i = 0; i < listRoot1.size(); i++) {
                while (count2 < listRoot2.size()) {
                    if (listRoot2.get(count2) <= listRoot1.get(i)) {
                        list.add(listRoot2.get(count2));
                        count2++;
                    } else {
                        break;
                    }
                }
                list.add(listRoot1.get(i));
            }

        }else if(listRoot2.size() > 0){
            for (int i = 0; i < listRoot2.size(); i++) {
                while (count1 < listRoot1.size()) {
                    if (listRoot2.get(count1) < listRoot1.get(i)) {
                        list.add(listRoot1.get(count1));
                        count1++;
                    } else {
                        break;
                    }
                }
                list.add(listRoot2.get(i));
            }
        }

        System.out.println(Arrays.toString(list.toArray()));
    }
}


