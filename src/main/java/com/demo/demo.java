package com.demo;



import com.demo.FBHT.FBHT;

import static org.web3j.utils.Convert.Unit.ETHER;

public class demo {

    public static void main(String args[]) {
//        String url="https://ropsten.infura.io/v3/";
//        String privatekey="";
//        Web3 web3=new Web3();
//        web3.GetMiningStatus();
//        String contractAddress="0xd44af5c682157f493ba2ebede6e0506428debf67";
//        String contractAddress="";
//        String contractName="Refund";
//
//        System.out.println(web3.GetMiningStatus());
//        System.out.println(web3.ConvertToWei("1", ETHER));
//        System.out.println(web3.ConvertFromWei("5000000000000000000",ETHER));
//        Contract refund=web3.LoadContract(privatekey,contractName,contractAddress);
//        System.out.println(((Refund)refund));
//        web3.SignTransaction(privatekey,web3.GetNonce("0xc222fDe7CaE05d8514DF13C901e4BEa3F23523cf"),contractAddress);
//        try {
//            System.out.println(((Refund)refund).refundBalance().sendAsync().get());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//        System.out.println(((Refund)refund).getBalance().send());
//        System.out.println(((Refund)refund).refundBalance().send());
//        web3.SignTransaction();
        FBHT fbht=new FBHT(4);
        for(int i=0;i<8;i++){
            fbht.put(i+"");
        }
        fbht.node_println();
    }






}
