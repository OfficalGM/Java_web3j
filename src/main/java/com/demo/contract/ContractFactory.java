package com.demo.contract;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.tx.Contract;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;

import java.math.BigInteger;

public class ContractFactory {
    //not finish
    public Contract Deploy(String contractName, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) throws Exception {
        if (contractName.equalsIgnoreCase("Refund")) {
            return Refund.deploy(web3j, credentials, gasPrice, gasLimit).send();
        }
        return null;
    }

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
