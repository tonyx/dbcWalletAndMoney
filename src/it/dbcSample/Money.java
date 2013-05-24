package it.dbcSample;

import com.google.java.contract.Requires;

/**
 * Created with IntelliJ IDEA.
 * User: Tony
 * Date: 02/02/13
 * Time: 19.45
 * To change this template use File | Settings | File Templates.
 */



public class Money {
// ....
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



//    public Money(int amount) throws InsufficientFoundException {
//        if (amount<0)
//            throw new InsufficientFoundException("negative amount not allowed: "+amount);
//        this.amount = amount;
//    }


//    public Money(int amount) {
//        if (amount<0)
//            throw new PreconditionError();
//        this.amount = amount;
//    }



    @Requires({"amount>=0"})
    public Money(int amount) {
        this.amount = amount;
    }


    public int getAmount() {
        return amount;
    }

//    public Money spend(int amountToSpend) throws InsufficientFoundException {
//        if ((amountToSpend>this.amount))
//            throw new InsufficientFoundException("insufficient founds");
//
//        return new Money(this.getAmount()-amountToSpend);
//    }


    @Requires({"amountToSpend<=this.amount"})
    public Money spend(int amountToSpend) {
        return new Money(this.getAmount()-amountToSpend);
    }


    public Money add(int addedQuantity) {
        return new Money(this.amount+addedQuantity);
    }
}


