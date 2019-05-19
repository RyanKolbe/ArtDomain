package com.ryankolbe.repository;

import com.ryankolbe.domain.Permission;

import java.util.Set;

public interface PermissionRepository extends IRepository<Permission, String> {
    Set<Permission> getAll();
}