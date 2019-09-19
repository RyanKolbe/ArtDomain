package com.ryankolbe.service;

import com.ryankolbe.domain.Locality;

import java.util.List;

public interface LocalityService extends IService<Locality, String> {
    List<Locality> getAll();
}