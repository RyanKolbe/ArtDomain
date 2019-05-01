package com.ryankolbe.repository.implementation;

import com.ryankolbe.model.Role;
import com.ryankolbe.repository.RoleRepository;

import java.util.HashSet;
import java.util.Set;

public class RoleRepositoryImpl implements RoleRepository {
    private static RoleRepository roleRepository = null;
    private Set<Role> roles;

    private RoleRepositoryImpl() {
        this.roles = new HashSet<>();
    }

    public static RoleRepository getRoleRepository() {
        if (roleRepository == null) roleRepository = new RoleRepositoryImpl();
        return roleRepository;
    }

    @Override
    public Role create(Role role) {
        this.roles.add(role);
        return role;
    }

    @Override
    public Role read(String roleId) {
        return search(roleId);
    }

    @Override
    public Role update(Role role) {
        Role roleTemp = search(role.getRoleId());
        if (roleTemp != null) {
            Role roleNew = new Role.Builder()
                    .build();
            return create(roleNew);
        }
        return null;
    }

    @Override
    public void delete(String roleId) {
        Role role = search(roleId);
        if (role != null) this.roles.remove(role);
    }

    public Role search(final String roleId) {
        for (Role roleSearch : this.roles) {
            if (roleSearch.getRoleId().equals(roleId))
                return roleSearch;
        }
        return null;
    }

    @Override
    public Set<Role> getAll() {
        return this.roles;
    }
}
