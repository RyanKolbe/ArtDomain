package com.ryankolbe.repository;

import com.ryankolbe.factory.PermissionFactory;
import com.ryankolbe.model.Permission;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashSet;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PermissionRepositoryImpTest {
    private static PermissionRepository permissionRepository = PermissionRepositoryImp.getPermissionRepository();
    private static Permission permission;
    private static Set<Permission> permissions = new HashSet<>();

    @BeforeClass
    public static void setUp() {
        permission = PermissionFactory.createPermission("End User", "System User",
                "User Roles", "User that utilizes the system resources");
    }

    @Test
    public void getPermissionRepository() {
        Assert.assertNotNull(permissionRepository);
    }

    @Test
    public void create() {
        permissions.add(permissionRepository.create(permission));
        Permission createPermission = permissionRepository.getAll().iterator().next();
        Assert.assertEquals(createPermission, permissionRepository.read(createPermission.getPermissionId()));
    }

    @Test
    public void read() {
        permissions.add(permissionRepository.create(permission));
        Permission readPermission = permissionRepository.read(permission.getPermissionId());
        Assert.assertEquals(readPermission, permissionRepository.read(readPermission.getPermissionId()));
    }

    @Test
    public void update() {
        permissions.add(permissionRepository.create(permission));
        String newPermissionRole = "System Controller";
        Permission permissionUpdate = new Permission.Builder()
                .copy(permission)
                .permissionRole(newPermissionRole)
                .build();
        Assert.assertEquals(permissionUpdate.getPermissionRole(), newPermissionRole);
    }

    @Test
    public void delete() {
        permissions.add(permissionRepository.create(permission));
        permissions.remove(permission);
        permissionRepository.delete(permission.getPermissionId());
        Assert.assertEquals(permissions.size(), permissionRepository.getAll().size());
    }

    @Test
    public void getAll() {
        Set<Permission> permissions = permissionRepository.getAll();
        Assert.assertEquals(permissions.size(), permissionRepository.getAll().size());
    }
}