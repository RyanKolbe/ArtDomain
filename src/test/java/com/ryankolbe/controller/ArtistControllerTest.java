package com.ryankolbe.controller;

import com.ryankolbe.domain.Artist;
import com.ryankolbe.factory.ArtistFactory;
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
public class ArtistControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;
    private String uRL;

    @Before
    public void setUp() {
        Artist artist = ArtistFactory.createArtist("0001",
                "Ryan", "Kolbe");
        uRL = "http://localhost:8080/artist";
        ResponseEntity<Artist> postResponse = testRestTemplate.withBasicAuth("admin", "admin")
                .postForEntity(uRL + "/create", artist, Artist.class);
        System.out.println(postResponse.toString());
    }

    @Test
    public void create() {
        Artist artist = ArtistFactory.createArtist("0002",
                "Deidre", "Van Vuuren");
        ResponseEntity<Artist> postResponse = testRestTemplate.withBasicAuth("admin", "admin")
                .postForEntity(uRL + "/create", artist, Artist.class);
        Assert.assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        System.out.println(postResponse.toString());
    }

    @Test
    public void update() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", "0002");
        Artist artist = ArtistFactory.createArtist("0003", "Rea", "Naidu");
        testRestTemplate.put(uRL + "/update/", parameters, artist);
    }

    @Test
    public void read() {
        Artist artist = testRestTemplate.getForObject(uRL + "/read/0001",
                Artist.class);
        Assert.assertNotNull(artist);
    }

    @Test
    public void delete() {
        Artist artist = ArtistFactory.createArtist("0002", "Deidre", "Kolbe");
        ResponseEntity<Artist> postResponse = testRestTemplate.withBasicAuth("admin", "admin")
                .postForEntity(uRL + "/create", artist, Artist.class);
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", "0002");
        testRestTemplate.delete(uRL + "/delete/" + parameters, Artist.class);
        try {
            Artist deleteArtist = testRestTemplate.getForObject(uRL + "/read/0002", Artist.class);
            System.out.println(deleteArtist);
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