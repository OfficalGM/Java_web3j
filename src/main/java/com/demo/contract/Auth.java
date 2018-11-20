package com.demo.contract;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
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
public class Auth extends Contract {
    private static final String BINARY = "0x608060405234801561001057600080fd5b506105a3806100206000396000f3006080604052600436106100825763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663313529368114610087578063658b6ff9146100b15780639201de55146100dd578063b55b5cc01461016a578063bfac4fbe1461017f578063cfb51928146101d6578063f1835db71461022f575b600080fd5b34801561009357600080fd5b5061009f60043561027c565b60408051918252519081900360200190f35b3480156100bd57600080fd5b506100c960043561028e565b604080519115158252519081900360200190f35b3480156100e957600080fd5b506100f56004356102ba565b6040805160208082528351818301528351919283929083019185019080838360005b8381101561012f578181015183820152602001610117565b50505050905090810190601f16801561015c5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561017657600080fd5b5061009f610468565b34801561018b57600080fd5b50604080516020600480358082013583810280860185019096528085526101d49536959394602494938501929182918501908490808284375094975061046e9650505050505050565b005b3480156101e257600080fd5b506040805160206004803580820135601f810184900484028501840190955284845261009f9436949293602493928401919081908401838280828437509497506104e69650505050505050565b34801561023b57600080fd5b5061025360043560ff6024351660443560643561050a565b6040805173ffffffffffffffffffffffffffffffffffffffff9092168252519081900360200190f35b60006020819052908152604090205481565b604080516020818101835283825260018054808201825560009081529182905292902090519055919050565b6040805160208082528183019092526060918291600091829182918591908082016104008038833901905050945060009350600092505b602083101561037e576008830260020a870291507fff000000000000000000000000000000000000000000000000000000000000008216156103735781858581518110151561033c57fe5b9060200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a9053506001909301925b6001909201916102f1565b836040519080825280601f01601f1916602001820160405280156103ac578160200160208202803883390190505b509050600092505b8383101561045e5784838151811015156103ca57fe5b9060200101517f010000000000000000000000000000000000000000000000000000000000000090047f010000000000000000000000000000000000000000000000000000000000000002818481518110151561042357fe5b9060200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a9053506001909201916103b4565b9695505050505050565b60015481565b7f01e584a59acd8408de91a297ccb473de8e648b621a4caf59fcd04f9def0aa073816040518080602001828103825283818151815260200191508051906020019060200280838360005b838110156104d05781810151838201526020016104b8565b505050509050019250505060405180910390a150565b8051600090829015156104fc5760009150610504565b602083015191505b50919050565b604080516000808252602080830180855288905260ff87168385015260608301869052608083018590529251909260019260a080820193601f198101928190039091019086865af1158015610563573d6000803e3d6000fd5b5050604051601f19015196955050505050505600a165627a7a72305820776ce22e18b0f3fb3bb1652e39097ebfe1a0fd642ffbe713f4a680571c2615fc0029";

    public static final String FUNC_TREE = "tree";

    public static final String FUNC_TREENUMBER = "TreeNumber";

    public static final String FUNC_VERIFY = "verify";

    public static final String FUNC_SETTREE = "setTree";

    public static final String FUNC_AA = "AA";

    public static final String FUNC_BYTES32TOSTRING = "bytes32ToString";

    public static final String FUNC_STRINGTOBYTES32 = "stringToBytes32";

    public static final Event H_EVENT = new Event("h",
            Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Bytes32>>() {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
        _addresses.put("5777", "0x33d528d43176854bf2e2041a2ff83525f2438b07");
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

    public RemoteCall<byte[]> tree(BigInteger param0) {
        final Function function = new Function(FUNC_TREE,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<BigInteger> TreeNumber() {
        final Function function = new Function(FUNC_TREENUMBER,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public List<HEventResponse> getHEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(H_EVENT, transactionReceipt);
        ArrayList<HEventResponse> responses = new ArrayList<HEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            HEventResponse typedResponse = new HEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.slice = (List<byte[]>) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<HEventResponse> hEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, HEventResponse>() {
            @Override
            public HEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(H_EVENT, log);
                HEventResponse typedResponse = new HEventResponse();
                typedResponse.log = log;
                typedResponse.slice = (List<byte[]>) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<HEventResponse> hEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(H_EVENT));
        return hEventObservable(filter);
    }

    public RemoteCall<String> verify(byte[] hash, BigInteger v, byte[] r, byte[] s) {
        final Function function = new Function(FUNC_VERIFY,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(hash),
                        new org.web3j.abi.datatypes.generated.Uint8(v),
                        new org.web3j.abi.datatypes.generated.Bytes32(r),
                        new org.web3j.abi.datatypes.generated.Bytes32(s)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> setTree(byte[] _roothash) {
        final Function function = new Function(
                FUNC_SETTREE,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_roothash)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> AA(List<byte[]> a) {
        final Function function = new Function(
                FUNC_AA,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.Utils.typeMap(a, org.web3j.abi.datatypes.generated.Bytes32.class))),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> bytes32ToString(byte[] x) {
        final Function function = new Function(FUNC_BYTES32TOSTRING,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(x)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<byte[]> stringToBytes32(String source) {
        final Function function = new Function(FUNC_STRINGTOBYTES32,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(source)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
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

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class HEventResponse {
        public Log log;

        public List<byte[]> slice;
    }
}
