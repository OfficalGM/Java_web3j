package com.demo;



import com.demo.FBHT.FBHT;
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
;


public class demo {
    public static void main(String args[]) {
        Properties properties=Load();
        String web3url=properties.getProperty("web3url");
        String privatekey=properties.getProperty("privatekey");
//        String url="https://ropsten.infura.io/v3/";

        Web3 web3=new Web3();
        String contractAddress="0x1478a2b11a36b67284422038abfedf5b6ba96c6c";
        String contractName="Auth";
        Contract auth=web3.LoadContract(privatekey,contractName,contractAddress);
//        System.out.println(web3.signData(privatekey,"AA"));
//        try {
//            byte a[]=((Auth)auth).stringToBytes32("AA").sendAsync().get();
//            System.out.println(Arrays.toString(a));
//            System.out.println(((Auth)auth).bytes32ToString(a).sendAsync().get());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
        FBHT fbht=new FBHT(3);
        for(int i=0;i<2;i++){
            fbht.put(i+"");
        }
        fbht.node_println();
//        System.out.println(fbht.calcLeafIndex("0"));//5
//        System.out.println(fbht.calcLeafIndex("1"));//7
//        System.out.println(fbht.calcLeafIndex("4"));//6
//        List<byte[]> list=fbht.getSlice("4");

        try {
//            byte[] a=
            byte[] a=((Auth)auth).getKeccak256().sendAsync().get();
            byte[] b=Hash.sha3("AA".getBytes(StandardCharsets.UTF_8));
            System.out.println(a);
            System.out.println(b);
            System.out.println(Arrays.toString(a));
            System.out.println(Arrays.toString(b));
            System.out.println(((Auth)auth).setTest(Hash.sha3("AA".getBytes(StandardCharsets.UTF_8)),"AA").sendAsync().get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

//        for(int i=list.size()-1;i>=0;i--){
//            byte[] s=list.get(i);
//            System.out.println(Numeric.toHexStringNoPrefix(s));
//        }
//
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
