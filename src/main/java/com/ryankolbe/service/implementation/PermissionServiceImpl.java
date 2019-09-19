package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Permission;
import com.ryankolbe.repository.PermissionRepository;
import com.ryankolbe.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("PermissionServiceImpl")
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public Permission create(Permission permission) {
        return this.permissionRepository.save(permission);
    }

    @Override
    public Permission read(String permissionId) {
        Optional<Permission> byId = this.permissionRepository.findById(permissionId);
        return byId.orElseThrow(RuntimeException::new);
    }

    @Override
    public Permission update(Permission permission) {
        return this.permissionRepository.save(permission);
    }

    @Override
    public void delete(String permissionId) {
        this.permissionRepository.deleteById(permissionId);
    }

    @Override
    public List<Permission> getAll() {
        return this.permissionRepository.findAll();
    }
}