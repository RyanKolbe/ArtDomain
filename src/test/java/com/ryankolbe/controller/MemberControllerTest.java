package com.ryankolbe.controller;

import com.ryankolbe.domain.Member;
import com.ryankolbe.factory.MemberFactory;
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
public class MemberControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;
    private String uRL;

    @Before
    public void setUp() {
        Member member = MemberFactory.createMember("0001",
                "Deidre", "Gold");
        uRL = "http://localhost:8080/member";
        ResponseEntity<Member> postResponse = testRestTemplate.withBasicAuth("admin", "admin")
                .postForEntity(uRL + "/create", member, Member.class);
        System.out.println(postResponse.toString());
    }

    @Test
    public void create() {
        Member member = MemberFactory.createMember("0002",
                "Deidre", "Silver");
        ResponseEntity<Member> postResponse = testRestTemplate.withBasicAuth("admin", "admin")
                .postForEntity(uRL + "/create", member, Member.class);
        Assert.assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        System.out.println(postResponse.toString());
    }

    @Test
    public void update() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", "0002");
        Member member = MemberFactory.createMember("0003",
                 "Rea", "Platinum");
        testRestTemplate.put(uRL + "/update/", parameters, member);
    }

    @Test
    public void read() {
        Member member = testRestTemplate.getForObject(uRL + "/read/0001",
                Member.class);
        Assert.assertNotNull(member);
    }

    @Test
    public void delete() {
        Member member = MemberFactory.createMember("0002",
                 "Deidre", "Bronze");
        ResponseEntity<Member> postResponse = testRestTemplate.withBasicAuth("admin", "admin")
                .postForEntity(uRL + "/create", member, Member.class);
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", "0002");
        testRestTemplate.delete(uRL + "/delete/" + parameters, Member.class);
        try {
            Member deleteMember = testRestTemplate.getForObject(uRL + "/read/0002", Member.class);
            System.out.println(deleteMember);
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