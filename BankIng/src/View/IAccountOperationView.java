package View;

import Controller.AccountOperation;
import Controller.AccountOperationDelegate;

import java.util.Scanner;

/**
 * Created by rgadbois on 8/7/16.
 */
public interface IAccountOperationView {
    void setDelegate(AccountOperationDelegate delegate);
    AccountOperation getOperation(Scanner in);
    void displayMessage(String msg);
}
