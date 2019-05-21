package com.ryankolbe.repository.implementation;

import com.ryankolbe.domain.Account;
import com.ryankolbe.repository.AccountRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

public class AccountRepositoryImplTest {
    private AccountRepository accountRepository;
    private Account account;

    @Before
    public void setUp() throws Exception {
        accountRepository = AccountRepositoryImpl.getAccountRepository();
    }

    @Test
    public void getAccountRepository() {
        Assert.assertNotNull(accountRepository);
    }

    @Test
    public void create() {
    }

    @Test
    public void read() {
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void getAll() {
        Set<Account> accounts = this.accountRepository.getAll();
        Assert.assertEquals(accounts, accountRepository.getAll());
    }
}