package com.ryankolbe.factory;

import com.ryankolbe.domain.Permission;
import org.junit.Assert;
import org.junit.Test;

public class PermissionFactoryTest {

    @Test
    public void createPermission() {
        Permission permission = PermissionFactory.createPermission("0001",
                "Administrator", "System Administrator");
        Assert.assertEquals("Administrator", permission.getPermissionRole());
    }
}