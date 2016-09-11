package View;

import Controller.AccountOperation;
import Controller.AccountOperationDelegate;

import java.util.Scanner;

/**
 * Created by rgadbois on 8/7/16.
 */
public class AccountOperationView implements IAccountOperationView {

    private AccountOperationDelegate delegate;

    @Override
    public void setDelegate(AccountOperationDelegate delegate) {
        this.delegate = delegate;
    }

    public AccountOperation getOperation(Scanner in) {

        AccountOperation operation = AccountOperation.QUIT;
        boolean quit = false;
        int userChoice;
        do {
            System.out.println("1. Deposit money");
            System.out.println("2. Withdraw money");
            System.out.println("3. Check balance");
            System.out.print("Your choice, 0 to quit: ");
            userChoice = in.nextInt();
            switch (userChoice) {
                case 1: {
                    System.out.print("Amount to deposit: ");
                    float amount = in.nextFloat();
                    delegate.setAmount(amount);
                    operation = AccountOperation.DEPOSIT;
                    quit = true;
                }
                break;
                case 2: {
                    System.out.print("Amount to withdraw: ");
                    float amount = in.nextFloat();
                    delegate.setAmount(amount);
                    operation = AccountOperation.WITHDRAW;
                    quit = true;
                }
                break;
                case 3:
                    operation = AccountOperation.BALANCE;
                    quit = true;
                    break;
                case 0:
                    operation = AccountOperation.QUIT;
                    quit = true;
                    break;
                default:
                    System.out.println("Wrong choice.");
                    break;
            }
            System.out.println();
        } while (!quit);
        return operation;
    }
    public void displayMessage(String msg) {
        System.out.println(msg);
    }

}
