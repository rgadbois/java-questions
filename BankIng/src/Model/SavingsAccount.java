package Model;

import Model.Account;

/**
 * Created by rgadbois on 8/6/16.
 */
public class SavingsAccount extends Account {

    public SavingsAccount(String id)
    {
        super(AccountType.SAVINGS, id);
    }

    public SavingsAccount(String id, double initialBalance)
    {
        super(AccountType.SAVINGS, id);
        if (initialBalance < 0) {
            throw new RuntimeException();
        }
        this.balanceInCents.set((long) Math.floor(initialBalance * 100.0));
    }

}