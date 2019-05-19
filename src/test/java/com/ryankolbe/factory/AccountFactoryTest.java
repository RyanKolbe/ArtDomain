package com.ryankolbe.factory;

import com.ryankolbe.domain.Account;
import org.junit.Assert;
import org.junit.Test;

public class AccountFactoryTest {

    @Test
    public void createAccount() {
        Account account = AccountFactory.createAccount("0001", "1234", "Orkin",
                "Pest Control");
        Assert.assertEquals("Orkin", account.getAccountName());
    }
}