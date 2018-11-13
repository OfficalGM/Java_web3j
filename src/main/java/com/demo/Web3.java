package com.demo;

import com.demo.contract.ContractFactory;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.RawTransaction;
import org.web3j.crypto.TransactionEncoder;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.EthMining;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.utils.Convert;
import org.web3j.utils.Numeric;


import java.io.IOException;
import java.math.BigInteger;

import static org.web3j.utils.Convert.Unit.ETHER;


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
        Credentials credentials = Credentials.create("af58e057cb1ccbcf31bed1dff0a56910e36a6e5b5c2e3e4cdcc742bbac662875");
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
        Credentials credentials = Credentials.create("af58e057cb1ccbcf31bed1dff0a56910e36a6e5b5c2e3e4cdcc742bbac662875");
//        RawTransactionManager rawTransactionManager=new RawTransactionManager(web3j,credentials);
//        sendTransaction：数据签名和nonce的计算都由以太坊节点来完成，不需要我们关心
//        sendRawTransaction：数据签名和nonce需要外部处理好，再发送交易到以太坊节点
        String address = "0x4E82321967Cb2aF509A7FFf42F771e5Cda08A49c";
        BigInteger nonce=GetNonce(address);
        BigInteger contractGasLimit = DefaultGasProvider.GAS_LIMIT;
        BigInteger contractGasPrice = DefaultGasProvider.GAS_PRICE;
        String toaddress="0xf3fbadb5887a21a22215d7a86e8b41d0a6dc1efd";
//        RawTransaction rawTransaction=RawTransaction.createEtherTransaction(nonce,contractGasPrice,contractGasLimit,toaddress,ConvertToWei("500",ETHER));
//        byte []signedMessage= TransactionEncoder.signMessage(rawTransaction,credentials);
//        String hexValue = Numeric.toHexString(signedMessage);
//        try {
//            EthSendTransaction ethSendTransaction = web3j.ethSendRawTransaction(hexValue).send();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        RawTransaction rawTransaction=RawTransaction.createTransaction(nonce,contractGasPrice,contractGasLimit,toaddress,ConvertToWei("10",ETHER),"pay");
        byte []signedMessage= TransactionEncoder.signMessage(rawTransaction,credentials);
        String hexValue = Numeric.toHexString(signedMessage);
        try {
            EthSendTransaction ethSendTransaction = web3j.ethSendRawTransaction(hexValue).send();
            System.out.println(ethSendTransaction.getTransactionHash());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    private BigInteger GetNonce(String address){
        EthGetTransactionCount ethGetTransactionCount = null;
        try {
            ethGetTransactionCount = web3j.ethGetTransactionCount(
                    address, DefaultBlockParameterName.LATEST).send();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ethGetTransactionCount.getTransactionCount();
    }

}
