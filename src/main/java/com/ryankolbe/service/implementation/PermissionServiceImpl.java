package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Permission;
import com.ryankolbe.repository.PermissionRepository;
import com.ryankolbe.repository.implementation.PermissionRepositoryImpl;
import com.ryankolbe.service.PermissionService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("PermissionServiceImpl")
public class PermissionServiceImpl implements PermissionService {
    private final PermissionRepository permissionRepository;

    private PermissionServiceImpl() {
        this.permissionRepository = PermissionRepositoryImpl.getPermissionRepository();
    }
    @Override
    public Permission create(Permission permission) {
        return this.permissionRepository.create(permission);
    }

    @Override
    public Permission read(String permissionId) {
        return this.permissionRepository.read(permissionId);
    }

    @Override
    public Permission update(Permission permission) {
        return this.permissionRepository.update(permission);
    }

    @Override
    public void delete(String permissionId) {
        this.permissionRepository.delete(permissionId);
    }

    @Override
    public Set<Permission> getAll() {
        return this.permissionRepository.getAll();
    }

}
