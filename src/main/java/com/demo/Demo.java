package com.demo;


import com.demo.FBHT.FBHTree;
import com.demo.contract.Auth;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;

import java.util.Properties;


public class Demo {

    public static void main(String args[]) {
//        Properties properties = Load();
//        String web3Url = properties.getProperty("web3url");
//        String privateKey = properties.getProperty("privatekey");
//        Web3 web3 = new Web3();
        String contractAddress = "0x9683Eeb68FE0d3dF151559670C83A40fBfD8472B";
        String contractName = "Auth";
//        Contract auth = web3.LoadContract(privateKey, contractName, contractAddress);

        int height = 3;
        FBHTree fbhTree = new FBHTree(height);

        for (int i = 0; i < 4; i++) {
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
