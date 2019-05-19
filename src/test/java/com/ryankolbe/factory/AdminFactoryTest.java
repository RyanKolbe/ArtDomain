package com.ryankolbe.factory;

import com.ryankolbe.domain.Admin;
import org.junit.Assert;
import org.junit.Test;

public class AdminFactoryTest {

    @Test
    public void createAdmin() {
        Admin admin = AdminFactory.createAdmin("0001", "Ryan", "Pass.123");
        Assert.assertEquals("Ryan", admin.getAdminLogin());
    }
}