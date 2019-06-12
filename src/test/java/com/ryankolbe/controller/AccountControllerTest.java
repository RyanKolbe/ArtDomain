package com.ryankolbe.controller;

import com.ryankolbe.domain.Account;
import com.ryankolbe.factory.AccountFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class AccountControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;
    private String uRL;

    @Before
    public void setUp() {
        Account account = AccountFactory.createAccount("0001",
                "1234", "Ryan", "Yolo");
        uRL = "http://localhost:8080/account";
        ResponseEntity<Account> postResponse = testRestTemplate.postForEntity(uRL + "/create",
                account, Account.class);
        System.out.println(postResponse.toString());
    }

    @Test
    public void create() {
        Account account = AccountFactory.createAccount("0002",
                "2465", "Deidre", "Credit");
        ResponseEntity<Account> postResponse = testRestTemplate.postForEntity(uRL + "/create", account,
                Account.class);
        Assert.assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        System.out.println(postResponse.toString());
    }

    @Test
    public void update() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", "0002");
        Account account = AccountFactory.createAccount("0003",
                "4658", "Rea", "Credit");
        testRestTemplate.put(uRL + "/update/", parameters, account);
    }

    @Test
    public void read() {
        Account account = testRestTemplate.getForObject(uRL + "/read/0001",
                Account.class);
        Assert.assertNotNull(account);
    }

    @Test
    public void delete() {
        Account account = AccountFactory.createAccount("0002",
                "2465", "Deidre", "Credit");
        ResponseEntity<Account> postResponse = testRestTemplate.postForEntity(uRL + "/create",
                account, Account.class);
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", "0002");
        testRestTemplate.delete(uRL + "/delete/" + parameters, Account.class);
        try {
            Account deleteAccount = testRestTemplate.getForObject(uRL + "/read/0002", Account.class);
            System.out.println(deleteAccount);
        } catch (final HttpClientErrorException e) {
            Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void getAll() {
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> stringHttpEntity = new HttpEntity<>(null, httpHeaders);
        HttpEntity<String> response = testRestTemplate.exchange(
                uRL + "/getAll/all", HttpMethod.GET,
                stringHttpEntity, String.class);
        Assert.assertNotNull(response.getBody());
    }
}