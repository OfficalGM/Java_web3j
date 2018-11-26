package com.demo;


import com.demo.FBHT.FBHTree;
import com.demo.FBHT.HashUtil;
import com.demo.contract.Auth;
import org.web3j.crypto.Hash;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.*;


public class Demo {

    public static void main(String args[]) {
//        Properties properties = Load();
//        String web3Url = properties.getProperty("web3url");
//        String privateKey = properties.getProperty("privatekey");
//        Web3 web3 = new Web3();
//        String contractAddress = "0x9683Eeb68FE0d3dF151559670C83A40fBfD8472B";
//        String contractName = "Auth";
//        Contract auth = web3.LoadContract(privateKey, contractName, contractAddress);

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
