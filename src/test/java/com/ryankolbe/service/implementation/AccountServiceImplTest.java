package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Account;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@Service("AccountServiceImp")
public class AccountServiceImplTest {
    private static AccountServiceImpl accountServiceImpl;
    private Account account;

    @Before
    public void setUp() {
    }

    @Test
    public void getAll() {
    }

    @Test
    public void create() {
    }

    @Test
    public void read() {
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }
}