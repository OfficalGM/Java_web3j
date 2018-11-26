import com.demo.FBHT.FBHTree;
import com.demo.Web3;
import com.demo.contract.Auth;
import org.junit.Assert;
import org.junit.Test;
import org.reactivestreams.Subscription;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.EventValues;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.websocket.WebSocketClient;
import org.web3j.protocol.websocket.WebSocketService;
import org.web3j.tx.Contract;
import org.web3j.tx.gas.DefaultGasProvider;

import java.math.BigInteger;
import java.net.ConnectException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.assertj.core.api.Assertions.*;


public class TestAuth {
    FBHTree fbht = new FBHTree(3);

    /**
     * input
     * string tx
     */
    @Test
    public void testFBHT() {
        //before
        for (int i = 1; i < fbht.nodes.length; i++) {
            assertThat(fbht.nodes[i].hash).isNotEmpty();
        }
        //when input
        for (int i = 0; i < 2; i++) {
            fbht.put(i + "");
        }
        for (int i = 1; i < fbht.nodes.length; i++) {
            assertThat(fbht.nodes[i].hash).hasSize(32).isNotEmpty();
        }
    }

    /**
     * input
     * byte[] roothash
     */
    @Test
    public void testWriteClearanceRecords() {
        for (int i = 0; i < 2; i++) {
            fbht.put(i + "");
        }
        fbht.nodePrintln();
        Web3 web3 = new Web3();
        //contract input
        String contractAddress = "0xf3fbadb5887a21a22215d7a86e8b41d0a6dc1efd";
        String contractName = "Auth";
        String privateKey = "af58e057cb1ccbcf31bed1dff0a56910e36a6e5b5c2e3e4cdcc742bbac662875";

        //Load contract
        Contract auth = web3.LoadContract(privateKey, contractName, contractAddress);
        try {
            TransactionReceipt transactionReceipt = ((Auth) auth).writeClearanceRecords(fbht.nodes[1].hash).sendAsync().get();
            BigInteger i = ((Auth) auth).treeNumber().sendAsync().get().add(new BigInteger("-1"));
            byte[] hash = ((Auth) auth).clearanceRecords(i).sendAsync().get();
            assertThat(Arrays.toString(hash)).isEqualTo(Arrays.toString(fbht.nodes[1].hash)).isNotEmpty();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * input
     * byte[] hash
     * BigInteger v
     * byte[] r
     * byte[] s
     */
    @Test
    public void testVerifySignature() {
        Web3 web3 = new Web3();
        // contract input
        String contractAddress = "0x9683eeb68fe0d3df151559670c83a40fbfd8472b";
        String contractName = "Auth";
        String privateKey = "43cbbbf7643cd3f8bdf54d70014cd5fcc313b243aadec7081d16c1ad04ee4b8f";
        String account = "0xa2be5cc6a7683ea3e3b0405e3169111db7dac31a";
        Contract auth = web3.LoadContract(privateKey, contractName, contractAddress);
        List list = web3.signData(privateKey, "0");
        try {
            String address = ((Auth) auth).verifySignature((byte[]) list.get(0), new BigInteger((byte[]) list.get(1)), (byte[]) list.get(2), (byte[]) list.get(3)).sendAsync().get();
            assertThat(address).isNotEmpty().isEqualTo(account);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testlostTransaction() {
        Web3 web3 = new Web3("https://ropsten.infura.io/v3/");
        String contractAddress = "0x295da118945d50e5fb64b1824d85faacce59d3a7";
        String contractName = "Auth";
        String privateKey = "";
        Contract auth = web3.LoadContract(privateKey, contractName, contractAddress);
        List list = web3.signData(privateKey, "0");
        try {
            ((Auth)auth).writeClearanceRecords((byte[]) list.get(0)).sendAsync().get();
            TransactionReceipt transactionReceipt = ((Auth) auth).lostTransaction((byte[]) list.get(0), BigInteger.ZERO, (byte[]) list.get(0), new BigInteger((byte[]) list.get(1)), (byte[]) list.get(2), (byte[]) list.get(3)).sendAsync().get();
            assertThat(transactionReceipt).isNotNull();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

}
