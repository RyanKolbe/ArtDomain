package com.ryankolbe.repository.implementation;

import com.ryankolbe.domain.Admin;
import com.ryankolbe.repository.AdminRepository;

import java.util.HashSet;
import java.util.Set;

public class AdminRepositoryImpl implements AdminRepository {
    private static AdminRepository adminRepository = null;
    private Set<Admin> admins;


    private AdminRepositoryImpl() {
        this.admins = new HashSet<>();
    }

    public static AdminRepository getAdminRepository() {
        if (adminRepository == null) adminRepository = new AdminRepositoryImpl();
        return adminRepository;
    }

    @Override
    public Admin create(Admin admin) {
        this.admins.add(admin);
        return admin;
    }

    @Override
    public Admin read(String adminId) {
        return search(adminId);
    }

    @Override
    public Admin update(Admin admin) {
        Admin adminTemp = search(admin.getAdminId());
        if (adminTemp == null) {
            Admin adminNew = new Admin.Builder()
                    .copy(adminTemp)
                    .build();
            return create(adminNew);
        }
        return null;
    }

    @Override
    public void delete(String adminId) {
        Admin adminDelete = search(adminId);
        if (adminDelete != null) this.admins.remove(adminDelete);
    }

    private Admin search(final String adminId) {
        for (Admin adminSearch : this.admins) {
            if (adminSearch.getAdminId().equals(adminId))
                return adminSearch;
        }
        return null;
    }

    @Override
    public Set<Admin> getAll() {
        return this.admins;
    }
}
