package com.ryankolbe.controller;

import com.ryankolbe.domain.Customer;
import com.ryankolbe.factory.CustomerFactory;
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
public class CustomerControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;
    private String uRL;

    @Before
    public void setUp() {
        Customer customer = CustomerFactory.createCustomer("0001",
                "Ryan", "0820546897");
        uRL = "http://localhost:8080/customer";
        ResponseEntity<Customer> postResponse = testRestTemplate.postForEntity(uRL + "/create",
                customer, Customer.class);
        System.out.println(postResponse.toString());
    }

    @Test
    public void create() {
        Customer customer = CustomerFactory.createCustomer("0002",
                "Deidre", "0764985612");
        ResponseEntity<Customer> postResponse = testRestTemplate.postForEntity(uRL + "/create", customer,
                Customer.class);
        Assert.assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        System.out.println(postResponse.toString());
    }

    @Test
    public void update() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", "0002");
        Customer customer = CustomerFactory.createCustomer("0003",
                "Rea", "0826594658");
        testRestTemplate.put(uRL + "/update/", parameters, customer);
    }

    @Test
    public void read() {
        Customer customer = testRestTemplate.getForObject(uRL + "/read/0001",
                Customer.class);
        Assert.assertNotNull(customer);
    }

    @Test
    public void delete() {
        Customer customer = CustomerFactory.createCustomer("0002",
                 "Deidre", "0762825979");
        ResponseEntity<Customer> postResponse = testRestTemplate.postForEntity(uRL + "/create",
                customer, Customer.class);
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", "0002");
        testRestTemplate.delete(uRL + "/delete/" + parameters, Customer.class);
        try {
            Customer deleteCustomer = testRestTemplate.getForObject(uRL + "/read/0002", Customer.class);
            System.out.println(deleteCustomer);
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