package com.ryankolbe.controller;

import com.ryankolbe.domain.Courier;
import com.ryankolbe.factory.CourierFactory;
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
public class CourierControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;
    private String uRL;

    @Before
    public void setUp() {
        Courier courier = CourierFactory.createCourier("0001",
                "DHL", "0215957656");
        uRL = "http://localhost:8080/courier";
        ResponseEntity<Courier> postResponse = testRestTemplate.postForEntity(uRL + "/create",
                courier, Courier.class);
        System.out.println(postResponse.toString());
    }

    @Test
    public void create() {
        Courier courier = CourierFactory.createCourier("0002",
                "FedEx", "0217659784");
        ResponseEntity<Courier> postResponse = testRestTemplate.postForEntity(uRL + "/create", courier,
                Courier.class);
        Assert.assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        System.out.println(postResponse.toString());
    }

    @Test
    public void update() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", "0002");
        Courier courier = CourierFactory.createCourier("0003",
                "DropZone", "0315978465");
        testRestTemplate.put(uRL + "/update/", parameters, courier);
    }

    @Test
    public void read() {
        Courier courier = testRestTemplate.getForObject(uRL + "/read/0001",
                Courier.class);
        Assert.assertNotNull(courier);
    }

    @Test
    public void delete() {
        Courier courier = CourierFactory.createCourier("0002",
                "Mr Delivery", "0114758965");
        ResponseEntity<Courier> postResponse = testRestTemplate.postForEntity(uRL + "/create",
                courier, Courier.class);
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", "0002");
        testRestTemplate.delete(uRL + "/delete/" + parameters, Courier.class);
        try {
            Courier deleteCourier = testRestTemplate.getForObject(uRL + "/read/0002", Courier.class);
            System.out.println(deleteCourier);
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