package com.ryankolbe.repository.implementation;

import com.ryankolbe.domain.Account;
import com.ryankolbe.factory.AccountFactory;
import com.ryankolbe.repository.AccountRepository;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashSet;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AccountRepositoryImplTest {
    private static AccountRepository accountRepository = AccountRepositoryImpl.getAccountRepository();
    private static Account account;
    private static Set<Account> accounts = new HashSet<>();

    @BeforeClass
    public static void setUp() {
        account = AccountFactory.createAccount("0001", "1234",
                "Cheque Card", "Check Account");
        accounts.add(accountRepository.create(account));
    }

    @Test
    public void getAccountRepository() {
        Assert.assertNotNull(accountRepository);
    }

    @Test
    public void create() {
        Account newAccount = AccountFactory.createAccount("0001", "2345",
                "Credit Card", "Credit Account");
        accounts.add(accountRepository.create(newAccount));
        Assert.assertEquals(newAccount.getAccountId(), accountRepository.read(newAccount.getAccountId()).getAccountId());
    }

    @Test
    public void read() {
        Account readAccount = accountRepository.getAll().iterator().next();
        accounts.add(readAccount);
        Assert.assertEquals(readAccount.getAccountId(), accountRepository.read(readAccount.getAccountId()).getAccountId());
    }

    @Test
    public void update() {
        String newAccountCategory = "Overdraft";
        Account updateAccount = new Account.Builder().copy(account).accountCategory(newAccountCategory).build();
        accountRepository.update(account);
        System.out.println(updateAccount);
        Assert.assertEquals(newAccountCategory, updateAccount.getAccountCategory());
    }

    @Test
    public void delete() {
        Account deleteAccount = accountRepository.create(AccountFactory.createAccount("4321", "5421",
                "Platinum Card", "Cheque Account"));
        accounts.add(deleteAccount);
        accounts.remove(deleteAccount);
        accountRepository.getAll().remove(deleteAccount);
        Assert.assertEquals(accounts.size(), accountRepository.getAll().size());
    }

    @Test
    public void getAll() {
        Set<Account> accountSet = accountRepository.getAll();
        Assert.assertEquals(accountSet, accountRepository.getAll());
    }
}