package com.ryankolbe.factory;

import com.ryankolbe.model.Role;
import org.junit.Assert;
import org.junit.Test;

public class RoleFactoryTest {

    @Test
    public void createRole() {
        Role role = RoleFactory.createRole("Artist", "Painter");
        Assert.assertNotNull(role);
    }
}