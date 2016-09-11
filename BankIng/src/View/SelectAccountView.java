package View;

import Controller.SelectAccountDelegate;
import Controller.SelectAccoutOperation;


import java.util.Scanner;

/**
 * Created by rgadbois on 8/7/16.
 */
public class SelectAccountView implements ISelectAccountView {

    private SelectAccountDelegate delegate;

    public void setDelegate(SelectAccountDelegate delegate) {
        this.delegate = delegate;
    }

    public SelectAccoutOperation getOperation(Scanner in) {
        boolean quit = false;
        int userChoice;
        String accountId;
        SelectAccoutOperation operation = SelectAccoutOperation.QUIT;
        do {
            System.out.println("1. Enter Account");
            System.out.println("2. Create Saving Account");
            System.out.println("3. Create Checking Account");
            System.out.println("4. List Accounts");
            System.out.print("Your choice, 0 to quit: ");
            userChoice = in.nextInt();
            switch (userChoice) {
                case 1:
                    System.out.print("Account name: ");
                    accountId = in.next();
                    delegate.setAccountId(accountId);
                    operation = SelectAccoutOperation.SELECT;
                    quit = true;
                    break;
                case 2:
                    operation = SelectAccoutOperation.CREATESAVING;
                    quit = true;
                    break;
                case 3:
                    operation = SelectAccoutOperation.CREATECHECKING;
                    quit = true;
                    break;
                case 4:
                    operation = SelectAccoutOperation.LIST;
                    quit = true;
                    break;
                case 0:
                    operation = SelectAccoutOperation.QUIT;
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
