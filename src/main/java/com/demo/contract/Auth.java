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
import org.web3j.abi.datatypes.Bool;
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
    private static final String BINARY = "0x608060405234801561001057600080fd5b50610894806100206000396000f30060806040526004361061008d5763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663313529368114610092578063658b6ff9146100bc5780639201de55146100e8578063b55b5cc014610175578063cfb519281461018a578063d137d082146101e3578063d490db8f1461023d578063f1835db71461029b575b600080fd5b34801561009e57600080fd5b506100aa6004356102e8565b60408051918252519081900360200190f35b3480156100c857600080fd5b506100d46004356102fa565b604080519115158252519081900360200190f35b3480156100f457600080fd5b50610100600435610326565b6040805160208082528351818301528351919283929083019185019080838360005b8381101561013a578181015183820152602001610122565b50505050905090810190601f1680156101675780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561018157600080fd5b506100aa61046c565b34801561019657600080fd5b506040805160206004803580820135601f81018490048402850184019095528484526100aa9436949293602493928401919081908401838280828437509497506104729650505050505050565b3480156101ef57600080fd5b506040805160206004602480358281013584810280870186019097528086526100d4968435963696604495919490910192918291850190849080828437509497506104969650505050505050565b34801561024957600080fd5b5060408051602060046024803582810135601f81018590048502860185019096528585526100d49583359536956044949193909101919081908401838280828437509497506106999650505050505050565b3480156102a757600080fd5b506102bf60043560ff602435166044356064356106dc565b6040805173ffffffffffffffffffffffffffffffffffffffff9092168252519081900360200190f35b60006020819052908152604090205481565b604080516020818101835283825260018054808201825560009081529182905292902090519055919050565b6040805160208082528183019092526060918291600091829182918591908082016104008038833901905050945060009350600092505b60208310156103d2576008830260020a870291507fff000000000000000000000000000000000000000000000000000000000000008216156103c7578185858151811015156103a857fe5b906020010190600160f860020a031916908160001a9053506001909301925b60019092019161035d565b836040519080825280601f01601f191660200182016040528015610400578160200160208202803883390190505b509050600092505b8383101561046257848381518110151561041e57fe5b90602001015160f860020a900460f860020a02818481518110151561043f57fe5b906020010190600160f860020a031916908160001a905350600190920191610408565b9695505050505050565b60015481565b8051600090829015156104885760009150610490565b602083015191505b50919050565b600060606000806000855111151561050f57604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601060248201527f736c6963652e6c656e677468203d203000000000000000000000000000000000604482015290519081900360640190fd5b5083516000190160028111156106905761055b610545866001840381518110151561053657fe5b90602001906020020151610326565b610556878481518110151561053657fe5b610749565b925061056683610472565b604080516020808201849052825180830382018152918301928390528151939550909282918401908083835b602083106105b15780518252601f199092019160209182019101610592565b51815160209384036101000a60001901801990921691161790526040805192909401829003822080835293519397507f43301dc8c54bdbbd4d24a116f2ea756dc144e1d601c06f9216c219572b66ecdb95509083900301925050a17f48be4a73ee7b726ef98a6a0fbd09ca9e00722aa05b4ee6e7671daf8a3305d559856001600289040381518110151561064157fe5b602090810290910181015160408051918252519081900390910190a181856001600289040381518110151561067257fe5b60209081029091010151141561068b5760019350610690565b600093505b50505092915050565b60008060006106a784610472565b6040805182815290519081900360200190209092509050848114156106cf57600192506106d4565b600092505b505092915050565b604080516000808252602080830180855288905260ff87168385015260608301869052608083018590529251909260019260a080820193601f198101928190039091019086865af1158015610735573d6000803e3d6000fd5b5050604051601f1901519695505050505050565b606080606080606060008088955087945084518651016040519080825280601f01601f19166020018201604052801561078c578160200160208202803883390190505b50935083925060009150600090505b85518110156107f95785818151811015156107b257fe5b90602001015160f860020a900460f860020a0283838060010194508151811015156107d957fe5b906020010190600160f860020a031916908160001a90535060010161079b565b5060005b845181101561085b57848181518110151561081457fe5b90602001015160f860020a900460f860020a02838380600101945081518110151561083b57fe5b906020010190600160f860020a031916908160001a9053506001016107fd565b50909796505050505050505600a165627a7a723058207698fcf28826271f251be6cb2b9dae0bc1fdf488881f6d906d2ffc7bd53871d30029";

    public static final String FUNC_TREE = "tree";

    public static final String FUNC_TREENUMBER = "TreeNumber";

    public static final String FUNC_VERIFY = "verify";

    public static final String FUNC_SETTREE = "setTree";

    public static final String FUNC_SLICEROOTHASH = "SliceRootHash";

    public static final String FUNC_SETTEST = "setTest";

    public static final String FUNC_BYTES32TOSTRING = "bytes32ToString";

    public static final String FUNC_STRINGTOBYTES32 = "stringToBytes32";

    public static final Event RH_EVENT = new Event("RH", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
    ;

    public static final Event RH2_EVENT = new Event("RH2", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
        _addresses.put("5777", "0x1478a2b11a36b67284422038abfedf5b6ba96c6c");
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

    public List<RHEventResponse> getRHEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(RH_EVENT, transactionReceipt);
        ArrayList<RHEventResponse> responses = new ArrayList<RHEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            RHEventResponse typedResponse = new RHEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.b = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<RHEventResponse> rHEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, RHEventResponse>() {
            @Override
            public RHEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(RH_EVENT, log);
                RHEventResponse typedResponse = new RHEventResponse();
                typedResponse.log = log;
                typedResponse.b = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<RHEventResponse> rHEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(RH_EVENT));
        return rHEventObservable(filter);
    }

    public List<RH2EventResponse> getRH2Events(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(RH2_EVENT, transactionReceipt);
        ArrayList<RH2EventResponse> responses = new ArrayList<RH2EventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            RH2EventResponse typedResponse = new RH2EventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.b = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<RH2EventResponse> rH2EventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, RH2EventResponse>() {
            @Override
            public RH2EventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(RH2_EVENT, log);
                RH2EventResponse typedResponse = new RH2EventResponse();
                typedResponse.log = log;
                typedResponse.b = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<RH2EventResponse> rH2EventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(RH2_EVENT));
        return rH2EventObservable(filter);
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

    public RemoteCall<TransactionReceipt> SliceRootHash(BigInteger idx, List<byte[]> slice) {
        final Function function = new Function(
                FUNC_SLICEROOTHASH, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(idx), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.Utils.typeMap(slice, org.web3j.abi.datatypes.generated.Bytes32.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Boolean> setTest(byte[] _h, String _s) {
        final Function function = new Function(FUNC_SETTEST, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_h), 
                new org.web3j.abi.datatypes.Utf8String(_s)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
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

    public static class RHEventResponse {
        public Log log;

        public byte[] b;
    }

    public static class RH2EventResponse {
        public Log log;

        public byte[] b;
    }
}
