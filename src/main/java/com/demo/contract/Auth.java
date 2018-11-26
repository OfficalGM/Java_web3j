package com.demo.contract;

import io.reactivex.Flowable;
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
import org.web3j.tuples.generated.Tuple4;
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
    private static final String BINARY = "0x608060405260008054600160a060020a03191633179055610986806100256000396000f3006080604052600436106100a35763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663024cd19b81146100a85780632a53ff07146101165780633fbc64ad1461013957806366503315146101635780636b30ad231461018a57806372fb9703146101a25780637d24a89d146101f35780638da5cb5b1461020b578063969578691461023c578063c198f8ba14610260575b600080fd5b3480156100b457600080fd5b50604080516020600460248035828101358481028087018601909752808652610102968435963696604495919490910192918291850190849080828437509497506102759650505050505050565b604080519115158252519081900360200190f35b34801561012257600080fd5b50610137600160a060020a03600435166103f9565b005b34801561014557600080fd5b5061010260043560243560443560ff6064351660843560a435610413565b34801561016f57600080fd5b506101786105b7565b60408051918252519081900360200190f35b34801561019657600080fd5b506101786004356105bd565b3480156101ae57600080fd5b506101c3600160a060020a03600435166105cf565b60408051600160a060020a0390951685529215156020850152838301919091526060830152519081900360800190f35b3480156101ff57600080fd5b50610178600435610617565b34801561021757600080fd5b50610220610663565b60408051600160a060020a039092168252519081900360200190f35b34801561024857600080fd5b5061022060043560ff60243516604435606435610672565b34801561026c57600080fd5b506101026106df565b60008060008060008086511115156102ee57604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601060248201527f736c6963652e6c656e677468203d203000000000000000000000000000000000604482015290519081900360640190fd5b50508351859150600090600019015b60018111156103ef57600283049250856001820381518110151561031d57fe5b90602001906020020151868281518110151561033557fe5b6020908102909101810151604080518084019490945283810191909152805180840382018152606090930190819052825190918291908401908083835b602083106103915780518252601f199092019160209182019101610372565b6001836020036101000a038019825116818451168082178552505050505050905001915050604051809103902093506103e486600185038151811015156103d457fe5b906020019060200201518561082b565b9150600290046102fd565b5095945050505050565b600054600160a060020a0316331461041057600080fd5b50565b60003381808061042589898989610672565b9250600160a060020a038481169084161461044357600094506105a9565b60008a81526002602052604090205491508a821461046457600094506105a9565b43905060a06040519081016040528085600160a060020a0316815260200160011515815260200182815260200160408051908101604052808e600019166000191681526020018c600019166000191681525081526020018b8152506001600086600160a060020a0316600160a060020a0316815260200190815260200160002060008201518160000160006101000a815481600160a060020a030219169083600160a060020a0316021790555060208201518160000160146101000a81548160ff02191690831515021790555060408201518160010155606082015181600201906002610552929190610900565b506080919091015160049091015560408051600160a060020a03861681526020810183905281517fc2bf77981b420d23feebe8e29f228fbd8effe648d7f53bc286eff90706859ed7929181900390910190a1600194505b505050509695505050505050565b60035481565b60026020526000908152604090205481565b6001602081905260009182526040909120805491810154600490910154600160a060020a0383169274010000000000000000000000000000000000000000900460ff16919084565b60008054600160a060020a0316331461062f57600080fd5b5060408051602081810183528382526003805460018101825560009081526002909252929020905190555460001901919050565b600054600160a060020a031681565b604080516000808252602080830180855288905260ff87168385015260608301869052608083018590529251909260019260a080820193601f198101928190039091019086865af11580156106cb573d6000803e3d6000fd5b5050604051601f1901519695505050505050565b33600090815260016020819052604082205474010000000000000000000000000000000000000000900460ff161515146107a057604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152602d60248201527f6368616c6c656e67656453746174652069732077726f6e67206f72206164646460448201527f726573732069732077726f6e6700000000000000000000000000000000000000606482015290519081900360840190fd5b3360009081526001602081905260409091200154603243011161082457604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601760248201527f6368616c6c656e6765206973206e6f742066696e697368000000000000000000604482015290519081900360640190fd5b5060015b90565b6000805b60208110156108f45783816020811061084457fe5b1a7f0100000000000000000000000000000000000000000000000000000000000000027effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916838260208110151561089757fe5b1a7f0100000000000000000000000000000000000000000000000000000000000000027effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff19161415156108ec57600091506108f9565b60010161082f565b600191505b5092915050565b8260028101928215610930579160200282015b828111156109305782518255602090920191600190910190610913565b5061093c929150610940565b5090565b61082891905b8082111561093c57600081556001016109465600a165627a7a72305820ca67d1068e297345ce6b23d1bb6003ab1af8fdf1e635eea2e040ec55aba6aac70029";

    public static final String FUNC_TREENUMBER = "treeNumber";

    public static final String FUNC_CLEARANCERECORDS = "clearanceRecords";

    public static final String FUNC_CHALLENGE = "challenge";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_VERIFYSIGNATURE = "verifySignature";

    public static final String FUNC_WRITECLEARANCERECORDS = "writeClearanceRecords";

    public static final String FUNC_SLICEROOTHASH = "sliceRootHash";

    public static final String FUNC_LOSTTRANSACTION = "lostTransaction";

    public static final String FUNC_SPPROOF = "spProof";

    public static final String FUNC_PROPOSE = "propose";

    public static final Event LOSTTX_EVENT = new Event("lostTx",
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
        _addresses.put("3", "0x295da118945d50e5fb64b1824d85faacce59d3a7");
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

    public RemoteCall<Tuple4<String, Boolean, BigInteger, BigInteger>> challenge(String param0) {
        final Function function = new Function(FUNC_CHALLENGE,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bool>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple4<String, Boolean, BigInteger, BigInteger>>(
                new Callable<Tuple4<String, Boolean, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple4<String, Boolean, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple4<String, Boolean, BigInteger, BigInteger>(
                                (String) results.get(0).getValue(),
                                (Boolean) results.get(1).getValue(),
                                (BigInteger) results.get(2).getValue(),
                                (BigInteger) results.get(3).getValue());
                    }
                });
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
            typedResponse.client = (String) eventValues.getNonIndexedValues().get(0).getValue();
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
                typedResponse.client = (String) eventValues.getNonIndexedValues().get(0).getValue();
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

    public void spProof(String addr) {
        throw new RuntimeException("cannot call constant function with void return type");
    }

    public RemoteCall<Boolean> propose() {
        final Function function = new Function(FUNC_PROPOSE,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
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

        public String client;

        public BigInteger currentBlock;
    }
}
