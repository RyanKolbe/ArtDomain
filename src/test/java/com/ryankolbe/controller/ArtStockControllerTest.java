package com.ryankolbe.controller;

import com.ryankolbe.domain.ArtStock;
import com.ryankolbe.factory.ArtStockFactory;
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
public class ArtStockControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;
    private String uRL;

    @Before
    public void setUp() {
        ArtStock artStock = ArtStockFactory.createArtStock("0001",
                "Black Ink", 1, "Ink");
        uRL = "http://localhost:8080/artStock";
        ResponseEntity<ArtStock> postResponse = testRestTemplate.postForEntity(uRL + "/create",
                artStock, ArtStock.class);
        System.out.println(postResponse.toString());
    }

    @Test
    public void create() {
        ArtStock artStock = ArtStockFactory.createArtStock("0002",
                "White Paper", 3, "Paper");
        ResponseEntity<ArtStock> postResponse = testRestTemplate.postForEntity(uRL + "/create", artStock,
                ArtStock.class);
        Assert.assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        System.out.println(postResponse.toString());
    }

    @Test
    public void update() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", "0002");
        ArtStock artStock = ArtStockFactory.createArtStock("0003",
                "Black Pens", 3, "Pens");
        testRestTemplate.put(uRL + "/update/", parameters, artStock);
    }

    @Test
    public void read() {
        ArtStock artStock = testRestTemplate.getForObject(uRL + "/read/0001",
                ArtStock.class);
        Assert.assertNotNull(artStock);
    }

    @Test
    public void delete() {
        ArtStock artStock = ArtStockFactory.createArtStock("0002",
                "2HB Pencil", 2, "Pencils");
        ResponseEntity<ArtStock> postResponse = testRestTemplate.postForEntity(uRL + "/create",
                artStock, ArtStock.class);
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", "0002");
        testRestTemplate.delete(uRL + "/delete/" + parameters, ArtStock.class);
        try {
            ArtStock deleteArtStock = testRestTemplate.getForObject(uRL + "/read/0002", ArtStock.class);
            System.out.println(deleteArtStock);
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