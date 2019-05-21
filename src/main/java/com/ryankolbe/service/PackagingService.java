package com.ryankolbe.service;

import com.ryankolbe.domain.Packaging;

import java.util.Set;

public interface PackagingService extends IService<Packaging, String> {
    Set<Packaging> getAll();
}