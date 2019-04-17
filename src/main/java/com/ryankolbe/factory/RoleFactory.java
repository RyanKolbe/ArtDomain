package com.ryankolbe.factory;

import com.ryankolbe.model.Role;
import com.ryankolbe.util.Misc;

public class RoleFactory {

    public static Role createRole(String roleTitle, String roleDescription) {
        return new Role.Builder()
                .roleId(Misc.generateId())
                .roleTitle(roleTitle)
                .roleDescription(roleDescription)
                .build();
    }
}