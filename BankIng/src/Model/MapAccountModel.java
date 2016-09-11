package Model;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;


/**
 * Created by rgadbois on 8/7/16.
 */
public class MapAccountModel implements IAccountModel {

    private Map<String, IAccount> accounts;
    private static AtomicLong count = new AtomicLong(0L);

    public MapAccountModel() {
        accounts = new ConcurrentHashMap<>();
    }

    public String createAccount(AccountType type) {
        IAccount account = null;

        Long oldCount = count.getAndIncrement();
        switch (type) {
            case SAVINGS:
                account = new SavingsAccount(oldCount.toString());
                accounts.put(account.accountId(), account);
                break;
            case CHECKING:
                account = new CheckingAccount(oldCount.toString());
                accounts.put(account.accountId(), account);
                break;
        }
        return account.accountId();
    }
    public boolean isPresent(String id) {
        return accounts.containsKey(id);
    }
    public IAccount getAccount(String id) {
        return accounts.get(id);
    }

    public Set<String> getAllAccountIds() {
        return accounts.keySet();
    }
    public void deleteAccount(String id) {
        accounts.remove(id);
    }
}

