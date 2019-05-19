package com.ryankolbe.repository;

import com.ryankolbe.domain.Services;

import java.util.Set;

public interface ServicesRepository extends IRepository<Services, String> {
    Set<Services> getAll();
}