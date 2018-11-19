package com.demo;



import com.demo.FBHT.FBHT;
import com.demo.contract.Auth;
import org.web3j.tx.Contract;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Properties;
import java.util.concurrent.ExecutionException;


public class demo {

    public static void main(String args[]) {
        Properties properties=Load();
        String web3url=properties.getProperty("web3url");
        String privatekey=properties.getProperty("privatekey");
//        System.out.println(privatekey);
        Web3 web3=new Web3();
        String contractAddress="0x33d528d43176854bf2e2041a2ff83525f2438b07";
        String contractName="Auth";
        Contract auth=web3.LoadContract(privatekey,contractName,contractAddress);


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
        for(int i=0;i<4;i++){
            fbht.put(i+"");
        }
//        fbht.node_println();
        try {
//            ((Auth)auth).setTree(fbht.nodes[1].hash).sendAsync().get();

            System.out.println( ((Auth)auth).tree(BigInteger.ONE).sendAsync().get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

//        fbht.node_println();





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
