package com.ryankolbe.controller;

import com.ryankolbe.domain.Exhibition;
import com.ryankolbe.factory.ExhibitionFactory;
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

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class ExhibitionControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;
    private String uRL;

    @Before
    public void setUp() {
        Exhibition exhibition = ExhibitionFactory.createExhibition("0001",
                "Paint The First Stones", LocalDate.parse("2018-05-16"), LocalDate.parse("2018-05-18"));
        uRL = "http://localhost:8080/exhibition";
        ResponseEntity<Exhibition> postResponse = testRestTemplate.withBasicAuth("admin", "admin")
                .postForEntity(uRL + "/create", exhibition, Exhibition.class);
        System.out.println(postResponse.toString());
    }

    @Test
    public void create() {
        Exhibition exhibition = ExhibitionFactory.createExhibition("0002",
                "Truth Through Material", LocalDate.parse("2018-05-16"), LocalDate.parse("2018-05-18"));
        ResponseEntity<Exhibition> postResponse = testRestTemplate.withBasicAuth("admin", "admin")
                .postForEntity(uRL + "/create", exhibition, Exhibition.class);
        Assert.assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        System.out.println(postResponse.toString());
    }

    @Test
    public void update() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", "0002");
        Exhibition exhibition = ExhibitionFactory.createExhibition("0003",
                "Revealing Time Through Art", LocalDate.parse("2018-05-16"), LocalDate.parse("2018-05-18"));
        testRestTemplate.put(uRL + "/update/", parameters, exhibition);
    }

    @Test
    public void read() {
        Exhibition exhibition = testRestTemplate.getForObject(uRL + "/read/0001",
                Exhibition.class);
        Assert.assertNotNull(exhibition);
    }

    @Test
    public void delete() {
        Exhibition exhibition = ExhibitionFactory.createExhibition("0002",
                "Addressing The Cultural Divide Through Canvas",
                LocalDate.parse("2018-05-16"), LocalDate.parse("2018-05-18"));
        ResponseEntity<Exhibition> postResponse = testRestTemplate.withBasicAuth("admin", "admin")
                .postForEntity(uRL + "/create", exhibition, Exhibition.class);
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", "0002");
        testRestTemplate.delete(uRL + "/delete/" + parameters, Exhibition.class);
        try {
            Exhibition deleteExhibition = testRestTemplate.getForObject(uRL + "/read/0002", Exhibition.class);
            System.out.println(deleteExhibition);
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