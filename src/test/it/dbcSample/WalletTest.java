package test.it.dbcSample;

import io.StreamOutput;
import it.dbcSample.Money;
import it.dbcSample.Wallet;
import org.junit.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: Tony
 * Date: 11/02/13
 * Time: 16.23
 * To change this template use File | Settings | File Templates.
 */
public class WalletTest {
    @Test
    public void shouldSayWelcome() {
        // given
        StreamOutput streamOutput = mock(StreamOutput.class);

        // when
        Wallet wallet = new Wallet(streamOutput);
        wallet.run();

        // then
        verify(streamOutput).output("welcome to your wallet");
    }

    @Test
    public void shouldPutSomeInitialMoneyInTheWallet() {
        // given
        StreamOutput streamOutput = mock(StreamOutput.class);

        // when
        Wallet wallet = new Wallet(streamOutput);
        wallet.run();
        wallet.addMoney(10);

        // then
        verify(streamOutput).output("welcome to your wallet");
        verify(streamOutput).output("you just added 10 to your wallet");
    }

    @Test
    public void canSpendMoneyTherAreAvailable() {
        // given
        StreamOutput streamOutput = mock(StreamOutput.class);

        // when
        Wallet wallet = new Wallet(streamOutput, new Money(1));
        wallet.run();
        wallet.spendMoney(1);
        InOrder inOrder = inOrder(streamOutput);

        // then
        inOrder.verify(streamOutput).output("welcome to your wallet");
        inOrder.verify(streamOutput).output("you just spent 1");
    }

    @Test
    public void walletCantSpendMoneyThatDoesNotHave() {
        // given
        StreamOutput streamOutput = mock(StreamOutput.class);

        // when
        Wallet wallet = new Wallet(streamOutput, new Money(1));
        wallet.run();
        wallet.spendMoney(2);
        InOrder inOrder = inOrder(streamOutput);

        // then
        inOrder.verify(streamOutput).output("welcome to your wallet");
        inOrder.verify(streamOutput).output("insufficient credit");
    }
}
