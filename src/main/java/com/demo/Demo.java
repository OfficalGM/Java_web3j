package com.demo;


import com.demo.FBHT.FBHTree;
import org.web3j.tx.Contract;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;


public class Demo {

    public static void main(String args[]) {
//        Properties properties = Load();
//        String web3Url = properties.getProperty("web3url");
        String privateKey = "43cbbbf7643cd3f8bdf54d70014cd5fcc313b243aadec7081d16c1ad04ee4b8f";
        Web3 web3 = new Web3();
        String contractAddress = "0x9683eeb68fe0d3df151559670c83a40fbfd8472b";
        String contractName = "LedgerBooster";
//        Contract ledgerBooster = web3.LoadContract(privateKey, contractName, contractAddress);
        FBHTree fbhTree = new FBHTree(3);
        for(int i=0;i<10;i++){
            fbhTree.put(i+"");
        }
    }

    public static Properties Load() {
        Properties properties = new Properties();
        String configFile = "config.properties";
        try {
            properties.load(new FileInputStream(configFile));
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return properties;
    }


}
