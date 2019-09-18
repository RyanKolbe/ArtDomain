package com.ryankolbe.controller;

import com.ryankolbe.domain.Packaging;
import com.ryankolbe.factory.PackagingFactory;
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
public class PackagingControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;
    private String uRL;

    @Before
    public void setUp() {
        Packaging packaging = PackagingFactory.createPackaging("0001",
                "123", "154", "253");
        uRL = "http://localhost:8080/packaging";
        ResponseEntity<Packaging> postResponse = testRestTemplate.withBasicAuth("admin", "admin")
                .postForEntity(uRL + "/create", packaging, Packaging.class);
        System.out.println(postResponse.toString());
    }

    @Test
    public void create() {
        Packaging packaging = PackagingFactory.createPackaging("0002",
                "465", "563", "145");
        ResponseEntity<Packaging> postResponse = testRestTemplate.withBasicAuth("admin", "admin")
                .postForEntity(uRL + "/create", packaging, Packaging.class);
        Assert.assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        System.out.println(postResponse.toString());
    }

    @Test
    public void update() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", "0002");
        Packaging packaging = PackagingFactory.createPackaging("0003",
                "458", "756", "653");
        testRestTemplate.put(uRL + "/update/", parameters, packaging);
    }

    @Test
    public void read() {
        Packaging packaging = testRestTemplate.getForObject(uRL + "/read/0001",
                Packaging.class);
        Assert.assertNotNull(packaging);
    }

    @Test
    public void delete() {
        Packaging packaging = PackagingFactory.createPackaging("0002",
                "246", "652", "234");
        ResponseEntity<Packaging> postResponse = testRestTemplate.withBasicAuth("admin", "admin")
                .postForEntity(uRL + "/create", packaging, Packaging.class);
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", "0002");
        testRestTemplate.delete(uRL + "/delete/" + parameters, Packaging.class);
        try {
            Packaging deletePackaging = testRestTemplate.getForObject(uRL + "/read/0002", Packaging.class);
            System.out.println(deletePackaging);
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