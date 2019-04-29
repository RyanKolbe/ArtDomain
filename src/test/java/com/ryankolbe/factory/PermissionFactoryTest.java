package com.ryankolbe.factory;

import com.ryankolbe.model.Permission;
import org.junit.Assert;
import org.junit.Test;

public class PermissionFactoryTest {

    @Test
    public void createPermission() {
        Permission permission = PermissionFactory.createPermission("Admin", "Administrator",
                "Login Control", "Administrator has full control");
        Assert.assertEquals("Admin", permission.getPermissionRole());
    }
}