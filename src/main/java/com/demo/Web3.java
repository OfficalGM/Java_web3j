package com.demo;

import com.demo.contract.ContractFactory;
import com.demo.contract.Refund;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthMining;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.utils.Convert;

import java.io.IOException;
import java.math.BigInteger;


public class Web3 {
    public String url;
    private Web3j web3j;

    public Web3() {
        web3j = Web3j.build(new HttpService());
    }

    public Web3(String url) {
        this.url = url;
        web3j = Web3j.build(new HttpService(this.url));
    }

    public boolean GetMiningStatus() {
        EthMining ethMining = null;
        try {
            ethMining = web3j.ethMining().send();
        } catch (IOException e) {
            e.printStackTrace();
        }
        boolean isMining = ethMining.isMining();
        return isMining;
    }

    public BigInteger ConvertToWei(String _value, Convert.Unit uint) {
        BigInteger value = Convert.toWei(_value, uint).toBigInteger();
        return value;
    }

    public BigInteger ConvertFromWei(String _value, Convert.Unit uint) {
        BigInteger value = Convert.fromWei(_value, uint).toBigInteger();
        return value;
    }
    public Contract LoadContract(String contractName, String contractAddress) {
        Credentials credentials = Credentials.create("43cbbbf7643cd3f8bdf54d70014cd5fcc313b243aadec7081d16c1ad04ee4b8f");
        Contract contract = null;
        ContractFactory contractFactory = new ContractFactory();
        BigInteger contractGasLimit = DefaultGasProvider.GAS_LIMIT;
        BigInteger contractGasPrice = DefaultGasProvider.GAS_PRICE;
        try {
            contract = contractFactory.LoadContract(contractName, contractAddress, web3j, credentials, contractGasPrice, contractGasLimit);
//            contract= Refund.load(contractAddress, web3j, credentials, contractGasPrice, contractGasLimit);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return contract;
    }

    //簽署交易
    public void SignTransaction() {
        Credentials credentials = Credentials.create("43cbbbf7643cd3f8bdf54d70014cd5fcc313b243aadec7081d16c1ad04ee4b8f");
        RawTransactionManager rawTransactionManager=new RawTransactionManager(web3j,credentials);
//        System.out.println(rawTransactionManager.);

    }


}
