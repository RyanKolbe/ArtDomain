package com.ryankolbe.controller;

import com.ryankolbe.domain.Curator;
import com.ryankolbe.factory.CuratorFactory;
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
public class CuratorControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;
    private String uRL;

    @Before
    public void setUp() {
        Curator curator = CuratorFactory.createCurator("0001",
                 "Ryan", "Kolbe");
        uRL = "http://localhost:8080/curator";
        ResponseEntity<Curator> postResponse = testRestTemplate.withBasicAuth("admin", "admin")
                .postForEntity(uRL + "/create", curator, Curator.class);
        System.out.println(postResponse.toString());
    }

    @Test
    public void create() {
        Curator curator = CuratorFactory.createCurator("0002",
                 "Deidre", "Van Vuuren");
        ResponseEntity<Curator> postResponse = testRestTemplate.withBasicAuth("admin", "admin")
                .postForEntity(uRL + "/create", curator, Curator.class);
        Assert.assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        System.out.println(postResponse.toString());
    }

    @Test
    public void update() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", "0002");
        Curator curator = CuratorFactory.createCurator("0003",
                 "Rea", "Naidu");
        testRestTemplate.put(uRL + "/update/", parameters, curator);
    }

    @Test
    public void read() {
        Curator curator = testRestTemplate.getForObject(uRL + "/read/0001",
                Curator.class);
        Assert.assertNotNull(curator);
    }

    @Test
    public void delete() {
        Curator curator = CuratorFactory.createCurator("0002",
                 "Deidre","Kolbe");
        ResponseEntity<Curator> postResponse = testRestTemplate.withBasicAuth("admin", "admin")
                .postForEntity(uRL + "/create", curator, Curator.class);
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", "0002");
        testRestTemplate.delete(uRL + "/delete/" + parameters, Curator.class);
        try {
            Curator deleteCurator = testRestTemplate.getForObject(uRL + "/read/0002", Curator.class);
            System.out.println(deleteCurator);
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