package com.ryankolbe.repository.implementation;

import com.ryankolbe.domain.Admin;
import com.ryankolbe.factory.AdminFactory;
import com.ryankolbe.repository.AdminRepository;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashSet;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdminRepositoryImplTest {
    private static AdminRepository adminRepository = AdminRepositoryImpl.getAdminRepository();
    private static Admin admin;
    private static Set<Admin> admins = new HashSet<>();

    @BeforeClass
    public static void setUp() {
        admin = AdminFactory.createAdmin("0001","ABCD","Pass.123");
        admins.add(adminRepository.create(admin));
    }

    @Test
    public void getAdminRepository() {
        Assert.assertNotNull(adminRepository);
    }

    @Test
    public void create() {
        Admin newAdmin = AdminFactory.createAdmin("0002", "WXYZ","Pass.987");
        admins.add(adminRepository.create(newAdmin));
        Assert.assertEquals(newAdmin.getAdminId(), adminRepository.read(newAdmin.getAdminId()).getAdminId());
    }

    @Test
    public void read() {
        Admin readAdmin = adminRepository.getAll().iterator().next();
        Assert.assertEquals(readAdmin, adminRepository.read(readAdmin.getAdminId()));
    }

    @Test
    public void update() {
        String newAdminLogin = "EFGH";
        Admin updateAdmin = new Admin.Builder().copy(admin).adminLogin(newAdminLogin).build();
        admins.add(adminRepository.update(updateAdmin));
        Assert.assertEquals(newAdminLogin, adminRepository.read(updateAdmin.getAdminId()).getAdminLogin());
    }

    @Test
    public void delete() {
        Admin deleteAdmin = AdminFactory.createAdmin("0003", "Dude", "Pass546");
        admins.add(adminRepository.create(deleteAdmin));
        adminRepository.delete(deleteAdmin.getAdminId());
        admins.remove(deleteAdmin);
        Assert.assertEquals(admins.size(), adminRepository.getAll().size());
    }

    @Test
    public void getAll() {
        Set<Admin> adminSet = adminRepository.getAll();
        Assert.assertEquals(adminSet, adminRepository.getAll());
    }
}