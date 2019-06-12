package com.ryankolbe.controller;

import com.ryankolbe.domain.Admin;
import com.ryankolbe.factory.AdminFactory;
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
public class AdminControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;
    private String uRL;

    @Before
    public void setUp() {
        Admin admin = AdminFactory.createAdmin("0001","1234", "Ryan");
        uRL = "http://localhost:8080/admin";
        ResponseEntity<Admin> postResponse = testRestTemplate.postForEntity(uRL + "/create",
                admin, Admin.class);
        System.out.println(postResponse.toString());
    }

    @Test
    public void create() {
        Admin admin = AdminFactory.createAdmin("0002","2465", "Deidre");
        ResponseEntity<Admin> postResponse = testRestTemplate.postForEntity(uRL + "/create", admin,
                Admin.class);
        Assert.assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        System.out.println(postResponse.toString());
    }

    @Test
    public void update() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", "0002");
        Admin admin = AdminFactory.createAdmin("0003","4658", "Rea");
        testRestTemplate.put(uRL + "/update/", parameters, admin);
    }

    @Test
    public void read() {
        Admin admin = testRestTemplate.getForObject(uRL + "/read/0001",
                Admin.class);
        Assert.assertNotNull(admin);
    }

    @Test
    public void delete() {
        Admin admin = AdminFactory.createAdmin("0002","2465", "Deidre");
        ResponseEntity<Admin> postResponse = testRestTemplate.postForEntity(uRL + "/create",
                admin, Admin.class);
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", "0002");
        testRestTemplate.delete(uRL + "/delete/" + parameters, Admin.class);
        try {
            Admin deleteAdmin = testRestTemplate.getForObject(uRL + "/read/0002", Admin.class);
            System.out.println(deleteAdmin);
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