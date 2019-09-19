package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Admin;
import com.ryankolbe.repository.AdminRepository;
import com.ryankolbe.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("AdminServiceImpl")
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin create(Admin admin) {
        return this.adminRepository.save(admin);
    }

    @Override
    public Admin read(String adminId) {
        Optional<Admin> byId = this.adminRepository.findById(adminId);
        return byId.orElseThrow(RuntimeException::new);
    }

    @Override
    public Admin update(Admin admin) {
        return this.adminRepository.save(admin);
    }

    @Override
    public void delete(String adminId) {
        this.adminRepository.deleteById(adminId);
    }

    @Override
    public List<Admin> getAll() {
        return this.adminRepository.findAll();
    }
}