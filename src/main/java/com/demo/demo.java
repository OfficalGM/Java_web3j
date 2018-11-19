package com.demo;



import com.demo.FBHT.FBHT;
import com.demo.contract.Auth;
import com.demo.contract.Refund;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Hash;
import org.web3j.crypto.Sign;
import org.web3j.tx.Contract;
import org.web3j.utils.Numeric;

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
        String contractAddress="0x1478a2b11a36b67284422038abfedf5b6ba96c6c";
        String contractName="Auth";
        Contract auth=web3.LoadContract(privatekey,contractName,contractAddress);
        Credentials credentials = Credentials.create(privatekey);
        System.out.println("Address: " + credentials.getAddress());
        String str="AA";
        try {
            Sign.SignatureData signature=Sign.signMessage(str.getBytes("UTF-8"),credentials.getEcKeyPair());
            byte[] r=signature.getR();
            byte[] s=signature.getS();
            BigInteger v= new BigInteger(signature.getV()+"");
            byte[] hash=Hash.sha3(str.getBytes("UTF-8"));
            String respond=((Auth)auth).verify(hash,v,r,s).sendAsync().get();
            System.out.println(respond);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        //        web3.SignTransaction(privatekey,web3.GetNonce("0xA2Be5Cc6a7683EA3E3b0405E3169111db7DaC31A"),contractAddress);
//        try {
//            System.out.println(((Refund)refund).getBalance().sendAsync().get());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

//        FBHT fbht=new FBHT(3);
////        fbht.node_println();
//        for(int i=0;i<8;i++){
//            fbht.put(i+"");
//        }
//        fbht.node_println();
//        System.out.println(Arrays.toString(fbht.nodes[1].hash));
//        try {
////            ((Auth)auth).setTree(fbht.nodes[1].hash).sendAsync().get();
//            byte[] c=((Auth)auth).tree(BigInteger.ONE).sendAsync().get(10, TimeUnit.SECONDS);
//
////            System.out.println(Arrays.toString(c));
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (TimeoutException e) {
//            e.printStackTrace();
//        }


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
