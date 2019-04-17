package com.ryankolbe.factory;

import com.ryankolbe.model.User;
import com.ryankolbe.util.Misc;

public class UserFactory {

    public static User createUser(String userName, String userEmail, String userRole, String dob) {
        return new User.Builder()
                .id(Misc.generateId())
                .userName(userName)
                .userEmail(userEmail)
                .userRole(userRole)
                .dob(dob)
                .build();
    }
}