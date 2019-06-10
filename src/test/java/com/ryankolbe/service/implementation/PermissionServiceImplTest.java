package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Permission;
import com.ryankolbe.factory.PermissionFactory;
import com.ryankolbe.service.PermissionService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PermissionServiceImplTest {
    @Autowired
    @Qualifier("PermissionServiceImpl")
    private PermissionService permissionService;
    private Permission permission;
    private Set<Permission> permissions = new HashSet<>();

    @Before
    public void setUp() {
        permission = permissionService.create(PermissionFactory.createPermission("0001",
                "System Administrator", "Administrators"));
    }

    @Test
    public void create() {
        Permission createPermission = permissionService.create(PermissionFactory.createPermission("0002",
                "HR End User", "End Users"));
        permissions.add(createPermission);
        Assert.assertEquals(createPermission, permissionService.read(createPermission.getPermissionId()));
    }

    @Test
    public void read() {
        Permission readPermission = permissionService.read(permission.getPermissionId());
        Assert.assertEquals(readPermission, permissionService.read(readPermission.getPermissionId()));
    }

    @Test
    public void update() {
        String newPermissionRole = "Visitor";
        Permission updatePermission = permissionService.update(new Permission.Builder().copy(permission)
                .permissionRole(newPermissionRole).build());
        permissions.add(updatePermission);
        Assert.assertEquals(updatePermission, permissionService.read(updatePermission.getPermissionId()));
    }

    @Test
    public void delete() {
        permissions.addAll(permissionService.getAll());
        Permission deletePermission = permissionService.create(PermissionFactory.createPermission("0054",
                "Network Administrator", "Administrator"));
        permissions.add(deletePermission);
        permissions.remove(deletePermission);
        permissionService.delete(deletePermission.getPermissionId());
        Assert.assertEquals(permissions.size(), permissionService.getAll().size());
    }

    @Test
    public void getAll() {
        Set<Permission> permissionSet = permissionService.getAll();
        Assert.assertEquals(permissionSet.size(), permissionService.getAll().size());
    }
}