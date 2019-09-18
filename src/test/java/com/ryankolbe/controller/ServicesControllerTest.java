package com.ryankolbe.controller;

import com.ryankolbe.domain.Services;
import com.ryankolbe.factory.ServicesFactory;
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
public class ServicesControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;
    private String uRL;

    @Before
    public void setUp() {
        Services services = ServicesFactory.createServices("0001",
                "Art Restoration", "Restoration", 2500.00);
        uRL = "http://localhost:8080/services";
        ResponseEntity<Services> postResponse = testRestTemplate.withBasicAuth("admin", "admin")
                .postForEntity(uRL + "/create", services, Services.class);
        System.out.println(postResponse.toString());
    }

    @Test
    public void create() {
        Services services = ServicesFactory.createServices("0002",
                "Painting Courses", "Art Courses", 500.00);
        ResponseEntity<Services> postResponse = testRestTemplate.withBasicAuth("admin", "admin")
                .postForEntity(uRL + "/create", services, Services.class);
        Assert.assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        System.out.println(postResponse.toString());
    }

    @Test
    public void update() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", "0002");
        Services services = ServicesFactory.createServices("0003",
                "Photocopying", "Copies", 25.00);
        testRestTemplate.put(uRL + "/update/", parameters, services);
    }

    @Test
    public void read() {
        Services services = testRestTemplate.getForObject(uRL + "/read/0001",
                Services.class);
        Assert.assertNotNull(services);
    }

    @Test
    public void delete() {
        Services services = ServicesFactory.createServices("0002",
                "Photoshop Service", "Digital Enhancements", 150.00);
        ResponseEntity<Services> postResponse = testRestTemplate.withBasicAuth("admin", "admin")
                .postForEntity(uRL + "/create", services, Services.class);
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", "0002");
        testRestTemplate.delete(uRL + "/delete/" + parameters, Services.class);
        try {
            Services deleteServices = testRestTemplate.getForObject(uRL + "/read/0002", Services.class);
            System.out.println(deleteServices);
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