package com.ryankolbe.service;

import com.ryankolbe.domain.Account;

import java.util.List;

public interface AccountService extends IService<Account, String> {
    List<Account> getAll();
}