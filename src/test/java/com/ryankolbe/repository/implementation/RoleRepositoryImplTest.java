package com.ryankolbe.repository.implementation;

import com.ryankolbe.factory.RoleFactory;
import com.ryankolbe.model.Role;
import com.ryankolbe.repository.RoleRepository;
import com.ryankolbe.util.Misc;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashSet;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RoleRepositoryImplTest {

    private static RoleRepository roleRepository = RoleRepositoryImpl.getRoleRepository();
    private static Role role;
    private static Set<Role> roles = new HashSet<>();

    @BeforeClass
    public static void setUp() {
        role = RoleFactory.createRole("Administrator", "Administers system");
        roles.add(roleRepository.create(role));
    }

    @Test
    public void create() {
        role = RoleFactory.createRole("End User", "Utilizes system");
        roles.add(roleRepository.create(role));
        Assert.assertEquals(roles.size(), roleRepository.getAll().size());
    }

    @Test
    public void read() {
        String roleId = roleRepository.getAll().stream().findFirst().get().getRoleId();
        String roleIdCheck = roleRepository.read(roleId).getRoleId();
        Assert.assertEquals(roleId, roleIdCheck);
    }

    @Test
    public void update() {
        String newRoleId = Misc.generateId();
        Role newRole = new Role.Builder().copy(role).roleId(newRoleId).build();
        Assert.assertEquals(newRoleId, newRole.getRoleId());
    }

    @Test
    public void delete() {
        roleRepository.delete(role.getRoleId());
        Assert.assertEquals(1, roleRepository.getAll().size());
    }
}