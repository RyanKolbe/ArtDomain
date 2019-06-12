package com.ryankolbe.controller;

import com.ryankolbe.domain.ArtCourse;
import com.ryankolbe.factory.ArtCourseFactory;
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
public class ArtCourseControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;
    private String uRL;

    @Before
    public void setUp() {
        ArtCourse artCourse = ArtCourseFactory.createArtCourse("0001",
                "Painting 101", true);
        uRL = "http://localhost:8080/artCourse";
        ResponseEntity<ArtCourse> postResponse = testRestTemplate.postForEntity(uRL + "/create",
                artCourse, ArtCourse.class);
        System.out.println(postResponse.toString());
    }

    @Test
    public void create() {
        ArtCourse artCourse = ArtCourseFactory.createArtCourse("0002",
                "Pottery 101", true);
        ResponseEntity<ArtCourse> postResponse = testRestTemplate.postForEntity(uRL + "/create", artCourse,
                ArtCourse.class);
        Assert.assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        System.out.println(postResponse.toString());
    }

    @Test
    public void update() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", "0002");
        ArtCourse artCourse = ArtCourseFactory.createArtCourse("0003",
                "Sculptures 101", true);
        testRestTemplate.put(uRL + "/update/", parameters, artCourse);
    }

    @Test
    public void read() {
        ArtCourse artCourse = testRestTemplate.getForObject(uRL + "/read/0001",
                ArtCourse.class);
        Assert.assertNotNull(artCourse);
    }

    @Test
    public void delete() {
        ArtCourse artCourse = ArtCourseFactory.createArtCourse("0002",
                "Sketching 101", true);
        ResponseEntity<ArtCourse> postResponse = testRestTemplate.postForEntity(uRL + "/create",
                artCourse, ArtCourse.class);
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", "0002");
        testRestTemplate.delete(uRL + "/delete/" + parameters, ArtCourse.class);
        try {
            ArtCourse deleteArtCourse = testRestTemplate.getForObject(uRL + "/read/0002", ArtCourse.class);
            System.out.println(deleteArtCourse);
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