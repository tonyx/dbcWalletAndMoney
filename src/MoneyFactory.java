/**
 * Created with IntelliJ IDEA.
 * User: Tony
 * Date: 03/02/13
 * Time: 12.19
 * To change this template use File | Settings | File Templates.
 */
public class MoneyFactory {
    public Money money(int amount) {
        return new Money(amount);
    }
}
