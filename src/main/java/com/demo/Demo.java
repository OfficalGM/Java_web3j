package com.demo;


import com.demo.FBHT.FBHT;
import com.demo.contract.Auth;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
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
        String contractAddress = "0x9683Eeb68FE0d3dF151559670C83A40fBfD8472B";
        String contractName = "Auth";
        Contract auth = web3.LoadContract(privateKey, contractName, contractAddress);


        FBHT fbht = new FBHT(3);

        for (int i = 0; i < 2; i++) {
            fbht.put(i + "");
        }
        fbht.node_println();
//        System.out.println(fbht.calcLeafIndex("0"));//5
//        System.out.println(fbht.calcLeafIndex("1"));//7
        System.out.println(Arrays.toString(fbht.nodes[5].hash));
        List list = web3.signData(privateKey, "0");
        try {
//            TransactionReceipt transactionReceipt=((Auth) auth).verify((byte[])list.get(0),new BigInteger((byte[]) list.get(1)),(byte[])list.get(2),(byte[])list.get(3)).sendAsync().get();
            TransactionReceipt transactionReceipt = ((Auth) auth).lostTransaction(fbht.nodes[5].hash, new BigInteger((byte[]) list.get(1)), (byte[]) list.get(2), (byte[]) list.get(3)).sendAsync().get();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


//        List<byte[]> list=fbht.getSlice("4");
//        for(int i=0;i<list.size();i++){
//            byte f[]=list.get(i);
//            System.out.println(Arrays.toString(f));
//        }


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
