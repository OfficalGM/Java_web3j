import com.demo.FBHT.FBHT;
import com.demo.Web3;
import com.demo.contract.Auth;
import org.junit.Assert;
import org.junit.Test;
import org.web3j.tx.Contract;
import java.math.BigInteger;
import java.util.Arrays;
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
        //when input
        for (int i = 0; i < 2; i++) {
            fbht.put(i + "");
        }
        for(int i=1;i<fbht.nodes.length;i++){
            assertThat(fbht.nodes[i].hash).hasSize(32).isNotEmpty();
        }

    }
    //smart contract
    @Test
    public void testSetTree(){
        for (int i = 0; i < 2; i++) {
            fbht.put(i + "");
        }
        fbht.node_println();
        Web3 web3 = new Web3();
        //input string
        String contractAddress = "0x9683eeb68fe0d3df151559670c83a40fbfd8472b";
        String contractName = "Auth";
        String privateKey="43cbbbf7643cd3f8bdf54d70014cd5fcc313b243aadec7081d16c1ad04ee4b8f";

        //Load contract
        Contract auth = web3.LoadContract(privateKey, contractName, contractAddress);
        try {
//            ((Auth)auth).writeClearanceRecords()
//            byte[] hash=((Auth)auth).tree(BigInteger.ZERO).sendAsync().get();
//            assertThat(Arrays.toString(hash)).isEqualTo(Arrays.toString(fbht.nodes[1].hash)).isNotEmpty();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
