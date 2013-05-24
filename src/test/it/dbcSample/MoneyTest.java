package test.it.dbcSample;

import com.google.java.contract.PreconditionError;
import it.dbcSample.InsufficientFoundException;
import it.dbcSample.Money;
import it.dbcSample.MoneyWithNegatives;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created with IntelliJ IDEA.
 * User: Tony
 * Date: 02/02/13
 * Time: 20.05
 * To change this template use File | Settings | File Templates.
 */
public class MoneyTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void positiveBalanceIsAllowed() {
        new Money(1);
    }

    @Test (expected=PreconditionError.class)
    public void aMoneyNoteCannotHaveNegativeValue() {
         new Money(-1);
    }


//        // given
//        Money money;
//
//        // then
//        // PreconditionError
//
//        // when
//        money = new Money(-1);
//    }

//    @Test(expected=PreconditionError.class)
//    public void cantSpendMoneyThatWeDontHave() {
//        Money money = new Money(1);
//        money.spend(2008);
//    }

    @Test(expected=PreconditionError.class)
    public void cantSpendMoneyThatWeDontHave() throws Exception {
        Money money = new Money(1);
        money.spend(2008);
    }

    @Test
    public void sameAmountOfMoneyAreEquals() {
        assertEquals(new Money(1), new Money(1));
    }

    @Test
    public void soundComparisonBetweenDifferentClassesOfMoney() {
        assertEquals(new Money(1), new MoneyWithNegatives(1));
    }

    @Test
    public void compareNegativeMoneys() {
        assertEquals(new MoneyWithNegatives(1), new MoneyWithNegatives(1));
    }

    @Test
    public void canSeeTheMoneyAmount()  {
        Money money = new Money(1);
        assertEquals(1, money.getAmount());
    }

//    @Test(expected=com.google.java.contract.PreconditionError.class)
//    public void cantSpendMoreMoneyThanYouHave()  {
//        Money money = new Money(1);
//        money.spend(2);
//    }

    @Test(expected= PreconditionError.class)
    public void cantSpendMoreMoneyThanYouHave() throws Exception {
        Money money = new Money(1);
        money.spend(2);
    }

//    @Test
//    public void moneyAllowingDebtsCanBeSpentShamelessly()  {
//        Money money = new MoneyWithNegatives(1);
//        Money residual = money.spend(2008);
//        assertEquals(new MoneyWithNegatives(-2007),residual);
//    }

    @Test
    public void moneyAllowingDebtsCanBeSpentShamelessly()  {
        MoneyWithNegatives money = new MoneyWithNegatives(1);
        Money residual = money.spend(2008);
        assertEquals(new MoneyWithNegatives(-2007),residual);
    }

}


