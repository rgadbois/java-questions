package Model;

/**
 * Created by rgadbois on 8/6/16.
 */
public interface IAccount {

    String accountId();

    AccountType getType();

    void deposit(double amount);

    void withdraw(double amount);

    void transfer(IAccount toAccount);

    double getBalance();
}
