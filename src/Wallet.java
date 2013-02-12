import io.ConsoleOutput;
import io.StreamOutput;

/**
 * Created with IntelliJ IDEA.
 * User: Tony
 * Date: 11/02/13
 * Time: 15.11
 * To change this template use File | Settings | File Templates.
 */
public class Wallet {
    StreamOutput streamOutput;
    Money money;

    public static void main(String string[]){
        Wallet wallet = new Wallet(new ConsoleOutput());
        wallet.run();
    }

    public Wallet(StreamOutput streamOutput) {
        this(streamOutput, new Money(0));
    }

    private Wallet(StreamOutput streamOutput, Money money) {
        this.streamOutput= streamOutput;
        this.money=money;
    }

    public void run() {
        sayWelcome();
    }

    private void sayWelcome() {
        streamOutput.output("welcome to your wallet");
    }

    public void addMoney(int addedmoney)  {
        this.money = money.addAmount(addedmoney);
        streamOutput.output("you just added "+addedmoney+" to your wallet");
    }

    public void spendMoney(int spentAmount) {
        if (spentAmount>this.money.getAmount()) {
            streamOutput.output("insufficient credit");
        } else {
            this.money = this.money.spendMoney(spentAmount);
            streamOutput.output("you just spent "+spentAmount);
        }
    }
}


