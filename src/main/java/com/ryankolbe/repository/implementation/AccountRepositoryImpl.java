/*
package com.ryankolbe.repository.implementation;

import com.ryankolbe.domain.Account;
import com.ryankolbe.repository.AccountRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("AccountRepository")
public class AccountRepositoryImpl implements AccountRepository {
    private static AccountRepositoryImpl accountRepository = null;
    private Set<Account> accounts;

    private AccountRepositoryImpl() {
        this.accounts = new HashSet<>();
    }

    public static AccountRepositoryImpl getAccountRepository() {
        if (accountRepository == null) accountRepository = new AccountRepositoryImpl();
        return accountRepository;
    }

    @Override
    public Account create(Account account) {
        this.accounts.add(account);
        return account;
    }

    @Override
    public Account read(String accountId) {
        return search(accountId);
    }

    @Override
    public Account update(Account account) {
        Account accountTemp = search(account.getAccountId());
        if (accountTemp != null) {
            accounts.remove(accountTemp);
            return create(account);
        }
        return null;
    }

    @Override
    public void delete(String accountId) {
        Account accountDelete = search(accountId);
        if (accountDelete != null) this.accounts.remove(accountDelete);
    }

    private Account search(final String accountId) {
        for (Account accountSearch : this.accounts) {
            if (accountSearch.getAccountId().equals(accountId))
                return accountSearch;
        }
        return null;
    }

    @Override
    public Set<Account> getAll() {
        return this.accounts;
    }
}
*/
