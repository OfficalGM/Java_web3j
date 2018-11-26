package com.demo.FBHT;

import org.web3j.crypto.Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.demo.FBHT.HashUtil.sha3;

public class FBHTree {

    private int height;
    public Node[] nodes;
    public int leafHeight;

    public FBHTree(int treeHeight) {
        if (treeHeight < 0) {
            throw new IllegalArgumentException("The minimum value for tree height is 1.");
        }
        this.height = treeHeight;
        this.leafHeight = (1 << (height - 1));
        this.nodes = new Node[1 << treeHeight];
        for (int i = nodes.length - 1; i > 0; i--) {
            if (i >= (1 << (height - 1))) {//leaf node
                nodes[i] = new Node(i, null, null);
            } else {//internal node
                nodes[i] = new Node(i, nodes[i * 2], nodes[(i * 2) + 1]);
            }
        }

    }

    public int calcLeafIndex(String tx) {
        byte digest[] = HashUtil.sha256(tx);
        int index = 0;
        for (int i = 0; i < 2; i++) {
            index += digest[i] << (i * 8);
        }
        return Math.abs(index) % (1 << (this.height - 1))+leafHeight;
    }

    public void put(String tx) {

        int index = calcLeafIndex(tx);

        byte[] p = sha3(tx);
        nodes[index].pbPair.add(p);
        updateLeafNode(index);
    }
    private void updateLeafNode(int index) {

        byte[] digest = new byte[nodes[index].pbPair.size()*32];
        for(int i=0;i<nodes[index].pbPair.size();i++) {
            for (int j = 0; j < 32; j++) {
                digest[j + i * 32] = nodes[index].pbPair.get(i)[j];
            }
        }
        digest= Hash.sha3(digest);
        nodes[index].hash=digest;
        updateNode(index);
    }

    //沒檢查
    private void updateNode(int index) {
        int root_height = 1;
        int tree_height = height;
        while (tree_height > root_height) {
            if (index % 2 == 1) {
                nodes[index / 2].hash = sha3(nodes[index - 1].hash, nodes[index].hash);
            } else {
                nodes[index / 2].hash = sha3(nodes[index].hash, nodes[index + 1].hash);
            }
            index = index / 2;
            tree_height--;
        }
    }

    public List<byte[]> getSlice(String base) {
        List<byte[]> slice = new ArrayList<byte[]>();
        int index = calcLeafIndex(base);

        for (int i = index; i > 1; i = i / 2) {
            if (i % 2 == 1) {
                slice.add(nodes[i].hash);
                slice.add(nodes[i - 1].hash);
            } else {
                slice.add(nodes[i + 1].hash);
                slice.add(nodes[i].hash);

            }
        }
        slice.add(nodes[1].hash);
        Collections.reverse(slice);
        return slice;
    }


    public void nodePrintln() {
        for (int i = 1; i < nodes.length; i++) {
//            System.out.println(i + " " + nodes[i].hash);
            System.out.println(i + ": " + Arrays.toString(nodes[i].hash));

//            System.out.println();
//            System.out.println(i+" "+sha256(nodes[i].hash));
        }
    }
}
