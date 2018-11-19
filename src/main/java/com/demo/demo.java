package com.demo;



import com.demo.FBHT.FBHT;
import com.demo.contract.Auth;
import com.demo.contract.Refund;
import org.web3j.tx.Contract;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


public class demo {

    public static void main(String args[]) {
        Properties properties=Load();
        String web3url=properties.getProperty("web3url");
        String privatekey=properties.getProperty("privatekey");
//        System.out.println(privatekey);
//        String url="https://ropsten.infura.io/v3/";

        Web3 web3=new Web3();
        String contractAddress="0x33d528d43176854bf2E2041A2ff83525f2438B07";
        String contractName="Auth";
        Contract auth=web3.LoadContract(privatekey,contractName,contractAddress);
//
//        web3.SignTransaction(privatekey,web3.GetNonce("0xA2Be5Cc6a7683EA3E3b0405E3169111db7DaC31A"),contractAddress);
//        try {
//            System.out.println(((Refund)refund).getBalance().sendAsync().get());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

        FBHT fbht=new FBHT(3);
//        fbht.node_println();
        for(int i=0;i<8;i++){
            fbht.put(i+"");
        }
        fbht.node_println();
        System.out.println(Arrays.toString(fbht.nodes[1].hash));
        try {
//            ((Auth)auth).setTree(fbht.nodes[1].hash).sendAsync().get();
            byte[] c=((Auth)auth).tree(BigInteger.ONE).sendAsync().get(10, TimeUnit.SECONDS);

//            System.out.println(Arrays.toString(c));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }


    }
    public static Properties Load(){
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
