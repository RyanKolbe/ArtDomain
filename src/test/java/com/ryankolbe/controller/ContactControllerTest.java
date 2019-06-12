package com.ryankolbe.controller;

import com.ryankolbe.domain.Contact;
import com.ryankolbe.factory.ContactFactory;
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
public class ContactControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;
    private String uRL;

    @Before
    public void setUp() {
        Contact contact = ContactFactory.createContact("0001",
                "1234.@email.com", "0729597000", "0219597000");
        uRL = "http://localhost:8080/contact";
        ResponseEntity<Contact> postResponse = testRestTemplate.postForEntity(uRL + "/create",
                contact, Contact.class);
        System.out.println(postResponse.toString());
    }

    @Test
    public void create() {
        Contact contact = ContactFactory.createContact("0002",
                "2465@email.com", "0761459875", "0219487654");
        ResponseEntity<Contact> postResponse = testRestTemplate.postForEntity(uRL + "/create", contact,
                Contact.class);
        Assert.assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        System.out.println(postResponse.toString());
    }

    @Test
    public void update() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", "0002");
        Contact contact = ContactFactory.createContact("0003","4658@email.com",
                "0856497652", "0115697846");
        testRestTemplate.put(uRL + "/update/", parameters, contact);
    }

    @Test
    public void read() {
        Contact contact = testRestTemplate.getForObject(uRL + "/read/0001",
                Contact.class);
        Assert.assertNotNull(contact);
    }

    @Test
    public void delete() {
        Contact contact = ContactFactory.createContact("0002",
                "2465@email.com", "0862654987", "0412657985");
        ResponseEntity<Contact> postResponse = testRestTemplate.postForEntity(uRL + "/create",
                contact, Contact.class);
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", "0002");
        testRestTemplate.delete(uRL + "/delete/" + parameters, Contact.class);
        try {
            Contact deleteContact = testRestTemplate.getForObject(uRL + "/read/0002", Contact.class);
            System.out.println(deleteContact);
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