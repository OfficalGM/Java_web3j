import com.demo.FBHT.FBHT;
import com.demo.Web3;
import com.demo.contract.Auth;
import org.junit.Assert;
import org.junit.Test;
import org.web3j.tx.Contract;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;


public class TestAuth {
    FBHT fbht = new FBHT(3);
    @Test
    public void testFBHT(){
        for (int i = 0; i < 2; i++) {
            fbht.put(i + "");
        }
        fbht.node_println();
    }
    @Test
    //smart contract
    public void testSetTree(){
        String contractAddress = "0xf3fbadb5887a21a22215d7a86e8b41d0a6dc1efd";
        String contractName = "Auth";
        String privateKey="af58e057cb1ccbcf31bed1dff0a56910e36a6e5b5c2e3e4cdcc742bbac662875";
        Web3 web3 = new Web3();
        Contract auth = web3.LoadContract(privateKey, contractName, contractAddress);

        try {
            System.out.println(((Auth)auth).setTree(fbht.nodes[1].hash).sendAsync().get());
            byte[] hash=((Auth)auth).tree(BigInteger.ONE).sendAsync().get();

            Assert.assertEquals(Arrays.toString(hash),Arrays.toString(fbht.nodes[1].hash));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
