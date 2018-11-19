package com.demo;



import com.demo.FBHT.FBHT;
import com.demo.contract.Refund;
import org.web3j.tx.Contract;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutionException;


public class demo {

    public static void main(String args[]) {
//        String url="https://ropsten.infura.io/v3/";
//        String privatekey="43cbbbf7643cd3f8bdf54d70014cd5fcc313b243aadec7081d16c1ad04ee4b8f";
//        Web3 web3=new Web3();
//        String contractAddress="0x9683eeb68fe0d3df151559670c83a40fbfd8472b";
//        String contractName="Refund";
//        Contract refund=web3.LoadContract(privatekey,contractName,contractAddress);
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
        fbht.node_println();
        for(int i=0;i<1;i++){
            fbht.put(i+"");
        }
//        fbht.node_println();

//        try {
//            System.out.println(((Refund)refund).setTree().sendAsync().get());
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
    }






}
