package com.ryankolbe.factory;

import com.ryankolbe.domain.Permission;

public class PermissionFactory {

    public static Permission createPermission(String permissionId, String permissionRole, String permissionTitle) {
        return new Permission.Builder()
                .permissionId(permissionId)
                .permissionRole(permissionRole)
                .permissionTitle(permissionTitle)
                .build();
    }
}