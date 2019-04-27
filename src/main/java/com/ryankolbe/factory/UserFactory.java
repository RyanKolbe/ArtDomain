package com.ryankolbe.factory;

import com.ryankolbe.model.User;
import com.ryankolbe.util.Misc;

public class UserFactory {

    public static User createUser() {
        return new User.Builder()
                .userId(Misc.generateId())
                .build();
    }
}