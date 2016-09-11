import Controller.AccountOperationController;
import Controller.SelectAccountController;
import Model.IAccount;
import Model.IAccountModel;
import Model.MapAccountModel;
import View.IAccountOperationView;
import View.AccountOperationView;
import View.ISelectAccountView;
import View.SelectAccountView;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        IAccountModel accountModel = new MapAccountModel();
        ISelectAccountView selectAccountView = new SelectAccountView();
        SelectAccountController controller = new SelectAccountController(selectAccountView, accountModel);
        selectAccountView.setDelegate(controller);

        controller.process(in);
    }
}
