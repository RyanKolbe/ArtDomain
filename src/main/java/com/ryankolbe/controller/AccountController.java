package com.ryankolbe.controller;

import com.ryankolbe.domain.Account;
import com.ryankolbe.service.AccountService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Set;

@RestController
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;

    public AccountController(@Qualifier("AccountServiceImpl") AccountService accountService, RestTemplate restTemplate) {
        this.accountService = accountService;
    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Account  create(@RequestBody Account account) {
        return accountService.create(account);
    }

    @PutMapping("/update")
    @ResponseBody
    public Account update(@RequestBody Account account) {
        return accountService.update(account);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Account read(@PathVariable String id) {
        return accountService.read(id);
    }

    @DeleteMapping("/delete/{id}")
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