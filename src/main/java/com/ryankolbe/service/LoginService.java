package com.ryankolbe.service;

import com.ryankolbe.domain.Login;

import java.util.List;

public interface LoginService extends IService<Login, String> {
    List<Login> getAll();
}