package Model;

/**
 * Created by rgadbois on 8/6/16.
 */
public class CheckingAccount extends Account {

    public CheckingAccount(String id)
    {
        super(AccountType.CHECKING, id);
    }

    public CheckingAccount(String id, double initialBalance)
    {
        super(AccountType.CHECKING, id);
        if (initialBalance < 0) {
            throw new RuntimeException();
        }
        this.balanceInCents.set((long) Math.floor(initialBalance * 100.0));
    }

}
