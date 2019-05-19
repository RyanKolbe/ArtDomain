package com.ryankolbe.repository;

import com.ryankolbe.domain.Packaging;

import java.util.Set;

public interface PackagingRepository extends IRepository<Packaging, String> {
    Set<Packaging> getAll();
}