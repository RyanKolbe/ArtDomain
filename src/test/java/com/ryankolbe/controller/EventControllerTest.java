package com.ryankolbe.controller;

import com.ryankolbe.domain.Event;
import com.ryankolbe.factory.EventFactory;
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
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class EventControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;
    private String uRL;

    @Before
    public void setUp() {
        Event event = EventFactory.createEvent("0001",
                "Art Of Pain", LocalDate.parse("2018-10-01"), LocalTime.parse("10:00:00"));
        uRL = "http://localhost:8080/event";
        ResponseEntity<Event> postResponse = testRestTemplate.withBasicAuth("admin", "admin")
                .postForEntity(uRL + "/create", event, Event.class);
        System.out.println(postResponse.toString());
    }

    @Test
    public void create() {
        Event event = EventFactory.createEvent("0002",
                "Human Nature Visualized", LocalDate.parse("2018-10-01"), LocalTime.parse("10:00:00"));
        ResponseEntity<Event> postResponse = testRestTemplate.withBasicAuth("admin", "admin")
                .postForEntity(uRL + "/create", event, Event.class);
        Assert.assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        System.out.println(postResponse.toString());
    }

    @Test
    public void update() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", "0002");
        Event event = EventFactory.createEvent("0003",
                "Death On Display", LocalDate.parse("2018-10-01"), LocalTime.parse("10:00:00"));
        testRestTemplate.put(uRL + "/update/", parameters, event);
    }

    @Test
    public void read() {
        Event event = testRestTemplate.getForObject(uRL + "/read/0001",
                Event.class);
        Assert.assertNotNull(event);
    }

    @Test
    public void delete() {
        Event event = EventFactory.createEvent("0002",
                "True Meanings Through Paint", LocalDate.parse("2018-10-01"), LocalTime.parse("10:00:00"));
        ResponseEntity<Event> postResponse = testRestTemplate.withBasicAuth("admin", "admin")
                .postForEntity(uRL + "/create", event, Event.class);
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", "0002");
        testRestTemplate.delete(uRL + "/delete/" + parameters, Event.class);
        try {
            Event deleteEvent = testRestTemplate.getForObject(uRL + "/read/0002", Event.class);
            System.out.println(deleteEvent);
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