package com.ryankolbe.service;

import com.ryankolbe.domain.Login;

import java.util.Set;

public interface LoginService extends IService<Login, String> {
    Set<Login> getAll();
}