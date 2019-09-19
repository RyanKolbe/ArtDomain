package com.ryankolbe.service;

import com.ryankolbe.domain.Admin;

import java.util.List;

public interface AdminService extends IService<Admin, String> {
    List<Admin> getAll();
}