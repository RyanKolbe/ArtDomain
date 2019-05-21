package com.ryankolbe.service;

import com.ryankolbe.domain.Permission;

import java.util.Set;

public interface PermissionService extends IService<Permission, String> {
    Set<Permission> getAll();
}