package com.ryankolbe.repository;

import com.ryankolbe.domain.Admin;

import java.util.Set;

public interface AdminRepository extends IRepository<Admin, String> {
    Set<Admin> getAll();
}
