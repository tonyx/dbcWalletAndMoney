package it.dbcSample;

import com.google.java.contract.Requires;

/**
 * Created with IntelliJ IDEA.
 * User: Tony
 * Date: 02/02/13
 * Time: 22.04
 * To change this template use File | Settings | File Templates.
 */


public class MoneyWithNegatives extends Money {
    public MoneyWithNegatives(int amount) {
        this.amount=amount;
    }

    @Override
    @Requires({"true"})
    public Money spend(int amountToSpend) {
        return  new MoneyWithNegatives(this.getAmount()- amountToSpend);
    }
}
