package Controller;

import Model.IAccount;
import Model.IAccountModel;
import View.IAccountOperationView;

import java.util.Scanner;

/**
 * Created by rgadbois on 8/7/16.
 */
public class AccountOperationController implements AccountOperationDelegate {

    private IAccountOperationView accountView;
    private IAccountModel accountModel;
    private double amount;

    public AccountOperationController(IAccountOperationView accountView, IAccountModel accountModel) {
        this.accountView = accountView;
        this.accountModel = accountModel;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void process(Scanner in, String accountId) {
        boolean quit = false;
        do {
            AccountOperation operation = accountView.getOperation(in);
            switch (operation) {
                case DEPOSIT: {
                    if (amount <= 0) {
                        accountView.displayMessage("Can't deposit negative amount.");
                    } else {
                        IAccount account = accountModel.getAccount(accountId);
                        if (account != null) {
                            account.deposit(amount);
                            accountView.displayMessage("$" + amount + " has been deposited.");
                        } else {
                            accountView.displayMessage("Error during deposit");
                        }
                    }
                }
                    break;
                case WITHDRAW: {
                    IAccount account = accountModel.getAccount(accountId);
                    if (account != null) {
                        double balance = account.getBalance();
                        if (amount <= 0 || amount > balance) {
                            accountView.displayMessage("Withdrawal can't be completed.");
                        } else {
                            account.withdraw(amount);
                            accountView.displayMessage("$" + amount + " has been withdrawn.");
                        }
                    } else {
                        accountView.displayMessage("Error during withdraw");
                    }
                }
                break;
                case BALANCE: {
                    IAccount account = accountModel.getAccount(accountId);
                    if (account != null) {
                        double balance = account.getBalance();
                        accountView.displayMessage("Your balance: $" + balance);
                    } else {
                        accountView.displayMessage("Error during get balance");
                    }
                }
                break;
                case QUIT:
                    quit = true;
                    break;
            }
        } while (!quit);
    }
}
