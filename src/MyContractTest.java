import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created with IntelliJ IDEA.
 * User: Tony
 * Date: 02/02/13
 * Time: 16.47
 * To change this template use File | Settings | File Templates.
 */
@RunWith(JUnit4.class)
public class MyContractTest  {
    @Test
    public void TestContract() {
        new MyContract().testContract(-1);
        //Assert.assertTrue(false);
    }
}
