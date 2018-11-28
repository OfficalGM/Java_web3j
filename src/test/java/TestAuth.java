import com.demo.FBHT.FBHTree;
import com.demo.Web3;
import com.demo.contract.LedgerBooster;
import org.junit.Test;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tx.Contract;

import java.math.BigInteger;
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
        String contractAddress = "0x9683eeb68fe0d3df151559670c83a40fbfd8472b";
        String contractName = "LedgerBooster";
        String privateKey = "43cbbbf7643cd3f8bdf54d70014cd5fcc313b243aadec7081d16c1ad04ee4b8f";

        //Load contract
        Contract ledgerBooster = web3.LoadContract(privateKey, contractName, contractAddress);
        try {
            TransactionReceipt transactionReceipt = ((LedgerBooster) ledgerBooster).writeClearanceRecords(fbht.nodes[1].hash,BigInteger.ZERO).sendAsync().get();
            BigInteger i = ((LedgerBooster) ledgerBooster).treeNumber().sendAsync().get().add(new BigInteger("-1"));
            Tuple3 tuple3=((LedgerBooster)ledgerBooster).clearanceRecords(i).sendAsync().get();
            byte hash[]= (byte[]) tuple3.getValue1();
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

//    @Test
//    public void testlostTransaction() {
//        Web3 web3 = new Web3("https://ropsten.infura.io/v3/");
//        String contractAddress = "0x295da118945d50e5fb64b1824d85faacce59d3a7";
//        String contractName = "LedgerBooster";
//        String privateKey = "";
//        Contract ledgerBooster = web3.LoadContract(privateKey, contractName, contractAddress);
//        List list = web3.signData(privateKey, "0");
//        try {
////            ((LedgerBooster)ledgerBooster).writeClearanceRecords((byte[]) list.get(0)).sendAsync().get();
////            TransactionReceipt transactionReceipt = ((LedgerBooster) ledgerBooster).lostTransaction((byte[]) list.get(0), BigInteger.ZERO, (byte[]) list.get(0), new BigInteger((byte[]) list.get(1)), (byte[]) list.get(2), (byte[]) list.get(3)).sendAsync().get();
////            assertThat(transactionReceipt).isNotNull();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//
//
//    }

}
