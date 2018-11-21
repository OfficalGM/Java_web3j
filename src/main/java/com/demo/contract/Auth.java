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
    private static final String BINARY = "0x608060405234801561001057600080fd5b506108b7806100206000396000f3006080604052600436106100a35763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663141e08e081146100a85780632da0ceb2146100d5578063313529361461012e578063658b6ff9146101465780639201de5514610172578063b55b5cc0146101ff578063cfb5192814610214578063d137d0821461026d578063e66773bd146102c7578063f1835db7146102e2575b600080fd5b3480156100b457600080fd5b506100c360043560243561032f565b60408051918252519081900360200190f35b3480156100e157600080fd5b506040805160206004803580820135601f81018490048402850184019095528484526100c39436949293602493928401919081908401838280828437509497506103b59650505050505050565b34801561013a57600080fd5b506100c360043561047f565b34801561015257600080fd5b5061015e600435610491565b604080519115158252519081900360200190f35b34801561017e57600080fd5b5061018a6004356104bd565b6040805160208082528351818301528351919283929083019185019080838360005b838110156101c45781810151838201526020016101ac565b50505050905090810190601f1680156101f15780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561020b57600080fd5b506100c3610603565b34801561022057600080fd5b506040805160206004803580820135601f81018490048402850184019095528484526100c39436949293602493928401919081908401838280828437509497506106099650505050505050565b34801561027957600080fd5b5060408051602060046024803582810135848102808701860190975280865261015e9684359636966044959194909101929182918501908490808284375094975061062d9650505050505050565b3480156102d357600080fd5b5061015e6004356024356107b1565b3480156102ee57600080fd5b5061030660043560ff6024351660443560643561081e565b6040805173ffffffffffffffffffffffffffffffffffffffff9092168252519081900360200190f35b6040805160208082018590528183018490528251808303840181526060909201928390528151600093918291908401908083835b602083106103825780518252601f199092019160209182019101610363565b5181516020939093036101000a600019018019909116921691909117905260405192018290039091209695505050505050565b6000816040516020018082805190602001908083835b602083106103ea5780518252601f1990920191602091820191016103cb565b6001836020036101000a0380198251168184511680821785525050505050509050019150506040516020818303038152906040526040518082805190602001908083835b6020831061044d5780518252601f19909201916020918201910161042e565b5181516020939093036101000a6000190180199091169216919091179052604051920182900390912095945050505050565b60006020819052908152604090205481565b604080516020818101835283825260018054808201825560009081529182905292902090519055919050565b6040805160208082528183019092526060918291600091829182918591908082016104008038833901905050945060009350600092505b6020831015610569576008830260020a870291507fff0000000000000000000000000000000000000000000000000000000000000082161561055e5781858581518110151561053f57fe5b906020010190600160f860020a031916908160001a9053506001909301925b6001909201916104f4565b836040519080825280601f01601f191660200182016040528015610597578160200160208202803883390190505b509050600092505b838310156105f95784838151811015156105b557fe5b90602001015160f860020a900460f860020a0281848151811015156105d657fe5b906020010190600160f860020a031916908160001a90535060019092019161059f565b9695505050505050565b60015481565b80516000908290151561061f5760009150610627565b602083015191505b50919050565b60008060008060008086511115156106a657604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601060248201527f736c6963652e6c656e677468203d203000000000000000000000000000000000604482015290519081900360640190fd5b50508351859150600090600019015b60018111156107a75760028304925085600182038151811015156106d557fe5b9060200190602002015186828151811015156106ed57fe5b6020908102909101810151604080518084019490945283810191909152805180840382018152606090930190819052825190918291908401908083835b602083106107495780518252601f19909201916020918201910161072a565b6001836020036101000a0380198251168184511680821785525050505050509050019150506040518091039020935061079c866001850381518110151561078c57fe5b90602001906020020151856107b1565b9150600290046106b5565b5095945050505050565b6000805b6020811015610812578381602081106107ca57fe5b1a60f860020a02600160f860020a03191683826020811015156107e957fe5b1a60f860020a02600160f860020a03191614151561080a5760009150610817565b6001016107b5565b600191505b5092915050565b604080516000808252602080830180855288905260ff87168385015260608301869052608083018590529251909260019260a080820193601f198101928190039091019086865af1158015610877573d6000803e3d6000fd5b5050604051601f19015196955050505050505600a165627a7a723058208158872bc0130d095d70ef64367749a67bcb41bf2a4db827104a323e3190ac060029";

    public static final String FUNC_TREE = "tree";

    public static final String FUNC_TREENUMBER = "TreeNumber";

    public static final String FUNC_VERIFY = "verify";

    public static final String FUNC_SETTREE = "setTree";

    public static final String FUNC_SLICEROOTHASH = "SliceRootHash";

    public static final String FUNC_SETTEST = "setTest";

    public static final String FUNC_GETKECCAK256_2 = "getKeccak256_2";

    public static final String FUNC_GETKECCAK256 = "getKeccak256";

    public static final String FUNC_BYTES32TOSTRING = "bytes32ToString";

    public static final String FUNC_STRINGTOBYTES32 = "stringToBytes32";

    public static final Event R_EVENT = new Event("R",
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
    ;

    public static final Event A_EVENT = new Event("A",
            Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}));
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

    public List<REventResponse> getREvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(R_EVENT, transactionReceipt);
        ArrayList<REventResponse> responses = new ArrayList<REventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            REventResponse typedResponse = new REventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.t = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<REventResponse> rEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, REventResponse>() {
            @Override
            public REventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(R_EVENT, log);
                REventResponse typedResponse = new REventResponse();
                typedResponse.log = log;
                typedResponse.t = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<REventResponse> rEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(R_EVENT));
        return rEventObservable(filter);
    }

    public List<AEventResponse> getAEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(A_EVENT, transactionReceipt);
        ArrayList<AEventResponse> responses = new ArrayList<AEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AEventResponse typedResponse = new AEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.b = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.t = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.temp = (byte[]) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<AEventResponse> aEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, AEventResponse>() {
            @Override
            public AEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(A_EVENT, log);
                AEventResponse typedResponse = new AEventResponse();
                typedResponse.log = log;
                typedResponse.b = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.t = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.temp = (byte[]) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<AEventResponse> aEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(A_EVENT));
        return aEventObservable(filter);
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

    public RemoteCall<Boolean> SliceRootHash(BigInteger idx, List<byte[]> slice) {
        final Function function = new Function(FUNC_SLICEROOTHASH,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(idx),
                        new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                                org.web3j.abi.Utils.typeMap(slice, org.web3j.abi.datatypes.generated.Bytes32.class))),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<Boolean> setTest(byte[] _h, byte[] _s) {
        final Function function = new Function(FUNC_SETTEST,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_h),
                        new org.web3j.abi.datatypes.generated.Bytes32(_s)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<byte[]> getKeccak256_2(String _a) {
        final Function function = new Function(FUNC_GETKECCAK256_2,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_a)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<byte[]> getKeccak256(byte[] _a, byte[] _b) {
        final Function function = new Function(FUNC_GETKECCAK256,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_a),
                        new org.web3j.abi.datatypes.generated.Bytes32(_b)),
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

    public static class REventResponse {
        public Log log;

        public byte[] t;
    }

    public static class AEventResponse {
        public Log log;

        public Boolean b;

        public byte[] t;

        public byte[] temp;
    }
}
