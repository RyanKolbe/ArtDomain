package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Admin;
import com.ryankolbe.repository.AdminRepository;
import com.ryankolbe.repository.implementation.AdminRepositoryImpl;
import com.ryankolbe.service.AdminService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("AdminServiceImpl")
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;

    private AdminServiceImpl() {
        this.adminRepository = AdminRepositoryImpl.getAdminRepository();
    }

    @Override
    public Set<Admin> getAll() {
        return this.adminRepository.getAll();
    }

    @Override
    public Admin create(Admin admin) {
        return this.adminRepository.create(admin);
    }

    @Override
    public Admin read(String adminId) {
        return this.adminRepository.read(adminId);
    }

    @Override
    public Admin update(Admin admin) {
        return this.adminRepository.update(admin);
    }

    @Override
    public void delete(String adminId) {
        this.adminRepository.delete(adminId);
    }
}