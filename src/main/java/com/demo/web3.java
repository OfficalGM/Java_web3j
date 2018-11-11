package com.demo;

import com.demo.contract.Refund;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthMining;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;
import org.web3j.tx.ManagedTransaction;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public class web3 {
    public String url;
    private Web3j web3j;
    public web3(){
        web3j=Web3j.build(new HttpService());
    }
    public web3(String url){
        this.url=url;
        web3j=Web3j.build(new HttpService(this.url));
    }
    public boolean GetMiningStatus(){
        EthMining ethMining = null;
        try {
            ethMining = web3j.ethMining().send();
        } catch (IOException e) {
            e.printStackTrace();
        }
        boolean isMining = ethMining.isMining();
        return isMining;
    }
    public BigInteger ConvertToWei(String _value, Convert.Unit uint){
        BigInteger value = Convert.toWei(_value, uint).toBigInteger();
        return value;
    }
    public BigInteger ConvertFromWei(String _value, Convert.Unit uint){
        BigInteger value = Convert.fromWei(_value, uint).toBigInteger();
        return value;
    }

    //deploy contract
    public void AA(){
        Credentials credentials=Credentials.create("af58e057cb1ccbcf31bed1dff0a56910e36a6e5b5c2e3e4cdcc742bbac662875");
        Refund refund=null;
        try {
            refund=Refund.deploy(web3j,credentials, ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT).send();
            System.out.println(refund.isValid());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //交易
    public void BB(){
        String toAddress = "0x85F53ADc4e0A109184A6E006C314E8430dfb0152";
        Credentials credentials=Credentials.create("af58e057cb1ccbcf31bed1dff0a56910e36a6e5b5c2e3e4cdcc742bbac662875");
        TransactionReceipt transactionReceipt = null;
        try {
            transactionReceipt = Transfer.sendFunds(web3j, credentials, toAddress, BigDecimal.valueOf(500), Convert.Unit.ETHER).send();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(transactionReceipt);
    }

}
