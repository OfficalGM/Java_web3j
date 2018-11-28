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
import org.web3j.tuples.generated.Tuple3;
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
public class LedgerBooster extends Contract {
    private static final String BINARY = "0x608060405260008054600160a060020a0319163317905561083a806100256000396000f30060806040526004361061008d5763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166329c3c48581146100925780632a53ff07146100e3578063401e64761461010657806366503315146101215780636b30ad2314610148578063861043591461017e5780638da5cb5b146101ab578063c198f8ba146101dc575b600080fd5b34801561009e57600080fd5b506100b3600160a060020a0360043516610205565b60408051600160a060020a0390951685529215156020850152838301919091526060830152519081900360800190f35b3480156100ef57600080fd5b50610104600160a060020a036004351661024d565b005b34801561011257600080fd5b50610104600435602435610267565b34801561012d57600080fd5b506101366102c5565b60408051918252519081900360200190f35b34801561015457600080fd5b506101606004356102cb565b60408051938452602084019290925282820152519081900360600190f35b34801561018a57600080fd5b5061010460043560243560443560643560ff6084351660a43560c4356102eb565b3480156101b757600080fd5b506101c0610687565b60408051600160a060020a039092168252519081900360200190f35b3480156101e857600080fd5b506101f1610696565b604080519115158252519081900360200190f35b6001602081905260009182526040909120805491810154600490910154600160a060020a0383169274010000000000000000000000000000000000000000900460ff16919084565b600054600160a060020a0316331461026457600080fd5b50565b600054600160a060020a0316331461027e57600080fd5b604080516060810182529283526003805460208086018281528685019586526001808401909455600092835260029182905293909120945185559151908401559051910155565b60035481565b600260208190526000918252604090912080546001820154919092015483565b604080517f969578690000000000000000000000000000000000000000000000000000000081526004810186905260ff85166024820152604481018490526064810183905290513391600091829173__Util__________________________________91639695786991608480820192602092909190829003018186803b15801561037557600080fd5b505af4158015610389573d6000803e3d6000fd5b505050506040513d602081101561039f57600080fd5b50519150600160a060020a038381169083161415610407576040805160e560020a62461bcd02815260206004820152601260248201527f7369676e6174757265206973206572726f720000000000000000000000000000604482015290519081900360640190fd5b6040805160208082018b905282518083038201815291830192839052815191929182918401908083835b602083106104505780518252601f199092019160209182019101610431565b5181516020939093036101000a600019018019909116921691909117905260405192018290039091208a141592506104d5915050576040805160e560020a62461bcd02815260206004820152600b60248201527f74782069732077726f6e67000000000000000000000000000000000000000000604482015290519081900360640190fd5b6000898152600260205260409020548a141561053b576040805160e560020a62461bcd02815260206004820152601160248201527f726f6f7468617368206973206572726f72000000000000000000000000000000604482015290519081900360640190fd5b43905060a06040519081016040528084600160a060020a0316815260200160011515815260200182815260200160408051908101604052808d600019166000191681526020018a600019166000191681525081526020018a8152506001600085600160a060020a0316600160a060020a0316815260200190815260200160002060008201518160000160006101000a815481600160a060020a030219169083600160a060020a0316021790555060208201518160000160146101000a81548160ff021916908315150217905550604082015181600101556060820151816002019060026106299291906107b4565b506080919091015160049091015560408051600160a060020a03851681526020810183905281517fc2bf77981b420d23feebe8e29f228fbd8effe648d7f53bc286eff90706859ed7929181900390910190a150505050505050505050565b600054600160a060020a031681565b33600090815260016020819052604082205474010000000000000000000000000000000000000000900460ff16151514610740576040805160e560020a62461bcd02815260206004820152602d60248201527f6368616c6c656e67656453746174652069732077726f6e67206f72206164646460448201527f726573732069732077726f6e6700000000000000000000000000000000000000606482015290519081900360840190fd5b336000908152600160208190526040909120015460324301116107ad576040805160e560020a62461bcd02815260206004820152601760248201527f6368616c6c656e6765206973206e6f742066696e697368000000000000000000604482015290519081900360640190fd5b5060015b90565b82600281019282156107e4579160200282015b828111156107e457825182556020909201916001909101906107c7565b506107f09291506107f4565b5090565b6107b191905b808211156107f057600081556001016107fa5600a165627a7a72305820c659d3983fbc2ef65f7c6b0cd60f9992a311995df69b1276a24473896555bea20029";

    public static final String FUNC_CHALLENGELOG = "challengeLog";

    public static final String FUNC_TREENUMBER = "treeNumber";

    public static final String FUNC_CLEARANCERECORDS = "clearanceRecords";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_WRITECLEARANCERECORDS = "writeClearanceRecords";

    public static final String FUNC_LOSTTRANSACTION = "lostTransaction";

    public static final String FUNC_SPPROOF = "spProof";

    public static final String FUNC_PROPOSE = "propose";

    public static final Event LOSTTX_EVENT = new Event("lostTx",
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
        _addresses.put("5777", "0x9683eeb68fe0d3df151559670c83a40fbfd8472b");
    }

    @Deprecated
    protected LedgerBooster(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected LedgerBooster(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected LedgerBooster(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected LedgerBooster(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<Tuple4<String, Boolean, BigInteger, BigInteger>> challengeLog(String param0) {
        final Function function = new Function(FUNC_CHALLENGELOG,
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

    public RemoteCall<BigInteger> treeNumber() {
        final Function function = new Function(FUNC_TREENUMBER,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<Tuple3<byte[], BigInteger, BigInteger>> clearanceRecords(BigInteger param0) {
        final Function function = new Function(FUNC_CLEARANCERECORDS,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple3<byte[], BigInteger, BigInteger>>(
                new Callable<Tuple3<byte[], BigInteger, BigInteger>>() {
                    @Override
                    public Tuple3<byte[], BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<byte[], BigInteger, BigInteger>(
                                (byte[]) results.get(0).getValue(),
                                (BigInteger) results.get(1).getValue(),
                                (BigInteger) results.get(2).getValue());
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

    public RemoteCall<TransactionReceipt> writeClearanceRecords(byte[] _rootHash, BigInteger classification) {
        final Function function = new Function(
                FUNC_WRITECLEARANCERECORDS,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_rootHash),
                        new org.web3j.abi.datatypes.generated.Uint256(classification)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> lostTransaction(byte[] _rootHash, BigInteger _treeNumber, byte[] pbPairs, byte[] _tx, BigInteger v, byte[] r, byte[] s) {
        final Function function = new Function(
                FUNC_LOSTTRANSACTION,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_rootHash),
                        new org.web3j.abi.datatypes.generated.Uint256(_treeNumber),
                        new org.web3j.abi.datatypes.generated.Bytes32(pbPairs),
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
    public static LedgerBooster load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new LedgerBooster(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static LedgerBooster load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new LedgerBooster(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static LedgerBooster load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new LedgerBooster(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static LedgerBooster load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new LedgerBooster(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<LedgerBooster> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(LedgerBooster.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<LedgerBooster> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(LedgerBooster.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<LedgerBooster> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(LedgerBooster.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<LedgerBooster> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(LedgerBooster.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
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
