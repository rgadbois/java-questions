package Controller;

import Model.AccountType;
import Model.IAccountModel;
import View.AccountOperationView;
import View.IAccountOperationView;
import View.ISelectAccountView;

import java.util.Scanner;
import java.util.Set;

/**
 * Created by rgadbois on 8/7/16.
 */
public class SelectAccountController implements SelectAccountDelegate {

    private ISelectAccountView accountView;
    private IAccountModel accountModel;
    private String accountId;

    public SelectAccountController(ISelectAccountView accountView, IAccountModel accountModel) {
        this.accountView = accountView;
        this.accountModel = accountModel;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void process(Scanner in) {
        boolean quit = false;
        do {
            SelectAccoutOperation operation = accountView.getOperation(in);
            switch (operation) {
                case SELECT: {
                    if ((accountId == null) || !accountModel.isPresent(accountId)) {
                        accountView.displayMessage("Account: id not valid");
                    } else {
                        IAccountOperationView accountView = new AccountOperationView();
                        AccountOperationController controller = new AccountOperationController(accountView, accountModel);
                        accountView.setDelegate(controller);
                        controller.process(in, accountId);
                    }
                }
                break;
                case CREATESAVING: {
                    accountId = accountModel.createAccount(AccountType.SAVINGS);
                    accountView.displayMessage("Created Saving Account : " + accountId);
                }
                break;
                case CREATECHECKING: {
                    accountId = accountModel.createAccount(AccountType.CHECKING);
                    accountView.displayMessage("Created Checking Account : " + accountId);
                }
                break;
                case LIST: {
                    Set<String> allAccounts = accountModel.getAllAccountIds();
                    if ((allAccounts == null) || allAccounts.isEmpty()) {
                        accountView.displayMessage("No Accounts available");
                    } else {
                        for (String id : allAccounts) {
                            accountView.displayMessage("Account: " + id);
                        }
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
