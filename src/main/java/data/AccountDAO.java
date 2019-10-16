package data;

import model.Account;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AccountDAO {
    // store account id to Account object.
    private static final Map ACCOUNT_STORE = new ConcurrentHashMap<String, Account>();
    private static AccountDAO instance;

    //for singleton
    private AccountDAO() {
    }

    public static AccountDAO getInstance() {
        if (instance == null) {
            instance = new AccountDAO();
        }
        return instance;
    }

    /**
     * Retrives account with id
     *
     * @param accountID id
     * @return Account
     */
    public Account getAccount(String accountID) {
        return (Account) ACCOUNT_STORE.get(accountID);
    }

    // TODO method gives warning
    public boolean updateAccount(Account account) {
        Account fetchedAccount = getAccount(account.getAccountID());
        if (fetchedAccount == null) {
            return false;
        }

        ACCOUNT_STORE.put(account.getAccountID(), account);
        return true;
    }

    /**
     * Add account to ACCOUNT_STORE if the id does not exists
     *
     * @param account account object to be stored
     * @return true for success, false for existing accounts
     */
//    public Account createAccount(final String name) {
//        Account acc = new Account();
//
//        addAccount(acc);
//        return acc;
//    }


    public boolean addAccount(Account account) {
        if (ACCOUNT_STORE.containsKey(account.getAccountID())) {
            return false;
        }
        ACCOUNT_STORE.put(account.getAccountID(), account);
        return true;
    }

    /**
     * Remove account if exists
     *
     * @param accountID to be deleted
     * @return false for non-exists account
     */
    public boolean removeAccount(String accountID) {
        if (ACCOUNT_STORE.containsKey(accountID)) {
            ACCOUNT_STORE.remove(accountID);
            return true;
        }
        return false;
    }
}
