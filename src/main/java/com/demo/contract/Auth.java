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
    private static final String BINARY = "0x608060405260008054600160a060020a03191633179055610642806100256000396000f3006080604052600436106100825763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663024cd19b811461008757806366503315146100f55780636b30ad231461011c5780637d24a89d146101345780638da5cb5b1461014c578063969578691461018a578063c29d6a7a146101ae575b600080fd5b34801561009357600080fd5b506040805160206004602480358281013584810280870186019097528086526100e1968435963696604495919490910192918291850190849080828437509497506101d49650505050505050565b604080519115158252519081900360200190f35b34801561010157600080fd5b5061010a610358565b60408051918252519081900360200190f35b34801561012857600080fd5b5061010a60043561035e565b34801561014057600080fd5b5061010a600435610370565b34801561015857600080fd5b506101616103c8565b6040805173ffffffffffffffffffffffffffffffffffffffff9092168252519081900360200190f35b34801561019657600080fd5b5061016160043560ff602435166044356064356103e4565b3480156101ba57600080fd5b506101d260043560ff60243516604435606435610451565b005b600080600080600080865111151561024d57604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601060248201527f736c6963652e6c656e677468203d203000000000000000000000000000000000604482015290519081900360640190fd5b50508351859150600090600019015b600181111561034e57600283049250856001820381518110151561027c57fe5b90602001906020020151868281518110151561029457fe5b6020908102909101810151604080518084019490945283810191909152805180840382018152606090930190819052825190918291908401908083835b602083106102f05780518252601f1990920191602091820191016102d1565b6001836020036101000a03801982511681845116808217855250505050505090500191505060405180910390209350610343866001850381518110151561033357fe5b9060200190602002015185610541565b91506002900461025c565b5095945050505050565b60025481565b60016020526000908152604090205481565b6000805473ffffffffffffffffffffffffffffffffffffffff16331461039557600080fd5b50604080516020818101835283825260028054600181810183556000918252909252929020905190555460001901919050565b60005473ffffffffffffffffffffffffffffffffffffffff1681565b604080516000808252602080830180855288905260ff87168385015260608301869052608083018590529251909260019260a080820193601f198101928190039091019086865af115801561043d573d6000803e3d6000fd5b5050604051601f1901519695505050505050565b336000610460868686866103e4565b905073ffffffffffffffffffffffffffffffffffffffff828116908216146104e957604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601260248201527f7369676e61747572652069732077726f6e670000000000000000000000000000604482015290519081900360640190fd5b6040805187815273ffffffffffffffffffffffffffffffffffffffff8316602082015281517f2404264c3202763e8c2d4679f09d587364ef7c02f6d94b650c89a6c44e075eea929181900390910190a1505050505050565b6000805b602081101561060a5783816020811061055a57fe5b1a7f0100000000000000000000000000000000000000000000000000000000000000027effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff191683826020811015156105ad57fe5b1a7f0100000000000000000000000000000000000000000000000000000000000000027effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916141515610602576000915061060f565b600101610545565b600191505b50929150505600a165627a7a72305820b68881949019befad2c88904c95f4855611a601e8b471d058f5d247ed68de5340029";

    public static final String FUNC_TREENUMBER = "treeNumber";

    public static final String FUNC_CLEARANCERECORDS = "clearanceRecords";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_VERIFYSIGNATURE = "verifySignature";

    public static final String FUNC_WRITECLEARANCERECORDS = "writeClearanceRecords";

    public static final String FUNC_SLICEROOTHASH = "sliceRootHash";

    public static final String FUNC_LOSTTRANSACTION = "lostTransaction";

    public static final Event LOSTTX_EVENT = new Event("lostTx",
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Address>() {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
        _addresses.put("5777", "0xf3fbadb5887a21a22215d7a86e8b41d0a6dc1efd");
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
