package com.ryankolbe.repository;

import com.ryankolbe.domain.Returns;

import java.util.Set;

public interface ReturnsRepository extends IRepository<Returns, String> {
    Set<Returns> getAll();
}