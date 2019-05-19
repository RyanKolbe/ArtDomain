package com.ryankolbe.repository;

import com.ryankolbe.domain.Account;

import java.util.Set;

public interface AccountRepository extends IRepository<Account, String> {
    Set<Account> getAll();
}
