package com.ryankolbe.factory;

import com.ryankolbe.model.Permission;
import com.ryankolbe.util.Misc;

public class PermissionFactory {

    public static Permission createPermission(String permissionRole, String permissionTitle,
                                              String permissionModule, String permissionDescription) {
        return new Permission.Builder()
                .id(Misc.generateId())
                .permissionRole(permissionRole)
                .permissionTitle(permissionTitle)
                .permissionModule(permissionModule)
                .permissionDescription(permissionDescription)
                .build();
    }
}