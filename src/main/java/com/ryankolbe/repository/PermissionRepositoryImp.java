package com.ryankolbe.repository;

import com.ryankolbe.model.Permission;

import java.util.HashSet;
import java.util.Set;

public class PermissionRepositoryImp implements PermissionRepository {
    private static PermissionRepository permissionRepository = null;
    private Set<Permission> permissions;

    private PermissionRepositoryImp() {
        this.permissions = new HashSet<>();
    }

    public static PermissionRepository getPermissionRepository() {
        if (permissionRepository == null) permissionRepository = new PermissionRepositoryImp();
        return permissionRepository;
    }

    @Override
    public Permission create(Permission permission) {
        this.permissions.add(permission);
        return permission;
    }

    @Override
    public Permission read(String permissionId) {
        return search(permissionId);
    }

    @Override
    public Permission update(Permission permission) {
        Permission permissionTemp = search(permission.getPermissionId());
        if (permissionTemp != null) {
            return new Permission.Builder()
                    .copy(permissionTemp)
                    .build();
        }
        return null;
    }

    @Override
    public void delete(String permissionId) {
        Permission deletePermission = search(permissionId);
        if (deletePermission != null)
            this.permissions.remove(deletePermission);
    }

    @Override
    public Set<Permission> getAll() {
        return this.permissions;
    }

    public Permission search(final String permissionId) {
        for (Permission permissionSearch : this.permissions) {
            if (permissionSearch.getPermissionId().equals(permissionId))
                return permissionSearch;
        }
        return null;
    }
}