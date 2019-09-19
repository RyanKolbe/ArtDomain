/*
package com.ryankolbe.repository.implementation;

import com.ryankolbe.domain.Permission;
import com.ryankolbe.factory.PermissionFactory;
import com.ryankolbe.repository.PermissionRepository;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashSet;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PermissionRepositoryImplTest {
    private static PermissionRepository permissionRepository = PermissionRepositoryImpl.getPermissionRepository();
    private static Permission permission;
    private static Set<Permission> permissions = new HashSet<>();

    @BeforeClass
    public static void setUp() {
        permission = PermissionFactory.createPermission("0354", "Admin End User",
                "End User");
        permissions.add(permissionRepository.create(permission));
    }

    @Test
    public void getPermissionRepository() {
        Assert.assertNotNull(permissionRepository);
    }

    @Test
    public void create() {
        Permission createPermission = PermissionFactory.createPermission("0012", "Admin",
                "System Administrator");
        permissions.add(permissionRepository.create(createPermission));
        Assert.assertEquals(createPermission, permissionRepository.read(createPermission.getPermissionId()));
    }

    @Test
    public void read() {
        Permission readPermission = permissionRepository.read(permission.getPermissionId());
        Assert.assertEquals(readPermission, permissionRepository.read(readPermission.getPermissionId()));
    }

    @Test
    public void update() {
        String newPermissionRole = "Visitor";
        Permission updatePermission = new Permission.Builder().copy(permission).permissionRole(newPermissionRole).build();
        permissions.add(permissionRepository.update(updatePermission));
        Assert.assertEquals(updatePermission, permissionRepository.read(updatePermission.getPermissionId()));
    }

    @Test
    public void delete() {
        Permission deletePermission = PermissionFactory.createPermission("0946", "HR End User",
                "End User");
        permissions.add(permissionRepository.create(deletePermission));
        permissions.remove(deletePermission);
        permissionRepository.delete(deletePermission.getPermissionId());
        Assert.assertEquals(permissions.size(), permissionRepository.getAll().size());
    }

    @Test
    public void getAll() {
        Set<Permission> permissionSet = permissionRepository.getAll();
        Assert.assertEquals(permissionSet.size(), permissionRepository.getAll().size());
    }
}*/
