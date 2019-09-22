package data;

import model.Account;
import model.Currency;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class AccountDAOTest {

    @Test
    public void concurrencyTest() throws InterruptedException {

        final int TRY_COUNT = 50;
        final int THREAD_COUNT = 50;
        Account a = new Account("1", Currency.GBP, 0);

        AccountDAO.getInstance().addAccount(a);

        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < TRY_COUNT; i++) {
            threads.add(new Thread(() -> {
                int i1 = TRY_COUNT;
                while (--i1 > 0) {
                    Account b = AccountDAO.getInstance().getAccount(a.getAccountID());
                    b.deposit(1.0);
                }

                i1 = TRY_COUNT;
                while (--i1 > 0) {
                    Account b = AccountDAO.getInstance().getAccount(a.getAccountID());
                    b.withdraw(1.0);
                }
            }));
        }

        synchronized (this) {
            for (int i = 0; i < THREAD_COUNT; i++)
                threads.get(i).start();

            for (int i = 0; i < THREAD_COUNT; i++)
                threads.get(i).join();
        }

        Assert.assertEquals(0.0, AccountDAO.getInstance().getAccount(a.getAccountID()).getBalance());

    }
}
