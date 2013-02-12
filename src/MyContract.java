import com.google.java.contract.Requires;
import com.google.java.contract.*;
/**
 * Created with IntelliJ IDEA.
 * User: Tony
 * Date: 01/02/13
 * Time: 18.50
 * To change this template use File | Settings | File Templates.
 */
public class MyContract {
    @Requires({"c >0 "})
    public void testContract(int c) {

    }
}

