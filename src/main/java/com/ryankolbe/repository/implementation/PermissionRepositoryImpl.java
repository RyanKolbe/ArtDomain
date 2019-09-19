/*
package com.ryankolbe.repository.implementation;

import com.ryankolbe.domain.Permission;
import com.ryankolbe.repository.PermissionRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("PermissionRepository")
public class PermissionRepositoryImpl implements PermissionRepository {
    private static PermissionRepositoryImpl permissionRepository = null;
    private Set<Permission> permissions;


    private PermissionRepositoryImpl() {
        this.permissions = new HashSet<>();
    }

    public static PermissionRepositoryImpl getPermissionRepository() {
        if (permissionRepository == null) permissionRepository = new PermissionRepositoryImpl();
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
            permissions.remove(permissionTemp);
            return create(permission);
        }
        return null;
    }

    @Override
    public void delete(String permissionId) {
        Permission permissionDelete = search(permissionId);
        if (permissionDelete != null) this.permissions.remove(permissionDelete);
    }

    private Permission search(final String permissionId) {
        for (Permission permissionSearch : this.permissions) {
            if (permissionSearch.getPermissionId().equals(permissionId))
                return permissionSearch;
        }
        return null;
    }

    @Override
    public Set<Permission> getAll() {
        return this.permissions;
    }
}*/
