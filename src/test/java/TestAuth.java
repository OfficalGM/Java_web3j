import com.demo.FBHT.FBHTree;
import com.demo.Web3;
import com.demo.contract.Auth;
import org.junit.Assert;
import org.junit.Test;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
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
     *
     */
    @Test
    public void testFBHT(){
        //before
        for(int i=1;i<fbht.nodes.length;i++){
            assertThat(fbht.nodes[i].hash).isNotEmpty();
        }


        //when input
        for (int i = 0; i < 2; i++) {
            fbht.put(i + "");
        }
        for(int i=1;i<fbht.nodes.length;i++){
            assertThat(fbht.nodes[i].hash).hasSize(32).isNotEmpty();
        }

    }

    /**
     * input
     *  byte[] roothash
     */
    @Test
    public void testWriteClearanceRecords(){
        for (int i = 0; i < 2; i++) {
            fbht.put(i + "");
        }
        fbht.nodePrintln();
        Web3 web3 = new Web3();
        //contract input
        String contractAddress = "0xf3fbadb5887a21a22215d7a86e8b41d0a6dc1efd";
        String contractName = "Auth";
        String privateKey="af58e057cb1ccbcf31bed1dff0a56910e36a6e5b5c2e3e4cdcc742bbac662875";

        //Load contract
        Contract auth = web3.LoadContract(privateKey, contractName, contractAddress);
        try {
            TransactionReceipt transactionReceipt=((Auth)auth).writeClearanceRecords(fbht.nodes[1].hash).sendAsync().get();
            BigInteger i=((Auth)auth).treeNumber().sendAsync().get().add(new BigInteger("-1"));
            byte[] hash=((Auth)auth).clearanceRecords(i).sendAsync().get();
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
    public void testVerifySignature(){
        Web3 web3=new Web3();
        // contract input
        String contractAddress = "0xf3fbadb5887a21a22215d7a86e8b41d0a6dc1efd";
        String contractName = "Auth";
        String privateKey="af58e057cb1ccbcf31bed1dff0a56910e36a6e5b5c2e3e4cdcc742bbac662875";
        String account="0x4e82321967cb2af509a7fff42f771e5cda08a49c";
        Contract auth = web3.LoadContract(privateKey, contractName, contractAddress);
        List list = web3.signData(privateKey, "0");
        try {
            String address=((Auth)auth).verifySignature((byte[])list.get(0),new BigInteger((byte[]) list.get(1)),(byte[])list.get(2),(byte[])list.get(3)).sendAsync().get();
                assertThat(address).isNotEmpty().isEqualTo(account);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
    
}
