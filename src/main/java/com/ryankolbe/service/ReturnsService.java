package com.ryankolbe.service;

import com.ryankolbe.domain.Returns;

import java.util.List;

public interface ReturnsService extends IService<Returns, String> {
    List<Returns> getAll();
}