import org.junit.Ignore;
import org.junit.Test;
import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Tony
 * Date: 02/02/13
 * Time: 20.05
 * To change this template use File | Settings | File Templates.
 */
public class MoneyTest {
    @Test
    public void positiveBalanceIsAllowed() {
        new Money(1);
    }

    @Test(expected=com.google.java.contract.PreconditionError.class)
    public void negativeBalanceAreNotAllowed() {
        new Money(-1);
    }

    @Test(expected=com.google.java.contract.PreconditionError.class)
    public void cantSpendMoneyThatWeDontHave() {
        Money money = new Money(1);
        money.spendMoney(2008);
    }

    @Test
    public void sameAmountOfMoneyAreEquals() {
        assertEquals(new Money(1), new Money(1));
    }

    @Test
    public void soundComparisonBetweenDifferentClassesOfMoney() {
        assertEquals(new Money(1), new MoneyAllowingDebts(1));
    }

    @Test
    public void compareNegativeMoneys() {
        assertEquals(new MoneyAllowingDebts(1), new MoneyAllowingDebts(1));
    }

    @Test
    public void clientUsesMoneyFactory() {
        Money money = new MoneyFactory().money(1);
        assertEquals(money,new Money(1));
    }

    @Test
    public void canSeeTheMoneyAmount()  {
        Money money = new MoneyFactory().money(1);
        assertEquals(1, money.getAmount());
    }

    @Test
    public void ifIspendONeUnitOfMoneyFromTwoThenIlRemainWithOne()  {
        Money money = new MoneyFactory().money(2);
        Money residualMoney = money.spendMoney(1);
        assertEquals(1, residualMoney.getAmount());
    }

    @Test(expected=com.google.java.contract.PreconditionError.class)
    public void cantSpendMoreMoneyThanYouHave()  {
        Money money = new Money(1);
        money.spendMoney(2);
    }

    @Test
    public void moneyAllowingDebtsCanBeSpentShamelessly()  {
        Money money = new MoneyAllowingDebts(1);
        Money residual = money.spendMoney(2008);
        assertEquals(new MoneyAllowingDebts(-2007),residual);
    }

}


