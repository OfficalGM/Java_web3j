package com.demo;


import com.demo.contract.Refund;
import org.web3j.tx.Contract;

import static org.web3j.utils.Convert.Unit.ETHER;

public class demo {

    public static void main(String args[]) throws Exception {
        String url="https://ropsten.infura.io/v3/";
        String privatekey="af58e057cb1ccbcf31bed1dff0a56910e36a6e5b5c2e3e4cdcc742bbac662875";
        Web3 web3=new Web3();
//        web3.GetMiningStatus();
//        String contractAddress="0xd44af5c682157f493ba2ebede6e0506428debf67";
        String contractAddress="0xf3fbadb5887a21a22215d7a86e8b41d0a6dc1efd";
        String contractName="Refund";

        System.out.println(web3.GetMiningStatus());
        System.out.println(web3.ConvertToWei("1", ETHER));
        System.out.println(web3.ConvertFromWei("5000000000000000000",ETHER));
        Contract refund=web3.LoadContract(privatekey,contractName,contractAddress);
//        System.out.println(((Refund)refund));
//        web3.SignTransaction(privatekey,web3.GetNonce("0xc222fDe7CaE05d8514DF13C901e4BEa3F23523cf"),contractAddress);
//        ((Refund)refund).refundBalance().send();
        System.out.println(((Refund)refund).owner().send());
//        web3.SignTransaction();
    }






}
