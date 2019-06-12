package com.ryankolbe.controller;

import com.ryankolbe.domain.Returns;
import com.ryankolbe.factory.ReturnsFactory;
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
public class ReturnsControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;
    private String uRL;

    @Before
    public void setUp() {
        Returns returns = ReturnsFactory.createReturns("0001",
                "Damaged", 1, 800.00);
        uRL = "http://localhost:8080/returns";
        ResponseEntity<Returns> postResponse = testRestTemplate.postForEntity(uRL + "/create",
                returns, Returns.class);
        System.out.println(postResponse.toString());
    }

    @Test
    public void create() {
        Returns returns = ReturnsFactory.createReturns("0002",
                "Quality", 1, 1000.00);
        ResponseEntity<Returns> postResponse = testRestTemplate.postForEntity(uRL + "/create", returns,
                Returns.class);
        Assert.assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        System.out.println(postResponse.toString());
    }

    @Test
    public void update() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", "0002");
        Returns returns = ReturnsFactory.createReturns("0003",
                "Incorrect Item Delivered", 2, 1500.00);
        testRestTemplate.put(uRL + "/update/", parameters, returns);
    }

    @Test
    public void read() {
        Returns returns = testRestTemplate.getForObject(uRL + "/read/0001",
                Returns.class);
        Assert.assertNotNull(returns);
    }

    @Test
    public void delete() {
        Returns returns = ReturnsFactory.createReturns("0002",
                "Damaged", 2, 700.00);
        ResponseEntity<Returns> postResponse = testRestTemplate.postForEntity(uRL + "/create",
                returns, Returns.class);
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", "0002");
        testRestTemplate.delete(uRL + "/delete/" + parameters, Returns.class);
        try {
            Returns deleteReturns = testRestTemplate.getForObject(uRL + "/read/0002", Returns.class);
            System.out.println(deleteReturns);
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