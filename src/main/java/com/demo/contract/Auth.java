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
    private static final String BINARY = "0x608060405234801561001057600080fd5b506109be806100206000396000f3006080604052600436106100985763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416632d53b353811461009d57806331352936146100c4578063658b6ff9146100dc5780639201de5514610108578063b55b5cc014610195578063cfb51928146101aa578063d137d08214610203578063e66773bd1461025d578063f1835db714610278575b600080fd5b3480156100a957600080fd5b506100b26102c5565b60408051918252519081900360200190f35b3480156100d057600080fd5b506100b2600435610368565b3480156100e857600080fd5b506100f460043561037a565b604080519115158252519081900360200190f35b34801561011457600080fd5b506101206004356103a6565b6040805160208082528351818301528351919283929083019185019080838360005b8381101561015a578181015183820152602001610142565b50505050905090810190601f1680156101875780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b3480156101a157600080fd5b506100b26104ec565b3480156101b657600080fd5b506040805160206004803580820135601f81018490048402850184019095528484526100b29436949293602493928401919081908401838280828437509497506104f29650505050505050565b34801561020f57600080fd5b506040805160206004602480358281013584810280870186019097528086526100f4968435963696604495919490910192918291850190849080828437509497506105169650505050505050565b34801561026957600080fd5b506100f4600435602435610719565b34801561028457600080fd5b5061029c60043560ff60243516604435606435610806565b6040805173ffffffffffffffffffffffffffffffffffffffff9092168252519081900360200190f35b600060405160200180807f414100000000000000000000000000000000000000000000000000000000000081525060020190506040516020818303038152906040526040518082805190602001908083835b602083106103365780518252601f199092019160209182019101610317565b6001836020036101000a0380198251168184511680821785525050505050509050019150506040518091039020905090565b60006020819052908152604090205481565b604080516020818101835283825260018054808201825560009081529182905292902090519055919050565b6040805160208082528183019092526060918291600091829182918591908082016104008038833901905050945060009350600092505b6020831015610452576008830260020a870291507fff000000000000000000000000000000000000000000000000000000000000008216156104475781858581518110151561042857fe5b906020010190600160f860020a031916908160001a9053506001909301925b6001909201916103dd565b836040519080825280601f01601f191660200182016040528015610480578160200160208202803883390190505b509050600092505b838310156104e257848381518110151561049e57fe5b90602001015160f860020a900460f860020a0281848151811015156104bf57fe5b906020010190600160f860020a031916908160001a905350600190920191610488565b9695505050505050565b60015481565b8051600090829015156105085760009150610510565b602083015191505b50919050565b600060606000806000855111151561058f57604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601060248201527f736c6963652e6c656e677468203d203000000000000000000000000000000000604482015290519081900360640190fd5b508351600019016002811115610710576105db6105c586600184038151811015156105b657fe5b906020019060200201516103a6565b6105d687848151811015156105b657fe5b610873565b92506105e6836104f2565b604080516020808201849052825180830382018152918301928390528151939550909282918401908083835b602083106106315780518252601f199092019160209182019101610612565b51815160209384036101000a60001901801990921691161790526040805192909401829003822080835293519397507f43301dc8c54bdbbd4d24a116f2ea756dc144e1d601c06f9216c219572b66ecdb95509083900301925050a17f48be4a73ee7b726ef98a6a0fbd09ca9e00722aa05b4ee6e7671daf8a3305d55985600160028904038151811015156106c157fe5b602090810290910181015160408051918252519081900390910190a18185600160028904038151811015156106f257fe5b60209081029091010151141561070b5760019350610710565b600093505b50505092915050565b60408051602080820184905282518083038201815291830192839052815160009384938493909282918401908083835b602083106107685780518252601f199092019160209182019101610749565b6001836020036101000a03801982511681845116808217855250505050505090500191505060405180910390209150600090505b60208110156107f9578481602081106107b157fe5b1a60f860020a02600160f860020a03191682826020811015156107d057fe5b1a60f860020a02600160f860020a0319161415156107f157600092506107fe565b60010161079c565b600192505b505092915050565b604080516000808252602080830180855288905260ff87168385015260608301869052608083018590529251909260019260a080820193601f198101928190039091019086865af115801561085f573d6000803e3d6000fd5b5050604051601f1901519695505050505050565b606080606080606060008088955087945084518651016040519080825280601f01601f1916602001820160405280156108b6578160200160208202803883390190505b50935083925060009150600090505b85518110156109235785818151811015156108dc57fe5b90602001015160f860020a900460f860020a02838380600101945081518110151561090357fe5b906020010190600160f860020a031916908160001a9053506001016108c5565b5060005b845181101561098557848181518110151561093e57fe5b90602001015160f860020a900460f860020a02838380600101945081518110151561096557fe5b906020010190600160f860020a031916908160001a905350600101610927565b50909796505050505050505600a165627a7a723058204a76909882e76c5358bc843a5a6c4e610f99f4499b95bb629dedc3caa7b8e9d30029";

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

    public RemoteCall<Boolean> setTest(byte[] _h, byte[] _s) {
        final Function function = new Function(FUNC_SETTEST,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_h),
                        new org.web3j.abi.datatypes.generated.Bytes32(_s)),
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
