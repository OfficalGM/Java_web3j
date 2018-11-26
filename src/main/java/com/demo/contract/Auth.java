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
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.0.1.
 */
public class Auth extends Contract {
    private static final String BINARY = "0x608060405260008054600160a060020a0319163317905561067c806100256000396000f30060806040526004361061008d5763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663024cd19b81146100925780633fbc64ad14610100578063665033151461012a5780636b30ad23146101515780637d24a89d146101695780638da5cb5b1461018157806396957869146101bf578063b3af7f1a146101e3575b600080fd5b34801561009e57600080fd5b506040805160206004602480358281013584810280870186019097528086526100ec968435963696604495919490910192918291850190849080828437509497506101f89650505050505050565b604080519115158252519081900360200190f35b34801561010c57600080fd5b506100ec60043560243560443560ff6064351660843560a43561037c565b34801561013657600080fd5b5061013f610461565b60408051918252519081900360200190f35b34801561015d57600080fd5b5061013f600435610467565b34801561017557600080fd5b5061013f600435610479565b34801561018d57600080fd5b506101966104d1565b6040805173ffffffffffffffffffffffffffffffffffffffff9092168252519081900360200190f35b3480156101cb57600080fd5b5061019660043560ff602435166044356064356104ed565b3480156101ef57600080fd5b506100ec61055a565b600080600080600080865111151561027157604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601060248201527f736c6963652e6c656e677468203d203000000000000000000000000000000000604482015290519081900360640190fd5b50508351859150600090600019015b60018111156103725760028304925085600182038151811015156102a057fe5b9060200190602002015186828151811015156102b857fe5b6020908102909101810151604080518084019490945283810191909152805180840382018152606090930190819052825190918291908401908083835b602083106103145780518252601f1990920191602091820191016102f5565b6001836020036101000a03801982511681845116808217855250505050505090500191505060405180910390209350610367866001850381518110151561035757fe5b906020019060200201518561057b565b915060029004610280565b5095945050505050565b60003381808061038e898989896104ed565b925073ffffffffffffffffffffffffffffffffffffffff848116908416146103d5576000805474ff0000000000000000000000000000000000000000191681559450610453565b60008a81526001602052604090205491508a8214610412576000805474ff0000000000000000000000000000000000000000191681559450610453565b50604080518b81524360208201819052825190927f09ee0b8553997f3e86f76e26fa33568413de6ece6c380840c816f84e7adaa95d928290030190a1600194505b505050509695505050505050565b60025481565b60016020526000908152604090205481565b6000805473ffffffffffffffffffffffffffffffffffffffff16331461049e57600080fd5b50604080516020818101835283825260028054600181810183556000918252909252929020905190555460001901919050565b60005473ffffffffffffffffffffffffffffffffffffffff1681565b604080516000808252602080830180855288905260ff87168385015260608301869052608083018590529251909260019260a080820193601f198101928190039091019086865af1158015610546573d6000803e3d6000fd5b5050604051601f1901519695505050505050565b60005474010000000000000000000000000000000000000000900460ff1681565b6000805b60208110156106445783816020811061059457fe5b1a7f0100000000000000000000000000000000000000000000000000000000000000027effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff191683826020811015156105e757fe5b1a7f0100000000000000000000000000000000000000000000000000000000000000027effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff191614151561063c5760009150610649565b60010161057f565b600191505b50929150505600a165627a7a723058209a6627d283dbfc15a0a4dc13a2d2050bded066e5bead5bad81999a8a963704e70029";

    public static final String FUNC_TREENUMBER = "treeNumber";

    public static final String FUNC_CLEARANCERECORDS = "clearanceRecords";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_LOSTTXTRUE = "lostTxTrue";

    public static final String FUNC_VERIFYSIGNATURE = "verifySignature";

    public static final String FUNC_WRITECLEARANCERECORDS = "writeClearanceRecords";

    public static final String FUNC_SLICEROOTHASH = "sliceRootHash";

    public static final String FUNC_LOSTTRANSACTION = "lostTransaction";

    public static final Event LOSTTX_EVENT = new Event("lostTx",
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Uint256>() {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
        _addresses.put("3", "0x0fccf1b990d0b9b8e907dd791559b2a47c362705");
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

    public RemoteCall<Boolean> lostTxTrue() {
        final Function function = new Function(FUNC_LOSTTXTRUE,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public List<LostTxEventResponse> getLostTxEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(LOSTTX_EVENT, transactionReceipt);
        ArrayList<LostTxEventResponse> responses = new ArrayList<LostTxEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            LostTxEventResponse typedResponse = new LostTxEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.rootHash = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.currentBlock = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
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
                typedResponse.rootHash = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.currentBlock = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<LostTxEventResponse> lostTxEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(LOSTTX_EVENT));
        return lostTxEventFlowable(filter);
    }

    public RemoteCall<String> verifySignature(byte[] hash, BigInteger v, byte[] r, byte[] s) {
        final Function function = new Function(FUNC_VERIFYSIGNATURE,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(hash),
                        new org.web3j.abi.datatypes.generated.Uint8(v),
                        new org.web3j.abi.datatypes.generated.Bytes32(r),
                        new org.web3j.abi.datatypes.generated.Bytes32(s)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
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

    public RemoteCall<TransactionReceipt> lostTransaction(byte[] _rootHash, BigInteger _treeNumber, byte[] _tx, BigInteger v, byte[] r, byte[] s) {
        final Function function = new Function(
                FUNC_LOSTTRANSACTION,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_rootHash),
                        new org.web3j.abi.datatypes.generated.Uint256(_treeNumber),
                        new org.web3j.abi.datatypes.generated.Bytes32(_tx),
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

        public byte[] rootHash;

        public BigInteger currentBlock;
    }
}
