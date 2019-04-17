package com.ryankolbe.factory;

import com.ryankolbe.model.User;
import org.junit.Assert;
import org.junit.Test;

public class UserFactoryTest {

    @Test
    public void createUser() {
        User user = UserFactory.createUser("Lindi", "lindiv@vectorlog.com",
                "Artist", "8301010101010");
        Assert.assertNotNull(user);
    }
}