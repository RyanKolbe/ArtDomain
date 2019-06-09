package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Account;
import com.ryankolbe.factory.AccountFactory;
import com.ryankolbe.service.AccountService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AccountServiceImplTest {
    @Autowired
    @Qualifier("AccountServiceImpl")
    private AccountService accountService;
    private Account account;
    private Set<Account> accounts = new HashSet<>();

    @Before
    public void setUp() {
        account = accountService.create(AccountFactory.createAccount("0001", "1234",
                "Gold Card", "Cheque Account"));
        accounts.add(account);
    }

    @Test
    public void create() {
        Account createAccount = accountService.create(AccountFactory.createAccount("0002", "3568",
                "Platinum Card", "Checque Account"));
        accounts.add(createAccount);
        Assert.assertEquals(createAccount, accountService.read(createAccount.getAccountId()));
    }

    @Test
    public void read() {
        Account readAccount = accountService.read(account.getAccountId());
        Assert.assertEquals(readAccount, accountService.read(readAccount.getAccountId()));
    }

    @Test
    public void update() {
        String newAccountName = "Private Wealth Card";
        Account updateAccount = accountService.update(new Account.Builder().copy(account).
                acccountName(newAccountName).build());
        accounts.add(updateAccount);
        Assert.assertEquals(updateAccount, accountService.read(updateAccount.getAccountId()));
    }

    @Test
    public void delete() {
        accounts.addAll(accountService.getAll());
        Account deleteAccount = accountService.create(AccountFactory.createAccount("0268",
                "5498", "Gold Card", "Credit Card"));
        accounts.add(deleteAccount);
        accounts.remove(deleteAccount);
        accountService.delete(deleteAccount.getAccountId());
        Assert.assertEquals(accounts.size(), accountService.getAll().size());
    }

    @Test
    public void getAll() {
        Set<Account> accountSet = accountService.getAll();
        Assert.assertEquals(accountSet.size(), accountService.getAll().size());
    }
}