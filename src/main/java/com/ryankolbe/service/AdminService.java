package com.ryankolbe.service;

import com.ryankolbe.domain.Admin;

import java.util.Set;

public interface AdminService extends IService<Admin, String> {
    Set<Admin> getAll();
}