package com.demo;


import com.demo.FBHT.FBHT;
import com.demo.FBHT.HashUtil;
import com.demo.contract.Auth;
import org.web3j.crypto.Hash;
import org.web3j.tx.Contract;
import org.web3j.utils.Numeric;

import java.io.FileInputStream;
import java.io.IOException;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutionException;



public class Demo {
    public static void main(String args[]) {
        Properties properties = Load();
        String web3Url = properties.getProperty("web3url");
        String privateKey = properties.getProperty("privatekey");
        Web3 web3 = new Web3();
        String contractAddress = "0xf3fbadb5887a21a22215d7a86e8b41d0a6dc1efd";
        String contractName = "Auth";
        Contract auth = web3.LoadContract(privateKey, contractName, contractAddress);
//        System.out.println(web3.signData(privatekey,"AA"));

        FBHT fbht = new FBHT(3);
        for (int i = 0; i < 2; i++) {
            fbht.put(i + "");
        }
        fbht.node_println();
////        System.out.println(fbht.calcLeafIndex("0"));//5
//        System.out.println(fbht.calcLeafIndex("4"));//7
        List<byte[]> list=fbht.getSlice("4");
        for(int i=0;i<list.size();i++){
            byte f[]=list.get(i);
            System.out.println(Arrays.toString(f));
        }
        System.out.println();



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
