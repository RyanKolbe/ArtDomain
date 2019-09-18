package com.ryankolbe.controller;

import com.ryankolbe.domain.Permission;
import com.ryankolbe.factory.PermissionFactory;
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
public class PermissionControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;
    private String uRL;

    @Before
    public void setUp() {
        Permission permission = PermissionFactory.createPermission("0001",
                "End User", "Admin End User");
        uRL = "http://localhost:8080/permission";
        ResponseEntity<Permission> postResponse = testRestTemplate.withBasicAuth("admin", "admin")
                .postForEntity(uRL + "/create", permission, Permission.class);
        System.out.println(postResponse.toString());
    }

    @Test
    public void create() {
        Permission permission = PermissionFactory.createPermission("0002",
                "End User", "Database End User");
        ResponseEntity<Permission> postResponse = testRestTemplate.withBasicAuth("admin", "admin")
                .postForEntity(uRL + "/create", permission, Permission.class);
        Assert.assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        System.out.println(postResponse.toString());
    }

    @Test
    public void update() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", "0002");
        Permission permission = PermissionFactory.createPermission("0003",
                "Administrator", "System Administrator");
        testRestTemplate.put(uRL + "/update/", parameters, permission);
    }

    @Test
    public void read() {
        Permission permission = testRestTemplate.getForObject(uRL + "/read/0001",
                Permission.class);
        Assert.assertNotNull(permission);
    }

    @Test
    public void delete() {
        Permission permission = PermissionFactory.createPermission("0002",
                "Administrator", "Network Administrator");
        ResponseEntity<Permission> postResponse = testRestTemplate.withBasicAuth("admin", "admin")
                .postForEntity(uRL + "/create", permission, Permission.class);
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", "0002");
        testRestTemplate.delete(uRL + "/delete/" + parameters, Permission.class);
        try {
            Permission deletePermission = testRestTemplate.getForObject(uRL + "/read/0002", Permission.class);
            System.out.println(deletePermission);
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