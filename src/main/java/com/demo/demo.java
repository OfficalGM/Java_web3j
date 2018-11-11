package com.demo;


import static org.web3j.utils.Convert.Unit.ETHER;

public class demo {

    public static void main(String args[]) throws Exception {
        web3 web3=new web3();
//        web3.GetMiningStatus();
        System.out.println(web3.GetMiningStatus());
        System.out.println(web3.ConvertToWei("1", ETHER));
        System.out.println(web3.ConvertFromWei("5000000000000000000",ETHER));
        web3.AA();

    }






}
