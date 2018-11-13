package com.demo.contract;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.tx.Contract;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;


public class ContractFactory {

    public Contract LoadContract(String contractName, String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        if (contractName.equalsIgnoreCase("Refund")) {
            return new Refund(contractAddress,web3j,credentials,contractGasProvider);
        }
        return null;
    }
    //not finish
    public ContractGasProvider GetInfo(){
        ContractGasProvider contractGasProvider=new DefaultGasProvider();
        return contractGasProvider;
    }
}
