package com.demo.contract;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
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
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;
import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.6.0.
 */
public class Refund extends Contract {
    private static final String BINARY = "0x608060405260008054600160a060020a03191633179055610485806100256000396000f3006080604052600436106100975763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041662f714ce811461014957806312065fe01461016f578063313529361461019657806354c7be31146101ae578063658b6ff9146101c35780638da5cb5b146101ef578063b55b5cc014610220578063cf0deba914610235578063f15a88371461024a575b60408051606081018252308152336020808301828152348486018181526001805480820182556000908152600386528890209651875473ffffffffffffffffffffffffffffffffffffffff19908116600160a060020a03928316178955945191880180549095169116179092559051600290940193909355835191825281019190915281517f81d2c188629cc4a1c694d285150cb5fa3dde3157a2684460d3ac7a1e331f6164929181900390910190a1005b34801561015557600080fd5b5061016d600435600160a060020a036024351661028c565b005b34801561017b57600080fd5b50610184610328565b60408051918252519081900360200190f35b3480156101a257600080fd5b5061018460043561032d565b3480156101ba57600080fd5b5061018461033f565b3480156101cf57600080fd5b506101db600435610345565b604080519115158252519081900360200190f35b3480156101fb57600080fd5b5061020461038e565b60408051600160a060020a039092168252519081900360200190f35b34801561022c57600080fd5b5061018461039d565b34801561024157600080fd5b5061016d6103a3565b34801561025657600080fd5b5061026260043561042b565b60408051600160a060020a0394851681529290931660208301528183015290519081900360600190f35b60008054600160a060020a031633146102a457600080fd5b50604051670de0b6b3a7640000830290600160a060020a0383169082156108fc029083906000818181858888f193505050501580156102e7573d6000803e3d6000fd5b50604080513381526020810183905281517fe0e5873eb9d996d2ab087b071a9a50522121c02b43308c8728c06739f52b3f87929181900390910190a1505050565b303190565b60046020526000908152604090205481565b60015481565b60008054600160a060020a0316331461035d57600080fd5b5060408051602081810183528382526002805460018082019092556000908152600490925292902090519055919050565b600054600160a060020a031681565b60025481565b60008054600160a060020a031633146103bb57600080fd5b50604051303190339082156108fc029083906000818181858888f193505050501580156103ec573d6000803e3d6000fd5b50604080513381526020810183905281517fe0e5873eb9d996d2ab087b071a9a50522121c02b43308c8728c06739f52b3f87929181900390910190a150565b600360205260009081526040902080546001820154600290920154600160a060020a039182169290911690835600a165627a7a723058204debee2ca27811534e40549d9a22b54aea986de81eea856e2a30206a6b0d44c50029";

    public static final String FUNC_TREE = "tree";

    public static final String FUNC_RECIPTENUMBER = "RecipteNumber";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_TREENUMBER = "TreeNumber";

    public static final String FUNC_RECIPTE = "recipte";

    public static final String FUNC_GETBALANCE = "getBalance";

    public static final String FUNC_REFUNDBALANCE = "refundBalance";

    public static final String FUNC_WITHDRAW = "withdraw";

    public static final String FUNC_SETTREE = "setTree";

    public static final Event LOGRECEIVEDFUNDS_EVENT = new Event("LogReceivedFunds", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event LOGRETURNEDFUNDS_EVENT = new Event("LogReturnedFunds", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
        _addresses.put("3", "0xd44af5c682157f493ba2ebede6e0506428debf67");
        _addresses.put("5777", "0x9683eeb68fe0d3df151559670c83a40fbfd8472b");
    }

    @Deprecated
    protected Refund(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Refund(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Refund(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Refund(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<byte[]> tree(BigInteger param0) {
        final Function function = new Function(FUNC_TREE, 
                Arrays.<Type>asList(new Uint256(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<BigInteger> RecipteNumber() {
        final Function function = new Function(FUNC_RECIPTENUMBER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> TreeNumber() {
        final Function function = new Function(FUNC_TREENUMBER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<Tuple3<String, String, BigInteger>> recipte(BigInteger param0) {
        final Function function = new Function(FUNC_RECIPTE, 
                Arrays.<Type>asList(new Uint256(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple3<String, String, BigInteger>>(
                new Callable<Tuple3<String, String, BigInteger>>() {
                    @Override
                    public Tuple3<String, String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<String, String, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue());
                    }
                });
    }

    public List<LogReceivedFundsEventResponse> getLogReceivedFundsEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(LOGRECEIVEDFUNDS_EVENT, transactionReceipt);
        ArrayList<LogReceivedFundsEventResponse> responses = new ArrayList<LogReceivedFundsEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            LogReceivedFundsEventResponse typedResponse = new LogReceivedFundsEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.sender = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<LogReceivedFundsEventResponse> logReceivedFundsEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, LogReceivedFundsEventResponse>() {
            @Override
            public LogReceivedFundsEventResponse call(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(LOGRECEIVEDFUNDS_EVENT, log);
                LogReceivedFundsEventResponse typedResponse = new LogReceivedFundsEventResponse();
                typedResponse.log = log;
                typedResponse.sender = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<LogReceivedFundsEventResponse> logReceivedFundsEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(LOGRECEIVEDFUNDS_EVENT));
        return logReceivedFundsEventObservable(filter);
    }

    public List<LogReturnedFundsEventResponse> getLogReturnedFundsEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(LOGRETURNEDFUNDS_EVENT, transactionReceipt);
        ArrayList<LogReturnedFundsEventResponse> responses = new ArrayList<LogReturnedFundsEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            LogReturnedFundsEventResponse typedResponse = new LogReturnedFundsEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.recipient = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<LogReturnedFundsEventResponse> logReturnedFundsEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, LogReturnedFundsEventResponse>() {
            @Override
            public LogReturnedFundsEventResponse call(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(LOGRETURNEDFUNDS_EVENT, log);
                LogReturnedFundsEventResponse typedResponse = new LogReturnedFundsEventResponse();
                typedResponse.log = log;
                typedResponse.recipient = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<LogReturnedFundsEventResponse> logReturnedFundsEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(LOGRETURNEDFUNDS_EVENT));
        return logReturnedFundsEventObservable(filter);
    }

    public RemoteCall<BigInteger> getBalance() {
        final Function function = new Function(FUNC_GETBALANCE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> refundBalance() {
        final Function function = new Function(
                FUNC_REFUNDBALANCE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> withdraw(BigInteger amount, String addr) {
        final Function function = new Function(
                FUNC_WITHDRAW, 
                Arrays.<Type>asList(new Uint256(amount),
                new Address(addr)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setTree(byte[] _roothash) {
        final Function function = new Function(
                FUNC_SETTREE, 
                Arrays.<Type>asList(new Bytes32(_roothash)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<Refund> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Refund.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Refund> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Refund.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Refund> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Refund.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Refund> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Refund.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static Refund load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Refund(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Refund load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Refund(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Refund load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Refund(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Refund load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Refund(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class LogReceivedFundsEventResponse {
        public Log log;

        public String sender;

        public BigInteger amount;
    }

    public static class LogReturnedFundsEventResponse {
        public Log log;

        public String recipient;

        public BigInteger amount;
    }
}
