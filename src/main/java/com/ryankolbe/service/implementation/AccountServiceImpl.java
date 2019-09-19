package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Account;
import com.ryankolbe.repository.AccountRepository;
import com.ryankolbe.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("AccountServiceImpl")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> getAll() {
        return this.accountRepository.findAll();
    }

    @Override
    public Account create(Account account) {
        return this.accountRepository.save(account);
    }

    @Override
    public Account read(String accountId) {
        Optional<Account> byId = this.accountRepository.findById(accountId);
        return byId.orElseThrow(RuntimeException::new);
    }

    @Override
    public Account update(Account account) {
        return this.accountRepository.save(account);
    }

    @Override
    public void delete(String accountId) {
        this.accountRepository.deleteById(accountId);
    }
}