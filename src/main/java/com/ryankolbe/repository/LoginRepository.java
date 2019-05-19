package com.ryankolbe.repository;

import com.ryankolbe.domain.Login;

import java.util.Set;

public interface LoginRepository extends IRepository<Login, String> {
    Set<Login> getAll();
}
