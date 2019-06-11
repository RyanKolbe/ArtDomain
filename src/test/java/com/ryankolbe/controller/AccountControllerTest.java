package com.ryankolbe.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class AccountControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/account";

    @Before
    public void setUp() {
    }

    @Test
    public void create() {
    }

    @Test
    public void update() {
    }

    @Test
    public void read() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void getAll() {
    }
}