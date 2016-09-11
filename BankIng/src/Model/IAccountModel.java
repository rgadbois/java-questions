package Model;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Set;

/**
 * Created by rgadbois on 8/7/16.
 */
public interface IAccountModel {
    String createAccount(AccountType type);
    boolean isPresent(String id);
    IAccount getAccount(String id);
    Set<String> getAllAccountIds();

    void deleteAccount(String id);
}
