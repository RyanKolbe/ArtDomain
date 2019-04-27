package com.ryankolbe.factory;

import com.ryankolbe.model.User;
import org.junit.Assert;
import org.junit.Test;

public class UserFactoryTest {

    @Test
    public void createUser() {
        User user = UserFactory.createUser();
        Assert.assertNotNull(user);

    }
}