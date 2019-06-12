package com.ryankolbe.controller;

import com.ryankolbe.domain.Painting;
import com.ryankolbe.factory.PaintingFactory;
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
public class PaintingControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;
    private String uRL;

    @Before
    public void setUp() {
        Painting painting = PaintingFactory.createPainting("0001",
                "Flying Home", "Water Painting");
        uRL = "http://localhost:8080/painting";
        ResponseEntity<Painting> postResponse = testRestTemplate.postForEntity(uRL + "/create",
                painting, Painting.class);
        System.out.println(postResponse.toString());
    }

    @Test
    public void create() {
        Painting painting = PaintingFactory.createPainting("0002",
                "Vehicle Fuming", "Oil Painting");
        ResponseEntity<Painting> postResponse = testRestTemplate.postForEntity(uRL + "/create", painting,
                Painting.class);
        Assert.assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        System.out.println(postResponse.toString());
    }

    @Test
    public void update() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", "0002");
        Painting painting = PaintingFactory.createPainting("0003",
                "Shadows Hiding Grace", "Charcoal Drawing");
        testRestTemplate.put(uRL + "/update/", parameters, painting);
    }

    @Test
    public void read() {
        Painting painting = testRestTemplate.getForObject(uRL + "/read/0001",
                Painting.class);
        Assert.assertNotNull(painting);
    }

    @Test
    public void delete() {
        Painting painting = PaintingFactory.createPainting("0002",
                "Life On Display", "Pastel Painting");
        ResponseEntity<Painting> postResponse = testRestTemplate.postForEntity(uRL + "/create",
                painting, Painting.class);
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", "0002");
        testRestTemplate.delete(uRL + "/delete/" + parameters, Painting.class);
        try {
            Painting deletePainting = testRestTemplate.getForObject(uRL + "/read/0002", Painting.class);
            System.out.println(deletePainting);
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