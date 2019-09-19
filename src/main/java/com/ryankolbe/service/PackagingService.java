package com.ryankolbe.service;

import com.ryankolbe.domain.Packaging;

import java.util.List;

public interface PackagingService extends IService<Packaging, String> {
    List<Packaging> getAll();
}