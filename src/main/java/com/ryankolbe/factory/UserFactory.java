package com.ryankolbe.factory;

import com.ryankolbe.model.*;
import com.ryankolbe.util.Misc;

public class UserFactory {
    public static User createUser(Login login, Role role, Permission permission, Name name, Contact contact) {
        return new User.Builder()
                .userId(Misc.generateId())
                .login(login)
                .role(role)
                .permission(permission)
                .name(name)
                .contact(contact)
                .build();
    }
}