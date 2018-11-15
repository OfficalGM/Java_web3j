package com.demo.FBHT;

import java.util.HashMap;

public class Node {
    public int id;
    public String hash=null;
    public Node left;
    public Node right;
//    public HashMap<String, String> hashmap;
//    public String[] nodeData;
    public Node(int id, Node left, Node right) {
        this.id = id;
        this.left = left;
        this.right = right;
        if (left != null || right != null) {
            this.hash = HashUtil.sha256(this.left.hash + this.right.hash);
        }else{

//            this.nodeData=new String[1];
//            this.hashmap=new HashMap<>();
        }
    }
}
