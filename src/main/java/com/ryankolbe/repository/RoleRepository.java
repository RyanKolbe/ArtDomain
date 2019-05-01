package com.ryankolbe.repository;

import com.ryankolbe.model.Role;

import java.util.Set;

public interface RoleRepository extends IRepository<Role, String> {
    Set<Role> getAll();
}
