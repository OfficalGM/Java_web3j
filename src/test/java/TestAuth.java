import com.demo.FBHT.FBHT;
import com.demo.Web3;
import com.demo.contract.Auth;
import org.junit.Assert;
import org.junit.Test;
import org.web3j.tx.Contract;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

import static org.assertj.core.api.Assertions.*;


public class TestAuth {
    FBHT fbht = new FBHT(3);
    @Test
    public void testFBHT(){
        //before
        for(int i=1;i<fbht.nodes.length;i++){
            assertThat(fbht.nodes[i].hash).isNotEmpty();
        }

        //input{string}
        //
        //
        //when input
        for (int i = 0; i < 2; i++) {
            fbht.put(i + "");

        }
        for(int i=1;i<fbht.nodes.length;i++){
            assertThat(fbht.nodes[i].hash).hasSize(32).isNotEmpty();
        }

    }
    @Test
    //smart contract
    public void testSetTree(){
        Web3 web3 = new Web3();
        //input string
        String contractAddress = "0xf3fbadb5887a21a22215d7a86e8b41d0a6dc1efd";
        String contractName = "Auth";
        String privateKey="af58e057cb1ccbcf31bed1dff0a56910e36a6e5b5c2e3e4cdcc742bbac662875";

        //Load contract
        Contract auth = web3.LoadContract(privateKey, contractName, contractAddress);

        try {
            System.out.println(((Auth)auth).setTree(fbht.nodes[1].hash).sendAsync().get());
            byte[] hash=((Auth)auth).tree(BigInteger.ZERO).sendAsync().get();
            assertThat(Arrays.toString(hash)).isEqualTo(Arrays.toString(fbht.nodes[1].hash)).isNotEmpty();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
