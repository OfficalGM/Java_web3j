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
    private static final String BINARY = "0x608060405234801561001057600080fd5b506109b9806100206000396000f3006080604052600436106100985763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416632d53b353811461009d57806331352936146100c4578063658b6ff9146100dc5780639201de5514610108578063b55b5cc014610195578063cfb51928146101aa578063d137d08214610203578063d490db8f1461025d578063f1835db7146102bb575b600080fd5b3480156100a957600080fd5b506100b2610308565b60408051918252519081900360200190f35b3480156100d057600080fd5b506100b26004356103ab565b3480156100e857600080fd5b506100f46004356103bd565b604080519115158252519081900360200190f35b34801561011457600080fd5b506101206004356103e9565b6040805160208082528351818301528351919283929083019185019080838360005b8381101561015a578181015183820152602001610142565b50505050905090810190601f1680156101875780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b3480156101a157600080fd5b506100b261052f565b3480156101b657600080fd5b506040805160206004803580820135601f81018490048402850184019095528484526100b29436949293602493928401919081908401838280828437509497506105359650505050505050565b34801561020f57600080fd5b506040805160206004602480358281013584810280870186019097528086526100f4968435963696604495919490910192918291850190849080828437509497506105599650505050505050565b34801561026957600080fd5b5060408051602060046024803582810135601f81018590048502860185019096528585526100f495833595369560449491939091019190819084018382808284375094975061075c9650505050505050565b3480156102c757600080fd5b506102df60043560ff60243516604435606435610801565b6040805173ffffffffffffffffffffffffffffffffffffffff9092168252519081900360200190f35b600060405160200180807f414100000000000000000000000000000000000000000000000000000000000081525060020190506040516020818303038152906040526040518082805190602001908083835b602083106103795780518252601f19909201916020918201910161035a565b6001836020036101000a0380198251168184511680821785525050505050509050019150506040518091039020905090565b60006020819052908152604090205481565b604080516020818101835283825260018054808201825560009081529182905292902090519055919050565b6040805160208082528183019092526060918291600091829182918591908082016104008038833901905050945060009350600092505b6020831015610495576008830260020a870291507fff0000000000000000000000000000000000000000000000000000000000000082161561048a5781858581518110151561046b57fe5b906020010190600160f860020a031916908160001a9053506001909301925b600190920191610420565b836040519080825280601f01601f1916602001820160405280156104c3578160200160208202803883390190505b509050600092505b838310156105255784838151811015156104e157fe5b90602001015160f860020a900460f860020a02818481518110151561050257fe5b906020010190600160f860020a031916908160001a9053506001909201916104cb565b9695505050505050565b60015481565b80516000908290151561054b5760009150610553565b602083015191505b50919050565b60006060600080600085511115156105d257604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601060248201527f736c6963652e6c656e677468203d203000000000000000000000000000000000604482015290519081900360640190fd5b5083516000190160028111156107535761061e61060886600184038151811015156105f957fe5b906020019060200201516103e9565b61061987848151811015156105f957fe5b61086e565b925061062983610535565b604080516020808201849052825180830382018152918301928390528151939550909282918401908083835b602083106106745780518252601f199092019160209182019101610655565b51815160209384036101000a60001901801990921691161790526040805192909401829003822080835293519397507f43301dc8c54bdbbd4d24a116f2ea756dc144e1d601c06f9216c219572b66ecdb95509083900301925050a17f48be4a73ee7b726ef98a6a0fbd09ca9e00722aa05b4ee6e7671daf8a3305d559856001600289040381518110151561070457fe5b602090810290910181015160408051918252519081900390910190a181856001600289040381518110151561073557fe5b60209081029091010151141561074e5760019350610753565b600093505b50505092915050565b600080600061076a84610535565b604080516020808201849052825180830382018152918301928390528151939550909282918401908083835b602083106107b55780518252601f199092019160209182019101610796565b5181516020939093036101000a600019018019909116921691909117905260405192018290039091209350505050848114156107f457600192506107f9565b600092505b505092915050565b604080516000808252602080830180855288905260ff87168385015260608301869052608083018590529251909260019260a080820193601f198101928190039091019086865af115801561085a573d6000803e3d6000fd5b5050604051601f1901519695505050505050565b606080606080606060008088955087945084518651016040519080825280601f01601f1916602001820160405280156108b1578160200160208202803883390190505b50935083925060009150600090505b855181101561091e5785818151811015156108d757fe5b90602001015160f860020a900460f860020a0283838060010194508151811015156108fe57fe5b906020010190600160f860020a031916908160001a9053506001016108c0565b5060005b845181101561098057848181518110151561093957fe5b90602001015160f860020a900460f860020a02838380600101945081518110151561096057fe5b906020010190600160f860020a031916908160001a905350600101610922565b50909796505050505050505600a165627a7a72305820420ff5811047d8755fd8aa5eafc9423fc6ac17ac5d57586f153140c1d415016c0029";

    public static final String FUNC_TREE = "tree";

    public static final String FUNC_TREENUMBER = "TreeNumber";

    public static final String FUNC_VERIFY = "verify";

    public static final String FUNC_SETTREE = "setTree";

    public static final String FUNC_SLICEROOTHASH = "SliceRootHash";

    public static final String FUNC_SETTEST = "setTest";

    public static final String FUNC_GETKECCAK256 = "getKeccak256";

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

    public RemoteCall<byte[]> getKeccak256() {
        final Function function = new Function(FUNC_GETKECCAK256, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
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
