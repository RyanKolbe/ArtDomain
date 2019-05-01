package com.ryankolbe.repository;

import com.ryankolbe.model.Role;
import com.ryankolbe.model.User;

import java.util.Set;

public interface UserRepository extends IRepository<User, String> {
    Set<Role> getAll();
}
