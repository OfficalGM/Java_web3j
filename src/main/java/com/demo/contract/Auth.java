package com.demo.contract;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to updagetLostTxEventste.
 *
 * <p>Generated with web3j version 4.0.1.
 */
public class Auth extends Contract {
    private static final String BINARY = "0x608060405260008054600160a060020a03191633179055610679806100256000396000f30060806040526004361061008d5763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663024cd19b81146100925780632ca151221461010057806366503315146101315780636b30ad23146101585780637d24a89d146101705780638da5cb5b14610188578063c29d6a7a1461019d578063f1835db7146101c3575b600080fd5b34801561009e57600080fd5b506040805160206004602480358281013584810280870186019097528086526100ec968435963696604495919490910192918291850190849080828437509497506101e79650505050505050565b604080519115158252519081900360200190f35b34801561010c57600080fd5b5061011561036b565b60408051600160a060020a039092168252519081900360200190f35b34801561013d57600080fd5b5061014661037a565b60408051918252519081900360200190f35b34801561016457600080fd5b50610146600435610380565b34801561017c57600080fd5b50610146600435610392565b34801561019457600080fd5b506101156103dd565b3480156101a957600080fd5b506101c160043560ff602435166044356064356103ec565b005b3480156101cf57600080fd5b5061011560043560ff602435166044356064356104e3565b600080600080600080865111151561026057604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601060248201527f736c6963652e6c656e677468203d203000000000000000000000000000000000604482015290519081900360640190fd5b50508351859150600090600019015b600181111561036157600283049250856001820381518110151561028f57fe5b9060200190602002015186828151811015156102a757fe5b6020908102909101810151604080518084019490945283810191909152805180840382018152606090930190819052825190918291908401908083835b602083106103035780518252601f1990920191602091820191016102e4565b6001836020036101000a03801982511681845116808217855250505050505090500191505060405180910390209350610356866001850381518110151561034657fe5b9060200190602002015185610578565b91506002900461026f565b5095945050505050565b600354600160a060020a031681565b60025481565b60016020526000908152604090205481565b60008054600160a060020a031633146103aa57600080fd5b50604080516020818101835283825260028054600181810183556000918252909252929020905190555460001901919050565b600054600160a060020a031681565b3360006103fb868686866104e3565b6003805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0383811691821790925591925083161461049857604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601260248201527f7369676e61747572652069732077726f6e670000000000000000000000000000604482015290519081900360640190fd5b60408051878152600160a060020a038316602082015281517f2404264c3202763e8c2d4679f09d587364ef7c02f6d94b650c89a6c44e075eea929181900390910190a1505050505050565b604080516000808252602080830180855288905260ff87168385015260608301869052608083018590529251909260019260a080820193601f198101928190039091019086865af115801561053c573d6000803e3d6000fd5b5050604051601f1901516003805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0383161790559695505050505050565b6000805b60208110156106415783816020811061059157fe5b1a7f0100000000000000000000000000000000000000000000000000000000000000027effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff191683826020811015156105e457fe5b1a7f0100000000000000000000000000000000000000000000000000000000000000027effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff19161415156106395760009150610646565b60010161057c565b600191505b50929150505600a165627a7a7230582082d98fa3a043cc728791e84c86fb9279b403d6594cfa5d5af0a0c2586a0b19920029";

    public static final String FUNC_SIGN = "sign";

    public static final String FUNC_TREENUMBER = "treeNumber";

    public static final String FUNC_CLEARANCERECORDS = "clearanceRecords";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_VERIFY = "verify";

    public static final String FUNC_WRITECLEARANCERECORDS = "writeClearanceRecords";

    public static final String FUNC_SLICEROOTHASH = "sliceRootHash";

    public static final String FUNC_LOSTTRANSACTION = "lostTransaction";

    public static final Event LOSTTX_EVENT = new Event("lostTx",
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Address>() {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
        _addresses.put("5777", "0x9683eeb68fe0d3df151559670c83a40fbfd8472b");
    }

    @Deprecated
    protected Auth(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Auth(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Auth(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Auth(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<String> sign() {
        final Function function = new Function(FUNC_SIGN,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> treeNumber() {
        final Function function = new Function(FUNC_TREENUMBER,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<byte[]> clearanceRecords(BigInteger param0) {
        final Function function = new Function(FUNC_CLEARANCERECORDS,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<String> owner() {
        final Function function = new Function(FUNC_OWNER,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public List<LostTxEventResponse> getLostTxEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(LOSTTX_EVENT, transactionReceipt);
        ArrayList<LostTxEventResponse> responses = new ArrayList<LostTxEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            LostTxEventResponse typedResponse = new LostTxEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.tx = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.signature = (String) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<LostTxEventResponse> lostTxEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, LostTxEventResponse>() {
            @Override
            public LostTxEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(LOSTTX_EVENT, log);
                LostTxEventResponse typedResponse = new LostTxEventResponse();
                typedResponse.log = log;
                typedResponse.tx = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.signature = (String) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<LostTxEventResponse> lostTxEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(LOSTTX_EVENT));
        return lostTxEventFlowable(filter);
    }

    public RemoteCall<TransactionReceipt> verify(byte[] hash, BigInteger v, byte[] r, byte[] s) {
        final Function function = new Function(
                FUNC_VERIFY,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(hash),
                        new org.web3j.abi.datatypes.generated.Uint8(v),
                        new org.web3j.abi.datatypes.generated.Bytes32(r),
                        new org.web3j.abi.datatypes.generated.Bytes32(s)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> writeClearanceRecords(byte[] _rootHash) {
        final Function function = new Function(
                FUNC_WRITECLEARANCERECORDS,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_rootHash)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Boolean> sliceRootHash(BigInteger idx, List<byte[]> slice) {
        final Function function = new Function(FUNC_SLICEROOTHASH,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(idx),
                        new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                                org.web3j.abi.Utils.typeMap(slice, org.web3j.abi.datatypes.generated.Bytes32.class))),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> lostTransaction(byte[] _tx, BigInteger v, byte[] r, byte[] s) {
        final Function function = new Function(
                FUNC_LOSTTRANSACTION,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_tx),
                        new org.web3j.abi.datatypes.generated.Uint8(v),
                        new org.web3j.abi.datatypes.generated.Bytes32(r),
                        new org.web3j.abi.datatypes.generated.Bytes32(s)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Auth load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Auth(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Auth load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Auth(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Auth load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Auth(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Auth load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Auth(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Auth> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Auth.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Auth> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Auth.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Auth> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Auth.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Auth> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Auth.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class LostTxEventResponse {
        public Log log;

        public byte[] tx;

        public String signature;
    }
}
