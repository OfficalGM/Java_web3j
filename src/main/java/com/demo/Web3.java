package com.demo;

import com.demo.contract.Auth;
import com.demo.contract.ContractFactory;
import org.web3j.crypto.*;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.EthMining;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.utils.Convert;
import org.web3j.utils.Numeric;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.concurrent.ExecutionException;

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

    public Contract LoadContract(String secretKey, String contractName, String contractAddress) {
        Credentials credentials = Credentials.create(secretKey);
        Contract contract = null;
        ContractFactory contractFactory = new ContractFactory();
        try {
            ContractGasProvider contractGasProvider = contractFactory.GetInfo();
            contract = contractFactory.LoadContract(contractName, contractAddress, web3j, credentials, contractGasProvider);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contract;
    }

    //簽署交易
    public String SignTransaction(String secretKey, BigInteger nonce, String toAddress) {
        Credentials credentials = Credentials.create(secretKey);
        BigInteger contractGasLimit = DefaultGasProvider.GAS_LIMIT;
        BigInteger contractGasPrice = DefaultGasProvider.GAS_PRICE;
        RawTransaction rawTransaction = RawTransaction.createTransaction(nonce, contractGasPrice, contractGasLimit, toAddress, ConvertToWei("10", ETHER), "pay");
        byte[] signedMessage = TransactionEncoder.signMessage(rawTransaction, credentials);
        String hexValue = Numeric.toHexString(signedMessage);
        EthSendTransaction ethSendTransaction = null;
        try {
            ethSendTransaction = web3j.ethSendRawTransaction(hexValue).sendAsync().get();
            return ethSendTransaction.getTransactionHash();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    public BigInteger GetNonce(String address) {
        EthGetTransactionCount ethGetTransactionCount = null;
        try {
            ethGetTransactionCount = web3j.ethGetTransactionCount(
                    address, DefaultBlockParameterName.LATEST).send();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ethGetTransactionCount.getTransactionCount();
    }

    public void signData(String secretKey, String data) {
        Credentials credentials = Credentials.create(secretKey);
        try {

            Sign.SignatureData signature = Sign.signMessage(data.getBytes("UTF-8"), credentials.getEcKeyPair());
            byte[] hash = Hash.sha3(data.getBytes("UTF-8"));
            BigInteger v = new BigInteger(signature.getV() + "");
            byte[] r = signature.getR();
            byte[] s = signature.getS();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
