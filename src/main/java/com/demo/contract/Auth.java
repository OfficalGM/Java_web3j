package com.demo.contract;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
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
    private static final String BINARY = "0x608060405260008054600160a060020a03191633179055610521806100256000396000f3006080604052600436106100775763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663024cd19b811461007c57806331352936146100ea578063658b6ff9146101145780638da5cb5b1461012c578063b55b5cc01461016a578063f1835db71461017f575b600080fd5b34801561008857600080fd5b506040805160206004602480358281013584810280870186019097528086526100d6968435963696604495919490910192918291850190849080828437509497506101a39650505050505050565b604080519115158252519081900360200190f35b3480156100f657600080fd5b50610102600435610327565b60408051918252519081900360200190f35b34801561012057600080fd5b50610102600435610339565b34801561013857600080fd5b50610141610391565b6040805173ffffffffffffffffffffffffffffffffffffffff9092168252519081900360200190f35b34801561017657600080fd5b506101026103ad565b34801561018b57600080fd5b5061014160043560ff602435166044356064356103b3565b600080600080600080865111151561021c57604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601060248201527f736c6963652e6c656e677468203d203000000000000000000000000000000000604482015290519081900360640190fd5b50508351859150600090600019015b600181111561031d57600283049250856001820381518110151561024b57fe5b90602001906020020151868281518110151561026357fe5b6020908102909101810151604080518084019490945283810191909152805180840382018152606090930190819052825190918291908401908083835b602083106102bf5780518252601f1990920191602091820191016102a0565b6001836020036101000a03801982511681845116808217855250505050505090500191505060405180910390209350610312866001850381518110151561030257fe5b9060200190602002015185610420565b91506002900461022b565b5095945050505050565b60016020526000908152604090205481565b6000805473ffffffffffffffffffffffffffffffffffffffff16331461035e57600080fd5b50604080516020818101835283825260028054600181810183556000918252909252929020905190555460001901919050565b60005473ffffffffffffffffffffffffffffffffffffffff1681565b60025481565b604080516000808252602080830180855288905260ff87168385015260608301869052608083018590529251909260019260a080820193601f198101928190039091019086865af115801561040c573d6000803e3d6000fd5b5050604051601f1901519695505050505050565b6000805b60208110156104e95783816020811061043957fe5b1a7f0100000000000000000000000000000000000000000000000000000000000000027effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916838260208110151561048c57fe5b1a7f0100000000000000000000000000000000000000000000000000000000000000027effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff19161415156104e157600091506104ee565b600101610424565b600191505b50929150505600a165627a7a72305820dd6da075291da9333605711984bfc29693a0ef6e164d8b3b1e4a80dd1d4cc3700029";

    public static final String FUNC_TREE = "tree";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_TREENUMBER = "TreeNumber";

    public static final String FUNC_VERIFY = "verify";

    public static final String FUNC_SETTREE = "setTree";

    public static final String FUNC_SLICEROOTHASH = "sliceRootHash";

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

    public RemoteCall<byte[]> tree(BigInteger param0) {
        final Function function = new Function(FUNC_TREE,
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

    public RemoteCall<BigInteger> TreeNumber() {
        final Function function = new Function(FUNC_TREENUMBER,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
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

    public RemoteCall<Boolean> sliceRootHash(BigInteger idx, List<byte[]> slice) {
        final Function function = new Function(FUNC_SLICEROOTHASH,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(idx),
                        new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                                org.web3j.abi.Utils.typeMap(slice, org.web3j.abi.datatypes.generated.Bytes32.class))),
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
}
