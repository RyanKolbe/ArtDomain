package com.ryankolbe.controller;

import com.ryankolbe.domain.JobRole;
import com.ryankolbe.factory.JobRoleFactory;
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
public class JobRoleControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;
    private String uRL;

    @Before
    public void setUp() {
        JobRole jobRole = JobRoleFactory.createJobRole("0001",
                "Artist", 8500.00);
        uRL = "http://localhost:8080/jobRole";
        ResponseEntity<JobRole> postResponse = testRestTemplate.postForEntity(uRL + "/create",
                jobRole, JobRole.class);
        System.out.println(postResponse.toString());
    }

    @Test
    public void create() {
        JobRole jobRole = JobRoleFactory.createJobRole("0002",
                "Curator", 8000.00);
        ResponseEntity<JobRole> postResponse = testRestTemplate.postForEntity(uRL + "/create", jobRole,
                JobRole.class);
        Assert.assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        System.out.println(postResponse.toString());
    }

    @Test
    public void update() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", "0002");
        JobRole jobRole = JobRoleFactory.createJobRole("0003",
                "Art Restorer", 8400.00);
        testRestTemplate.put(uRL + "/update/", parameters, jobRole);
    }

    @Test
    public void read() {
        JobRole jobRole = testRestTemplate.getForObject(uRL + "/read/0001",
                JobRole.class);
        Assert.assertNotNull(jobRole);
    }

    @Test
    public void delete() {
        JobRole jobRole = JobRoleFactory.createJobRole("0002",
                "Driver", 6000.00);
        ResponseEntity<JobRole> postResponse = testRestTemplate.postForEntity(uRL + "/create",
                jobRole, JobRole.class);
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", "0002");
        testRestTemplate.delete(uRL + "/delete/" + parameters, JobRole.class);
        try {
            JobRole deleteJobRole = testRestTemplate.getForObject(uRL + "/read/0002", JobRole.class);
            System.out.println(deleteJobRole);
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