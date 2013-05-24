package it.dbcSample;

import io.ConsoleInputStream;
import io.ConsoleOutputStream;
import io.InputStream;
import io.OutputStream;

/**
 * Created with IntelliJ IDEA.
 * User: Tony
 * Date: 11/02/13
 * Time: 15.11
 * To change this template use File | Settings | File Templates.
 */
public class Wallet {
    OutputStream outputStream;
    InputStream inputStream;
    Money money;

    public static void main(String string[]){
        Wallet wallet = new Wallet(new ConsoleInputStream(), new ConsoleOutputStream(),new Money(0));
        wallet.run();
    }

    public Wallet(InputStream inputStream, OutputStream outputStream, Money money) {
        this.inputStream = inputStream;
        this.outputStream = outputStream;
        this.money=money;
    }

    public Wallet(OutputStream outputStream) {
        this(new ConsoleInputStream(), outputStream, new Money(0));
    }

    public Wallet(OutputStream outputStream, Money money) {
        this.outputStream = outputStream;
        this.money=money;
        this.inputStream = new ConsoleInputStream();
    }

    public void run() {
        sayWelcome();
    }

    private void sayWelcome() {
        outputStream.print("welcome from your wallet");
    }

    public void addMoney(int addedmoney)  {
        money = money.add(addedmoney);
        outputStream.print("you just added " + addedmoney);
    }


    public void spend(int amount) {
        if (amount> money.getAmount()) {
            outputStream.print("insufficient found");
        } else {
            money = money.spend(amount);
            outputStream.print("you just spent " + amount);
        }
    }



//    public void spend(int amount)   {
//        try {
//            money.spend(amount);
//            outputStream.print("you just spent "+amount);
//        } catch (InsufficientFoundException e) {
//            outputStream.print("insufficient found");
//        }
//    }



//        if (spentAmount> money.getAmount()) {
//            outputStream.print("insufficient credit");
//        } else {
//            money = money.spend(spentAmount);
//            outputStream.print("you just spent "+spentAmount);
//        }
//    }

}


