package com.ryankolbe.controller;

import com.ryankolbe.domain.Login;
import com.ryankolbe.factory.LoginFactory;
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
public class LoginControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;
    private String uRL;

    @Before
    public void setUp() {
        Login login = LoginFactory.createLogin("0001",
                "Ryan", "1234");
        uRL = "http://localhost:8080/login";
        ResponseEntity<Login> postResponse = testRestTemplate.postForEntity(uRL + "/create",
                login, Login.class);
        System.out.println(postResponse.toString());
    }

    @Test
    public void create() {
        Login login = LoginFactory.createLogin("0002",
                "Deidre", "2465");
        ResponseEntity<Login> postResponse = testRestTemplate.postForEntity(uRL + "/create", login,
                Login.class);
        Assert.assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        System.out.println(postResponse.toString());
    }

    @Test
    public void update() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", "0002");
        Login login = LoginFactory.createLogin("0003",
                "Rea", "4658");
        testRestTemplate.put(uRL + "/update/", parameters, login);
    }

    @Test
    public void read() {
        Login login = testRestTemplate.getForObject(uRL + "/read/0001",
                Login.class);
        Assert.assertNotNull(login);
    }

    @Test
    public void delete() {
        Login login = LoginFactory.createLogin("0002",
                "Deidre", "2465");
        ResponseEntity<Login> postResponse = testRestTemplate.postForEntity(uRL + "/create",
                login, Login.class);
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", "0002");
        testRestTemplate.delete(uRL + "/delete/" + parameters, Login.class);
        try {
            Login deleteLogin = testRestTemplate.getForObject(uRL + "/read/0002", Login.class);
            System.out.println(deleteLogin);
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