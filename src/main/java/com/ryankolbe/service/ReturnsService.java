package com.ryankolbe.service;

import com.ryankolbe.domain.Returns;

import java.util.Set;

public interface ReturnsService extends IService<Returns, String> {
    Set<Returns> getAll();
}