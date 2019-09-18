package com.ryankolbe.controller;

import com.ryankolbe.domain.Order;
import com.ryankolbe.factory.OrderFactory;
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
public class OrderControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;
    private String uRL;

    @Before
    public void setUp() {
        Order order = OrderFactory.createOrder("0001",
                2, 250.00);
        uRL = "http://localhost:8080/order";
        ResponseEntity<Order> postResponse = testRestTemplate.withBasicAuth("admin", "admin")
                .postForEntity(uRL + "/create", order, Order.class);
        System.out.println(postResponse.toString());
    }

    @Test
    public void create() {
        Order order = OrderFactory.createOrder("0002",
                6, 120.00);
        ResponseEntity<Order> postResponse = testRestTemplate.withBasicAuth("admin", "admin")
                .postForEntity(uRL + "/create", order, Order.class);
        Assert.assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        System.out.println(postResponse.toString());
    }

    @Test
    public void update() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", "0002");
        Order order = OrderFactory.createOrder("0003",
                8, 345.00);
        testRestTemplate.put(uRL + "/update/", parameters, order);
    }

    @Test
    public void read() {
        Order order = testRestTemplate.getForObject(uRL + "/read/0001",
                Order.class);
        Assert.assertNotNull(order);
    }

    @Test
    public void delete() {
        Order order = OrderFactory.createOrder("0002",
                2, 157.00);
        ResponseEntity<Order> postResponse = testRestTemplate.withBasicAuth("admin", "admin")
                .postForEntity(uRL + "/create", order, Order.class);
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", "0002");
        testRestTemplate.delete(uRL + "/delete/" + parameters, Order.class);
        try {
            Order deleteOrder = testRestTemplate.getForObject(uRL + "/read/0002", Order.class);
            System.out.println(deleteOrder);
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