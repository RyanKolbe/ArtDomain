package com.ryankolbe.service;

import com.ryankolbe.domain.Locality;

import java.util.Set;

public interface LocalityService extends IService<Locality, String> {
    Set<Locality> getAll();
}