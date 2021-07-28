package com.company;

import java.io.IOException;
import java.util.*;

public class NAryTreeLevelOrderTraversal {
    static public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        List<List<Integer>> retList = new ArrayList<>();
        List<Integer> childList = new ArrayList<>();
        Queue<Integer> h = new LinkedList<>();

        if(root ==null)
            return retList;
        q.add(root);

        childList.add(root.val);
        retList.add(childList);
        int countChild = 0;

        h.add(1);
        h.add(h.peek()+1);

        while(!q.isEmpty()){
            Node n = q.remove();

            countChild = 0;
            childList= new ArrayList<>();

            while(countChild < n.children.size()){
                if(n.children.get(countChild)!=null) {
                    q.add(n.children.get(countChild));
                    childList.add(n.children.get(countChild).val);
                    countChild++;
                }
            }
            if(childList.size()>0){
                retList.add(childList);
            }

        }

        return retList;
    }

    public static void main(String[] args) throws IOException {
        List<Node> childList = new ArrayList<>();
        Node root = new Node(1);
        Node n12 = new Node(2);
        Node n13 = new Node(3);
        Node n14 = new Node(4);
        Node n15 = new Node(5);
        childList.add(n12);
        childList.add(n13);
        childList.add(n14);
        childList.add(n15);
        root.children = childList;

        childList = new ArrayList<>();
        Node n36 = new Node(6);
        Node n37= new Node(7);
        childList.add(n36);
        childList.add(n37);
        n13.children = childList;

        childList = new ArrayList<>();
        Node n711 = new Node(11);
        childList.add(n711);
        n37.children = childList;

        childList = new ArrayList<>();
        Node n1114 = new Node(14);
        childList.add(n1114);
        n711.children = childList;

        childList = new ArrayList<>();
        Node n48 = new Node(8);
        childList.add(n48);
        n14.children = childList;

        childList = new ArrayList<>();
        Node n812 = new Node(12);
        childList.add(n812);
        n48.children = childList;

        childList = new ArrayList<>();
        Node n59 = new Node(9);
        Node n510 = new Node(10);
        childList.add(n59);
        childList.add(n510);
        n15.children = childList;

        childList = new ArrayList<>();
        Node n913 = new Node(13);
        childList.add(n913);
        n59.children = childList;

        System.out.println(Arrays.toString(levelOrder(root).toArray()));
    }
}

class Node{
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
