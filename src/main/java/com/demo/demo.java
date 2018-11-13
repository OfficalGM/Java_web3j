package com.demo;


import static org.web3j.utils.Convert.Unit.ETHER;

public class demo {

    public static void main(String args[]) throws Exception {
        Web3 web3=new Web3();
//        web3.GetMiningStatus();
        String contractAddress="0x9683eeb68fe0d3df151559670c83a40fbfd8472b";
        String contractName="Refund";
        System.out.println(web3.GetMiningStatus());
        System.out.println(web3.ConvertToWei("1", ETHER));
        System.out.println(web3.ConvertFromWei("5000000000000000000",ETHER));
//        web3.LoadContract(contractName,contractAddress);
        web3.SignTransaction();
    }






}
