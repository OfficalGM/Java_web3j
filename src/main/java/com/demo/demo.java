package com.demo;


import com.demo.contract.Refund;
import org.web3j.tx.Contract;

import static org.web3j.utils.Convert.Unit.ETHER;

public class demo {

    public static void main(String args[]) throws Exception {
        String url="https://ropsten.infura.io/v3/";
        String privatekey="";
        Web3 web3=new Web3(url);
//        web3.GetMiningStatus();
        String contractAddress="0xd44af5c682157f493ba2ebede6e0506428debf67";
        String contractName="Refund";
        System.out.println(web3.GetMiningStatus());
        System.out.println(web3.ConvertToWei("1", ETHER));
        System.out.println(web3.ConvertFromWei("5000000000000000000",ETHER));
        Contract refund=web3.LoadContract(contractName,contractAddress);
//        System.out.println(((Refund)refund));
//        web3.SignTransaction(privatekey,web3.GetNonce("0xc222fDe7CaE05d8514DF13C901e4BEa3F23523cf"),contractAddress);
        ((Refund)refund).refundBalance().send();
//        System.out.println(((Refund)refund).getBalance().send());
//        web3.SignTransaction();
    }






}
