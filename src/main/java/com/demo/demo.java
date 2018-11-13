package com.demo;


import com.demo.contract.Refund;
import org.web3j.tx.Contract;

import static org.web3j.utils.Convert.Unit.ETHER;

public class demo {

    public static void main(String args[]) throws Exception {
        Web3 web3=new Web3();
//        web3.GetMiningStatus();
        String contractAddress="0xf3fbadb5887a21a22215d7a86e8b41d0a6dc1efd";
        String contractName="Refund";
        System.out.println(web3.GetMiningStatus());
        System.out.println(web3.ConvertToWei("1", ETHER));
        System.out.println(web3.ConvertFromWei("5000000000000000000",ETHER));
        Contract refund=web3.LoadContract(contractName,contractAddress);
//        System.out.println(((Refund)refund));
        web3.SignTransaction();
        System.out.println(((Refund)refund).getBalance().send());
//        web3.SignTransaction();
    }






}
