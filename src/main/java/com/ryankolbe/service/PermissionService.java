package com.ryankolbe.service;

import com.ryankolbe.domain.Permission;

import java.util.List;

public interface PermissionService extends IService<Permission, String> {
    List<Permission> getAll();
}