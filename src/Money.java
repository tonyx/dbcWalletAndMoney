import com.google.java.contract.Requires;

/**
 * Created with IntelliJ IDEA.
 * User: Tony
 * Date: 02/02/13
 * Time: 19.45
 * To change this template use File | Settings | File Templates.
 */
public class Money {
    protected int amount;

    protected Money() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money)) return false;

        Money money = (Money) o;

        if (amount != money.amount) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return amount;
    }

    @Requires({"amount>=0"})
    public Money(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    @Requires({"amountSpent<=this.amount"})
    public Money spendMoney(int amountSpent) {
        Money remainingMoney = new Money(this.getAmount()-amountSpent);
        return remainingMoney;
    }

    public Money addAmount(int addedQuantity) {
        return new Money(this.amount+addedQuantity);
    }
}


