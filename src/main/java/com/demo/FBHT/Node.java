package com.demo.FBHT;

import java.util.ArrayList;
import java.util.HashMap;

public class Node {

    public int id;

    public byte[] hash;
    public Node left;
    public Node right;
//    public ArrayList<byte[]> pbPair;

    public HashMap<Integer, byte[]> pbPair;

    public Node(int id, Node left, Node right) {
        this.id = id;
        this.left = left;
        this.right = right;
        this.hash = new byte[32];
        if (left != null || right != null) {
            this.hash = HashUtil.sha3(this.left.hash, this.right.hash);
        } else {
            this.pbPair = new HashMap();
        }
    }
}
