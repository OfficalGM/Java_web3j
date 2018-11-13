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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contract;
    }

    //簽署交易
    public void SignTransaction(String privatekey,BigInteger nonce,String toAddress) {
        Credentials credentials = Credentials.create(privatekey);
        BigInteger contractGasLimit = DefaultGasProvider.GAS_LIMIT;
        BigInteger contractGasPrice = DefaultGasProvider.GAS_PRICE;
        RawTransaction rawTransaction=RawTransaction.createTransaction(nonce,contractGasPrice,contractGasLimit,toAddress,ConvertToWei("5",ETHER),"pay");
        byte []signedMessage= TransactionEncoder.signMessage(rawTransaction,credentials);
        String hexValue = Numeric.toHexString(signedMessage);
        try {
            EthSendTransaction ethSendTransaction = web3j.ethSendRawTransaction(hexValue).send();
            System.out.println(ethSendTransaction.getTransactionHash());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public BigInteger GetNonce(String address){
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
