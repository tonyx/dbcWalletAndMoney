package test.it.dbcSample;

import io.OutputStream;
import io.InputStream;
import it.dbcSample.Money;
import it.dbcSample.MoneyWithNegatives;
import it.dbcSample.Wallet;
import org.junit.Before;
import org.junit.Ignore;
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

    OutputStream outputStream;
    @Before
    public void setUp() {
        outputStream = mock(OutputStream.class);
    }

    //OutputStream outputStream = mock(OutputStream.class);
    @Test
    public void shouldSayWelcome() {
        // given
        OutputStream outputStream = mock(OutputStream.class);

        // when
        Wallet wallet = new Wallet(outputStream);
        wallet.run();

        // then
        verify(outputStream).print("welcome from your wallet");
    }

    @Test
    @Ignore
    public void sayWelcomeAndThenHiToWallet() throws Exception {
        // given
        OutputStream outputStream = mock(OutputStream.class);
        InputStream inputStream = mock(InputStream.class);
        when(inputStream.input()).thenReturn("John");

        // when
        Wallet wallet = new Wallet(inputStream, outputStream,new Money(0));
        wallet.run();

        // then
        verify(outputStream).print("welcome from your wallet");
        verify(outputStream).print("hi John");

    }


    @Test
    public void shouldNotifyHowMuchMoneyIAdd() {
        // given
        OutputStream outputStream = mock(OutputStream.class);

        // when
        Wallet wallet = new Wallet(outputStream);
        wallet.run();
        wallet.addMoney(10);

        // then
        verify(outputStream).print("welcome from your wallet");
        verify(outputStream).print("you just added 10");
    }

    @Test
    public void shouldNotifyWhenISpend()  throws Exception {
        // given
        OutputStream outputStream = mock(OutputStream.class);

        // when
        Wallet wallet = new Wallet(outputStream, new Money(1));
        wallet.run();
        wallet.spend(1);
        InOrder inOrder = inOrder(outputStream);

        // then
        inOrder.verify(outputStream).print("welcome from your wallet");
        inOrder.verify(outputStream).print("you just spent 1");
    }

    @Test
    public void shouldNotAllowSpendingUnavailableFounds() throws Exception {
        // given
        Wallet wallet = new Wallet(outputStream, new MoneyWithNegatives(1));

        // when
        wallet.spend(2);

        // then
        verify(outputStream).print("insufficient found");
    }



    @Test
    public void walletCantSpendMoneyThatDoesNotHaveEvenIfUseCreditCard() throws Exception {
        // given
        InOrder inOrder = inOrder(outputStream);

        // when
        Wallet wallet = new Wallet(outputStream, new MoneyWithNegatives(1));

        wallet.run();
        // then
        inOrder.verify(outputStream).print("welcome from your wallet");

        // and when
        wallet.spend(2);

        // then
        inOrder.verify(outputStream).print("insufficient found");
    }
}
