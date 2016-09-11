package Model;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by rgadbois on 8/7/16.
 */
public class Account implements IAccount {
    protected String id;
    protected AccountType type;
    protected AtomicLong balanceInCents;

    public Account(AccountType type, String id) {
        balanceInCents = new AtomicLong(0L);
        this.type = type;
        this.id = id;
    }

    public AccountType getType() {
        return type;
    }

    public String accountId() {
        return id;
    }

    public void deposit(double amount) {
        balanceInCents.getAndAdd((long) Math.floor(amount * 100.0));
    }

    public void withdraw(double amount) {
        balanceInCents.getAndAdd(Math.negateExact((long) Math.floor(amount * 100.0)));
    }

    public double getBalance() {
        return balanceInCents.doubleValue() / 100.0;
    }

    public void transfer(IAccount toAccount) {

    }
}