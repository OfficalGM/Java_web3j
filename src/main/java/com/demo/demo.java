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
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


public class demo {

    public static void main(String args[]) {
        Properties properties=Load();
        String web3url=properties.getProperty("web3url");
        String privatekey=properties.getProperty("privatekey");
//        String url="https://ropsten.infura.io/v3/";

        Web3 web3=new Web3();
        String contractAddress="0x33d528d43176854bf2e2041a2ff83525f2438b07";
        String contractName="Auth";
        Contract auth=web3.LoadContract(privatekey,contractName,contractAddress);
//        System.out.println(web3.signData(privatekey,"AA"));
        try {
            byte a[]=((Auth)auth).stringToBytes32("AA").sendAsync().get();
            System.out.println(Arrays.toString(a));
            System.out.println(((Auth)auth).bytes32ToString(a).sendAsync().get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
//        FBHT fbht=new FBHT(3);
//        for(int i=0;i<2;i++){
//            fbht.put(i+"");
//        }
//        fbht.node_println();
//        System.out.println(fbht.calcLeafIndex("0"));//5
//        System.out.println(fbht.calcLeafIndex("1"));//7
//        List<byte[]> list=fbht.getSlice("0");
//        try {
//            System.out.println(((Auth)auth).AA(list).sendAsync().get());
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

//        ((Auth)auth).SliceRootHash() list bytes

//        byte []
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
