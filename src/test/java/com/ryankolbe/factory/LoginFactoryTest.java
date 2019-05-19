package com.ryankolbe.factory;

import com.ryankolbe.domain.Login;
import org.junit.Assert;
import org.junit.Test;

public class LoginFactoryTest {

    @Test
    public void createLogin() {
        Login login = LoginFactory.createLogin("0001", "Ryan", "Fabian");
        Assert.assertEquals("Ryan", login.getLoginName());
    }
}