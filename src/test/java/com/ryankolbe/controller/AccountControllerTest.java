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
        ResponseEntity<Account> postResponse = testRestTemplate.postForEntity(uRL + "/create", account,
                Account.class);
    }

    @Test
    public void create() {
        Account account = AccountFactory.createAccount("0002",
                "2465", "Deidre", "Credit");
        ResponseEntity<Account> postResponse = testRestTemplate.postForEntity(uRL + "/create", account,
                Account.class);
        Assert.assertEquals(HttpStatus.OK, postResponse.getStatusCode());
    }

    @Test
    public void update() {
        int id = 1;
        Account account = testRestTemplate.getForObject(uRL + "/read/" + id, Account.class);
        ResponseEntity<Account> postResponse = testRestTemplate.postForEntity(uRL + "/create", account,
                Account.class);
        System.out.println(postResponse);
        testRestTemplate.put(uRL + "/account/" + id, account);
        int newId = 3;
        Account updatedStudent = testRestTemplate.getForObject(uRL + "/update/" + newId, Account.class);
        Assert.assertNotNull(updatedStudent);
        System.out.println(updatedStudent);
    }

    @Test
    public void read() {

        Account account = testRestTemplate.getForObject(uRL + "/read/0001",
                Account.class);
        System.out.println(account.getAccountName());
        Assert.assertNotNull(account);

    }

    @Test
    public void delete() {
        int id = 2;
        Account account = testRestTemplate.getForObject(uRL + "/students/" + id, Account.class);
        Assert.assertNotNull(account);
        testRestTemplate.delete(uRL + "/students/" + id);
        try {
            account = testRestTemplate.getForObject(uRL + "/students/" + id, Account.class);
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
    }
}