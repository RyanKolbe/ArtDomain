package com.ryankolbe.controller;

import com.ryankolbe.domain.Gallery;
import com.ryankolbe.factory.GalleryFactory;
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
public class GalleryControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;
    private String uRL;

    @Before
    public void setUp() {
        Gallery gallery = GalleryFactory.createGallery("0001",
                "Artscapes", "700");
        uRL = "http://localhost:8080/gallery";
        ResponseEntity<Gallery> postResponse = testRestTemplate.withBasicAuth("admin", "admin")
                .postForEntity(uRL + "/create", gallery, Gallery.class);
        System.out.println(postResponse.toString());
    }

    @Test
    public void create() {
        Gallery gallery = GalleryFactory.createGallery("0002",
                "Returning Culture", "654");
        ResponseEntity<Gallery> postResponse = testRestTemplate.withBasicAuth("admin", "admin")
                .postForEntity(uRL + "/create", gallery, Gallery.class);
        Assert.assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        System.out.println(postResponse.toString());
    }

    @Test
    public void update() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", "0002");
        Gallery gallery = GalleryFactory.createGallery("0003",
                "Art Warehouse", "468");
        testRestTemplate.put(uRL + "/update/", parameters, gallery);
    }

    @Test
    public void read() {
        Gallery gallery = testRestTemplate.getForObject(uRL + "/read/0001",
                Gallery.class);
        Assert.assertNotNull(gallery);
    }

    @Test
    public void delete() {
        Gallery gallery = GalleryFactory.createGallery("0002",
                "Ryan and Deidre Art Studio", "687");
        ResponseEntity<Gallery> postResponse = testRestTemplate.withBasicAuth("admin", "admin")
                .postForEntity(uRL + "/create", gallery, Gallery.class);
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", "0002");
        testRestTemplate.delete(uRL + "/delete/" + parameters, Gallery.class);
        try {
            Gallery deleteGallery = testRestTemplate.getForObject(uRL + "/read/0002", Gallery.class);
            System.out.println(deleteGallery);
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