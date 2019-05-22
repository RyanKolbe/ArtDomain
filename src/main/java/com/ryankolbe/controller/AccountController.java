package com.ryankolbe.controller;

import com.ryankolbe.domain.Account;
import com.ryankolbe.service.AccountService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;

    public AccountController(@Qualifier("AccountServiceImpl") AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/create")
    @ResponseBody
    public Account create(Account account) {
        return accountService.create(account);
    }

    @PostMapping("/update")
    @ResponseBody
    public Account update(Account account) {
        return accountService.update(account);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Account read(@PathVariable String id) {
        return accountService.read(id);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        accountService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public Set<Account> getAll() {
        return accountService.getAll();
    }
}