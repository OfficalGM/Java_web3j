package com.demo;


import com.demo.FBHT.FBHTree;
import com.demo.contract.Auth;
import org.web3j.crypto.Hash;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
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

        for (int i = 0; i < 2; i++) {

            fbhTree.put(i+"");
        }

        byte a[]=new byte[]{4, 72, 82, -78, -90, 112, -83, -27, 64, 126, 120, -5, 40, 99, -59, 29, -23, -4, -71, 101, 66, -96, 113, -122, -2, 58, -19, -90, -69, -118, 17, 109, -56, -98, -3, -86, 84, -64, -14, 12, 122, -33, 97, 40, -126, -33, 9, 80, -11, -87, 81, 99, 126, 3, 7, -51, -53, 76, 103, 47, 41, -117, -117, -58};
        System.out.println(Arrays.toString(Hash.sha3(a)));
        System.out.println(Arrays.toString(fbhTree.nodes[5].hash));
        fbhTree.nodePrintln();
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
