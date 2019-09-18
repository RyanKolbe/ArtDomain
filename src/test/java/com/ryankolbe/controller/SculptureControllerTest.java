package com.ryankolbe.controller;

import com.ryankolbe.domain.Sculpture;
import com.ryankolbe.factory.SculptureFactory;
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
public class SculptureControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;
    private String uRL;

    @Before
    public void setUp() {
        Sculpture sculpture = SculptureFactory.createSculpture("0001",
                "Man Of Steel", "Marble");
        uRL = "http://localhost:8080/sculpture";
        ResponseEntity<Sculpture> postResponse = testRestTemplate.withBasicAuth("admin", "admin")
                .postForEntity(uRL + "/create", sculpture, Sculpture.class);
        System.out.println(postResponse.toString());
    }

    @Test
    public void create() {
        Sculpture sculpture = SculptureFactory.createSculpture("0002",
                "Greek Goddess Of Life", "Marble");
        ResponseEntity<Sculpture> postResponse = testRestTemplate.withBasicAuth("admin", "admin")
                .postForEntity(uRL + "/create", sculpture, Sculpture.class);
        Assert.assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        System.out.println(postResponse.toString());
    }

    @Test
    public void update() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", "0002");
        Sculpture sculpture = SculptureFactory.createSculpture("0003",
                "Brittle Life", "Clay");
        testRestTemplate.put(uRL + "/update/", parameters, sculpture);
    }

    @Test
    public void read() {
        Sculpture sculpture = testRestTemplate.getForObject(uRL + "/read/0001",
                Sculpture.class);
        Assert.assertNotNull(sculpture);
    }

    @Test
    public void delete() {
        Sculpture sculpture = SculptureFactory.createSculpture("0002",
                "Nature Of The Beast", "Reclaimed Wood");
        ResponseEntity<Sculpture> postResponse = testRestTemplate.withBasicAuth("admin", "admin")
                .postForEntity(uRL + "/create", sculpture, Sculpture.class);
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", "0002");
        testRestTemplate.delete(uRL + "/delete/" + parameters, Sculpture.class);
        try {
            Sculpture deleteSculpture = testRestTemplate.getForObject(uRL + "/read/0002", Sculpture.class);
            System.out.println(deleteSculpture);
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