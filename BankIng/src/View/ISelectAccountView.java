package View;

import Controller.SelectAccountDelegate;
import Controller.SelectAccoutOperation;

import java.util.Scanner;

/**
 * Created by rgadbois on 8/7/16.
 */
public interface ISelectAccountView {
    void setDelegate(SelectAccountDelegate delegate);
    SelectAccoutOperation getOperation(Scanner in);
    void displayMessage(String msg);
}
