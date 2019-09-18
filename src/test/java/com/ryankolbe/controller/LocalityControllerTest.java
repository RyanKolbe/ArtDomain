package com.ryankolbe.controller;

import com.ryankolbe.domain.Locality;
import com.ryankolbe.factory.LocalityFactory;
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
public class LocalityControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;
    private String uRL;

    @Before
    public void setUp() {
        Locality locality = LocalityFactory.createLocality("0001",
                "Steenberg", "Western Cape", "South Africa",
                "7958");
        uRL = "http://localhost:8080/locality";
        ResponseEntity<Locality> postResponse = testRestTemplate.withBasicAuth("admin", "admin")
                .postForEntity(uRL + "/create", locality, Locality.class);
        System.out.println(postResponse.toString());
    }

    @Test
    public void create() {
        Locality locality = LocalityFactory.createLocality("0002",
                "Wynberg", "Western Cape", "South Africa",
                "4679");
        ResponseEntity<Locality> postResponse = testRestTemplate.withBasicAuth("admin", "admin")
                .postForEntity(uRL + "/create", locality, Locality.class);
        Assert.assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        System.out.println(postResponse.toString());
    }

    @Test
    public void update() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", "0002");
        Locality locality = LocalityFactory.createLocality("0003",
                "Ottery", "Western Cape", "South Africa",
                "7659");
        testRestTemplate.put(uRL + "/update/", parameters, locality);
    }

    @Test
    public void read() {
        Locality locality = testRestTemplate.getForObject(uRL + "/read/0001",
                Locality.class);
        Assert.assertNotNull(locality);
    }

    @Test
    public void delete() {
        Locality locality = LocalityFactory.createLocality("0002",
                "Brackenfell", "Western Cape", "South Africa",
                "8594");
        ResponseEntity<Locality> postResponse = testRestTemplate.withBasicAuth("admin", "admin")
                .postForEntity(uRL + "/create", locality, Locality.class);
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", "0002");
        testRestTemplate.delete(uRL + "/delete/" + parameters, Locality.class);
        try {
            Locality deleteLocality = testRestTemplate.getForObject(uRL + "/read/0002", Locality.class);
            System.out.println(deleteLocality);
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