package com.ryankolbe.service;

import com.ryankolbe.domain.Account;

import java.util.Set;

public interface AccountService extends IService<Account, String> {
    Set<Account> getAll();
}