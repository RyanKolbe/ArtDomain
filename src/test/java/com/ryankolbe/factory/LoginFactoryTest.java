package com.ryankolbe.factory;

import com.ryankolbe.model.Login;
import org.junit.Assert;
import org.junit.Test;

public class LoginFactoryTest {

    @Test
    public void createLogin() {
        Login login = LoginFactory.createLogin("Ryan", "Fabian");
        Assert.assertEquals("Ryan", login.getLoginName());
    }
}