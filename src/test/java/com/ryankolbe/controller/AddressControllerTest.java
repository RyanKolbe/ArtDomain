package com.ryankolbe.controller;

import com.ryankolbe.domain.Address;
import com.ryankolbe.factory.AddressFactory;
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
public class AddressControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;
    private String uRL;

    @Before
    public void setUp() {
        Address address = AddressFactory.createAddress("0001",
                "1234", "Ryan", "Crescent");
        uRL = "http://localhost:8080/address";
        ResponseEntity<Address> postResponse = testRestTemplate.postForEntity(uRL + "/create",
                address, Address.class);
        System.out.println(postResponse.toString());
    }

    @Test
    public void create() {
        Address address = AddressFactory.createAddress("0002",
                "2465", "Deidre", "Circle");
        ResponseEntity<Address> postResponse = testRestTemplate.postForEntity(uRL + "/create", address,
                Address.class);
        Assert.assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        System.out.println(postResponse.toString());
    }

    @Test
    public void update() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", "0002");
        Address address = AddressFactory.createAddress("0003",
                "4658", "Rea", "Road");
        testRestTemplate.put(uRL + "/update/", parameters, address);
    }

    @Test
    public void read() {
        Address address = testRestTemplate.getForObject(uRL + "/read/0001",
                Address.class);
        Assert.assertNotNull(address);
    }

    @Test
    public void delete() {
        Address address = AddressFactory.createAddress("0002",
                "2465", "Deidre", "Street");
        ResponseEntity<Address> postResponse = testRestTemplate.postForEntity(uRL + "/create",
                address, Address.class);
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", "0002");
        testRestTemplate.delete(uRL + "/delete/" + parameters, Address.class);
        try {
            Address deleteAddress = testRestTemplate.getForObject(uRL + "/read/0002", Address.class);
            System.out.println(deleteAddress);
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