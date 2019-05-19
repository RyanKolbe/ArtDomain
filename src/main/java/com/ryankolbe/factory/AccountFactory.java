package com.ryankolbe.factory;

import com.ryankolbe.domain.Account;

public class AccountFactory {
    public static Account createAccount(String accountId, String accountNumber,
                                        String accountName, String accountCategory) {
        return new Account.Builder()
                .accountId(accountId)
                .acccountName(accountName)
                .accountNumber(accountNumber)
                .accountCategory(accountCategory)
                .build();
    }
}